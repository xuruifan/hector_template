import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class stencil extends MultiIOModule {
  val mem_global_0 = Module(new ReadMem(8192, 32))
  val var0 = mem_global_0.r_en
  val var1 = mem_global_0.addr
  val var2 = mem_global_0.r_data
  val mem_global_1 = Module(new WriteMem(8192, 32))
  val var3 = mem_global_1.w_en
  val var4 = mem_global_1.addr
  val var5 = mem_global_1.w_data
  val mem_global_2 = Module(new ReadMem(9, 32))
  val var6 = mem_global_2.r_en
  val var7 = mem_global_2.addr
  val var8 = mem_global_2.r_data
  mem_global_0.initMem("data_set/stencil_stencil2d/in_0.txt");
  mem_global_2.initMem("data_set/stencil_stencil2d/in_1.txt");
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
    val var13 = IO(Input(UInt(32.W)))
    val var14 = IO(Input(UInt(32.W)))
    val var15 = IO(Input(UInt(32.W)))
    val var16 = IO(Output(UInt(32.W)))
    var16 := DontCare
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
    val var50 = Reg(UInt(64.W))
    val var51 = Reg(UInt(32.W))
    val var52 = Reg(UInt(32.W))
    val var53 = Reg(UInt(64.W))
    val var54 = Reg(UInt(64.W))
    val var55 = Reg(UInt(64.W))
    val var56 = Reg(UInt(32.W))
    val var57 = Reg(UInt(32.W))
    val var58 = Reg(UInt(64.W))
    val var59 = Reg(UInt(64.W))
    val var60 = Reg(UInt(64.W))
    val var61 = Reg(UInt(32.W))
    val muli_outline_0_0 = Module(new MulI())
    val var62 = muli_outline_0_0.operand0
    var62 := DontCare
    val var63 = muli_outline_0_0.operand1
    var63 := DontCare
    val var64 = muli_outline_0_0.result
    val muli_outline_0_1 = Module(new MulI())
    val var65 = muli_outline_0_1.operand0
    var65 := DontCare
    val var66 = muli_outline_0_1.operand1
    var66 := DontCare
    val var67 = muli_outline_0_1.result
    val muli_outline_0_2 = Module(new MulI())
    val var68 = muli_outline_0_2.operand0
    var68 := DontCare
    val var69 = muli_outline_0_2.operand1
    var69 := DontCare
    val var70 = muli_outline_0_2.result
    val var71 = Reg(UInt(32.W))
    when (go) {
      var71 := var9
    }
    when (go) {
      var17 := var9
    }
    when (go) {
      var18 := var10
    }
    when (go) {
      var19 := var11
    }
    when (go) {
      var20 := var12
    }
    when (go) {
      var21 := var13
    }
    when (go) {
      var22 := var14
    }
    when (go) {
      var23 := var15
    }
    when (go) {
      var37 := var15
    }
    val var0 = IO(Output(UInt(1.W)))
    var0 := false.B
    val var1 = IO(Output(UInt(13.W)))
    var1 := DontCare
    val var6 = IO(Output(UInt(1.W)))
    var6 := false.B
    val var7 = IO(Output(UInt(4.W)))
    var7 := DontCare
    val var2 = IO(Input(UInt(32.W)))
    val var8 = IO(Input(UInt(32.W)))
    val shift_register = RegInit(0.U(5.W))
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
	shift_register(1)
      } else if (stage == 5) {
	shift_register(1)
      } else if (stage == 6) {
	shift_register(1)
      } else if (stage == 7) {
	shift_register(2)
      } else if (stage == 8) {
	shift_register(2)
      } else if (stage == 9) {
	shift_register(2)
      } else if (stage == 10) {
	shift_register(3)
      } else if (stage == 11) {
	shift_register(3)
      } else if (stage == 12) {
	shift_register(3)
      } else if (stage == 13) {
	shift_register(4)
      } else {
	new_input
      }
    }
    val counter = RegInit(0.U(2.W))
    when (counter === 2.U) {
      counter := 0.U
    }.otherwise {
      when (start || shift_register =/= 0.U) {
	counter := counter + 1.U
      }
    }
    when (counter === 0.U) {
      shift_register := Cat(shift_register(3, 0), new_input)
    }
    when (counter === 0.U) {
      when (valid(0)) {
	var24 := var71
      }
      when (valid(3)) {
	var27 := var26
      }
      when (valid(3)) {
	var40 := var39
      }
      when (valid(6)) {
	var53 := var67
      }
      var7 := var54
      var6 := 1.U
      val var72 = var67 + var13
      when (valid(6)) {
	var58 := var72
      }
      val var73 = var72 + var29
      when (valid(6)) {
	var59 := var73
      }
      when (valid(6)) {
	var30 := var29
      }
      when (valid(6)) {
	var43 := var42
      }
      when (valid(6)) {
	var55 := var54
      }
      when (valid(9)) {
	var61 := var2
      }
      var68 := var56
      var69 := var2
      when (valid(9)) {
	var33 := var32
      }
      when (valid(9)) {
	var46 := var45
      }
      when (valid(9)) {
	var57 := var56
      }
      when (valid(12)) {
	var36 := var35
      }
      when (valid(12)) {
	var49 := var48
      }
    }
    when (counter === 1.U) {
      var62 := var22
      var63 := 3.U
      val var74 = var20 + var22
      when (valid(1)) {
	var51 := var74
      }
      when (valid(1)) {
	var25 := var24
      }
      when (valid(1)) {
	var38 := var37
      }
      when (valid(4)) {
	var28 := var27
      }
      when (valid(4)) {
	var41 := var40
      }
      var1 := var59
      var0 := 1.U
      when (valid(7)) {
	var31 := var30
      }
      when (valid(7)) {
	var44 := var43
      }
      when (valid(7)) {
	var60 := var59
      }
      when (valid(10)) {
	var34 := var33
      }
      when (valid(10)) {
	var47 := var46
      }
      val var75 = var49 + var70
      when (valid(13)) {
	var47 := var75
	var16 := var75
	when (!valid(10)) {
	  done := true.B
	}
      }
    }
    when (counter === 2.U) {
      var65 := var51
      var66 := 64.U
      when (valid(2)) {
	var26 := var25
      }
      when (valid(2)) {
	var39 := var38
      }
      when (valid(2)) {
	var52 := var51
      }
      when (valid(5)) {
	var50 := var64
      }
      val var76 = var64 + var28
      when (valid(5)) {
	var54 := var76
      }
      when (valid(5)) {
	var29 := var28
      }
      when (valid(5)) {
	var42 := var41
      }
      when (valid(8)) {
	var56 := var8
      }
      when (valid(8)) {
	var32 := var31
      }
      when (valid(8)) {
	var45 := var44
      }
      when (valid(11)) {
	var35 := var34
      }
      when (valid(11)) {
	var48 := var47
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
      when (var71 <= upper_bound) {
	when (counter === 2.U) {
	  var71 := var71 + step
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
    val var77 = muli_main_0.operand0
    var77 := DontCare
    val var78 = muli_main_0.operand1
    var78 := DontCare
    val var79 = muli_main_0.result
    val var80 = Reg(UInt(1.W))
    val var81 = Reg(UInt(32.W))
    val var82 = Reg(UInt(1.W))
    val var83 = Reg(UInt(32.W))
    val var84 = Reg(UInt(1.W))
    val var85 = Reg(UInt(32.W))
    val var86 = Reg(UInt(32.W))
    val var87 = Reg(UInt(32.W))
    val var88 = Reg(UInt(64.W))
    val var89 = Reg(UInt(64.W))
    val outline_0_0 = Module(new outline_0)
    outline_0_0.go := 0.U
    val var90 = outline_0_0.var9
    var90 := DontCare
    val var91 = outline_0_0.var10
    var91 := DontCare
    val var92 = outline_0_0.var11
    var92 := DontCare
    val var93 = outline_0_0.var12
    var93 := DontCare
    val var94 = outline_0_0.var13
    var94 := DontCare
    val var95 = outline_0_0.var14
    var95 := DontCare
    val var96 = outline_0_0.var15
    var96 := DontCare
    val var97 = outline_0_0.var16
    val var98 = outline_0_0.done
    val var0 = IO(Output(UInt(1.W)))
    var0 := outline_0_0.var0
    val var1 = IO(Output(UInt(13.W)))
    var1 := outline_0_0.var1
    val var6 = IO(Output(UInt(1.W)))
    var6 := outline_0_0.var6
    val var7 = IO(Output(UInt(4.W)))
    var7 := outline_0_0.var7
    val var2 = IO(Input(UInt(32.W)))
    outline_0_0.var2 := var2
    val var8 = IO(Input(UInt(32.W)))
    outline_0_0.var8 := var8
    val var3 = IO(Output(UInt(1.W)))
    var3 := false.B
    val var4 = IO(Output(UInt(13.W)))
    var4 := DontCare
    val var5 = IO(Output(UInt(32.W)))
    var5 := DontCare
    object State extends ChiselEnum {
      val s0, s1, s1_entry, s2, s2_entry, s3, s3_entry, s4, s4_wait, s5, s6, s7, s7_0, s7_1, s7_2, s8, s9, s10, s11, s12 = Value
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
	val var99 = 0.U <= 125.U
	var80 := var99
	val var100 = !var99
	var81 := 0.U
	state := State.s2;
	when (var100.asBool()) {
	  state := State.s12;
	}
      }
      is (State.s1_entry) {
	val var101 = !var80
	state := State.s2;
	when (var101.asBool()) {
	  state := State.s12;
	}
      }
      is (State.s2) {
	val var102 = 0.U <= 61.U
	var82 := var102
	val var103 = !var102
	var83 := 0.U
	state := State.s3;
	when (var103.asBool()) {
	  state := State.s11;
	}
      }
      is (State.s2_entry) {
	val var104 = !var82
	state := State.s3;
	when (var104.asBool()) {
	  state := State.s11;
	}
      }
      is (State.s3) {
	val var105 = 0.U <= 2.U
	var84 := var105
	val var106 = !var105
	var85 := 0.U
	var86 := 0.U
	when (var106.asBool()) {
	  var87 := 0.U
	}
	state := State.s4;
	when (var106.asBool()) {
	  state := State.s6;
	}
      }
      is (State.s3_entry) {
	val var107 = !var84
	when (var107.asBool()) {
	  var87 := var86
	}
	state := State.s4;
	when (var107.asBool()) {
	  state := State.s6;
	}
      }
      is (State.s4) {
	var90 := 0.U
	var91 := 2.U
	var92 := 1.U
	var93 := var81
	var94 := var83
	var95 := var85
	var96 := var86
	outline_0_0.go := 1.U
	when (var98.asBool()) {
	  var86 := var97
	}
	state := State.s4_wait;
	when (var98.asBool()) {
	  state := State.s5;
	}
      }
      is (State.s4_wait) {
	when (var98.asBool()) {
	  var86 := var97
	}
	when (var98.asBool()) {
	  state := State.s5;
	}
      }
      is (State.s5) {
	var86 := var86
	val var108 = var85 + 1.U
	var85 := var108
	val var109 = var108 <= 2.U
	var84 := var109
	state := State.s3_entry;
      }
      is (State.s6) {
	state := State.s7;
      }
      is (State.s7) {
	var77 := var81
	var78 := 64.U
	state := State.s7_0;
      }
      is (State.s7_0) {
	state := State.s7_1;
      }
      is (State.s7_1) {
	state := State.s7_2;
      }
      is (State.s7_2) {
	var88 := var79
	state := State.s8;
      }
      is (State.s8) {
	val var110 = var88 + var83
	var89 := var110
	var4 := var110
	var5 := var87
	var3 := true.B
	state := State.s9;
      }
      is (State.s9) {
	state := State.s10;
      }
      is (State.s10) {
	val var111 = var83 + 1.U
	var83 := var111
	val var112 = var111 <= 61.U
	var82 := var112
	state := State.s2_entry;
      }
      is (State.s11) {
	val var113 = var81 + 1.U
	var81 := var113
	val var114 = var113 <= 125.U
	var80 := var114
	state := State.s1_entry;
      }
      is (State.s12) {
	done := 1.U
      }
    }
  }
  val main = Module(new main)
  mem_global_0.dataIn(0).valid := main.var0
  mem_global_0.dataIn(0).bits := main.var1
  mem_global_2.dataIn(0).valid := main.var6
  mem_global_2.dataIn(0).bits := main.var7
  mem_global_1.dataIn(0).valid := main.var3
  mem_global_1.dataIn(0).bits := main.var4
  mem_global_1.w_dataIn(0).bits := main.var5
  val go = IO(Input(Bool()))
  main.go := go
  val done = IO(Output(Bool()))
  done := main.done
  main.var2 := var2
  main.var8 := var8
  val mem_global_1_test_addr = IO(Input(UInt(log2Ceil(8192).W)))
  mem_global_1.test_addr := mem_global_1_test_addr
  val mem_global_1_test_data = IO(Output(UInt(32.W)))
  mem_global_1_test_data := mem_global_1.test_data
  mem_global_1.finished := done
}

