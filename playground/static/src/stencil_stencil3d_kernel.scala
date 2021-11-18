import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class stencil3d extends MultiIOModule {
	val mem_global_0 = Module(new ReadMem(2, 32, 1))
	val var0 = mem_global_0.r_en
	val var1 = mem_global_0.addr
	val var2 = mem_global_0.r_data
	val mem_global_1 = Module(new ReadMem(16384, 32, 4))
	val var3 = mem_global_1.r_en
	val var4 = mem_global_1.addr
	val var5 = mem_global_1.r_data
	val mem_global_2 = Module(new WriteMem(16384, 32, 4))
	val var6 = mem_global_2.w_en
	val var7 = mem_global_2.addr
	val var8 = mem_global_2.w_data
class outline_0 extends MultiIOModule {
	val go = IO(Input(Bool()))
	val start = RegInit(false.B)
	val new_input = Wire(Bool())
	new_input := false.B
	val done = IO(Output(Bool()))
	done := 0.U
	val var9 = IO(Input(UInt(32.W)))
	val var10 = IO(Input(UInt(32.W)))
	val var11 = IO(Input(UInt(32.W)))
	val var12 = IO(Input(UInt(32.W)))
	val var13 = Reg(UInt(32.W))
	val var14 = Reg(UInt(32.W))
	val var15 = Reg(UInt(32.W))
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
	when (go) {
		var35 := var9
	}
	when (go) {
		var13 := var9
	}
	when (go) {
		var14 := var10
	}
	when (go) {
		var15 := var11
	}
	when (go) {
		var16 := var12
	}
	val var3 = IO(Output(UInt(1.W)))
	var3 := false.B
	val var4 = IO(Output(UInt(14.W)))
	var4 := DontCare
	val var6 = IO(Output(UInt(1.W)))
	var6 := false.B
	val var7 = IO(Output(UInt(14.W)))
	var7 := DontCare
	val var8 = IO(Output(UInt(32.W)))
	var8 := DontCare
	val var5 = IO(Input(UInt(32.W)))
	val shift_register = RegInit(0.U(3.W))
	when (go) {
		when (var9 > var10) {
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
			shift_register(1)
		} else if (stage == 4) {
			shift_register(1)
		} else if (stage == 5) {
			shift_register(2)
		} else {
			new_input
		}
	}
	val counter = RegInit(0.U(1.W))
	when (counter === 1.U) {
		counter := 0.U
	}.otherwise {
		when (start || shift_register =/= 0.U) {
			counter := counter + 1.U
		}
	}
	when (counter === 0.U) {
		shift_register := Cat(shift_register(1, 0), new_input)
	}
	when (counter === 0.U) {
		when (valid(0)) {
			var17 := var35
		}
		val var36 = var16 << 4.U
		when (valid(2)) {
			var28 := var36
		}
		val var37 = var18 + var36
		when (valid(2)) {
			var29 := var37
		}
		var4 := var24
		when (valid(2)) {
			var3 := 1.U
		}
		when (valid(2)) {
			var19 := var18
		}
		when (valid(2)) {
			var25 := var24
		}
		when (valid(4)) {
			var34 := var5
		}
		var7 := var30
		var8 := var5
		when (valid(4)) {
			var6 := 1.U
		}
		when (valid(4)) {
			var21 := var20
		}
		when (valid(4)) {
			var27 := var26
		}
		when (valid(4)) {
			var31 := var30
		}
		when (valid(4)) {
			var33 := var32
		}
	}
	when (counter === 1.U) {
		val var38 = var16 + 992.U
		when (valid(1)) {
			var22 := var38
		}
		val var39 = var38 << 4.U
		when (valid(1)) {
			var23 := var39
		}
		val var40 = var17 + var39
		when (valid(1)) {
			var24 := var40
		}
		when (valid(1)) {
			var18 := var17
		}
		when (valid(3)) {
			var32 := var5
		}
		var4 := var29
		when (valid(3)) {
			var3 := 1.U
		}
		when (valid(3)) {
			var20 := var19
		}
		when (valid(3)) {
			var26 := var25
		}
		when (valid(3)) {
			var30 := var29
		}
		var7 := var27
		var8 := var33
		when (valid(5)) {
			var6 := 1.U
		}
	}
	when (counter === 1.U && valid(5)) {
		done := !valid(3)
	}
	when (done) {
		shift_register := 0.U
		counter := 0.U
	}
	val ub_reg = Reg(UInt(32.W))
	when (go) {
		ub_reg := var10
	}
	val step_reg = Reg(UInt(32.W))
	when (go) {
		step_reg := var11
	}
	val upper_bound = Mux(go, var10, ub_reg)
	val step = Mux(go, var11, step_reg)
	new_input := start
	when (start) {
		when (var35 <= upper_bound) {
			when (counter === 1.U) {
				var35 := var35 + step
			}
		}.otherwise {
			start := false.B
			new_input := false.B
		}
	}
}
class outline_1 extends MultiIOModule {
	val go = IO(Input(Bool()))
	val start = RegInit(false.B)
	val new_input = Wire(Bool())
	new_input := false.B
	val done = IO(Output(Bool()))
	done := 0.U
	val var41 = IO(Input(UInt(32.W)))
	val var42 = IO(Input(UInt(32.W)))
	val var43 = IO(Input(UInt(32.W)))
	val var44 = IO(Input(UInt(32.W)))
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
	when (go) {
		var69 := var41
	}
	when (go) {
		var45 := var41
	}
	when (go) {
		var46 := var42
	}
	when (go) {
		var47 := var43
	}
	when (go) {
		var48 := var44
	}
	val var3 = IO(Output(UInt(1.W)))
	var3 := false.B
	val var4 = IO(Output(UInt(14.W)))
	var4 := DontCare
	val var6 = IO(Output(UInt(1.W)))
	var6 := false.B
	val var7 = IO(Output(UInt(14.W)))
	var7 := DontCare
	val var8 = IO(Output(UInt(32.W)))
	var8 := DontCare
	val var5 = IO(Input(UInt(32.W)))
	val shift_register = RegInit(0.U(3.W))
	when (go) {
		when (var41 > var42) {
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
			shift_register(1)
		} else if (stage == 4) {
			shift_register(1)
		} else if (stage == 5) {
			shift_register(2)
		} else {
			new_input
		}
	}
	val counter = RegInit(0.U(1.W))
	when (counter === 1.U) {
		counter := 0.U
	}.otherwise {
		when (start || shift_register =/= 0.U) {
			counter := counter + 1.U
		}
	}
	when (counter === 0.U) {
		shift_register := Cat(shift_register(1, 0), new_input)
	}
	when (counter === 0.U) {
		when (valid(0)) {
			var49 := var69
		}
		val var70 = var54 << 4.U
		when (valid(2)) {
			var62 := var70
		}
		val var71 = var50 + var70
		when (valid(2)) {
			var63 := var71
		}
		var4 := var58
		when (valid(2)) {
			var3 := 1.U
		}
		when (valid(2)) {
			var51 := var50
		}
		when (valid(2)) {
			var55 := var54
		}
		when (valid(2)) {
			var59 := var58
		}
		when (valid(4)) {
			var68 := var5
		}
		var7 := var64
		var8 := var5
		when (valid(4)) {
			var6 := 1.U
		}
		when (valid(4)) {
			var53 := var52
		}
		when (valid(4)) {
			var61 := var60
		}
		when (valid(4)) {
			var65 := var64
		}
		when (valid(4)) {
			var67 := var66
		}
	}
	when (counter === 1.U) {
		val var72 = var48 << 5.U
		when (valid(1)) {
			var54 := var72
		}
		val var73 = var72 + 31.U
		when (valid(1)) {
			var56 := var73
		}
		val var74 = var73 << 4.U
		when (valid(1)) {
			var57 := var74
		}
		val var75 = var49 + var74
		when (valid(1)) {
			var58 := var75
		}
		when (valid(1)) {
			var50 := var49
		}
		when (valid(3)) {
			var66 := var5
		}
		var4 := var63
		when (valid(3)) {
			var3 := 1.U
		}
		when (valid(3)) {
			var52 := var51
		}
		when (valid(3)) {
			var60 := var59
		}
		when (valid(3)) {
			var64 := var63
		}
		var7 := var61
		var8 := var67
		when (valid(5)) {
			var6 := 1.U
		}
	}
	when (counter === 1.U && valid(5)) {
		done := !valid(3)
	}
	when (done) {
		shift_register := 0.U
		counter := 0.U
	}
	val ub_reg = Reg(UInt(32.W))
	when (go) {
		ub_reg := var42
	}
	val step_reg = Reg(UInt(32.W))
	when (go) {
		step_reg := var43
	}
	val upper_bound = Mux(go, var42, ub_reg)
	val step = Mux(go, var43, step_reg)
	new_input := start
	when (start) {
		when (var69 <= upper_bound) {
			when (counter === 1.U) {
				var69 := var69 + step
			}
		}.otherwise {
			start := false.B
			new_input := false.B
		}
	}
}
class outline_2 extends MultiIOModule {
	val go = IO(Input(Bool()))
	val start = RegInit(false.B)
	val new_input = Wire(Bool())
	new_input := false.B
	val done = IO(Output(Bool()))
	done := 0.U
	val var76 = IO(Input(UInt(32.W)))
	val var77 = IO(Input(UInt(32.W)))
	val var78 = IO(Input(UInt(32.W)))
	val var79 = IO(Input(UInt(32.W)))
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
	when (go) {
		var98 := var76
	}
	when (go) {
		var80 := var76
	}
	when (go) {
		var81 := var77
	}
	when (go) {
		var82 := var78
	}
	when (go) {
		var83 := var79
	}
	val var3 = IO(Output(UInt(1.W)))
	var3 := false.B
	val var4 = IO(Output(UInt(14.W)))
	var4 := DontCare
	val var6 = IO(Output(UInt(1.W)))
	var6 := false.B
	val var7 = IO(Output(UInt(14.W)))
	var7 := DontCare
	val var8 = IO(Output(UInt(32.W)))
	var8 := DontCare
	val var5 = IO(Input(UInt(32.W)))
	val shift_register = RegInit(0.U(3.W))
	when (go) {
		when (var76 > var77) {
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
			shift_register(1)
		} else if (stage == 4) {
			shift_register(1)
		} else {
			new_input
		}
	}
	val counter = RegInit(0.U(1.W))
	when (counter === 1.U) {
		counter := 0.U
	}.otherwise {
		when (start || shift_register =/= 0.U) {
			counter := counter + 1.U
		}
	}
	when (counter === 0.U) {
		shift_register := Cat(shift_register(1, 0), new_input)
	}
	when (counter === 0.U) {
		when (valid(0)) {
			var84 := var98
		}
		var4 := var92
		when (valid(2)) {
			var3 := 1.U
		}
		val var99 = var92 + 15.U
		when (valid(2)) {
			var96 := var99
		}
		when (valid(2)) {
			var86 := var85
		}
		when (valid(2)) {
			var93 := var92
		}
		var7 := var97
		var8 := var5
		when (valid(4)) {
			var6 := 1.U
		}
	}
	when (counter === 1.U) {
		val var100 = var84 - var82
		when (valid(1)) {
			var88 := var100
		}
		val var101 = var100 + 1.U
		when (valid(1)) {
			var89 := var101
		}
		val var102 = var83 << 5.U
		when (valid(1)) {
			var90 := var102
		}
		val var103 = var101 + var102
		when (valid(1)) {
			var91 := var103
		}
		val var104 = var103 << 4.U
		when (valid(1)) {
			var92 := var104
		}
		when (valid(1)) {
			var85 := var84
		}
		when (valid(3)) {
			var95 := var5
		}
		var7 := var93
		var8 := var5
		when (valid(3)) {
			var6 := 1.U
		}
		var4 := var96
		when (valid(3)) {
			var3 := 1.U
		}
		when (valid(3)) {
			var87 := var86
		}
		when (valid(3)) {
			var94 := var93
		}
		when (valid(3)) {
			var97 := var96
		}
	}
	when (counter === 0.U && valid(4)) {
		done := !valid(2)
	}
	when (done) {
		shift_register := 0.U
		counter := 0.U
	}
	val ub_reg = Reg(UInt(32.W))
	when (go) {
		ub_reg := var77
	}
	val step_reg = Reg(UInt(32.W))
	when (go) {
		step_reg := var78
	}
	val upper_bound = Mux(go, var77, ub_reg)
	val step = Mux(go, var78, step_reg)
	new_input := start
	when (start) {
		when (var98 <= upper_bound) {
			when (counter === 1.U) {
				var98 := var98 + step
			}
		}.otherwise {
			start := false.B
			new_input := false.B
		}
	}
}
class outline_3 extends MultiIOModule {
	val go = IO(Input(Bool()))
	val start = RegInit(false.B)
	val new_input = Wire(Bool())
	new_input := false.B
	val done = IO(Output(Bool()))
	done := 0.U
	val var105 = IO(Input(UInt(32.W)))
	val var106 = IO(Input(UInt(32.W)))
	val var107 = IO(Input(UInt(32.W)))
	val var108 = IO(Input(UInt(32.W)))
	val var109 = IO(Input(UInt(32.W)))
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
	val var201 = Reg(UInt(32.W))
	val var202 = Reg(UInt(32.W))
	val var203 = Reg(UInt(32.W))
	val var204 = Reg(UInt(32.W))
	val var205 = Reg(UInt(32.W))
	val var206 = Reg(UInt(32.W))
	val var207 = Reg(UInt(32.W))
	val var208 = Reg(UInt(32.W))
	val var209 = Reg(UInt(32.W))
	val var210 = Reg(UInt(32.W))
	val var211 = Reg(UInt(32.W))
	val var212 = Reg(UInt(32.W))
	val var213 = Reg(UInt(32.W))
	val var214 = Reg(UInt(32.W))
	val var215 = Reg(UInt(32.W))
	val var216 = Reg(UInt(32.W))
	val var217 = Reg(UInt(32.W))
	val var218 = Reg(UInt(32.W))
	val var219 = Reg(UInt(32.W))
	val var220 = Reg(UInt(32.W))
	val var221 = Reg(UInt(32.W))
	val var222 = Reg(UInt(32.W))
	val var223 = Reg(UInt(32.W))
	val var224 = Reg(UInt(32.W))
	val var225 = Reg(UInt(32.W))
	val var226 = Reg(UInt(32.W))
	val var227 = Reg(UInt(32.W))
	val var228 = Reg(UInt(32.W))
	val var229 = Reg(UInt(32.W))
	val var230 = Reg(UInt(32.W))
	val var231 = Reg(UInt(32.W))
	val var232 = Reg(UInt(32.W))
	val var233 = Reg(UInt(32.W))
	val var234 = Reg(UInt(32.W))
	val var235 = Reg(UInt(32.W))
	val var236 = Reg(UInt(32.W))
	val var237 = Reg(UInt(32.W))
	val var238 = Reg(UInt(32.W))
	val var239 = Reg(UInt(32.W))
	val var240 = Reg(UInt(32.W))
	val var241 = Reg(UInt(32.W))
	val muli_outline_3_0 = Module(new MulIIP(32, 2))
	muli_outline_3_0.ce := true.B
	val var242 = muli_outline_3_0.operand0
	var242 := DontCare
	val var243 = muli_outline_3_0.operand1
	var243 := DontCare
	val var244 = muli_outline_3_0.result
	val muli_outline_3_1 = Module(new MulIIP(32, 2))
	muli_outline_3_1.ce := true.B
	val var245 = muli_outline_3_1.operand0
	var245 := DontCare
	val var246 = muli_outline_3_1.operand1
	var246 := DontCare
	val var247 = muli_outline_3_1.result
	val var248 = Reg(UInt(32.W))
	when (go) {
		var248 := var105
	}
	when (go) {
		var110 := var105
	}
	when (go) {
		var111 := var106
	}
	when (go) {
		var112 := var107
	}
	when (go) {
		var113 := var108
	}
	when (go) {
		var114 := var109
	}
	val var0 = IO(Output(UInt(1.W)))
	var0 := false.B
	val var1 = IO(Output(UInt(1.W)))
	var1 := DontCare
	val var3 = IO(Output(UInt(1.W)))
	var3 := false.B
	val var4 = IO(Output(UInt(14.W)))
	var4 := DontCare
	val var6 = IO(Output(UInt(1.W)))
	var6 := false.B
	val var7 = IO(Output(UInt(14.W)))
	var7 := DontCare
	val var8 = IO(Output(UInt(32.W)))
	var8 := DontCare
	val var2 = IO(Input(UInt(32.W)))
	val var5 = IO(Input(UInt(32.W)))
	val shift_register = RegInit(0.U(2.W))
	when (go) {
		when (var105 > var106) {
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
			shift_register(1)
		} else if (stage == 9) {
			shift_register(1)
		} else if (stage == 10) {
			shift_register(1)
		} else if (stage == 11) {
			shift_register(1)
		} else if (stage == 12) {
			shift_register(1)
		} else if (stage == 13) {
			shift_register(1)
		} else {
			new_input
		}
	}
	val counter = RegInit(0.U(3.W))
	when (counter === 6.U) {
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
			var115 := var248
		}
		when (valid(7)) {
			var218 := var5
		}
		val var249 = var220 + var192
		when (valid(7)) {
			var227 := var249
		}
		var4 := var225
		when (valid(7)) {
			var3 := 1.U
		}
		var242 := var5
		var243 := var187
		when (valid(7)) {
			var122 := var121
		}
		when (valid(7)) {
			var147 := var146
		}
		when (valid(7)) {
			var188 := var187
		}
		when (valid(7)) {
			var193 := var192
		}
		when (valid(7)) {
			var198 := var197
		}
		when (valid(7)) {
			var221 := var220
		}
		when (valid(7)) {
			var223 := var222
		}
		when (valid(7)) {
			var226 := var225
		}
	}
	when (counter === 1.U) {
		val var250 = var115 - var112
		when (valid(1)) {
			var128 := var250
		}
		val var251 = var250 + 1.U
		when (valid(1)) {
			var129 := var251
		}
		val var252 = var113 << 5.U
		when (valid(1)) {
			var133 := var252
		}
		val var253 = var114 + var252
		when (valid(1)) {
			var134 := var253
		}
		val var254 = var253 << 4.U
		when (valid(1)) {
			var135 := var254
		}
		val var255 = var251 + var254
		when (valid(1)) {
			var141 := var255
		}
		val var256 = var113 + var112
		when (valid(1)) {
			var153 := var256
		}
		val var257 = var113 - var112
		when (valid(1)) {
			var157 := var257
		}
		val var258 = var114 + var112
		when (valid(1)) {
			var160 := var258
		}
		val var259 = var258 + var252
		when (valid(1)) {
			var161 := var259
		}
		val var260 = var259 << 4.U
		when (valid(1)) {
			var162 := var260
		}
		val var261 = var251 + var260
		when (valid(1)) {
			var163 := var261
		}
		val var262 = var114 - var112
		when (valid(1)) {
			var166 := var262
		}
		val var263 = var262 + var252
		when (valid(1)) {
			var167 := var263
		}
		val var264 = var263 << 4.U
		when (valid(1)) {
			var168 := var264
		}
		val var265 = var251 + var264
		when (valid(1)) {
			var169 := var265
		}
		val var266 = var251 + var112
		when (valid(1)) {
			var171 := var266
		}
		val var267 = var251 - var112
		when (valid(1)) {
			var177 := var267
		}
		var1 := 0.U
		when (valid(1)) {
			var0 := 1.U
		}
		when (valid(1)) {
			var116 := var115
		}
		when (valid(8)) {
			var230 := var5
		}
		var4 := var223
		when (valid(8)) {
			var3 := 1.U
		}
		when (valid(8)) {
			var123 := var122
		}
		when (valid(8)) {
			var148 := var147
		}
		when (valid(8)) {
			var199 := var198
		}
		when (valid(8)) {
			var224 := var223
		}
		when (valid(8)) {
			var228 := var227
		}
	}
	when (counter === 2.U) {
		when (valid(2)) {
			var183 := var2
		}
		var4 := var169
		when (valid(2)) {
			var3 := 1.U
		}
		var1 := var112
		when (valid(2)) {
			var0 := 1.U
		}
		when (valid(2)) {
			var117 := var116
		}
		when (valid(2)) {
			var130 := var129
		}
		when (valid(2)) {
			var136 := var135
		}
		when (valid(2)) {
			var142 := var141
		}
		when (valid(2)) {
			var154 := var153
		}
		when (valid(2)) {
			var158 := var157
		}
		when (valid(2)) {
			var164 := var163
		}
		when (valid(2)) {
			var170 := var169
		}
		when (valid(2)) {
			var172 := var171
		}
		when (valid(2)) {
			var178 := var177
		}
		when (valid(9)) {
			var232 := var244
		}
		when (valid(9)) {
			var236 := var5
		}
		val var268 = var228 + var5
		when (valid(9)) {
			var237 := var268
		}
		val var269 = var268 + var230
		when (valid(9)) {
			var238 := var269
		}
		when (valid(9)) {
			var124 := var123
		}
		when (valid(9)) {
			var149 := var148
		}
		when (valid(9)) {
			var200 := var199
		}
		when (valid(9)) {
			var229 := var228
		}
		when (valid(9)) {
			var231 := var230
		}
	}
	when (counter === 3.U) {
		when (valid(3)) {
			var189 := var5
		}
		when (valid(3)) {
			var194 := var2
		}
		val var270 = var158 << 5.U
		when (valid(3)) {
			var202 := var270
		}
		val var271 = var114 + var270
		when (valid(3)) {
			var203 := var271
		}
		val var272 = var271 << 4.U
		when (valid(3)) {
			var204 := var272
		}
		val var273 = var130 + var272
		when (valid(3)) {
			var205 := var273
		}
		var4 := var164
		when (valid(3)) {
			var3 := 1.U
		}
		when (valid(3)) {
			var118 := var117
		}
		when (valid(3)) {
			var131 := var130
		}
		when (valid(3)) {
			var137 := var136
		}
		when (valid(3)) {
			var143 := var142
		}
		when (valid(3)) {
			var155 := var154
		}
		when (valid(3)) {
			var159 := var158
		}
		when (valid(3)) {
			var165 := var164
		}
		when (valid(3)) {
			var173 := var172
		}
		when (valid(3)) {
			var179 := var178
		}
		when (valid(3)) {
			var184 := var183
		}
		var245 := var238
		var246 := var200
		when (valid(10)) {
			var125 := var124
		}
		when (valid(10)) {
			var150 := var149
		}
		when (valid(10)) {
			var201 := var200
		}
		when (valid(10)) {
			var233 := var232
		}
		when (valid(10)) {
			var239 := var238
		}
	}
	when (counter === 4.U) {
		when (valid(4)) {
			var207 := var5
		}
		val var274 = var155 << 5.U
		when (valid(4)) {
			var210 := var274
		}
		val var275 = var114 + var274
		when (valid(4)) {
			var211 := var275
		}
		val var276 = var275 << 4.U
		when (valid(4)) {
			var212 := var276
		}
		val var277 = var131 + var276
		when (valid(4)) {
			var213 := var277
		}
		var4 := var205
		when (valid(4)) {
			var3 := 1.U
		}
		when (valid(4)) {
			var119 := var118
		}
		when (valid(4)) {
			var132 := var131
		}
		when (valid(4)) {
			var138 := var137
		}
		when (valid(4)) {
			var144 := var143
		}
		when (valid(4)) {
			var156 := var155
		}
		when (valid(4)) {
			var174 := var173
		}
		when (valid(4)) {
			var180 := var179
		}
		when (valid(4)) {
			var185 := var184
		}
		when (valid(4)) {
			var190 := var189
		}
		when (valid(4)) {
			var195 := var194
		}
		when (valid(4)) {
			var206 := var205
		}
		when (valid(11)) {
			var126 := var125
		}
		when (valid(11)) {
			var151 := var150
		}
		when (valid(11)) {
			var234 := var233
		}
	}
	when (counter === 5.U) {
		when (valid(5)) {
			var215 := var5
		}
		var4 := var213
		when (valid(5)) {
			var3 := 1.U
		}
		when (valid(5)) {
			var120 := var119
		}
		when (valid(5)) {
			var139 := var138
		}
		when (valid(5)) {
			var145 := var144
		}
		when (valid(5)) {
			var175 := var174
		}
		when (valid(5)) {
			var181 := var180
		}
		when (valid(5)) {
			var186 := var185
		}
		when (valid(5)) {
			var191 := var190
		}
		when (valid(5)) {
			var196 := var195
		}
		when (valid(5)) {
			var208 := var207
		}
		when (valid(5)) {
			var214 := var213
		}
		when (valid(12)) {
			var240 := var247
		}
		val var278 = var234 + var247
		when (valid(12)) {
			var241 := var278
		}
		when (valid(12)) {
			var127 := var126
		}
		when (valid(12)) {
			var152 := var151
		}
		when (valid(12)) {
			var235 := var234
		}
	}
	when (counter === 6.U) {
		when (valid(6)) {
			var217 := var5
		}
		var4 := var145
		when (valid(6)) {
			var3 := 1.U
		}
		val var279 = var5 + var215
		when (valid(6)) {
			var219 := var279
		}
		val var280 = var279 + var208
		when (valid(6)) {
			var220 := var280
		}
		val var281 = var175 + var139
		when (valid(6)) {
			var222 := var281
		}
		val var282 = var181 + var139
		when (valid(6)) {
			var225 := var282
		}
		when (valid(6)) {
			var121 := var120
		}
		when (valid(6)) {
			var140 := var139
		}
		when (valid(6)) {
			var146 := var145
		}
		when (valid(6)) {
			var176 := var175
		}
		when (valid(6)) {
			var182 := var181
		}
		when (valid(6)) {
			var187 := var186
		}
		when (valid(6)) {
			var192 := var191
		}
		when (valid(6)) {
			var197 := var196
		}
		when (valid(6)) {
			var209 := var208
		}
		when (valid(6)) {
			var216 := var215
		}
		var7 := var152
		var8 := var241
		when (valid(13)) {
			var6 := 1.U
		}
	}
	when (counter === 6.U && valid(13)) {
		done := !valid(6)
	}
	when (done) {
		shift_register := 0.U
		counter := 0.U
	}
	val ub_reg = Reg(UInt(32.W))
	when (go) {
		ub_reg := var106
	}
	val step_reg = Reg(UInt(32.W))
	when (go) {
		step_reg := var107
	}
	val upper_bound = Mux(go, var106, ub_reg)
	val step = Mux(go, var107, step_reg)
	new_input := start
	when (start) {
		when (var248 <= upper_bound) {
			when (counter === 6.U) {
				var248 := var248 + step
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
	val var283 = Reg(UInt(1.W))
	val var284 = Reg(UInt(32.W))
	val var285 = Reg(UInt(32.W))
	val var286 = Reg(UInt(32.W))
	val var287 = Reg(UInt(32.W))
	val var288 = Reg(UInt(32.W))
	val var289 = Reg(UInt(1.W))
	val var290 = Reg(UInt(32.W))
	val outline_0_0 = Module(new outline_0)
	outline_0_0.go := 0.U
	val var291 = outline_0_0.var9
	var291 := DontCare
	val var292 = outline_0_0.var10
	var292 := DontCare
	val var293 = outline_0_0.var11
	var293 := DontCare
	val var294 = outline_0_0.var12
	var294 := DontCare
	val var295 = outline_0_0.done
	val outline_0_0_var3 = IO(Output(UInt(1.W)))
	outline_0_0_var3 := outline_0_0.var3
	val outline_0_0_var4 = IO(Output(UInt(14.W)))
	outline_0_0_var4 := outline_0_0.var4
	val outline_0_0_var6 = IO(Output(UInt(1.W)))
	outline_0_0_var6 := outline_0_0.var6
	val outline_0_0_var7 = IO(Output(UInt(14.W)))
	outline_0_0_var7 := outline_0_0.var7
	val outline_0_0_var8 = IO(Output(UInt(32.W)))
	outline_0_0_var8 := outline_0_0.var8
	val outline_0_0_var5 = IO(Input(UInt(32.W)))
	outline_0_0.var5 := outline_0_0_var5
	val outline_1_0 = Module(new outline_1)
	outline_1_0.go := 0.U
	val var296 = outline_1_0.var41
	var296 := DontCare
	val var297 = outline_1_0.var42
	var297 := DontCare
	val var298 = outline_1_0.var43
	var298 := DontCare
	val var299 = outline_1_0.var44
	var299 := DontCare
	val var300 = outline_1_0.done
	val outline_1_0_var3 = IO(Output(UInt(1.W)))
	outline_1_0_var3 := outline_1_0.var3
	val outline_1_0_var4 = IO(Output(UInt(14.W)))
	outline_1_0_var4 := outline_1_0.var4
	val outline_1_0_var6 = IO(Output(UInt(1.W)))
	outline_1_0_var6 := outline_1_0.var6
	val outline_1_0_var7 = IO(Output(UInt(14.W)))
	outline_1_0_var7 := outline_1_0.var7
	val outline_1_0_var8 = IO(Output(UInt(32.W)))
	outline_1_0_var8 := outline_1_0.var8
	val outline_1_0_var5 = IO(Input(UInt(32.W)))
	outline_1_0.var5 := outline_1_0_var5
	val outline_2_0 = Module(new outline_2)
	outline_2_0.go := 0.U
	val var301 = outline_2_0.var76
	var301 := DontCare
	val var302 = outline_2_0.var77
	var302 := DontCare
	val var303 = outline_2_0.var78
	var303 := DontCare
	val var304 = outline_2_0.var79
	var304 := DontCare
	val var305 = outline_2_0.done
	val outline_2_0_var3 = IO(Output(UInt(1.W)))
	outline_2_0_var3 := outline_2_0.var3
	val outline_2_0_var4 = IO(Output(UInt(14.W)))
	outline_2_0_var4 := outline_2_0.var4
	val outline_2_0_var6 = IO(Output(UInt(1.W)))
	outline_2_0_var6 := outline_2_0.var6
	val outline_2_0_var7 = IO(Output(UInt(14.W)))
	outline_2_0_var7 := outline_2_0.var7
	val outline_2_0_var8 = IO(Output(UInt(32.W)))
	outline_2_0_var8 := outline_2_0.var8
	val outline_2_0_var5 = IO(Input(UInt(32.W)))
	outline_2_0.var5 := outline_2_0_var5
	val outline_3_0 = Module(new outline_3)
	outline_3_0.go := 0.U
	val var306 = outline_3_0.var105
	var306 := DontCare
	val var307 = outline_3_0.var106
	var307 := DontCare
	val var308 = outline_3_0.var107
	var308 := DontCare
	val var309 = outline_3_0.var108
	var309 := DontCare
	val var310 = outline_3_0.var109
	var310 := DontCare
	val var311 = outline_3_0.done
	val outline_3_0_var0 = IO(Output(UInt(1.W)))
	outline_3_0_var0 := outline_3_0.var0
	val outline_3_0_var1 = IO(Output(UInt(1.W)))
	outline_3_0_var1 := outline_3_0.var1
	val outline_3_0_var3 = IO(Output(UInt(1.W)))
	outline_3_0_var3 := outline_3_0.var3
	val outline_3_0_var4 = IO(Output(UInt(14.W)))
	outline_3_0_var4 := outline_3_0.var4
	val outline_3_0_var6 = IO(Output(UInt(1.W)))
	outline_3_0_var6 := outline_3_0.var6
	val outline_3_0_var7 = IO(Output(UInt(14.W)))
	outline_3_0_var7 := outline_3_0.var7
	val outline_3_0_var8 = IO(Output(UInt(32.W)))
	outline_3_0_var8 := outline_3_0.var8
	val outline_3_0_var2 = IO(Input(UInt(32.W)))
	outline_3_0.var2 := outline_3_0_var2
	val outline_3_0_var5 = IO(Input(UInt(32.W)))
	outline_3_0.var5 := outline_3_0_var5
	object State extends ChiselEnum {
		val s0, s1, s1_entry, s2, s2_wait, s3, s4, s5, s5_entry, s6, s7, s8, s8_wait, s9, s10, s11, s11_entry, s12, s13, s14, s14_wait, s15, s16, s17, s17_entry, s18, s19, s20, s20_entry, s21, s22, s23, s23_wait, s24, s25, s26 = Value
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
			val var312 = 0.U <= 31.U
			var283 := var312
			val var313 = !var312
			var284 := 0.U
			state := State.s2;
			when (var313.asBool()) {
				state := State.s4;
			}
		}
		is (State.s1_entry) {
			val var314 = !var283
			state := State.s2;
			when (var314.asBool()) {
				state := State.s4;
			}
		}
		is (State.s2) {
			var291 := 0.U
			var292 := 15.U
			var293 := 1.U
			var294 := var284
			outline_0_0.go := 1.U
			state := State.s2_wait;
			when (var295.asBool()) {
				state := State.s3;
			}
		}
		is (State.s2_wait) {
			when (var295.asBool()) {
				state := State.s3;
			}
		}
		is (State.s3) {
			val var315 = var284 + 1.U
			var284 := var315
			val var316 = var315 <= 31.U
			var283 := var316
			state := State.s1_entry;
		}
		is (State.s4) {
			state := State.s5;
		}
		is (State.s5) {
			val var317 = 1.U <= 30.U
			var283 := var317
			val var318 = !var317
			var284 := 1.U
			state := State.s6;
			when (var318.asBool()) {
				state := State.s10;
			}
		}
		is (State.s5_entry) {
			val var319 = !var283
			state := State.s6;
			when (var319.asBool()) {
				state := State.s10;
			}
		}
		is (State.s6) {
			val var320 = var284 - 1.U
			var285 := var320
			val var321 = var320 + 1.U
			var286 := var321
			state := State.s7;
		}
		is (State.s7) {
			state := State.s8;
		}
		is (State.s8) {
			var296 := 0.U
			var297 := 15.U
			var298 := 1.U
			var299 := var286
			outline_1_0.go := 1.U
			state := State.s8_wait;
			when (var300.asBool()) {
				state := State.s9;
			}
		}
		is (State.s8_wait) {
			when (var300.asBool()) {
				state := State.s9;
			}
		}
		is (State.s9) {
			val var322 = var284 + 1.U
			var284 := var322
			val var323 = var322 <= 30.U
			var283 := var323
			state := State.s5_entry;
		}
		is (State.s10) {
			state := State.s11;
		}
		is (State.s11) {
			val var324 = 1.U <= 30.U
			var283 := var324
			val var325 = !var324
			var284 := 1.U
			state := State.s12;
			when (var325.asBool()) {
				state := State.s16;
			}
		}
		is (State.s11_entry) {
			val var326 = !var283
			state := State.s12;
			when (var326.asBool()) {
				state := State.s16;
			}
		}
		is (State.s12) {
			val var327 = var284 - 1.U
			var287 := var327
			val var328 = var327 + 1.U
			var285 := var328
			state := State.s13;
		}
		is (State.s13) {
			state := State.s14;
		}
		is (State.s14) {
			var301 := 1.U
			var302 := 30.U
			var303 := 1.U
			var304 := var285
			outline_2_0.go := 1.U
			state := State.s14_wait;
			when (var305.asBool()) {
				state := State.s15;
			}
		}
		is (State.s14_wait) {
			when (var305.asBool()) {
				state := State.s15;
			}
		}
		is (State.s15) {
			val var329 = var284 + 1.U
			var284 := var329
			val var330 = var329 <= 30.U
			var283 := var330
			state := State.s11_entry;
		}
		is (State.s16) {
			state := State.s17;
		}
		is (State.s17) {
			val var331 = 1.U <= 30.U
			var283 := var331
			val var332 = !var331
			var284 := 1.U
			state := State.s18;
			when (var332.asBool()) {
				state := State.s26;
			}
		}
		is (State.s17_entry) {
			val var333 = !var283
			state := State.s18;
			when (var333.asBool()) {
				state := State.s26;
			}
		}
		is (State.s18) {
			val var334 = var284 - 1.U
			var288 := var334
			val var335 = var334 + 1.U
			var285 := var335
			state := State.s19;
		}
		is (State.s19) {
			state := State.s20;
		}
		is (State.s20) {
			val var336 = 1.U <= 30.U
			var289 := var336
			val var337 = !var336
			var286 := 1.U
			state := State.s21;
			when (var337.asBool()) {
				state := State.s25;
			}
		}
		is (State.s20_entry) {
			val var338 = !var289
			state := State.s21;
			when (var338.asBool()) {
				state := State.s25;
			}
		}
		is (State.s21) {
			val var339 = var286 - 1.U
			var290 := var339
			val var340 = var339 + 1.U
			var287 := var340
			state := State.s22;
		}
		is (State.s22) {
			state := State.s23;
		}
		is (State.s23) {
			var306 := 1.U
			var307 := 14.U
			var308 := 1.U
			var309 := var285
			var310 := var287
			outline_3_0.go := 1.U
			state := State.s23_wait;
			when (var311.asBool()) {
				state := State.s24;
			}
		}
		is (State.s23_wait) {
			when (var311.asBool()) {
				state := State.s24;
			}
		}
		is (State.s24) {
			val var341 = var286 + 1.U
			var286 := var341
			val var342 = var341 <= 30.U
			var289 := var342
			state := State.s20_entry;
		}
		is (State.s25) {
			val var343 = var284 + 1.U
			var284 := var343
			val var344 = var343 <= 30.U
			var283 := var344
			state := State.s17_entry;
		}
		is (State.s26) {
			done := 1.U
		}
	}
}
	val main = Module(new main)
	mem_global_1.dataIn(0).valid := main.outline_0_0_var3
	mem_global_1.dataIn(0).bits := main.outline_0_0_var4
	mem_global_2.dataIn(0).valid := main.outline_0_0_var6
	mem_global_2.dataIn(0).bits := main.outline_0_0_var7
	mem_global_2.w_dataIn(0).bits := main.outline_0_0_var8
	mem_global_1.dataIn(1).valid := main.outline_1_0_var3
	mem_global_1.dataIn(1).bits := main.outline_1_0_var4
	mem_global_2.dataIn(1).valid := main.outline_1_0_var6
	mem_global_2.dataIn(1).bits := main.outline_1_0_var7
	mem_global_2.w_dataIn(1).bits := main.outline_1_0_var8
	mem_global_1.dataIn(2).valid := main.outline_2_0_var3
	mem_global_1.dataIn(2).bits := main.outline_2_0_var4
	mem_global_2.dataIn(2).valid := main.outline_2_0_var6
	mem_global_2.dataIn(2).bits := main.outline_2_0_var7
	mem_global_2.w_dataIn(2).bits := main.outline_2_0_var8
	mem_global_0.dataIn(0).valid := main.outline_3_0_var0
	mem_global_0.dataIn(0).bits := main.outline_3_0_var1
	mem_global_1.dataIn(3).valid := main.outline_3_0_var3
	mem_global_1.dataIn(3).bits := main.outline_3_0_var4
	mem_global_2.dataIn(3).valid := main.outline_3_0_var6
	mem_global_2.dataIn(3).bits := main.outline_3_0_var7
	mem_global_2.w_dataIn(3).bits := main.outline_3_0_var8
	val go = IO(Input(Bool()))
	main.go := go
	val done = IO(Output(Bool()))
	done := main.done
	main.outline_0_0_var5 := var5
	main.outline_1_0_var5 := var5
	main.outline_2_0_var5 := var5
	main.outline_3_0_var2 := var2
	main.outline_3_0_var5 := var5
	val mem_global_2_test_addr = IO(Input(UInt(log2Ceil(16384).W)))
	mem_global_2.test_addr := mem_global_2_test_addr
	val mem_global_2_test_data = IO(Output(UInt(32.W)))
	mem_global_2_test_data := mem_global_2.test_data
	mem_global_2.finished := done
}

