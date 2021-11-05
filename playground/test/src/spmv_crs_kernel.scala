import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import testing._
import chisel3.experimental._
import hls._

/*
class spmv extends MultiIOModule {
  class main extends MultiIOModule {
    val mem_0 = Module(new DynMem(1, 0)(1666, 64))
    mem_0.finish := DontCare
    mem_0.read_address := DontCare
    val var0 = mem_0.load_address apply 0
    var0 := DontCare
    val var1 = mem_0.load_data apply 0
    val mem_1 = Module(new DynMem(1, 0)(1666, 32))
    mem_1.finish := DontCare
    mem_1.read_address := DontCare
    val var2 = mem_1.load_address apply 0
    var2 := DontCare
    val var3 = mem_1.load_data apply 0
    val mem_2 = Module(new DynMem(2, 0)(495, 32))
    mem_2.finish := DontCare
    mem_2.read_address := DontCare
    val var4 = mem_2.load_address apply 0
    var4 := DontCare
    val var5 = mem_2.load_data apply 0
    val var6 = mem_2.load_address apply 1
    var6 := DontCare
    val var7 = mem_2.load_data apply 1
    val mem_3 = Module(new DynMem(1, 0)(494, 64))
    mem_3.finish := DontCare
    mem_3.read_address := DontCare
    val var8 = mem_3.load_address apply 0
    var8 := DontCare
    val var9 = mem_3.load_data apply 0
    val mem_4 = Module(new DynMem(0, 1)(494, 64))
    val finish = IO(Input(Bool()))
    mem_4.finish := finish
    val test_addr = IO(Input(UInt(9.W)))
    mem_4.read_address := test_addr
    val test_data = IO(Output(UInt(64.W)))
    test_data := mem_4.out_data
    val var10 = mem_4.store_address apply 0
    var10 := DontCare
    val var11 = mem_4.store_data apply 0
    var11 := DontCare
    val cmpi_sle_5 = Module(new LessEqualthanIDynamic())
    val var12 = cmpi_sle_5.operand0
    var12 := DontCare
    val var13 = cmpi_sle_5.operand1
    var13 := DontCare
    val var14 = cmpi_sle_5.result
    var14 := DontCare
    val m_6 = Module(new Merge()())
    val var15 = m_6.dataIn apply 0
    var15 := DontCare
    val var16 = m_6.dataIn apply 1
    var16 := DontCare
    val var17 = m_6.dataOut
    var17 := DontCare
    val buf_7 = Module(new ElasticBuffer())
    val var18 = buf_7.dataIn
    var18 := DontCare
    val var19 = buf_7.dataOut
    var19 := DontCare
    val b_8 = Module(new Branch())
    val var20 = b_8.condition
    var20 := DontCare
    val var21 = b_8.dataIn
    var21 := DontCare
    val var22 = b_8.dataOut apply 0
    var22 := DontCare
    val var23 = b_8.dataOut apply 1
    var23 := DontCare
    val addi_9 = Module(new AddIDynamic())
    val var24 = addi_9.operand0
    var24 := DontCare
    val var25 = addi_9.operand1
    var25 := DontCare
    val var26 = addi_9.result
    var26 := DontCare
    val load_10 = Module(new Load())
    val var27 = load_10.address_in
    var27 := DontCare
    val var28 = load_10.data_out
    var28 := DontCare
    val var29 = load_10.address_out
    var29 := DontCare
    val var30 = load_10.data_in
    var30 := DontCare
    val addi_11 = Module(new AddIDynamic())
    val var31 = addi_11.operand0
    var31 := DontCare
    val var32 = addi_11.operand1
    var32 := DontCare
    val var33 = addi_11.result
    var33 := DontCare
    val load_12 = Module(new Load())
    val var34 = load_12.address_in
    var34 := DontCare
    val var35 = load_12.data_out
    var35 := DontCare
    val var36 = load_12.address_out
    var36 := DontCare
    val var37 = load_12.data_in
    var37 := DontCare
    val subi_13 = Module(new SubIDynamic())
    val var38 = subi_13.operand0
    var38 := DontCare
    val var39 = subi_13.operand1
    var39 := DontCare
    val var40 = subi_13.result
    var40 := DontCare
    val cmpi_sle_14 = Module(new LessEqualthanIDynamic())
    val var41 = cmpi_sle_14.operand0
    var41 := DontCare
    val var42 = cmpi_sle_14.operand1
    var42 := DontCare
    val var43 = cmpi_sle_14.result
    var43 := DontCare
    val m_15 = Module(new Merge()())
    val var44 = m_15.dataIn apply 0
    var44 := DontCare
    val var45 = m_15.dataIn apply 1
    var45 := DontCare
    val var46 = m_15.dataOut
    var46 := DontCare
    val b_16 = Module(new Branch())
    val var47 = b_16.condition
    var47 := DontCare
    val var48 = b_16.dataIn
    var48 := DontCare
    val var49 = b_16.dataOut apply 0
    var49 := DontCare
    val var50 = b_16.dataOut apply 1
    var50 := DontCare
    val buf_17 = Module(new ElasticBuffer())
    val var51 = buf_17.dataIn
    var51 := DontCare
    val var52 = buf_17.dataOut
    var52 := DontCare
    val m_18 = Module(new Merge()())
    val var53 = m_18.dataIn apply 0
    var53 := DontCare
    val var54 = m_18.dataIn apply 1
    var54 := DontCare
    val var55 = m_18.dataOut
    var55 := DontCare
    val buf_19 = Module(new ElasticBuffer())
    val var56 = buf_19.dataIn
    var56 := DontCare
    val var57 = buf_19.dataOut
    var57 := DontCare
    val b_20 = Module(new Branch())
    val var58 = b_20.condition
    var58 := DontCare
    val var59 = b_20.dataIn
    var59 := DontCare
    val var60 = b_20.dataOut apply 0
    var60 := DontCare
    val var61 = b_20.dataOut apply 1
    var61 := DontCare
    val m_21 = Module(new Merge()())
    val var62 = m_21.dataIn apply 0
    var62 := DontCare
    val var63 = m_21.dataIn apply 1
    var63 := DontCare
    val var64 = m_21.dataOut
    var64 := DontCare
    val buf_22 = Module(new ElasticBuffer())
    val var65 = buf_22.dataIn
    var65 := DontCare
    val var66 = buf_22.dataOut
    var66 := DontCare
    val b_23 = Module(new Branch())
    val var67 = b_23.condition
    var67 := DontCare
    val var68 = b_23.dataIn
    var68 := DontCare
    val var69 = b_23.dataOut apply 0
    var69 := DontCare
    val var70 = b_23.dataOut apply 1
    var70 := DontCare
    val addi_24 = Module(new AddIDynamic())
    val var71 = addi_24.operand0
    var71 := DontCare
    val var72 = addi_24.operand1
    var72 := DontCare
    val var73 = addi_24.result
    var73 := DontCare
    val subi_25 = Module(new SubIDynamic())
    val var74 = subi_25.operand0
    var74 := DontCare
    val var75 = subi_25.operand1
    var75 := DontCare
    val var76 = subi_25.result
    var76 := DontCare
    val addi_26 = Module(new AddIDynamic())
    val var77 = addi_26.operand0
    var77 := DontCare
    val var78 = addi_26.operand1
    var78 := DontCare
    val var79 = addi_26.result
    var79 := DontCare
    val load_27 = Module(new Load())
    val var80 = load_27.address_in
    var80 := DontCare
    val var81 = load_27.data_out
    var81 := DontCare
    val var82 = load_27.address_out
    var82 := DontCare
    val var83 = load_27.data_in
    var83 := DontCare
    val load_28 = Module(new Load())
    val var84 = load_28.address_in
    var84 := DontCare
    val var85 = load_28.data_out
    var85 := DontCare
    val var86 = load_28.address_out
    var86 := DontCare
    val var87 = load_28.data_in
    var87 := DontCare
    val load_29 = Module(new Load())
    val var88 = load_29.address_in
    var88 := DontCare
    val var89 = load_29.data_out
    var89 := DontCare
    val var90 = load_29.address_out
    var90 := DontCare
    val var91 = load_29.data_in
    var91 := DontCare
    val mulf_30 = Module(new MulFDynamic(6, 11, 53))
    val var92 = mulf_30.operand0
    var92 := DontCare
    val var93 = mulf_30.operand1
    var93 := DontCare
    val var94 = mulf_30.result
    var94 := DontCare
    val addf_31 = Module(new AddFDynamic(10, 11, 53))
    val var95 = addf_31.operand0
    var95 := DontCare
    val var96 = addf_31.operand1
    var96 := DontCare
    val var97 = addf_31.result
    var97 := DontCare
    val store_32 = Module(new Store())
    val var98 = store_32.address_in
    var98 := DontCare
    val var99 = store_32.data_in
    var99 := DontCare
    val var100 = store_32.address_out
    var100 := DontCare
    val var101 = store_32.data_out
    var101 := DontCare
    val f_33 = Module(new Fork()(2))
    val var102 = f_33.dataIn
    var102 := DontCare
    val var103 = f_33.dataOut apply 0
    var103 := DontCare
    val var104 = f_33.dataOut apply 1
    var104 := DontCare
    val f_34 = Module(new Fork()(4))
    val var105 = f_34.dataIn
    var105 := DontCare
    val var106 = f_34.dataOut apply 0
    var106 := DontCare
    val var107 = f_34.dataOut apply 1
    var107 := DontCare
    val var108 = f_34.dataOut apply 2
    var108 := DontCare
    val var109 = f_34.dataOut apply 3
    var109 := DontCare
    val f_35 = Module(new Fork()(3))
    val var110 = f_35.dataIn
    var110 := DontCare
    val var111 = f_35.dataOut apply 0
    var111 := DontCare
    val var112 = f_35.dataOut apply 1
    var112 := DontCare
    val var113 = f_35.dataOut apply 2
    var113 := DontCare
    val f_36 = Module(new Fork()(3))
    val var114 = f_36.dataIn
    var114 := DontCare
    val var115 = f_36.dataOut apply 0
    var115 := DontCare
    val var116 = f_36.dataOut apply 1
    var116 := DontCare
    val var117 = f_36.dataOut apply 2
    var117 := DontCare
    val f_37 = Module(new Fork()(2))
    val var118 = f_37.dataIn
    var118 := DontCare
    val var119 = f_37.dataOut apply 0
    var119 := DontCare
    val var120 = f_37.dataOut apply 1
    var120 := DontCare
    val f_38 = Module(new Fork()(2))
    val var121 = f_38.dataIn
    var121 := DontCare
    val var122 = f_38.dataOut apply 0
    var122 := DontCare
    val var123 = f_38.dataOut apply 1
    var123 := DontCare
    val f_39 = Module(new Fork()(2))
    val var124 = f_39.dataIn
    var124 := DontCare
    val var125 = f_39.dataOut apply 0
    var125 := DontCare
    val var126 = f_39.dataOut apply 1
    var126 := DontCare
    val f_40 = Module(new Fork()(2))
    val var127 = f_40.dataIn
    var127 := DontCare
    val var128 = f_40.dataOut apply 0
    var128 := DontCare
    val var129 = f_40.dataOut apply 1
    var129 := DontCare
    var18 <> var17
    var15.bits := 0.U
    val temp_reg = RegInit(true.B)
    var15.valid := temp_reg
    when(var15.ready) {
      temp_reg := false.B
    }
    var12 <> var104
    var13.bits := 493.U
    var13.valid := true.B
    var20 <> var14
    var21 <> var103
    var24 <> var109
    var25.bits := 1.U
    var25.valid := true.B
    var16 <> var26
    var27 <> var108
    var4 <> var29
    var30 <> var5
    var31 <> var107
    var32.bits := 1.U
    var32.valid := true.B
    var34 <> var33
    var6 <> var36
    var37 <> var7
    var38 <> var35
    var39.bits := 1.U
    var39.valid := true.B
    var51 <> var46
    var48 <> var52
    var47 <> var117
    var44.bits := 0.U
    var44.valid := true.B
    var56 <> var55
    var53 <> var40
    var58 <> var116
    var59 <> var120
    var54 <> var60
    var65 <> var64
    var62 <> var113
    var41 <> var123
    var42 <> var119
    var67 <> var115
    var68 <> var122
    var71 <> var126
    var72.bits := 1.U
    var72.valid := true.B
    var63 <> var73
    var74 <> var125
    var75 <> var112
    var77 <> var76
    var78 <> var111
    var80 <> var129
    var0 <> var82
    var83 <> var1
    var84 <> var128
    var2 <> var86
    var87 <> var3
    var88 <> var85
    var8 <> var90
    var91 <> var9
    var92 <> var81
    var93 <> var89
    var95 <> var49
    var96 <> var94
    var45 <> var97
    var98 <> var106
    var99 <> var50
    var10 <> var100
    var11 <> var101
    var102 <> var19
    var105 <> var22
    var110 <> var28
    var114 <> var43
    var118 <> var57
    var121 <> var66
    var124 <> var69
    var127 <> var79
    var23.ready := true.B
    var61.ready := true.B
    var70.ready := true.B
    mem_0.initMem("mem_0.txt")
    mem_1.initMem("mem_1.txt")
    mem_2.initMem("mem_2.txt")
    mem_3.initMem("mem_3.txt")
  }

  val main = Module(new main)
  val finish = IO(Input(Bool()))
  main.finish := finish
  val test_addr = IO(Input(UInt(9.W)))
  main.test_addr := test_addr
  val test_data = IO(Output(UInt(64.W)))
  test_data := main.test_data
}
*/

