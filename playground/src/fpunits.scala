package hls

import chisel3._
import chisel3.util._
// import chisel3.experimental._

import scala.util.Random
import scala.collection.mutable.TreeMap

import hardfloat._

class MulFBase(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  // Exposed interface
  val width    = (expWidth + sigWidth).W
  val operand0 = IO(Input(UInt(width)))
  val operand1 = IO(Input(UInt(width)))
  val ce       = IO(Input(Bool()))

  val result = IO(Output(UInt(width)))

  val new_clock = (clock.asUInt()(0) & ce).asClock()

  withClock(new_clock) {

    val operand0_reg = RegNext(operand0)
    val operand1_reg = RegNext(operand1)

    // Connect to core module

    val operand0_rec = recFNFromFN(expWidth, sigWidth, operand0_reg)
    val operand1_rec = recFNFromFN(expWidth, sigWidth, operand1_reg)

    val multiplier = Module(new MulRecFN(expWidth, sigWidth))

    multiplier.io.roundingMode   := consts.round_near_even
    multiplier.io.detectTininess := consts.tininess_afterRounding

    multiplier.io.a := operand0_rec
    multiplier.io.b := operand1_rec

    val output = fNFromRecFN(expWidth, sigWidth, multiplier.io.out)

    if (latency == 1) {
      result := output
    } else {
      val shiftRegs = Reg(Vec(latency - 1, UInt(width)))
      shiftRegs(0) := output
      for (i <- 0 until latency - 2) {
        shiftRegs(i + 1) := shiftRegs(i)
      }

      result := shiftRegs(latency - 2)
    }
  }
}

class AddSubFBase(latency: Int, expWidth: Int, sigWidth: Int, mode: Boolean) extends MultiIOModule {
  // Exposed interface
  val width    = (expWidth + sigWidth).W
  val operand0 = IO(Input(UInt(width)))
  val operand1 = IO(Input(UInt(width)))
  val ce       = IO(Input(Bool()))
  val result   = IO(Output(UInt(width)))

  val new_clock = (clock.asUInt()(0) & ce).asClock()
  withClock(new_clock) {
    val operand0_reg = RegNext(operand0)
    val operand1_reg = RegNext(operand1)

    // Connect to core module

    val operand0_rec = recFNFromFN(expWidth, sigWidth, operand0_reg)
    val operand1_rec = recFNFromFN(expWidth, sigWidth, operand1_reg)

    val adder = Module(new AddRecFN(expWidth, sigWidth))

    if (mode == true) {
      adder.io.subOp := false.B
    } else {
      adder.io.subOp := true.B
    }

    adder.io.roundingMode   := consts.round_near_even
    adder.io.detectTininess := consts.tininess_afterRounding

    adder.io.a := operand0_rec
    adder.io.b := operand1_rec

    val output = fNFromRecFN(expWidth, sigWidth, adder.io.out)

    if (latency == 1) {
      result := output
    } else {
      val shiftRegs = Reg(Vec(latency - 1, UInt(width)))
      shiftRegs(0) := output
      for (i <- 0 until latency - 2) {
        shiftRegs(i + 1) := shiftRegs(i)
      }

      result := shiftRegs(latency - 2)
    }
  }
}

