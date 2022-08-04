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

  class aggregate_wrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var1 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new aggregate)

    val finish = IO(Input(Bool()))
    main.finish := finish
    val test_addr0 = IO(Input(UInt(6.W)))
    main.mem_0_addr := test_addr0
    val test_data0 = IO(Output(UInt(64.W)))
    test_data0 := main.mem_0_data
    /*    val test_addr1 = IO(Input(UInt(6.W)))
        main.mem_1_addr := test_addr1
        val test_data1 = IO(Output(UInt(64.W)))
        test_data1 := main.mem_1_data
        val test_addr2 = IO(Input(UInt(6.W)))
        main.mem_2_addr := test_addr2
        val test_data2 = IO(Output(UInt(64.W)))
        test_data2 := main.mem_2_data
        val test_addr3 = IO(Input(UInt(6.W)))
        main.mem_3_addr := test_addr3
        val test_data3 = IO(Output(UInt(64.W)))
        test_data3 := main.mem_3_data*/

    connection(var0, main.var0)
    connection_inverse(var1, main.var1)
  }

  val s = ChiselStage.emitFirrtl(new aggregate_wrapper)

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
        //        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_9", "ReadMem_5").ref("mem"),
        CircuitTarget("aggregate_wrapper").module("aggregate_wrapper").instOf("main", "aggregate").instOf("mem_9", "DynMem").instOf("mem", "insideMemory").ref("mem"),
        input0
      ),
      MemoryArrayInitAnnotation(
        //        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_8", "ReadMem_4").ref("mem"),
        CircuitTarget("aggregate_wrapper").module("aggregate_wrapper").instOf("main", "aggregate").instOf("mem_8", "DynMem_4").instOf("mem", "insideMemory").ref("mem"),
        input1
      ),
      MemoryArrayInitAnnotation(
        //        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_7", "ReadMem_3").ref("mem"),
        CircuitTarget("aggregate_wrapper").module("aggregate_wrapper").instOf("main", "aggregate").instOf("mem_7", "DynMem_3").instOf("mem", "insideMemory").ref("mem"),
        input2
      ),
      MemoryArrayInitAnnotation(
        //        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_6", "ReadMem_2").ref("mem"),
        CircuitTarget("aggregate_wrapper").module("aggregate_wrapper").instOf("main", "aggregate").instOf("mem_6", "DynMem_2").instOf("mem", "insideMemory").ref("mem"),
        input3
      ),
      MemoryArrayInitAnnotation(
        //        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_5", "ReadMem_1").ref("mem"),
        CircuitTarget("aggregate_wrapper").module("aggregate_wrapper").instOf("main", "aggregate").instOf("mem_5", "DynMem_1").instOf("mem", "insideMemory").ref("mem"),
        input4
      ),
      MemoryArrayInitAnnotation(
        //        CircuitTarget("aggregate").module("aggregate").instOf("mem_global_4", "ReadMem").ref("mem"),
        CircuitTarget("aggregate_wrapper").module("aggregate_wrapper").instOf("main", "aggregate").instOf("mem_4", "DynMem").instOf("mem", "insideMemory").ref("mem"),
        input5
      )
    )
  )

  tester.poke("var0_valid", 1)
  tester.step()
  tester.poke("var0_valid", 0)
  var clock = 0
  val threshold = 2000
  while (clock < threshold) {
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

  class aeloss_pull_wrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var1 = IO(DecoupledIO(UInt(64.W)))
    val var2 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new aeloss_pull)

    val finish = IO(Input(Bool()))
    main.finish := finish
    val test_addr = IO(Input(UInt(10.W)))
    main.mem_2_addr := test_addr
    val test_data = IO(Output(UInt(64.W)))
    test_data := main.mem_2_data

    connection(var0, main.var0)
    connection_inverse(var1, main.var1)
    connection_inverse(var2, main.var2)
  }

  val s = ChiselStage.emitFirrtl(new aeloss_pull_wrapper)

  val input0 = Source.fromFile("data_set/aeloss_pull/in_0.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input1 = Source.fromFile("data_set/aeloss_pull/in_1.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input2 = Source.fromFile("data_set/aeloss_pull/in_2.txt").getLines.toSeq.map(str => BigInt(str, 16))

  val tester = TreadleTester(
    Seq(
      FirrtlSourceAnnotation(s),
      treadle.WriteVcdAnnotation,
      TargetDirAnnotation("test_run_dir/aeloss_pull_wrapper"),
      OutputFileAnnotation("aeloss_pull"),
      MemoryArrayInitAnnotation(
        CircuitTarget("aeloss_pull_wrapper").module("aeloss_pull_wrapper").instOf("main", "aeloss_pull").instOf("mem_0", "DynMem").instOf("mem", "insideMemory").ref("mem"),
        input0
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("aeloss_pull_wrapper").module("aeloss_pull_wrapper").instOf("main", "aeloss_pull").instOf("mem_1", "DynMem_1").instOf("mem", "insideMemory_1").ref("mem"),
        input1
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("aeloss_pull_wrapper").module("aeloss_pull_wrapper").instOf("main", "aeloss_pull").instOf("mem_3", "DynMem_3").instOf("mem", "insideMemory_3").ref("mem"),
        input2
      )
    )
  )

  tester.poke("var0_valid", 1)
  tester.step()
  tester.poke("var0_valid", 0)

  var clock = 1
  val threshold = 20000
  while (clock < threshold) {
    tester.step()
    clock += 1
  }
  if (clock >= threshold)
    println("Time Out!")
  println(s"clock $clock")
  val printer = new PrintWriter(new File("data_set/aeloss_pull/out.txt"))
  for (i <- 0 to 1023) {
    val x = tester.peekMemory("main.mem_2.mem.mem", i).toLong
    val res = longBitsToDouble(x)
    printer.write(s"$res\n")
  }
  printer.close()

  tester.finish
}

