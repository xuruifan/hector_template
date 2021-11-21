import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class aeloss_pull extends MultiIOModule {
	val var0 = IO(Flipped(DecoupledIO(UInt(0.W))))
	val var1 = IO(DecoupledIO(UInt(64.W)))
	var1 := DontCare
	val var2 = IO(DecoupledIO(UInt(0.W)))
	var2 := DontCare
	val mem_0 = Module(new DynMem(1,0)(1024,64))
	val var3 = mem_0.load_address apply 0
	var3 := DontCare
	val var4 = mem_0.load_data apply 0
	var4 := DontCare
	val mem_1 = Module(new DynMem(1,0)(1024,64))
	val var5 = mem_1.load_address apply 0
	var5 := DontCare
	val var6 = mem_1.load_data apply 0
	var6 := DontCare
	val mem_2 = Module(new DynMem(0,1)(1024,64))
	val var7 = mem_2.store_address apply 0
	var7 := DontCare
	val var8 = mem_2.store_data apply 0
	var8 := DontCare
	val mem_3 = Module(new DynMem(1,0)(1024,32))
	val var9 = mem_3.load_address apply 0
	var9 := DontCare
	val var10 = mem_3.load_data apply 0
	var10 := DontCare
	val cmpi_sle_4 = Module(new LessEqualthanIDynamic(32))
	val var11 = cmpi_sle_4.operand0
	var11 := DontCare
	val var12 = cmpi_sle_4.operand1
	var12 := DontCare
	val var13 = cmpi_sle_4.result
	var13 := DontCare
	val m_5 = Module(new Control_Merge(0))
	val var14 = m_5.dataIn apply 0
	var14 := DontCare
	val var15 = m_5.dataIn apply 1
	var15 := DontCare
	val var16 = m_5.dataOut
	var16 := DontCare
	val var17 = m_5.condition
	var17 := DontCare
	val buf_6 = Module(new ElasticBuffer(0))
	val var18 = buf_6.dataIn
	var18 := DontCare
	val var19 = buf_6.dataOut
	var19 := DontCare
	val b_7 = Module(new Branch(0))
	val var20 = b_7.condition
	var20 := DontCare
	val var21 = b_7.dataIn
	var21 := DontCare
	val var22 = b_7.dataOut apply 0
	var22 := DontCare
	val var23 = b_7.dataOut apply 1
	var23 := DontCare
	val m_8 = Module(new MuxDynamic(64)())
	val var24 = m_8.dataIn apply 0
	var24 := DontCare
	val var25 = m_8.dataIn apply 1
	var25 := DontCare
	val var26 = m_8.dataOut
	var26 := DontCare
	val var27 = m_8.condition
	var27 := DontCare
	val buf_9 = Module(new ElasticBuffer(64))
	val var28 = buf_9.dataIn
	var28 := DontCare
	val var29 = buf_9.dataOut
	var29 := DontCare
	val b_10 = Module(new Branch(64))
	val var30 = b_10.condition
	var30 := DontCare
	val var31 = b_10.dataIn
	var31 := DontCare
	val var32 = b_10.dataOut apply 0
	var32 := DontCare
	val var33 = b_10.dataOut apply 1
	var33 := DontCare
	val const_11 = Module(new Constant(64))
	val var34 = const_11.control
	var34 := DontCare
	val var35 = const_11.dataIn
	var35 := DontCare
	val var36 = const_11.dataOut
	var36 := DontCare
	val const_12 = Module(new Constant(32))
	val var37 = const_12.control
	var37 := DontCare
	val var38 = const_12.dataIn
	var38 := DontCare
	val var39 = const_12.dataOut
	var39 := DontCare
	val m_13 = Module(new MuxDynamic(32)())
	val var40 = m_13.dataIn apply 0
	var40 := DontCare
	val var41 = m_13.dataIn apply 1
	var41 := DontCare
	val var42 = m_13.dataOut
	var42 := DontCare
	val var43 = m_13.condition
	var43 := DontCare
	val buf_14 = Module(new ElasticBuffer(32))
	val var44 = buf_14.dataIn
	var44 := DontCare
	val var45 = buf_14.dataOut
	var45 := DontCare
	val b_15 = Module(new Branch(32))
	val var46 = b_15.condition
	var46 := DontCare
	val var47 = b_15.dataIn
	var47 := DontCare
	val var48 = b_15.dataOut apply 0
	var48 := DontCare
	val var49 = b_15.dataOut apply 1
	var49 := DontCare
	val const_16 = Module(new Constant(32))
	val var50 = const_16.control
	var50 := DontCare
	val var51 = const_16.dataIn
	var51 := DontCare
	val var52 = const_16.dataOut
	var52 := DontCare
	val m_17 = Module(new MuxDynamic(32)())
	val var53 = m_17.dataIn apply 0
	var53 := DontCare
	val var54 = m_17.dataIn apply 1
	var54 := DontCare
	val var55 = m_17.dataOut
	var55 := DontCare
	val var56 = m_17.condition
	var56 := DontCare
	val buf_18 = Module(new ElasticBuffer(32))
	val var57 = buf_18.dataIn
	var57 := DontCare
	val var58 = buf_18.dataOut
	var58 := DontCare
	val b_19 = Module(new Branch(32))
	val var59 = b_19.condition
	var59 := DontCare
	val var60 = b_19.dataIn
	var60 := DontCare
	val var61 = b_19.dataOut apply 0
	var61 := DontCare
	val var62 = b_19.dataOut apply 1
	var62 := DontCare
	val const_20 = Module(new Constant(32))
	val var63 = const_20.control
	var63 := DontCare
	val var64 = const_20.dataIn
	var64 := DontCare
	val var65 = const_20.dataOut
	var65 := DontCare
	val m_21 = Module(new MuxDynamic(32)())
	val var66 = m_21.dataIn apply 0
	var66 := DontCare
	val var67 = m_21.dataIn apply 1
	var67 := DontCare
	val var68 = m_21.dataOut
	var68 := DontCare
	val var69 = m_21.condition
	var69 := DontCare
	val buf_22 = Module(new ElasticBuffer(32))
	val var70 = buf_22.dataIn
	var70 := DontCare
	val var71 = buf_22.dataOut
	var71 := DontCare
	val b_23 = Module(new Branch(32))
	val var72 = b_23.condition
	var72 := DontCare
	val var73 = b_23.dataIn
	var73 := DontCare
	val var74 = b_23.dataOut apply 0
	var74 := DontCare
	val var75 = b_23.dataOut apply 1
	var75 := DontCare
	val addi_24 = Module(new AddIDynamic(32))
	val var76 = addi_24.operand0
	var76 := DontCare
	val var77 = addi_24.operand1
	var77 := DontCare
	val var78 = addi_24.result
	var78 := DontCare
	val load_25 = Module(new Load(1024,64))
	val var79 = load_25.address_in
	var79 := DontCare
	val var80 = load_25.data_out
	var80 := DontCare
	val var81 = load_25.address_out
	var81 := DontCare
	val var82 = load_25.data_in
	var82 := DontCare
	val var83 = load_25.control
	var83 := DontCare
	val load_26 = Module(new Load(1024,64))
	val var84 = load_26.address_in
	var84 := DontCare
	val var85 = load_26.data_out
	var85 := DontCare
	val var86 = load_26.address_out
	var86 := DontCare
	val var87 = load_26.data_in
	var87 := DontCare
	val var88 = load_26.control
	var88 := DontCare
	val addf_27 = Module(new AddFDynamic(13, 11, 53))
	val var89 = addf_27.operand0
	var89 := DontCare
	val var90 = addf_27.operand1
	var90 := DontCare
	val var91 = addf_27.result
	var91 := DontCare
	val mulf_28 = Module(new MulFDynamic(9, 11, 53))
	val var92 = mulf_28.operand0
	var92 := DontCare
	val var93 = mulf_28.operand1
	var93 := DontCare
	val var94 = mulf_28.result
	var94 := DontCare
	val const_29 = Module(new Constant(64))
	val var95 = const_29.control
	var95 := DontCare
	val var96 = const_29.dataIn
	var96 := DontCare
	val var97 = const_29.dataOut
	var97 := DontCare
	val store_30 = Module(new Store(1024,64))
	val var98 = store_30.address_in
	var98 := DontCare
	val var99 = store_30.data_in
	var99 := DontCare
	val var100 = store_30.address_out
	var100 := DontCare
	val var101 = store_30.data_out
	var101 := DontCare
	val var102 = store_30.control
	var102 := DontCare
	val subf_31 = Module(new SubFDynamic(13, 11, 53))
	val var103 = subf_31.operand0
	var103 := DontCare
	val var104 = subf_31.operand1
	var104 := DontCare
	val var105 = subf_31.result
	var105 := DontCare
	val subf_32 = Module(new SubFDynamic(13, 11, 53))
	val var106 = subf_32.operand0
	var106 := DontCare
	val var107 = subf_32.operand1
	var107 := DontCare
	val var108 = subf_32.result
	var108 := DontCare
	val mulf_33 = Module(new MulFDynamic(9, 11, 53))
	val var109 = mulf_33.operand0
	var109 := DontCare
	val var110 = mulf_33.operand1
	var110 := DontCare
	val var111 = mulf_33.result
	var111 := DontCare
	val mulf_34 = Module(new MulFDynamic(9, 11, 53))
	val var112 = mulf_34.operand0
	var112 := DontCare
	val var113 = mulf_34.operand1
	var113 := DontCare
	val var114 = mulf_34.result
	var114 := DontCare
	val addf_35 = Module(new AddFDynamic(13, 11, 53))
	val var115 = addf_35.operand0
	var115 := DontCare
	val var116 = addf_35.operand1
	var116 := DontCare
	val var117 = addf_35.result
	var117 := DontCare
	val mulf_36 = Module(new MulFDynamic(9, 11, 53))
	val var118 = mulf_36.operand0
	var118 := DontCare
	val var119 = mulf_36.operand1
	var119 := DontCare
	val var120 = mulf_36.result
	var120 := DontCare
	val const_37 = Module(new Constant(64))
	val var121 = const_37.control
	var121 := DontCare
	val var122 = const_37.dataIn
	var122 := DontCare
	val var123 = const_37.dataOut
	var123 := DontCare
	val load_38 = Module(new Load(1024,32))
	val var124 = load_38.address_in
	var124 := DontCare
	val var125 = load_38.data_out
	var125 := DontCare
	val var126 = load_38.address_out
	var126 := DontCare
	val var127 = load_38.data_in
	var127 := DontCare
	val var128 = load_38.control
	var128 := DontCare
	val trunci_39 = Module(new TruncIDynamic(32,1))
	val var129 = trunci_39.operand
	var129 := DontCare
	val var130 = trunci_39.result
	var130 := DontCare
	val b_40 = Module(new Branch(0))
	val var131 = b_40.condition
	var131 := DontCare
	val var132 = b_40.dataIn
	var132 := DontCare
	val var133 = b_40.dataOut apply 0
	var133 := DontCare
	val var134 = b_40.dataOut apply 1
	var134 := DontCare
	val b_41 = Module(new Branch(64))
	val var135 = b_41.condition
	var135 := DontCare
	val var136 = b_41.dataIn
	var136 := DontCare
	val var137 = b_41.dataOut apply 0
	var137 := DontCare
	val var138 = b_41.dataOut apply 1
	var138 := DontCare
	val b_42 = Module(new Branch(64))
	val var139 = b_42.condition
	var139 := DontCare
	val var140 = b_42.dataIn
	var140 := DontCare
	val var141 = b_42.dataOut apply 0
	var141 := DontCare
	val var142 = b_42.dataOut apply 1
	var142 := DontCare
	val m_43 = Module(new MuxDynamic(64)())
	val var143 = m_43.dataIn apply 0
	var143 := DontCare
	val var144 = m_43.dataIn apply 1
	var144 := DontCare
	val var145 = m_43.dataOut
	var145 := DontCare
	val var146 = m_43.condition
	var146 := DontCare
	val addf_44 = Module(new AddFDynamic(13, 11, 53))
	val var147 = addf_44.operand0
	var147 := DontCare
	val var148 = addf_44.operand1
	var148 := DontCare
	val var149 = addf_44.result
	var149 := DontCare
	val f_45 = Module(new Fork(1)(5))
	val var150 = f_45.dataIn
	var150 := DontCare
	val var151 = f_45.dataOut apply 0
	var151 := DontCare
	val var152 = f_45.dataOut apply 1
	var152 := DontCare
	val var153 = f_45.dataOut apply 2
	var153 := DontCare
	val var154 = f_45.dataOut apply 3
	var154 := DontCare
	val var155 = f_45.dataOut apply 4
	var155 := DontCare
	val f_46 = Module(new Fork(1)(4))
	val var156 = f_46.dataIn
	var156 := DontCare
	val var157 = f_46.dataOut apply 0
	var157 := DontCare
	val var158 = f_46.dataOut apply 1
	var158 := DontCare
	val var159 = f_46.dataOut apply 2
	var159 := DontCare
	val var160 = f_46.dataOut apply 3
	var160 := DontCare
	val f_47 = Module(new Fork(0)(8))
	val var161 = f_47.dataIn
	var161 := DontCare
	val var162 = f_47.dataOut apply 0
	var162 := DontCare
	val var163 = f_47.dataOut apply 1
	var163 := DontCare
	val var164 = f_47.dataOut apply 2
	var164 := DontCare
	val var165 = f_47.dataOut apply 3
	var165 := DontCare
	val var166 = f_47.dataOut apply 4
	var166 := DontCare
	val var167 = f_47.dataOut apply 5
	var167 := DontCare
	val var168 = f_47.dataOut apply 6
	var168 := DontCare
	val var169 = f_47.dataOut apply 7
	var169 := DontCare
	val f_48 = Module(new Fork(32)(2))
	val var170 = f_48.dataIn
	var170 := DontCare
	val var171 = f_48.dataOut apply 0
	var171 := DontCare
	val var172 = f_48.dataOut apply 1
	var172 := DontCare
	val f_49 = Module(new Fork(32)(2))
	val var173 = f_49.dataIn
	var173 := DontCare
	val var174 = f_49.dataOut apply 0
	var174 := DontCare
	val var175 = f_49.dataOut apply 1
	var175 := DontCare
	val f_50 = Module(new Fork(32)(2))
	val var176 = f_50.dataIn
	var176 := DontCare
	val var177 = f_50.dataOut apply 0
	var177 := DontCare
	val var178 = f_50.dataOut apply 1
	var178 := DontCare
	val f_51 = Module(new Fork(32)(5))
	val var179 = f_51.dataIn
	var179 := DontCare
	val var180 = f_51.dataOut apply 0
	var180 := DontCare
	val var181 = f_51.dataOut apply 1
	var181 := DontCare
	val var182 = f_51.dataOut apply 2
	var182 := DontCare
	val var183 = f_51.dataOut apply 3
	var183 := DontCare
	val var184 = f_51.dataOut apply 4
	var184 := DontCare
	val f_52 = Module(new Fork(64)(2))
	val var185 = f_52.dataIn
	var185 := DontCare
	val var186 = f_52.dataOut apply 0
	var186 := DontCare
	val var187 = f_52.dataOut apply 1
	var187 := DontCare
	val f_53 = Module(new Fork(64)(2))
	val var188 = f_53.dataIn
	var188 := DontCare
	val var189 = f_53.dataOut apply 0
	var189 := DontCare
	val var190 = f_53.dataOut apply 1
	var190 := DontCare
	val f_54 = Module(new Fork(64)(3))
	val var191 = f_54.dataIn
	var191 := DontCare
	val var192 = f_54.dataOut apply 0
	var192 := DontCare
	val var193 = f_54.dataOut apply 1
	var193 := DontCare
	val var194 = f_54.dataOut apply 2
	var194 := DontCare
	val f_55 = Module(new Fork(64)(2))
	val var195 = f_55.dataIn
	var195 := DontCare
	val var196 = f_55.dataOut apply 0
	var196 := DontCare
	val var197 = f_55.dataOut apply 1
	var197 := DontCare
	val f_56 = Module(new Fork(64)(2))
	val var198 = f_56.dataIn
	var198 := DontCare
	val var199 = f_56.dataOut apply 0
	var199 := DontCare
	val var200 = f_56.dataOut apply 1
	var200 := DontCare
	val f_57 = Module(new Fork(1)(4))
	val var201 = f_57.dataIn
	var201 := DontCare
	val var202 = f_57.dataOut apply 0
	var202 := DontCare
	val var203 = f_57.dataOut apply 1
	var203 := DontCare
	val var204 = f_57.dataOut apply 2
	var204 := DontCare
	val var205 = f_57.dataOut apply 3
	var205 := DontCare
	val fifo_58 = Module(new ElasticFIFO(13,64))
	val var206 = fifo_58.dataIn
	var206 := DontCare
	val var207 = fifo_58.dataOut
	var207 := DontCare
	val fifo_59 = Module(new ElasticFIFO(13,64))
	val var208 = fifo_59.dataIn
	var208 := DontCare
	val var209 = fifo_59.dataOut
	var209 := DontCare
	val fifo_60 = Module(new ElasticFIFO(79,64))
	val var210 = fifo_60.dataIn
	var210 := DontCare
	val var211 = fifo_60.dataOut
	var211 := DontCare
	val fifo_61 = Module(new ElasticFIFO(13,64))
	val var212 = fifo_61.dataIn
	var212 := DontCare
	val var213 = fifo_61.dataOut
	var213 := DontCare
	val fifo_62 = Module(new ElasticFIFO(35,64))
	val var214 = fifo_62.dataIn
	var214 := DontCare
	val var215 = fifo_62.dataOut
	var215 := DontCare
	val fifo_63 = Module(new ElasticFIFO(13,64))
	val var216 = fifo_63.dataIn
	var216 := DontCare
	val var217 = fifo_63.dataOut
	var217 := DontCare
	val fifo_64 = Module(new ElasticFIFO(22,32))
	val var218 = fifo_64.dataIn
	var218 := DontCare
	val var219 = fifo_64.dataOut
	var219 := DontCare
	val fifo_65 = Module(new ElasticFIFO(22,0))
	val var220 = fifo_65.dataIn
	var220 := DontCare
	val var221 = fifo_65.dataOut
	var221 := DontCare
	val fifo_66 = Module(new ElasticFIFO(9,64))
	val var222 = fifo_66.dataIn
	var222 := DontCare
	val var223 = fifo_66.dataOut
	var223 := DontCare
	val fifo_67 = Module(new ElasticFIFO(22,64))
	val var224 = fifo_67.dataIn
	var224 := DontCare
	val var225 = fifo_67.dataOut
	var225 := DontCare
	val fifo_68 = Module(new ElasticFIFO(9,64))
	val var226 = fifo_68.dataIn
	var226 := DontCare
	val var227 = fifo_68.dataOut
	var227 := DontCare
	val fifo_69 = Module(new ElasticFIFO(9,64))
	val var228 = fifo_69.dataIn
	var228 := DontCare
	val var229 = fifo_69.dataOut
	var229 := DontCare
	val fifo_70 = Module(new ElasticFIFO(13,64))
	val var230 = fifo_70.dataIn
	var230 := DontCare
	val var231 = fifo_70.dataOut
	var231 := DontCare
	val fifo_71 = Module(new ElasticFIFO(13,64))
	val var232 = fifo_71.dataIn
	var232 := DontCare
	val var233 = fifo_71.dataOut
	var233 := DontCare
	val fifo_72 = Module(new ElasticFIFO(9,64))
	val var234 = fifo_72.dataIn
	var234 := DontCare
	val var235 = fifo_72.dataOut
	var235 := DontCare
	val fifo_73 = Module(new ElasticFIFO(9,64))
	val var236 = fifo_73.dataIn
	var236 := DontCare
	val var237 = fifo_73.dataOut
	var237 := DontCare
	val fifo_74 = Module(new ElasticFIFO(35,64))
	val var238 = fifo_74.dataIn
	var238 := DontCare
	val var239 = fifo_74.dataOut
	var239 := DontCare
	val fifo_75 = Module(new ElasticFIFO(13,64))
	val var240 = fifo_75.dataIn
	var240 := DontCare
	val var241 = fifo_75.dataOut
	var241 := DontCare
	val fifo_76 = Module(new ElasticFIFO(9,64))
	val var242 = fifo_76.dataIn
	var242 := DontCare
	val var243 = fifo_76.dataOut
	var243 := DontCare
	val fifo_77 = Module(new ElasticFIFO(66,64))
	val var244 = fifo_77.dataIn
	var244 := DontCare
	val var245 = fifo_77.dataOut
	var245 := DontCare
	val fifo_78 = Module(new ElasticFIFO(66,1))
	val var246 = fifo_78.dataIn
	var246 := DontCare
	val var247 = fifo_78.dataOut
	var247 := DontCare
	var21 <> var19
	var18 <> var16
	var20 <> var155
	var14 <> var0
	var31 <> var29
	var28 <> var26
	var30 <> var154
	var34 <> var0
	var35.bits := 0L.U
	var35.valid := true.B
	var24 <> var36
	var27 <> var160
	var37 <> var0
	var38.bits := 0.U
	var38.valid := true.B
	var47 <> var172
	var44 <> var42
	var46 <> var153
	var50 <> var0
	var51.bits := 1024.U
	var51.valid := true.B
	var40 <> var52
	var41 <> var48
	var43 <> var159
	var60 <> var58
	var57 <> var55
	var59 <> var152
	var63 <> var0
	var64.bits := 1.U
	var64.valid := true.B
	var53 <> var65
	var54 <> var175
	var56 <> var158
	var70 <> var68
	var66 <> var39
	var11 <> var178
	var12 <> var171
	var72 <> var151
	var73 <> var177
	var76 <> var184
	var77 <> var174
	var67 <> var78
	var69 <> var157
	var79 <> var183
	var83 <> var169
	var3 <> var81
	var82 <> var4
	var84 <> var182
	var88 <> var168
	var5 <> var86
	var87 <> var6
	var95 <> var167
	var96.bits := 4602678819172646912L.U
	var96.valid := true.B
	var99 <> var194
	var7 <> var100
	var8 <> var101
	var121 <> var165
	var122.bits := 4591705420666420376L.U
	var122.valid := true.B
	var124 <> var180
	var128 <> var164
	var9 <> var126
	var127 <> var10
	var129 <> var125
	var131 <> var205
	var132 <> var163
	var135 <> var204
	var136 <> var32
	var140 <> var120
	var146 <> var202
	var144 <> var149
	var143 <> var138
	var25 <> var145
	var15 <> var162
	var1 <> var33
	var150 <> var13
	var156 <> var17
	var161 <> var22
	var170 <> var45
	var173 <> var61
	var176 <> var71
	var179 <> var74
	var185 <> var80
	var188 <> var85
	var191 <> var94
	var195 <> var105
	var198 <> var108
	var201 <> var130
	var206 <> var187
	var89 <> var207
	var208 <> var190
	var90 <> var209
	var210 <> var137
	var147 <> var211
	var212 <> var141
	var148 <> var213
	var214 <> var186
	var103 <> var215
	var216 <> var193
	var104 <> var217
	var218 <> var181
	var98 <> var219
	var220 <> var166
	var102 <> var221
	var222 <> var91
	var92 <> var223
	var224 <> var97
	var93 <> var225
	var226 <> var200
	var112 <> var227
	var228 <> var199
	var113 <> var229
	var230 <> var111
	var115 <> var231
	var232 <> var114
	var116 <> var233
	var234 <> var197
	var109 <> var235
	var236 <> var196
	var110 <> var237
	var238 <> var189
	var106 <> var239
	var240 <> var192
	var107 <> var241
	var242 <> var117
	var118 <> var243
	var244 <> var123
	var119 <> var245
	var246 <> var203
	var139 <> var247
	var23.ready := true.B
	var49.ready := true.B
	var62.ready := true.B
	var75.ready := true.B
	var133.ready := true.B
	var134.ready := true.B
	var142.ready := true.B
	val finish = IO(Input(Bool()))
	mem_0.read_address := DontCare
	mem_0.finish := DontCare
	mem_1.read_address := DontCare
	mem_1.finish := DontCare
	mem_2.read_address := DontCare
	mem_2.finish := DontCare
	mem_2.finish := finish
	val mem_2_addr = IO(Input(UInt(log2Ceil(1024).W)))
	mem_2.read_address := mem_2_addr
	val mem_2_data = IO(Output(UInt(64.W)))
	mem_2_data := mem_2.out_data
	mem_3.read_address := DontCare
	mem_3.finish := DontCare
}