class CmpFBase(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  // Exposed interface
  val width = (expWidth + sigWidth).W

  val operand0 = IO(Input(UInt(width)))
  val operand1 = IO(Input(UInt(width)))
  val ce       = IO(Input(Bool()))
  val opcode   = IO(Input(UInt(5.W)))

  val result = IO(Output(Bool()))

  val new_clock = (clock.asUInt()(0) & ce).asClock()

  withClock(new_clock) {
    val operand0_reg = RegNext(operand0)
    val operand1_reg = RegNext(operand1)

    // Connect to core module

    val operand0_rec = recFNFromFN(expWidth, sigWidth, operand0_reg)
    val operand1_rec = recFNFromFN(expWidth, sigWidth, operand1_reg)

    val comparator = Module(new CompareRecFN(expWidth, sigWidth))

    comparator.io.a         := operand0_rec
    comparator.io.b         := operand1_rec
    comparator.io.signaling := false.B

    val output = Wire(Bool())
    when(opcode === "b00001".U) {
      // EQ
      output := comparator.io.eq
    }.elsewhen(opcode === "b00010".U) {
      // GT
      output := comparator.io.gt
    }.elsewhen(opcode === "b00011".U) {
      // GE
      output := comparator.io.gt || comparator.io.eq
    }.elsewhen(opcode === "b00100".U) {
      // LT
      output := comparator.io.lt
    }.elsewhen(opcode === "b00101".U) {
      // LE
      output := comparator.io.lt || comparator.io.eq
    }.elsewhen(opcode === "b00110".U) {
      // NE
      output := !comparator.io.eq
    }.otherwise {
      output := true.B
    }

    if (latency == 1) {
      result := output
    } else {
      val shiftRegs = Reg(Vec(latency - 1, Bool()))
      shiftRegs(0) := output
      for (i <- 0 until latency - 2) {
        shiftRegs(i + 1) := shiftRegs(i)
      }

      result := shiftRegs(latency - 2)
    }
  }
}

class IntToFloatBase(latency: Int, intWidth: Int, expWidth: Int, sigWidth: Int, signed: Boolean) extends MultiIOModule {
  val fWidth = expWidth + sigWidth

  val operand = IO(Input(UInt(intWidth.W)))
  val result  = IO(Output(UInt(fWidth.W)))
  val ce      = IO(Input(Bool()))

  val compUnit = Module(new INToRecFN(intWidth, expWidth, sigWidth))

  //  compUnit.io.signIn         := signed.B
  compUnit.io.signedIn := signed.B

  compUnit.io.in             := operand
  compUnit.io.roundingMode   := consts.round_near_even
  compUnit.io.detectTininess := consts.tininess_afterRounding

  val output = fNFromRecFN(expWidth, sigWidth, compUnit.io.out)

  result := ShiftRegister(output, latency, ce)
}

class FloatToIntBase(latency: Int, intWidth: Int, expWidth: Int, sigWidth: Int, signed: Boolean) extends MultiIOModule {
  val fWidth = expWidth + sigWidth

  val operand = IO(Input(UInt(fWidth.W)))
  val result  = IO(Output(UInt(intWidth.W)))
  val ce      = IO(Input(Bool()))

  val compUnit = Module(new RecFNToIN(expWidth, sigWidth, intWidth))

  //  compUnit.io.signIn         := signed.B
  compUnit.io.signedOut := signed.B

  compUnit.io.in           := recFNFromFN(expWidth, sigWidth, operand)
  compUnit.io.roundingMode := consts.round_near_even

  //val output = fNFromRecFN(expWidth, sigWidth, compUnit.io.out)
  result := ShiftRegister(compUnit.io.out, latency, ce)
}

/// result = operand0 / operand1
class DivFBase(latency: Int, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val fWidth = expWidth + sigWidth

  val operand0 = IO(Input(UInt(fWidth.W)))
  val operand1 = IO(Input(UInt(fWidth.W)))
  val ce       = IO(Input(Bool()))
  val result   = IO(Output(UInt(fWidth.W)))

  val x        = operand0 * operand1
  val newClock = (clock.asBool() & ce).asClock()
  result := ShiftRegister(x, latency, ce)
}

/// usage: result := NegF(8, 24, operand)
object NegF {
  def apply(expWidth: Int, sigWidth: Int, in: Bits) {
    val fWidth = expWidth + sigWidth
    Cat(in(fWidth - 1), in(fWidth - 2, 0))
  }
}

//===----------------------------------------------------------------------===//
/// Wrapper for Vivado IP
//===----------------------------------------------------------------------===//

class VivadoUnaryIP(expWidth: Int, sigWidth: Int) extends BlackBox {
  val width = expWidth + sigWidth
  val io = IO(new Bundle {
    val aclk                 = Input(Clock())
    val aclken               = Input(Bool())
    val s_axis_a_tdata       = Input(UInt(width.W))
    val s_axis_a_tvalid      = Input(Bool())
    val m_axis_result_tvalid = Output(Bool())
    val m_axis_result_tdata  = Output(UInt(width.W))
  })
}

