package hls

import chisel3._
import chisel3.util._
import chisel3.experimental._
import chisel3.util.experimental.loadMemoryFromFileInline

trait InitMem {
  def mem: SyncReadMem[UInt]

  def initMem(memoryFile: String) = loadMemoryFromFileInline(mem, memoryFile)
}

class MyArbiter(width: Int = 32)(portNum: Int = 1) extends MultiIOModule {
  val dataIn = IO(Vec(portNum, Flipped(ValidIO(UInt(width.W)))))
  val dataOut = IO(ValidIO(UInt(width.W)))
  val arb = Module(new Arbiter(UInt(width.W), portNum))
  arb.io.out.ready := true.B
  for (i <- 0 until portNum) {
    arb.io.in(i).bits := dataIn(i).bits
    arb.io.in(i).valid := dataIn(i).valid
  }
  dataOut.bits <> arb.io.out.bits
  dataOut.valid <> arb.io.out.valid
}

class ReadMem(size: Int, width: Int = 32, portNum: Int = 1) extends MultiIOModule with InitMem {
  val mem = SyncReadMem(size, UInt(width.W))
  private val addrWidth = log2Ceil(size)
  //  val r_en = IO(Input(Bool()))
  //  val addr = IO(Input(UInt(addrWidth.W)))
  val r_data = IO(Output(UInt(width.W)))

  val arb = Module(new MyArbiter(addrWidth)(portNum))

  val dataIn = IO(Vec(portNum, Flipped(ValidIO(UInt(width.W)))))
  dataIn <> arb.dataIn


  val addr = arb.dataOut.bits
  val r_en = arb.dataOut.valid
  r_data := mem.read(addr, r_en)
}

class BitsWrapper[+T <: Data](gen: T) extends Bundle {
  val bits = Output(gen)
}

object BitsWrapper {
  def apply[T <: Data](gen: T): BitsWrapper[T] = new BitsWrapper(gen)
}

class WriteMem(size: Int, width: Int = 32, portNum: Int = 1) extends MultiIOModule with InitMem {
  val mem = SyncReadMem(size, UInt(width.W))
  private val addrWidth = log2Ceil(size)
  //  val w_en = IO(Input(Bool()))
  //  val addr = IO(Input(UInt(addrWidth.W)))
  //  val w_data = IO(Input(UInt(width.W)))

  val arb = Module(new MyArbiter(addrWidth + width)(portNum))

  val dataIn = IO(Vec(portNum, Flipped(ValidIO(UInt(addrWidth.W)))))
  val w_dataIn = IO(Vec(portNum, Flipped(BitsWrapper(UInt(width.W)))))
  for (i <- 0 until portNum) {
    arb.dataIn(i).bits := Cat(dataIn(i).bits, w_dataIn(i).bits)
    arb.dataIn(i).valid := dataIn(i).valid
  }

  val w_en = arb.dataOut.valid
  val addr = arb.dataOut.bits(addrWidth + width - 1, width)
  val w_data = arb.dataOut.bits(width - 1, 0)

  val finished = IO(Input(Bool()))
  val test_addr = IO(Input(UInt(addrWidth.W)))
  val test_data = IO(Output(UInt(width.W)))
  test_data := DontCare

  //  when(w_en) {
  //    mem.write(addr, w_data)
  //  }

  when(finished) {
    test_data := mem.read(test_addr)
  }.elsewhen(w_en) {
    mem.write(addr, w_data)
  }
}

class ReadWriteMem(size: Int, width: Int = 32, portNum: Int = 1) extends MultiIOModule with InitMem {
  val mem = SyncReadMem(size, UInt(width.W))
  private val addrWidth = log2Ceil(size)
  //  val r_en = IO(Input(Bool()))
  //  val w_en = IO(Input(Bool()))
  //  val addr = IO(Input(UInt(addrWidth.W)))
  //  val w_data = IO(Input(UInt(width.W)))
  val r_data = IO(Output(UInt(width.W)))
  r_data := DontCare

  val readArb = Module(new MyArbiter(addrWidth)(portNum))
  val writeArb = Module(new MyArbiter(addrWidth + width)(portNum))

  val readIn = IO(Vec(portNum, Flipped(ValidIO(UInt(addrWidth.W)))))
  val writeIn = IO(Vec(portNum, Flipped(ValidIO(UInt(addrWidth.W)))))
  val w_dataIn = IO(Vec(portNum, Flipped(BitsWrapper(UInt(width.W)))))

  readIn <> readArb.dataIn

  for (i <- 0 until portNum) {
    writeArb.dataIn(i).bits := Cat(w_dataIn(i).bits, writeIn(i).bits)
    writeArb.dataIn(i).valid := writeIn(i).valid
  }
  //  writeIn <> writeArb.dataIn

  val r_en = readArb.dataOut.valid
  val w_en = writeArb.dataOut.valid

  val arb = Module(new MyArbiter(addrWidth + width)(2))
  arb.dataIn(0) <> readArb.dataOut // FIXME, unmatched width
  arb.dataIn(1) <> writeArb.dataOut
  val addr = arb.dataOut.bits(addrWidth - 1, 0)
  val w_data = arb.dataOut.bits(addrWidth + width - 1, addrWidth)

  val finished = IO(Input(Bool()))
  val test_addr = IO(Input(UInt(addrWidth.W)))
  val test_data = IO(Output(UInt(width.W)))
  test_data := DontCare

  when(finished) {
    test_data := mem.read(test_addr)
  }.elsewhen(r_en || w_en) {
    val rwPort = mem(addr)
    when(w_en) {
      rwPort := w_data
    }.otherwise {
      r_data := rwPort
    }
  }
}
