import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class fft extends MultiIOModule {
  val mem_global_0 = Module(new ReadWriteMem(1024, 64))
  val var0 = mem_global_0.w_en
  val var1 = mem_global_0.r_en
  val var2 = mem_global_0.addr
  val var3 = mem_global_0.w_data
  val var4 = mem_global_0.r_data
  val mem_global_1 = Module(new ReadWriteMem(1024, 64))
  val var5 = mem_global_1.w_en
  val var6 = mem_global_1.r_en
  val var7 = mem_global_1.addr
  val var8 = mem_global_1.w_data
  val var9 = mem_global_1.r_data
  val mem_global_2 = Module(new ReadMem(512, 64))
  val var10 = mem_global_2.r_en
  val var11 = mem_global_2.addr
  val var12 = mem_global_2.r_data
  val mem_global_3 = Module(new ReadMem(512, 64))
  val var13 = mem_global_3.r_en
  val var14 = mem_global_3.addr
  val var15 = mem_global_3.r_data
  class outline_0 extends MultiIOModule {
    val go = IO(Input(Bool()))
    val start = RegInit(false.B)
    val new_input = Wire(Bool())
    new_input := false.B
    val done = IO(Output(Bool()))
    done := 0.U
    val var16 = IO(Input(UInt(32.W)))
    val var17 = IO(Input(UInt(32.W)))
    val var18 = IO(Input(UInt(32.W)))
    val var19 = IO(Input(UInt(32.W)))
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
    val var144 = Reg(UInt(32.W))
    val var145 = Reg(UInt(32.W))
    val var146 = Reg(UInt(32.W))
    val var147 = Reg(UInt(32.W))
    val var148 = Reg(UInt(32.W))
    val var149 = Reg(UInt(32.W))
    val var150 = Reg(UInt(32.W))
    val var151 = Reg(UInt(32.W))
    val var152 = Reg(UInt(32.W))
    val var153 = Reg(UInt(32.W))
    val var154 = Reg(UInt(32.W))
    val var155 = Reg(UInt(32.W))
    val var156 = Reg(UInt(32.W))
    val var157 = Reg(UInt(32.W))
    val var158 = Reg(UInt(32.W))
    val var159 = Reg(UInt(32.W))
    val var160 = Reg(UInt(32.W))
    val var161 = Reg(UInt(32.W))
    val var162 = Reg(UInt(32.W))
    val var163 = Reg(UInt(32.W))
    val var164 = Reg(UInt(32.W))
    val var165 = Reg(UInt(32.W))
    val var166 = Reg(UInt(32.W))
    val var167 = Reg(UInt(32.W))
    val var168 = Reg(UInt(32.W))
    val var169 = Reg(UInt(32.W))
    val var170 = Reg(UInt(32.W))
    val var171 = Reg(UInt(32.W))
    val var172 = Reg(UInt(32.W))
    val var173 = Reg(UInt(32.W))
    val var174 = Reg(UInt(32.W))
    val var175 = Reg(UInt(32.W))
    val var176 = Reg(UInt(32.W))
    val var177 = Reg(UInt(32.W))
    val var178 = Reg(UInt(32.W))
    val var179 = Reg(UInt(32.W))
    val var180 = Reg(UInt(32.W))
    val var181 = Reg(UInt(32.W))
    val var182 = Reg(UInt(32.W))
    val var183 = Reg(UInt(32.W))
    val var184 = Reg(UInt(32.W))
    val var185 = Reg(UInt(32.W))
    val var186 = Reg(UInt(32.W))
    val var187 = Reg(UInt(32.W))
    val var188 = Reg(UInt(32.W))
    val var189 = Reg(UInt(32.W))
    val var190 = Reg(UInt(32.W))
    val var191 = Reg(UInt(32.W))
    val var192 = Reg(UInt(32.W))
    val var193 = Reg(UInt(32.W))
    val var194 = Reg(UInt(32.W))
    val var195 = Reg(UInt(32.W))
    val var196 = Reg(UInt(32.W))
    val var197 = Reg(UInt(32.W))
    val var198 = Reg(UInt(32.W))
    val var199 = Reg(UInt(32.W))
    val var200 = Reg(UInt(32.W))
    val var201 = Reg(UInt(1.W))
    val var202 = Reg(UInt(1.W))
    val var203 = Reg(UInt(1.W))
    val var204 = Reg(UInt(1.W))
    val var205 = Reg(UInt(1.W))
    val var206 = Reg(UInt(1.W))
    val var207 = Reg(UInt(1.W))
    val var208 = Reg(UInt(1.W))
    val var209 = Reg(UInt(1.W))
    val var210 = Reg(UInt(1.W))
    val var211 = Reg(UInt(1.W))
    val var212 = Reg(UInt(1.W))
    val var213 = Reg(UInt(1.W))
    val var214 = Reg(UInt(1.W))
    val var215 = Reg(UInt(1.W))
    val var216 = Reg(UInt(1.W))
    val var217 = Reg(UInt(1.W))
    val var218 = Reg(UInt(1.W))
    val var219 = Reg(UInt(1.W))
    val var220 = Reg(UInt(1.W))
    val var221 = Reg(UInt(1.W))
    val var222 = Reg(UInt(1.W))
    val var223 = Reg(UInt(1.W))
    val var224 = Reg(UInt(1.W))
    val var225 = Reg(UInt(1.W))
    val var226 = Reg(UInt(1.W))
    val var227 = Reg(UInt(1.W))
    val var228 = Reg(UInt(1.W))
    val var229 = Reg(UInt(1.W))
    val var230 = Reg(UInt(1.W))
    val var231 = Reg(UInt(1.W))
    val var232 = Reg(UInt(1.W))
    val var233 = Reg(UInt(1.W))
    val var234 = Reg(UInt(1.W))
    val var235 = Reg(UInt(1.W))
    val var236 = Reg(UInt(1.W))
    val var237 = Reg(UInt(1.W))
    val var238 = Reg(UInt(1.W))
    val var239 = Reg(UInt(1.W))
    val var240 = Reg(UInt(1.W))
    val var241 = Reg(UInt(1.W))
    val var242 = Reg(UInt(1.W))
    val var243 = Reg(UInt(1.W))
    val var244 = Reg(UInt(1.W))
    val var245 = Reg(UInt(1.W))
    val var246 = Reg(UInt(1.W))
    val var247 = Reg(UInt(1.W))
    val var248 = Reg(UInt(1.W))
    val var249 = Reg(UInt(1.W))
    val var250 = Reg(UInt(1.W))
    val var251 = Reg(UInt(1.W))
    val var252 = Reg(UInt(1.W))
    val var253 = Reg(UInt(1.W))
    val var254 = Reg(UInt(1.W))
    val var255 = Reg(UInt(1.W))
    val var256 = Reg(UInt(1.W))
    val var257 = Reg(UInt(1.W))
    val var258 = Reg(UInt(1.W))
    val var259 = Reg(UInt(32.W))
    val var260 = Reg(UInt(32.W))
    val var261 = Reg(UInt(32.W))
    val var262 = Reg(UInt(32.W))
    val var263 = Reg(UInt(32.W))
    val var264 = Reg(UInt(32.W))
    val var265 = Reg(UInt(32.W))
    val var266 = Reg(UInt(32.W))
    val var267 = Reg(UInt(32.W))
    val var268 = Reg(UInt(32.W))
    val var269 = Reg(UInt(32.W))
    val var270 = Reg(UInt(32.W))
    val var271 = Reg(UInt(32.W))
    val var272 = Reg(UInt(32.W))
    val var273 = Reg(UInt(32.W))
    val var274 = Reg(UInt(32.W))
    val var275 = Reg(UInt(32.W))
    val var276 = Reg(UInt(32.W))
    val var277 = Reg(UInt(32.W))
    val var278 = Reg(UInt(32.W))
    val var279 = Reg(UInt(32.W))
    val var280 = Reg(UInt(32.W))
    val var281 = Reg(UInt(32.W))
    val var282 = Reg(UInt(32.W))
    val var283 = Reg(UInt(32.W))
    val var284 = Reg(UInt(32.W))
    val var285 = Reg(UInt(32.W))
    val var286 = Reg(UInt(32.W))
    val var287 = Reg(UInt(32.W))
    val var288 = Reg(UInt(32.W))
    val var289 = Reg(UInt(32.W))
    val var290 = Reg(UInt(32.W))
    val var291 = Reg(UInt(32.W))
    val var292 = Reg(UInt(32.W))
    val var293 = Reg(UInt(32.W))
    val var294 = Reg(UInt(32.W))
    val var295 = Reg(UInt(32.W))
    val var296 = Reg(UInt(32.W))
    val var297 = Reg(UInt(32.W))
    val var298 = Reg(UInt(32.W))
    val var299 = Reg(UInt(32.W))
    val var300 = Reg(UInt(32.W))
    val var301 = Reg(UInt(32.W))
    val var302 = Reg(UInt(32.W))
    val var303 = Reg(UInt(32.W))
    val var304 = Reg(UInt(32.W))
    val var305 = Reg(UInt(32.W))
    val var306 = Reg(UInt(32.W))
    val var307 = Reg(UInt(32.W))
    val var308 = Reg(UInt(32.W))
    val var309 = Reg(UInt(32.W))
    val var310 = Reg(UInt(32.W))
    val var311 = Reg(UInt(32.W))
    val var312 = Reg(UInt(32.W))
    val var313 = Reg(UInt(32.W))
    val var314 = Reg(UInt(32.W))
    val var315 = Reg(UInt(32.W))
    val var316 = Reg(UInt(32.W))
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
    val var332 = Reg(UInt(64.W))
    val var333 = Reg(UInt(64.W))
    val var334 = Reg(UInt(64.W))
    val var335 = Reg(UInt(64.W))
    val var336 = Reg(UInt(64.W))
    val var337 = Reg(UInt(64.W))
    val var338 = Reg(UInt(64.W))
    val var339 = Reg(UInt(64.W))
    val var340 = Reg(UInt(64.W))
    val var341 = Reg(UInt(64.W))
    val var342 = Reg(UInt(64.W))
    val var343 = Reg(UInt(64.W))
    val var344 = Reg(UInt(64.W))
    val var345 = Reg(UInt(64.W))
    val var346 = Reg(UInt(64.W))
    val var347 = Reg(UInt(64.W))
    val var348 = Reg(UInt(64.W))
    val var349 = Reg(UInt(64.W))
    val var350 = Reg(UInt(64.W))
    val var351 = Reg(UInt(64.W))
    val var352 = Reg(UInt(64.W))
    val var353 = Reg(UInt(64.W))
    val var354 = Reg(UInt(64.W))
    val var355 = Reg(UInt(64.W))
    val var356 = Reg(UInt(64.W))
    val var357 = Reg(UInt(64.W))
    val var358 = Reg(UInt(64.W))
    val var359 = Reg(UInt(64.W))
    val var360 = Reg(UInt(64.W))
    val var361 = Reg(UInt(64.W))
    val var362 = Reg(UInt(64.W))
    val var363 = Reg(UInt(64.W))
    val var364 = Reg(UInt(64.W))
    val var365 = Reg(UInt(64.W))
    val var366 = Reg(UInt(64.W))
    val var367 = Reg(UInt(64.W))
    val var368 = Reg(UInt(64.W))
    val var369 = Reg(UInt(64.W))
    val var370 = Reg(UInt(64.W))
    val var371 = Reg(UInt(64.W))
    val var372 = Reg(UInt(64.W))
    val var373 = Reg(UInt(64.W))
    val var374 = Reg(UInt(64.W))
    val var375 = Reg(UInt(64.W))
    val var376 = Reg(UInt(64.W))
    val var377 = Reg(UInt(64.W))
    val var378 = Reg(UInt(64.W))
    val var379 = Reg(UInt(64.W))
    val var380 = Reg(UInt(64.W))
    val var381 = Reg(UInt(64.W))
    val var382 = Reg(UInt(64.W))
    val var383 = Reg(UInt(64.W))
    val var384 = Reg(UInt(64.W))
    val var385 = Reg(UInt(64.W))
    val var386 = Reg(UInt(64.W))
    val var387 = Reg(UInt(64.W))
    val var388 = Reg(UInt(64.W))
    val var389 = Reg(UInt(64.W))
    val var390 = Reg(UInt(64.W))
    val var391 = Reg(UInt(64.W))
    val var392 = Reg(UInt(64.W))
    val var393 = Reg(UInt(64.W))
    val var394 = Reg(UInt(64.W))
    val var395 = Reg(UInt(64.W))
    val var396 = Reg(UInt(64.W))
    val var397 = Reg(UInt(64.W))
    val var398 = Reg(UInt(64.W))
    val var399 = Reg(UInt(64.W))
    val var400 = Reg(UInt(64.W))
    val var401 = Reg(UInt(64.W))
    val var402 = Reg(UInt(64.W))
    val var403 = Reg(UInt(64.W))
    val var404 = Reg(UInt(64.W))
    val var405 = Reg(UInt(64.W))
    val var406 = Reg(UInt(64.W))
    val var407 = Reg(UInt(64.W))
    val var408 = Reg(UInt(64.W))
    val var409 = Reg(UInt(64.W))
    val var410 = Reg(UInt(64.W))
    val addf_outline_0_0 = Module(new AddSubFBase(10, 11, 53, true))
    addf_outline_0_0.ce := true.B
    val var411 = addf_outline_0_0.operand0
    var411 := DontCare
    val var412 = addf_outline_0_0.operand1
    var412 := DontCare
    val var413 = addf_outline_0_0.result
    val subf_outline_0_0 = Module(new AddSubFBase(10, 11, 53, false))
    subf_outline_0_0.ce := true.B
    val var414 = subf_outline_0_0.operand0
    var414 := DontCare
    val var415 = subf_outline_0_0.operand1
    var415 := DontCare
    val var416 = subf_outline_0_0.result
    val addf_outline_0_1 = Module(new AddSubFBase(10, 11, 53, true))
    addf_outline_0_1.ce := true.B
    val var417 = addf_outline_0_1.operand0
    var417 := DontCare
    val var418 = addf_outline_0_1.operand1
    var418 := DontCare
    val var419 = addf_outline_0_1.result
    val subf_outline_0_1 = Module(new AddSubFBase(10, 11, 53, false))
    subf_outline_0_1.ce := true.B
    val var420 = subf_outline_0_1.operand0
    var420 := DontCare
    val var421 = subf_outline_0_1.operand1
    var421 := DontCare
    val var422 = subf_outline_0_1.result
    val mulf_outline_0_0 = Module(new MulFBase(6, 11, 53))
    mulf_outline_0_0.ce := true.B
    val var423 = mulf_outline_0_0.operand0
    var423 := DontCare
    val var424 = mulf_outline_0_0.operand1
    var424 := DontCare
    val var425 = mulf_outline_0_0.result
    val mulf_outline_0_1 = Module(new MulFBase(6, 11, 53))
    mulf_outline_0_1.ce := true.B
    val var426 = mulf_outline_0_1.operand0
    var426 := DontCare
    val var427 = mulf_outline_0_1.operand1
    var427 := DontCare
    val var428 = mulf_outline_0_1.result
    val subf_outline_0_2 = Module(new AddSubFBase(10, 11, 53, false))
    subf_outline_0_2.ce := true.B
    val var429 = subf_outline_0_2.operand0
    var429 := DontCare
    val var430 = subf_outline_0_2.operand1
    var430 := DontCare
    val var431 = subf_outline_0_2.result
    val mulf_outline_0_2 = Module(new MulFBase(6, 11, 53))
    mulf_outline_0_2.ce := true.B
    val var432 = mulf_outline_0_2.operand0
    var432 := DontCare
    val var433 = mulf_outline_0_2.operand1
    var433 := DontCare
    val var434 = mulf_outline_0_2.result
    val mulf_outline_0_3 = Module(new MulFBase(6, 11, 53))
    mulf_outline_0_3.ce := true.B
    val var435 = mulf_outline_0_3.operand0
    var435 := DontCare
    val var436 = mulf_outline_0_3.operand1
    var436 := DontCare
    val var437 = mulf_outline_0_3.result
    val addf_outline_0_2 = Module(new AddSubFBase(10, 11, 53, true))
    addf_outline_0_2.ce := true.B
    val var438 = addf_outline_0_2.operand0
    var438 := DontCare
    val var439 = addf_outline_0_2.operand1
    var439 := DontCare
    val var440 = addf_outline_0_2.result
    val var441 = Reg(UInt(32.W))
    when (go) {
      var441 := var16
    }
    when (go) {
      var20 := var16
    }
    when (go) {
      var21 := var17
    }
    when (go) {
      var22 := var18
    }
    when (go) {
      var23 := var19
    }
    when (go) {
      var83 := var16
    }
    val var0 = IO(Output(UInt(1.W)))
    var0 := false.B
    val var1 = IO(Output(UInt(1.W)))
    var1 := false.B
    val var2 = IO(Output(UInt(10.W)))
    var2 := DontCare
    val var3 = IO(Output(UInt(64.W)))
    var3 := DontCare
    val var5 = IO(Output(UInt(1.W)))
    var5 := false.B
    val var6 = IO(Output(UInt(1.W)))
    var6 := false.B
    val var7 = IO(Output(UInt(10.W)))
    var7 := DontCare
    val var8 = IO(Output(UInt(64.W)))
    var8 := DontCare
    val var10 = IO(Output(UInt(1.W)))
    var10 := false.B
    val var11 = IO(Output(UInt(9.W)))
    var11 := DontCare
    val var13 = IO(Output(UInt(1.W)))
    var13 := false.B
    val var14 = IO(Output(UInt(9.W)))
    var14 := DontCare
    val var4 = IO(Input(UInt(64.W)))
    val var9 = IO(Input(UInt(64.W)))
    val var12 = IO(Input(UInt(64.W)))
    val var15 = IO(Input(UInt(64.W)))
    val shift_register = RegInit(0.U(2.W))
    when (go) {
      when (var16 > var17) {
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
	shift_register(0)
      } else if (stage == 17) {
	shift_register(0)
      } else if (stage == 18) {
	shift_register(0)
      } else if (stage == 19) {
	shift_register(0)
      } else if (stage == 20) {
	shift_register(0)
      } else if (stage == 21) {
	shift_register(0)
      } else if (stage == 22) {
	shift_register(0)
      } else if (stage == 23) {
	shift_register(0)
      } else if (stage == 24) {
	shift_register(0)
      } else if (stage == 25) {
	shift_register(0)
      } else if (stage == 26) {
	shift_register(0)
      } else if (stage == 27) {
	shift_register(0)
      } else if (stage == 28) {
	shift_register(0)
      } else if (stage == 29) {
	shift_register(0)
      } else if (stage == 30) {
	shift_register(0)
      } else if (stage == 31) {
	shift_register(0)
      } else if (stage == 32) {
	shift_register(0)
      } else if (stage == 33) {
	shift_register(0)
      } else if (stage == 34) {
	shift_register(0)
      } else if (stage == 35) {
	shift_register(0)
      } else if (stage == 36) {
	shift_register(0)
      } else if (stage == 37) {
	shift_register(0)
      } else if (stage == 38) {
	shift_register(0)
      } else if (stage == 39) {
	shift_register(0)
      } else if (stage == 40) {
	shift_register(0)
      } else if (stage == 41) {
	shift_register(1)
      } else if (stage == 42) {
	shift_register(1)
      } else if (stage == 43) {
	shift_register(1)
      } else if (stage == 44) {
	shift_register(1)
      } else if (stage == 45) {
	shift_register(1)
      } else if (stage == 46) {
	shift_register(1)
      } else if (stage == 47) {
	shift_register(1)
      } else if (stage == 48) {
	shift_register(1)
      } else if (stage == 49) {
	shift_register(1)
      } else if (stage == 50) {
	shift_register(1)
      } else if (stage == 51) {
	shift_register(1)
      } else if (stage == 52) {
	shift_register(1)
      } else if (stage == 53) {
	shift_register(1)
      } else if (stage == 54) {
	shift_register(1)
      } else if (stage == 55) {
	shift_register(1)
      } else if (stage == 56) {
	shift_register(1)
      } else if (stage == 57) {
	shift_register(1)
      } else if (stage == 58) {
	shift_register(1)
      } else if (stage == 59) {
	shift_register(1)
      } else {
	new_input
      }
    }
    val counter = RegInit(0.U(6.W))
    when (counter === 39.U) {
      counter := 0.U
    }.otherwise {
      when (start || shift_register =/= 0.U) {
	counter := counter + 1.U
      }
    }
    when (counter === 0.U) {
      shift_register := Cat(shift_register(0, 0), new_input)
    }
    when (counter === 0.U) {
      when (valid(0)) {
	var24 := var441
      }
      when (valid(40) && var239.asBool()) {
	var398 := var9
      }
      when (var239.asBool()) {
	var2 := var125
      }
      when (var239.asBool()) {
	var1 := 1.U
      }
      when (var239.asBool()) {
	var432 := var373
      }
      when (var239.asBool()) {
	var433 := var9
      }
      when (valid(40)) {
	var64 := var63
      }
      when (valid(40)) {
	var126 := var125
      }
      when (valid(40)) {
	var240 := var239
      }
      when (valid(40)) {
	var298 := var297
      }
      when (valid(40)) {
	var354 := var353
      }
      when (valid(40)) {
	var374 := var373
      }
      when (valid(40)) {
	var391 := var390
      }
      when (valid(40)) {
	var396 := var395
      }
    }
    when (counter === 1.U) {
      val var442 = var24 - var20
      when (valid(1)) {
	var85 := var442
      }
      val var443 = var442 + var20
      when (valid(1)) {
	var86 := var443
      }
      val var444 = var83 | var20
      when (valid(1)) {
	var87 := var444
      }
      val var445 = var444 ^ var20
      when (valid(1)) {
	var145 := var445
      }
      val var446 = var445 << var23
      when (valid(1)) {
	var163 := var446
      }
      val var447 = var446 & 1023.U
      when (valid(1)) {
	var164 := var447
      }
      val var448 = var447
      when (valid(1)) {
	var201 := var448
      }
      val var449 = var443 + 1.U
      when (valid(1)) {
	var259 := var449
      }
      when (valid(59)) {
	var83 := var449
//	var450 := var449
	when (!valid(19)) {
	  done := true.B
	}
      }
      when (valid(1)) {
	var25 := var24
      }
      when (valid(1)) {
	var84 := var83
      }
      when (valid(41) && var240.asBool()) {
	var399 := var9
      }
      when (valid(41) && var240.asBool()) {
	var401 := var4
      }
      when (var240.asBool()) {
	var435 := var396
      }
      when (var240.asBool()) {
	var436 := var4
      }
      when (valid(41)) {
	var65 := var64
      }
      when (valid(41)) {
	var127 := var126
      }
      when (valid(41)) {
	var241 := var240
      }
      when (valid(41)) {
	var299 := var298
      }
      when (valid(41)) {
	var355 := var354
      }
      when (valid(41)) {
	var392 := var391
      }
      when (valid(41)) {
	var397 := var396
      }
    }
    when (counter === 2.U) {
      var2 := var87
      var1 := 1.U
      var7 := var87
      var6 := 1.U
      when (valid(2)) {
	var26 := var25
      }
      when (valid(2)) {
	var88 := var87
      }
      when (valid(2)) {
	var146 := var145
      }
      when (valid(2)) {
	var165 := var164
      }
      when (valid(2)) {
	var202 := var201
      }
      when (valid(2)) {
	var260 := var259
      }
      when (valid(42) && var241.asBool()) {
	var402 := var4
      }
      when (var241.asBool()) {
	var426 := var355
      }
      when (var241.asBool()) {
	var427 := var399
      }
      when (valid(42)) {
	var66 := var65
      }
      when (valid(42)) {
	var128 := var127
      }
      when (valid(42)) {
	var242 := var241
      }
      when (valid(42)) {
	var300 := var299
      }
      when (valid(42)) {
	var356 := var355
      }
      when (valid(42)) {
	var393 := var392
      }
      when (valid(42)) {
	var400 := var399
      }
    }
    when (counter === 3.U) {
      var2 := var146
      var1 := 1.U
      var7 := var146
      var6 := 1.U
      when (valid(3)) {
	var27 := var26
      }
      when (valid(3)) {
	var89 := var88
      }
      when (valid(3)) {
	var147 := var146
      }
      when (valid(3)) {
	var166 := var165
      }
      when (valid(3)) {
	var203 := var202
      }
      when (valid(3)) {
	var261 := var260
      }
      when (var242.asBool()) {
	var423 := var393
      }
      when (var242.asBool()) {
	var424 := var402
      }
      when (valid(43)) {
	var67 := var66
      }
      when (valid(43)) {
	var129 := var128
      }
      when (valid(43)) {
	var243 := var242
      }
      when (valid(43)) {
	var301 := var300
      }
      when (valid(43)) {
	var394 := var393
      }
      when (valid(43)) {
	var403 := var402
      }
    }
    when (counter === 4.U) {
      when (valid(4)) {
	var317 := var4
      }
      when (valid(4)) {
	var320 := var9
      }
      var2 := var89
      var1 := 1.U
      var7 := var89
      var6 := 1.U
      when (valid(4)) {
	var28 := var27
      }
      when (valid(4)) {
	var90 := var89
      }
      when (valid(4)) {
	var148 := var147
      }
      when (valid(4)) {
	var167 := var166
      }
      when (valid(4)) {
	var204 := var203
      }
      when (valid(4)) {
	var262 := var261
      }
      when (valid(44)) {
	var68 := var67
      }
      when (valid(44)) {
	var130 := var129
      }
      when (valid(44)) {
	var244 := var243
      }
      when (valid(44)) {
	var302 := var301
      }
    }
    when (counter === 5.U) {
      when (valid(5)) {
	var322 := var4
      }
      when (valid(5)) {
	var324 := var9
      }
      var2 := var148
      var1 := 1.U
      var7 := var148
      var6 := 1.U
      var420 := var9
      var421 := var320
      when (valid(5)) {
	var29 := var28
      }
      when (valid(5)) {
	var91 := var90
      }
      when (valid(5)) {
	var149 := var148
      }
      when (valid(5)) {
	var168 := var167
      }
      when (valid(5)) {
	var205 := var204
      }
      when (valid(5)) {
	var263 := var262
      }
      when (valid(5)) {
	var318 := var317
      }
      when (valid(5)) {
	var321 := var320
      }
      when (valid(45)) {
	var69 := var68
      }
      when (valid(45)) {
	var131 := var130
      }
      when (valid(45)) {
	var245 := var244
      }
      when (valid(45)) {
	var303 := var302
      }
    }
    when (counter === 6.U) {
      when (valid(6)) {
	var325 := var4
      }
      when (valid(6)) {
	var328 := var9
      }
      var414 := var322
      var415 := var318
      when (valid(6)) {
	var30 := var29
      }
      when (valid(6)) {
	var92 := var91
      }
      when (valid(6)) {
	var150 := var149
      }
      when (valid(6)) {
	var169 := var168
      }
      when (valid(6)) {
	var206 := var205
      }
      when (valid(6)) {
	var264 := var263
      }
      when (valid(6)) {
	var319 := var318
      }
      when (valid(6)) {
	var323 := var322
      }
      when (valid(46) && var245.asBool()) {
	var404 := var434
      }
      when (valid(46)) {
	var70 := var69
      }
      when (valid(46)) {
	var132 := var131
      }
      when (valid(46)) {
	var246 := var245
      }
      when (valid(46)) {
	var304 := var303
      }
    }
    when (counter === 7.U) {
      when (valid(7)) {
	var330 := var4
      }
      when (valid(7)) {
	var332 := var9
      }
      var417 := var9
      var418 := var328
      when (valid(7)) {
	var31 := var30
      }
      when (valid(7)) {
	var93 := var92
      }
      when (valid(7)) {
	var151 := var150
      }
      when (valid(7)) {
	var170 := var169
      }
      when (valid(7)) {
	var207 := var206
      }
      when (valid(7)) {
	var265 := var264
      }
      when (valid(7)) {
	var326 := var325
      }
      when (valid(7)) {
	var329 := var328
      }
      when (valid(47) && var246.asBool()) {
	var406 := var437
      }
      when (var246.asBool()) {
	var438 := var404
      }
      when (var246.asBool()) {
	var439 := var437
      }
      when (valid(47)) {
	var71 := var70
      }
      when (valid(47)) {
	var133 := var132
      }
      when (valid(47)) {
	var247 := var246
      }
      when (valid(47)) {
	var305 := var304
      }
      when (valid(47)) {
	var405 := var404
      }
    }
    when (counter === 8.U) {
      var411 := var330
      var412 := var326
      when (valid(8)) {
	var32 := var31
      }
      when (valid(8)) {
	var94 := var93
      }
      when (valid(8)) {
	var152 := var151
      }
      when (valid(8)) {
	var171 := var170
      }
      when (valid(8)) {
	var208 := var207
      }
      when (valid(8)) {
	var266 := var265
      }
      when (valid(8)) {
	var327 := var326
      }
      when (valid(8)) {
	var331 := var330
      }
      when (valid(48) && var247.asBool()) {
	var407 := var428
      }
      when (valid(48)) {
	var72 := var71
      }
      when (valid(48)) {
	var134 := var133
      }
      when (valid(48)) {
	var248 := var247
      }
      when (valid(48)) {
	var306 := var305
      }
    }
    when (counter === 9.U) {
      when (valid(9)) {
	var33 := var32
      }
      when (valid(9)) {
	var95 := var94
      }
      when (valid(9)) {
	var153 := var152
      }
      when (valid(9)) {
	var172 := var171
      }
      when (valid(9)) {
	var209 := var208
      }
      when (valid(9)) {
	var267 := var266
      }
      when (valid(49) && var248.asBool()) {
	var409 := var425
      }
      when (var248.asBool()) {
	var429 := var425
      }
      when (var248.asBool()) {
	var430 := var407
      }
      when (valid(49)) {
	var73 := var72
      }
      when (valid(49)) {
	var135 := var134
      }
      when (valid(49)) {
	var249 := var248
      }
      when (valid(49)) {
	var307 := var306
      }
      when (valid(49)) {
	var408 := var407
      }
    }
    when (counter === 10.U) {
      when (valid(10)) {
	var34 := var33
      }
      when (valid(10)) {
	var96 := var95
      }
      when (valid(10)) {
	var154 := var153
      }
      when (valid(10)) {
	var173 := var172
      }
      when (valid(10)) {
	var210 := var209
      }
      when (valid(10)) {
	var268 := var267
      }
      when (valid(50)) {
	var74 := var73
      }
      when (valid(50)) {
	var136 := var135
      }
      when (valid(50)) {
	var250 := var249
      }
      when (valid(50)) {
	var308 := var307
      }
    }
    when (counter === 11.U) {
      when (valid(11)) {
	var35 := var34
      }
      when (valid(11)) {
	var97 := var96
      }
      when (valid(11)) {
	var155 := var154
      }
      when (valid(11)) {
	var174 := var173
      }
      when (valid(11)) {
	var211 := var210
      }
      when (valid(11)) {
	var269 := var268
      }
      when (valid(51)) {
	var75 := var74
      }
      when (valid(51)) {
	var137 := var136
      }
      when (valid(51)) {
	var251 := var250
      }
      when (valid(51)) {
	var309 := var308
      }
    }
    when (counter === 12.U) {
      when (valid(12)) {
	var36 := var35
      }
      when (valid(12)) {
	var98 := var97
      }
      when (valid(12)) {
	var156 := var155
      }
      when (valid(12)) {
	var175 := var174
      }
      when (valid(12)) {
	var212 := var211
      }
      when (valid(12)) {
	var270 := var269
      }
      when (valid(52)) {
	var76 := var75
      }
      when (valid(52)) {
	var138 := var137
      }
      when (valid(52)) {
	var252 := var251
      }
      when (valid(52)) {
	var310 := var309
      }
    }
    when (counter === 13.U) {
      when (valid(13)) {
	var37 := var36
      }
      when (valid(13)) {
	var99 := var98
      }
      when (valid(13)) {
	var157 := var156
      }
      when (valid(13)) {
	var176 := var175
      }
      when (valid(13)) {
	var213 := var212
      }
      when (valid(13)) {
	var271 := var270
      }
      when (valid(53)) {
	var77 := var76
      }
      when (valid(53)) {
	var139 := var138
      }
      when (valid(53)) {
	var253 := var252
      }
      when (valid(53)) {
	var311 := var310
      }
    }
    when (counter === 14.U) {
      when (valid(14)) {
	var38 := var37
      }
      when (valid(14)) {
	var100 := var99
      }
      when (valid(14)) {
	var158 := var157
      }
      when (valid(14)) {
	var177 := var176
      }
      when (valid(14)) {
	var214 := var213
      }
      when (valid(14)) {
	var272 := var271
      }
      when (valid(54)) {
	var78 := var77
      }
      when (valid(54)) {
	var140 := var139
      }
      when (valid(54)) {
	var254 := var253
      }
      when (valid(54)) {
	var312 := var311
      }
    }
    when (counter === 15.U) {
      when (valid(15)) {
	var333 := var422
      }
      var7 := var100
      var8 := var422
      var5 := 1.U
      when (valid(15)) {
	var39 := var38
      }
      when (valid(15)) {
	var101 := var100
      }
      when (valid(15)) {
	var159 := var158
      }
      when (valid(15)) {
	var178 := var177
      }
      when (valid(15)) {
	var215 := var214
      }
      when (valid(15)) {
	var273 := var272
      }
      when (valid(55)) {
	var79 := var78
      }
      when (valid(55)) {
	var141 := var140
      }
      when (valid(55)) {
	var255 := var254
      }
      when (valid(55)) {
	var313 := var312
      }
    }
    when (counter === 16.U) {
      when (valid(16)) {
	var334 := var416
      }
      var2 := var101
      var3 := var416
      var0 := 1.U
      when (valid(16)) {
	var40 := var39
      }
      when (valid(16)) {
	var102 := var101
      }
      when (valid(16)) {
	var160 := var159
      }
      when (valid(16)) {
	var179 := var178
      }
      when (valid(16)) {
	var216 := var215
      }
      when (valid(16)) {
	var274 := var273
      }
      when (valid(56)) {
	var80 := var79
      }
      when (valid(56)) {
	var142 := var141
      }
      when (valid(56)) {
	var256 := var255
      }
      when (valid(56)) {
	var314 := var313
      }
    }
    when (counter === 17.U) {
      when (valid(17)) {
	var335 := var419
      }
      var7 := var160
      var8 := var419
      var5 := 1.U
      when (valid(17)) {
	var41 := var40
      }
      when (valid(17)) {
	var103 := var102
      }
      when (valid(17)) {
	var161 := var160
      }
      when (valid(17)) {
	var180 := var179
      }
      when (valid(17)) {
	var217 := var216
      }
      when (valid(17)) {
	var275 := var274
      }
      when (valid(57) && var256.asBool()) {
	var410 := var440
      }
      when (var256.asBool()) {
	var7 := var142
      }
      when (var256.asBool()) {
	var8 := var440
      }
      when (var256.asBool()) {
	var5 := 1.U
      }
      when (valid(57)) {
	var81 := var80
      }
      when (valid(57)) {
	var143 := var142
      }
      when (valid(57)) {
	var257 := var256
      }
      when (valid(57)) {
	var315 := var314
      }
    }
    when (counter === 18.U) {
      when (valid(18)) {
	var336 := var413
      }
      var2 := var161
      var3 := var413
      var0 := 1.U
      when (valid(18)) {
	var42 := var41
      }
      when (valid(18)) {
	var104 := var103
      }
      when (valid(18)) {
	var162 := var161
      }
      when (valid(18)) {
	var181 := var180
      }
      when (valid(18)) {
	var218 := var217
      }
      when (valid(18)) {
	var276 := var275
      }
      when (valid(58)) {
	var82 := var81
      }
      when (valid(58)) {
	var144 := var143
      }
      when (valid(58)) {
	var258 := var257
      }
      when (valid(58)) {
	var316 := var315
      }
    }
    when (counter === 19.U) {
      when (valid(19)) {
	var43 := var42
      }
      when (valid(19)) {
	var105 := var104
      }
      when (valid(19)) {
	var182 := var181
      }
      when (valid(19)) {
	var219 := var218
      }
      when (valid(19)) {
	var277 := var276
      }
      when (var258.asBool()) {
	var2 := var144
      }
      when (var258.asBool()) {
	var3 := var431
      }
      when (var258.asBool()) {
	var0 := 1.U
      }
    }
    when (counter === 20.U) {
      when (valid(20)) {
	var44 := var43
      }
      when (valid(20)) {
	var106 := var105
      }
      when (valid(20)) {
	var183 := var182
      }
      when (valid(20)) {
	var220 := var219
      }
      when (valid(20)) {
	var278 := var277
      }
    }
    when (counter === 21.U) {
      when (var220.asBool()) {
	var14 := var183
      }
      when (var220.asBool()) {
	var13 := 1.U
      }
      when (var220.asBool()) {
	var11 := var183
      }
      when (var220.asBool()) {
	var10 := 1.U
      }
      when (valid(21)) {
	var45 := var44
      }
      when (valid(21)) {
	var107 := var106
      }
      when (valid(21)) {
	var184 := var183
      }
      when (valid(21)) {
	var221 := var220
      }
      when (valid(21)) {
	var279 := var278
      }
    }
    when (counter === 22.U) {
      when (var221.asBool()) {
	var11 := var184
      }
      when (var221.asBool()) {
	var10 := 1.U
      }
      when (valid(22)) {
	var46 := var45
      }
      when (valid(22)) {
	var108 := var107
      }
      when (valid(22)) {
	var185 := var184
      }
      when (valid(22)) {
	var222 := var221
      }
      when (valid(22)) {
	var280 := var279
      }
    }
    when (counter === 23.U) {
      when (valid(23) && var222.asBool()) {
	var337 := var15
      }
      when (valid(23) && var222.asBool()) {
	var357 := var12
      }
      when (valid(23)) {
	var47 := var46
      }
      when (valid(23)) {
	var109 := var108
      }
      when (valid(23)) {
	var186 := var185
      }
      when (valid(23)) {
	var223 := var222
      }
      when (valid(23)) {
	var281 := var280
      }
    }
    when (counter === 24.U) {
      when (valid(24) && var223.asBool()) {
	var375 := var12
      }
      when (valid(24)) {
	var48 := var47
      }
      when (valid(24)) {
	var110 := var109
      }
      when (valid(24)) {
	var187 := var186
      }
      when (valid(24)) {
	var224 := var223
      }
      when (valid(24)) {
	var282 := var281
      }
      when (valid(24)) {
	var338 := var337
      }
      when (valid(24)) {
	var358 := var357
      }
    }
    when (counter === 25.U) {
      when (valid(25)) {
	var49 := var48
      }
      when (valid(25)) {
	var111 := var110
      }
      when (valid(25)) {
	var188 := var187
      }
      when (valid(25)) {
	var225 := var224
      }
      when (valid(25)) {
	var283 := var282
      }
      when (valid(25)) {
	var339 := var338
      }
      when (valid(25)) {
	var359 := var358
      }
      when (valid(25)) {
	var376 := var375
      }
    }
    when (counter === 26.U) {
      when (valid(26)) {
	var50 := var49
      }
      when (valid(26)) {
	var112 := var111
      }
      when (valid(26)) {
	var189 := var188
      }
      when (valid(26)) {
	var226 := var225
      }
      when (valid(26)) {
	var284 := var283
      }
      when (valid(26)) {
	var340 := var339
      }
      when (valid(26)) {
	var360 := var359
      }
      when (valid(26)) {
	var377 := var376
      }
    }
    when (counter === 27.U) {
      when (valid(27)) {
	var51 := var50
      }
      when (valid(27)) {
	var113 := var112
      }
      when (valid(27)) {
	var190 := var189
      }
      when (valid(27)) {
	var227 := var226
      }
      when (valid(27)) {
	var285 := var284
      }
      when (valid(27)) {
	var341 := var340
      }
      when (valid(27)) {
	var361 := var360
      }
      when (valid(27)) {
	var378 := var377
      }
    }
    when (counter === 28.U) {
      when (valid(28)) {
	var52 := var51
      }
      when (valid(28)) {
	var114 := var113
      }
      when (valid(28)) {
	var191 := var190
      }
      when (valid(28)) {
	var228 := var227
      }
      when (valid(28)) {
	var286 := var285
      }
      when (valid(28)) {
	var342 := var341
      }
      when (valid(28)) {
	var362 := var361
      }
      when (valid(28)) {
	var379 := var378
      }
    }
    when (counter === 29.U) {
      when (valid(29)) {
	var53 := var52
      }
      when (valid(29)) {
	var115 := var114
      }
      when (valid(29)) {
	var192 := var191
      }
      when (valid(29)) {
	var229 := var228
      }
      when (valid(29)) {
	var287 := var286
      }
      when (valid(29)) {
	var343 := var342
      }
      when (valid(29)) {
	var363 := var362
      }
      when (valid(29)) {
	var380 := var379
      }
    }
    when (counter === 30.U) {
      when (valid(30)) {
	var54 := var53
      }
      when (valid(30)) {
	var116 := var115
      }
      when (valid(30)) {
	var193 := var192
      }
      when (valid(30)) {
	var230 := var229
      }
      when (valid(30)) {
	var288 := var287
      }
      when (valid(30)) {
	var344 := var343
      }
      when (valid(30)) {
	var364 := var363
      }
      when (valid(30)) {
	var381 := var380
      }
    }
    when (counter === 31.U) {
      when (valid(31)) {
	var55 := var54
      }
      when (valid(31)) {
	var117 := var116
      }
      when (valid(31)) {
	var194 := var193
      }
      when (valid(31)) {
	var231 := var230
      }
      when (valid(31)) {
	var289 := var288
      }
      when (valid(31)) {
	var345 := var344
      }
      when (valid(31)) {
	var365 := var364
      }
      when (valid(31)) {
	var382 := var381
      }
    }
    when (counter === 32.U) {
      when (valid(32)) {
	var56 := var55
      }
      when (valid(32)) {
	var118 := var117
      }
      when (valid(32)) {
	var195 := var194
      }
      when (valid(32)) {
	var232 := var231
      }
      when (valid(32)) {
	var290 := var289
      }
      when (valid(32)) {
	var346 := var345
      }
      when (valid(32)) {
	var366 := var365
      }
      when (valid(32)) {
	var383 := var382
      }
    }
    when (counter === 33.U) {
      when (valid(33)) {
	var57 := var56
      }
      when (valid(33)) {
	var119 := var118
      }
      when (valid(33)) {
	var196 := var195
      }
      when (valid(33)) {
	var233 := var232
      }
      when (valid(33)) {
	var291 := var290
      }
      when (valid(33)) {
	var347 := var346
      }
      when (valid(33)) {
	var367 := var366
      }
      when (valid(33)) {
	var384 := var383
      }
    }
    when (counter === 34.U) {
      when (valid(34)) {
	var58 := var57
      }
      when (valid(34)) {
	var120 := var119
      }
      when (valid(34)) {
	var197 := var196
      }
      when (valid(34)) {
	var234 := var233
      }
      when (valid(34)) {
	var292 := var291
      }
      when (valid(34)) {
	var348 := var347
      }
      when (valid(34)) {
	var368 := var367
      }
      when (valid(34)) {
	var385 := var384
      }
    }
    when (counter === 35.U) {
      when (valid(35)) {
	var59 := var58
      }
      when (valid(35)) {
	var121 := var120
      }
      when (valid(35)) {
	var198 := var197
      }
      when (valid(35)) {
	var235 := var234
      }
      when (valid(35)) {
	var293 := var292
      }
      when (valid(35)) {
	var349 := var348
      }
      when (valid(35)) {
	var369 := var368
      }
      when (valid(35)) {
	var386 := var385
      }
    }
    when (counter === 36.U) {
      when (valid(36)) {
	var60 := var59
      }
      when (valid(36)) {
	var122 := var121
      }
      when (valid(36)) {
	var199 := var198
      }
      when (valid(36)) {
	var236 := var235
      }
      when (valid(36)) {
	var294 := var293
      }
      when (valid(36)) {
	var350 := var349
      }
      when (valid(36)) {
	var370 := var369
      }
      when (valid(36)) {
	var387 := var386
      }
    }
    when (counter === 37.U) {
      when (var236.asBool()) {
	var14 := var199
      }
      when (var236.asBool()) {
	var13 := 1.U
      }
      when (valid(37)) {
	var61 := var60
      }
      when (valid(37)) {
	var123 := var122
      }
      when (valid(37)) {
	var200 := var199
      }
      when (valid(37)) {
	var237 := var236
      }
      when (valid(37)) {
	var295 := var294
      }
      when (valid(37)) {
	var351 := var350
      }
      when (valid(37)) {
	var371 := var370
      }
      when (valid(37)) {
	var388 := var387
      }
    }
    when (counter === 38.U) {
      when (var237.asBool()) {
	var7 := var123
      }
      when (var237.asBool()) {
	var6 := 1.U
      }
      when (valid(38)) {
	var62 := var61
      }
      when (valid(38)) {
	var124 := var123
      }
      when (valid(38)) {
	var238 := var237
      }
      when (valid(38)) {
	var296 := var295
      }
      when (valid(38)) {
	var352 := var351
      }
      when (valid(38)) {
	var372 := var371
      }
      when (valid(38)) {
	var389 := var388
      }
    }
    when (counter === 39.U) {
      when (valid(39) && var238.asBool()) {
	var395 := var15
      }
      when (var238.asBool()) {
	var7 := var124
      }
      when (var238.asBool()) {
	var6 := 1.U
      }
      when (var238.asBool()) {
	var2 := var124
      }
      when (var238.asBool()) {
	var1 := 1.U
      }
      when (valid(39)) {
	var63 := var62
      }
      when (valid(39)) {
	var125 := var124
      }
      when (valid(39)) {
	var239 := var238
      }
      when (valid(39)) {
	var297 := var296
      }
      when (valid(39)) {
	var353 := var352
      }
      when (valid(39)) {
	var373 := var372
      }
      when (valid(39)) {
	var390 := var389
      }
    }
    when (done) {
      shift_register := 0.U
      counter := 0.U
    }
    val ub_reg = Reg(UInt(32.W))
    when (go) {
      ub_reg := var17
    }
    val step_reg = Reg(UInt(32.W))
    when (go) {
      step_reg := var18
    }
    val upper_bound = Mux(go, var17, ub_reg)
    val step = Mux(go, var18, step_reg)
    new_input := start
    when (start) {
      when (var441 <= upper_bound) {
	when (counter === 39.U) {
	  var441 := var441 + step
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
    val var451 = Reg(UInt(32.W))
    val var452 = Reg(UInt(1.W))
    val var453 = Reg(UInt(1.W))
    val var454 = Reg(UInt(32.W))
    val var455 = Reg(UInt(32.W))
    val var456 = Reg(UInt(32.W))
    val var457 = Reg(UInt(1.W))
    val outline_0_0 = Module(new outline_0)
    outline_0_0.go := 0.U
    val var458 = outline_0_0.var16
    var458 := DontCare
    val var459 = outline_0_0.var17
    var459 := DontCare
    val var460 = outline_0_0.var18
    var460 := DontCare
    val var461 = outline_0_0.var19
    var461 := DontCare
    val var462 = outline_0_0.done
    val var0 = IO(Output(UInt(1.W)))
    var0 := outline_0_0.var0
    val var1 = IO(Output(UInt(1.W)))
    var1 := outline_0_0.var1
    val var2 = IO(Output(UInt(10.W)))
    var2 := outline_0_0.var2
    val var3 = IO(Output(UInt(64.W)))
    var3 := outline_0_0.var3
    val var5 = IO(Output(UInt(1.W)))
    var5 := outline_0_0.var5
    val var6 = IO(Output(UInt(1.W)))
    var6 := outline_0_0.var6
    val var7 = IO(Output(UInt(10.W)))
    var7 := outline_0_0.var7
    val var8 = IO(Output(UInt(64.W)))
    var8 := outline_0_0.var8
    val var10 = IO(Output(UInt(1.W)))
    var10 := outline_0_0.var10
    val var11 = IO(Output(UInt(9.W)))
    var11 := outline_0_0.var11
    val var13 = IO(Output(UInt(1.W)))
    var13 := outline_0_0.var13
    val var14 = IO(Output(UInt(9.W)))
    var14 := outline_0_0.var14
    val var4 = IO(Input(UInt(64.W)))
    outline_0_0.var4 := var4
    val var9 = IO(Input(UInt(64.W)))
    outline_0_0.var9 := var9
    val var12 = IO(Input(UInt(64.W)))
    outline_0_0.var12 := var12
    val var15 = IO(Input(UInt(64.W)))
    outline_0_0.var15 := var15
    object State extends ChiselEnum {
      val s0, s1, s2, s3, s3_entry, s4, s4_wait, s5, s6, s7, s8 = Value
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
	val var463 = 1024.U >> 1.U
	var451 := var463
	val var464 = var463
	var452 := var464
	state := State.s2;
      }
      is (State.s2) {
	state := State.s3;
      }
      is (State.s3) {
	val var465 = !var452
	var453 := var452
	var454 := var451
	var455 := 0.U
	when (var465.asBool()) {
	  var451 := var454
	}
	when (var465.asBool()) {
	  var451 := var455
	}
	state := State.s4;
	when (var465.asBool()) {
	  state := State.s8;
	}
      }
      is (State.s3_entry) {
	val var466 = !var453
	when (var466.asBool()) {
	  var451 := var454
	}
	when (var466.asBool()) {
	  var451 := var455
	}
	state := State.s4;
	when (var466.asBool()) {
	  state := State.s8;
	}
      }
      is (State.s4) {
	var458 := var454
	var459 := 1024.U
	var460 := 1.U
	var461 := var455
	outline_0_0.go := 1.U
	state := State.s4_wait;
	when (var462.asBool()) {
	  state := State.s5;
	}
      }
      is (State.s4_wait) {
	when (var462.asBool()) {
	  state := State.s5;
	}
      }
      is (State.s5) {
	state := State.s6;
      }
      is (State.s6) {
	val var467 = var454 >> 1.U
	var456 := var467
	val var468 = var467
	var457 := var468
	val var469 = var455 + 1.U
	var454 := var469
	state := State.s7;
      }
      is (State.s7) {
	var453 := var457
	var454 := var456
	var455 := var454
	state := State.s3_entry;
      }
      is (State.s8) {
	done := 1.U
      }
    }
  }
  val main = Module(new main)
  mem_global_0.writeIn(0).valid := main.var0
  mem_global_0.readIn(0).valid := main.var1
  mem_global_0.writeIn(0).bits := main.var2
  mem_global_0.w_dataIn(0).bits := main.var3
  mem_global_1.writeIn(0).valid := main.var5
  mem_global_1.readIn(0).valid := main.var6
  mem_global_1.writeIn(0).bits := main.var7
  mem_global_1.w_dataIn(0).bits := main.var8
  mem_global_2.dataIn(0).valid := main.var10
  mem_global_2.dataIn(0).bits := main.var11
  mem_global_3.dataIn(0).valid := main.var13
  mem_global_3.dataIn(0).bits := main.var14
  val go = IO(Input(Bool()))
  main.go := go
  val done = IO(Output(Bool()))
  done := main.done
  main.var4 := var4
  main.var9 := var9
  main.var12 := var12
  main.var15 := var15


  mem_global_0.initMem("data_set/fft_strided/in_0.txt");
  mem_global_1.initMem("data_set/fft_strided/in_1.txt");
  mem_global_2.initMem("data_set/fft_strided/in_2.txt");
  mem_global_3.initMem("data_set/fft_strided/in_3.txt");

  val test_addr0 = IO(Input(UInt(10.W)))
  val test_data0 = IO(Output(UInt(64.W)))
  val test_addr1 = IO(Input(UInt(10.W)))
  val test_data1 = IO(Output(UInt(64.W)))

  mem_global_0.test_addr := test_addr0
  test_data0 := mem_global_0.test_data
  mem_global_0.finished := done
  mem_global_1.test_addr := test_addr1
  test_data1 := mem_global_1.test_data
  mem_global_1.finished := done
}

