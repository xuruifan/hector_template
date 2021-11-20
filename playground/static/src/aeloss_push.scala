import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class aeloss_push extends MultiIOModule {
	val mem_global_0 = Module(new ReadMem(1024, 64, 1))
	val var0 = mem_global_0.r_en
	val var1 = mem_global_0.addr
	val var2 = mem_global_0.r_data
	val mem_global_1 = Module(new ReadMem(1024, 32, 2))
	val var3 = mem_global_1.r_en
	val var4 = mem_global_1.addr
	val var5 = mem_global_1.r_data
class outline_0 extends MultiIOModule {
	val go = IO(Input(Bool()))
	val start = RegInit(false.B)
	val new_input = Wire(Bool())
	new_input := false.B
	val done = IO(Output(Bool()))
	done := 0.U
	val var6 = IO(Input(UInt(32.W)))
	val var7 = IO(Input(UInt(32.W)))
	val var8 = IO(Input(UInt(32.W)))
	val var9 = IO(Input(UInt(32.W)))
	val var10 = IO(Input(UInt(64.W)))
	val var11 = IO(Output(UInt(64.W)))
	var11 := DontCare
	val var12 = Reg(UInt(32.W))
	val var13 = Reg(UInt(32.W))
	val var14 = Reg(UInt(32.W))
	val var15 = Reg(UInt(32.W))
	val var16 = Reg(UInt(64.W))
	val var17 = Reg(UInt(32.W))
	val var18 = Reg(UInt(32.W))
	val var19 = Reg(UInt(32.W))
	val var20 = Reg(UInt(32.W))
	val var21 = Reg(UInt(32.W))
	val var22 = Reg(UInt(32.W))
	val var23 = Reg(UInt(32.W))
	val var24 = Reg(UInt(32.W))
	val var25 = Reg(UInt(32.W))
	val var26 = Reg(UInt(32.W))
	val var27 = Reg(UInt(32.W))
	val var28 = Reg(UInt(32.W))
	val var29 = Reg(UInt(32.W))
	val var30 = Reg(UInt(32.W))
	val var31 = Reg(UInt(32.W))
	val var32 = Reg(UInt(32.W))
	val var33 = Reg(UInt(32.W))
	val var34 = Reg(UInt(32.W))
	val var35 = Reg(UInt(32.W))
	val var36 = Reg(UInt(32.W))
	val var37 = Reg(UInt(32.W))
	val var38 = Reg(UInt(32.W))
	val var39 = Reg(UInt(32.W))
	val var40 = Reg(UInt(32.W))
	val var41 = Reg(UInt(32.W))
	val var42 = Reg(UInt(32.W))
	val var43 = Reg(UInt(32.W))
	val var44 = Reg(UInt(32.W))
	val var45 = Reg(UInt(32.W))
	val var46 = Reg(UInt(32.W))
	val var47 = Reg(UInt(32.W))
	val var48 = Reg(UInt(32.W))
	val var49 = Reg(UInt(32.W))
	val var50 = Reg(UInt(32.W))
	val var51 = Reg(UInt(32.W))
	val var52 = Reg(UInt(32.W))
	val var53 = Reg(UInt(32.W))
	val var54 = Reg(UInt(32.W))
	val var55 = Reg(UInt(32.W))
	val var56 = Reg(UInt(32.W))
	val var57 = Reg(UInt(32.W))
	val var58 = Reg(UInt(32.W))
	val var59 = Reg(UInt(32.W))
	val var60 = Reg(UInt(32.W))
	val var61 = Reg(UInt(32.W))
	val var62 = Reg(UInt(32.W))
	val var63 = Reg(UInt(32.W))
	val var64 = Reg(UInt(32.W))
	val var65 = Reg(UInt(32.W))
	val var66 = Reg(UInt(32.W))
	val var67 = Reg(UInt(32.W))
	val var68 = Reg(UInt(32.W))
	val var69 = Reg(UInt(32.W))
	val var70 = Reg(UInt(32.W))
	val var71 = Reg(UInt(32.W))
	val var72 = Reg(UInt(32.W))
	val var73 = Reg(UInt(32.W))
	val var74 = Reg(UInt(32.W))
	val var75 = Reg(UInt(32.W))
	val var76 = Reg(UInt(32.W))
	val var77 = Reg(UInt(32.W))
	val var78 = Reg(UInt(32.W))
	val var79 = Reg(UInt(32.W))
	val var80 = Reg(UInt(32.W))
	val var81 = Reg(UInt(32.W))
	val var82 = Reg(UInt(32.W))
	val var83 = Reg(UInt(32.W))
	val var84 = Reg(UInt(32.W))
	val var85 = Reg(UInt(32.W))
	val var86 = Reg(UInt(32.W))
	val var87 = Reg(UInt(32.W))
	val var88 = Reg(UInt(32.W))
	val var89 = Reg(UInt(32.W))
	val var90 = Reg(UInt(32.W))
	val var91 = Reg(UInt(32.W))
	val var92 = Reg(UInt(32.W))
	val var93 = Reg(UInt(32.W))
	val var94 = Reg(UInt(32.W))
	val var95 = Reg(UInt(32.W))
	val var96 = Reg(UInt(32.W))
	val var97 = Reg(UInt(32.W))
	val var98 = Reg(UInt(32.W))
	val var99 = Reg(UInt(32.W))
	val var100 = Reg(UInt(32.W))
	val var101 = Reg(UInt(32.W))
	val var102 = Reg(UInt(32.W))
	val var103 = Reg(UInt(32.W))
	val var104 = Reg(UInt(32.W))
	val var105 = Reg(UInt(32.W))
	val var106 = Reg(UInt(32.W))
	val var107 = Reg(UInt(32.W))
	val var108 = Reg(UInt(32.W))
	val var109 = Reg(UInt(32.W))
	val var110 = Reg(UInt(32.W))
	val var111 = Reg(UInt(32.W))
	val var112 = Reg(UInt(32.W))
	val var113 = Reg(UInt(32.W))
	val var114 = Reg(UInt(32.W))
	val var115 = Reg(UInt(32.W))
	val var116 = Reg(UInt(32.W))
	val var117 = Reg(UInt(32.W))
	val var118 = Reg(UInt(32.W))
	val var119 = Reg(UInt(32.W))
	val var120 = Reg(UInt(32.W))
	val var121 = Reg(UInt(32.W))
	val var122 = Reg(UInt(32.W))
	val var123 = Reg(UInt(32.W))
	val var124 = Reg(UInt(32.W))
	val var125 = Reg(UInt(32.W))
	val var126 = Reg(UInt(32.W))
	val var127 = Reg(UInt(32.W))
	val var128 = Reg(UInt(32.W))
	val var129 = Reg(UInt(32.W))
	val var130 = Reg(UInt(32.W))
	val var131 = Reg(UInt(32.W))
	val var132 = Reg(UInt(32.W))
	val var133 = Reg(UInt(32.W))
	val var134 = Reg(UInt(32.W))
	val var135 = Reg(UInt(32.W))
	val var136 = Reg(UInt(32.W))
	val var137 = Reg(UInt(32.W))
	val var138 = Reg(UInt(32.W))
	val var139 = Reg(UInt(32.W))
	val var140 = Reg(UInt(32.W))
	val var141 = Reg(UInt(32.W))
	val var142 = Reg(UInt(32.W))
	val var143 = Reg(UInt(32.W))
	val var144 = Reg(UInt(64.W))
	val var145 = Reg(UInt(64.W))
	val var146 = Reg(UInt(64.W))
	val var147 = Reg(UInt(64.W))
	val var148 = Reg(UInt(64.W))
	val var149 = Reg(UInt(64.W))
	val var150 = Reg(UInt(64.W))
	val var151 = Reg(UInt(64.W))
	val var152 = Reg(UInt(64.W))
	val var153 = Reg(UInt(64.W))
	val var154 = Reg(UInt(64.W))
	val var155 = Reg(UInt(64.W))
	val var156 = Reg(UInt(64.W))
	val var157 = Reg(UInt(64.W))
	val var158 = Reg(UInt(64.W))
	val var159 = Reg(UInt(64.W))
	val var160 = Reg(UInt(64.W))
	val var161 = Reg(UInt(64.W))
	val var162 = Reg(UInt(64.W))
	val var163 = Reg(UInt(64.W))
	val var164 = Reg(UInt(64.W))
	val var165 = Reg(UInt(64.W))
	val var166 = Reg(UInt(64.W))
	val var167 = Reg(UInt(64.W))
	val var168 = Reg(UInt(64.W))
	val var169 = Reg(UInt(64.W))
	val var170 = Reg(UInt(64.W))
	val var171 = Reg(UInt(64.W))
	val var172 = Reg(UInt(64.W))
	val var173 = Reg(UInt(64.W))
	val var174 = Reg(UInt(64.W))
	val var175 = Reg(UInt(64.W))
	val var176 = Reg(UInt(64.W))
	val var177 = Reg(UInt(64.W))
	val var178 = Reg(UInt(64.W))
	val var179 = Reg(UInt(64.W))
	val var180 = Reg(UInt(64.W))
	val var181 = Reg(UInt(64.W))
	val var182 = Reg(UInt(64.W))
	val var183 = Reg(UInt(64.W))
	val var184 = Reg(UInt(64.W))
	val var185 = Reg(UInt(64.W))
	val var186 = Reg(UInt(64.W))
	val var187 = Reg(UInt(64.W))
	val var188 = Reg(UInt(64.W))
	val var189 = Reg(UInt(64.W))
	val var190 = Reg(UInt(64.W))
	val var191 = Reg(UInt(64.W))
	val var192 = Reg(UInt(64.W))
	val var193 = Reg(UInt(64.W))
	val var194 = Reg(UInt(64.W))
	val var195 = Reg(UInt(64.W))
	val var196 = Reg(UInt(64.W))
	val var197 = Reg(UInt(64.W))
	val var198 = Reg(UInt(64.W))
	val var199 = Reg(UInt(64.W))
	val var200 = Reg(UInt(64.W))
	val var201 = Reg(UInt(64.W))
	val var202 = Reg(UInt(64.W))
	val var203 = Reg(UInt(64.W))
	val var204 = Reg(UInt(64.W))
	val var205 = Reg(UInt(64.W))
	val var206 = Reg(UInt(64.W))
	val var207 = Reg(UInt(64.W))
	val var208 = Reg(UInt(64.W))
	val var209 = Reg(UInt(64.W))
	val var210 = Reg(UInt(64.W))
	val var211 = Reg(UInt(64.W))
	val var212 = Reg(UInt(64.W))
	val var213 = Reg(UInt(64.W))
	val var214 = Reg(UInt(64.W))
	val var215 = Reg(UInt(64.W))
	val var216 = Reg(UInt(64.W))
	val var217 = Reg(UInt(64.W))
	val var218 = Reg(UInt(64.W))
	val var219 = Reg(UInt(64.W))
	val var220 = Reg(UInt(64.W))
	val var221 = Reg(UInt(64.W))
	val var222 = Reg(UInt(64.W))
	val var223 = Reg(UInt(64.W))
	val var224 = Reg(UInt(64.W))
	val var225 = Reg(UInt(64.W))
	val var226 = Reg(UInt(64.W))
	val var227 = Reg(UInt(64.W))
	val var228 = Reg(UInt(64.W))
	val var229 = Reg(UInt(64.W))
	val var230 = Reg(UInt(64.W))
	val var231 = Reg(UInt(64.W))
	val var232 = Reg(UInt(64.W))
	val var233 = Reg(UInt(64.W))
	val var234 = Reg(UInt(64.W))
	val var235 = Reg(UInt(64.W))
	val var236 = Reg(UInt(64.W))
	val var237 = Reg(UInt(64.W))
	val var238 = Reg(UInt(64.W))
	val var239 = Reg(UInt(64.W))
	val var240 = Reg(UInt(64.W))
	val var241 = Reg(UInt(64.W))
	val var242 = Reg(UInt(64.W))
	val var243 = Reg(UInt(64.W))
	val var244 = Reg(UInt(64.W))
	val var245 = Reg(UInt(64.W))
	val var246 = Reg(UInt(64.W))
	val var247 = Reg(UInt(64.W))
	val var248 = Reg(UInt(64.W))
	val var249 = Reg(UInt(64.W))
	val var250 = Reg(UInt(64.W))
	val var251 = Reg(UInt(64.W))
	val var252 = Reg(UInt(64.W))
	val var253 = Reg(UInt(64.W))
	val var254 = Reg(UInt(64.W))
	val var255 = Reg(UInt(64.W))
	val var256 = Reg(UInt(64.W))
	val var257 = Reg(UInt(64.W))
	val var258 = Reg(UInt(64.W))
	val var259 = Reg(UInt(64.W))
	val var260 = Reg(UInt(64.W))
	val var261 = Reg(UInt(64.W))
	val var262 = Reg(UInt(64.W))
	val var263 = Reg(UInt(64.W))
	val var264 = Reg(UInt(64.W))
	val var265 = Reg(UInt(64.W))
	val var266 = Reg(UInt(64.W))
	val var267 = Reg(UInt(64.W))
	val var268 = Reg(UInt(64.W))
	val var269 = Reg(UInt(64.W))
	val var270 = Reg(UInt(64.W))
	val var271 = Reg(UInt(64.W))
	val var272 = Reg(UInt(64.W))
	val var273 = Reg(UInt(64.W))
	val var274 = Reg(UInt(64.W))
	val var275 = Reg(UInt(64.W))
	val var276 = Reg(UInt(64.W))
	val var277 = Reg(UInt(64.W))
	val var278 = Reg(UInt(1.W))
	val var279 = Reg(UInt(1.W))
	val var280 = Reg(UInt(1.W))
	val var281 = Reg(UInt(1.W))
	val var282 = Reg(UInt(1.W))
	val var283 = Reg(UInt(1.W))
	val var284 = Reg(UInt(1.W))
	val var285 = Reg(UInt(1.W))
	val var286 = Reg(UInt(1.W))
	val var287 = Reg(UInt(1.W))
	val var288 = Reg(UInt(1.W))
	val var289 = Reg(UInt(1.W))
	val var290 = Reg(UInt(1.W))
	val var291 = Reg(UInt(1.W))
	val var292 = Reg(UInt(1.W))
	val var293 = Reg(UInt(1.W))
	val var294 = Reg(UInt(64.W))
	val var295 = Reg(UInt(64.W))
	val var296 = Reg(UInt(64.W))
	val var297 = Reg(UInt(64.W))
	val var298 = Reg(UInt(64.W))
	val var299 = Reg(UInt(64.W))
	val var300 = Reg(UInt(64.W))
	val var301 = Reg(UInt(64.W))
	val var302 = Reg(UInt(64.W))
	val var303 = Reg(UInt(64.W))
	val var304 = Reg(UInt(64.W))
	val var305 = Reg(UInt(64.W))
	val var306 = Reg(UInt(64.W))
	val var307 = Reg(UInt(64.W))
	val var308 = Reg(UInt(64.W))
	val var309 = Reg(UInt(64.W))
	val var310 = Reg(UInt(64.W))
	val var311 = Reg(UInt(64.W))
	val var312 = Reg(UInt(64.W))
	val var313 = Reg(UInt(64.W))
	val var314 = Reg(UInt(64.W))
	val var315 = Reg(UInt(64.W))
	val var316 = Reg(UInt(64.W))
	val var317 = Reg(UInt(64.W))
	val var318 = Reg(UInt(64.W))
	val var319 = Reg(UInt(64.W))
	val var320 = Reg(UInt(64.W))
	val var321 = Reg(UInt(64.W))
	val var322 = Reg(UInt(64.W))
	val var323 = Reg(UInt(64.W))
	val var324 = Reg(UInt(64.W))
	val var325 = Reg(UInt(64.W))
	val var326 = Reg(UInt(64.W))
	val var327 = Reg(UInt(64.W))
	val var328 = Reg(UInt(64.W))
	val var329 = Reg(UInt(64.W))
	val var330 = Reg(UInt(64.W))
	val var331 = Reg(UInt(64.W))
	val var332 = Reg(UInt(32.W))
	val var333 = Reg(UInt(1.W))
	val var334 = Reg(UInt(1.W))
	val var335 = Reg(UInt(1.W))
	val var336 = Reg(UInt(1.W))
	val var337 = Reg(UInt(1.W))
	val var338 = Reg(UInt(1.W))
	val var339 = Reg(UInt(1.W))
	val var340 = Reg(UInt(1.W))
	val var341 = Reg(UInt(1.W))
	val var342 = Reg(UInt(1.W))
	val var343 = Reg(UInt(1.W))
	val var344 = Reg(UInt(1.W))
	val var345 = Reg(UInt(1.W))
	val var346 = Reg(UInt(1.W))
	val var347 = Reg(UInt(1.W))
	val var348 = Reg(UInt(1.W))
	val var349 = Reg(UInt(1.W))
	val var350 = Reg(UInt(1.W))
	val var351 = Reg(UInt(1.W))
	val var352 = Reg(UInt(1.W))
	val var353 = Reg(UInt(1.W))
	val var354 = Reg(UInt(1.W))
	val var355 = Reg(UInt(1.W))
	val var356 = Reg(UInt(1.W))
	val var357 = Reg(UInt(1.W))
	val var358 = Reg(UInt(1.W))
	val var359 = Reg(UInt(1.W))
	val var360 = Reg(UInt(1.W))
	val var361 = Reg(UInt(1.W))
	val var362 = Reg(UInt(1.W))
	val var363 = Reg(UInt(1.W))
	val var364 = Reg(UInt(1.W))
	val var365 = Reg(UInt(1.W))
	val var366 = Reg(UInt(1.W))
	val var367 = Reg(UInt(1.W))
	val var368 = Reg(UInt(1.W))
	val var369 = Reg(UInt(64.W))
	val var370 = Reg(UInt(64.W))
	val var371 = Reg(UInt(64.W))
	val var372 = Reg(UInt(64.W))
	val var373 = Reg(UInt(64.W))
	val var374 = Reg(UInt(64.W))
	val var375 = Reg(UInt(1.W))
	val var376 = Reg(UInt(1.W))
	val var377 = Reg(UInt(1.W))
	val var378 = Reg(UInt(1.W))
	val var379 = Reg(UInt(1.W))
	val var380 = Reg(UInt(1.W))
	val var381 = Reg(UInt(1.W))
	val var382 = Reg(UInt(1.W))
	val var383 = Reg(UInt(1.W))
	val var384 = Reg(UInt(1.W))
	val var385 = Reg(UInt(1.W))
	val var386 = Reg(UInt(1.W))
	val var387 = Reg(UInt(1.W))
	val var388 = Reg(UInt(1.W))
	val var389 = Reg(UInt(1.W))
	val var390 = Reg(UInt(1.W))
	val var391 = Reg(UInt(1.W))
	val var392 = Reg(UInt(1.W))
	val var393 = Reg(UInt(1.W))
	val var394 = Reg(UInt(1.W))
	val var395 = Reg(UInt(1.W))
	val var396 = Reg(UInt(1.W))
	val var397 = Reg(UInt(1.W))
	val var398 = Reg(UInt(1.W))
	val var399 = Reg(UInt(1.W))
	val var400 = Reg(UInt(1.W))
	val var401 = Reg(UInt(1.W))
	val var402 = Reg(UInt(1.W))
	val var403 = Reg(UInt(1.W))
	val var404 = Reg(UInt(1.W))
	val var405 = Reg(UInt(1.W))
	val var406 = Reg(UInt(1.W))
	val var407 = Reg(UInt(1.W))
	val var408 = Reg(UInt(1.W))
	val var409 = Reg(UInt(1.W))
	val var410 = Reg(UInt(1.W))
	val var411 = Reg(UInt(1.W))
	val var412 = Reg(UInt(1.W))
	val var413 = Reg(UInt(1.W))
	val var414 = Reg(UInt(1.W))
	val var415 = Reg(UInt(1.W))
	val var416 = Reg(UInt(1.W))
	val var417 = Reg(UInt(1.W))
	val var418 = Reg(UInt(1.W))
	val var419 = Reg(UInt(1.W))
	val var420 = Reg(UInt(1.W))
	val var421 = Reg(UInt(1.W))
	val var422 = Reg(UInt(1.W))
	val var423 = Reg(UInt(1.W))
	val var424 = Reg(UInt(1.W))
	val var425 = Reg(UInt(1.W))
	val var426 = Reg(UInt(1.W))
	val var427 = Reg(UInt(1.W))
	val var428 = Reg(UInt(1.W))
	val var429 = Reg(UInt(1.W))
	val var430 = Reg(UInt(1.W))
	val var431 = Reg(UInt(1.W))
	val var432 = Reg(UInt(1.W))
	val var433 = Reg(UInt(1.W))
	val var434 = Reg(UInt(1.W))
	val var435 = Reg(UInt(1.W))
	val var436 = Reg(UInt(1.W))
	val var437 = Reg(UInt(64.W))
	val var438 = Reg(UInt(64.W))
	val var439 = Reg(UInt(64.W))
	val var440 = Reg(UInt(64.W))
	val subf_outline_0_0 = Module(new AddSubFIP(13, 11, 53, false))
	subf_outline_0_0.ce := true.B
	val var441 = subf_outline_0_0.operand0
	var441 := DontCare
	val var442 = subf_outline_0_0.operand1
	var442 := DontCare
	val var443 = subf_outline_0_0.result
	val cmpf_outline_0_0 = Module(new CmpFIP(2, 11, 53))
	cmpf_outline_0_0.ce := true.B
	cmpf_outline_0_0.opcode := 2.U
	val var444 = cmpf_outline_0_0.operand0
	var444 := DontCare
	val var445 = cmpf_outline_0_0.operand1
	var445 := DontCare
	val var446 = cmpf_outline_0_0.result
	val addf_outline_0_0 = Module(new AddSubFIP(13, 11, 53, true))
	addf_outline_0_0.ce := true.B
	val var447 = addf_outline_0_0.operand0
	var447 := DontCare
	val var448 = addf_outline_0_0.operand1
	var448 := DontCare
	val var449 = addf_outline_0_0.result
	val divf_outline_0_0 = Module(new DivFIP(30, 11, 53))
	divf_outline_0_0.ce := true.B
	val var450 = divf_outline_0_0.operand0
	var450 := DontCare
	val var451 = divf_outline_0_0.operand1
	var451 := DontCare
	val var452 = divf_outline_0_0.result
	val var453 = Reg(UInt(32.W))
	when (go) {
		var453 := var6
	}
	when (go) {
		var12 := var6
	}
	when (go) {
		var13 := var7
	}
	when (go) {
		var14 := var8
	}
	when (go) {
		var15 := var9
	}
	when (go) {
		var16 := var10
	}
	when (go) {
		var144 := var10
	}
	val var0 = IO(Output(UInt(1.W)))
	var0 := false.B
	val var1 = IO(Output(UInt(10.W)))
	var1 := DontCare
	val var3 = IO(Output(UInt(1.W)))
	var3 := false.B
	val var4 = IO(Output(UInt(10.W)))
	var4 := DontCare
	val var2 = IO(Input(UInt(64.W)))
	val var5 = IO(Input(UInt(32.W)))
	val shift_register = RegInit(0.U(9.W))
	when (go) {
		when (var6 > var7) {
			done := true.B
		} .otherwise {
			start := true.B
		}
	}
	def valid(stage: Int): Bool = {
		if (stage == 1) {
			shift_register(0)
		} else if (stage == 2) {
			shift_register(0)
		} else if (stage == 3) {
			shift_register(0)
		} else if (stage == 4) {
			shift_register(0)
		} else if (stage == 5) {
			shift_register(0)
		} else if (stage == 6) {
			shift_register(0)
		} else if (stage == 7) {
			shift_register(0)
		} else if (stage == 8) {
			shift_register(0)
		} else if (stage == 9) {
			shift_register(0)
		} else if (stage == 10) {
			shift_register(0)
		} else if (stage == 11) {
			shift_register(0)
		} else if (stage == 12) {
			shift_register(0)
		} else if (stage == 13) {
			shift_register(0)
		} else if (stage == 14) {
			shift_register(0)
		} else if (stage == 15) {
			shift_register(0)
		} else if (stage == 16) {
			shift_register(1)
		} else if (stage == 17) {
			shift_register(1)
		} else if (stage == 18) {
			shift_register(1)
		} else if (stage == 19) {
			shift_register(1)
		} else if (stage == 20) {
			shift_register(1)
		} else if (stage == 21) {
			shift_register(1)
		} else if (stage == 22) {
			shift_register(1)
		} else if (stage == 23) {
			shift_register(1)
		} else if (stage == 24) {
			shift_register(1)
		} else if (stage == 25) {
			shift_register(1)
		} else if (stage == 26) {
			shift_register(1)
		} else if (stage == 27) {
			shift_register(1)
		} else if (stage == 28) {
			shift_register(1)
		} else if (stage == 29) {
			shift_register(1)
		} else if (stage == 30) {
			shift_register(1)
		} else if (stage == 31) {
			shift_register(2)
		} else if (stage == 32) {
			shift_register(2)
		} else if (stage == 33) {
			shift_register(2)
		} else if (stage == 34) {
			shift_register(2)
		} else if (stage == 35) {
			shift_register(2)
		} else if (stage == 36) {
			shift_register(2)
		} else if (stage == 37) {
			shift_register(2)
		} else if (stage == 38) {
			shift_register(2)
		} else if (stage == 39) {
			shift_register(2)
		} else if (stage == 40) {
			shift_register(2)
		} else if (stage == 41) {
			shift_register(2)
		} else if (stage == 42) {
			shift_register(2)
		} else if (stage == 43) {
			shift_register(2)
		} else if (stage == 44) {
			shift_register(2)
		} else if (stage == 45) {
			shift_register(2)
		} else if (stage == 46) {
			shift_register(3)
		} else if (stage == 47) {
			shift_register(3)
		} else if (stage == 48) {
			shift_register(3)
		} else if (stage == 49) {
			shift_register(3)
		} else if (stage == 50) {
			shift_register(3)
		} else if (stage == 51) {
			shift_register(3)
		} else if (stage == 52) {
			shift_register(3)
		} else if (stage == 53) {
			shift_register(3)
		} else if (stage == 54) {
			shift_register(3)
		} else if (stage == 55) {
			shift_register(3)
		} else if (stage == 56) {
			shift_register(3)
		} else if (stage == 57) {
			shift_register(3)
		} else if (stage == 58) {
			shift_register(3)
		} else if (stage == 59) {
			shift_register(3)
		} else if (stage == 60) {
			shift_register(3)
		} else if (stage == 61) {
			shift_register(4)
		} else if (stage == 62) {
			shift_register(4)
		} else if (stage == 63) {
			shift_register(4)
		} else if (stage == 64) {
			shift_register(4)
		} else if (stage == 65) {
			shift_register(4)
		} else if (stage == 66) {
			shift_register(4)
		} else if (stage == 67) {
			shift_register(4)
		} else if (stage == 68) {
			shift_register(4)
		} else if (stage == 69) {
			shift_register(4)
		} else if (stage == 70) {
			shift_register(4)
		} else if (stage == 71) {
			shift_register(4)
		} else if (stage == 72) {
			shift_register(4)
		} else if (stage == 73) {
			shift_register(4)
		} else if (stage == 74) {
			shift_register(4)
		} else if (stage == 75) {
			shift_register(4)
		} else if (stage == 76) {
			shift_register(5)
		} else if (stage == 77) {
			shift_register(5)
		} else if (stage == 78) {
			shift_register(5)
		} else if (stage == 79) {
			shift_register(5)
		} else if (stage == 80) {
			shift_register(5)
		} else if (stage == 81) {
			shift_register(5)
		} else if (stage == 82) {
			shift_register(5)
		} else if (stage == 83) {
			shift_register(5)
		} else if (stage == 84) {
			shift_register(5)
		} else if (stage == 85) {
			shift_register(5)
		} else if (stage == 86) {
			shift_register(5)
		} else if (stage == 87) {
			shift_register(5)
		} else if (stage == 88) {
			shift_register(5)
		} else if (stage == 89) {
			shift_register(5)
		} else if (stage == 90) {
			shift_register(5)
		} else if (stage == 91) {
			shift_register(6)
		} else if (stage == 92) {
			shift_register(6)
		} else if (stage == 93) {
			shift_register(6)
		} else if (stage == 94) {
			shift_register(6)
		} else if (stage == 95) {
			shift_register(6)
		} else if (stage == 96) {
			shift_register(6)
		} else if (stage == 97) {
			shift_register(6)
		} else if (stage == 98) {
			shift_register(6)
		} else if (stage == 99) {
			shift_register(6)
		} else if (stage == 100) {
			shift_register(6)
		} else if (stage == 101) {
			shift_register(6)
		} else if (stage == 102) {
			shift_register(6)
		} else if (stage == 103) {
			shift_register(6)
		} else if (stage == 104) {
			shift_register(6)
		} else if (stage == 105) {
			shift_register(6)
		} else if (stage == 106) {
			shift_register(7)
		} else if (stage == 107) {
			shift_register(7)
		} else if (stage == 108) {
			shift_register(7)
		} else if (stage == 109) {
			shift_register(7)
		} else if (stage == 110) {
			shift_register(7)
		} else if (stage == 111) {
			shift_register(7)
		} else if (stage == 112) {
			shift_register(7)
		} else if (stage == 113) {
			shift_register(7)
		} else if (stage == 114) {
			shift_register(7)
		} else if (stage == 115) {
			shift_register(7)
		} else if (stage == 116) {
			shift_register(7)
		} else if (stage == 117) {
			shift_register(7)
		} else if (stage == 118) {
			shift_register(7)
		} else if (stage == 119) {
			shift_register(7)
		} else if (stage == 120) {
			shift_register(7)
		} else if (stage == 121) {
			shift_register(8)
		} else if (stage == 122) {
			shift_register(8)
		} else if (stage == 123) {
			shift_register(8)
		} else if (stage == 124) {
			shift_register(8)
		} else if (stage == 125) {
			shift_register(8)
		} else if (stage == 126) {
			shift_register(8)
		} else if (stage == 127) {
			shift_register(8)
		} else {
			new_input
		}
	}
	val counter = RegInit(0.U(4.W))
	when (counter === 14.U) {
		counter := 0.U
	}.otherwise {
		when (start || shift_register =/= 0.U) {
			counter := counter + 1.U
		}
	}
	when (counter === 0.U) {
		shift_register := Cat(shift_register(7, 0), new_input)
	}
	when (counter === 0.U) {
		when (valid(0)) {
			var17 := var453
		}
		when (valid(15)) {
			var32 := var31
		}
		when (valid(15)) {
			var159 := var158
		}
		when (valid(30)) {
			var47 := var46
		}
		when (valid(30)) {
			var174 := var173
		}
		when (valid(30)) {
			var290 := var289
		}
		when (valid(45)) {
			var62 := var61
		}
		when (valid(45)) {
			var189 := var188
		}
		when (valid(45)) {
			var307 := var306
		}
		when (valid(45)) {
			var343 := var342
		}
		when (valid(60)) {
			var77 := var76
		}
		when (valid(60)) {
			var204 := var203
		}
		when (valid(60)) {
			var322 := var321
		}
		when (valid(60)) {
			var358 := var357
		}
		when (valid(75)) {
			var92 := var91
		}
		when (valid(75)) {
			var219 := var218
		}
		when (valid(75)) {
			var382 := var381
		}
		when (valid(90)) {
			var107 := var106
		}
		when (valid(90)) {
			var234 := var233
		}
		when (valid(90)) {
			var397 := var396
		}
		when (valid(105)) {
			var122 := var121
		}
		when (valid(105)) {
			var249 := var248
		}
		when (valid(105)) {
			var412 := var411
		}
		when (valid(120)) {
			var137 := var136
		}
		when (valid(120)) {
			var264 := var263
		}
		when (valid(120)) {
			var427 := var426
		}
	}
	when (counter === 1.U) {
		var1 := var15
		when (valid(1)) {
			var0 := 1.U
		}
		when (valid(1)) {
			var18 := var17
		}
		when (valid(1)) {
			var145 := var144
		}
		when (valid(16)) {
			var274 := var443
		}
		var444 := var443
		var445 := 0L.U
		when (valid(16)) {
			var33 := var32
		}
		when (valid(16)) {
			var160 := var159
		}
		when (valid(31)) {
			var48 := var47
		}
		when (valid(31)) {
			var175 := var174
		}
		when (valid(31)) {
			var291 := var290
		}
		when (valid(46)) {
			var63 := var62
		}
		when (valid(46)) {
			var190 := var189
		}
		when (valid(46)) {
			var308 := var307
		}
		when (valid(46)) {
			var344 := var343
		}
		when (valid(61)) {
			var78 := var77
		}
		when (valid(61)) {
			var205 := var204
		}
		when (valid(61)) {
			var323 := var322
		}
		when (valid(61)) {
			var359 := var358
		}
		when (valid(76)) {
			var93 := var92
		}
		when (valid(76)) {
			var220 := var219
		}
		when (valid(76)) {
			var383 := var382
		}
		when (valid(91)) {
			var108 := var107
		}
		when (valid(91)) {
			var235 := var234
		}
		when (valid(91)) {
			var398 := var397
		}
		when (valid(106)) {
			var123 := var122
		}
		when (valid(106)) {
			var250 := var249
		}
		when (valid(106)) {
			var413 := var412
		}
		when (valid(121)) {
			var138 := var137
		}
		when (valid(121)) {
			var265 := var264
		}
		when (valid(121)) {
			var428 := var427
		}
	}
	when (counter === 2.U) {
		when (valid(2)) {
			var271 := var2
		}
		var1 := var18
		when (valid(2)) {
			var0 := 1.U
		}
		when (valid(2)) {
			var19 := var18
		}
		when (valid(2)) {
			var146 := var145
		}
		when (valid(17)) {
			var34 := var33
		}
		when (valid(17)) {
			var161 := var160
		}
		when (valid(17)) {
			var275 := var274
		}
		when (valid(32) && var291.asBool()) {
			var328 := var443
		}
		val var454 = !var291
		when (valid(32) && var454.asBool()) {
			var330 := var449
		}
		when (valid(32) && var291.asBool()) {
			var294 := var443
		}
		when (valid(32) && var454.asBool()) {
			var294 := var449
		}
		when (valid(32)) {
			var49 := var48
		}
		when (valid(32)) {
			var176 := var175
		}
		when (valid(32)) {
			var292 := var291
		}
		when (valid(47)) {
			var64 := var63
		}
		when (valid(47)) {
			var191 := var190
		}
		when (valid(47)) {
			var309 := var308
		}
		when (valid(47)) {
			var345 := var344
		}
		when (valid(62)) {
			var79 := var78
		}
		when (valid(62)) {
			var206 := var205
		}
		when (valid(62)) {
			var324 := var323
		}
		when (valid(62)) {
			var360 := var359
		}
		when (valid(77)) {
			var94 := var93
		}
		when (valid(77)) {
			var221 := var220
		}
		when (valid(77)) {
			var384 := var383
		}
		when (valid(92)) {
			var109 := var108
		}
		when (valid(92)) {
			var236 := var235
		}
		when (valid(92)) {
			var399 := var398
		}
		when (valid(107)) {
			var124 := var123
		}
		when (valid(107)) {
			var251 := var250
		}
		when (valid(107)) {
			var414 := var413
		}
		when (valid(122)) {
			var139 := var138
		}
		when (valid(122)) {
			var266 := var265
		}
		when (valid(122)) {
			var429 := var428
		}
	}
	when (counter === 3.U) {
		when (valid(3)) {
			var273 := var2
		}
		var441 := var271
		var442 := var2
		when (valid(3)) {
			var20 := var19
		}
		when (valid(3)) {
			var147 := var146
		}
		when (valid(3)) {
			var272 := var271
		}
		when (valid(18)) {
			var278 := var446
		}
		when (valid(18)) {
			var35 := var34
		}
		when (valid(18)) {
			var162 := var161
		}
		when (valid(18)) {
			var276 := var275
		}
		when (valid(33)) {
			var50 := var49
		}
		when (valid(33)) {
			var177 := var176
		}
		when (valid(33)) {
			var293 := var292
		}
		when (valid(33)) {
			var295 := var294
		}
		when (valid(33)) {
			var329 := var328
		}
		when (valid(33)) {
			var331 := var330
		}
		when (valid(48)) {
			var65 := var64
		}
		when (valid(48)) {
			var192 := var191
		}
		when (valid(48)) {
			var310 := var309
		}
		when (valid(48)) {
			var346 := var345
		}
		var444 := var324
		var445 := 0L.U
		when (valid(63)) {
			var80 := var79
		}
		when (valid(63)) {
			var207 := var206
		}
		when (valid(63)) {
			var325 := var324
		}
		when (valid(63)) {
			var361 := var360
		}
		when (valid(78)) {
			var95 := var94
		}
		when (valid(78)) {
			var222 := var221
		}
		when (valid(78)) {
			var385 := var384
		}
		when (valid(93)) {
			var110 := var109
		}
		when (valid(93)) {
			var237 := var236
		}
		when (valid(93)) {
			var400 := var399
		}
		when (valid(108)) {
			var125 := var124
		}
		when (valid(108)) {
			var252 := var251
		}
		when (valid(108)) {
			var415 := var414
		}
		when (valid(123)) {
			var140 := var139
		}
		when (valid(123)) {
			var267 := var266
		}
		when (valid(123)) {
			var430 := var429
		}
	}
	when (counter === 4.U) {
		when (valid(4)) {
			var21 := var20
		}
		when (valid(4)) {
			var148 := var147
		}
		when (var278.asBool()) {
			var441 := 4607182418800017408L.U
		}
		when (var278.asBool()) {
			var442 := var276
		}
		val var455 = !var278
		when (var455.asBool()) {
			var447 := 4607182418800017408L.U
		}
		when (var455.asBool()) {
			var448 := var276
		}
		when (valid(19)) {
			var36 := var35
		}
		when (valid(19)) {
			var163 := var162
		}
		when (valid(19)) {
			var277 := var276
		}
		when (valid(19)) {
			var279 := var278
		}
		var4 := var50
		when (valid(34)) {
			var3 := 1.U
		}
		when (valid(34)) {
			var51 := var50
		}
		when (valid(34)) {
			var178 := var177
		}
		when (valid(34)) {
			var296 := var295
		}
		when (valid(49)) {
			var66 := var65
		}
		when (valid(49)) {
			var193 := var192
		}
		when (valid(49)) {
			var311 := var310
		}
		when (valid(49)) {
			var347 := var346
		}
		when (valid(64)) {
			var81 := var80
		}
		when (valid(64)) {
			var208 := var207
		}
		when (valid(64)) {
			var326 := var325
		}
		when (valid(64)) {
			var362 := var361
		}
		when (valid(79)) {
			var96 := var95
		}
		when (valid(79)) {
			var223 := var222
		}
		when (valid(79)) {
			var386 := var385
		}
		when (valid(94)) {
			var111 := var110
		}
		when (valid(94)) {
			var238 := var237
		}
		when (valid(94)) {
			var401 := var400
		}
		when (valid(109)) {
			var126 := var125
		}
		when (valid(109)) {
			var253 := var252
		}
		when (valid(109)) {
			var416 := var415
		}
		when (valid(124)) {
			var141 := var140
		}
		when (valid(124)) {
			var268 := var267
		}
		when (valid(124)) {
			var431 := var430
		}
	}
	when (counter === 5.U) {
		when (valid(5)) {
			var22 := var21
		}
		when (valid(5)) {
			var149 := var148
		}
		when (valid(20)) {
			var37 := var36
		}
		when (valid(20)) {
			var164 := var163
		}
		when (valid(20)) {
			var280 := var279
		}
		when (valid(35)) {
			var332 := var5
		}
		val var456 = var5
		when (valid(35)) {
			var333 := var456
		}
		when (valid(35)) {
			var52 := var51
		}
		when (valid(35)) {
			var179 := var178
		}
		when (valid(35)) {
			var297 := var296
		}
		when (valid(50)) {
			var67 := var66
		}
		when (valid(50)) {
			var194 := var193
		}
		when (valid(50)) {
			var312 := var311
		}
		when (valid(50)) {
			var348 := var347
		}
		when (valid(65)) {
			var368 := var446
		}
		val var457 = Mux(var446.asBool(), var326, 0L.U)
		when (valid(65)) {
			var369 := var457
		}
		when (valid(65)) {
			var82 := var81
		}
		when (valid(65)) {
			var209 := var208
		}
		when (valid(65)) {
			var327 := var326
		}
		when (valid(65)) {
			var363 := var362
		}
		when (valid(80)) {
			var97 := var96
		}
		when (valid(80)) {
			var224 := var223
		}
		when (valid(80)) {
			var387 := var386
		}
		when (valid(95)) {
			var112 := var111
		}
		when (valid(95)) {
			var239 := var238
		}
		when (valid(95)) {
			var402 := var401
		}
		when (valid(110)) {
			var127 := var126
		}
		when (valid(110)) {
			var254 := var253
		}
		when (valid(110)) {
			var417 := var416
		}
		when (valid(125)) {
			var142 := var141
		}
		when (valid(125)) {
			var269 := var268
		}
		when (valid(125)) {
			var432 := var431
		}
	}
	when (counter === 6.U) {
		when (valid(6)) {
			var23 := var22
		}
		when (valid(6)) {
			var150 := var149
		}
		when (valid(21)) {
			var38 := var37
		}
		when (valid(21)) {
			var165 := var164
		}
		when (valid(21)) {
			var281 := var280
		}
		when (valid(36)) {
			var53 := var52
		}
		when (valid(36)) {
			var180 := var179
		}
		when (valid(36)) {
			var298 := var297
		}
		when (valid(36)) {
			var334 := var333
		}
		when (valid(51)) {
			var68 := var67
		}
		when (valid(51)) {
			var195 := var194
		}
		when (valid(51)) {
			var313 := var312
		}
		when (valid(51)) {
			var349 := var348
		}
		when (valid(66)) {
			var83 := var82
		}
		when (valid(66)) {
			var210 := var209
		}
		when (valid(66)) {
			var364 := var363
		}
		when (valid(66)) {
			var370 := var369
		}
		when (valid(81)) {
			var98 := var97
		}
		when (valid(81)) {
			var225 := var224
		}
		when (valid(81)) {
			var388 := var387
		}
		when (valid(96)) {
			var113 := var112
		}
		when (valid(96)) {
			var240 := var239
		}
		when (valid(96)) {
			var403 := var402
		}
		when (valid(111)) {
			var128 := var127
		}
		when (valid(111)) {
			var255 := var254
		}
		when (valid(111)) {
			var418 := var417
		}
		when (valid(126) && var432.asBool()) {
			var440 := var449
		}
		when (valid(126) && var432.asBool()) {
			var437 := var449
		}
		val var458 = !var432
		when (valid(126) && var458.asBool()) {
			var437 := var269
		}
		when (valid(126)) {
			var143 := var142
		}
		when (valid(126)) {
			var270 := var269
		}
		when (valid(126)) {
			var433 := var432
		}
	}
	when (counter === 7.U) {
		when (valid(7)) {
			var24 := var23
		}
		when (valid(7)) {
			var151 := var150
		}
		when (valid(22)) {
			var39 := var38
		}
		when (valid(22)) {
			var166 := var165
		}
		when (valid(22)) {
			var282 := var281
		}
		when (valid(37)) {
			var54 := var53
		}
		when (valid(37)) {
			var181 := var180
		}
		when (valid(37)) {
			var299 := var298
		}
		when (valid(37)) {
			var335 := var334
		}
		when (valid(52)) {
			var69 := var68
		}
		when (valid(52)) {
			var196 := var195
		}
		when (valid(52)) {
			var314 := var313
		}
		when (valid(52)) {
			var350 := var349
		}
		val var459 = Wire(UInt(1.W))
		var459 := DontCare
		when (var364.asBool()) {
			var459 := var15 =/= var83
		}
		when (valid(67) && var364.asBool()) {
			var434 := var459
		}
		when (valid(67)) {
			var84 := var83
		}
		when (valid(67)) {
			var211 := var210
		}
		when (valid(67)) {
			var365 := var364
		}
		when (valid(67)) {
			var371 := var370
		}
		when (valid(82)) {
			var99 := var98
		}
		when (valid(82)) {
			var226 := var225
		}
		when (valid(82)) {
			var389 := var388
		}
		when (valid(97)) {
			var114 := var113
		}
		when (valid(97)) {
			var241 := var240
		}
		when (valid(97)) {
			var404 := var403
		}
		when (valid(112)) {
			var129 := var128
		}
		when (valid(112)) {
			var256 := var255
		}
		when (valid(112)) {
			var419 := var418
		}
		when (valid(127)) {
			var256 := var437
			var11 := var437
		}
	}
	when (counter === 8.U) {
		when (valid(8)) {
			var25 := var24
		}
		when (valid(8)) {
			var152 := var151
		}
		when (valid(23)) {
			var40 := var39
		}
		when (valid(23)) {
			var167 := var166
		}
		when (valid(23)) {
			var283 := var282
		}
		when (valid(38)) {
			var55 := var54
		}
		when (valid(38)) {
			var182 := var181
		}
		when (valid(38)) {
			var300 := var299
		}
		when (valid(38)) {
			var336 := var335
		}
		when (valid(53)) {
			var70 := var69
		}
		when (valid(53)) {
			var197 := var196
		}
		when (valid(53)) {
			var315 := var314
		}
		when (valid(53)) {
			var351 := var350
		}
		when (valid(68) && var365.asBool()) {
			var375 := var434
		}
		val var460 = !var365
		when (valid(68) && var460.asBool()) {
			var375 := 0.U
		}
		when (valid(68)) {
			var85 := var84
		}
		when (valid(68)) {
			var212 := var211
		}
		when (valid(68)) {
			var366 := var365
		}
		when (valid(68)) {
			var372 := var371
		}
		when (valid(68)) {
			var435 := var434
		}
		when (valid(83) && var389.asBool()) {
			var438 := var443
		}
		when (var389.asBool()) {
			var450 := var443
		}
		when (var389.asBool()) {
			var451 := 4636350344607927405L.U
		}
		when (valid(83)) {
			var100 := var99
		}
		when (valid(83)) {
			var227 := var226
		}
		when (valid(83)) {
			var390 := var389
		}
		when (valid(98)) {
			var115 := var114
		}
		when (valid(98)) {
			var242 := var241
		}
		when (valid(98)) {
			var405 := var404
		}
		when (valid(113) && var419.asBool()) {
			var439 := var452
		}
		when (var419.asBool()) {
			var447 := var256
		}
		when (var419.asBool()) {
			var448 := var452
		}
		when (valid(113)) {
			var130 := var129
		}
		when (valid(113)) {
			var257 := var256
		}
		when (valid(113)) {
			var420 := var419
		}
	}
	when (counter === 9.U) {
		when (valid(9)) {
			var26 := var25
		}
		when (valid(9)) {
			var153 := var152
		}
		when (valid(24)) {
			var41 := var40
		}
		when (valid(24)) {
			var168 := var167
		}
		when (valid(24)) {
			var284 := var283
		}
		when (valid(39)) {
			var56 := var55
		}
		when (valid(39)) {
			var183 := var182
		}
		when (valid(39)) {
			var301 := var300
		}
		when (valid(39)) {
			var337 := var336
		}
		when (valid(54)) {
			var71 := var70
		}
		when (valid(54)) {
			var198 := var197
		}
		when (valid(54)) {
			var316 := var315
		}
		when (valid(54)) {
			var352 := var351
		}
		when (valid(69)) {
			var86 := var85
		}
		when (valid(69)) {
			var213 := var212
		}
		when (valid(69)) {
			var367 := var366
		}
		when (valid(69)) {
			var373 := var372
		}
		when (valid(69)) {
			var376 := var375
		}
		when (valid(69)) {
			var436 := var435
		}
		when (valid(84)) {
			var101 := var100
		}
		when (valid(84)) {
			var228 := var227
		}
		when (valid(84)) {
			var391 := var390
		}
		when (valid(99)) {
			var116 := var115
		}
		when (valid(99)) {
			var243 := var242
		}
		when (valid(99)) {
			var406 := var405
		}
		when (valid(114)) {
			var131 := var130
		}
		when (valid(114)) {
			var258 := var257
		}
		when (valid(114)) {
			var421 := var420
		}
	}
	when (counter === 10.U) {
		when (valid(10)) {
			var27 := var26
		}
		when (valid(10)) {
			var154 := var153
		}
		when (valid(25)) {
			var42 := var41
		}
		when (valid(25)) {
			var169 := var168
		}
		when (valid(25)) {
			var285 := var284
		}
		when (valid(40)) {
			var57 := var56
		}
		when (valid(40)) {
			var184 := var183
		}
		when (valid(40)) {
			var302 := var301
		}
		when (valid(40)) {
			var338 := var337
		}
		when (valid(55)) {
			var72 := var71
		}
		when (valid(55)) {
			var199 := var198
		}
		when (valid(55)) {
			var317 := var316
		}
		when (valid(55)) {
			var353 := var352
		}
		when (var376.asBool()) {
			var441 := var373
		}
		when (var376.asBool()) {
			var442 := 4591705145477314065L.U
		}
		when (valid(70)) {
			var87 := var86
		}
		when (valid(70)) {
			var214 := var213
		}
		when (valid(70)) {
			var374 := var373
		}
		when (valid(70)) {
			var377 := var376
		}
		when (valid(85)) {
			var102 := var101
		}
		when (valid(85)) {
			var229 := var228
		}
		when (valid(85)) {
			var392 := var391
		}
		when (valid(100)) {
			var117 := var116
		}
		when (valid(100)) {
			var244 := var243
		}
		when (valid(100)) {
			var407 := var406
		}
		when (valid(115)) {
			var132 := var131
		}
		when (valid(115)) {
			var259 := var258
		}
		when (valid(115)) {
			var422 := var421
		}
	}
	when (counter === 11.U) {
		when (valid(11)) {
			var28 := var27
		}
		when (valid(11)) {
			var155 := var154
		}
		when (valid(26)) {
			var43 := var42
		}
		when (valid(26)) {
			var170 := var169
		}
		when (valid(26)) {
			var286 := var285
		}
		when (valid(41)) {
			var58 := var57
		}
		when (valid(41)) {
			var185 := var184
		}
		when (valid(41)) {
			var303 := var302
		}
		when (valid(41)) {
			var339 := var338
		}
		when (valid(56)) {
			var73 := var72
		}
		when (valid(56)) {
			var200 := var199
		}
		when (valid(56)) {
			var318 := var317
		}
		when (valid(56)) {
			var354 := var353
		}
		when (valid(71)) {
			var88 := var87
		}
		when (valid(71)) {
			var215 := var214
		}
		when (valid(71)) {
			var378 := var377
		}
		when (valid(86)) {
			var103 := var102
		}
		when (valid(86)) {
			var230 := var229
		}
		when (valid(86)) {
			var393 := var392
		}
		when (valid(101)) {
			var118 := var117
		}
		when (valid(101)) {
			var245 := var244
		}
		when (valid(101)) {
			var408 := var407
		}
		when (valid(116)) {
			var133 := var132
		}
		when (valid(116)) {
			var260 := var259
		}
		when (valid(116)) {
			var423 := var422
		}
	}
	when (counter === 12.U) {
		when (valid(12)) {
			var29 := var28
		}
		when (valid(12)) {
			var156 := var155
		}
		when (valid(27)) {
			var44 := var43
		}
		when (valid(27)) {
			var171 := var170
		}
		when (valid(27)) {
			var287 := var286
		}
		when (valid(42)) {
			var59 := var58
		}
		when (valid(42)) {
			var186 := var185
		}
		when (valid(42)) {
			var304 := var303
		}
		when (valid(42)) {
			var340 := var339
		}
		when (valid(57)) {
			var74 := var73
		}
		when (valid(57)) {
			var201 := var200
		}
		when (valid(57)) {
			var319 := var318
		}
		when (valid(57)) {
			var355 := var354
		}
		when (valid(72)) {
			var89 := var88
		}
		when (valid(72)) {
			var216 := var215
		}
		when (valid(72)) {
			var379 := var378
		}
		when (valid(87)) {
			var104 := var103
		}
		when (valid(87)) {
			var231 := var230
		}
		when (valid(87)) {
			var394 := var393
		}
		when (valid(102)) {
			var119 := var118
		}
		when (valid(102)) {
			var246 := var245
		}
		when (valid(102)) {
			var409 := var408
		}
		when (valid(117)) {
			var134 := var133
		}
		when (valid(117)) {
			var261 := var260
		}
		when (valid(117)) {
			var424 := var423
		}
	}
	when (counter === 13.U) {
		when (valid(13)) {
			var30 := var29
		}
		when (valid(13)) {
			var157 := var156
		}
		when (valid(28)) {
			var45 := var44
		}
		when (valid(28)) {
			var172 := var171
		}
		when (valid(28)) {
			var288 := var287
		}
		when (valid(43)) {
			var60 := var59
		}
		when (valid(43)) {
			var187 := var186
		}
		when (valid(43)) {
			var305 := var304
		}
		when (valid(43)) {
			var341 := var340
		}
		when (valid(58)) {
			var75 := var74
		}
		when (valid(58)) {
			var202 := var201
		}
		when (valid(58)) {
			var320 := var319
		}
		when (valid(58)) {
			var356 := var355
		}
		when (valid(73)) {
			var90 := var89
		}
		when (valid(73)) {
			var217 := var216
		}
		when (valid(73)) {
			var380 := var379
		}
		when (valid(88)) {
			var105 := var104
		}
		when (valid(88)) {
			var232 := var231
		}
		when (valid(88)) {
			var395 := var394
		}
		when (valid(103)) {
			var120 := var119
		}
		when (valid(103)) {
			var247 := var246
		}
		when (valid(103)) {
			var410 := var409
		}
		when (valid(118)) {
			var135 := var134
		}
		when (valid(118)) {
			var262 := var261
		}
		when (valid(118)) {
			var425 := var424
		}
	}
	when (counter === 14.U) {
		when (valid(14)) {
			var31 := var30
		}
		when (valid(14)) {
			var158 := var157
		}
		when (valid(29)) {
			var46 := var45
		}
		when (valid(29)) {
			var173 := var172
		}
		when (valid(29)) {
			var289 := var288
		}
		when (valid(44)) {
			var61 := var60
		}
		when (valid(44)) {
			var188 := var187
		}
		when (valid(44)) {
			var306 := var305
		}
		when (valid(44)) {
			var342 := var341
		}
		when (valid(59)) {
			var76 := var75
		}
		when (valid(59)) {
			var203 := var202
		}
		when (valid(59)) {
			var321 := var320
		}
		when (valid(59)) {
			var357 := var356
		}
		when (valid(74)) {
			var91 := var90
		}
		when (valid(74)) {
			var218 := var217
		}
		when (valid(74)) {
			var381 := var380
		}
		when (valid(89)) {
			var106 := var105
		}
		when (valid(89)) {
			var233 := var232
		}
		when (valid(89)) {
			var396 := var395
		}
		when (valid(104)) {
			var121 := var120
		}
		when (valid(104)) {
			var248 := var247
		}
		when (valid(104)) {
			var411 := var410
		}
		when (valid(119)) {
			var136 := var135
		}
		when (valid(119)) {
			var263 := var262
		}
		when (valid(119)) {
			var426 := var425
		}
	}
	when (counter === 7.U && valid(127)) {
		done := !valid(112)
	}
	when (done) {
		shift_register := 0.U
		counter := 0.U
	}
	val ub_reg = Reg(UInt(32.W))
	when (go) {
		ub_reg := var7
	}
	val step_reg = Reg(UInt(32.W))
	when (go) {
		step_reg := var8
	}
	val upper_bound = Mux(go, var7, ub_reg)
	val step = Mux(go, var8, step_reg)
	new_input := start
	when (start) {
		when (var453 <= upper_bound) {
			when (counter === 14.U) {
				var453 := var453 + step
			}
		}.otherwise {
			start := false.B
			new_input := false.B
		}
	}
}
class main extends MultiIOModule {
	val go = IO(Input(Bool()))
	val done = IO(Output(Bool()))
	done := 0.U
	val var461 = IO(Output(UInt(64.W)))
	var461 := DontCare
	val var462 = Reg(UInt(1.W))
	val var463 = Reg(UInt(32.W))
	val var464 = Reg(UInt(64.W))
	val var465 = Reg(UInt(64.W))
	val var466 = Reg(UInt(32.W))
	val var467 = Reg(UInt(1.W))
	val var468 = Reg(UInt(64.W))
	val var469 = Reg(UInt(64.W))
	val outline_0_0 = Module(new outline_0)
	outline_0_0.go := 0.U
	val var470 = outline_0_0.var6
	var470 := DontCare
	val var471 = outline_0_0.var7
	var471 := DontCare
	val var472 = outline_0_0.var8
	var472 := DontCare
	val var473 = outline_0_0.var9
	var473 := DontCare
	val var474 = outline_0_0.var10
	var474 := DontCare
	val var475 = outline_0_0.var11
	val var476 = outline_0_0.done
	val outline_0_0_var0 = IO(Output(UInt(1.W)))
	outline_0_0_var0 := outline_0_0.var0
	val outline_0_0_var1 = IO(Output(UInt(10.W)))
	outline_0_0_var1 := outline_0_0.var1
	val outline_0_0_var3 = IO(Output(UInt(1.W)))
	outline_0_0_var3 := outline_0_0.var3
	val outline_0_0_var4 = IO(Output(UInt(10.W)))
	outline_0_0_var4 := outline_0_0.var4
	val outline_0_0_var2 = IO(Input(UInt(64.W)))
	outline_0_0.var2 := outline_0_0_var2
	val outline_0_0_var5 = IO(Input(UInt(32.W)))
	outline_0_0.var5 := outline_0_0_var5
	val var3 = IO(Output(UInt(1.W)))
	var3 := false.B
	val var4 = IO(Output(UInt(10.W)))
	var4 := DontCare
	val var5 = IO(Input(UInt(32.W)))
	object State extends ChiselEnum {
		val s0, s1, s1_entry, s2, s3, s4, s5, s5_wait, s6, s7, s8 = Value
	}
	val state = RegInit(State.s0)
	val ready = go & (state === State.s0)
	switch (state) {
		is (State.s0) {
			when (go) {
				state := State.s1;
			}
		}
		is (State.s1) {
			val var477 = 0.U <= 1023.U
			var462 := var477
			val var478 = !var477
			var463 := 0.U
			var464 := 0L.U
			when (var478.asBool()) {
				var465 := 0L.U
			}
			state := State.s2;
			when (var478.asBool()) {
				state := State.s8;
			}
		}
		is (State.s1_entry) {
			val var479 = !var462
			when (var479.asBool()) {
				var465 := var464
			}
			state := State.s2;
			when (var479.asBool()) {
				state := State.s8;
			}
		}
		is (State.s2) {
			var4 := var463
			var3 := true.B
			state := State.s3;
		}
		is (State.s3) {
			var466 := var5
			val var480 = var5
			var467 := var480
			state := State.s4;
		}
		is (State.s4) {
			val var481 = !var467
			when (var481.asBool()) {
				var468 := var464
			}
			when (var467.asBool()) {
				state := State.s5;
			}
			when (var481.asBool()) {
				state := State.s7;
			}
		}
		is (State.s5) {
			var470 := 0.U
			var471 := 1023.U
			var472 := 1.U
			var473 := var463
			var474 := var464
			outline_0_0.go := 1.U
			when (var476.asBool()) {
				var469 := var475
			}
			state := State.s5_wait;
			when (var476.asBool()) {
				state := State.s6;
			}
		}
		is (State.s5_wait) {
			when (var476.asBool()) {
				var469 := var475
			}
			when (var476.asBool()) {
				state := State.s6;
			}
		}
		is (State.s6) {
			var468 := var469
			state := State.s7;
		}
		is (State.s7) {
			var464 := var468
			val var482 = var463 + 1.U
			var463 := var482
			val var483 = var482 <= 1023.U
			var462 := var483
			state := State.s1_entry;
		}
		is (State.s8) {
			done := 1.U
			var461 := var465
		}
	}
}
	val main = Module(new main)
	mem_global_0.dataIn(0).valid := main.outline_0_0_var0
	mem_global_0.dataIn(0).bits := main.outline_0_0_var1
	mem_global_1.dataIn(0).valid := main.outline_0_0_var3
	mem_global_1.dataIn(0).bits := main.outline_0_0_var4
	mem_global_1.dataIn(1).valid := main.var3
	mem_global_1.dataIn(1).bits := main.var4
	val go = IO(Input(Bool()))
	main.go := go
	val done = IO(Output(Bool()))
	done := main.done
	main.outline_0_0_var2 := var2
	main.outline_0_0_var5 := var5
  main.var5 := var5

    val result = IO(Output(UInt(64.W)))
  result := main.var461
  mem_global_0.initMem("data_set/aeloss_push/in_0.txt")
  mem_global_1.initMem("data_set/aeloss_push/in_1.txt")
}

