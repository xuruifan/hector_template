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

import org.scalatest.{FlatSpec, Matchers}
import scala.util.Random

import java.lang.Float.{floatToIntBits, intBitsToFloat}
import java.lang.Double.{doubleToLongBits, longBitsToDouble}

object TestSpmv extends ChiselUtestTester {
  class spmvWrapper extends MultiIOModule with dynamicDelay {
    val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
    val var1 = IO(DecoupledIO(UInt(0.W)))

    val main = Module(new spmv)

    val finish = IO(Input(Bool()))
    main.finish := finish
    val test_addr = IO(Input(UInt(9.W)))
    main.test_addr := test_addr
    val test_data = IO(Output(UInt(64.W)))
    test_data := main.test_data

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
