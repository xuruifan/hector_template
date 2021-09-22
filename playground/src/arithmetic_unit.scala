package hls

import chisel3._
import chisel3.util._
import chisel3.experimental._


class BinaryUnit(width: Int = 32, func: (UInt, UInt) => UInt, shift: Int = 0) extends MultiIOModule {
  val operand0 = IO(Input(UInt(width.W)))
  val operand1 = IO(Input(UInt(width.W)))
  val result = IO(Output(UInt(width.W)))
  //  result := func(operand0, operand1)
  private val buffer = ShiftRegister(func(operand0, operand1), shift)
  result := buffer
}

class And(width: Int = 32) extends BinaryUnit(width, _ & _) {}

class Or(width: Int = 32) extends BinaryUnit(width, _ | _) {}

class Xor(width: Int = 32) extends BinaryUnit(width, _ ^ _) {}

class AddI(width: Int = 32) extends BinaryUnit(width, _ + _) {}

class SubI(width: Int = 32) extends BinaryUnit(width, _ - _) {}

class MulI(width: Int = 32) extends BinaryUnit(width, _ * _, 1) {}


class DivI(width: Int = 32) extends BinaryUnit(width, _ / _) {}

class BinaryUnitDynamic(width: Int = 32, func: (UInt, UInt) => UInt) extends MultiIOModule {
  val operand0 = IO(Flipped(DecoupledIO(UInt(width.W))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width.W))))
  val result = IO(DecoupledIO(UInt(width.W)))
  result.bits := func(operand0.bits, operand1.bits)
  result.valid := operand0.valid & operand1.valid
  operand0.ready := operand1.valid & result.ready
  operand1.ready := operand0.valid & result.ready
}

class AndDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ & _) {}

class OrDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ | _) {}

class XorDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ ^ _) {}

class AddIDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ + _) {}

class SubIDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ - _) {}

class MulIDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ * _) {}

class DivIDynamic(width: Int = 32) extends BinaryUnitDynamic(width, _ / _) {}

class CmpI(width: Int = 32, func: (UInt, UInt) => Bool) extends MultiIOModule {
  val operand0 = IO(Input(UInt(width.W)))
  val operand1 = IO(Input(UInt(width.W)))
  val result = IO(Output(Bool()))
  result := func(operand0, operand1)
}

class GreaterthanI(width: Int = 32) extends CmpI(width, _ > _) {}

class GreaterEqualthanI(width: Int = 32) extends CmpI(width, _ >= _) {}

class LessthanI(width: Int = 32) extends CmpI(width, _ < _) {}

class LessEqualthanI(width: Int = 32) extends CmpI(width, _ <= _) {}

class EqualI(width: Int = 32) extends CmpI(width, _ === _) {}

class CmpIDynamic(width: Int = 32, func: (UInt, UInt) => Bool) extends MultiIOModule {
  val operand0 = IO(Flipped(DecoupledIO(UInt(width.W))))
  val operand1 = IO(Flipped(DecoupledIO(UInt(width.W))))
  val result = IO(DecoupledIO(Bool()))
  result.bits := func(operand0.bits, operand1.bits)
  result.valid := operand0.valid & operand1.valid
  operand0.ready := operand1.valid & result.ready
  operand1.ready := operand0.valid & result.ready
}

class GreaterthanIDynamic(width: Int = 32) extends CmpIDynamic(width, _ > _) {}

class GreaterEqualthanIDynamic(width: Int = 32) extends CmpIDynamic(width, _ >= _) {}

class LessthanIDynamic(width: Int = 32) extends CmpIDynamic(width, _ < _) {}

class LessEqualthanIDynamic(width: Int = 32) extends CmpIDynamic(width, _ <= _) {}

class EqualIDynamic(width: Int = 32) extends CmpIDynamic(width, _ === _) {}
