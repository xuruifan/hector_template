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
    val lhs: Float = r.nextFloat() * 100
    val rhs: Float = r.nextFloat() * 100
    val result: Float = lhs * rhs

    val lhs_in: Int = floatToIntBits(lhs)
    val rhs_in: Int = floatToIntBits(rhs)
    val result_out: Int = floatToIntBits(result)

    poke(c.enable, true.B)
    poke(c.lhs, lhs_in.U)
    poke(c.rhs, rhs_in.U)
    
    step(latency)

    expect(c.result, result_out.U)
    expect(c.done, true.B)
}

class AddTester(c: AddSubFBase, latency: Int) extends PeekPokeTester(c) {
    val r = new Random(1)
    val lhs: Float = r.nextFloat() * 100
    val rhs: Float = r.nextFloat() * 100
    val result: Float = lhs + rhs

    val lhs_in: Int = floatToIntBits(lhs)
    val rhs_in: Int = floatToIntBits(rhs)
    val result_out: Int = floatToIntBits(result)

    poke(c.enable, true.B)
    poke(c.lhs, lhs_in.U)
    poke(c.rhs, rhs_in.U)

    step(latency)
    
    expect(c.result, result_out.U)
    expect(c.done, true.B)
}

class SubTester(c: AddSubFBase, latency: Int) extends PeekPokeTester(c) {
    val r = new Random(1)
    val lhs: Float = r.nextFloat() * 100
    val rhs: Float = r.nextFloat() * 100
    val result: Float = lhs - rhs

    val lhs_in: Int = floatToIntBits(lhs)
    val rhs_in: Int = floatToIntBits(rhs)
    val result_out: Int = floatToIntBits(result)

    poke(c.enable, true.B)
    poke(c.lhs, lhs_in.U)
    poke(c.rhs, rhs_in.U)

    step(latency)

    expect(c.result, result_out.U)
    expect(c.done, true.B)
}

class CmpFTester(c: CmpFBase, latency: Int) extends PeekPokeTester(c) {
    var queue = scala.collection.mutable.Queue[Bool]()
    for (i <- 0 until 100) {
        val nums = generator.genFloats(2)
        val ins = generator.floatsToBits(nums)
        val opcode = generator.genInt(6) + 1
        poke(c.enable, true.B)
        poke(c.lhs, ins(0).U)
        poke(c.rhs, ins(1).U)
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
        if (peek(c.done) == BigInt(1)) {
            val deq = queue.dequeue
            expect(c.result, deq)
        }
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
}