class VivadoBinaryIP(expWidth: Int, sigWidth: Int) extends BlackBox {
  val width = expWidth + sigWidth
  val io = IO(new Bundle {
    val aclk                 = Input(Clock())
    val aclken               = Input(Bool())
    val s_axis_a_tdata       = Input(UInt(width.W))
    val s_axis_a_tvalid      = Input(Bool())
    val s_axis_b_tdata       = Input(UInt(width.W))
    val s_axis_b_tvalid      = Input(Bool())
    val m_axis_result_tvalid = Output(Bool())
    val m_axis_result_tdata  = Output(UInt(width.W))
  })
}

class VivadoFCMPIP(expWidth: Int, sigWidth: Int) extends BlackBox {
  val width = expWidth + sigWidth
  val io = IO(new Bundle {
    val aclk                    = Input(Clock())
    val aclken                  = Input(Bool())
    val s_axis_a_tdata          = Input(UInt(width.W))
    val s_axis_a_tvalid         = Input(Bool())
    val s_axis_b_tdata          = Input(UInt(width.W))
    val s_axis_b_tvalid         = Input(Bool())
    val s_axis_operation_tdata  = Input(UInt(8.W))
    val s_axis_operation_tvalid = Input(Bool())
    val m_axis_result_tvalid    = Output(Bool())
    val m_axis_result_tdata     = Output(Bool())
  })
}

class UnaryWrapper[T <: VivadoUnaryIP](genT: => T, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width   = expWidth + sigWidth
  val operand = IO(Input(UInt(width.W)))
  val ce      = IO(Input(Bool()))
  val result  = IO(Output(UInt(width.W)))
  val valid   = IO(Output(Bool()))

  val IPCore = Module(genT)

  val operandReg = Reg(UInt(width.W))
  val ceReg      = RegNext(ce)

  when(ceReg) {
    operandReg := operand
  }

  IPCore.io.aclk            := clock
  IPCore.io.aclken          := ceReg
  IPCore.io.s_axis_a_tdata  := operandReg
  IPCore.io.s_axis_a_tvalid := true.B
  result                    := IPCore.io.m_axis_result_tdata
  valid                     := IPCore.io.m_axis_result_tvalid
}

class ComponentWrapper[T <: VivadoBinaryIP](genT: => T, expWidth: Int, sigWidth: Int) extends MultiIOModule {
  val width    = expWidth + sigWidth
  val operand0 = IO(Input(UInt(width.W)))
  val operand1 = IO(Input(UInt(width.W)))
  val ce       = IO(Input(Bool()))
  val result   = IO(Output(UInt(width.W)))
  val valid    = IO(Output(Bool()))

  val IPCore = Module(genT)

  val operand0Reg = Reg(UInt(width.W))
  val operand1Reg = Reg(UInt(width.W))
  val ceReg       = RegNext(ce)

  when(ceReg) {
    operand0Reg := operand0
    operand1Reg := operand1
  }

  IPCore.io.aclk            := clock
  IPCore.io.aclken          := ceReg
  IPCore.io.s_axis_a_tdata  := operand0Reg
  IPCore.io.s_axis_a_tvalid := true.B
  IPCore.io.s_axis_b_tdata  := operand1Reg
  IPCore.io.s_axis_b_tvalid := true.B
  result                    := IPCore.io.m_axis_result_tdata
  valid                     := IPCore.io.m_axis_result_tvalid
}

class CMPWrapper[T <: VivadoFCMPIP](genT: => T, expWidth: Int, sigWidth: Int) extends MultiIOModule() {
  val width    = expWidth + sigWidth
  val operand0 = IO(Input(UInt(width.W)))
  val operand1 = IO(Input(UInt(width.W)))
  val opcode   = IO(Input(UInt(8.W)))
  val ce       = IO(Input(Bool()))
  val result   = IO(Output(Bool()))
  val valid    = IO(Output(Bool()))

