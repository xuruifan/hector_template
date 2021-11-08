import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class bbgemm extends MultiIOModule {
  val mem_global_0 = Module(new ReadMem(4096, 64))
  val var0 = mem_global_0.r_en
  val var1 = mem_global_0.addr
  val var2 = mem_global_0.r_data
  val mem_global_1 = Module(new ReadMem(4096, 64))
  val var3 = mem_global_1.r_en
  val var4 = mem_global_1.addr
  val var5 = mem_global_1.r_data
  val mem_global_2 = Module(new ReadWriteMem(4096, 64))
  val var6 = mem_global_2.w_en
  val var7 = mem_global_2.r_en
  val var8 = mem_global_2.addr
  val var9 = mem_global_2.w_data
  val var10 = mem_global_2.r_data
  class outline_0 extends MultiIOModule {
    val go = IO(Input(Bool()))
    val start = RegInit(false.B)
    val new_input = Wire(Bool())
    new_input := false.B
    val done = IO(Output(Bool()))
    done := 0.U
    val var11 = IO(Input(UInt(32.W)))
    val var12 = IO(Input(UInt(32.W)))
    val var13 = IO(Input(UInt(32.W)))
    val var14 = IO(Input(UInt(64.W)))
    val var15 = IO(Input(UInt(64.W)))
    val var16 = IO(Input(UInt(32.W)))
    val var17 = IO(Input(UInt(64.W)))
    val var18 = Reg(UInt(32.W))
    val var19 = Reg(UInt(32.W))
    val var20 = Reg(UInt(32.W))
    val var21 = Reg(UInt(64.W))
    val var22 = Reg(UInt(64.W))
    val var23 = Reg(UInt(32.W))
    val var24 = Reg(UInt(64.W))
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
    val var45 = Reg(UInt(64.W))
    val var46 = Reg(UInt(64.W))
    val var47 = Reg(UInt(64.W))
    val var48 = Reg(UInt(64.W))
    val var49 = Reg(UInt(64.W))
    val var50 = Reg(UInt(64.W))
    val var51 = Reg(UInt(64.W))
    val var52 = Reg(UInt(64.W))
    val var53 = Reg(UInt(64.W))
    val var54 = Reg(UInt(64.W))
    val var55 = Reg(UInt(64.W))
    val var56 = Reg(UInt(64.W))
    val var57 = Reg(UInt(64.W))
    val var58 = Reg(UInt(64.W))
    val var59 = Reg(UInt(64.W))
    val var60 = Reg(UInt(64.W))
    val var61 = Reg(UInt(64.W))
    val var62 = Reg(UInt(64.W))
    val var63 = Reg(UInt(64.W))
    val var64 = Reg(UInt(64.W))
    val var65 = Reg(UInt(64.W))
    val var66 = Reg(UInt(64.W))
    val var67 = Reg(UInt(64.W))
    val var68 = Reg(UInt(64.W))
    val var69 = Reg(UInt(64.W))
    val var70 = Reg(UInt(64.W))
    val mulf_outline_0_0 = Module(new MulFBase(6, 11, 53))
    mulf_outline_0_0.ce := true.B
    val var71 = mulf_outline_0_0.operand0
    var71 := DontCare
    val var72 = mulf_outline_0_0.operand1
    var72 := DontCare
    val var73 = mulf_outline_0_0.result
    val addf_outline_0_0 = Module(new AddSubFBase(10, 11, 53, true))
    addf_outline_0_0.ce := true.B
    val var74 = addf_outline_0_0.operand0
    var74 := DontCare
    val var75 = addf_outline_0_0.operand1
    var75 := DontCare
    val var76 = addf_outline_0_0.result
    val var77 = Reg(UInt(32.W))
    when (go) {
      var77 := var11
    }
    when (go) {
      var18 := var11
    }
    when (go) {
      var19 := var12
    }
    when (go) {
      var20 := var13
    }
    when (go) {
      var21 := var14
    }
    when (go) {
      var22 := var15
    }
    when (go) {
      var23 := var16
    }
    when (go) {
      var24 := var17
    }
    val var3 = IO(Output(UInt(1.W)))
    var3 := false.B
    val var4 = IO(Output(UInt(12.W)))
    var4 := DontCare
    val var6 = IO(Output(UInt(1.W)))
    var6 := false.B
    val var7 = IO(Output(UInt(1.W)))
    var7 := false.B
    val var8 = IO(Output(UInt(12.W)))
    var8 := DontCare
    val var9 = IO(Output(UInt(64.W)))
    var9 := DontCare
    val var5 = IO(Input(UInt(64.W)))
    val var10 = IO(Input(UInt(64.W)))
    val shift_register = RegInit(0.U(2.W))
    when (go) {
      when (var11 > var12) {
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
      } else {
	new_input
      }
    }
    val counter = RegInit(0.U(4.W))
    when (counter === 13.U) {
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
	var25 := var77
      }
      when (valid(14)) {
	var39 := var38
      }
      when (valid(14)) {
	var62 := var61
      }
    }
    when (counter === 1.U) {
      val var78 = var21 + var25
      when (valid(1)) {
	var45 := var78
      }
      val var79 = var78 + var23
      when (valid(1)) {
	var46 := var79
      }
      val var80 = var22 + var25
      when (valid(1)) {
	var48 := var80
      }
      val var81 = var80 + var23
      when (valid(1)) {
	var49 := var81
      }
      when (valid(1)) {
	var26 := var25
      }
      when (valid(15)) {
	var40 := var39
      }
      when (valid(15)) {
	var63 := var62
      }
    }
    when (counter === 2.U) {
      var4 := var46
      var3 := 1.U
      when (valid(2)) {
	var27 := var26
      }
      when (valid(2)) {
	var47 := var46
      }
      when (valid(2)) {
	var50 := var49
      }
      when (valid(16)) {
	var41 := var40
      }
      when (valid(16)) {
	var64 := var63
      }
    }
    when (counter === 3.U) {
      when (valid(3)) {
	var28 := var27
      }
      when (valid(3)) {
	var51 := var50
      }
      when (valid(17)) {
	var42 := var41
      }
      when (valid(17)) {
	var65 := var64
      }
    }
    when (counter === 4.U) {
      when (valid(4)) {
	var68 := var5
      }
      var71 := var17
      var72 := var5
      when (valid(4)) {
	var29 := var28
      }
      when (valid(4)) {
	var52 := var51
      }
      when (valid(18)) {
	var43 := var42
      }
      when (valid(18)) {
	var66 := var65
      }
    }
    when (counter === 5.U) {
      when (valid(5)) {
	var30 := var29
      }
      when (valid(5)) {
	var53 := var52
      }
      when (valid(19)) {
	var44 := var43
      }
      when (valid(19)) {
	var67 := var66
      }
    }
    when (counter === 6.U) {
      when (valid(6)) {
	var31 := var30
      }
      when (valid(6)) {
	var54 := var53
      }
      var8 := var67
      var9 := var76
      var6 := 1.U
    }
    when (counter === 7.U) {
      when (valid(7)) {
	var32 := var31
      }
      when (valid(7)) {
	var55 := var54
      }
    }
    when (counter === 8.U) {
      var8 := var55
      var7 := 1.U
      when (valid(8)) {
	var33 := var32
      }
      when (valid(8)) {
	var56 := var55
      }
    }
    when (counter === 9.U) {
      when (valid(9)) {
	var34 := var33
      }
      when (valid(9)) {
	var57 := var56
      }
    }
    when (counter === 10.U) {
      when (valid(10)) {
	var69 := var73
      }
      when (valid(10)) {
	var70 := var10
      }
      var74 := var10
      var75 := var73
      when (valid(10)) {
	var35 := var34
      }
      when (valid(10)) {
	var58 := var57
      }
    }
    when (counter === 11.U) {
      when (valid(11)) {
	var36 := var35
      }
      when (valid(11)) {
	var59 := var58
      }
    }
    when (counter === 12.U) {
      when (valid(12)) {
	var37 := var36
      }
      when (valid(12)) {
	var60 := var59
      }
    }
    when (counter === 13.U) {
      when (valid(13)) {
	var38 := var37
      }
      when (valid(13)) {
	var61 := var60
      }
    }
    when (done) {
      shift_register := 0.U
      counter := 0.U
    }
    val ub_reg = Reg(UInt(32.W))
    when (go) {
      ub_reg := var12
    }
    val step_reg = Reg(UInt(32.W))
    when (go) {
      step_reg := var13
    }
    val upper_bound = Mux(go, var12, ub_reg)
    val step = Mux(go, var13, step_reg)
    new_input := start
    when (start) {
      when (var77 <= upper_bound) {
	when (counter === 13.U) {
	  var77 := var77 + step
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
    val muli_main_0 = Module(new MulI())
    val var82 = muli_main_0.operand0
    var82 := DontCare
    val var83 = muli_main_0.operand1
    var83 := DontCare
    val var84 = muli_main_0.result
    val muli_main_1 = Module(new MulI())
    val var85 = muli_main_1.operand0
    var85 := DontCare
    val var86 = muli_main_1.operand1
    var86 := DontCare
    val var87 = muli_main_1.result
    val var88 = Reg(UInt(1.W))
    val var89 = Reg(UInt(32.W))
    val var90 = Reg(UInt(1.W))
    val var91 = Reg(UInt(32.W))
    val var92 = Reg(UInt(1.W))
    val var93 = Reg(UInt(32.W))
    val var94 = Reg(UInt(1.W))
    val var95 = Reg(UInt(32.W))
    val var96 = Reg(UInt(64.W))
    val var97 = Reg(UInt(32.W))
    val var98 = Reg(UInt(64.W))
    val var99 = Reg(UInt(64.W))
    val var100 = Reg(UInt(64.W))
    val var101 = Reg(UInt(64.W))
    val outline_0_0 = Module(new outline_0)
    outline_0_0.go := 0.U
    val var102 = outline_0_0.var11
    var102 := DontCare
    val var103 = outline_0_0.var12
    var103 := DontCare
    val var104 = outline_0_0.var13
    var104 := DontCare
    val var105 = outline_0_0.var14
    var105 := DontCare
    val var106 = outline_0_0.var15
    var106 := DontCare
    val var107 = outline_0_0.var16
    var107 := DontCare
    val var108 = outline_0_0.var17
    var108 := DontCare
    val var109 = outline_0_0.done
    val var3 = IO(Output(UInt(1.W)))
    var3 := outline_0_0.var3
    val var4 = IO(Output(UInt(12.W)))
    var4 := outline_0_0.var4
    val var6 = IO(Output(UInt(1.W)))
    var6 := outline_0_0.var6
    val var7 = IO(Output(UInt(1.W)))
    var7 := outline_0_0.var7
    val var8 = IO(Output(UInt(12.W)))
    var8 := outline_0_0.var8
    val var9 = IO(Output(UInt(64.W)))
    var9 := outline_0_0.var9
    val var5 = IO(Input(UInt(64.W)))
    outline_0_0.var5 := var5
    val var10 = IO(Input(UInt(64.W)))
    outline_0_0.var10 := var10
    val var0 = IO(Output(UInt(1.W)))
    var0 := false.B
    val var1 = IO(Output(UInt(12.W)))
    var1 := DontCare
    val var2 = IO(Input(UInt(64.W)))
    object State extends ChiselEnum {
      val s0, s1, s1_entry, s2, s2_entry, s3, s3_entry, s4, s4_entry, s5, s6, s6_0, s6_1, s7, s8, s9, s10, s10_wait, s11, s12, s13, s14, s15 = Value
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
	val var110 = var89 <= 64.U
	var88 := var110
	val var111 = !var110
	var89 := 0.U
	state := State.s2;
	when (var111.asBool()) {
	  state := State.s15;
	}
      }
      is (State.s1_entry) {
	val var112 = !var88
	state := State.s2;
	when (var112.asBool()) {
	  state := State.s15;
	}
      }
      is (State.s2) {
	val var113 = var91 <= 64.U
	var90 := var113
	val var114 = !var113
	var91 := 0.U
	state := State.s3;
	when (var114.asBool()) {
	  state := State.s14;
	}
      }
      is (State.s2_entry) {
	val var115 = !var90
	state := State.s3;
	when (var115.asBool()) {
	  state := State.s14;
	}
      }
      is (State.s3) {
	val var116 = var93 <= 64.U
	var92 := var116
	val var117 = !var116
	var93 := 0.U
	state := State.s4;
	when (var117.asBool()) {
	  state := State.s13;
	}
      }
      is (State.s3_entry) {
	val var118 = !var92
	state := State.s4;
	when (var118.asBool()) {
	  state := State.s13;
	}
      }
      is (State.s4) {
	val var119 = var95 <= 8.U
	var94 := var119
	val var120 = !var119
	var95 := 0.U
	state := State.s5;
	when (var120.asBool()) {
	  state := State.s12;
	}
      }
      is (State.s4_entry) {
	val var121 = !var94
	state := State.s5;
	when (var121.asBool()) {
	  state := State.s12;
	}
      }
      is (State.s5) {
	var82 := var93
	var83 := 64.U
	val var122 = var95 + var91
	var97 := var122
	state := State.s6;
      }
      is (State.s6) {
	var85 := var97
	var86 := 64.U
	state := State.s6_0;
      }
      is (State.s6_0) {
	state := State.s6_1;
      }
      is (State.s6_1) {
	var96 := var84
	state := State.s7;
      }
      is (State.s7) {
	var98 := var87
	val var123 = var96 + var95
	var99 := var123
	val var124 = var123 + var91
	var100 := var124
	var1 := var124
	var0 := true.B
	state := State.s8;
      }
      is (State.s8) {
	var101 := var2
	state := State.s9;
      }
      is (State.s9) {
	state := State.s10;
      }
      is (State.s10) {
	var102 := 0.U
	var103 := 8.U
	var104 := 1.U
	var105 := var98
	var106 := var96
	var107 := var89
	var108 := var101
	outline_0_0.go := 1.U
	state := State.s10_wait;
	when (var109.asBool()) {
	  state := State.s11;
	}
      }
      is (State.s10_wait) {
	when (var109.asBool()) {
	  state := State.s11;
	}
      }
      is (State.s11) {
	val var125 = var95 + 1.U
	var95 := var125
	val var126 = var125 <= 8.U
	var94 := var126
	state := State.s4_entry;
      }
      is (State.s12) {
	val var127 = var93 + 1.U
	var93 := var127
	val var128 = var127 <= 64.U
	var92 := var128
	state := State.s3_entry;
      }
      is (State.s13) {
	val var129 = var91 + 8.U
	var91 := var129
	val var130 = var129 <= 64.U
	var90 := var130
	state := State.s2_entry;
      }
      is (State.s14) {
	val var131 = var89 + 8.U
	var89 := var131
	val var132 = var131 <= 64.U
	var88 := var132
	state := State.s1_entry;
      }
      is (State.s15) {
	done := 1.U
      }
    }
  }
  val main = Module(new main)
  mem_global_1.dataIn(0).valid := main.var3
  mem_global_1.dataIn(0).bits := main.var4
  mem_global_2.writeIn(0).valid := main.var6
  mem_global_2.readIn(0).valid := main.var7
  mem_global_2.writeIn(0).bits := main.var8
  mem_global_2.w_dataIn(0).bits := main.var9
  mem_global_0.dataIn(0).valid := main.var0
  mem_global_0.dataIn(0).bits := main.var1
  val go = IO(Input(Bool()))
  main.go := go
  val done = IO(Output(Bool()))
  done := main.done
  main.var5 := var5
  main.var10 := var10
  main.var2 := var2
}

