package hls

import chisel3._
import chisel3.util._

import scala.collection.mutable.TreeMap

class BinaryUnit(width: Int = 32, func: (UInt, UInt) => UInt, shift: Int = 0) extends MultiIOModule {
  val operand0 = IO(Input(UInt(width.W)))
  val operand1 = IO(Input(UInt(width.W)))
  val result = IO(Output(UInt(width.W)))
  //  result := func(operand0, operand1)
  private val buffer = ShiftRegister(func(operand0, operand1), shift)
  result := buffer
}

class And(width: Int = 32) extends BinaryUnit(width, _ & _) {}

class Or(width: Int = 32) extends BinaryUnit(width, _ | _) {}

class Xor(width: Int = 32) extends BinaryUnit(width, _ ^ _) {}

class AddI(width: Int = 32) extends BinaryUnit(width, _ + _) {}

class SubI(width: Int = 32) extends BinaryUnit(width, _ - _) {}

// class MulI(width: Int = 32) extends BinaryUnit(width, _ * _, 4) {}
class MulI(width: Int = 32, latency: Int = 2) extends MultiIOModule {
  val operand0 = IO(Input(UInt(width.W)))
  val operand1 = IO(Input(UInt(width.W)))
  val ce = IO(Input(Bool()))
  val result = IO(Output(UInt(width.W)))

  result := ShiftRegister(operand0 * operand1, latency, ce)
}

class VivadoMulIIP(width: Int = 32, latency: Int) extends BlackBox {
  val io = IO(new Bundle {
    val CLK = Input(Clock())
    val A = Input(UInt(width.W))
    val B = Input(UInt(width.W))
    val CE = Input(Bool())
    val P = Output(UInt(width.W))
  })

  override def desiredName: String = s"muli_${width}_${latency}_ip"

  val config = TreeMap(
    "version" -> "12.0",
    "ip_name" -> "mult_gen",
    "portatype" -> "Signed",
    "portawidth" -> s"${width}",
    "portbtype" -> "Signed",
    "portbwidth" -> s"${width}",
    "multiplier_construction" -> "Use_Mults",
    "outputwidthhigh" -> s"${width - 1}",
    "outputwidthlow" -> "0",
    "pipestages" -> s"${latency - 1}",
    "clockenable" -> "true"
  )
  IPLogger.addIP(desiredName, config)
}

class MulIIP(width: Int = 32, latency: Int = 2) extends MultiIOModule {
  val operand0 = IO(Input(UInt(width.W)))
  val operand1 = IO(Input(UInt(width.W)))
  val ce = IO(Input(Bool()))
  val result = IO(Output(UInt(width.W)))

  val ipcore = Module(new VivadoMulIIP(width, latency))
  val operand0Reg = Reg(UInt(width.W))
  val operand1Reg = Reg(UInt(width.W))
  val ceReg = RegNext(ce)

  when(ce) {
    operand0Reg := operand0
    operand1Reg := operand1
  }

  ipcore.io.CLK := clock
  ipcore.io.A := operand0
  ipcore.io.B := operand1
  result := ipcore.io.P
  ipcore.io.CE := ceReg
}

class DivI(width: Int = 32) extends BinaryUnit(width, _ / _) {}

class TruncIDynamic(inwidth: Int = 32, outwidth: Int = 32) extends MultiIOModule {
  val operand = IO(Flipped(DecoupledIO(UInt(inwidth.W))))
  val result = IO(DecoupledIO(UInt(outwidth.W)))
  result.bits := operand.bits
  result.valid := operand.valid
  operand.ready := result.ready
}

class BinaryUnitDynamic(width: Int = 32, func: (UInt, UInt) => UInt) extends MultiIOModule {
  val operand0 = IO(Flipped(DecoupledIO(UInt(width.W))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width.W))))
  val result = IO(DecoupledIO(UInt(width.W)))
  result.bits := func(operand0.bits, operand1.bits)
  result.valid := operand0.valid & operand1.valid
  operand0.ready := operand1.valid & result.ready
  operand1.ready := operand0.valid & result.ready
}

class AndDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ & _) {}

class OrDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ | _) {}

class XorDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ ^ _) {}

class AddIDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ + _) {}

class SubIDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ - _) {}

