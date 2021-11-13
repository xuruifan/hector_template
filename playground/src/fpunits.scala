package hls

import chisel3._
import chisel3.util._
// import chisel3.experimental._

import scala.util.Random

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

  compUnit.io.in             := recFNFromFN(expWidth, sigWidth, operand)
  compUnit.io.roundingMode   := consts.round_near_even

  //val output = fNFromRecFN(expWidth, sigWidth, compUnit.io.out)
  result := ShiftRegister(compUnit.io.out, latency, ce)
}

//===----------------------------------------------------------------------===//
/// Wrapper for Vivado IP
//===----------------------------------------------------------------------===//

class VivadoBinaryIP(width: Int) extends BlackBox {
  val io = IO(new Bundle {
    val aclk                 = Input(Clock())
    val aclken               = Input(Bool())
    val s_axis_a_tdata       = Input(UInt(width.W))
    val s_axis_a_tvalid      = Input(UInt(width.W))
    val s_axis_b_tdata       = Input(UInt(width.W))
    val s_axis_b_tvalid      = Input(UInt(width.W))
    val m_axis_result_tvalid = Output(Bool())
    val m_axis_result_tdata  = Output(UInt(width.W))
  })
}

class VivadoFCMPIP(width: Int) extends BlackBox {
  val io = IO(new Bundle {
    val aclken                  = Input(Bool())
    val s_axis_a_tdata          = Input(UInt(width.W))
    val s_axis_a_tvalid         = Input(UInt(width.W))
    val s_axis_b_tdata          = Input(UInt(width.W))
    val s_axis_b_tvalid         = Input(UInt(width.W))
    val s_axis_operation_tdata  = Input(UInt(8.W))
    val s_axis_operation_tvalid = Input(Bool())
    val m_axis_result_tvalid    = Output(Bool())
    val m_axis_result_tdata     = Output(Bool())
  })
}

class ComponentWrapper[T <: VivadoBinaryIP](genT: => T, width: Int) extends MultiIOModule {
  val operand0 = IO(Input(UInt(width.W)))
  val operand1 = IO(Input(UInt(width.W)))
  val enable   = IO(Input(Bool()))
  val result   = IO(Output(UInt(width.W)))
  val valid    = IO(Output(Bool()))

  val IPCore = Module(genT)

  val operand0Reg = Reg(UInt(width.W))
  val operand1Reg = Reg(UInt(width.W))
  val enableReg   = RegNext(enable)

  when(enable) {
    operand0Reg := operand0
    operand1Reg := operand1
  }

  IPCore.io.aclk            := clock
  IPCore.io.aclken          := enableReg
  IPCore.io.s_axis_a_tdata  := operand0Reg
  IPCore.io.s_axis_a_tvalid := true.B
  IPCore.io.s_axis_b_tdata  := operand1Reg
  IPCore.io.s_axis_b_tvalid := true.B
  result                    := IPCore.io.m_axis_result_tdata
  valid                     := IPCore.io.m_axis_result_tvalid
}

class CMPWrapper[T <: VivadoFCMPIP](genT: => T, width: Int) extends MultiIOModule() {

  val operand0 = IO(Input(UInt(width.W)))
  val operand1 = IO(Input(UInt(width.W)))
  val opcode   = IO(Input(UInt(8.W)))
  val enable   = IO(Input(Bool()))
  val result   = IO(Output(Bool()))
  val valid    = IO(Output(Bool()))

  val IPCore = Module(genT)

  val operand0Reg = Reg(UInt(width.W))
  val operand1Reg = Reg(UInt(width.W))
  val opcodeReg   = Reg(UInt(8.W))
  val enableReg   = RegNext(enable)

  when(enable) {
    operand0Reg := operand0
    operand1Reg := operand1
    opcodeReg   := opcode
  }

  IPCore.io.aclken                  := enableReg
  IPCore.io.s_axis_a_tdata          := operand0Reg
  IPCore.io.s_axis_a_tvalid         := true.B
  IPCore.io.s_axis_b_tdata          := operand1Reg
  IPCore.io.s_axis_b_tvalid         := true.B
  IPCore.io.s_axis_operation_tdata  := opcodeReg
  IPCore.io.s_axis_operation_tvalid := true.B

  result := IPCore.io.m_axis_result_tdata
  valid  := IPCore.io.m_axis_result_tvalid
}

class FP64MulIP extends VivadoBinaryIP(64)
class FP64AddIP extends VivadoBinaryIP(64)
class FP64SubIP extends VivadoBinaryIP(64)
class FP64CMPIP extends VivadoFCMPIP(64)
class FP32MulIP extends VivadoBinaryIP(32)
class FP32AddIP extends VivadoBinaryIP(32)
class FP32SubIP extends VivadoBinaryIP(32)
class FP32CMPIP extends VivadoFCMPIP(32)

class FMul64IP extends ComponentWrapper(new FP64MulIP, 64)
class FAdd64IP extends ComponentWrapper(new FP64AddIP, 64)
class FSub64IP extends ComponentWrapper(new FP64SubIP, 64)
class FCMP64IP extends CMPWrapper(new FP64CMPIP, 64)

class FMul32IP extends ComponentWrapper(new FP32MulIP, 32)
class FAdd32IP extends ComponentWrapper(new FP32AddIP, 32)
class FSub32IP extends ComponentWrapper(new FP32SubIP, 32)
class FCMP32IP extends CMPWrapper(new FP32CMPIP, 32)