class spmv extends MultiIOModule {
  class main extends MultiIOModule {
    val mem_0 = Module(new DynMem(1, 0)(1666, 64))
    val var0 = mem_0.load_address apply 0
    var0 := DontCare
    val var1 = mem_0.load_data apply 0
    var1 := DontCare
    val mem_1 = Module(new DynMem(1, 0)(1666, 32))
    val var2 = mem_1.load_address apply 0
    var2 := DontCare
    val var3 = mem_1.load_data apply 0
    var3 := DontCare
    val mem_2 = Module(new DynMem(2, 0)(495, 32))
    val var4 = mem_2.load_address apply 0
    var4 := DontCare
    val var5 = mem_2.load_data apply 0
    var5 := DontCare
    val var6 = mem_2.load_address apply 1
    var6 := DontCare
    val var7 = mem_2.load_data apply 1
    var7 := DontCare
    val mem_3 = Module(new DynMem(1, 0)(494, 64))
    val var8 = mem_3.load_address apply 0
    var8 := DontCare
    val var9 = mem_3.load_data apply 0
    var9 := DontCare
    val mem_4 = Module(new DynMem(0, 1)(494, 64))
    val var10 = mem_4.store_address apply 0
    var10 := DontCare
    val var11 = mem_4.store_data apply 0
    var11 := DontCare
    val cmpi_sle_5 = Module(new LessEqualthanIDynamic())
    val var12 = cmpi_sle_5.operand0
    var12 := DontCare
    val var13 = cmpi_sle_5.operand1
    var13 := DontCare
    val var14 = cmpi_sle_5.result
    var14 := DontCare
    val m_6 = Module(new Merge()())
    val var15 = m_6.dataIn apply 0
    var15 := DontCare
    val var16 = m_6.dataIn apply 1
    var16 := DontCare
    val var17 = m_6.dataOut
    var17 := DontCare
    val buf_7 = Module(new ElasticBuffer())
    val var18 = buf_7.dataIn
    var18 := DontCare
    val var19 = buf_7.dataOut
    var19 := DontCare
    val b_8 = Module(new Branch())
    val var20 = b_8.condition
    var20 := DontCare
    val var21 = b_8.dataIn
    var21 := DontCare
    val var22 = b_8.dataOut apply 0
    var22 := DontCare
    val var23 = b_8.dataOut apply 1
    var23 := DontCare
    val addi_9 = Module(new AddIDynamic())
    val var24 = addi_9.operand0
    var24 := DontCare
    val var25 = addi_9.operand1
    var25 := DontCare
    val var26 = addi_9.result
    var26 := DontCare
    val load_10 = Module(new Load(495, 32))
    val var27 = load_10.address_in
    var27 := DontCare
    val var28 = load_10.data_out
    var28 := DontCare
    val var29 = load_10.address_out
    var29 := DontCare
    val var30 = load_10.data_in
    var30 := DontCare
    val addi_11 = Module(new AddIDynamic())
    val var31 = addi_11.operand0
    var31 := DontCare
    val var32 = addi_11.operand1
    var32 := DontCare
    val var33 = addi_11.result
    var33 := DontCare
    val load_12 = Module(new Load(495, 32))
    val var34 = load_12.address_in
    var34 := DontCare
    val var35 = load_12.data_out
    var35 := DontCare
    val var36 = load_12.address_out
    var36 := DontCare
    val var37 = load_12.data_in
    var37 := DontCare
    val subi_13 = Module(new SubIDynamic())
    val var38 = subi_13.operand0
    var38 := DontCare
    val var39 = subi_13.operand1
    var39 := DontCare
    val var40 = subi_13.result
    var40 := DontCare
    val cmpi_sle_14 = Module(new LessEqualthanIDynamic())
    val var41 = cmpi_sle_14.operand0
    var41 := DontCare
    val var42 = cmpi_sle_14.operand1
    var42 := DontCare
    val var43 = cmpi_sle_14.result
    var43 := DontCare
    val m_15 = Module(new Merge()())
    val var44 = m_15.dataIn apply 0
    var44 := DontCare
    val var45 = m_15.dataIn apply 1
    var45 := DontCare
    val var46 = m_15.dataOut
    var46 := DontCare
    val b_16 = Module(new Branch())
    val var47 = b_16.condition
    var47 := DontCare
    val var48 = b_16.dataIn
    var48 := DontCare
    val var49 = b_16.dataOut apply 0
    var49 := DontCare
    val var50 = b_16.dataOut apply 1
    var50 := DontCare
    val buf_17 = Module(new ElasticBuffer())
    val var51 = buf_17.dataIn
    var51 := DontCare
    val var52 = buf_17.dataOut
    var52 := DontCare
    val m_18 = Module(new Merge()())
    val var53 = m_18.dataIn apply 0
    var53 := DontCare
    val var54 = m_18.dataIn apply 1
    var54 := DontCare
    val var55 = m_18.dataOut
    var55 := DontCare
    val buf_19 = Module(new ElasticBuffer())
    val var56 = buf_19.dataIn
    var56 := DontCare
    val var57 = buf_19.dataOut
    var57 := DontCare
    val b_20 = Module(new Branch())
    val var58 = b_20.condition
    var58 := DontCare
    val var59 = b_20.dataIn
    var59 := DontCare
    val var60 = b_20.dataOut apply 0
    var60 := DontCare
    val var61 = b_20.dataOut apply 1
    var61 := DontCare
    val m_21 = Module(new Merge()())
    val var62 = m_21.dataIn apply 0
    var62 := DontCare
    val var63 = m_21.dataIn apply 1
    var63 := DontCare
    val var64 = m_21.dataOut
    var64 := DontCare
    val buf_22 = Module(new ElasticBuffer())
    val var65 = buf_22.dataIn
    var65 := DontCare
    val var66 = buf_22.dataOut
    var66 := DontCare
    val b_23 = Module(new Branch())
    val var67 = b_23.condition
    var67 := DontCare
    val var68 = b_23.dataIn
    var68 := DontCare
    val var69 = b_23.dataOut apply 0
    var69 := DontCare
    val var70 = b_23.dataOut apply 1
    var70 := DontCare
    val m_24 = Module(new Merge()())
    val var71 = m_24.dataIn apply 0
    var71 := DontCare
    val var72 = m_24.dataIn apply 1
    var72 := DontCare
    val var73 = m_24.dataOut
    var73 := DontCare
    val buf_25 = Module(new ElasticBuffer())
    val var74 = buf_25.dataIn
    var74 := DontCare
    val var75 = buf_25.dataOut
    var75 := DontCare
    val b_26 = Module(new Branch())
    val var76 = b_26.condition
    var76 := DontCare
    val var77 = b_26.dataIn
    var77 := DontCare
    val var78 = b_26.dataOut apply 0
    var78 := DontCare
    val var79 = b_26.dataOut apply 1
    var79 := DontCare
    val addi_27 = Module(new AddIDynamic())
    val var80 = addi_27.operand0
    var80 := DontCare
    val var81 = addi_27.operand1
    var81 := DontCare
    val var82 = addi_27.result
    var82 := DontCare
    val subi_28 = Module(new SubIDynamic())
    val var83 = subi_28.operand0
    var83 := DontCare
    val var84 = subi_28.operand1
    var84 := DontCare
    val var85 = subi_28.result
    var85 := DontCare
    val addi_29 = Module(new AddIDynamic())
    val var86 = addi_29.operand0
    var86 := DontCare
    val var87 = addi_29.operand1
    var87 := DontCare
    val var88 = addi_29.result
    var88 := DontCare
    val load_30 = Module(new Load(1666, 64))
    val var89 = load_30.address_in
    var89 := DontCare
    val var90 = load_30.data_out
    var90 := DontCare
    val var91 = load_30.address_out
    var91 := DontCare
    val var92 = load_30.data_in
    var92 := DontCare
    val load_31 = Module(new Load(1666, 32))
    val var93 = load_31.address_in
    var93 := DontCare
    val var94 = load_31.data_out
    var94 := DontCare
    val var95 = load_31.address_out
    var95 := DontCare
    val var96 = load_31.data_in
    var96 := DontCare
    val load_32 = Module(new Load(494, 64))
    val var97 = load_32.address_in
    var97 := DontCare
    val var98 = load_32.data_out
    var98 := DontCare
    val var99 = load_32.address_out
    var99 := DontCare
    val var100 = load_32.data_in
    var100 := DontCare
    val mulf_33 = Module(new MulFDynamic(6, 11, 53))
    val var101 = mulf_33.operand0
    var101 := DontCare
    val var102 = mulf_33.operand1
    var102 := DontCare
    val var103 = mulf_33.result
    var103 := DontCare
    val addf_34 = Module(new AddFDynamic(10, 11, 53))
    val var104 = addf_34.operand0
    var104 := DontCare
    val var105 = addf_34.operand1
    var105 := DontCare
    val var106 = addf_34.result
    var106 := DontCare
    val store_35 = Module(new Store(494, 64))
    val var107 = store_35.address_in
    var107 := DontCare
    val var108 = store_35.data_in
    var108 := DontCare
    val var109 = store_35.address_out
    var109 := DontCare
    val var110 = store_35.data_out
    var110 := DontCare
    val f_36 = Module(new Fork()(2))
    val var111 = f_36.dataIn
    var111 := DontCare
    val var112 = f_36.dataOut apply 0
    var112 := DontCare
    val var113 = f_36.dataOut apply 1
    var113 := DontCare
    val f_37 = Module(new Fork()(4))
    val var114 = f_37.dataIn
    var114 := DontCare
    val var115 = f_37.dataOut apply 0
    var115 := DontCare
    val var116 = f_37.dataOut apply 1
    var116 := DontCare
    val var117 = f_37.dataOut apply 2
    var117 := DontCare
    val var118 = f_37.dataOut apply 3
    var118 := DontCare
    val f_38 = Module(new Fork()(2))
    val var119 = f_38.dataIn
    var119 := DontCare
    val var120 = f_38.dataOut apply 0
    var120 := DontCare
    val var121 = f_38.dataOut apply 1
    var121 := DontCare
    val f_39 = Module(new Fork()(4))
    val var122 = f_39.dataIn
    var122 := DontCare
    val var123 = f_39.dataOut apply 0
    var123 := DontCare
    val var124 = f_39.dataOut apply 1
    var124 := DontCare
    val var125 = f_39.dataOut apply 2
    var125 := DontCare
    val var126 = f_39.dataOut apply 3
    var126 := DontCare
    val f_40 = Module(new Fork()(2))
    val var127 = f_40.dataIn
    var127 := DontCare
    val var128 = f_40.dataOut apply 0
    var128 := DontCare
    val var129 = f_40.dataOut apply 1
    var129 := DontCare
    val f_41 = Module(new Fork()(3))
    val var130 = f_41.dataIn
    var130 := DontCare
    val var131 = f_41.dataOut apply 0
    var131 := DontCare
    val var132 = f_41.dataOut apply 1
    var132 := DontCare
    val var133 = f_41.dataOut apply 2
    var133 := DontCare
    val f_42 = Module(new Fork()(2))
    val var134 = f_42.dataIn
    var134 := DontCare
    val var135 = f_42.dataOut apply 0
    var135 := DontCare
    val var136 = f_42.dataOut apply 1
    var136 := DontCare
    val f_43 = Module(new Fork()(2))
    val var137 = f_43.dataIn
    var137 := DontCare
    val var138 = f_43.dataOut apply 0
    var138 := DontCare
    val var139 = f_43.dataOut apply 1
    var139 := DontCare
    val f_44 = Module(new Fork()(2))
    val var140 = f_44.dataIn
    var140 := DontCare
    val var141 = f_44.dataOut apply 0
    var141 := DontCare
    val var142 = f_44.dataOut apply 1
    var142 := DontCare
    var18 <> var17
    var15.bits := 0.U
    var15.valid := true.B
    var12 <> var113
    var13.bits := 493.U
    var13.valid := true.B
    var20 <> var14
    var21 <> var112
    var24 <> var118
    var25.bits := 1.U
    var25.valid := true.B
    var16 <> var26
    var27 <> var117
    var4 <> var29
    var30 <> var5
    var31 <> var116
    var32.bits := 1.U
    var32.valid := true.B
    var34 <> var33
    var6 <> var36
    var37 <> var7
    var38 <> var35
    var39.bits := 1.U
    var39.valid := true.B
    var51 <> var46
    var48 <> var52
    var47 <> var126
    var44.bits := 0.U
    var44.valid := true.B
    var56 <> var55
    var53 <> var40
    var58 <> var125
    var59 <> var129
    var54 <> var60
    var65 <> var64
    var62 <> var121
    var67 <> var124
    var68 <> var133
    var63 <> var69
    var74 <> var73
    var71 <> var120
    var41 <> var136
    var42 <> var128
    var76 <> var123
    var77 <> var135
    var80 <> var139
    var81.bits := 1.U
    var81.valid := true.B
    var72 <> var82
    var83 <> var138
    var84 <> var132
    var86 <> var85
    var87 <> var131
    var89 <> var142
    var0 <> var91
    var92 <> var1
    var93 <> var141
    var2 <> var95
    var96 <> var3
    var97 <> var94
    var8 <> var99
    var100 <> var9
    var101 <> var90
    var102 <> var98
    var104 <> var49
    var105 <> var103
    var45 <> var106
    var107 <> var115
    var108 <> var50
    var10 <> var109
    var11 <> var110
    var111 <> var19
    var114 <> var22
    var119 <> var28
    var122 <> var43
    var127 <> var57
    var130 <> var66
    var134 <> var75
    var137 <> var78
    var140 <> var88
    var23.ready := true.B
    var61.ready := true.B
    var70.ready := true.B
    var79.ready := true.B
    val temp_reg = RegInit(true.B)
    var15.valid := temp_reg
    when(var15.ready) {
      temp_reg := false.B
    }
    mem_0.initMem("mem_0.txt")
    mem_1.initMem("mem_1.txt")
    mem_2.initMem("mem_2.txt")
    mem_3.initMem("mem_3.txt")
    mem_0.finish := DontCare
    mem_0.read_address := DontCare
    mem_1.finish := DontCare
    mem_1.read_address := DontCare
    mem_2.finish := DontCare
    mem_2.read_address := DontCare
    mem_3.finish := DontCare
    mem_3.read_address := DontCare
    val finish = IO(Input(Bool()))
    mem_4.finish := finish
    val test_addr = IO(Input(UInt(9.W)))
    mem_4.read_address := test_addr
    val test_data = IO(Output(UInt(64.W)))
    test_data := mem_4.out_data
  }

  val main = Module(new main)
  val finish = IO(Input(Bool()))
  main.finish := finish
  val test_addr = IO(Input(UInt(9.W)))
  main.test_addr := test_addr
  val test_data = IO(Output(UInt(64.W)))
  test_data := main.test_data
}
