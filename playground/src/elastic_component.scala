package hls

import chisel3._
import chisel3.util._
import chisel3.experimental._

class Join extends MultiIOModule {
  val pValid = IO(Vec(2, Input(Bool())))
  val ready = IO(Vec(2, Output(Bool())))

  val valid = IO(Output(Bool()))
  val nReady = IO(Input(Bool()))

  valid := pValid(0) & pValid(1)

  ready(0) := nReady & pValid(1)
  ready(1) := nReady & pValid(0)
}

class TEHB(size: Int = 32) extends MultiIOModule {
  val dataIn = IO(Flipped(DecoupledIO(UInt(size.W))))
  val dataOut = IO(DecoupledIO(UInt(size.W)))

  private val full_reg = RegInit(Bool(), false.B)
  private val reg_en = Wire(Bool())
  private val mux_sel = Wire(Bool())
  private val data_reg = RegInit(UInt(size.W), 0.U)

  dataOut.valid := dataIn.valid | full_reg
  dataIn.ready := !full_reg
  reg_en := dataIn.ready & dataIn.valid & (!dataOut.ready)
  mux_sel := full_reg

  full_reg := dataOut.valid & (!dataOut.ready)

  when(reg_en) {
    data_reg := dataIn.bits
  }

  when(mux_sel) {
    dataOut.bits := data_reg
  }.otherwise {
    dataOut.bits := dataIn.bits
  }
  //  def apply(size : Int = 32)(in : DecoupledIO[UInt]) = {
  //    val tehb = Module(new TEHB(size))
  //    tehb.dataIn := in
  //    tehb.dataOut
  //  }
}

class OEHB(size: Int = 32) extends MultiIOModule {
  val dataIn = IO(Flipped(DecoupledIO(UInt(size.W))))
  val dataOut = IO(DecoupledIO(UInt(size.W)))

  private val full_reg = RegInit(Bool(), false.B)
  private val reg_en = Wire(Bool())
  private val data_reg = RegInit(UInt(size.W), 0.U)

  dataOut.valid := full_reg
  dataIn.ready := (!full_reg) | dataOut.ready
  reg_en := dataIn.ready & dataIn.valid

  full_reg := dataIn.valid | (!dataIn.ready)

  when(reg_en) {
    data_reg := dataIn.bits
  }

  dataOut.bits := data_reg
}

class ElasticBuffer(size: Int = 32) extends MultiIOModule {
  val dataIn = IO(Flipped(DecoupledIO(UInt(size.W))))
  val dataOut = IO(DecoupledIO(UInt(size.W)))

  private val tehb = Module(new TEHB(size))
  private val oehb = Module(new OEHB(size))

  //  tehb.dataOut.ready <> oehb.data
  tehb.dataIn <> dataIn
  tehb.dataOut <> oehb.dataIn
  dataOut <> oehb.dataOut
}

class Merge(size: Int = 32)(input: Int = 2) extends MultiIOModule {
  val dataIn = IO(Vec(input, Flipped(DecoupledIO(UInt(size.W)))))
  val dataOut = IO(DecoupledIO(UInt(size.W)))

  private val tehb = Module(new TEHB(size))
  tehb.dataOut <> dataOut

  for (i <- 0 until input) {
    dataIn(i).ready := tehb.dataIn.ready
  }
  private val tmp_data_out = Wire(UInt(size.W))
  private val tmp_valid = Wire(Bool())

  tmp_data_out := dataIn(0).bits
  tmp_valid := false.B

  for (i <- (0 to input - 1).reverse) {
    when(dataIn(i).valid) {
      tmp_data_out := dataIn(i).bits
      tmp_valid := true.B
    }
  }

  tehb.dataIn.bits := tmp_data_out
  tehb.dataIn.valid := tmp_valid
}

class Merge_no_tehb(size: Int = 32)(input: Int = 2) extends MultiIOModule {
  val dataIn = IO(Vec(input, Flipped(DecoupledIO(UInt(size.W)))))
  val dataOut = IO(DecoupledIO(UInt(size.W)))


  for (i <- 0 until input) {
    dataIn(i).ready := dataOut.ready
  }
  private val tmp_data_out = Wire(UInt(size.W))
  private val tmp_valid = Wire(Bool())

  tmp_data_out := dataIn(0).bits
  tmp_valid := false.B

  for (i <- (0 to input - 1).reverse) {
    when(dataIn(i).valid) {
      tmp_data_out := dataIn(i).bits
      tmp_valid := true.B
    }
  }

  dataOut.bits := tmp_data_out
  dataOut.valid := tmp_valid
}

class Branch(size: Int = 32) extends MultiIOModule {
  val dataIn = IO(Flipped(DecoupledIO(UInt(size.W))))
  val dataOut = IO(Vec(2, DecoupledIO(UInt(size.W))))
  val condition = IO(Flipped(DecoupledIO(Bool())))

  private val join = Module(new Join())

  join.pValid(0) := condition.valid
  join.pValid(1) := dataIn.valid
  //  join.nReady := (dataOut(1).ready & (!join.valid)) | (dataOut(0).ready & join.valid)
  join.nReady := (dataOut(1).ready & !condition.bits) | (dataOut(0).ready & condition.bits)