//class MulIDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ * _) {}
class MulIDynamic(width: Int = 32, latency: Int = 4) extends MultiIOModule {
  val operand0 = IO(Flipped(DecoupledIO(UInt(width.W))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width.W))))

  val result = IO(DecoupledIO(UInt(width.W)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val muli = Module(new MulI(width, latency))
  muli.ce := oehb.dataIn.ready
  muli.operand0 := operand0.bits
  muli.operand1 := operand1.bits
  result.bits := muli.result
}

class DivIDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ / _) {}

class CmpI(width: Int = 32, func: (UInt, UInt) => Bool) extends MultiIOModule {
  val operand0 = IO(Input(UInt(width.W)))
  val operand1 = IO(Input(UInt(width.W)))
  val result = IO(Output(Bool()))
  result := func(operand0, operand1)
}

class GreaterthanI(width: Int = 32) extends CmpI(width, _ > _) {}

class GreaterEqualthanI(width: Int = 32) extends CmpI(width, _ >= _) {}

class LessthanI(width: Int = 32) extends CmpI(width, _ < _) {}

class NotEqualI(width: Int = 32) extends CmpI(width, _ =/= _) {}

class LessEqualthanI(width: Int = 32) extends CmpI(width, _ <= _) {}

class EqualI(width: Int = 32) extends CmpI(width, _ === _) {}

class CmpIDynamic(width: Int = 32, func: (UInt, UInt) => Bool) extends MultiIOModule {
  val operand0 = IO(Flipped(DecoupledIO(UInt(width.W))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width.W))))
  val result = IO(DecoupledIO(Bool()))
  result.bits := func(operand0.bits, operand1.bits)
  result.valid := operand0.valid & operand1.valid
  operand0.ready := operand1.valid & result.ready
  operand1.ready := operand0.valid & result.ready
}

class GreaterthanIDynamic(width: Int = 32) extends CmpIDynamic(width, _ > _) {}

class GreaterEqualthanIDynamic(width: Int = 32) extends CmpIDynamic(width, _ >= _) {}

class LessthanIDynamic(width: Int = 32) extends CmpIDynamic(width, _ < _) {}

class LessEqualthanIDynamic(width: Int = 32) extends CmpIDynamic(width, _ <= _) {}

class NotEqualIDynamic(width: Int = 32) extends CmpIDynamic(width, _ =/= _) {}

class EqualIDynamic(width: Int = 32) extends CmpIDynamic(width, _ === _) {}

