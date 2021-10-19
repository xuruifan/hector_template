import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import testing._
import chisel3.experimental._
import hls._

class main extends MultiIOModule {
  val var0 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val var1 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val var2 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val var3 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val var4 = IO(DecoupledIO(UInt(32.W)))
  var4 := DontCare
  val cmpi_sle_0 = Module(new LessEqualthanIDynamic())
  val var5 = cmpi_sle_0.operand0
  var5 := DontCare
  val var6 = cmpi_sle_0.operand1
  var6 := DontCare
  val var7 = cmpi_sle_0.result
  var7 := DontCare
  val m_1 = Module(new Merge()())
  val var8 = m_1.dataIn apply 0
  var8 := DontCare
  val var9 = m_1.dataIn apply 1
  var9 := DontCare
  val var10 = m_1.dataOut
  var10 := DontCare
  val b_2 = Module(new Branch())
  val var11 = b_2.condition
  var11 := DontCare
  val var12 = b_2.dataIn
  var12 := DontCare
  val var13 = b_2.dataOut apply 0
  var13 := DontCare
  val var14 = b_2.dataOut apply 1
  var14 := DontCare
  val buf_3 = Module(new ElasticBuffer())
  val var15 = buf_3.dataIn
  var15 := DontCare
  val var16 = buf_3.dataOut
  var16 := DontCare
  val m_4 = Module(new Merge()())
  val var17 = m_4.dataIn apply 0
  var17 := DontCare
  val var18 = m_4.dataIn apply 1
  var18 := DontCare
  val var19 = m_4.dataOut
  var19 := DontCare
  val buf_5 = Module(new ElasticBuffer())
  val var20 = buf_5.dataIn
  var20 := DontCare
  val var21 = buf_5.dataOut
  var21 := DontCare
  val b_6 = Module(new Branch())
  val var22 = b_6.condition
  var22 := DontCare
  val var23 = b_6.dataIn
  var23 := DontCare
  val var24 = b_6.dataOut apply 0
  var24 := DontCare
  val var25 = b_6.dataOut apply 1
  var25 := DontCare
  val m_7 = Module(new Merge()())
  val var26 = m_7.dataIn apply 0
  var26 := DontCare
  val var27 = m_7.dataIn apply 1
  var27 := DontCare
  val var28 = m_7.dataOut
  var28 := DontCare
  val buf_8 = Module(new ElasticBuffer())
  val var29 = buf_8.dataIn
  var29 := DontCare
  val var30 = buf_8.dataOut
  var30 := DontCare
  val b_9 = Module(new Branch())
  val var31 = b_9.condition
  var31 := DontCare
  val var32 = b_9.dataIn
  var32 := DontCare
  val var33 = b_9.dataOut apply 0
  var33 := DontCare
  val var34 = b_9.dataOut apply 1
  var34 := DontCare
  val m_10 = Module(new Merge()())
  val var35 = m_10.dataIn apply 0
  var35 := DontCare
  val var36 = m_10.dataIn apply 1
  var36 := DontCare
  val var37 = m_10.dataOut
  var37 := DontCare
  val buf_11 = Module(new ElasticBuffer())
  val var38 = buf_11.dataIn
  var38 := DontCare
  val var39 = buf_11.dataOut
  var39 := DontCare
  val b_12 = Module(new Branch())
  val var40 = b_12.condition
  var40 := DontCare
  val var41 = b_12.dataIn
  var41 := DontCare
  val var42 = b_12.dataOut apply 0
  var42 := DontCare
  val var43 = b_12.dataOut apply 1
  var43 := DontCare
  val addi_13 = Module(new AddIDynamic())
  val var44 = addi_13.operand0
  var44 := DontCare
  val var45 = addi_13.operand1
  var45 := DontCare
  val var46 = addi_13.result
  var46 := DontCare
  val cmpi_14 = Module(new LessEqualthanIDynamic())
  val var47 = cmpi_14.operand0
  var47 := DontCare
  val var48 = cmpi_14.operand1
  var48 := DontCare
  val var49 = cmpi_14.result
  var49 := DontCare
  val b_15 = Module(new Branch())
  val var50 = b_15.condition
  var50 := DontCare
  val var51 = b_15.dataIn
  var51 := DontCare
  val var52 = b_15.dataOut apply 0
  var52 := DontCare
  val var53 = b_15.dataOut apply 1
  var53 := DontCare
  val b_16 = Module(new Branch())
  val var54 = b_16.condition
  var54 := DontCare
  val var55 = b_16.dataIn
  var55 := DontCare
  val var56 = b_16.dataOut apply 0
  var56 := DontCare
  val var57 = b_16.dataOut apply 1
  var57 := DontCare
  val m_17 = Module(new Merge()())
  val var58 = m_17.dataIn apply 0
  var58 := DontCare
  val var59 = m_17.dataIn apply 1
  var59 := DontCare
  val var60 = m_17.dataOut
  var60 := DontCare
  val addi_18 = Module(new AddIDynamic())
  val var61 = addi_18.operand0
  var61 := DontCare
  val var62 = addi_18.operand1
  var62 := DontCare
  val var63 = addi_18.result
  var63 := DontCare
  val addi_19 = Module(new AddIDynamic())
  val var64 = addi_19.operand0
  var64 := DontCare
  val var65 = addi_19.operand1
  var65 := DontCare
  val var66 = addi_19.result
  var66 := DontCare
  val addi_20 = Module(new AddIDynamic())
  val var67 = addi_20.operand0
  var67 := DontCare
  val var68 = addi_20.operand1
  var68 := DontCare
  val var69 = addi_20.result
  var69 := DontCare
  val f_21 = Module(new Fork()(4))
  val var70 = f_21.dataIn
  var70 := DontCare
  val var71 = f_21.dataOut apply 0
  var71 := DontCare
  val var72 = f_21.dataOut apply 1
  var72 := DontCare
  val var73 = f_21.dataOut apply 2
  var73 := DontCare
  val var74 = f_21.dataOut apply 3
  var74 := DontCare
  val f_22 = Module(new Fork()(2))
  val var75 = f_22.dataIn
  var75 := DontCare
  val var76 = f_22.dataOut apply 0
  var76 := DontCare
  val var77 = f_22.dataOut apply 1
  var77 := DontCare
  val f_23 = Module(new Fork()(2))
  val var78 = f_23.dataIn
  var78 := DontCare
  val var79 = f_23.dataOut apply 0
  var79 := DontCare
  val var80 = f_23.dataOut apply 1
  var80 := DontCare
  val f_24 = Module(new Fork()(2))
  val var81 = f_24.dataIn
  var81 := DontCare
  val var82 = f_24.dataOut apply 0
  var82 := DontCare
  val var83 = f_24.dataOut apply 1
  var83 := DontCare
  val f_25 = Module(new Fork()(3))
  val var84 = f_25.dataIn
  var84 := DontCare
  val var85 = f_25.dataOut apply 0
  var85 := DontCare
  val var86 = f_25.dataOut apply 1
  var86 := DontCare
  val var87 = f_25.dataOut apply 2
  var87 := DontCare
  val f_26 = Module(new Fork()(2))
  val var88 = f_26.dataIn
  var88 := DontCare
  val var89 = f_26.dataOut apply 0
  var89 := DontCare
  val var90 = f_26.dataOut apply 1
  var90 := DontCare
  val f_27 = Module(new Fork()(2))
  val var91 = f_27.dataIn
  var91 := DontCare
  val var92 = f_27.dataOut apply 0
  var92 := DontCare
  val var93 = f_27.dataOut apply 1
  var93 := DontCare
  var15 <> var10
  var12 <> var16
  var11 <> var74
  var8 <> var3
  var20 <> var19
  var17 <> var2
  var22 <> var73
  var23 <> var77
  var18 <> var24
  var29 <> var28
  var26 <> var1
  var31 <> var72
  var32 <> var80
  var27 <> var33
  var38 <> var37
  var35 <> var0
  var5 <> var83
  var6 <> var79
  var40 <> var71
  var41 <> var82
  var44 <> var87
  var45 <> var76
  var36 <> var46
  var47 <> var86
  var48.bits := 5.U
  var48.valid := true.B
  var50 <> var90
  var51 <> var85
  var54 <> var89
  var55 <> var13
  var61 <> var56
  var62 <> var52
  var58 <> var63
  var64 <> var93
  var65 <> var92
  var67 <> var57
  var68 <> var66
  var59 <> var69
  var9 <> var60
  var4 <> var14
  var70 <> var7
  var75 <> var21
  var78 <> var30
  var81 <> var39
  var84 <> var42
  var88 <> var49
  var91 <> var53
  var25.ready := true.B
  var34.ready := true.B
  var43.ready := true.B
}