object TestPullHybridTreadle extends FlatSpec with Matchers with App {

  class pull_hybrid_wrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var1 = IO(DecoupledIO(UInt(64.W)))
    val var2 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new pull_hybrid)

    val finish = IO(Input(Bool()))
    main.finish := finish
    val test_addr = IO(Input(UInt(10.W)))
    main.mem_0_addr := test_addr
    val test_data = IO(Output(UInt(64.W)))
    test_data := main.mem_0_data

    connection(var0, main.var122)
    connection_inverse(var1, main.var123)
    connection_inverse(var2, main.var124)
  }

  val s = ChiselStage.emitFirrtl(new pull_hybrid_wrapper)

  //  println(s)
  val input0 = Source.fromFile("data_set/aeloss_pull/in_0.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input1 = Source.fromFile("data_set/aeloss_pull/in_1.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input2 = Source.fromFile("data_set/aeloss_pull/in_2.txt").getLines.toSeq.map(str => BigInt(str, 16))

  val tester = TreadleTester(
    Seq(
      FirrtlSourceAnnotation(s),
      treadle.WriteVcdAnnotation,
      TargetDirAnnotation("test_run_dir/pull_hybrid"),
      OutputFileAnnotation("pull_hybrid"),
      MemoryArrayInitAnnotation(
        CircuitTarget("pull_hybrid_wrapper").module("pull_hybrid_wrapper").instOf("main", "pull_hybrid").instOf("mem_1", "DynMeM_1").instOf("mem", "insideMemory_1").ref("mem"),
        input2
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("pull_hybrid_wrapper").module("pull_hybrid_wrapper").instOf("main", "pull_hybrid").instOf("mem_global_0", "ReadMem").ref("mem"),
        input0
      ),
      MemoryArrayInitAnnotation(
        CircuitTarget("pull_hybrid_wrapper").module("pull_hybrid_wrapper").instOf("main", "pull_hybrid").instOf("mem_global_1", "ReadMem").ref("mem"),
        input1
      )
    )
  )

  tester.poke("var0_valid", 1)
  tester.step()
  tester.poke("var0_valid", 0)

  var clock = 1
  val threshold = 10000
  while (clock < threshold) {
    tester.step()
    clock += 1
  }
  if (clock >= threshold)
    println("Time Out!")
  println(s"clock $clock")
  val printer = new PrintWriter(new File("data_set/aeloss_pull/out_hybrid.txt"))
  for (i <- 0 to 1023) {
    val x = tester.peekMemory("main.mem_0.mem.mem", i).toLong
    val res = longBitsToDouble(x)
    printer.write(s"$res\n")
  }
  printer.close()

  tester.finish
}

object TestAelossPushTreadle extends FlatSpec with Matchers with App {
  class aeloss_push_wrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var1 = IO(DecoupledIO(UInt(64.W)))
    val var2 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new aeloss_push)

    val finish = IO(Input(Bool()))
    main.finish := finish

    connection(var0, main.var99)
    connection_inverse(var1, main.var100)
    connection_inverse(var2, main.var101)
  }

  val s = ChiselStage.emitFirrtl(new aeloss_push_wrapper)

  println(s)
  val input0 = Source.fromFile("data_set/aeloss_pull/in_0.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input1 = Source.fromFile("data_set/aeloss_pull/in_1.txt").getLines.toSeq.map(str => BigInt(str, 16))
  val input2 = Source.fromFile("data_set/aeloss_pull/in_2.txt").getLines.toSeq.map(str => BigInt(str, 16))

  val tester = TreadleTester(
    Seq(
      FirrtlSourceAnnotation(s),
      //      treadle.WriteVcdAnnotation,
      TargetDirAnnotation("test_run_dir/aeloss_push_wrapper"),
      OutputFileAnnotation("aeloss_push"),
      MemoryArrayInitAnnotation(
        CircuitTarget("aeloss_push_wrapper").module("aeloss_push_wrapper").instOf("main", "aeloss_pull").instOf("mem_1", "DynMeM_1").instOf("mem", "insideMemory_1").ref("mem"),
        input2
      )
    )
  )

  tester.poke("var0_valid", 1)
  tester.step()
  tester.poke("var0_valid", 0)

  var clock = 1
  val threshold = 1000000
  while (clock < threshold && tester.peek("var1_valid") != 1) {
    tester.step()
    clock += 1
  }
  if (clock >= threshold)
    println("Time Out!")
  println(s"clock $clock")

  tester.finish
}
