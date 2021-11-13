import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.iotesters._
import chisel3.experimental.BundleLiterals._
import utest._
import testing._
import chisel3.experimental._

import org.scalatest.{FlatSpec, Matchers}
import scala.util.Random

import java.lang.Float.{floatToIntBits, intBitsToFloat}
import java.lang.Double.{doubleToLongBits, longBitsToDouble}

import hls._

object generator {
  val r = new Random(100)
  def floatsToBits(numbers: Seq[Float]): Seq[Int] = {
    numbers.map({f => floatToIntBits(f)})
  }
  def genFloats(num: Int): Seq[Float] = {
    Seq.fill(num){r.nextFloat}
  }
  def genFloatBits(num: Int): Seq[Int] = {
    Seq.fill(num){floatToIntBits(r.nextFloat)}
  }
  def genInt(lim: Int): Int = {
    r.nextInt(lim)
  }
}

class MulFTester(c: MulFBase, latency: Int) extends PeekPokeTester(c) {
  val r = new Random(1)
  val operand0: Float = r.nextFloat() * 100
  val operand1: Float = r.nextFloat() * 100
  val result: Float = operand0 * operand1

  val operand0_in: Int = floatToIntBits(operand0)
  val operand1_in: Int = floatToIntBits(operand1)
  val result_out: Int = floatToIntBits(result)

  poke(c.operand0, operand0_in.U)
  poke(c.operand1, operand1_in.U)
  poke(c.ce, true.B)

  step(latency - 2)
  poke(c.ce, false.B)
  step(10)
  poke(c.ce, true.B)
  step(2)

  expect(c.result, result_out.U)
}

class AddTester(c: AddSubFBase, latency: Int) extends PeekPokeTester(c) {
  val r = new Random(1)
  val operand0: Float = r.nextFloat() * 100
  val operand1: Float = r.nextFloat() * 100
  val result: Float = operand0 + operand1

  val operand0_in: Int = floatToIntBits(operand0)
  val operand1_in: Int = floatToIntBits(operand1)
  val result_out: Int = floatToIntBits(result)

  poke(c.operand0, operand0_in.U)
  poke(c.operand1, operand1_in.U)
  poke(c.ce, true.B)

  step(latency)
  
  expect(c.result, result_out.U)
}

class SubTester(c: AddSubFBase, latency: Int) extends PeekPokeTester(c) {
  val r = new Random(1)
  val operand0: Float = r.nextFloat() * 100
  val operand1: Float = r.nextFloat() * 100
  val result: Float = operand0 - operand1

  val operand0_in: Int = floatToIntBits(operand0)
  val operand1_in: Int = floatToIntBits(operand1)
  val result_out: Int = floatToIntBits(result)

  poke(c.operand0, operand0_in.U)
  poke(c.operand1, operand1_in.U)
  poke(c.ce, true.B)

  step(latency)

  expect(c.result, result_out.U)
}

class CmpFTester(c: CmpFBase, latency: Int) extends PeekPokeTester(c) {
  var queue = scala.collection.mutable.Queue[Bool]()
  poke(c.ce, true.B)
  for (i <- 0 until 100) {
    val nums = generator.genFloats(2)
    val ins = generator.floatsToBits(nums)
    val opcode = generator.genInt(6) + 1
    poke(c.operand0, ins(0).U)
    poke(c.operand1, ins(1).U)
    poke(c.opcode, opcode.U(5.W))

    opcode match {
      case 1 => queue.enqueue((nums(0) == nums(1)).B)
      case 2 => queue.enqueue((nums(0) > nums(1)).B)
      case 3 => queue.enqueue((nums(0) >= nums(1)).B)
      case 4 => queue.enqueue((nums(0) < nums(1)).B)
      case 5 => queue.enqueue((nums(0) <= nums(1)).B)
      case 6 => queue.enqueue((nums(0) != nums(1)).B)
    }
    step(1)
    if (i >= latency - 1) {
      val deq = queue.dequeue
      expect(c.result, deq)
    }
  }
}

class IntToFloatTester(c: IntToFloatBase, latency: Int) extends PeekPokeTester(c) {
  val r = new Random(2);
  var queue = scala.collection.mutable.Queue[Float]()
  val eps = 1e-7
  poke(c.ce, true.B)
  for (i <- 0 to latency + 5) {
    val intVal = r.nextInt()
    val floatVal = intVal.toFloat
    queue.enqueue(floatVal)
    poke(c.operand, intVal)
    //val output = peek(c.result).floatValue()
    if (i >= latency) {
      val golden = queue.dequeue()
      expect(c.result, intToUnsignedBigInt(floatToIntBits(golden)))
      val result = intBitsToFloat(peek(c.result).toInt)
      println("%f %f".format(result, golden))
    }
    step(1)
  }
}

object Tester extends FlatSpec with Matchers with App {

  iotesters.Driver.execute(() => new MulFBase(6, 8, 24), new TesterOptionsManager) { c =>
    new MulFTester(c, 6)
  }

  iotesters.Driver.execute(() => new AddSubFBase(7, 8, 24, true), new TesterOptionsManager) { c =>
    new AddTester(c, 7)
  }

  iotesters.Driver.execute(() => new AddSubFBase(7, 8, 24, false), new TesterOptionsManager) { c =>
    new SubTester(c, 7)
  }

  iotesters.Driver.execute(() => new CmpFBase(1, 8, 24), new TesterOptionsManager) { c =>
    new CmpFTester(c, 1)
  }

  iotesters.Driver.execute(() => new IntToFloatBase(7, 32, 8, 24, true), new TesterOptionsManager) { c =>
    new IntToFloatTester(c, 7)
  }
}