class Z extends MultiIOModule {
  val go = IO(Input(Bool()))
  val done = IO(Output(Bool()))
  done := 0.U
  val var0 = IO(Input(UInt(32.W)))
  val var1 = IO(Output(UInt(32.W)))
  var1 := DontCare
  object State extends ChiselEnum {
    val z0 = Value
  }
  val state = RegInit(State.z0)
  switch (state) {
    is (State.z0) {
      when (go) {
        done := 1.U
        var1 := 30.U
      }
    }
  }
}


class dyn_main extends MultiIOModule {
  val var2_dyn = IO(Flipped(DecoupledIO(UInt(32.W))))
  val var2 = var2_dyn.bits
  val var3_dyn = IO(Flipped(DecoupledIO(UInt(1.W))))
  val var3 = var3_dyn.bits
  val var4_dyn = IO(DecoupledIO(UInt(32.W)))
  val var4 = var4_dyn.bits
  var4 := DontCare
  var4_dyn.valid := false.B
  val var5_dyn = IO(DecoupledIO(UInt(1.W)))
  val var5 = var5_dyn.bits
  var5 := DontCare
  var5_dyn.valid := false.B
  val go = var4_dyn.ready & var5_dyn.ready & var2_dyn.valid & var3_dyn.valid
  def done() : Unit = {
    var4_dyn.valid := true.B
    var5_dyn.valid := true.B
  }
  val var6 = Reg(UInt(32.W))
  val add = Module(new AddI())
  val var7 = add.operand0
  var7 := DontCare
  val var8 = add.operand1
  var8 := DontCare
  val var9 = add.result
  var9 := DontCare
  val z = Module(new Z)
  z.go := 0.U
  val var10 = z.var0
  var10 := DontCare
  val var11 = z.go
  var11 := DontCare
  val var12 = z.var1
  val var13 = z.done
  object State extends ChiselEnum {
    val s0, s1 = Value
  }
  val state = RegInit(State.s0)
  val ready = go & (state === State.s0)
  switch (state) {
    is (State.s0) {
      when (go) {
        var6 := 10.U
        var7 := var6
        z.go := 1.U
        when (1.U.asBool()) {
          state := State.s1;
        }
        done()
        var4 := var2
      }
    }
    is (State.s1) {
      when (1.U.asBool()) {
        z.go := 1.U
      }
      state := State.s0;
      when (1.U.asBool()) {
        done()
        var4 := var12
      }
    }
  }
  var2_dyn.ready := ready
  var3_dyn.ready := ready
}

