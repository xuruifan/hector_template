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


object TestSpmvEllpack extends ChiselUtestTester {
  val tests = Tests {
    test("spmvEllpack") {
      testCircuit(
        new ellpack,
        Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)
      ) { dut =>
        dut.clock.setTimeout(1000)
        fork {
          dut.go.poke(true.B)
          dut.clock.step();
        } fork {
          while (!dut.done.peek.litToBoolean) {
            dut.clock.step();
          }
        } join()
      }
    }
  }
}