  val IPCore = Module(genT)

  val operand0Reg = Reg(UInt(width.W))
  val operand1Reg = Reg(UInt(width.W))
  val opcodeReg   = Reg(UInt(8.W))
  val ceReg       = RegNext(ce)

  when(ceReg) {
    operand0Reg := operand0
    operand1Reg := operand1
    opcodeReg   := opcode
  }

  IPCore.io.aclk                    := clock
  IPCore.io.aclken                  := ceReg
  IPCore.io.s_axis_a_tdata          := operand0Reg
  IPCore.io.s_axis_a_tvalid         := true.B
  IPCore.io.s_axis_b_tdata          := operand1Reg
  IPCore.io.s_axis_b_tvalid         := true.B
  IPCore.io.s_axis_operation_tdata  := opcodeReg
  IPCore.io.s_axis_operation_tvalid := true.B

  result := IPCore.io.m_axis_result_tdata
  valid  := IPCore.io.m_axis_result_tvalid
}

class VivadoMulFIP(latency: Int, expWidth: Int, sigWidth: Int) extends VivadoBinaryIP(expWidth, sigWidth) {
  override def desiredName: String = s"mulf_${latency}_${expWidth}_${sigWidth}_ip"
  val precision = if (expWidth + sigWidth == 32) "Single" else "Double"
  val config = TreeMap(
    "a_precision_type" -> precision,
    "result_precision_type" -> precision,
    "ip_name" -> "floating_point",
    "operation_type" -> "Multiply",
    "has_aclken" -> "true",
    "c_latency" -> s"${latency}",
    "c_rate" -> "1",
    "c_a_exponent_width" -> s"$expWidth",
    "c_a_fraction_width" -> s"$sigWidth",
    "c_result_exponent_width" -> s"$expWidth",
    "c_result_fraction_width" -> s"$sigWidth"
  )
  IPLogger.addIP(desiredName, config)
}

class MulFIP(latency: Int, expWidth: Int, sigWidth: Int)
    extends ComponentWrapper(new VivadoMulFIP(latency, expWidth, sigWidth), expWidth, sigWidth)

class VivadoAddSubFIP(latency: Int, expWidth: Int, sigWidth: Int, mode: Boolean)
    extends VivadoBinaryIP(expWidth, sigWidth) {
  override def desiredName: String = s"addsubf_${mode}_${latency}_${expWidth}_${sigWidth}_ip"
    val precision = if (expWidth + sigWidth == 32) "Single" else "Double"
  val add_sub = if (mode) "Add" else "Sub"
  val config = TreeMap(
    "a_precision_type" -> precision,
    "result_precision_type" -> precision,
    "ip_name" -> "floating_point",
    "operation_type" -> "Add_Subtract",
    "add_sub_value" -> s"${add_sub}",
    "has_aclken" -> "true",
    "c_latency" -> s"${latency-1}",
    "c_rate" -> "1",
    "c_a_exponent_width" -> s"$expWidth",
    "c_a_fraction_width" -> s"$sigWidth",
    "c_result_exponent_width" -> s"$expWidth",
    "c_result_fraction_width" -> s"$sigWidth"
  )
  IPLogger.addIP(desiredName, config)
}

/// TODO put mode into argument
class AddSubFIP(latency: Int, expWidth: Int, sigWidth: Int, mode: Boolean)
    extends ComponentWrapper(new VivadoAddSubFIP(latency, expWidth, sigWidth, mode), expWidth, sigWidth)

