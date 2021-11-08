import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class spmv extends MultiIOModule {
  val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
  val var1 = IO(DecoupledIO(UInt(0.W)))
  var1 := DontCare
  val mem_0 = Module(new DynMem(1,0)(1666,64))
  val var2 = mem_0.load_address apply 0
  var2 := DontCare
  val var3 = mem_0.load_data apply 0
  var3 := DontCare
  val mem_1 = Module(new DynMem(1,0)(1666,32))
  val var4 = mem_1.load_address apply 0
  var4 := DontCare
  val var5 = mem_1.load_data apply 0
  var5 := DontCare
  val mem_2 = Module(new DynMem(2,0)(495,32))
  val var6 = mem_2.load_address apply 0
  var6 := DontCare
  val var7 = mem_2.load_data apply 0
  var7 := DontCare
  val var8 = mem_2.load_address apply 1
  var8 := DontCare
  val var9 = mem_2.load_data apply 1
  var9 := DontCare
  val mem_3 = Module(new DynMem(1,0)(494,64))
  val var10 = mem_3.load_address apply 0
  var10 := DontCare
  val var11 = mem_3.load_data apply 0
  var11 := DontCare
  val mem_4 = Module(new DynMem(0,1)(494,64))
  val var12 = mem_4.store_address apply 0
  var12 := DontCare
  val var13 = mem_4.store_data apply 0
  var13 := DontCare
  val cmpi_sle_5 = Module(new LessEqualthanIDynamic(32))
  val var14 = cmpi_sle_5.operand0
  var14 := DontCare
  val var15 = cmpi_sle_5.operand1
  var15 := DontCare
  val var16 = cmpi_sle_5.result
  var16 := DontCare
  val const_6 = Module(new Constant(32))
  val var17 = const_6.control
  var17 := DontCare
  val var18 = const_6.dataIn
  var18 := DontCare
  val var19 = const_6.dataOut
  var19 := DontCare
  val m_7 = Module(new Merge(0)())
  val var20 = m_7.dataIn apply 0
  var20 := DontCare
  val var21 = m_7.dataIn apply 1
  var21 := DontCare
  val var22 = m_7.dataOut
  var22 := DontCare
  val buf_8 = Module(new ElasticBuffer(0))
  val var23 = buf_8.dataIn
  var23 := DontCare
  val var24 = buf_8.dataOut
  var24 := DontCare
  val b_9 = Module(new Branch(0))
  val var25 = b_9.condition
  var25 := DontCare
  val var26 = b_9.dataIn
  var26 := DontCare
  val var27 = b_9.dataOut apply 0
  var27 := DontCare
  val var28 = b_9.dataOut apply 1
  var28 := DontCare
  val m_10 = Module(new Merge(32)())
  val var29 = m_10.dataIn apply 0
  var29 := DontCare
  val var30 = m_10.dataIn apply 1
  var30 := DontCare
  val var31 = m_10.dataOut
  var31 := DontCare
  val buf_11 = Module(new ElasticBuffer(32))
  val var32 = buf_11.dataIn
  var32 := DontCare
  val var33 = buf_11.dataOut
  var33 := DontCare
  val const_12 = Module(new Constant(32))
  val var34 = const_12.control
  var34 := DontCare
  val var35 = const_12.dataIn
  var35 := DontCare
  val var36 = const_12.dataOut
  var36 := DontCare
  val b_13 = Module(new Branch(32))
  val var37 = b_13.condition
  var37 := DontCare
  val var38 = b_13.dataIn
  var38 := DontCare
  val var39 = b_13.dataOut apply 0
  var39 := DontCare
  val var40 = b_13.dataOut apply 1
  var40 := DontCare
  val m_14 = Module(new Merge(32)())
  val var41 = m_14.dataIn apply 0
  var41 := DontCare
  val var42 = m_14.dataIn apply 1
  var42 := DontCare
  val var43 = m_14.dataOut
  var43 := DontCare
  val buf_15 = Module(new ElasticBuffer(32))
  val var44 = buf_15.dataIn
  var44 := DontCare
  val var45 = buf_15.dataOut
  var45 := DontCare
  val b_16 = Module(new Branch(32))
  val var46 = b_16.condition
  var46 := DontCare
  val var47 = b_16.dataIn
  var47 := DontCare
  val var48 = b_16.dataOut apply 0
  var48 := DontCare
  val var49 = b_16.dataOut apply 1
  var49 := DontCare
  val m_17 = Module(new Merge(32)())
  val var50 = m_17.dataIn apply 0
  var50 := DontCare
  val var51 = m_17.dataIn apply 1
  var51 := DontCare
  val var52 = m_17.dataOut
  var52 := DontCare
  val buf_18 = Module(new ElasticBuffer(32))
  val var53 = buf_18.dataIn
  var53 := DontCare
  val var54 = buf_18.dataOut
  var54 := DontCare
  val const_19 = Module(new Constant(32))
  val var55 = const_19.control
  var55 := DontCare
  val var56 = const_19.dataIn
  var56 := DontCare
  val var57 = const_19.dataOut
  var57 := DontCare
  val b_20 = Module(new Branch(32))
  val var58 = b_20.condition
  var58 := DontCare
  val var59 = b_20.dataIn
  var59 := DontCare
  val var60 = b_20.dataOut apply 0
  var60 := DontCare
  val var61 = b_20.dataOut apply 1
  var61 := DontCare
  val m_21 = Module(new Merge(32)())
  val var62 = m_21.dataIn apply 0
  var62 := DontCare
  val var63 = m_21.dataIn apply 1
  var63 := DontCare
  val var64 = m_21.dataOut
  var64 := DontCare
  val buf_22 = Module(new ElasticBuffer(32))
  val var65 = buf_22.dataIn
  var65 := DontCare
  val var66 = buf_22.dataOut
  var66 := DontCare
  val b_23 = Module(new Branch(32))
  val var67 = b_23.condition
  var67 := DontCare
  val var68 = b_23.dataIn
  var68 := DontCare
  val var69 = b_23.dataOut apply 0
  var69 := DontCare
  val var70 = b_23.dataOut apply 1
  var70 := DontCare
  val addi_24 = Module(new AddIDynamic(32))
  val var71 = addi_24.operand0
  var71 := DontCare
  val var72 = addi_24.operand1
  var72 := DontCare
  val var73 = addi_24.result
  var73 := DontCare
  val load_25 = Module(new Load(495,32))
  val var74 = load_25.address_in
  var74 := DontCare
  val var75 = load_25.data_out
  var75 := DontCare
  val var76 = load_25.address_out
  var76 := DontCare
  val var77 = load_25.data_in
  var77 := DontCare
  val addi_26 = Module(new AddIDynamic(32))
  val var78 = addi_26.operand0
  var78 := DontCare
  val var79 = addi_26.operand1
  var79 := DontCare
  val var80 = addi_26.result
  var80 := DontCare
  val const_27 = Module(new Constant(32))
  val var81 = const_27.control
  var81 := DontCare
  val var82 = const_27.dataIn
  var82 := DontCare
  val var83 = const_27.dataOut
  var83 := DontCare
  val load_28 = Module(new Load(495,32))
  val var84 = load_28.address_in
  var84 := DontCare
  val var85 = load_28.data_out
  var85 := DontCare
  val var86 = load_28.address_out
  var86 := DontCare
  val var87 = load_28.data_in
  var87 := DontCare
  val subi_29 = Module(new SubIDynamic(32))
  val var88 = subi_29.operand0
  var88 := DontCare
  val var89 = subi_29.operand1
  var89 := DontCare
  val var90 = subi_29.result
  var90 := DontCare
  val const_30 = Module(new Constant(32))
  val var91 = const_30.control
  var91 := DontCare
  val var92 = const_30.dataIn
  var92 := DontCare
  val var93 = const_30.dataOut
  var93 := DontCare
  val cmpi_sle_31 = Module(new LessEqualthanIDynamic(32))
  val var94 = cmpi_sle_31.operand0
  var94 := DontCare
  val var95 = cmpi_sle_31.operand1
  var95 := DontCare
  val var96 = cmpi_sle_31.result
  var96 := DontCare
  val m_32 = Module(new Merge(64)())
  val var97 = m_32.dataIn apply 0
  var97 := DontCare
  val var98 = m_32.dataIn apply 1
  var98 := DontCare
  val var99 = m_32.dataOut
  var99 := DontCare
  val b_33 = Module(new Branch(64))
  val var100 = b_33.condition
  var100 := DontCare
  val var101 = b_33.dataIn
  var101 := DontCare
  val var102 = b_33.dataOut apply 0
  var102 := DontCare
  val var103 = b_33.dataOut apply 1
  var103 := DontCare
  val buf_34 = Module(new ElasticBuffer(64))
  val var104 = buf_34.dataIn
  var104 := DontCare
  val var105 = buf_34.dataOut
  var105 := DontCare
  val const_35 = Module(new Constant(64))
  val var106 = const_35.control
  var106 := DontCare
  val var107 = const_35.dataIn
  var107 := DontCare
  val var108 = const_35.dataOut
  var108 := DontCare
  val m_36 = Module(new Merge(0)())
  val var109 = m_36.dataIn apply 0
  var109 := DontCare
  val var110 = m_36.dataIn apply 1
  var110 := DontCare
  val var111 = m_36.dataOut
  var111 := DontCare
  val buf_37 = Module(new ElasticBuffer(0))
  val var112 = buf_37.dataIn
  var112 := DontCare
  val var113 = buf_37.dataOut
  var113 := DontCare
  val b_38 = Module(new Branch(0))
  val var114 = b_38.condition
  var114 := DontCare
  val var115 = b_38.dataIn
  var115 := DontCare
  val var116 = b_38.dataOut apply 0
  var116 := DontCare
  val var117 = b_38.dataOut apply 1
  var117 := DontCare
  val m_39 = Module(new Merge(32)())
  val var118 = m_39.dataIn apply 0
  var118 := DontCare
  val var119 = m_39.dataIn apply 1
  var119 := DontCare
  val var120 = m_39.dataOut
  var120 := DontCare
  val buf_40 = Module(new ElasticBuffer(32))
  val var121 = buf_40.dataIn
  var121 := DontCare
  val var122 = buf_40.dataOut
  var122 := DontCare
  val b_41 = Module(new Branch(32))
  val var123 = b_41.condition
  var123 := DontCare
  val var124 = b_41.dataIn
  var124 := DontCare
  val var125 = b_41.dataOut apply 0
  var125 := DontCare
  val var126 = b_41.dataOut apply 1
  var126 := DontCare
  val m_42 = Module(new Merge(32)())
  val var127 = m_42.dataIn apply 0
  var127 := DontCare
  val var128 = m_42.dataIn apply 1
  var128 := DontCare
  val var129 = m_42.dataOut
  var129 := DontCare
  val buf_43 = Module(new ElasticBuffer(32))
  val var130 = buf_43.dataIn
  var130 := DontCare
  val var131 = buf_43.dataOut
  var131 := DontCare
  val const_44 = Module(new Constant(32))
  val var132 = const_44.control
  var132 := DontCare
  val var133 = const_44.dataIn
  var133 := DontCare
  val var134 = const_44.dataOut
  var134 := DontCare
  val b_45 = Module(new Branch(32))
  val var135 = b_45.condition
  var135 := DontCare
  val var136 = b_45.dataIn
  var136 := DontCare
  val var137 = b_45.dataOut apply 0
  var137 := DontCare
  val var138 = b_45.dataOut apply 1
  var138 := DontCare
  val m_46 = Module(new Merge(64)())
  val var139 = m_46.dataIn apply 0
  var139 := DontCare
  val var140 = m_46.dataIn apply 1
  var140 := DontCare
  val var141 = m_46.dataOut
  var141 := DontCare
  val buf_47 = Module(new ElasticBuffer(64))
  val var142 = buf_47.dataIn
  var142 := DontCare
  val var143 = buf_47.dataOut
  var143 := DontCare
  val b_48 = Module(new Branch(64))
  val var144 = b_48.condition
  var144 := DontCare
  val var145 = b_48.dataIn
  var145 := DontCare
  val var146 = b_48.dataOut apply 0
  var146 := DontCare
  val var147 = b_48.dataOut apply 1
  var147 := DontCare
  val m_49 = Module(new Merge(32)())
  val var148 = m_49.dataIn apply 0
  var148 := DontCare
  val var149 = m_49.dataIn apply 1
  var149 := DontCare
  val var150 = m_49.dataOut
  var150 := DontCare
  val buf_50 = Module(new ElasticBuffer(32))
  val var151 = buf_50.dataIn
  var151 := DontCare
  val var152 = buf_50.dataOut
  var152 := DontCare
  val b_51 = Module(new Branch(32))
  val var153 = b_51.condition
  var153 := DontCare
  val var154 = b_51.dataIn
  var154 := DontCare
  val var155 = b_51.dataOut apply 0
  var155 := DontCare
  val var156 = b_51.dataOut apply 1
  var156 := DontCare
  val m_52 = Module(new Merge(32)())
  val var157 = m_52.dataIn apply 0
  var157 := DontCare
  val var158 = m_52.dataIn apply 1
  var158 := DontCare
  val var159 = m_52.dataOut
  var159 := DontCare
  val buf_53 = Module(new ElasticBuffer(32))
  val var160 = buf_53.dataIn
  var160 := DontCare
  val var161 = buf_53.dataOut
  var161 := DontCare
  val b_54 = Module(new Branch(32))
  val var162 = b_54.condition
  var162 := DontCare
  val var163 = b_54.dataIn
  var163 := DontCare
  val var164 = b_54.dataOut apply 0
  var164 := DontCare
  val var165 = b_54.dataOut apply 1
  var165 := DontCare
  val addi_55 = Module(new AddIDynamic(32))
  val var166 = addi_55.operand0
  var166 := DontCare
  val var167 = addi_55.operand1
  var167 := DontCare
  val var168 = addi_55.result
  var168 := DontCare
  val subi_56 = Module(new SubIDynamic(32))
  val var169 = subi_56.operand0
  var169 := DontCare
  val var170 = subi_56.operand1
  var170 := DontCare
  val var171 = subi_56.result
  var171 := DontCare
  val addi_57 = Module(new AddIDynamic(32))
  val var172 = addi_57.operand0
  var172 := DontCare
  val var173 = addi_57.operand1
  var173 := DontCare
  val var174 = addi_57.result
  var174 := DontCare
  val load_58 = Module(new Load(1666,64))
  val var175 = load_58.address_in
  var175 := DontCare
  val var176 = load_58.data_out
  var176 := DontCare
  val var177 = load_58.address_out
  var177 := DontCare
  val var178 = load_58.data_in
  var178 := DontCare
  val load_59 = Module(new Load(1666,32))
  val var179 = load_59.address_in
  var179 := DontCare
  val var180 = load_59.data_out
  var180 := DontCare
  val var181 = load_59.address_out
  var181 := DontCare
  val var182 = load_59.data_in
  var182 := DontCare
  val load_60 = Module(new Load(494,64))
  val var183 = load_60.address_in
  var183 := DontCare
  val var184 = load_60.data_out
  var184 := DontCare
  val var185 = load_60.address_out
  var185 := DontCare
  val var186 = load_60.data_in
  var186 := DontCare
  val mulf_61 = Module(new MulFDynamic(6, 11, 53))
  val var187 = mulf_61.operand0
  var187 := DontCare
  val var188 = mulf_61.operand1
  var188 := DontCare
  val var189 = mulf_61.result
  var189 := DontCare
  val addf_62 = Module(new AddFDynamic(10, 11, 53))
  val var190 = addf_62.operand0
  var190 := DontCare
  val var191 = addf_62.operand1
  var191 := DontCare
  val var192 = addf_62.result
  var192 := DontCare
  val store_63 = Module(new Store(494,64))
  val var193 = store_63.address_in
  var193 := DontCare
  val var194 = store_63.data_in
  var194 := DontCare
  val var195 = store_63.address_out
  var195 := DontCare
  val var196 = store_63.data_out
  var196 := DontCare
  val f_64 = Module(new Fork(1)(5))
  val var197 = f_64.dataIn
  var197 := DontCare
  val var198 = f_64.dataOut apply 0
  var198 := DontCare
  val var199 = f_64.dataOut apply 1
  var199 := DontCare
  val var200 = f_64.dataOut apply 2
  var200 := DontCare
  val var201 = f_64.dataOut apply 3
  var201 := DontCare
  val var202 = f_64.dataOut apply 4
  var202 := DontCare
  val f_65 = Module(new Fork(32)(2))
  val var203 = f_65.dataIn
  var203 := DontCare
  val var204 = f_65.dataOut apply 0
  var204 := DontCare
  val var205 = f_65.dataOut apply 1
  var205 := DontCare
  val f_66 = Module(new Fork(0)(6))
  val var206 = f_66.dataIn
  var206 := DontCare
  val var207 = f_66.dataOut apply 0
  var207 := DontCare
  val var208 = f_66.dataOut apply 1
  var208 := DontCare
  val var209 = f_66.dataOut apply 2
  var209 := DontCare
  val var210 = f_66.dataOut apply 3
  var210 := DontCare
  val var211 = f_66.dataOut apply 4
  var211 := DontCare
  val var212 = f_66.dataOut apply 5
  var212 := DontCare
  val f_67 = Module(new Fork(32)(2))
  val var213 = f_67.dataIn
  var213 := DontCare
  val var214 = f_67.dataOut apply 0
  var214 := DontCare
  val var215 = f_67.dataOut apply 1
  var215 := DontCare
  val f_68 = Module(new Fork(32)(2))
  val var216 = f_68.dataIn
  var216 := DontCare
  val var217 = f_68.dataOut apply 0
  var217 := DontCare
  val var218 = f_68.dataOut apply 1
  var218 := DontCare
  val f_69 = Module(new Fork(32)(2))
  val var219 = f_69.dataIn
  var219 := DontCare
  val var220 = f_69.dataOut apply 0
  var220 := DontCare
  val var221 = f_69.dataOut apply 1
  var221 := DontCare
  val f_70 = Module(new Fork(32)(4))
  val var222 = f_70.dataIn
  var222 := DontCare
  val var223 = f_70.dataOut apply 0
  var223 := DontCare
  val var224 = f_70.dataOut apply 1
  var224 := DontCare
  val var225 = f_70.dataOut apply 2
  var225 := DontCare
  val var226 = f_70.dataOut apply 3
  var226 := DontCare
  val f_71 = Module(new Fork(32)(2))
  val var227 = f_71.dataIn
  var227 := DontCare
  val var228 = f_71.dataOut apply 0
  var228 := DontCare
  val var229 = f_71.dataOut apply 1
  var229 := DontCare
  val f_72 = Module(new Fork(1)(7))
  val var230 = f_72.dataIn
  var230 := DontCare
  val var231 = f_72.dataOut apply 0
  var231 := DontCare
  val var232 = f_72.dataOut apply 1
  var232 := DontCare
  val var233 = f_72.dataOut apply 2
  var233 := DontCare
  val var234 = f_72.dataOut apply 3
  var234 := DontCare
  val var235 = f_72.dataOut apply 4
  var235 := DontCare
  val var236 = f_72.dataOut apply 5
  var236 := DontCare
  val var237 = f_72.dataOut apply 6
  var237 := DontCare
  val f_73 = Module(new Fork(64)(2))
  val var238 = f_73.dataIn
  var238 := DontCare
  val var239 = f_73.dataOut apply 0
  var239 := DontCare
  val var240 = f_73.dataOut apply 1
  var240 := DontCare
  val f_74 = Module(new Fork(32)(2))
  val var241 = f_74.dataIn
  var241 := DontCare
  val var242 = f_74.dataOut apply 0
  var242 := DontCare
  val var243 = f_74.dataOut apply 1
  var243 := DontCare
  val f_75 = Module(new Fork(32)(2))
  val var244 = f_75.dataIn
  var244 := DontCare
  val var245 = f_75.dataOut apply 0
  var245 := DontCare
  val var246 = f_75.dataOut apply 1
  var246 := DontCare
  val f_76 = Module(new Fork(32)(3))
  val var247 = f_76.dataIn
  var247 := DontCare
  val var248 = f_76.dataOut apply 0
  var248 := DontCare
  val var249 = f_76.dataOut apply 1
  var249 := DontCare
  val var250 = f_76.dataOut apply 2
  var250 := DontCare
  val f_77 = Module(new Fork(32)(2))
  val var251 = f_77.dataIn
  var251 := DontCare
  val var252 = f_77.dataOut apply 0
  var252 := DontCare
  val var253 = f_77.dataOut apply 1
  var253 := DontCare
  val f_78 = Module(new Fork(32)(2))
  val var254 = f_78.dataIn
  var254 := DontCare
  val var255 = f_78.dataOut apply 0
  var255 := DontCare
  val var256 = f_78.dataOut apply 1
  var256 := DontCare
  val f_79 = Module(new Fork(32)(2))
  val var257 = f_79.dataIn
  var257 := DontCare
  val var258 = f_79.dataOut apply 0
  var258 := DontCare
  val var259 = f_79.dataOut apply 1
  var259 := DontCare
  var17 <> var0
  var18.bits := 0.U
  var18.valid := true.B
  var23 <> var22
  var20 <> var0
  var25 <> var202
  var26 <> var24
  var21 <> var212
  var34 <> var0
  var35.bits := 493.U
  var35.valid := true.B
  var32 <> var31
  var29 <> var36
  var37 <> var201
  var38 <> var215
  var30 <> var39
  var44 <> var43
  var41 <> var205
  var46 <> var200
  var47 <> var45
  var42 <> var48
  var55 <> var0
  var56.bits := 1.U
  var56.valid := true.B
  var53 <> var52
  var50 <> var57
  var58 <> var199
  var59 <> var54
  var51 <> var218
  var65 <> var64
  var62 <> var204
  var14 <> var221
  var15 <> var214
  var67 <> var198
  var68 <> var220
  var71 <> var226
  var72 <> var217
  var63 <> var73
  var74 <> var225
  var6 <> var76
  var77 <> var7
  var78 <> var224
  var81 <> var211
  var82.bits := 1.U
  var82.valid := true.B
  var79 <> var83
  var84 <> var80
  var8 <> var86
  var87 <> var9
  var88 <> var85
  var91 <> var210
  var92.bits := 1.U
  var92.valid := true.B
  var89 <> var93
  var104 <> var99
  var101 <> var105
  var100 <> var237
  var106 <> var209
  var107.bits := 0.U
  var107.valid := true.B
  var97 <> var240
  var112 <> var111
  var109 <> var208
  var114 <> var236
  var115 <> var113
  var110 <> var116
  var121 <> var120
  var118 <> var90
  var123 <> var235
  var124 <> var243
  var119 <> var125
  var132 <> var207
  var133.bits := 1.U
  var133.valid := true.B
  var130 <> var129
  var127 <> var134
  var135 <> var234
  var136 <> var131
  var128 <> var246
  var142 <> var141
  var139 <> var239
  var144 <> var233
  var145 <> var143
  var140 <> var146
  var151 <> var150
  var148 <> var229
  var153 <> var232
  var154 <> var152
  var149 <> var250
  var160 <> var159
  var157 <> var228
  var94 <> var253
  var95 <> var242
  var162 <> var231
  var163 <> var252
  var166 <> var256
  var167 <> var245
  var158 <> var168
  var169 <> var255
  var170 <> var249
  var172 <> var171
  var173 <> var248
  var175 <> var259
  var2 <> var177
  var178 <> var3
  var179 <> var258
  var4 <> var181
  var182 <> var5
  var183 <> var180
  var10 <> var185
  var186 <> var11
  var187 <> var176
  var188 <> var184
  var190 <> var102
  var191 <> var189
  var98 <> var192
  var193 <> var223
  var194 <> var103
  var12 <> var195
  var13 <> var196
  var197 <> var16
  var203 <> var19
  var206 <> var27
  var213 <> var33
  var216 <> var60
  var219 <> var66
  var222 <> var69
  var227 <> var75
  var230 <> var96
  var238 <> var108
  var241 <> var122
  var244 <> var137
  var247 <> var155
  var251 <> var161
  var254 <> var164
  var257 <> var174
  var28.ready := true.B
  var40.ready := true.B
  var49.ready := true.B
  var61.ready := true.B
  var70.ready := true.B
  var117.ready := true.B
  var126.ready := true.B
  var138.ready := true.B
  var147.ready := true.B
  var156.ready := true.B
  var165.ready := true.B
  val finish = IO(Input(Bool()))
  mem_0.read_address := DontCare
  mem_0.finish := DontCare
  mem_1.read_address := DontCare
  mem_1.finish := DontCare
  mem_2.read_address := DontCare
  mem_2.finish := DontCare
  mem_3.read_address := DontCare
  mem_3.finish := DontCare
  mem_4.read_address := DontCare
  mem_4.finish := DontCare
  mem_4.finish := finish
  val mem_4_addr = IO(Input(UInt(log2Ceil(494).W)))
  mem_4.read_address := mem_4_addr
  val mem_4_data = IO(Output(UInt(64.W)))
  mem_4_data := mem_4.out_data
  mem_0.initMem("data_set/spmv_crs_kernel/mem_0.txt")
  mem_1.initMem("data_set/spmv_crs_kernel/mem_1.txt")
  mem_2.initMem("data_set/spmv_crs_kernel/mem_2.txt")
  mem_3.initMem("data_set/spmv_crs_kernel/mem_3.txt")
}

