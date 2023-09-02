import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

import scala.util.Random
import java.lang.Float.{floatToIntBits, intBitsToFloat}
import chisel3.util.experimental.loadMemoryFromFileInline
import java.io._

class PE extends MultiIOModule {
  val A_in = IO(Flipped(DecoupledIO(UInt(32.W))))
  val C_in = IO(Flipped(DecoupledIO(UInt(32.W))))
  val A_out = IO(DecoupledIO(UInt(32.W)))
  val C_out = IO(DecoupledIO(UInt(32.W)))

  val valid_in = A_in.valid & C_in.valid
  val valid_out = Wire(Bool())
  val ready_out = A_out.ready & C_out.ready

  private val r = new Random(System.currentTimeMillis)
  private val list = for (t <- 0 until 7) yield floatToIntBits(r.nextFloat() * 100)
  val B_reg = for (t <- 0 until 7) yield RegInit(list(t).U(32.W))

  val ce = ready_out
  when(ce) {
    for (t <- 1 until 7) {
      B_reg(t - 1) := B_reg(t)
    }
    B_reg(6) := B_reg(0)
  }
  val B = B_reg(0)

  val mul = Module(new MulFBase(3, 8, 24))
  mul.ce := ce

  val add = Module(new AddSubFBase(4, 8, 24, true))
  add.ce := ce

  val A_buf = Module(new DelayBuffer(7, 33))
  A_buf.valid_in := (A_in.bits << 1) | valid_in
  A_buf.ready_in := ce

  mul.operand0 := A_in.bits
  mul.operand1 := B

  val C_buf = Module(new DelayBuffer(3, 32))
  C_buf.valid_in := C_in.bits
  C_buf.ready_in := ce
  add.operand0 := C_buf.valid_out
  add.operand1 := mul.result

  A_out.bits := A_buf.valid_out >> 1
  C_out.bits := add.result

  valid_out := A_buf.valid_out & 1.U
  A_out.valid := valid_out
  C_out.valid := valid_out
  A_in.ready := ready_out
  C_in.ready := ready_out
}

