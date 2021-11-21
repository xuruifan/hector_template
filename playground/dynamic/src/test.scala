import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals._
import utest._
import chisel3.experimental._
import hls._
import scala.util.Random
import chiseltest.internal.{VerilatorBackendAnnotation, WriteVcdAnnotation}

import org.scalatest.{FlatSpec, Matchers}
import scala.util.Random

import java.lang.Float.{floatToIntBits, intBitsToFloat}
import java.lang.Double.{doubleToLongBits, longBitsToDouble}

object Elaborate extends App {
  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new aeloss_pull())))
}

trait dynamicDelay {
  def connection[T <: Data](outer: DecoupledIO[T], inner: DecoupledIO[T]): Unit = {
    val reg_bits = Reg(outer.bits.cloneType)
    var reg_valid = Reg(Bool())
    reg_bits := outer.bits
    inner.bits := reg_bits

    reg_valid := outer.valid
    inner.valid := reg_valid
    outer.ready := inner.ready
  }

  def connection_inverse[T <: Data](outer: DecoupledIO[T], inner: DecoupledIO[T]): Unit = {
    var reg_ready = Reg(Bool())
    outer.bits := inner.bits

    reg_ready := outer.ready
    inner.ready := reg_ready
    outer.valid := inner.valid
  }
}

object TestSpmv extends ChiselUtestTester {
  class spmvWrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var1 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new spmv)

    val finish = IO(Input(Bool()))
    main.finish := finish
    val test_addr = IO(Input(UInt(9.W)))
    main.mem_4_addr := test_addr
    val test_data = IO(Output(UInt(64.W)))
    test_data := main.mem_4_data

    connection(var0, main.var0)
    connection_inverse(var1, main.var1)
  }

  val tests = Tests {
    test("spmv") {
      testCircuit(
        new spmvWrapper,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(60000)
        fork {
          dut.var0.valid.poke(true.B)
          dut.clock.step()
          } fork {
            dut.clock.step(60000)
          } join()
      }
    }
  }
}

object TestStencil2d extends ChiselUtestTester {
  class stencilWrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var1 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new stencil)

    val finish = IO(Input(Bool()))
    main.finish := finish
    val test_addr = IO(Input(UInt(9.W)))
    main.mem_1_addr := test_addr
    val test_data = IO(Output(UInt(64.W)))
    test_data := main.mem_1_data

    connection(var0, main.var0)
    connection_inverse(var1, main.var1)
  }

  val tests = Tests {
    test("stencil2d") {
      testCircuit(
        new stencilWrapper,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(2000000)
        fork {
          dut.var0.valid.poke(true.B)
          dut.clock.step()
          } fork {
            dut.clock.step(2000000)
          } join()
      }
    }
  }
}

object Testif extends ChiselUtestTester {
  class ifWrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(32.W))))
    val var1 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var2 = IO(DecoupledIO(UInt(32.W)))
    val var3 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new aeloss)

    val finish = IO(Input(Bool()))
    main.finish := finish
    val test_addr = IO(Input(UInt(9.W)))
    main.mem_2_addr := test_addr
    val test_data = IO(Output(UInt(64.W)))
    test_data := main.mem_2_data

    connection(var0, main.var0)
    connection(var1, main.var1)
    connection_inverse(var2, main.var2)
    connection_inverse(var3, main.var3)
  }

  val tests = Tests {
    test("if") {
      testCircuit(
        new ifWrapper,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(60000)
        fork {
          dut.var0.valid.poke(true.B)
          dut.var0.bits.poke(1.U)
          dut.var1.valid.poke(true.B)
          dut.clock.step()
          } fork {
            dut.clock.step(60000)
          } join()
      }
    }
  }
}

object TestGemm extends ChiselUtestTester {
  class GemmWrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var1 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new gemm)

    val finish = IO(Input(Bool()))
    main.finish := finish
    val test_addr = IO(Input(UInt(9.W)))
    main.mem_2_addr := test_addr
    val test_data = IO(Output(UInt(64.W)))
    test_data := main.mem_2_data

    connection(var0, main.var0)
    connection_inverse(var1, main.var1)
  }

  val tests = Tests {
    test("gemm") {
      testCircuit(
        new GemmWrapper,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(3000000)
        fork {
          dut.var0.valid.poke(true.B)
          dut.clock.step()
          } fork {
            dut.clock.step(3000000)
          } join()
      }
    }
  }
}

object TestAelossPush extends ChiselUtestTester {
  class PushWrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var1 = IO(DecoupledIO(UInt(64.W)))
    val var2 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new aeloss_push)

    val finish = IO(Input(Bool()))
    main.finish := finish

    connection(var0, main.var0)
    connection_inverse(var1, main.var1)
    connection_inverse(var2, main.var2)
  }

  val tests = Tests {
    test("aeloss_push") {
      testCircuit(
        new PushWrapper,
        //Seq(WriteVcdAnnotation, VerilatorBackendAnnotation),
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation),
        //        Seq(VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(2000000)
        fork {
          dut.var0.valid.poke(true.B)
          dut.clock.step()
          } fork {
            dut.clock.step(2000000)
          } join()
      }
    }
  }
}
