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

object Elaborate extends App {
  //  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new branch_prediction())))
  //  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new main())))
  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new spmv())))
  //  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new ReadWriteMem(1024))))
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

class dynamicFloat extends MultiIOModule with dynamicDelay {
  val operand0 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val result = IO(DecoupledIO(UInt(32.W)))

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
          val operand0: Float = r.nextFloat() * 100
          val operand1: Float = r.nextFloat() * 100
          val result: Float = operand0 * operand1
          val operand0_in: Int = floatToIntBits(operand0)
          val operand1_in: Int = floatToIntBits(operand1)
          val result_in: Int = floatToIntBits(result)
          println(result_in)
          for(i <- 0 until 6) {
            dut.operand0.bits.poke(operand0_in.U)
            dut.operand1.bits.poke(operand1_in.U)
            dut.clock.step()
          }
          for(i <- 0 until 100) {
            dut.operand0.bits.poke(0.U)
            dut.operand1.bits.poke(0.U)
            dut.clock.step()
          }
          } fork {
            fork {
              dut.result.ready.poke(false.B)
              dut.clock.step(5)
              for(i <- 0 until 100) {
                dut.result.ready.poke(true.B)
                dut.clock.step()
              }
              } fork {
                dut.clock.step(5)
                dut.operand0.valid.poke(true.B)
                dut.clock.step()
                } fork {
                  dut.clock.step(1)
                  for(i <- 0 until 5) {
                    dut.operand1.valid.poke(true.B)
                    dut.clock.step()
                  }
                } join()
          } join()
      }
    }
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
    main.mem_1_addr := test_addr
    val test_data = IO(Output(UInt(64.W)))
    test_data := main.mem_1_data

    connection(var0, main.var75)
    connection_inverse(var1, main.var76)
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
