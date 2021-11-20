import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class aeloss_pull extends MultiIOModule {
	val mem_global_0 = Module(new ReadMem(1024, 64, 1))
	val var0 = mem_global_0.r_en
	val var1 = mem_global_0.addr
	val var2 = mem_global_0.r_data
	val mem_global_1 = Module(new ReadMem(1024, 64, 1))
	val var3 = mem_global_1.r_en
	val var4 = mem_global_1.addr
	val var5 = mem_global_1.r_data
	val mem_global_2 = Module(new WriteMem(1024, 64, 1))
	val var6 = mem_global_2.w_en
	val var7 = mem_global_2.addr
	val var8 = mem_global_2.w_data
	val mem_global_3 = Module(new ReadMem(1024, 32, 1))
	val var9 = mem_global_3.r_en
	val var10 = mem_global_3.addr
	val var11 = mem_global_3.r_data
class outline_0 extends MultiIOModule {
	val go = IO(Input(Bool()))
	val start = RegInit(false.B)
	val new_input = Wire(Bool())
	new_input := false.B
	val done = IO(Output(Bool()))
	done := 0.U
	val var12 = IO(Input(UInt(32.W)))
	val var13 = IO(Input(UInt(32.W)))
	val var14 = IO(Input(UInt(32.W)))
	val var15 = IO(Output(UInt(64.W)))
	var15 := DontCare
	val var16 = Reg(UInt(32.W))
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
	val var104 = Reg(UInt(64.W))
	val var105 = Reg(UInt(64.W))
	val var106 = Reg(UInt(64.W))
	val var107 = Reg(UInt(64.W))
	val var108 = Reg(UInt(64.W))
	val var109 = Reg(UInt(64.W))
	val var110 = Reg(UInt(64.W))
	val var111 = Reg(UInt(64.W))
	val var112 = Reg(UInt(64.W))
	val var113 = Reg(UInt(64.W))
	val var114 = Reg(UInt(64.W))
	val var115 = Reg(UInt(64.W))
	val var116 = Reg(UInt(64.W))
	val var117 = Reg(UInt(64.W))
	val var118 = Reg(UInt(64.W))
	val var119 = Reg(UInt(64.W))
	val var120 = Reg(UInt(64.W))
	val var121 = Reg(UInt(64.W))
	val var122 = Reg(UInt(64.W))
	val var123 = Reg(UInt(64.W))
	val var124 = Reg(UInt(64.W))
	val var125 = Reg(UInt(64.W))
	val var126 = Reg(UInt(64.W))
	val var127 = Reg(UInt(64.W))
	val var128 = Reg(UInt(64.W))
	val var129 = Reg(UInt(64.W))
	val var130 = Reg(UInt(64.W))
	val var131 = Reg(UInt(64.W))
	val var132 = Reg(UInt(64.W))
	val var133 = Reg(UInt(64.W))
	val var134 = Reg(UInt(64.W))
	val var135 = Reg(UInt(64.W))
	val var136 = Reg(UInt(64.W))
	val var137 = Reg(UInt(64.W))
	val var138 = Reg(UInt(64.W))
	val var139 = Reg(UInt(64.W))
	val var140 = Reg(UInt(64.W))
	val var141 = Reg(UInt(64.W))
	val var142 = Reg(UInt(64.W))
	val var143 = Reg(UInt(64.W))
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
	val var242 = Reg(UInt(32.W))
	val var243 = Reg(UInt(32.W))
	val var244 = Reg(UInt(64.W))
	val var245 = Reg(UInt(64.W))
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
	val var259 = Reg(UInt(1.W))
	val var260 = Reg(UInt(1.W))
	val var261 = Reg(UInt(1.W))
	val var262 = Reg(UInt(1.W))
	val var263 = Reg(UInt(1.W))
	val var264 = Reg(UInt(1.W))
	val var265 = Reg(UInt(1.W))
	val var266 = Reg(UInt(1.W))
	val var267 = Reg(UInt(1.W))
	val var268 = Reg(UInt(1.W))
	val var269 = Reg(UInt(1.W))
	val var270 = Reg(UInt(1.W))
	val var271 = Reg(UInt(1.W))
	val var272 = Reg(UInt(1.W))
	val var273 = Reg(UInt(1.W))
	val var274 = Reg(UInt(1.W))
	val var275 = Reg(UInt(1.W))
	val var276 = Reg(UInt(1.W))
	val var277 = Reg(UInt(1.W))
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
	val var294 = Reg(UInt(1.W))
	val var295 = Reg(UInt(1.W))
	val var296 = Reg(UInt(1.W))
	val var297 = Reg(UInt(1.W))
	val var298 = Reg(UInt(1.W))
	val var299 = Reg(UInt(1.W))
	val var300 = Reg(UInt(1.W))
	val var301 = Reg(UInt(1.W))
	val var302 = Reg(UInt(1.W))
	val var303 = Reg(UInt(1.W))
	val var304 = Reg(UInt(1.W))
	val var305 = Reg(UInt(1.W))
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
	val addf_outline_0_0 = Module(new AddSubFBase(13, 11, 53, true))
	addf_outline_0_0.ce := true.B
	val var316 = addf_outline_0_0.operand0
	var316 := DontCare
	val var317 = addf_outline_0_0.operand1
	var317 := DontCare
	val var318 = addf_outline_0_0.result
	val mulf_outline_0_0 = Module(new MulFBase(9, 11, 53))
	mulf_outline_0_0.ce := true.B
	val var319 = mulf_outline_0_0.operand0
	var319 := DontCare
	val var320 = mulf_outline_0_0.operand1
	var320 := DontCare
	val var321 = mulf_outline_0_0.result
	val subf_outline_0_0 = Module(new AddSubFBase(13, 11, 53, false))
	subf_outline_0_0.ce := true.B
	val var322 = subf_outline_0_0.operand0
	var322 := DontCare
	val var323 = subf_outline_0_0.operand1
	var323 := DontCare
	val var324 = subf_outline_0_0.result
	val var325 = Reg(UInt(32.W))
	when (go) {
		var325 := var12
	}
	when (go) {
		var16 := var12
	}
	when (go) {
		var17 := var13
	}
	when (go) {
		var18 := var14
	}
	when (go) {
		var104 := 0L.U
	}
	val var0 = IO(Output(UInt(1.W)))
	var0 := false.B
	val var1 = IO(Output(UInt(10.W)))
	var1 := DontCare
	val var3 = IO(Output(UInt(1.W)))
	var3 := false.B
	val var4 = IO(Output(UInt(10.W)))
	var4 := DontCare
	val var6 = IO(Output(UInt(1.W)))
	var6 := false.B
	val var7 = IO(Output(UInt(10.W)))
	var7 := DontCare
	val var8 = IO(Output(UInt(64.W)))
	var8 := DontCare
	val var9 = IO(Output(UInt(1.W)))
	var9 := false.B
	val var10 = IO(Output(UInt(10.W)))
	var10 := DontCare
	val var2 = IO(Input(UInt(64.W)))
	val var5 = IO(Input(UInt(64.W)))
	val var11 = IO(Input(UInt(32.W)))
	val shift_register = RegInit(0.U(6.W))
	when (go) {
		when (var12 > var13) {
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
		shift_register := Cat(shift_register(4, 0), new_input)
	}
	when (counter === 0.U) {
		when (valid(0)) {
			var19 := var325
		}
		when (valid(15)) {
			var236 := var318
		}
		var319 := var318
		var320 := 4602678819172646912L.U
		when (valid(15)) {
			var34 := var33
		}
		when (valid(15)) {
			var119 := var118
		}
		when (valid(15)) {
			var202 := var201
		}
		when (valid(15)) {
			var226 := var225
		}
		when (valid(30)) {
			var49 := var48
		}
		when (valid(30)) {
			var134 := var133
		}
		when (valid(30)) {
			var251 := var250
		}
		when (valid(45)) {
			var64 := var63
		}
		when (valid(45)) {
			var149 := var148
		}
		when (valid(45)) {
			var266 := var265
		}
		when (valid(60)) {
			var79 := var78
		}
		when (valid(60)) {
			var164 := var163
		}
		when (valid(60)) {
			var281 := var280
		}
		when (valid(75)) {
			var94 := var93
		}
		when (valid(75)) {
			var179 := var178
		}
		when (valid(75)) {
			var296 := var295
		}
	}
	when (counter === 1.U) {
		var1 := var19
		when (valid(1)) {
			var0 := 1.U
		}
		var4 := var19
		when (valid(1)) {
			var3 := 1.U
		}
		when (valid(1)) {
			var20 := var19
		}
		when (valid(1)) {
			var105 := var104
		}
		when (valid(16)) {
			var35 := var34
		}
		when (valid(16)) {
			var120 := var119
		}
		when (valid(16)) {
			var203 := var202
		}
		when (valid(16)) {
			var227 := var226
		}
		when (valid(31)) {
			var50 := var49
		}
		when (valid(31)) {
			var135 := var134
		}
		when (valid(31)) {
			var252 := var251
		}
		when (valid(46)) {
			var306 := var321
		}
		when (valid(46)) {
			var65 := var64
		}
		when (valid(46)) {
			var150 := var149
		}
		when (valid(46)) {
			var267 := var266
		}
		when (valid(61)) {
			var311 := var318
		}
		var319 := var318
		var320 := 4591705420666420376L.U
		when (valid(61)) {
			var80 := var79
		}
		when (valid(61)) {
			var165 := var164
		}
		when (valid(61)) {
			var282 := var281
		}
		when (valid(76)) {
			var95 := var94
		}
		when (valid(76)) {
			var180 := var179
		}
		when (valid(76)) {
			var297 := var296
		}
	}
	when (counter === 2.U) {
		when (valid(2)) {
			var189 := var2
		}
		when (valid(2)) {
			var213 := var5
		}
		var316 := var2
		var317 := var5
		when (valid(2)) {
			var21 := var20
		}
		when (valid(2)) {
			var106 := var105
		}
		when (valid(17)) {
			var36 := var35
		}
		when (valid(17)) {
			var121 := var120
		}
		when (valid(17)) {
			var204 := var203
		}
		when (valid(17)) {
			var228 := var227
		}
		when (valid(32)) {
			var51 := var50
		}
		when (valid(32)) {
			var136 := var135
		}
		when (valid(32)) {
			var253 := var252
		}
		when (valid(47)) {
			var309 := var321
		}
		when (valid(47)) {
			var66 := var65
		}
		when (valid(47)) {
			var151 := var150
		}
		when (valid(47)) {
			var268 := var267
		}
		when (valid(47)) {
			var307 := var306
		}
		when (valid(62)) {
			var81 := var80
		}
		when (valid(62)) {
			var166 := var165
		}
		when (valid(62)) {
			var283 := var282
		}
		when (valid(77)) {
			var96 := var95
		}
		when (valid(77)) {
			var181 := var180
		}
		when (valid(77)) {
			var298 := var297
		}
	}
	when (counter === 3.U) {
		when (valid(3)) {
			var22 := var21
		}
		when (valid(3)) {
			var107 := var106
		}
		when (valid(3)) {
			var190 := var189
		}
		when (valid(3)) {
			var214 := var213
		}
		when (valid(18)) {
			var37 := var36
		}
		when (valid(18)) {
			var122 := var121
		}
		when (valid(18)) {
			var205 := var204
		}
		when (valid(18)) {
			var229 := var228
		}
		when (valid(33)) {
			var52 := var51
		}
		when (valid(33)) {
			var137 := var136
		}
		when (valid(33)) {
			var254 := var253
		}
		var316 := var309
		var317 := var307
		when (valid(48)) {
			var67 := var66
		}
		when (valid(48)) {
			var152 := var151
		}
		when (valid(48)) {
			var269 := var268
		}
		when (valid(48)) {
			var308 := var307
		}
		when (valid(48)) {
			var310 := var309
		}
		when (valid(63)) {
			var82 := var81
		}
		when (valid(63)) {
			var167 := var166
		}
		when (valid(63)) {
			var284 := var283
		}
		when (valid(78)) {
			var97 := var96
		}
		when (valid(78)) {
			var182 := var181
		}
		when (valid(78)) {
			var299 := var298
		}
	}
	when (counter === 4.U) {
		when (valid(4)) {
			var23 := var22
		}
		when (valid(4)) {
			var108 := var107
		}
		when (valid(4)) {
			var191 := var190
		}
		when (valid(4)) {
			var215 := var214
		}
		when (valid(19)) {
			var38 := var37
		}
		when (valid(19)) {
			var123 := var122
		}
		when (valid(19)) {
			var206 := var205
		}
		when (valid(19)) {
			var230 := var229
		}
		when (valid(34)) {
			var53 := var52
		}
		when (valid(34)) {
			var138 := var137
		}
		when (valid(34)) {
			var255 := var254
		}
		when (valid(49)) {
			var68 := var67
		}
		when (valid(49)) {
			var153 := var152
		}
		when (valid(49)) {
			var270 := var269
		}
		when (valid(64)) {
			var83 := var82
		}
		when (valid(64)) {
			var168 := var167
		}
		when (valid(64)) {
			var285 := var284
		}
		when (valid(79)) {
			var98 := var97
		}
		when (valid(79)) {
			var183 := var182
		}
		when (valid(79)) {
			var300 := var299
		}
	}
	when (counter === 5.U) {
		when (valid(5)) {
			var24 := var23
		}
		when (valid(5)) {
			var109 := var108
		}
		when (valid(5)) {
			var192 := var191
		}
		when (valid(5)) {
			var216 := var215
		}
		when (valid(20)) {
			var39 := var38
		}
		when (valid(20)) {
			var124 := var123
		}
		when (valid(20)) {
			var207 := var206
		}
		when (valid(20)) {
			var231 := var230
		}
		when (valid(35)) {
			var54 := var53
		}
		when (valid(35)) {
			var139 := var138
		}
		when (valid(35)) {
			var256 := var255
		}
		when (valid(50)) {
			var69 := var68
		}
		when (valid(50)) {
			var154 := var153
		}
		when (valid(50)) {
			var271 := var270
		}
		when (valid(65)) {
			var84 := var83
		}
		when (valid(65)) {
			var169 := var168
		}
		when (valid(65)) {
			var286 := var285
		}
		when (valid(80)) {
			var99 := var98
		}
		when (valid(80)) {
			var184 := var183
		}
		when (valid(80)) {
			var301 := var300
		}
	}
	when (counter === 6.U) {
		when (valid(6)) {
			var25 := var24
		}
		when (valid(6)) {
			var110 := var109
		}
		when (valid(6)) {
			var193 := var192
		}
		when (valid(6)) {
			var217 := var216
		}
		when (valid(21)) {
			var40 := var39
		}
		when (valid(21)) {
			var125 := var124
		}
		when (valid(21)) {
			var208 := var207
		}
		when (valid(21)) {
			var232 := var231
		}
		when (valid(36)) {
			var55 := var54
		}
		when (valid(36)) {
			var140 := var139
		}
		when (valid(36)) {
			var257 := var256
		}
		when (valid(51)) {
			var70 := var69
		}
		when (valid(51)) {
			var155 := var154
		}
		when (valid(51)) {
			var272 := var271
		}
		when (valid(66)) {
			var85 := var84
		}
		when (valid(66)) {
			var170 := var169
		}
		when (valid(66)) {
			var287 := var286
		}
		when (valid(81)) {
			var100 := var99
		}
		when (valid(81)) {
			var185 := var184
		}
		when (valid(81)) {
			var302 := var301
		}
	}
	when (counter === 7.U) {
		when (valid(7)) {
			var26 := var25
		}
		when (valid(7)) {
			var111 := var110
		}
		when (valid(7)) {
			var194 := var193
		}
		when (valid(7)) {
			var218 := var217
		}
		when (valid(22)) {
			var41 := var40
		}
		when (valid(22)) {
			var126 := var125
		}
		when (valid(22)) {
			var209 := var208
		}
		when (valid(22)) {
			var233 := var232
		}
		when (valid(37)) {
			var244 := var324
		}
		var319 := var324
		var320 := var324
		when (valid(37)) {
			var56 := var55
		}
		when (valid(37)) {
			var141 := var140
		}
		when (valid(37)) {
			var258 := var257
		}
		when (valid(52)) {
			var71 := var70
		}
		when (valid(52)) {
			var156 := var155
		}
		when (valid(52)) {
			var273 := var272
		}
		when (valid(67)) {
			var86 := var85
		}
		when (valid(67)) {
			var171 := var170
		}
		when (valid(67)) {
			var288 := var287
		}
		when (valid(82)) {
			var101 := var100
		}
		when (valid(82)) {
			var186 := var185
		}
		when (valid(82)) {
			var303 := var302
		}
	}
	when (counter === 8.U) {
		when (valid(8)) {
			var27 := var26
		}
		when (valid(8)) {
			var112 := var111
		}
		when (valid(8)) {
			var195 := var194
		}
		when (valid(8)) {
			var219 := var218
		}
		var10 := var41
		when (valid(23)) {
			var9 := 1.U
		}
		when (valid(23)) {
			var42 := var41
		}
		when (valid(23)) {
			var127 := var126
		}
		when (valid(23)) {
			var210 := var209
		}
		when (valid(23)) {
			var234 := var233
		}
		when (valid(38)) {
			var245 := var324
		}
		var319 := var324
		var320 := var324
		when (valid(38)) {
			var57 := var56
		}
		when (valid(38)) {
			var142 := var141
		}
		when (valid(38)) {
			var259 := var258
		}
		when (valid(53)) {
			var72 := var71
		}
		when (valid(53)) {
			var157 := var156
		}
		when (valid(53)) {
			var274 := var273
		}
		when (valid(68)) {
			var87 := var86
		}
		when (valid(68)) {
			var172 := var171
		}
		when (valid(68)) {
			var289 := var288
		}
		when (valid(83)) {
			var102 := var101
		}
		when (valid(83)) {
			var187 := var186
		}
		when (valid(83)) {
			var304 := var303
		}
	}
	when (counter === 9.U) {
		when (valid(9)) {
			var28 := var27
		}
		when (valid(9)) {
			var113 := var112
		}
		when (valid(9)) {
			var196 := var195
		}
		when (valid(9)) {
			var220 := var219
		}
		when (valid(24)) {
			var237 := var321
		}
		when (valid(24)) {
			var242 := var11
		}
		var322 := var234
		var323 := var321
		when (valid(24)) {
			var43 := var42
		}
		when (valid(24)) {
			var128 := var127
		}
		when (valid(24)) {
			var211 := var210
		}
		when (valid(24)) {
			var235 := var234
		}
		when (valid(39)) {
			var58 := var57
		}
		when (valid(39)) {
			var143 := var142
		}
		when (valid(39)) {
			var260 := var259
		}
		when (valid(54)) {
			var73 := var72
		}
		when (valid(54)) {
			var158 := var157
		}
		when (valid(54)) {
			var275 := var274
		}
		when (valid(69)) {
			var88 := var87
		}
		when (valid(69)) {
			var173 := var172
		}
		when (valid(69)) {
			var290 := var289
		}
		when (valid(84) && var304.asBool()) {
			var315 := var318
		}
		when (valid(84) && var304.asBool()) {
			var314 := var318
		}
		val var326 = !var304
		when (valid(84) && var326.asBool()) {
			var314 := var187
		}
		when (valid(84)) {
			var103 := var102
		}
		when (valid(84)) {
			var188 := var187
		}
		when (valid(84)) {
			var305 := var304
		}
	}
	when (counter === 10.U) {
		when (valid(10)) {
			var29 := var28
		}
		when (valid(10)) {
			var114 := var113
		}
		when (valid(10)) {
			var197 := var196
		}
		when (valid(10)) {
			var221 := var220
		}
		var322 := var211
		var323 := var237
		val var327 = var242
		when (valid(25)) {
			var246 := var327
		}
		when (valid(25)) {
			var44 := var43
		}
		when (valid(25)) {
			var129 := var128
		}
		when (valid(25)) {
			var212 := var211
		}
		when (valid(25)) {
			var238 := var237
		}
		when (valid(25)) {
			var243 := var242
		}
		when (valid(40)) {
			var59 := var58
		}
		when (valid(40)) {
			var144 := var143
		}
		when (valid(40)) {
			var261 := var260
		}
		when (valid(55)) {
			var74 := var73
		}
		when (valid(55)) {
			var159 := var158
		}
		when (valid(55)) {
			var276 := var275
		}
		when (valid(70)) {
			var312 := var321
		}
		when (valid(70)) {
			var89 := var88
		}
		when (valid(70)) {
			var174 := var173
		}
		when (valid(70)) {
			var291 := var290
		}
		when (valid(85)) {
			var174 := var314
			var15 := var314
		}
	}
	when (counter === 11.U) {
		when (valid(11)) {
			var30 := var29
		}
		when (valid(11)) {
			var115 := var114
		}
		when (valid(11)) {
			var198 := var197
		}
		when (valid(11)) {
			var222 := var221
		}
		when (valid(26)) {
			var45 := var44
		}
		when (valid(26)) {
			var130 := var129
		}
		when (valid(26)) {
			var239 := var238
		}
		when (valid(26)) {
			var247 := var246
		}
		when (valid(41)) {
			var60 := var59
		}
		when (valid(41)) {
			var145 := var144
		}
		when (valid(41)) {
			var262 := var261
		}
		when (valid(56)) {
			var75 := var74
		}
		when (valid(56)) {
			var160 := var159
		}
		when (valid(56)) {
			var277 := var276
		}
		when (var291.asBool()) {
			var316 := var174
		}
		when (var291.asBool()) {
			var317 := var312
		}
		when (valid(71)) {
			var90 := var89
		}
		when (valid(71)) {
			var175 := var174
		}
		when (valid(71)) {
			var292 := var291
		}
		when (valid(71)) {
			var313 := var312
		}
	}
	when (counter === 12.U) {
		when (valid(12)) {
			var31 := var30
		}
		when (valid(12)) {
			var116 := var115
		}
		when (valid(12)) {
			var199 := var198
		}
		when (valid(12)) {
			var223 := var222
		}
		when (valid(27)) {
			var46 := var45
		}
		when (valid(27)) {
			var131 := var130
		}
		when (valid(27)) {
			var240 := var239
		}
		when (valid(27)) {
			var248 := var247
		}
		when (valid(42)) {
			var61 := var60
		}
		when (valid(42)) {
			var146 := var145
		}
		when (valid(42)) {
			var263 := var262
		}
		when (valid(57)) {
			var76 := var75
		}
		when (valid(57)) {
			var161 := var160
		}
		when (valid(57)) {
			var278 := var277
		}
		when (valid(72)) {
			var91 := var90
		}
		when (valid(72)) {
			var176 := var175
		}
		when (valid(72)) {
			var293 := var292
		}
	}
	when (counter === 13.U) {
		when (valid(13)) {
			var32 := var31
		}
		when (valid(13)) {
			var117 := var116
		}
		when (valid(13)) {
			var200 := var199
		}
		when (valid(13)) {
			var224 := var223
		}
		var7 := var46
		var8 := var240
		when (valid(28)) {
			var6 := 1.U
		}
		when (valid(28)) {
			var47 := var46
		}
		when (valid(28)) {
			var132 := var131
		}
		when (valid(28)) {
			var241 := var240
		}
		when (valid(28)) {
			var249 := var248
		}
		when (valid(43)) {
			var62 := var61
		}
		when (valid(43)) {
			var147 := var146
		}
		when (valid(43)) {
			var264 := var263
		}
		when (valid(58)) {
			var77 := var76
		}
		when (valid(58)) {
			var162 := var161
		}
		when (valid(58)) {
			var279 := var278
		}
		when (valid(73)) {
			var92 := var91
		}
		when (valid(73)) {
			var177 := var176
		}
		when (valid(73)) {
			var294 := var293
		}
	}
	when (counter === 14.U) {
		when (valid(14)) {
			var33 := var32
		}
		when (valid(14)) {
			var118 := var117
		}
		when (valid(14)) {
			var201 := var200
		}
		when (valid(14)) {
			var225 := var224
		}
		when (valid(29)) {
			var48 := var47
		}
		when (valid(29)) {
			var133 := var132
		}
		when (valid(29)) {
			var250 := var249
		}
		when (valid(44)) {
			var63 := var62
		}
		when (valid(44)) {
			var148 := var147
		}
		when (valid(44)) {
			var265 := var264
		}
		when (valid(59)) {
			var78 := var77
		}
		when (valid(59)) {
			var163 := var162
		}
		when (valid(59)) {
			var280 := var279
		}
		when (valid(74)) {
			var93 := var92
		}
		when (valid(74)) {
			var178 := var177
		}
		when (valid(74)) {
			var295 := var294
		}
	}
	when (counter === 10.U && valid(85)) {
		done := !valid(70)
	}
	when (done) {
		shift_register := 0.U
		counter := 0.U
	}
	val ub_reg = Reg(UInt(32.W))
	when (go) {
		ub_reg := var13
	}
	val step_reg = Reg(UInt(32.W))
	when (go) {
		step_reg := var14
	}
	val upper_bound = Mux(go, var13, ub_reg)
	val step = Mux(go, var14, step_reg)
	new_input := start
	when (start) {
		when (var325 <= upper_bound) {
			when (counter === 14.U) {
				var325 := var325 + step
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
	val var328 = IO(Output(UInt(64.W)))
	var328 := DontCare
	val var329 = Reg(UInt(64.W))
	val outline_0_0 = Module(new outline_0)
	outline_0_0.go := 0.U
	val var330 = outline_0_0.var12
	var330 := DontCare
	val var331 = outline_0_0.var13
	var331 := DontCare
	val var332 = outline_0_0.var14
	var332 := DontCare
	val var333 = outline_0_0.var15
	val var334 = outline_0_0.done
	val outline_0_0_var0 = IO(Output(UInt(1.W)))
	outline_0_0_var0 := outline_0_0.var0
	val outline_0_0_var1 = IO(Output(UInt(10.W)))
	outline_0_0_var1 := outline_0_0.var1
	val outline_0_0_var3 = IO(Output(UInt(1.W)))
	outline_0_0_var3 := outline_0_0.var3
	val outline_0_0_var4 = IO(Output(UInt(10.W)))
	outline_0_0_var4 := outline_0_0.var4
	val outline_0_0_var6 = IO(Output(UInt(1.W)))
	outline_0_0_var6 := outline_0_0.var6
	val outline_0_0_var7 = IO(Output(UInt(10.W)))
	outline_0_0_var7 := outline_0_0.var7
	val outline_0_0_var8 = IO(Output(UInt(64.W)))
	outline_0_0_var8 := outline_0_0.var8
	val outline_0_0_var9 = IO(Output(UInt(1.W)))
	outline_0_0_var9 := outline_0_0.var9
	val outline_0_0_var10 = IO(Output(UInt(10.W)))
	outline_0_0_var10 := outline_0_0.var10
	val outline_0_0_var2 = IO(Input(UInt(64.W)))
	outline_0_0.var2 := outline_0_0_var2
	val outline_0_0_var5 = IO(Input(UInt(64.W)))
	outline_0_0.var5 := outline_0_0_var5
	val outline_0_0_var11 = IO(Input(UInt(32.W)))
	outline_0_0.var11 := outline_0_0_var11
	object State extends ChiselEnum {
		val s0, s1, s1_wait, s2 = Value
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
			var330 := 0.U
			var331 := 1024.U
			var332 := 1.U
			outline_0_0.go := 1.U
			when (var334.asBool()) {
				var329 := var333
			}
			state := State.s1_wait;
			when (var334.asBool()) {
				state := State.s2;
			}
		}
		is (State.s1_wait) {
			when (var334.asBool()) {
				var329 := var333
			}
			when (var334.asBool()) {
				state := State.s2;
			}
		}
		is (State.s2) {
			done := 1.U
			var328 := var329
		}
	}
}
  val main = Module(new main)
  val result = IO(Output(UInt(64.W)))
  result := main.var328
	mem_global_0.dataIn(0).valid := main.outline_0_0_var0
	mem_global_0.dataIn(0).bits := main.outline_0_0_var1
	mem_global_1.dataIn(0).valid := main.outline_0_0_var3
	mem_global_1.dataIn(0).bits := main.outline_0_0_var4
	mem_global_2.dataIn(0).valid := main.outline_0_0_var6
	mem_global_2.dataIn(0).bits := main.outline_0_0_var7
	mem_global_2.w_dataIn(0).bits := main.outline_0_0_var8
	mem_global_3.dataIn(0).valid := main.outline_0_0_var9
	mem_global_3.dataIn(0).bits := main.outline_0_0_var10
	val go = IO(Input(Bool()))
	main.go := go
	val done = IO(Output(Bool()))
	done := main.done
	main.outline_0_0_var2 := var2
	main.outline_0_0_var5 := var5
	main.outline_0_0_var11 := var11
	val mem_global_2_test_addr = IO(Input(UInt(log2Ceil(1024).W)))
	mem_global_2.test_addr := mem_global_2_test_addr
	val mem_global_2_test_data = IO(Output(UInt(64.W)))
	mem_global_2_test_data := mem_global_2.test_data
	mem_global_2.finished := done
}

