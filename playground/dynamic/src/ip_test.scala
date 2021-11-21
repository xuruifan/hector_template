import hls._
import chisel3._
import chisel3.util._
import chisel3.stage.ChiselStage

import org.scalatest.{FlatSpec, Matchers}

class TestMulFIP extends MultiIOModule {
  val operand0 = IO(Input(UInt(32.W)))
  val operand1 = IO(Input(UInt(32.W)))
  val result0 = IO(Output(UInt(32.W)))
  val result1 = IO(Output(UInt(32.W)))

  val mulf_ip1 = Module(new MulFIP(6, 8, 24))
  val mulf_ip2 = Module(new MulFIP(4, 8, 24))

  mulf_ip1.operand0 := operand0
  mulf_ip1.operand1 := operand1
  mulf_ip2.operand0 := operand1
  mulf_ip2.operand1 := operand0
  mulf_ip1.ce := true.B
  mulf_ip2.ce := true.B
  result0 := mulf_ip1.result
  result1 := mulf_ip2.result
}

/**
  * 1. Define a new Object extends App and call TclGen inside the object
  *    TclGen(moduleName, destinationPath, TopModuleName)
  * 2. mill playground.test.runMain "name of new Object"
  *    It will Generate two files: destinationPath/kernel.v, 
  *    destinationPath/run.tcl
  * 3. vivado -mode tcl -source run.tcl to get two report file
  */
object ipGenerator extends App {
  TclGen(new aeloss_push, "hls_src", "aeloss_push")
}
