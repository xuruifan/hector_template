package hls

import chisel3._
import chisel3.util._
import chisel3.experimental._

class VivadoBinaryIP(width: Int) extends BlackBox {
    val io = IO(new Bundle{
        val aclk = Input(Clock())
        val aclken = Input(Bool())
        val s_axis_a_tdata = Input(UInt(width.W))
        val s_axis_a_tvalid = Input(UInt(width.W))
        val s_axis_b_tdata = Input(UInt(width.W))
        val s_axis_b_tvalid = Input(UInt(width.W))
        val m_axis_result_tvalid = Output(Bool())
        val m_axis_result_tdata = Output(UInt(width.W))
    }) 
}

class ComponentWrapper[T <: VivadoBinaryIP](genT: => T, width: Int) extends MultiIOModule {
    val operand0 = IO(Input(UInt(width.W)))
    val operand1 = IO(Input(UInt(width.W)))
    val enable = IO(Input(Bool()))
    val result = IO(Output(UInt(width.W)))
    val valid = IO(Output(Bool()))

    val IPCore = Module(genT)

    val operand0Reg = Reg(UInt(width.W))
    val operand1Reg = Reg(UInt(width.W))
    val enableReg = RegNext(enable)

    when (enable) {
        operand0Reg := operand0
        operand1Reg := operand1
    }

    IPCore.io.aclk := clock
    IPCore.io.aclken := enableReg
    IPCore.io.s_axis_a_tdata := operand0Reg
    IPCore.io.s_axis_a_tvalid := true.B
    IPCore.io.s_axis_b_tdata := operand1Reg
    IPCore.io.s_axis_b_tvalid := true.B
    result := IPCore.io.m_axis_result_tdata
    valid := IPCore.io.m_axis_result_tvalid
}

class FP64MulIP extends VivadoBinaryIP(64)
class FP32MulIP extends VivadoBinaryIP(32)
class FP64AddIP extends VivadoBinaryIP(64)
class FP32AddIP extends VivadoBinaryIP(32)

class FMul64 extends ComponentWrapper(new FP64MulIP, 64)
class FMul32 extends ComponentWrapper(new FP32MulIP, 32)
class FAdd64 extends ComponentWrapper(new FP64AddIP, 64)
class FAdd32 extends ComponentWrapper(new FP32AddIP, 32)