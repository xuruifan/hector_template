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
  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new systolic_array())))
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
        dut.clock.setTimeout(400000)
        fork {
          dut.var0.valid.poke(true.B)
          dut.clock.step()
        } fork {
          dut.clock.step(400000)
        } join()
      }
    }
  }
}

/*object Testif extends ChiselUtestTester {
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
}*/

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

/*object TestAelossPush extends ChiselUtestTester {
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
}*/

object TestAelossPull extends ChiselUtestTester {
  class PullWrapper extends MultiIOModule with dynamicDelay {
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

  val tests = Tests {
    test("aeloss_pull") {
      testCircuit(
        new PullWrapper,
        //Seq(WriteVcdAnnotation, VerilatorBackendAnnotation),
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation),
        //        Seq(VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(10000)
        fork {
          dut.var0.valid.poke(true.B)
          dut.clock.step()
        } fork {
          dut.clock.step(10000)
        } fork {
          for (i <- 0 until 10000) {
            dut.var1.ready.poke(true.B)
            dut.var2.ready.poke(true.B)
            dut.clock.step()
          }
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
        dut.clock.setTimeout(1000000)
        fork {
          dut.var0.valid.poke(true.B)
          dut.clock.step()
        } fork {
          dut.clock.step(1000000)
        } join()
      }
    }
  }
}

object TestPushHybrid extends ChiselUtestTester {
  class PushWrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var1 = IO(DecoupledIO(UInt(64.W)))
    val var2 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new push_hybrid)

    val finish = IO(Input(Bool()))
    main.finish := finish

    connection(var0, main.var99)
    connection_inverse(var1, main.var100)
    connection_inverse(var2, main.var101)
  }

  val tests = Tests {
    test("push_hybrid") {
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

import chisel3.util.experimental.loadMemoryFromFileInline
import java.io._

object TestSystolic extends ChiselUtestTester {
  val n = 8

  val tests = Tests {
    test("systolic_array") {
      testCircuit(
        new Wrapper,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation),
      ) { dut =>
        fork {
          val r = new Random(1)
          val A = for (t <- 0 until 7) yield for (i <- 0 until n) yield for (j <- 0 until n) yield r.nextFloat() * 100
          val A_inter = for (i <- 0 until 7 * n) yield for (j <- 0 until n) yield A(i % 7)(i / 7)(j)
          for (i <- 0 until n) {
            dut.C_out(i).ready.poke(true.B)
          }

          val C_output = for (t <- 0 until 7 * (3 * n - 1)) yield {
            for (i <- 0 until n) {
              if (t >= 7 * i && t < 7 * (i + n)) {
                dut.A(i).valid.poke(true.B)
                dut.A(i).bits.poke(floatToIntBits(A_inter(t - 7 * i)(i)).U)
              } else {
                dut.A(i).valid.poke(false.B)
              }

              if (t >= 7 * i && t < 7 * (i + n)) {
                dut.C_in(i).valid.poke(true.B)
                dut.C_in(i).bits.poke(floatToIntBits(0.0f).U)
              } else {
                dut.C_in(i).valid.poke(false.B)
              }
            }
            dut.clock.step()
            for (j <- 0 until n) yield {
              intBitsToFloat(dut.C_out(j).bits.peek.litValue.toInt)
            }
          }

          for (t <- 0 until 7) {
            val C = for (i <- 0 until n) yield {
              for (j <- 0 until n) yield {
                C_output(7 * (i + j + n) + t)(j)
              }
            }
            println(C)
          }
        } fork {
        } join()
      }
    }
  }
}
