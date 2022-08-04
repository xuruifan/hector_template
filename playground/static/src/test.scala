import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals._
import utest._
import chisel3.experimental._
import hls._
import scala.util.Random
import chiseltest.internal.{VerilatorBackendAnnotation, WriteVcdAnnotation}

import firrtl.annotations._
import firrtl.stage.FirrtlSourceAnnotation

import org.scalatest.{FlatSpec, Matchers}
import scala.util.Random

import java.lang.Float.{floatToIntBits, intBitsToFloat}
import java.lang.Double.{doubleToLongBits, longBitsToDouble}

import treadle.TreadleTester
import java.io.FileReader

object Elaborate extends App {
  //  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new branch_prediction())))
  //  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new main())))
//  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new spmv())))
  //  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new ReadWriteMem(1024))))
}

trait dynamicDelay {
  def connection[T <: Data](outer: DecoupledIO[T], inner: DecoupledIO[T]): Unit = {
    val reg_bits  = Reg(outer.bits.cloneType)
    var reg_valid = Reg(Bool())
    reg_bits   := outer.bits
    inner.bits := reg_bits

    reg_valid   := outer.valid
    inner.valid := reg_valid
    outer.ready := inner.ready
  }

  def connection_inverse[T <: Data](outer: DecoupledIO[T], inner: DecoupledIO[T]): Unit = {
    var reg_ready = Reg(Bool())
    outer.bits := inner.bits

    reg_ready   := outer.ready
    inner.ready := reg_ready
    outer.valid := inner.valid
  }
}

object TestAggregate extends ChiselUtestTester {
  val tests = Tests {
    test("aggregate") {
      testCircuit(
        new aggregate,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation),
//        Seq(VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(2000000)
        fork {
          dut.go.poke(true.B)
          dut.clock.step();
        }.fork {
          var cycle_num = 0
          while (!dut.done.peek.litToBoolean) {
            dut.clock.step();
            cycle_num += 1
          }
        }.join()
      }
    }
  }
}

object TestAelossPush extends ChiselUtestTester {
  val tests = Tests {
    test("aeloss_push") {
      testCircuit(
        new aeloss_push,
//        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation),
        Seq(VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(2000000)
        fork {
          dut.go.poke(true.B)
          dut.clock.step();
        }.fork {
          var cycle_num = 0
          while (!dut.done.peek.litToBoolean) {
            dut.clock.step();
            cycle_num += 1
          }
          val result = dut.result.peek()
          val fpresult = longBitsToDouble(result.litValue().toLong)
          println("cycle: %d, push: %.6f\n".format(cycle_num, fpresult))
        }.join()
      }
    }
  }
}

object TestAelossPull extends ChiselUtestTester {
  val tests = Tests {
    test("aeloss_pull") {
      testCircuit(
        new aeloss_pull,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(1400000)
        fork {
          dut.go.poke(true.B)
          dut.clock.step();
        }.fork {
          var cycle_num = 0
          while (!dut.done.peek.litToBoolean) {
            dut.clock.step();
            cycle_num += 1
          }
          val result = dut.result.peek()
          val fpresult = longBitsToDouble(result.litValue().toLong)
          println("cycle: %d, push: %.6f\n".format(cycle_num, fpresult))
        }.join()
      }
    }
  }
}

object TestFFTStrided extends ChiselUtestTester {
  val tests = Tests {
    test("fftStrided") {
      testCircuit(
        new fft,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(1400000)
        fork {
          dut.go.poke(true.B)
          dut.clock.step();
        }.fork {
          while (!dut.done.peek.litToBoolean) {
            dut.clock.step();
          }
        }.join()
      }
    }
  }
}


object TestStencil3d extends ChiselUtestTester {
  val tests = Tests {
    test("stencil3d") {
      testCircuit(
        new stencil3d,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut: stencil3d =>
        dut.clock.setTimeout(1400000)
        fork {
          dut.go.poke(true.B)
          dut.clock.step();
        }.fork {
          while (!dut.done.peek.litToBoolean) {
            dut.clock.step();
          }
        }.join()
      }
    }
  }
}

object TestSpmvCSR extends ChiselUtestTester {
  val tests = Tests {
    test("SpmvCSR") {
      testCircuit(
        new spmv,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(1400000)
        fork {
          dut.go.poke(true.B)
          dut.clock.step();
        }.fork {
          while (!dut.done.peek.litToBoolean) {
            dut.clock.step();
          }
        }.join()
      }
    }
  }
}

object TestStencil2d extends ChiselUtestTester {
  val tests = Tests {
    test("stencil2d") {
      testCircuit(
        new stencil,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(1000000)
        fork {
          dut.go.poke(true.B)
          dut.clock.step();
        }.fork {
          while (!dut.done.peek.litToBoolean) {
            dut.clock.step();
          }
        }.join()
      }
    }
  }
}

object TestGemmNcubed extends ChiselUtestTester {
  val tests = Tests {
    test("GemmNcubed") {
      testCircuit(
        new gemm,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(300000)
        fork {
          dut.go.poke(true.B)
          dut.clock.step();
        }.fork {
          while (!dut.done.peek.litToBoolean) {
            dut.clock.step();
          }
        }.join()
      }
    }
  }
}

object TestSpmvEllpack extends ChiselUtestTester {
  val tests = Tests {
    test("spmvEllpack") {
      testCircuit(
        new ellpack,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(200000)
        fork {
          dut.go.poke(true.B)
          dut.clock.step();
        }.fork {
          while (!dut.done.peek.litToBoolean) {
            dut.clock.step();
          }
        }.join()
      }
    }
  }
}

// object TestSpmv extends ChiselUtestTester {
//   val tests = Tests {
//     test("spmv") {
//       testCircuit(
//         new spmv,
//         Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
//       ) { dut =>
//         dut.clock.setTimeout(60000)
//         dut.clock.step(1000)
//       }
//     }
//   }
// }

class dynamicFloat extends MultiIOModule with dynamicDelay {
  val operand0 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val result   = IO(DecoupledIO(UInt(32.W)))

  val main = Module(new MulFDynamic(6, 8, 24))
  connection(operand0, main.operand0)
  connection(operand1, main.operand1)
  connection_inverse(result, main.result)

}

object TestFloat extends ChiselUtestTester {
  val tests = Tests {
    test("dynamicFloat") {
      testCircuit(
        new dynamicFloat,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        fork {
          val r = new Random(1)
          val operand0:    Float = r.nextFloat() * 100
          val operand1:    Float = r.nextFloat() * 100
          val result:      Float = operand0 * operand1
          val operand0_in: Int   = floatToIntBits(operand0)
          val operand1_in: Int   = floatToIntBits(operand1)
          val result_in:   Int   = floatToIntBits(result)
          println(result_in)
          for (i <- 0 until 6) {
            dut.operand0.bits.poke(operand0_in.U)
            dut.operand1.bits.poke(operand1_in.U)
            dut.clock.step()
          }
          for (i <- 0 until 100) {
            dut.operand0.bits.poke(0.U)
            dut.operand1.bits.poke(0.U)
            dut.clock.step()
          }
        }.fork {
          fork {
            dut.result.ready.poke(false.B)
            dut.clock.step(5)
            for (i <- 0 until 100) {
              dut.result.ready.poke(true.B)
              dut.clock.step()
            }
          }.fork {
            dut.clock.step(5)
            dut.operand0.valid.poke(true.B)
            dut.clock.step()
          }.fork {
            dut.clock.step(1)
            for (i <- 0 until 5) {
              dut.operand1.valid.poke(true.B)
              dut.clock.step()
            }
          }.join()
        }.join()
      }
    }
  }
}
