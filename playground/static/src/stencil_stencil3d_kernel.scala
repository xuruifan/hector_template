import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class stencil3d extends MultiIOModule {
	val mem_global_0 = Module(new ReadMem(2, 32))
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
	val var31 = Reg(UInt(64.W))
	val var32 = Reg(UInt(64.W))
	val var33 = Reg(UInt(64.W))
	val var34 = Reg(UInt(64.W))
	val var35 = Reg(UInt(64.W))
	val var36 = Reg(UInt(64.W))
	val var37 = Reg(UInt(32.W))
	val var38 = Reg(UInt(64.W))
	val var39 = Reg(UInt(64.W))
	val var40 = Reg(UInt(64.W))
	val var41 = Reg(UInt(64.W))
	val var42 = Reg(UInt(32.W))
	val muli_outline_0_0 = Module(new MulI())
	val var43 = muli_outline_0_0.operand0
	var43 := DontCare
	val var44 = muli_outline_0_0.operand1
	var44 := DontCare
	val var45 = muli_outline_0_0.result
	val muli_outline_0_1 = Module(new MulI())
	val var46 = muli_outline_0_1.operand0
	var46 := DontCare
	val var47 = muli_outline_0_1.operand1
	var47 := DontCare
	val var48 = muli_outline_0_1.result
	val var49 = Reg(UInt(32.W))
	when (go) {
		var49 := var9
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
			shift_register(0)
		} else if (stage == 4) {
			shift_register(0)
		} else if (stage == 5) {
			shift_register(1)
		} else if (stage == 6) {
			shift_register(1)
		} else if (stage == 7) {
			shift_register(1)
		} else if (stage == 8) {
			shift_register(1)
		} else if (stage == 9) {
			shift_register(2)
		} else if (stage == 10) {
			shift_register(2)
		} else if (stage == 11) {
			shift_register(2)
		} else {
			new_input
		}
	}
	when (valid(11)) {
		done := !valid(7)
	}
	val counter = RegInit(0.U(2.W))
	when (counter === 3.U) {
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
			var17 := var49
		}
		when (valid(4)) {
			var21 := var20
		}
		var4 := var38
		when (valid(8)) {
			var3 := 1.U
		}
		when (valid(8)) {
			var25 := var24
		}
		when (valid(8)) {
			var35 := var34
		}
		when (valid(8)) {
			var39 := var38
		}
	}
	when (counter === 1.U) {
		val var50 = var16 + 992.U
		when (valid(1)) {
			var28 := var50
		}
		when (valid(1)) {
			var18 := var17
		}
		when (valid(5)) {
			var22 := var21
		}
		when (valid(9)) {
			var37 := var5
		}
		var7 := var35
		var8 := var5
		when (valid(9)) {
			var6 := 1.U
		}
		when (valid(9)) {
			var26 := var25
		}
		when (valid(9)) {
			var36 := var35
		}
		when (valid(9)) {
			var40 := var39
		}
	}
	when (counter === 2.U) {
		var43 := var16
		var44 := 16.U
		when (valid(2)) {
			var19 := var18
		}
		when (valid(2)) {
			var29 := var28
		}
		when (valid(6)) {
			var31 := var45
		}
		val var51 = var22 + var45
		when (valid(6)) {
			var33 := var51
		}
		when (valid(6)) {
			var23 := var22
		}
		when (valid(10)) {
			var42 := var5
		}
		when (valid(10)) {
			var27 := var26
		}
		when (valid(10)) {
			var41 := var40
		}
	}
	when (counter === 3.U) {
		var46 := var29
		var47 := 16.U
		when (valid(3)) {
			var20 := var19
		}
		when (valid(3)) {
			var30 := var29
		}
		when (valid(7)) {
			var32 := var48
		}
		var4 := var33
		when (valid(7)) {
			var3 := 1.U
		}
		val var52 = var23 + var48
		when (valid(7)) {
			var38 := var52
		}
		when (valid(7)) {
			var24 := var23
		}
		when (valid(7)) {
			var34 := var33
		}
		var7 := var41
		var8 := var42
		when (valid(11)) {
			var6 := 1.U
		}
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
		when (var49 <= upper_bound) {
			when (counter === 3.U) {
				var49 := var49 + step
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
	val var53 = IO(Input(UInt(32.W)))
	val var54 = IO(Input(UInt(32.W)))
	val var55 = IO(Input(UInt(32.W)))
	val var56 = IO(Input(UInt(32.W)))
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
	val var76 = Reg(UInt(64.W))
	val var77 = Reg(UInt(64.W))
	val var78 = Reg(UInt(64.W))
	val var79 = Reg(UInt(64.W))
	val var80 = Reg(UInt(64.W))
	val var81 = Reg(UInt(64.W))
	val var82 = Reg(UInt(64.W))
	val var83 = Reg(UInt(64.W))
	val var84 = Reg(UInt(64.W))
	val var85 = Reg(UInt(64.W))
	val var86 = Reg(UInt(64.W))
	val var87 = Reg(UInt(32.W))
	val var88 = Reg(UInt(64.W))
	val var89 = Reg(UInt(64.W))
	val var90 = Reg(UInt(64.W))
	val var91 = Reg(UInt(64.W))
	val var92 = Reg(UInt(32.W))
	val muli_outline_1_0 = Module(new MulI())
	val var93 = muli_outline_1_0.operand0
	var93 := DontCare
	val var94 = muli_outline_1_0.operand1
	var94 := DontCare
	val var95 = muli_outline_1_0.result
	val muli_outline_1_1 = Module(new MulI())
	val var96 = muli_outline_1_1.operand0
	var96 := DontCare
	val var97 = muli_outline_1_1.operand1
	var97 := DontCare
	val var98 = muli_outline_1_1.result
	val muli_outline_1_2 = Module(new MulI())
	val var99 = muli_outline_1_2.operand0
	var99 := DontCare
	val var100 = muli_outline_1_2.operand1
	var100 := DontCare
	val var101 = muli_outline_1_2.result
	val var102 = Reg(UInt(32.W))
	when (go) {
		var102 := var53
	}
	when (go) {
		var57 := var53
	}
	when (go) {
		var58 := var54
	}
	when (go) {
		var59 := var55
	}
	when (go) {
		var60 := var56
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
	val shift_register = RegInit(0.U(4.W))
	when (go) {
		when (var53 > var54) {
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
			shift_register(1)
		} else if (stage == 6) {
			shift_register(1)
		} else if (stage == 7) {
			shift_register(1)
		} else if (stage == 8) {
			shift_register(1)
		} else if (stage == 9) {
			shift_register(2)
		} else if (stage == 10) {
			shift_register(2)
		} else if (stage == 11) {
			shift_register(2)
		} else if (stage == 12) {
			shift_register(2)
		} else if (stage == 13) {
			shift_register(3)
		} else if (stage == 14) {
			shift_register(3)
		} else if (stage == 15) {
			shift_register(3)
		} else {
			new_input
		}
	}
	when (valid(15)) {
		done := !valid(11)
	}
	val counter = RegInit(0.U(2.W))
	when (counter === 3.U) {
		counter := 0.U
	}.otherwise {
		when (start || shift_register =/= 0.U) {
			counter := counter + 1.U
		}
	}
	when (counter === 0.U) {
		shift_register := Cat(shift_register(2, 0), new_input)
	}
	when (counter === 0.U) {
		when (valid(0)) {
			var61 := var102
		}
		when (valid(4)) {
			var65 := var64
		}
		when (valid(8)) {
			var69 := var68
		}
		var4 := var88
		when (valid(12)) {
			var3 := 1.U
		}
		when (valid(12)) {
			var73 := var72
		}
		when (valid(12)) {
			var85 := var84
		}
		when (valid(12)) {
			var89 := var88
		}
	}
	when (counter === 1.U) {
		var93 := var60
		var94 := 32.U
		when (valid(1)) {
			var62 := var61
		}
		when (valid(5)) {
			var76 := var95
		}
		val var103 = var95 + 31.U
		when (valid(5)) {
			var78 := var103
		}
		when (valid(5)) {
			var66 := var65
		}
		when (valid(9)) {
			var70 := var69
		}
		when (valid(13)) {
			var87 := var5
		}
		var7 := var85
		var8 := var5
		when (valid(13)) {
			var6 := 1.U
		}
		when (valid(13)) {
			var74 := var73
		}
		when (valid(13)) {
			var86 := var85
		}
		when (valid(13)) {
			var90 := var89
		}
	}
	when (counter === 2.U) {
		when (valid(2)) {
			var63 := var62
		}
		var96 := var76
		var97 := 16.U
		when (valid(6)) {
			var67 := var66
		}
		when (valid(6)) {
			var77 := var76
		}
		when (valid(6)) {
			var79 := var78
		}
		when (valid(10)) {
			var81 := var98
		}
		val var104 = var70 + var98
		when (valid(10)) {
			var83 := var104
		}
		when (valid(10)) {
			var71 := var70
		}
		when (valid(14)) {
			var92 := var5
		}
		when (valid(14)) {
			var75 := var74
		}
		when (valid(14)) {
			var91 := var90
		}
	}
	when (counter === 3.U) {
		when (valid(3)) {
			var64 := var63
		}
		var99 := var79
		var100 := 16.U
		when (valid(7)) {
			var68 := var67
		}
		when (valid(7)) {
			var80 := var79
		}
		when (valid(11)) {
			var82 := var101
		}
		var4 := var83
		when (valid(11)) {
			var3 := 1.U
		}
		val var105 = var71 + var101
		when (valid(11)) {
			var88 := var105
		}
		when (valid(11)) {
			var72 := var71
		}
		when (valid(11)) {
			var84 := var83
		}
		var7 := var91
		var8 := var92
		when (valid(15)) {
			var6 := 1.U
		}
	}
	when (done) {
		shift_register := 0.U
		counter := 0.U
	}
	val ub_reg = Reg(UInt(32.W))
	when (go) {
		ub_reg := var54
	}
	val step_reg = Reg(UInt(32.W))
	when (go) {
		step_reg := var55
	}
	val upper_bound = Mux(go, var54, ub_reg)
	val step = Mux(go, var55, step_reg)
	new_input := start
	when (start) {
		when (var102 <= upper_bound) {
			when (counter === 3.U) {
				var102 := var102 + step
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
	val var134 = Reg(UInt(64.W))
	val var135 = Reg(UInt(64.W))
	val var136 = Reg(UInt(64.W))
	val var137 = Reg(UInt(64.W))
	val var138 = Reg(UInt(64.W))
	val var139 = Reg(UInt(64.W))
	val var140 = Reg(UInt(32.W))
	val var141 = Reg(UInt(64.W))
	val var142 = Reg(UInt(64.W))
	val var143 = Reg(UInt(64.W))
	val var144 = Reg(UInt(64.W))
	val var145 = Reg(UInt(32.W))
	val muli_outline_2_0 = Module(new MulI())
	val var146 = muli_outline_2_0.operand0
	var146 := DontCare
	val var147 = muli_outline_2_0.operand1
	var147 := DontCare
	val var148 = muli_outline_2_0.result
	val muli_outline_2_1 = Module(new MulI())
	val var149 = muli_outline_2_1.operand0
	var149 := DontCare
	val var150 = muli_outline_2_1.operand1
	var150 := DontCare
	val var151 = muli_outline_2_1.result
	val var152 = Reg(UInt(32.W))
	when (go) {
		var152 := var106
	}
	when (go) {
		var110 := var106
	}
	when (go) {
		var111 := var107
	}
	when (go) {
		var112 := var108
	}
	when (go) {
		var113 := var109
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
	val shift_register = RegInit(0.U(4.W))
	when (go) {
		when (var106 > var107) {
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
			shift_register(1)
		} else if (stage == 6) {
			shift_register(1)
		} else if (stage == 7) {
			shift_register(1)
		} else if (stage == 8) {
			shift_register(1)
		} else if (stage == 9) {
			shift_register(2)
		} else if (stage == 10) {
			shift_register(2)
		} else if (stage == 11) {
			shift_register(2)
		} else if (stage == 12) {
			shift_register(2)
		} else if (stage == 13) {
			shift_register(3)
		} else if (stage == 14) {
			shift_register(3)
		} else {
			new_input
		}
	}
	when (valid(14)) {
		done := !valid(10)
	}
	val counter = RegInit(0.U(2.W))
	when (counter === 3.U) {
		counter := 0.U
	}.otherwise {
		when (start || shift_register =/= 0.U) {
			counter := counter + 1.U
		}
	}
	when (counter === 0.U) {
		shift_register := Cat(shift_register(2, 0), new_input)
	}
	when (counter === 0.U) {
		when (valid(0)) {
			var114 := var152
		}
		when (valid(4)) {
			var118 := var117
		}
		when (valid(4)) {
			var132 := var131
		}
		when (valid(8)) {
			var122 := var121
		}
		when (valid(12)) {
			var140 := var5
		}
		var7 := var138
		var8 := var5
		when (valid(12)) {
			var6 := 1.U
		}
		when (valid(12)) {
			var126 := var125
		}
		when (valid(12)) {
			var139 := var138
		}
		when (valid(12)) {
			var143 := var142
		}
	}
	when (counter === 1.U) {
		val var153 = var114 - var112
		when (valid(1)) {
			var128 := var153
		}
		val var154 = var153 + 1.U
		when (valid(1)) {
			var129 := var154
		}
		var146 := var113
		var147 := 32.U
		when (valid(1)) {
			var115 := var114
		}
		when (valid(5)) {
			var134 := var148
		}
		val var155 = var132 + var148
		when (valid(5)) {
			var135 := var155
		}
		when (valid(5)) {
			var119 := var118
		}
		when (valid(5)) {
			var133 := var132
		}
		when (valid(9)) {
			var123 := var122
		}
		when (valid(13)) {
			var145 := var5
		}
		when (valid(13)) {
			var127 := var126
		}
		when (valid(13)) {
			var144 := var143
		}
	}
	when (counter === 2.U) {
		when (valid(2)) {
			var116 := var115
		}
		when (valid(2)) {
			var130 := var129
		}
		var149 := var135
		var150 := 16.U
		when (valid(6)) {
			var120 := var119
		}
		when (valid(6)) {
			var136 := var135
		}
		when (valid(10)) {
			var137 := var151
		}
		var4 := var151
		when (valid(10)) {
			var3 := 1.U
		}
		val var156 = var151 + 15.U
		when (valid(10)) {
			var141 := var156
		}
		when (valid(10)) {
			var124 := var123
		}
		var7 := var144
		var8 := var145
		when (valid(14)) {
			var6 := 1.U
		}
	}
	when (counter === 3.U) {
		when (valid(3)) {
			var117 := var116
		}
		when (valid(3)) {
			var131 := var130
		}
		when (valid(7)) {
			var121 := var120
		}
		var4 := var141
		when (valid(11)) {
			var3 := 1.U
		}
		when (valid(11)) {
			var125 := var124
		}
		when (valid(11)) {
			var138 := var137
		}
		when (valid(11)) {
			var142 := var141
		}
	}
	when (done) {
		shift_register := 0.U
		counter := 0.U
	}
	val ub_reg = Reg(UInt(32.W))
	when (go) {
		ub_reg := var107
	}
	val step_reg = Reg(UInt(32.W))
	when (go) {
		step_reg := var108
	}
	val upper_bound = Mux(go, var107, ub_reg)
	val step = Mux(go, var108, step_reg)
	new_input := start
	when (start) {
		when (var152 <= upper_bound) {
			when (counter === 3.U) {
				var152 := var152 + step
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
	val var157 = IO(Input(UInt(32.W)))
	val var158 = IO(Input(UInt(32.W)))
	val var159 = IO(Input(UInt(32.W)))
	val var160 = IO(Input(UInt(32.W)))
	val var161 = IO(Input(UInt(32.W)))
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
	val var210 = Reg(UInt(64.W))
	val var211 = Reg(UInt(32.W))
	val var212 = Reg(UInt(32.W))
	val var213 = Reg(UInt(64.W))
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
	val var242 = Reg(UInt(32.W))
	val var243 = Reg(UInt(32.W))
	val var244 = Reg(UInt(32.W))
	val var245 = Reg(UInt(32.W))
	val var246 = Reg(UInt(32.W))
	val var247 = Reg(UInt(32.W))
	val var248 = Reg(UInt(32.W))
	val var249 = Reg(UInt(32.W))
	val var250 = Reg(UInt(32.W))
	val var251 = Reg(UInt(32.W))
	val var252 = Reg(UInt(32.W))
	val var253 = Reg(UInt(32.W))
	val var254 = Reg(UInt(32.W))
	val var255 = Reg(UInt(32.W))
	val var256 = Reg(UInt(32.W))
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
	val var284 = Reg(UInt(64.W))
	val var285 = Reg(UInt(64.W))
	val var286 = Reg(UInt(64.W))
	val var287 = Reg(UInt(64.W))
	val var288 = Reg(UInt(64.W))
	val var289 = Reg(UInt(64.W))
	val var290 = Reg(UInt(64.W))
	val var291 = Reg(UInt(64.W))
	val var292 = Reg(UInt(64.W))
	val var293 = Reg(UInt(64.W))
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
	val var323 = Reg(UInt(32.W))
	val var324 = Reg(UInt(32.W))
	val var325 = Reg(UInt(32.W))
	val var326 = Reg(UInt(32.W))
	val var327 = Reg(UInt(32.W))
	val var328 = Reg(UInt(32.W))
	val var329 = Reg(UInt(32.W))
	val var330 = Reg(UInt(32.W))
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
	val var343 = Reg(UInt(32.W))
	val var344 = Reg(UInt(32.W))
	val var345 = Reg(UInt(32.W))
	val var346 = Reg(UInt(32.W))
	val var347 = Reg(UInt(32.W))
	val var348 = Reg(UInt(32.W))
	val var349 = Reg(UInt(32.W))
	val var350 = Reg(UInt(32.W))
	val var351 = Reg(UInt(32.W))
	val var352 = Reg(UInt(64.W))
	val var353 = Reg(UInt(64.W))
	val var354 = Reg(UInt(32.W))
	val var355 = Reg(UInt(32.W))
	val var356 = Reg(UInt(32.W))
	val var357 = Reg(UInt(32.W))
	val var358 = Reg(UInt(32.W))
	val var359 = Reg(UInt(32.W))
	val var360 = Reg(UInt(32.W))
	val var361 = Reg(UInt(32.W))
	val var362 = Reg(UInt(32.W))
	val var363 = Reg(UInt(32.W))
	val var364 = Reg(UInt(32.W))
	val var365 = Reg(UInt(32.W))
	val var366 = Reg(UInt(32.W))
	val var367 = Reg(UInt(32.W))
	val var368 = Reg(UInt(32.W))
	val var369 = Reg(UInt(32.W))
	val var370 = Reg(UInt(32.W))
	val var371 = Reg(UInt(32.W))
	val var372 = Reg(UInt(32.W))
	val var373 = Reg(UInt(32.W))
	val var374 = Reg(UInt(32.W))
	val var375 = Reg(UInt(32.W))
	val var376 = Reg(UInt(32.W))
	val var377 = Reg(UInt(32.W))
	val var378 = Reg(UInt(32.W))
	val muli_outline_3_0 = Module(new MulI())
	val var379 = muli_outline_3_0.operand0
	var379 := DontCare
	val var380 = muli_outline_3_0.operand1
	var380 := DontCare
	val var381 = muli_outline_3_0.result
	val muli_outline_3_1 = Module(new MulI())
	val var382 = muli_outline_3_1.operand0
	var382 := DontCare
	val var383 = muli_outline_3_1.operand1
	var383 := DontCare
	val var384 = muli_outline_3_1.result
	val muli_outline_3_2 = Module(new MulI())
	val var385 = muli_outline_3_2.operand0
	var385 := DontCare
	val var386 = muli_outline_3_2.operand1
	var386 := DontCare
	val var387 = muli_outline_3_2.result
	val muli_outline_3_3 = Module(new MulI())
	val var388 = muli_outline_3_3.operand0
	var388 := DontCare
	val var389 = muli_outline_3_3.operand1
	var389 := DontCare
	val var390 = muli_outline_3_3.result
	val muli_outline_3_4 = Module(new MulI())
	val var391 = muli_outline_3_4.operand0
	var391 := DontCare
	val var392 = muli_outline_3_4.operand1
	var392 := DontCare
	val var393 = muli_outline_3_4.result
	val muli_outline_3_5 = Module(new MulI())
	val var394 = muli_outline_3_5.operand0
	var394 := DontCare
	val var395 = muli_outline_3_5.operand1
	var395 := DontCare
	val var396 = muli_outline_3_5.result
	val muli_outline_3_6 = Module(new MulI())
	val var397 = muli_outline_3_6.operand0
	var397 := DontCare
	val var398 = muli_outline_3_6.operand1
	var398 := DontCare
	val var399 = muli_outline_3_6.result
	val muli_outline_3_7 = Module(new MulI())
	val var400 = muli_outline_3_7.operand0
	var400 := DontCare
	val var401 = muli_outline_3_7.operand1
	var401 := DontCare
	val var402 = muli_outline_3_7.result
	val muli_outline_3_8 = Module(new MulI())
	val var403 = muli_outline_3_8.operand0
	var403 := DontCare
	val var404 = muli_outline_3_8.operand1
	var404 := DontCare
	val var405 = muli_outline_3_8.result
	val muli_outline_3_9 = Module(new MulI())
	val var406 = muli_outline_3_9.operand0
	var406 := DontCare
	val var407 = muli_outline_3_9.operand1
	var407 := DontCare
	val var408 = muli_outline_3_9.result
	val var409 = Reg(UInt(32.W))
	when (go) {
		var409 := var157
	}
	when (go) {
		var162 := var157
	}
	when (go) {
		var163 := var158
	}
	when (go) {
		var164 := var159
	}
	when (go) {
		var165 := var160
	}
	when (go) {
		var166 := var161
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
	val shift_register = RegInit(0.U(3.W))
	when (go) {
		when (var157 > var158) {
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
			shift_register(1)
		} else if (stage == 12) {
			shift_register(1)
		} else if (stage == 13) {
			shift_register(1)
		} else if (stage == 14) {
			shift_register(1)
		} else if (stage == 15) {
			shift_register(1)
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
			shift_register(2)
		} else if (stage == 22) {
			shift_register(2)
		} else if (stage == 23) {
			shift_register(2)
		} else if (stage == 24) {
			shift_register(2)
		} else if (stage == 25) {
			shift_register(2)
		} else if (stage == 26) {
			shift_register(2)
		} else if (stage == 27) {
			shift_register(2)
		} else if (stage == 28) {
			shift_register(2)
		} else {
			new_input
		}
	}
	when (valid(28)) {
		done := !valid(18)
	}
	val counter = RegInit(0.U(4.W))
	when (counter === 9.U) {
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
			var167 := var409
		}
		when (valid(10)) {
			var288 := var402
		}
		var388 := var295
		var389 := 16.U
		val var410 = var204 + var402
		when (valid(10)) {
			var299 := var410
		}
		when (valid(10)) {
			var177 := var176
		}
		when (valid(10)) {
			var205 := var204
		}
		when (valid(10)) {
			var229 := var228
		}
		when (valid(10)) {
			var242 := var241
		}
		when (valid(10)) {
			var251 := var250
		}
		when (valid(10)) {
			var270 := var269
		}
		when (valid(10)) {
			var296 := var295
		}
		when (valid(20)) {
			var368 := var5
		}
		val var411 = var5 + var366
		when (valid(20)) {
			var369 := var411
		}
		val var412 = var411 + var350
		when (valid(20)) {
			var370 := var412
		}
		val var413 = var412 + var328
		when (valid(20)) {
			var371 := var413
		}
		val var414 = var413 + var364
		when (valid(20)) {
			var372 := var414
		}
		val var415 = var414 + var346
		when (valid(20)) {
			var373 := var415
		}
		when (valid(20)) {
			var187 := var186
		}
		when (valid(20)) {
			var280 := var279
		}
		when (valid(20)) {
			var315 := var314
		}
		when (valid(20)) {
			var329 := var328
		}
		when (valid(20)) {
			var347 := var346
		}
		when (valid(20)) {
			var351 := var350
		}
		when (valid(20)) {
			var355 := var354
		}
		when (valid(20)) {
			var365 := var364
		}
		when (valid(20)) {
			var367 := var366
		}
	}
	when (counter === 1.U) {
		val var416 = var167 - var164
		when (valid(1)) {
			var195 := var416
		}
		val var417 = var416 + 1.U
		when (valid(1)) {
			var196 := var417
		}
		var379 := var165
		var380 := 32.U
		val var418 = var165 - var164
		when (valid(1)) {
			var211 := var418
		}
		when (valid(1)) {
			var168 := var167
		}
		when (valid(11)) {
			var289 := var399
		}
		val var419 = var205 + var399
		when (valid(11)) {
			var302 := var419
		}
		when (valid(11)) {
			var178 := var177
		}
		when (valid(11)) {
			var206 := var205
		}
		when (valid(11)) {
			var230 := var229
		}
		when (valid(11)) {
			var243 := var242
		}
		when (valid(11)) {
			var252 := var251
		}
		when (valid(11)) {
			var271 := var270
		}
		when (valid(11)) {
			var300 := var299
		}
		when (valid(21)) {
			var188 := var187
		}
		when (valid(21)) {
			var281 := var280
		}
		when (valid(21)) {
			var316 := var315
		}
		when (valid(21)) {
			var356 := var355
		}
		when (valid(21)) {
			var374 := var373
		}
	}
	when (counter === 2.U) {
		var391 := var211
		var392 := 32.U
		when (valid(2)) {
			var169 := var168
		}
		when (valid(2)) {
			var197 := var196
		}
		when (valid(2)) {
			var212 := var211
		}
		when (valid(12)) {
			var290 := var384
		}
		val var420 = var206 + var384
		when (valid(12)) {
			var307 := var420
		}
		var4 := var300
		when (valid(12)) {
			var3 := 1.U
		}
		when (valid(12)) {
			var179 := var178
		}
		when (valid(12)) {
			var207 := var206
		}
		when (valid(12)) {
			var231 := var230
		}
		when (valid(12)) {
			var244 := var243
		}
		when (valid(12)) {
			var253 := var252
		}
		when (valid(12)) {
			var272 := var271
		}
		when (valid(12)) {
			var301 := var300
		}
		when (valid(12)) {
			var303 := var302
		}
		when (valid(22)) {
			var189 := var188
		}
		when (valid(22)) {
			var282 := var281
		}
		when (valid(22)) {
			var317 := var316
		}
		when (valid(22)) {
			var357 := var356
		}
		when (valid(22)) {
			var375 := var374
		}
	}
	when (counter === 3.U) {
		val var421 = var165 + var164
		when (valid(3)) {
			var214 := var421
		}
		val var422 = var166 + var164
		when (valid(3)) {
			var216 := var422
		}
		val var423 = var166 - var164
		when (valid(3)) {
			var219 := var423
		}
		val var424 = var197 + var164
		when (valid(3)) {
			var222 := var424
		}
		val var425 = var197 - var164
		when (valid(3)) {
			var235 := var425
		}
		var1 := 0.U
		when (valid(3)) {
			var0 := 1.U
		}
		when (valid(3)) {
			var170 := var169
		}
		when (valid(3)) {
			var198 := var197
		}
		when (valid(13)) {
			var297 := var396
		}
		var4 := var307
		when (valid(13)) {
			var3 := 1.U
		}
		val var426 = var207 + var396
		when (valid(13)) {
			var331 := var426
		}
		val var427 = var244 + var290
		when (valid(13)) {
			var336 := var427
		}
		when (valid(13)) {
			var180 := var179
		}
		when (valid(13)) {
			var208 := var207
		}
		when (valid(13)) {
			var232 := var231
		}
		when (valid(13)) {
			var245 := var244
		}
		when (valid(13)) {
			var254 := var253
		}
		when (valid(13)) {
			var273 := var272
		}
		when (valid(13)) {
			var291 := var290
		}
		when (valid(13)) {
			var304 := var303
		}
		when (valid(13)) {
			var308 := var307
		}
		var406 := var375
		var407 := var282
		when (valid(23)) {
			var190 := var189
		}
		when (valid(23)) {
			var283 := var282
		}
		when (valid(23)) {
			var318 := var317
		}
		when (valid(23)) {
			var358 := var357
		}
		when (valid(23)) {
			var376 := var375
		}
	}
	when (counter === 4.U) {
		var385 := var214
		var386 := 32.U
		when (valid(4)) {
			var171 := var170
		}
		when (valid(4)) {
			var199 := var198
		}
		when (valid(4)) {
			var215 := var214
		}
		when (valid(4)) {
			var217 := var216
		}
		when (valid(4)) {
			var220 := var219
		}
		when (valid(4)) {
			var223 := var222
		}
		when (valid(4)) {
			var236 := var235
		}
		when (valid(14)) {
			var298 := var390
		}
		when (valid(14)) {
			var323 := var5
		}
		val var428 = var208 + var390
		when (valid(14)) {
			var338 := var428
		}
		var4 := var336
		when (valid(14)) {
			var3 := 1.U
		}
		when (valid(14)) {
			var181 := var180
		}
		when (valid(14)) {
			var209 := var208
		}
		when (valid(14)) {
			var233 := var232
		}
		when (valid(14)) {
			var255 := var254
		}
		when (valid(14)) {
			var274 := var273
		}
		when (valid(14)) {
			var292 := var291
		}
		when (valid(14)) {
			var305 := var304
		}
		when (valid(14)) {
			var309 := var308
		}
		when (valid(14)) {
			var332 := var331
		}
		when (valid(14)) {
			var337 := var336
		}
		when (valid(24)) {
			var191 := var190
		}
		when (valid(24)) {
			var319 := var318
		}
		when (valid(24)) {
			var359 := var358
		}
	}
	when (counter === 5.U) {
		when (valid(5)) {
			var210 := var381
		}
		when (valid(5)) {
			var246 := var2
		}
		val var429 = var166 + var381
		when (valid(5)) {
			var258 := var429
		}
		val var430 = var217 + var381
		when (valid(5)) {
			var262 := var430
		}
		val var431 = var220 + var381
		when (valid(5)) {
			var265 := var431
		}
		var1 := var164
		when (valid(5)) {
			var0 := 1.U
		}
		when (valid(5)) {
			var172 := var171
		}
		when (valid(5)) {
			var200 := var199
		}
		when (valid(5)) {
			var218 := var217
		}
		when (valid(5)) {
			var221 := var220
		}
		when (valid(5)) {
			var224 := var223
		}
		when (valid(5)) {
			var237 := var236
		}
		when (valid(15)) {
			var330 := var5
		}
		var4 := var305
		when (valid(15)) {
			var3 := 1.U
		}
		val var432 = var233 + var292
		when (valid(15)) {
			var352 := var432
		}
		var403 := var5
		var404 := var255
		when (valid(15)) {
			var182 := var181
		}
		when (valid(15)) {
			var234 := var233
		}
		when (valid(15)) {
			var256 := var255
		}
		when (valid(15)) {
			var275 := var274
		}
		when (valid(15)) {
			var293 := var292
		}
		when (valid(15)) {
			var306 := var305
		}
		when (valid(15)) {
			var310 := var309
		}
		when (valid(15)) {
			var324 := var323
		}
		when (valid(15)) {
			var333 := var332
		}
		when (valid(15)) {
			var339 := var338
		}
		when (valid(25)) {
			var192 := var191
		}
		when (valid(25)) {
			var320 := var319
		}
		when (valid(25)) {
			var360 := var359
		}
	}
	when (counter === 6.U) {
		when (valid(6)) {
			var213 := var393
		}
		val var433 = var166 + var393
		when (valid(6)) {
			var284 := var433
		}
		var400 := var265
		var401 := 16.U
		when (valid(6)) {
			var173 := var172
		}
		when (valid(6)) {
			var201 := var200
		}
		when (valid(6)) {
			var225 := var224
		}
		when (valid(6)) {
			var238 := var237
		}
		when (valid(6)) {
			var247 := var246
		}
		when (valid(6)) {
			var259 := var258
		}
		when (valid(6)) {
			var263 := var262
		}
		when (valid(6)) {
			var266 := var265
		}
		when (valid(16)) {
			var343 := var5
		}
		var4 := var352
		when (valid(16)) {
			var3 := 1.U
		}
		when (valid(16)) {
			var183 := var182
		}
		when (valid(16)) {
			var276 := var275
		}
		when (valid(16)) {
			var311 := var310
		}
		when (valid(16)) {
			var325 := var324
		}
		when (valid(16)) {
			var334 := var333
		}
		when (valid(16)) {
			var340 := var339
		}
		when (valid(16)) {
			var353 := var352
		}
		when (valid(26)) {
			var193 := var192
		}
		when (valid(26)) {
			var321 := var320
		}
		when (valid(26)) {
			var361 := var360
		}
	}
	when (counter === 7.U) {
		when (valid(7)) {
			var267 := var2
		}
		var397 := var263
		var398 := 16.U
		when (valid(7)) {
			var174 := var173
		}
		when (valid(7)) {
			var202 := var201
		}
		when (valid(7)) {
			var226 := var225
		}
		when (valid(7)) {
			var239 := var238
		}
		when (valid(7)) {
			var248 := var247
		}
		when (valid(7)) {
			var260 := var259
		}
		when (valid(7)) {
			var264 := var263
		}
		when (valid(7)) {
			var285 := var284
		}
		when (valid(17)) {
			var348 := var5
		}
		var4 := var334
		when (valid(17)) {
			var3 := 1.U
		}
		when (valid(17)) {
			var184 := var183
		}
		when (valid(17)) {
			var277 := var276
		}
		when (valid(17)) {
			var312 := var311
		}
		when (valid(17)) {
			var326 := var325
		}
		when (valid(17)) {
			var335 := var334
		}
		when (valid(17)) {
			var341 := var340
		}
		when (valid(17)) {
			var344 := var343
		}
		when (valid(27)) {
			var377 := var408
		}
		val var434 = var361 + var408
		when (valid(27)) {
			var378 := var434
		}
		when (valid(27)) {
			var194 := var193
		}
		when (valid(27)) {
			var322 := var321
		}
		when (valid(27)) {
			var362 := var361
		}
	}
	when (counter === 8.U) {
		when (valid(8)) {
			var257 := var387
		}
		var382 := var260
		var383 := 16.U
		val var435 = var166 + var387
		when (valid(8)) {
			var294 := var435
		}
		when (valid(8)) {
			var175 := var174
		}
		when (valid(8)) {
			var203 := var202
		}
		when (valid(8)) {
			var227 := var226
		}
		when (valid(8)) {
			var240 := var239
		}
		when (valid(8)) {
			var249 := var248
		}
		when (valid(8)) {
			var261 := var260
		}
		when (valid(8)) {
			var268 := var267
		}
		when (valid(8)) {
			var286 := var285
		}
		when (valid(18)) {
			var363 := var5
		}
		var4 := var341
		when (valid(18)) {
			var3 := 1.U
		}
		when (valid(18)) {
			var185 := var184
		}
		when (valid(18)) {
			var278 := var277
		}
		when (valid(18)) {
			var313 := var312
		}
		when (valid(18)) {
			var327 := var326
		}
		when (valid(18)) {
			var342 := var341
		}
		when (valid(18)) {
			var345 := var344
		}
		when (valid(18)) {
			var349 := var348
		}
		var7 := var322
		var8 := var378
		when (valid(28)) {
			var6 := 1.U
		}
	}
	when (counter === 9.U) {
		var394 := var286
		var395 := 16.U
		when (valid(9)) {
			var176 := var175
		}
		when (valid(9)) {
			var204 := var203
		}
		when (valid(9)) {
			var228 := var227
		}
		when (valid(9)) {
			var241 := var240
		}
		when (valid(9)) {
			var250 := var249
		}
		when (valid(9)) {
			var269 := var268
		}
		when (valid(9)) {
			var287 := var286
		}
		when (valid(9)) {
			var295 := var294
		}
		when (valid(19)) {
			var354 := var405
		}
		when (valid(19)) {
			var366 := var5
		}
		when (valid(19)) {
			var186 := var185
		}
		when (valid(19)) {
			var279 := var278
		}
		when (valid(19)) {
			var314 := var313
		}
		when (valid(19)) {
			var328 := var327
		}
		when (valid(19)) {
			var346 := var345
		}
		when (valid(19)) {
			var350 := var349
		}
		when (valid(19)) {
			var364 := var363
		}
	}
	when (done) {
		shift_register := 0.U
		counter := 0.U
	}
	val ub_reg = Reg(UInt(32.W))
	when (go) {
		ub_reg := var158
	}
	val step_reg = Reg(UInt(32.W))
	when (go) {
		step_reg := var159
	}
	val upper_bound = Mux(go, var158, ub_reg)
	val step = Mux(go, var159, step_reg)
	new_input := start
	when (start) {
		when (var409 <= upper_bound) {
			when (counter === 9.U) {
				var409 := var409 + step
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
	val var436 = Reg(UInt(1.W))
	val var437 = Reg(UInt(32.W))
	val var438 = Reg(UInt(32.W))
	val var439 = Reg(UInt(32.W))
	val var440 = Reg(UInt(32.W))
	val var441 = Reg(UInt(32.W))
	val var442 = Reg(UInt(1.W))
	val var443 = Reg(UInt(32.W))
	val outline_0_0 = Module(new outline_0)
	outline_0_0.go := 0.U
	val var444 = outline_0_0.var9
	var444 := DontCare
	val var445 = outline_0_0.var10
	var445 := DontCare
	val var446 = outline_0_0.var11
	var446 := DontCare
	val var447 = outline_0_0.var12
	var447 := DontCare
	val var448 = outline_0_0.done
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
	val var449 = outline_1_0.var53
	var449 := DontCare
	val var450 = outline_1_0.var54
	var450 := DontCare
	val var451 = outline_1_0.var55
	var451 := DontCare
	val var452 = outline_1_0.var56
	var452 := DontCare
	val var453 = outline_1_0.done
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
	val var454 = outline_2_0.var106
	var454 := DontCare
	val var455 = outline_2_0.var107
	var455 := DontCare
	val var456 = outline_2_0.var108
	var456 := DontCare
	val var457 = outline_2_0.var109
	var457 := DontCare
	val var458 = outline_2_0.done
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
	val var459 = outline_3_0.var157
	var459 := DontCare
	val var460 = outline_3_0.var158
	var460 := DontCare
	val var461 = outline_3_0.var159
	var461 := DontCare
	val var462 = outline_3_0.var160
	var462 := DontCare
	val var463 = outline_3_0.var161
	var463 := DontCare
	val var464 = outline_3_0.done
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
			val var465 = 0.U <= 31.U
			var436 := var465
			val var466 = !var465
			var437 := 0.U
			state := State.s2;
			when (var466.asBool()) {
				state := State.s4;
			}
		}
		is (State.s1_entry) {
			val var467 = !var436
			state := State.s2;
			when (var467.asBool()) {
				state := State.s4;
			}
		}
		is (State.s2) {
			var444 := 0.U
			var445 := 15.U
			var446 := 1.U
			var447 := var437
			outline_0_0.go := 1.U
			state := State.s2_wait;
			when (var448.asBool()) {
				state := State.s3;
			}
		}
		is (State.s2_wait) {
			when (var448.asBool()) {
				state := State.s3;
			}
		}
		is (State.s3) {
			val var468 = var437 + 1.U
			var437 := var468
			val var469 = var468 <= 31.U
			var436 := var469
			state := State.s1_entry;
		}
		is (State.s4) {
			state := State.s5;
		}
		is (State.s5) {
			val var470 = 1.U <= 30.U
			var436 := var470
			val var471 = !var470
			var437 := 1.U
			state := State.s6;
			when (var471.asBool()) {
				state := State.s10;
			}
		}
		is (State.s5_entry) {
			val var472 = !var436
			state := State.s6;
			when (var472.asBool()) {
				state := State.s10;
			}
		}
		is (State.s6) {
			val var473 = var437 - 1.U
			var438 := var473
			val var474 = var473 + 1.U
			var439 := var474
			state := State.s7;
		}
		is (State.s7) {
			state := State.s8;
		}
		is (State.s8) {
			var449 := 0.U
			var450 := 15.U
			var451 := 1.U
			var452 := var439
			outline_1_0.go := 1.U
			state := State.s8_wait;
			when (var453.asBool()) {
				state := State.s9;
			}
		}
		is (State.s8_wait) {
			when (var453.asBool()) {
				state := State.s9;
			}
		}
		is (State.s9) {
			val var475 = var437 + 1.U
			var437 := var475
			val var476 = var475 <= 30.U
			var436 := var476
			state := State.s5_entry;
		}
		is (State.s10) {
			state := State.s11;
		}
		is (State.s11) {
			val var477 = 1.U <= 30.U
			var436 := var477
			val var478 = !var477
			var437 := 1.U
			state := State.s12;
			when (var478.asBool()) {
				state := State.s16;
			}
		}
		is (State.s11_entry) {
			val var479 = !var436
			state := State.s12;
			when (var479.asBool()) {
				state := State.s16;
			}
		}
		is (State.s12) {
			val var480 = var437 - 1.U
			var440 := var480
			val var481 = var480 + 1.U
			var438 := var481
			state := State.s13;
		}
		is (State.s13) {
			state := State.s14;
		}
		is (State.s14) {
			var454 := 1.U
			var455 := 30.U
			var456 := 1.U
			var457 := var438
			outline_2_0.go := 1.U
			state := State.s14_wait;
			when (var458.asBool()) {
				state := State.s15;
			}
		}
		is (State.s14_wait) {
			when (var458.asBool()) {
				state := State.s15;
			}
		}
		is (State.s15) {
			val var482 = var437 + 1.U
			var437 := var482
			val var483 = var482 <= 30.U
			var436 := var483
			state := State.s11_entry;
		}
		is (State.s16) {
			state := State.s17;
		}
		is (State.s17) {
			val var484 = 1.U <= 30.U
			var436 := var484
			val var485 = !var484
			var437 := 1.U
			state := State.s18;
			when (var485.asBool()) {
				state := State.s26;
			}
		}
		is (State.s17_entry) {
			val var486 = !var436
			state := State.s18;
			when (var486.asBool()) {
				state := State.s26;
			}
		}
		is (State.s18) {
			val var487 = var437 - 1.U
			var441 := var487
			val var488 = var487 + 1.U
			var438 := var488
			state := State.s19;
		}
		is (State.s19) {
			state := State.s20;
		}
		is (State.s20) {
			val var489 = 1.U <= 30.U
			var442 := var489
			val var490 = !var489
			var439 := 1.U
			state := State.s21;
			when (var490.asBool()) {
				state := State.s25;
			}
		}
		is (State.s20_entry) {
			val var491 = !var442
			state := State.s21;
			when (var491.asBool()) {
				state := State.s25;
			}
		}
		is (State.s21) {
			val var492 = var439 - 1.U
			var443 := var492
			val var493 = var492 + 1.U
			var440 := var493
			state := State.s22;
		}
		is (State.s22) {
			state := State.s23;
		}
		is (State.s23) {
			var459 := 1.U
			var460 := 14.U
			var461 := 1.U
			var462 := var438
			var463 := var440
			outline_3_0.go := 1.U
			state := State.s23_wait;
			when (var464.asBool()) {
				state := State.s24;
			}
		}
		is (State.s23_wait) {
			when (var464.asBool()) {
				state := State.s24;
			}
		}
		is (State.s24) {
			val var494 = var439 + 1.U
			var439 := var494
			val var495 = var494 <= 30.U
			var442 := var495
			state := State.s20_entry;
		}
		is (State.s25) {
			val var496 = var437 + 1.U
			var437 := var496
			val var497 = var496 <= 30.U
			var436 := var497
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
    mem_global_0.initMem("data_set/stencil_stencil3d/in_0.txt");
  mem_global_1.initMem("data_set/stencil_stencil3d/in_1.txt");
}

