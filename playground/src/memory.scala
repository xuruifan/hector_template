package hls

import chisel3._
import chisel3.util._
import chisel3.experimental._

class ReadMem(size: Int, width: Int = 32) extends MultiIOModule {
  private val mem = SyncReadMem(size, UInt(width.W))
  private val addrWidth = log2Ceil(size)
  val r_en = IO(Input(Bool()))
  val addr = IO(Input(UInt(addrWidth.W)))
  val r_data = IO(Output(UInt(width.W)))

  r_data := mem.read(addr, r_en)
}

class WriteMem(size: Int, width: Int = 32) extends MultiIOModule {
  private val mem = SyncReadMem(size, UInt(width.W))
  private val addrWidth = log2Ceil(size)
  val w_en = IO(Input(Bool()))
  val addr = IO(Input(UInt(addrWidth.W)))
  val w_data = IO(Input(UInt(width.W)))

  when(w_en) {
    mem.write(addr, w_data)
  }
}

class ReadWriteMem(size: Int, width: Int = 32) extends MultiIOModule {
  private val mem = SyncReadMem(size, UInt(width.W))
  private val addrWidth = log2Ceil(size)
  val r_en = IO(Input(Bool()))
  val w_en = IO(Input(Bool()))
  val addr = IO(Input(UInt(addrWidth.W)))
  val w_data = IO(Input(UInt(width.W)))
  val r_data = IO(Output(UInt(width.W)))
  r_data := DontCare

  when(r_en || w_en) {
    val rwPort = mem(addr)
    when(w_en) {
      rwPort := w_data
    }.otherwise {
      r_data := rwPort
    }
  }

}