class MulFDynamic(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand0 = IO(Flipped(DecoupledIO(UInt(width))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val mulf = Module(new MulFBase(latency, expWidth, sigWidth))
  mulf.ce := oehb.dataIn.ready
  mulf.operand0 := operand0.bits
  mulf.operand1 := operand1.bits
  result.bits := mulf.result
}

class AddFDynamic(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand0 = IO(Flipped(DecoupledIO(UInt(width))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val addf = Module(new AddSubFBase(latency, expWidth, sigWidth, true))
  addf.ce := oehb.dataIn.ready
  addf.operand0 := operand0.bits
  addf.operand1 := operand1.bits
  result.bits := addf.result
}

class SubFDynamic(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand0 = IO(Flipped(DecoupledIO(UInt(width))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val subf = Module(new AddSubFBase(latency, expWidth, sigWidth, false))
  subf.ce := oehb.dataIn.ready
  subf.operand0 := operand0.bits
  subf.operand1 := operand1.bits
  result.bits := subf.result
}

class CmpFDynamic(latency: Int, expWidth: Int, sigWidth: Int)(opcode: UInt) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand0 = IO(Flipped(DecoupledIO(UInt(width))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val subf = Module(new CmpFBase(latency, expWidth, sigWidth))
  subf.opcode := opcode
  subf.ce := oehb.dataIn.ready
  subf.operand0 := operand0.bits
  subf.operand1 := operand1.bits
  result.bits := subf.result
}

class IntToFloatDynamic(latency: Int, intWidth: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  operand.ready := oehb.dataIn.ready

  buff.valid_in := operand.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val subf = Module(new IntToFloatBase(latency, intWidth, expWidth, sigWidth, true))
  subf.ce := oehb.dataIn.ready
  subf.operand := operand.bits
  result.bits := subf.result
}

class FloatToIntDynamic(latency: Int, intWidth: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  operand.ready := oehb.dataIn.ready

  buff.valid_in := operand.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val subf = Module(new FloatToIntBase(latency, intWidth, expWidth, sigWidth, true))
  subf.ce := oehb.dataIn.ready
  subf.operand := operand.bits
  result.bits := subf.result
}

class DivFDynamic(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand0 = IO(Flipped(DecoupledIO(UInt(width))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val divf = Module(new DivFBase(latency, expWidth, sigWidth))
  divf.ce := oehb.dataIn.ready
  divf.operand0 := operand0.bits
  divf.operand1 := operand1.bits
  result.bits := divf.result
}

class Constant(size: Int = 32) extends MultiIOModule {
  val control = IO(Flipped(DecoupledIO(UInt(0.W))))
  val dataIn = IO(Flipped(DecoupledIO(UInt(size.W))))
  val dataOut = IO(DecoupledIO(UInt(size.W)))

  control <> dataOut
  dataOut.bits := dataIn.bits
  dataIn.ready := true.B
}

class NegFDynamic(expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val dataIn = IO(Flipped(DecoupledIO(UInt(width))))
  val dataOut = IO(DecoupledIO(UInt(width)))

  dataIn.ready := dataOut.ready
  dataOut.valid := dataIn.valid
  dataOut.bits := NegF(expWidth, sigWidth, dataIn.bits)

}

class MulFDynamic_test(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand0 = IO(Flipped(DecoupledIO(UInt(width))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val mulf = Module(new MulFIP(latency, expWidth, sigWidth))
  mulf.ce := oehb.dataIn.ready
  mulf.operand0 := operand0.bits
  mulf.operand1 := operand1.bits
  result.bits := mulf.result
}

class AddFDynamic_test(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand0 = IO(Flipped(DecoupledIO(UInt(width))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val addf = Module(new AddSubFIP(latency, expWidth, sigWidth, true))
  addf.ce := oehb.dataIn.ready
  addf.operand0 := operand0.bits
  addf.operand1 := operand1.bits
  result.bits := addf.result
}

class SubFDynamic_test(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand0 = IO(Flipped(DecoupledIO(UInt(width))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val subf = Module(new AddSubFIP(latency, expWidth, sigWidth, false))
  subf.ce := oehb.dataIn.ready
  subf.operand0 := operand0.bits
  subf.operand1 := operand1.bits
  result.bits := subf.result
}

class CmpFDynamic_test(latency: Int, expWidth: Int, sigWidth: Int)(opcode: UInt) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand0 = IO(Flipped(DecoupledIO(UInt(width))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val subf = Module(new CmpFIP(latency, expWidth, sigWidth))
  subf.opcode := opcode
  subf.ce := oehb.dataIn.ready
  subf.operand0 := operand0.bits
  subf.operand1 := operand1.bits
  result.bits := subf.result
}

class IntToFloatDynamic_test(latency: Int, intWidth: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  operand.ready := oehb.dataIn.ready

  buff.valid_in := operand.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val subf = Module(new IntToFloatIP(latency, expWidth, sigWidth))
  subf.ce := oehb.dataIn.ready
  subf.operand := operand.bits
  result.bits := subf.result
}

class FloatToIntDynamic_test(latency: Int, intWidth: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  operand.ready := oehb.dataIn.ready

  buff.valid_in := operand.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val subf = Module(new FloatToIntIP(latency, expWidth, sigWidth))
  subf.ce := oehb.dataIn.ready
  subf.operand := operand.bits
  result.bits := subf.result
}

class DivFDynamic_test(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width = (expWidth + sigWidth).W
  val operand0 = IO(Flipped(DecoupledIO(UInt(width))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width))))

  val result = IO(DecoupledIO(UInt(width)))

  private val join = Module(new Join())
  private val buff = Module(new DelayBuffer(latency - 1, 1))
  private val oehb = Module(new OEHB(0))

  join.pValid(0) := operand0.valid
  join.pValid(1) := operand1.valid
  operand0.ready := join.ready(0)
  operand1.ready := join.ready(1)
  join.nReady := oehb.dataIn.ready

  buff.valid_in := join.valid
  buff.ready_in := oehb.dataIn.ready

  oehb.dataIn.bits := DontCare
  oehb.dataOut.ready := result.ready
  oehb.dataIn.valid := buff.valid_out
  result.valid := oehb.dataOut.valid

  val divf = Module(new DivFIP(latency, expWidth, sigWidth))
  divf.ce := oehb.dataIn.ready
  divf.operand0 := operand0.bits
  divf.operand1 := operand1.bits
  result.bits := divf.result
}