class VivadoCmpFIP(latency: Int, expWidth: Int, sigWidth: Int) extends VivadoFCMPIP(expWidth, sigWidth) {
  override def desiredName: String = s"cmpf_${latency}_${expWidth}_${sigWidth}_ip"
    val precision = if (expWidth + sigWidth == 32) "Single" else "Double"
  val config = TreeMap(
    "a_precision_type" -> precision,
    "result_precision_type" -> precision,
    "ip_name" -> "floating_point",
    "operation_type" -> "Compare",
    "has_aclken" -> "true",
    "c_latency" -> s"${latency-1}",
    "c_rate" -> "1",
    "c_a_exponent_width" -> s"$expWidth",
    "c_a_fraction_width" -> s"$sigWidth",
    "c_result_exponent_width" -> s"$expWidth",
    "c_result_fraction_width" -> s"$sigWidth"
  )
  IPLogger.addIP(desiredName, config)
}

class CmpFIP(latency: Int, expWidth: Int, sigWidth: Int)
    extends CMPWrapper(new VivadoCmpFIP(latency, expWidth, sigWidth), expWidth, sigWidth)

class VivadoIntToFloatIP(latency: Int, expWidth: Int, sigWidth: Int) extends VivadoUnaryIP(expWidth, sigWidth) {
  override def desiredName: String = s"sitofp_${latency}_${expWidth}_${sigWidth}"
  val precision = if (expWidth + sigWidth == 32) "Single" else "Double"
  val config = TreeMap(
    "result_precision_type" -> precision,
    "ip_name" -> "floating_point",
    "operation_type" -> "Fixed_to_float",
    "has_aclken" -> "true",
    "c_latency" -> s"${latency-1}",
    "c_rate" -> "1",
    "c_a_exponent_width" -> s"$expWidth",
    "c_a_fraction_width" -> s"$sigWidth",
    "c_result_exponent_width" -> s"$expWidth",
    "c_result_fraction_width" -> s"$sigWidth"
  )
  IPLogger.addIP(desiredName, config)
}

class IntToFloatIP(latency: Int, expWidth: Int, sigWidth: Int)
    extends UnaryWrapper(new VivadoIntToFloatIP(latency, expWidth, sigWidth), expWidth, sigWidth)

class VivadoFloatToIntIP(latency: Int, expWidth: Int, sigWidth: Int) extends VivadoUnaryIP(expWidth, sigWidth) {
  override def desiredName: String = s"fptosi_${latency}_${expWidth}_${sigWidth}"
  val precision = if (expWidth + sigWidth == 32) "Single" else "Double"
  val config = TreeMap(
    "a_precision_type" -> precision,
    "ip_name" -> "floating_point",
    "operation_type" -> "Compare",
    "has_aclken" -> "true",
    "c_latency" -> s"${latency-1}",
    "c_rate" -> "1",
    "c_a_exponent_width" -> s"$expWidth",
    "c_a_fraction_width" -> s"$sigWidth",
    "c_result_exponent_width" -> s"$expWidth",
    "c_result_fraction_width" -> s"$sigWidth"
  )
  IPLogger.addIP(desiredName, config)
}

class FloatToIntIP(latency: Int, expWidth: Int, sigWidth: Int)
    extends UnaryWrapper(new VivadoFloatToIntIP(latency, expWidth, sigWidth), expWidth, sigWidth)

class VivadoDivFIP(latency: Int, expWidth: Int, sigWidth: Int) extends VivadoBinaryIP(expWidth, sigWidth) {
  override def desiredName: String = s"divf_${latency}_${expWidth}_${sigWidth}_ip"
  val precision = if (expWidth + sigWidth == 32) "Single" else "Double"
  val config = TreeMap(
    "a_precision_type" -> precision,
    "result_precision_type" -> precision,
    "ip_name" -> "floating_point",
    "operation_type" -> "Compare",
    "has_aclken" -> "true",
    "c_latency" -> s"${latency-1}",
    "c_rate" -> "1",
    "c_a_exponent_width" -> s"$expWidth",
    "c_a_fraction_width" -> s"$sigWidth",
    "c_result_exponent_width" -> s"$expWidth",
    "c_result_fraction_width" -> s"$sigWidth"
  )
  IPLogger.addIP(desiredName, config)
}

class DivFIP(latency: Int, expWidth: Int, sigWidth: Int)
    extends ComponentWrapper(new VivadoDivFIP(latency, expWidth, sigWidth), expWidth, sigWidth)
