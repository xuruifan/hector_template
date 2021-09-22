import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals._
import utest._
import testing._
import chisel3.experimental._
import hls._
import scala.util.Random
import chiseltest.internal.{VerilatorBackendAnnotation, WriteVcdAnnotation}


object Elaborate extends App {
  //  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new branch_prediction())))
  //  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new main())))
  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new main())))
  //(new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new ReadWriteMem(1024))))
}

/*
object TestPipelineFor extends ChiselUtestTester {
  val tests = Tests {
    test("pipeline_for") {
      testCircuit(
        new main,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        fork {
          dut.go.poke(true.B)
          dut.var10.poke(3.U)
          dut.var11.poke(7.U)
          dut.var12.poke(1.U)
          dut.var13.poke(0.U)
          dut.var14.poke(true.B)
          dut.clock.step()
        } fork {
          dut.clock.step(2)
          while (!dut.done.peek.litToBoolean) dut.clock.step()
          dut.clock.step(3)
          fork {
            dut.go.poke(true.B)
            dut.var10.poke(0.U)
            dut.var11.poke(20.U)
            dut.var12.poke(1.U)
            dut.var13.poke(0.U)
            dut.var14.poke(true.B)
            dut.clock.step()
          } fork {
            dut.clock.step(3)
            while (!dut.done.peek.litToBoolean) dut.clock.step()
          } join()
          dut.clock.step(5)
          fork {
            dut.var10.poke(30.U)
            dut.go.poke(true.B)
            dut.var11.poke(28.U)
            dut.var12.poke(1.U)
            dut.var13.poke(0.U)
            dut.var14.poke(true.B)
            dut.clock.step()
          } fork {
            dut.clock.step(3)
            //            while (!dut.done.peek.litToBoolean) dut.clock.step()
          } join()
        } join()
      }
    }
  }
}

object TestPipelineFunction extends ChiselUtestTester {
  val tests = Tests {
    test("pipeline_function") {
      testCircuit(
        new pipelined_func,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        fork {
          for (i <- 0 until 10) {
            if (Random.nextBoolean()) {
              dut.new_input.poke(true.B)
            } else {
              dut.new_input.poke(false.B)
            }
            dut.var0.poke(Random.nextInt(1000).U)
            dut.var1.poke(true.B)
            dut.clock.step(2)
          }
        } fork {
          for (i <- 0 until 20) {
            if (Random.nextBoolean()) {
              dut.start.poke(true.B)
            } else {
              dut.start.poke(false.B)
            }
            dut.clock.step()
          }
        } join()
      }
    }
  }
}*/

class dynamicWrapper extends MultiIOModule {
  def connection[T <: Data](outer: DecoupledIO[T], inner: DecoupledIO[T]): Unit = {
    val reg_bits = Reg(outer.bits.cloneType)
    var reg_valid = Reg(Bool())
    reg_bits := outer.bits
    inner.bits := reg_bits

    reg_valid := outer.valid
    inner.valid := reg_valid
    outer.ready := inner.ready
  }

  val var0 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val var1 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val var2 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val var3 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val var4 = IO(DecoupledIO(UInt(32.W)))

  val main = Module(new main())
  connection(var0, main.var0)
  connection(var1, main.var1)
  connection(var2, main.var2)
  connection(var3, main.var3)
  var4 <> main.var4

}

object TestDynamic extends ChiselUtestTester {
  val tests = Tests {
    test("dynamic") {
      testCircuit(
        new dynamicWrapper,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        fork {
          dut.var0.bits.poke(3.U)
          dut.var0.valid.poke(true.B)
          dut.var1.bits.poke(20.U)
          dut.var1.valid.poke(true.B)
          dut.var2.bits.poke(1.U)
          dut.var2.valid.poke(true.B)
          dut.var3.bits.poke(0.U)
          dut.var3.valid.poke(true.B)
          dut.clock.step()
        } fork {
//          for (i <- 0 until 100) {
//            dut.clock.step()
//          }
          dut.clock.step(100)
        } join()
      }
    }
  }
}


/*
class buffer extends MultiIOModule {
  val in = IO(Flipped(DecoupledIO(UInt(32.W))))
  val out = IO(DecoupledIO(UInt(32.W)))

  val EB = Module(new ElasticBuffer())
  EB.dataIn <> in
  EB.dataOut <> out
}


class wrapper extends MultiIOModule {
  val in = IO(Flipped(DecoupledIO(UInt(32.W))))
  val out = IO(DecoupledIO(UInt(32.W)))

  //  val reg_bits = Reg(UInt(32.W))
  //  val reg_valid = Reg(Bool())
  //  reg_bits := in.bits
  //  reg_valid := in.valid
  //  val reg_in = Reg(ValidIO(UInt(32.W)))
  //  reg_in <> in
  def connection[T <: Data](outer: DecoupledIO[T], inner: DecoupledIO[T]): Unit = {
    val reg_bits = Reg(outer.bits.cloneType)
    var reg_valid = Reg(Bool())
    reg_bits := outer.bits
    inner.bits := reg_bits

    reg_valid := outer.valid
    inner.valid := reg_valid
    outer.ready := inner.ready
  }

  val module = Module(new buffer())
  //  module.in.bits := reg_bits
  //  module.in.valid := reg_valid
  //  in.ready := module.in.ready
  connection(in, module.in)
  out <> module.out
}

object TestBuffer extends ChiselUtestTester {
  val tests = Tests {
    test("buffer") {
      testCircuit(
        new wrapper,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.in.initSource()
        dut.in.setSourceClock(dut.clock)
        dut.out.initSink()
        dut.out.setSinkClock(dut.clock)
        fork {
          dut.in.enqueueSeq(Seq(42.U, 43.U, 44.U))
        } fork {
          dut.out.expectDequeueSeq(Seq(42.U, 43.U, 44.U))
        } join()
      }
    }
  }
}
*/
