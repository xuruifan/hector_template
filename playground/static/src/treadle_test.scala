import chisel3._
import chisel3.util._
import chisel3.stage.ChiselStage

import firrtl.options.{TargetDirAnnotation}
import treadle.{TreadleTester, WriteVcdAnnotation}
import firrtl.stage.{OutputFileAnnotation}

import firrtl.annotations._
import hls._
import org.scalatest.{FlatSpec, Matchers}
import firrtl.stage.FirrtlSourceAnnotation
import scala.io.Source
import java.io._
import java.lang.Double.{longBitsToDouble}
import java.nio.ByteBuffer

object TestAggregateTreadle extends FlatSpec with Matchers with App {

  val s = ChiselStage.emitFirrtl(new aggregate)

  val input0 = Source.fromFile("data_set/aggregate/in_0.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input1 = Source.fromFile("data_set/aggregate/in_1.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input2 = Source.fromFile("data_set/aggregate/in_2.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input3 = Source.fromFile("data_set/aggregate/in_3.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input4 = Source.fromFile("data_set/aggregate/in_4.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input5 = Source.fromFile("data_set/aggregate/in_5.txt").getLines.toSeq.map(str => BigInt(str, 16))

  val tester = TreadleTester(
    Seq(
      FirrtlSourceAnnotation(s),
      treadle.WriteVcdAnnotation,
      TargetDirAnnotation("test_run_dir/aggregate"),
      OutputFileAnnotation("aggregate"),
      MemoryArrayInitAnnotation(
        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_9", "ReadMem_5").ref("mem"),
        input0
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_8", "ReadMem_4").ref("mem"),
        input1
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_7", "ReadMem_3").ref("mem"),
        input2
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_6", "ReadMem_2").ref("mem"),
        input3
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_5", "ReadMem_1").ref("mem"),
        input4
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_4", "ReadMem").ref("mem"),
        input5
      )
    )
  )

  tester.poke("go", 1)
  var clock     = 0
  val threshold = 200000
  while (tester.peek("done") != 1 && clock < threshold) {
    tester.step()
    clock += 1
  }
  if (clock >= threshold)
    println("Time Out!")
  println("Cycles :", clock)
  // println(s"clock $clock")
  // val printer = new PrintWriter(new File("data_set/aggregate/out.txt"))
  // for (i <- 0 to 1023) {
  //   val x   = tester.peekMemory("mem_global_2_.mem", i).toLong
  //   val res = longBitsToDouble(x)
  //   printer.write("%.6f\n".format(res))
  // }
  // printer.close()

  tester.finish
}

object TestAelossPullTreadle extends FlatSpec with Matchers with App {

  val s = ChiselStage.emitFirrtl(new aeloss_pull)

  val input0 = Source.fromFile("data_set/aeloss_pull/in_0.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input1 = Source.fromFile("data_set/aeloss_pull/in_1.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input2 = Source.fromFile("data_set/aeloss_pull/in_2.txt").getLines.toSeq.map(str => BigInt(str, 16))

  val tester = TreadleTester(
    Seq(
      FirrtlSourceAnnotation(s),
      treadle.WriteVcdAnnotation,
      TargetDirAnnotation("test_run_dir/aeloss_pull"),
      OutputFileAnnotation("aeloss_pull"),
      MemoryArrayInitAnnotation(
        CircuitTarget("aeloss_pull").module("aeloss_pull").instOf("mem_global_0", "ReadMem").ref("mem"),
        input0
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("aeloss_pull").module("aeloss_pull").instOf("mem_global_1", "ReadMem_1").ref("mem"),
        input1
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("aeloss_pull").module("aeloss_pull").instOf("mem_global_3", "ReadMem_3").ref("mem"),
        input2
      )
    )
  )

  tester.poke("go", 1)
  var clock     = 0
  val threshold = 200000000
  while (tester.peek("done") != 1 && clock < threshold) {
    tester.step()
    clock += 1
  }
  if (clock >= threshold)
    println("Time Out!")
  println(s"clock $clock")
  val printer = new PrintWriter(new File("data_set/aeloss_pull/out.txt"))
  for (i <- 0 to 1023) {
    val x   = tester.peekMemory("mem_global_2_.mem", i).toLong
    val res = longBitsToDouble(x)
    printer.write("%.6f\n".format(res))
  }
  printer.close()

  tester.finish
}

object TestGemmNcubedTreadle extends FlatSpec with Matchers with App {

  val s      = ChiselStage.emitFirrtl(new gemm)
  val input0 = Source.fromFile("data_set/gemm_ncubed/in_0.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input1 = Source.fromFile("data_set/gemm_ncubed/in_1.txt").getLines.toSeq.map(str => BigInt(str, 16))

  println(input0(0), input1(0))
  println(input0.size, input1.size)
  val tester = TreadleTester(
    Seq(
      FirrtlSourceAnnotation(s),
      MemoryArrayInitAnnotation(
        CircuitTarget("gemm").module("gemm").instOf("mem_global_0", "ReadMem").ref("mem"),
        input0
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("gemm").module("gemm").instOf("mem_global_1", "ReadMem_1").ref("mem"),
        input1
      )
    )
  )

  tester.poke("go", 1)
  var clock     = 0
  val threshold = 200000000
  while (tester.peek("done") != 1 && clock < threshold) {
    tester.step()
    clock += 1
  }
  if (clock >= threshold)
    println("Time Out!")
  println(s"clock $clock")
  val printer = new PrintWriter(new File("data_set/gemm_ncubed/out.txt"))
  for (i <- 0 to 4095) {
    val x   = tester.peekMemory("mem_global_2_.mem", i).toLong
    val res = longBitsToDouble(x)
    printer.write(s"$res\n")
  }
  printer.close()
}

object TestStencil3dTreadle extends FlatSpec with Matchers with App {
  def getMemoryReference(i: Int): ReferenceTarget = {
    return CircuitTarget("stencil3d").module("stencil3d").instOf(s"mem_global_$i", "ReadMem").ref("mem")
  }
  val s      = ChiselStage.emitFirrtl(new stencil3d)
  val input0 = Source.fromFile("data_set/stencil_stencil3d/in_0.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input1 = Source.fromFile("data_set/stencil_stencil3d/in_1.txt").getLines.toSeq.map(str => BigInt(str, 16))

  println(input0(0), input1(0))
  println(input0.size, input1.size)
  val tester = TreadleTester(
    Seq(
      FirrtlSourceAnnotation(s),
      MemoryArrayInitAnnotation(
        CircuitTarget("stencil3d").module("stencil3d").instOf("mem_global_0", "ReadMem").ref("mem"),
        input0
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("stencil3d").module("stencil3d").instOf("mem_global_1", "ReadMem_1").ref("mem"),
        input1
      )
    )
  )

  // val tester = TreadleTester(Seq(FirrtlSourceAnnotation(s)))

  tester.poke("go", 1)
  var clock    = 0
  val treshold = 1000000
  while (tester.peek("done") != 1 && clock < treshold) {
    tester.step()
    clock += 1
  }
  println(s"clock $clock")
  val printer = new PrintWriter(new File("data_set/stencil_stencil3d/out.txt"))
  for (i <- 0 to 16383) {
    val x = tester.peekMemory("mem_global_2_.mem", i).toInt
    printer.write(s"$x\n")
  }
  printer.close()
}

object TestStencil2dTreadle extends FlatSpec with Matchers with App {

  val s = ChiselStage.emitFirrtl(new stencil)
  val input0 = Source
    .fromFile("data_set/stencil_stencil2d/in_0.txt")
    .getLines
    .toSeq
    .map(str => BigInt(Integer.parseUnsignedInt(str, 16).toInt))
  val input1 = Source
    .fromFile("data_set/stencil_stencil2d/in_1.txt")
    .getLines
    .toSeq
    .map(str => BigInt(Integer.parseUnsignedInt(str, 16).toInt))

  println(input0(0), input1(0))
  println(input0.size, input1.size)
  val tester = TreadleTester(
    Seq(
      FirrtlSourceAnnotation(s),
      MemoryArrayInitAnnotation(
        CircuitTarget("stencil").module("stencil").instOf("mem_global_0", "ReadMem").ref("mem"),
        input0
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("stencil").module("stencil").instOf("mem_global_2", "ReadMem_1").ref("mem"),
        input1
      )
    )
  )

  // val tester = TreadleTester(Seq(FirrtlSourceAnnotation(s)))

  tester.poke("go", 1)
  var clock    = 0
  val treshold = 1000000
  while (tester.peek("done") != 1 && clock < treshold) {
    tester.step()
    clock += 1
  }
  println(s"clock $clock")
  val printer = new PrintWriter(new File("data_set/stencil_stencil2d/out.txt"))
  for (i <- 0 to 8191) {
    val x = tester.peekMemory("mem_global_1_.mem", i)
    printer.write(s"$x\n")
  }
  printer.close()
}

class MemWrapper extends MultiIOModule {
  val mem_global_0 = Module(new ReadWriteMem(1024, 32))
  val test_addr    = IO(Input(UInt(10.W)))
  val test_data    = IO(Output(UInt(32.W)))

  mem_global_0.readIn(0).bits   := DontCare
  mem_global_0.readIn(0).valid  := false.B
  mem_global_0.writeIn(0).bits  := DontCare
  mem_global_0.writeIn(0).valid := false.B
  mem_global_0.w_dataIn(0)      := DontCare
  mem_global_0.test_addr        := test_addr
  test_data                     := mem_global_0.test_data
  mem_global_0.finished         := false.B
}

object TreadleUsageSpec extends FlatSpec with Matchers with App {
  val s = ChiselStage.emitFirrtl(new MemWrapper)
  val name =
    CircuitTarget("MemWrapper").module("MemWrapper").instOf("mem_global_0", "ReadWriteMem").ref("mem").serialize
  println(name)
  val tester = TreadleTester(
    Seq(
      FirrtlSourceAnnotation(s),
      MemoryArrayInitAnnotation(
        CircuitTarget("MemWrapper").module("MemWrapper").instOf("mem_global_0", "ReadWriteMem").ref("mem"),
        Seq.tabulate(1024) { i => i }
      )
    )
  )

  for (i <- 0 to 1023) {
//    val data = tester.peekMemory("mem.mem", i)
//    println(data)

    tester.expectMemory("mem_global_0.mem", i, i)
  }
  tester.report()
}

object GCDCalculator {
  def computeGcd(a: Int, b: Int): (Int, Int) = {
    var x     = a
    var y     = b
    var depth = 1
    while (y > 0) {
      if (x > y) {
        x -= y
      } else {
        y -= x
      }
      depth += 1
    }
    (x, depth)
  }
}

class GCD extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(16.W))
    val b = Input(UInt(16.W))
    val e = Input(Bool())
    val z = Output(UInt(16.W))
    val v = Output(Bool())
  })
  val x = Reg(UInt())
  val y = Reg(UInt())
  when(x > y) { x := x - y }
    .elsewhen(x <= y) { y := y - x }
  when(io.e) { x := io.a; y := io.b }
  io.z := x
  io.v := y === 0.U
}
