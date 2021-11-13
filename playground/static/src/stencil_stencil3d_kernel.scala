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
    val var29 = Reg(UInt(64.W))
    val var30 = Reg(UInt(64.W))
    val var31 = Reg(UInt(64.W))
    val var32 = Reg(UInt(64.W))
    val var33 = Reg(UInt(64.W))
    val var34 = Reg(UInt(32.W))
    val var35 = Reg(UInt(64.W))
    val var36 = Reg(UInt(64.W))
    val muli_outline_0_0 = Module(new MulI())
    val var37 = muli_outline_0_0.operand0
    var37 := DontCare
    val var38 = muli_outline_0_0.operand1
    var38 := DontCare
    val var39 = muli_outline_0_0.result
    val muli_outline_0_1 = Module(new MulI())
    val var40 = muli_outline_0_1.operand0
    var40 := DontCare
    val var41 = muli_outline_0_1.operand1
    var41 := DontCare
    val var42 = muli_outline_0_1.result
    val var43 = Reg(UInt(32.W))
    when (go) {
      var43 := var9
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
      } else {
	new_input
      }
    }
    val counter = RegInit(0.U(2.W))
    when (counter === 3.U) {

      when (valid(9)) {
	done := !valid(5)
      }
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
	var17 := var43
      }
      when (valid(4)) {
	var21 := var20
      }
      when (valid(8)) {
	var34 := var5
      }
      var7 := var32
      var8 := var5
      when (valid(8)) {
	var6 := 1.U
      }
      var4 := var35
      when (valid(8)) {
	var3 := 1.U
      }
      when (valid(8)) {
	var25 := var24
      }
      when (valid(8)) {
	var33 := var32
      }
      when (valid(8)) {
	var36 := var35
      }
    }
    when (counter === 1.U) {
      val var44 = var16 + 992.U
      when (valid(1)) {
	var26 := var44
      }
      when (valid(1)) {
	var18 := var17
      }
      when (valid(5)) {
	var22 := var21
      }
      var7 := var36
      var8 := var5
      when (valid(9)) {
	var6 := 1.U
      }
    }
    when (counter === 2.U) {
      var37 := var16
      var38 := 16.U
      when (valid(2)) {
	var19 := var18
      }
      when (valid(2)) {
	var27 := var26
      }
      when (valid(6)) {
	var29 := var39
      }
      val var45 = var22 + var39
      when (valid(6)) {
	var31 := var45
      }
      when (valid(6)) {
	var23 := var22
      }
    }
    when (counter === 3.U) {
      var40 := var27
      var41 := 16.U
      when (valid(3)) {
	var20 := var19
      }
      when (valid(3)) {
	var28 := var27
      }
      when (valid(7)) {
	var30 := var42
      }
      var4 := var31
      when (valid(7)) {
	var3 := 1.U
      }
      val var46 = var23 + var42
      when (valid(7)) {
	var35 := var46
      }
      when (valid(7)) {
	var24 := var23
      }
      when (valid(7)) {
	var32 := var31
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
      when (var43 <= upper_bound) {
	when (counter === 3.U) {
	  var43 := var43 + step
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
    val var47 = IO(Input(UInt(32.W)))
    val var48 = IO(Input(UInt(32.W)))
    val var49 = IO(Input(UInt(32.W)))
    val var50 = IO(Input(UInt(32.W)))
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
    val var68 = Reg(UInt(64.W))
    val var69 = Reg(UInt(64.W))
    val var70 = Reg(UInt(64.W))
    val var71 = Reg(UInt(64.W))
    val var72 = Reg(UInt(64.W))
    val var73 = Reg(UInt(64.W))
    val var74 = Reg(UInt(64.W))
    val var75 = Reg(UInt(64.W))
    val var76 = Reg(UInt(64.W))
    val var77 = Reg(UInt(64.W))
    val var78 = Reg(UInt(32.W))
    val var79 = Reg(UInt(64.W))
    val var80 = Reg(UInt(64.W))
    val muli_outline_1_0 = Module(new MulI())
    val var81 = muli_outline_1_0.operand0
    var81 := DontCare
    val var82 = muli_outline_1_0.operand1
    var82 := DontCare
    val var83 = muli_outline_1_0.result
    val muli_outline_1_1 = Module(new MulI())
    val var84 = muli_outline_1_1.operand0
    var84 := DontCare
    val var85 = muli_outline_1_1.operand1
    var85 := DontCare
    val var86 = muli_outline_1_1.result
    val muli_outline_1_2 = Module(new MulI())
    val var87 = muli_outline_1_2.operand0
    var87 := DontCare
    val var88 = muli_outline_1_2.operand1
    var88 := DontCare
    val var89 = muli_outline_1_2.result
    val var90 = Reg(UInt(32.W))
    when (go) {
      var90 := var47
    }
    when (go) {
      var51 := var47
    }
    when (go) {
      var52 := var48
    }
    when (go) {
      var53 := var49
    }
    when (go) {
      var54 := var50
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
      when (var47 > var48) {
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
      } else {
	new_input
      }
    }
    val counter = RegInit(0.U(2.W))
    when (counter === 3.U) {

      when (valid(13)) {
	done := !valid(9)
      }
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
	var55 := var90
      }
      when (valid(4)) {
	var59 := var58
      }
      when (valid(8)) {
	var63 := var62
      }
      when (valid(12)) {
	var78 := var5
      }
      var7 := var76
      var8 := var5
      when (valid(12)) {
	var6 := 1.U
      }
      var4 := var79
      when (valid(12)) {
	var3 := 1.U
      }
      when (valid(12)) {
	var67 := var66
      }
      when (valid(12)) {
	var77 := var76
      }
      when (valid(12)) {
	var80 := var79
      }
    }
    when (counter === 1.U) {
      var81 := var54
      var82 := 32.U
      when (valid(1)) {
	var56 := var55
      }
      when (valid(5)) {
	var68 := var83
      }
      val var91 = var83 + 31.U
      when (valid(5)) {
	var70 := var91
      }
      when (valid(5)) {
	var60 := var59
      }
      when (valid(9)) {
	var64 := var63
      }
      var7 := var80
      var8 := var5
      when (valid(13)) {
	var6 := 1.U
      }
    }
    when (counter === 2.U) {
      when (valid(2)) {
	var57 := var56
      }
      var84 := var68
      var85 := 16.U
      when (valid(6)) {
	var61 := var60
      }
      when (valid(6)) {
	var69 := var68
      }
      when (valid(6)) {
	var71 := var70
      }
      when (valid(10)) {
	var73 := var86
      }
      val var92 = var64 + var86
      when (valid(10)) {
	var75 := var92
      }
      when (valid(10)) {
	var65 := var64
      }
    }
    when (counter === 3.U) {
      when (valid(3)) {
	var58 := var57
      }
      var87 := var71
      var88 := 16.U
      when (valid(7)) {
	var62 := var61
      }
      when (valid(7)) {
	var72 := var71
      }
      when (valid(11)) {
	var74 := var89
      }
      var4 := var75
      when (valid(11)) {
	var3 := 1.U
      }
      val var93 = var65 + var89
      when (valid(11)) {
	var79 := var93
      }
      when (valid(11)) {
	var66 := var65
      }
      when (valid(11)) {
	var76 := var75
      }
    }
    when (done) {
      shift_register := 0.U
      counter := 0.U
    }
    val ub_reg = Reg(UInt(32.W))
    when (go) {
      ub_reg := var48
    }
    val step_reg = Reg(UInt(32.W))
    when (go) {
      step_reg := var49
    }
    val upper_bound = Mux(go, var48, ub_reg)
    val step = Mux(go, var49, step_reg)
    new_input := start
    when (start) {
      when (var90 <= upper_bound) {
	when (counter === 3.U) {
	  var90 := var90 + step
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
    val var94 = IO(Input(UInt(32.W)))
    val var95 = IO(Input(UInt(32.W)))
    val var96 = IO(Input(UInt(32.W)))
    val var97 = IO(Input(UInt(32.W)))
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
    val var120 = Reg(UInt(64.W))
    val var121 = Reg(UInt(64.W))
    val var122 = Reg(UInt(64.W))
    val var123 = Reg(UInt(64.W))
    val var124 = Reg(UInt(64.W))
    val var125 = Reg(UInt(32.W))
    val var126 = Reg(UInt(64.W))
    val var127 = Reg(UInt(64.W))
    val muli_outline_2_0 = Module(new MulI())
    val var128 = muli_outline_2_0.operand0
    var128 := DontCare
    val var129 = muli_outline_2_0.operand1
    var129 := DontCare
    val var130 = muli_outline_2_0.result
    val muli_outline_2_1 = Module(new MulI())
    val var131 = muli_outline_2_1.operand0
    var131 := DontCare
    val var132 = muli_outline_2_1.operand1
    var132 := DontCare
    val var133 = muli_outline_2_1.result
    val var134 = Reg(UInt(32.W))
    when (go) {
      var134 := var94
    }
    when (go) {
      var98 := var94
    }
    when (go) {
      var99 := var95
    }
    when (go) {
      var100 := var96
    }
    when (go) {
      var101 := var97
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
      when (var94 > var95) {
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
      } else {
	new_input
      }
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

      when (valid(12)) {
	done := !valid(8)
      }
      when (valid(0)) {
	var102 := var134
      }
      when (valid(4)) {
	var106 := var105
      }
      when (valid(4)) {
	var118 := var117
      }
      when (valid(8)) {
	var110 := var109
      }
      var7 := var127
      var8 := var5
      when (valid(12)) {
	var6 := 1.U
      }
    }
    when (counter === 1.U) {
      val var135 = var102 - var100
      when (valid(1)) {
	var114 := var135
      }
      val var136 = var135 + 1.U
      when (valid(1)) {
	var115 := var136
      }
      var128 := var101
      var129 := 32.U
      when (valid(1)) {
	var103 := var102
      }
      when (valid(5)) {
	var120 := var130
      }
      val var137 = var118 + var130
      when (valid(5)) {
	var121 := var137
      }
      when (valid(5)) {
	var107 := var106
      }
      when (valid(5)) {
	var119 := var118
      }
      when (valid(9)) {
	var111 := var110
      }
    }
    when (counter === 2.U) {
      when (valid(2)) {
	var104 := var103
      }
      when (valid(2)) {
	var116 := var115
      }
      var131 := var121
      var132 := 16.U
      when (valid(6)) {
	var108 := var107
      }
      when (valid(6)) {
	var122 := var121
      }
      when (valid(10)) {
	var123 := var133
      }
      var4 := var133
      when (valid(10)) {
	var3 := 1.U
      }
      val var138 = var133 + 15.U
      when (valid(10)) {
	var126 := var138
      }
      when (valid(10)) {
	var112 := var111
      }
    }
    when (counter === 3.U) {
      when (valid(3)) {
	var105 := var104
      }
      when (valid(3)) {
	var117 := var116
      }
      when (valid(7)) {
	var109 := var108
      }
      when (valid(11)) {
	var125 := var5
      }
      var7 := var123
      var8 := var5
      when (valid(11)) {
	var6 := 1.U
      }
      var4 := var126
      when (valid(11)) {
	var3 := 1.U
      }
      when (valid(11)) {
	var113 := var112
      }
      when (valid(11)) {
	var124 := var123
      }
      when (valid(11)) {
	var127 := var126
      }
    }
    when (done) {
      shift_register := 0.U
      counter := 0.U
    }
    val ub_reg = Reg(UInt(32.W))
    when (go) {
      ub_reg := var95
    }
    val step_reg = Reg(UInt(32.W))
    when (go) {
      step_reg := var96
    }
    val upper_bound = Mux(go, var95, ub_reg)
    val step = Mux(go, var96, step_reg)
    new_input := start
    when (start) {
      when (var134 <= upper_bound) {
	when (counter === 3.U) {
	  var134 := var134 + step
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
    val var139 = IO(Input(UInt(32.W)))
    val var140 = IO(Input(UInt(32.W)))
    val var141 = IO(Input(UInt(32.W)))
    val var142 = IO(Input(UInt(32.W)))
    val var143 = IO(Input(UInt(32.W)))
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
    val var191 = Reg(UInt(64.W))
    val var192 = Reg(UInt(32.W))
    val var193 = Reg(UInt(32.W))
    val var194 = Reg(UInt(32.W))
    val var195 = Reg(UInt(32.W))
    val var196 = Reg(UInt(32.W))
    val var197 = Reg(UInt(64.W))
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
    val var241 = Reg(UInt(64.W))
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
    val var257 = Reg(UInt(32.W))
    val var258 = Reg(UInt(32.W))
    val var259 = Reg(UInt(32.W))
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
    val var278 = Reg(UInt(64.W))
    val var279 = Reg(UInt(64.W))
    val var280 = Reg(UInt(64.W))
    val var281 = Reg(UInt(64.W))
    val var282 = Reg(UInt(64.W))
    val var283 = Reg(UInt(64.W))
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
    val var303 = Reg(UInt(32.W))
    val var304 = Reg(UInt(32.W))
    val var305 = Reg(UInt(32.W))
    val var306 = Reg(UInt(32.W))
    val var307 = Reg(UInt(32.W))
    val var308 = Reg(UInt(32.W))
    val var309 = Reg(UInt(32.W))
    val var310 = Reg(UInt(32.W))
    val var311 = Reg(UInt(32.W))
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
    val var324 = Reg(UInt(32.W))
    val var325 = Reg(UInt(32.W))
    val var326 = Reg(UInt(32.W))
    val var327 = Reg(UInt(32.W))
    val var328 = Reg(UInt(32.W))
    val var329 = Reg(UInt(64.W))
    val var330 = Reg(UInt(64.W))
    val var331 = Reg(UInt(64.W))
    val var332 = Reg(UInt(64.W))
    val var333 = Reg(UInt(32.W))
    val var334 = Reg(UInt(32.W))
    val var335 = Reg(UInt(32.W))
    val var336 = Reg(UInt(32.W))
    val var337 = Reg(UInt(32.W))
    val var338 = Reg(UInt(32.W))
    val var339 = Reg(UInt(32.W))
    val var340 = Reg(UInt(32.W))
    val var341 = Reg(UInt(32.W))
    val var342 = Reg(UInt(32.W))
    val var343 = Reg(UInt(32.W))
    val var344 = Reg(UInt(32.W))
    val var345 = Reg(UInt(32.W))
    val var346 = Reg(UInt(32.W))
    val var347 = Reg(UInt(32.W))
    val var348 = Reg(UInt(32.W))
    val var349 = Reg(UInt(32.W))
    val var350 = Reg(UInt(32.W))
    val var351 = Reg(UInt(32.W))
    val var352 = Reg(UInt(32.W))
    val var353 = Reg(UInt(32.W))
    val var354 = Reg(UInt(32.W))
    val var355 = Reg(UInt(32.W))
    val var356 = Reg(UInt(32.W))
    val var357 = Reg(UInt(32.W))
    val var358 = Reg(UInt(32.W))
    val var359 = Reg(UInt(32.W))
    val var360 = Reg(UInt(32.W))
    val muli_outline_3_0 = Module(new MulI())
    val var361 = muli_outline_3_0.operand0
    var361 := DontCare
    val var362 = muli_outline_3_0.operand1
    var362 := DontCare
    val var363 = muli_outline_3_0.result
    val muli_outline_3_1 = Module(new MulI())
    val var364 = muli_outline_3_1.operand0
    var364 := DontCare
    val var365 = muli_outline_3_1.operand1
    var365 := DontCare
    val var366 = muli_outline_3_1.result
    val muli_outline_3_2 = Module(new MulI())
    val var367 = muli_outline_3_2.operand0
    var367 := DontCare
    val var368 = muli_outline_3_2.operand1
    var368 := DontCare
    val var369 = muli_outline_3_2.result
    val muli_outline_3_3 = Module(new MulI())
    val var370 = muli_outline_3_3.operand0
    var370 := DontCare
    val var371 = muli_outline_3_3.operand1
    var371 := DontCare
    val var372 = muli_outline_3_3.result
    val muli_outline_3_4 = Module(new MulI())
    val var373 = muli_outline_3_4.operand0
    var373 := DontCare
    val var374 = muli_outline_3_4.operand1
    var374 := DontCare
    val var375 = muli_outline_3_4.result
    val muli_outline_3_5 = Module(new MulI())
    val var376 = muli_outline_3_5.operand0
    var376 := DontCare
    val var377 = muli_outline_3_5.operand1
    var377 := DontCare
    val var378 = muli_outline_3_5.result
    val muli_outline_3_6 = Module(new MulI())
    val var379 = muli_outline_3_6.operand0
    var379 := DontCare
    val var380 = muli_outline_3_6.operand1
    var380 := DontCare
    val var381 = muli_outline_3_6.result
    val muli_outline_3_7 = Module(new MulI())
    val var382 = muli_outline_3_7.operand0
    var382 := DontCare
    val var383 = muli_outline_3_7.operand1
    var383 := DontCare
    val var384 = muli_outline_3_7.result
    val muli_outline_3_8 = Module(new MulI())
    val var385 = muli_outline_3_8.operand0
    var385 := DontCare
    val var386 = muli_outline_3_8.operand1
    var386 := DontCare
    val var387 = muli_outline_3_8.result
    val muli_outline_3_9 = Module(new MulI())
    val var388 = muli_outline_3_9.operand0
    var388 := DontCare
    val var389 = muli_outline_3_9.operand1
    var389 := DontCare
    val var390 = muli_outline_3_9.result
    val var391 = Reg(UInt(32.W))
    when (go) {
      var391 := var139
    }
    when (go) {
      var144 := var139
    }
    when (go) {
      var145 := var140
    }
    when (go) {
      var146 := var141
    }
    when (go) {
      var147 := var142
    }
    when (go) {
      var148 := var143
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
      when (var139 > var140) {
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
      } else {
	new_input
      }
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
	var149 := var391
      }
      when (valid(10)) {
	var269 := var384
      }
      var370 := var272
      var371 := 16.U
      val var392 = var185 + var384
      when (valid(10)) {
	var285 := var392
      }
      when (valid(10)) {
	var159 := var158
      }
      when (valid(10)) {
	var186 := var185
      }
      when (valid(10)) {
	var211 := var210
      }
      when (valid(10)) {
	var224 := var223
      }
      when (valid(10)) {
	var235 := var234
      }
      when (valid(10)) {
	var247 := var246
      }
      when (valid(10)) {
	var273 := var272
      }
      when (valid(20)) {
	var169 := var168
      }
      when (valid(20)) {
	var257 := var256
      }
      when (valid(20)) {
	var296 := var295
      }
      when (valid(20)) {
	var338 := var337
      }
      when (valid(20)) {
	var356 := var355
      }
    }
    when (counter === 1.U) {
      val var393 = var149 - var146
      when (valid(1)) {
	var176 := var393
      }
      val var394 = var393 + 1.U
      when (valid(1)) {
	var177 := var394
      }
      var361 := var147
      var362 := 32.U
      when (valid(1)) {
	var150 := var149
      }
      when (valid(11)) {
	var274 := var381
      }
      when (valid(11)) {
	var160 := var159
      }
      when (valid(11)) {
	var187 := var186
      }
      when (valid(11)) {
	var212 := var211
      }
      when (valid(11)) {
	var225 := var224
      }
      when (valid(11)) {
	var236 := var235
      }
      when (valid(11)) {
	var248 := var247
      }
      when (valid(11)) {
	var286 := var285
      }
      when (valid(21)) {
	var170 := var169
      }
      when (valid(21)) {
	var258 := var257
      }
      when (valid(21)) {
	var297 := var296
      }
      when (valid(21)) {
	var339 := var338
      }
      when (valid(21)) {
	var357 := var356
      }
    }
    when (counter === 2.U) {
      val var395 = var147 + var146
      when (valid(2)) {
	var192 := var395
      }
      val var396 = var147 - var146
      when (valid(2)) {
	var194 := var396
      }
      when (valid(2)) {
	var151 := var150
      }
      when (valid(2)) {
	var178 := var177
      }
      when (valid(12)) {
	var277 := var366
      }
      val var397 = var187 + var366
      when (valid(12)) {
	var288 := var397
      }
      var4 := var286
      when (valid(12)) {
	var3 := 1.U
      }
      when (valid(12)) {
	var161 := var160
      }
      when (valid(12)) {
	var188 := var187
      }
      when (valid(12)) {
	var213 := var212
      }
      when (valid(12)) {
	var226 := var225
      }
      when (valid(12)) {
	var237 := var236
      }
      when (valid(12)) {
	var249 := var248
      }
      when (valid(12)) {
	var275 := var274
      }
      when (valid(12)) {
	var287 := var286
      }
      var388 := var357
      var389 := var258
      when (valid(22)) {
	var171 := var170
      }
      when (valid(22)) {
	var259 := var258
      }
      when (valid(22)) {
	var298 := var297
      }
      when (valid(22)) {
	var340 := var339
      }
      when (valid(22)) {
	var358 := var357
      }
    }
    when (counter === 3.U) {
      var367 := var192
      var368 := 32.U
      val var398 = var148 + var146
      when (valid(3)) {
	var198 := var398
      }
      val var399 = var148 - var146
      when (valid(3)) {
	var201 := var399
      }
      val var400 = var178 + var146
      when (valid(3)) {
	var204 := var400
      }
      val var401 = var178 - var146
      when (valid(3)) {
	var217 := var401
      }
      var1 := 0.U
      when (valid(3)) {
	var0 := 1.U
      }
      when (valid(3)) {
	var152 := var151
      }
      when (valid(3)) {
	var179 := var178
      }
      when (valid(3)) {
	var193 := var192
      }
      when (valid(3)) {
	var195 := var194
      }
      when (valid(13)) {
	var283 := var378
      }
      when (valid(13)) {
	var303 := var5
      }
      var4 := var288
      when (valid(13)) {
	var3 := 1.U
      }
      val var402 = var188 + var378
      when (valid(13)) {
	var312 := var402
      }
      val var403 = var188 + var275
      when (valid(13)) {
	var314 := var403
      }
      when (valid(13)) {
	var162 := var161
      }
      when (valid(13)) {
	var189 := var188
      }
      when (valid(13)) {
	var214 := var213
      }
      when (valid(13)) {
	var227 := var226
      }
      when (valid(13)) {
	var238 := var237
      }
      when (valid(13)) {
	var250 := var249
      }
      when (valid(13)) {
	var276 := var275
      }
      when (valid(13)) {
	var278 := var277
      }
      when (valid(13)) {
	var289 := var288
      }
      when (valid(23)) {
	var172 := var171
      }
      when (valid(23)) {
	var299 := var298
      }
      when (valid(23)) {
	var341 := var340
      }
    }
    when (counter === 4.U) {
      when (valid(4)) {
	var229 := var2
      }
      var373 := var195
      var374 := 32.U
      var1 := var146
      when (valid(4)) {
	var0 := 1.U
      }
      when (valid(4)) {
	var153 := var152
      }
      when (valid(4)) {
	var180 := var179
      }
      when (valid(4)) {
	var196 := var195
      }
      when (valid(4)) {
	var199 := var198
      }
      when (valid(4)) {
	var202 := var201
      }
      when (valid(4)) {
	var205 := var204
      }
      when (valid(4)) {
	var218 := var217
      }
      when (valid(14)) {
	var284 := var372
      }
      when (valid(14)) {
	var310 := var5
      }
      val var404 = var189 + var372
      when (valid(14)) {
	var319 := var404
      }
      var4 := var312
      when (valid(14)) {
	var3 := 1.U
      }
      val var405 = var227 + var278
      when (valid(14)) {
	var329 := var405
      }
      when (valid(14)) {
	var163 := var162
      }
      when (valid(14)) {
	var190 := var189
      }
      when (valid(14)) {
	var215 := var214
      }
      when (valid(14)) {
	var228 := var227
      }
      when (valid(14)) {
	var239 := var238
      }
      when (valid(14)) {
	var251 := var250
      }
      when (valid(14)) {
	var279 := var278
      }
      when (valid(14)) {
	var290 := var289
      }
      when (valid(14)) {
	var304 := var303
      }
      when (valid(14)) {
	var313 := var312
      }
      when (valid(14)) {
	var315 := var314
      }
      when (valid(24)) {
	var173 := var172
      }
      when (valid(24)) {
	var300 := var299
      }
      when (valid(24)) {
	var342 := var341
      }
    }
    when (counter === 5.U) {
      when (valid(5)) {
	var191 := var363
      }
      when (valid(5)) {
	var242 := var2
      }
      val var406 = var148 + var363
      when (valid(5)) {
	var260 := var406
      }
      val var407 = var199 + var363
      when (valid(5)) {
	var264 := var407
      }
      val var408 = var202 + var363
      when (valid(5)) {
	var267 := var408
      }
      when (valid(5)) {
	var154 := var153
      }
      when (valid(5)) {
	var181 := var180
      }
      when (valid(5)) {
	var200 := var199
      }
      when (valid(5)) {
	var203 := var202
      }
      when (valid(5)) {
	var206 := var205
      }
      when (valid(5)) {
	var219 := var218
      }
      when (valid(5)) {
	var230 := var229
      }
      when (valid(15)) {
	var324 := var5
      }
      val var409 = var215 + var279
      when (valid(15)) {
	var331 := var409
      }
      var4 := var329
      when (valid(15)) {
	var3 := 1.U
      }
      var385 := var310
      var386 := var239
      when (valid(15)) {
	var164 := var163
      }
      when (valid(15)) {
	var216 := var215
      }
      when (valid(15)) {
	var240 := var239
      }
      when (valid(15)) {
	var252 := var251
      }
      when (valid(15)) {
	var280 := var279
      }
      when (valid(15)) {
	var291 := var290
      }
      when (valid(15)) {
	var305 := var304
      }
      when (valid(15)) {
	var311 := var310
      }
      when (valid(15)) {
	var316 := var315
      }
      when (valid(15)) {
	var320 := var319
      }
      when (valid(15)) {
	var330 := var329
      }
      when (valid(25)) {
	var174 := var173
      }
      when (valid(25)) {
	var301 := var300
      }
      when (valid(25)) {
	var343 := var342
      }
    }
    when (counter === 6.U) {
      var382 := var267
      var383 := 16.U
      when (valid(6)) {
	var155 := var154
      }
      when (valid(6)) {
	var182 := var181
      }
      when (valid(6)) {
	var207 := var206
      }
      when (valid(6)) {
	var220 := var219
      }
      when (valid(6)) {
	var231 := var230
      }
      when (valid(6)) {
	var243 := var242
      }
      when (valid(6)) {
	var261 := var260
      }
      when (valid(6)) {
	var265 := var264
      }
      when (valid(6)) {
	var268 := var267
      }
      when (valid(16)) {
	var333 := var5
      }
      var4 := var331
      when (valid(16)) {
	var3 := 1.U
      }
      when (valid(16)) {
	var165 := var164
      }
      when (valid(16)) {
	var253 := var252
      }
      when (valid(16)) {
	var292 := var291
      }
      when (valid(16)) {
	var306 := var305
      }
      when (valid(16)) {
	var317 := var316
      }
      when (valid(16)) {
	var321 := var320
      }
      when (valid(16)) {
	var325 := var324
      }
      when (valid(16)) {
	var332 := var331
      }
      when (valid(26)) {
	var359 := var390
      }
      val var410 = var343 + var390
      when (valid(26)) {
	var360 := var410
      }
      when (valid(26)) {
	var175 := var174
      }
      when (valid(26)) {
	var302 := var301
      }
      when (valid(26)) {
	var344 := var343
      }
    }
    when (counter === 7.U) {

      when (valid(27)) {
	done := !valid(17)
      }
      when (valid(7)) {
	var197 := var369
      }
      val var411 = var148 + var369
      when (valid(7)) {
	var270 := var411
      }
      var379 := var265
      var380 := 16.U
      when (valid(7)) {
	var156 := var155
      }
      when (valid(7)) {
	var183 := var182
      }
      when (valid(7)) {
	var208 := var207
      }
      when (valid(7)) {
	var221 := var220
      }
      when (valid(7)) {
	var232 := var231
      }
      when (valid(7)) {
	var244 := var243
      }
      when (valid(7)) {
	var262 := var261
      }
      when (valid(7)) {
	var266 := var265
      }
      when (valid(17)) {
	var345 := var5
      }
      var4 := var317
      when (valid(17)) {
	var3 := 1.U
      }
      when (valid(17)) {
	var166 := var165
      }
      when (valid(17)) {
	var254 := var253
      }
      when (valid(17)) {
	var293 := var292
      }
      when (valid(17)) {
	var307 := var306
      }
      when (valid(17)) {
	var318 := var317
      }
      when (valid(17)) {
	var322 := var321
      }
      when (valid(17)) {
	var326 := var325
      }
      when (valid(17)) {
	var334 := var333
      }
      var7 := var302
      var8 := var360
      when (valid(27)) {
	var6 := 1.U
      }
    }
    when (counter === 8.U) {
      when (valid(8)) {
	var241 := var375
      }
      var364 := var262
      var365 := 16.U
      val var412 = var148 + var375
      when (valid(8)) {
	var281 := var412
      }
      when (valid(8)) {
	var157 := var156
      }
      when (valid(8)) {
	var184 := var183
      }
      when (valid(8)) {
	var209 := var208
      }
      when (valid(8)) {
	var222 := var221
      }
      when (valid(8)) {
	var233 := var232
      }
      when (valid(8)) {
	var245 := var244
      }
      when (valid(8)) {
	var263 := var262
      }
      when (valid(8)) {
	var271 := var270
      }
      when (valid(18)) {
	var348 := var5
      }
      var4 := var322
      when (valid(18)) {
	var3 := 1.U
      }
      when (valid(18)) {
	var167 := var166
      }
      when (valid(18)) {
	var255 := var254
      }
      when (valid(18)) {
	var294 := var293
      }
      when (valid(18)) {
	var308 := var307
      }
      when (valid(18)) {
	var323 := var322
      }
      when (valid(18)) {
	var327 := var326
      }
      when (valid(18)) {
	var335 := var334
      }
      when (valid(18)) {
	var346 := var345
      }
    }
    when (counter === 9.U) {
      var376 := var281
      var377 := 16.U
      when (valid(9)) {
	var158 := var157
      }
      when (valid(9)) {
	var185 := var184
      }
      when (valid(9)) {
	var210 := var209
      }
      when (valid(9)) {
	var223 := var222
      }
      when (valid(9)) {
	var234 := var233
      }
      when (valid(9)) {
	var246 := var245
      }
      when (valid(9)) {
	var272 := var271
      }
      when (valid(9)) {
	var282 := var281
      }
      when (valid(19)) {
	var337 := var387
      }
      when (valid(19)) {
	var350 := var5
      }
      val var413 = var5 + var327
      when (valid(19)) {
	var351 := var413
      }
      val var414 = var413 + var348
      when (valid(19)) {
	var352 := var414
      }
      val var415 = var414 + var308
      when (valid(19)) {
	var353 := var415
      }
      val var416 = var415 + var346
      when (valid(19)) {
	var354 := var416
      }
      val var417 = var416 + var335
      when (valid(19)) {
	var355 := var417
      }
      when (valid(19)) {
	var168 := var167
      }
      when (valid(19)) {
	var256 := var255
      }
      when (valid(19)) {
	var295 := var294
      }
      when (valid(19)) {
	var309 := var308
      }
      when (valid(19)) {
	var328 := var327
      }
      when (valid(19)) {
	var336 := var335
      }
      when (valid(19)) {
	var347 := var346
      }
      when (valid(19)) {
	var349 := var348
      }
    }
    when (done) {
      shift_register := 0.U
      counter := 0.U
    }
    val ub_reg = Reg(UInt(32.W))
    when (go) {
      ub_reg := var140
    }
    val step_reg = Reg(UInt(32.W))
    when (go) {
      step_reg := var141
    }
    val upper_bound = Mux(go, var140, ub_reg)
    val step = Mux(go, var141, step_reg)
    new_input := start
    when (start) {
      when (var391 <= upper_bound) {
	when (counter === 9.U) {
	  var391 := var391 + step
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
    val var418 = Reg(UInt(1.W))
    val var419 = Reg(UInt(32.W))
    val var420 = Reg(UInt(32.W))
    val var421 = Reg(UInt(32.W))
    val var422 = Reg(UInt(32.W))
    val var423 = Reg(UInt(32.W))
    val var424 = Reg(UInt(1.W))
    val var425 = Reg(UInt(32.W))
    val outline_0_0 = Module(new outline_0)
    outline_0_0.go := 0.U
    val var426 = outline_0_0.var9
    var426 := DontCare
    val var427 = outline_0_0.var10
    var427 := DontCare
    val var428 = outline_0_0.var11
    var428 := DontCare
    val var429 = outline_0_0.var12
    var429 := DontCare
    val var430 = outline_0_0.done
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
    val var431 = outline_1_0.var47
    var431 := DontCare
    val var432 = outline_1_0.var48
    var432 := DontCare
    val var433 = outline_1_0.var49
    var433 := DontCare
    val var434 = outline_1_0.var50
    var434 := DontCare
    val var435 = outline_1_0.done
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
    val var436 = outline_2_0.var94
    var436 := DontCare
    val var437 = outline_2_0.var95
    var437 := DontCare
    val var438 = outline_2_0.var96
    var438 := DontCare
    val var439 = outline_2_0.var97
    var439 := DontCare
    val var440 = outline_2_0.done
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
    val var441 = outline_3_0.var139
    var441 := DontCare
    val var442 = outline_3_0.var140
    var442 := DontCare
    val var443 = outline_3_0.var141
    var443 := DontCare
    val var444 = outline_3_0.var142
    var444 := DontCare
    val var445 = outline_3_0.var143
    var445 := DontCare
    val var446 = outline_3_0.done
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
	val var447 = 0.U <= 31.U
	var418 := var447
	val var448 = !var447
	var419 := 0.U
	state := State.s2;
	when (var448.asBool()) {
	  state := State.s4;
	}
      }
      is (State.s1_entry) {
	val var449 = !var418
	state := State.s2;
	when (var449.asBool()) {
	  state := State.s4;
	}
      }
      is (State.s2) {
	var426 := 0.U
	var427 := 15.U
	var428 := 1.U
	var429 := var419
	outline_0_0.go := 1.U
	state := State.s2_wait;
	when (var430.asBool()) {
	  state := State.s3;
	}
      }
      is (State.s2_wait) {
	when (var430.asBool()) {
	  state := State.s3;
	}
      }
      is (State.s3) {
	val var450 = var419 + 1.U
	var419 := var450
	val var451 = var450 <= 31.U
	var418 := var451
	state := State.s1_entry;
      }
      is (State.s4) {
	state := State.s5;
      }
      is (State.s5) {
	val var452 = 1.U <= 30.U
	var418 := var452
	val var453 = !var452
	var419 := 1.U
	state := State.s6;
	when (var453.asBool()) {
	  state := State.s10;
	}
      }
      is (State.s5_entry) {
	val var454 = !var418
	state := State.s6;
	when (var454.asBool()) {
	  state := State.s10;
	}
      }
      is (State.s6) {
	val var455 = var419 - 1.U
	var420 := var455
	val var456 = var455 + 1.U
	var421 := var456
	state := State.s7;
      }
      is (State.s7) {
	state := State.s8;
      }
      is (State.s8) {
	var431 := 0.U
	var432 := 15.U
	var433 := 1.U
	var434 := var421
	outline_1_0.go := 1.U
	state := State.s8_wait;
	when (var435.asBool()) {
	  state := State.s9;
	}
      }
      is (State.s8_wait) {
	when (var435.asBool()) {
	  state := State.s9;
	}
      }
      is (State.s9) {
	val var457 = var419 + 1.U
	var419 := var457
	val var458 = var457 <= 30.U
	var418 := var458
	state := State.s5_entry;
      }
      is (State.s10) {
	state := State.s11;
      }
      is (State.s11) {
	val var459 = 1.U <= 30.U
	var418 := var459
	val var460 = !var459
	var419 := 1.U
	state := State.s12;
	when (var460.asBool()) {
	  state := State.s16;
	}
      }
      is (State.s11_entry) {
	val var461 = !var418
	state := State.s12;
	when (var461.asBool()) {
	  state := State.s16;
	}
      }
      is (State.s12) {
	val var462 = var419 - 1.U
	var422 := var462
	val var463 = var462 + 1.U
	var420 := var463
	state := State.s13;
      }
      is (State.s13) {
	state := State.s14;
      }
      is (State.s14) {
	var436 := 1.U
	var437 := 30.U
	var438 := 1.U
	var439 := var420
	outline_2_0.go := 1.U
	state := State.s14_wait;
	when (var440.asBool()) {
	  state := State.s15;
	}
      }
      is (State.s14_wait) {
	when (var440.asBool()) {
	  state := State.s15;
	}
      }
      is (State.s15) {
	val var464 = var419 + 1.U
	var419 := var464
	val var465 = var464 <= 30.U
	var418 := var465
	state := State.s11_entry;
      }
      is (State.s16) {
	state := State.s17;
      }
      is (State.s17) {
	val var466 = 1.U <= 30.U
	var418 := var466
	val var467 = !var466
	var419 := 1.U
	state := State.s18;
	when (var467.asBool()) {
	  state := State.s26;
	}
      }
      is (State.s17_entry) {
	val var468 = !var418
	state := State.s18;
	when (var468.asBool()) {
	  state := State.s26;
	}
      }
      is (State.s18) {
	val var469 = var419 - 1.U
	var423 := var469
	val var470 = var469 + 1.U
	var420 := var470
	state := State.s19;
      }
      is (State.s19) {
	state := State.s20;
      }
      is (State.s20) {
	val var471 = 1.U <= 30.U
	var424 := var471
	val var472 = !var471
	var421 := 1.U
	state := State.s21;
	when (var472.asBool()) {
	  state := State.s25;
	}
      }
      is (State.s20_entry) {
	val var473 = !var424
	state := State.s21;
	when (var473.asBool()) {
	  state := State.s25;
	}
      }
      is (State.s21) {
	val var474 = var421 - 1.U
	var425 := var474
	val var475 = var474 + 1.U
	var422 := var475
	state := State.s22;
      }
      is (State.s22) {
	state := State.s23;
      }
      is (State.s23) {
	var441 := 1.U
	var442 := 14.U
	var443 := 1.U
	var444 := var420
	var445 := var422
	outline_3_0.go := 1.U
	state := State.s23_wait;
	when (var446.asBool()) {
	  state := State.s24;
	}
      }
      is (State.s23_wait) {
	when (var446.asBool()) {
	  state := State.s24;
	}
      }
      is (State.s24) {
	val var476 = var421 + 1.U
	var421 := var476
	val var477 = var476 <= 30.U
	var424 := var477
	state := State.s20_entry;
      }
      is (State.s25) {
	val var478 = var419 + 1.U
	var419 := var478
	val var479 = var478 <= 30.U
	var418 := var479
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