  dataOut(1).valid := (!condition.bits) & join.valid
  dataOut(0).valid := (condition.bits) & join.valid
  //  condition.ready := (dataOut(1).ready & !condition.bits) | (dataOut(0).ready & condition.bits)
  condition.ready := join.ready(0)
  dataIn.ready := join.ready(1)

  dataOut(0).bits := dataIn.bits
  dataOut(1).bits := dataIn.bits
}

class EagerFork_RegisterBlock extends MultiIOModule {
  val p_valid = IO(Input(Bool()))
  val n_stop = IO(Input(Bool()))
  val p_valid_and_fork_stop = IO(Input(Bool()))
  val valid = IO(Output(Bool()))
  val block_stop = IO(Output(Bool()))

  private val reg = RegInit(true.B)

  private val block_stop_internal = n_stop & reg
  block_stop := block_stop_internal
  reg := block_stop_internal | (!p_valid_and_fork_stop)
  valid := reg & p_valid
}

class Fork(size: Int = 32)(output: Int = 2) extends MultiIOModule {
  val dataIn = IO(Flipped(DecoupledIO(UInt(size.W))))
  val dataOut = IO(Vec(output, DecoupledIO(UInt(size.W))))

  //  val forkStop;
  //  val nStop;
  //  val blockStop;
  //  val pValidAndForkStop;

  private val regblock = for (i <- 0 until output) yield Module(new EagerFork_RegisterBlock()).suggestName(f"regblock_$i")
  private val blockStop = for (i <- 0 until output) yield regblock(i).block_stop
  private val anyBlockStop = blockStop.foldLeft(false.B)(_ || _)

  for (i <- 0 until output) {
    dataOut(i).bits := dataIn.bits
    regblock(i).p_valid := dataIn.valid
    regblock(i).n_stop := !dataOut(i).ready
    regblock(i).p_valid_and_fork_stop := dataIn.valid & anyBlockStop
    dataOut(i).valid := regblock(i).valid
  }
  dataIn.ready := !anyBlockStop
}

class Control_Merge(size: Int = 32) extends MultiIOModule {
  val dataIn = IO(Vec(2, Flipped(DecoupledIO(UInt(size.W)))))
  val condition = IO(DecoupledIO(Bool()))
  val dataOut = IO(DecoupledIO(UInt(size.W)))

  private val phi_c = Module(new Merge_no_tehb(size)())
  phi_c.dataIn(0).bits := dataIn(0).bits
  phi_c.dataIn(1).bits := dataIn(1).bits
  phi_c.dataIn(0).valid := dataIn(0).valid
  phi_c.dataIn(1).valid := dataIn(1).valid
  dataIn(0).ready := phi_c.dataIn(0).ready
  dataIn(1).ready := phi_c.dataIn(1).ready

  //Not sure
  private val tehb = Module(new TEHB(size))
  phi_c.dataOut.ready <> tehb.dataIn.ready
  tehb.dataIn.bits := !(dataIn(0).valid)
  tehb.dataIn.valid <> phi_c.dataOut.valid
  dataOut.bits := tehb.dataOut.bits

  private val fork_c = Module(new Fork(1)())
  tehb.dataOut.ready <> fork_c.dataIn.ready
  fork_c.dataIn.valid := tehb.dataOut.valid
  fork_c.dataIn.bits := 1.U

  condition.ready <> fork_c.dataOut(0).ready
  dataOut.ready <> fork_c.dataOut(1).ready

  condition.valid := fork_c.dataOut(0).valid
  dataOut.valid := fork_c.dataOut(1).valid
  condition.bits := tehb.dataOut.bits
}

class MuxDynamic(size: Int = 32)(input: Int = 2) extends MultiIOModule {
  val condition_size = log2Ceil(input)

  val dataIn = IO(Vec(input, Flipped(DecoupledIO(UInt(size.W)))))
  val dataOut = IO(DecoupledIO(UInt(size.W)))

  val condition = IO(Flipped(DecoupledIO(UInt(condition_size.W))))

  private val tmp_data = Wire(UInt(size.W))
  private val tmp_valid = Wire(Bool())
  tmp_data := dataIn(0).bits
  tmp_valid := false.B

  private val tehb = Module(new TEHB(size))
  tehb.dataIn.bits := tmp_data
  tehb.dataIn.valid := tmp_valid
  tehb.dataOut <> dataOut

  for (i <- (0 until input).reverse) {
    when(condition.bits === i.U && condition.valid && dataIn(i).valid) {
      tmp_data := dataIn(i).bits
      tmp_valid := true.B
    }
    when((condition.bits === i.U && condition.valid && dataIn(i).valid && tehb.dataIn.ready) || !dataIn(i).valid) {
      dataIn(i).ready := true.B
    }.otherwise {
      dataIn(i).ready := false.B
    }
  }

  when(condition.valid || (tmp_valid && tehb.dataIn.ready)) {
    condition.ready := true.B
  }.otherwise {
    condition.ready := false.B
  }
}

class Sink(size: Int = 32) extends MultiIOModule {
  val dataIn = IO(Flipped(DecoupledIO(UInt(size.W))))
  dataIn.ready := false.B
}

class Const(size: Int = 32) extends MultiIOModule {

}
