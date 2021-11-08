import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFileInline
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._
import chisel3.util.experimental.loadMemoryFromFile

class gemm extends MultiIOModule {
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
  mem_global_0.initMem("gemm_ncubed/in_0.txt");
  mem_global_1.initMem("gemm_ncubed/in_1.txt");
  mem_global_2.initMem("gemm_ncubed/in_2.txt");
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
    val var15 = IO(Input(UInt(32.W)))
    val var16 = IO(Output(UInt(64.W)))
    var16 := DontCare
    val var17 = Reg(UInt(32.W))
    val var18 = Reg(UInt(32.W))
    val var19 = Reg(UInt(32.W))
    val var20 = Reg(UInt(64.W))
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
    val var71 = Reg(UInt(64.W))
    val var72 = Reg(UInt(64.W))
    val var73 = Reg(UInt(64.W))
    val var74 = Reg(UInt(64.W))
    val var75 = Reg(UInt(64.W))
    val muli_outline_0_0 = Module(new MulI())
    val var76 = muli_outline_0_0.operand0
    var76 := DontCare
    val var77 = muli_outline_0_0.operand1
    var77 := DontCare
    val var78 = muli_outline_0_0.result
    val mulf_outline_0_0 = Module(new MulFBase(6, 11, 53))
    mulf_outline_0_0.ce := true.B
    val var79 = mulf_outline_0_0.operand0
    var79 := DontCare
    val var80 = mulf_outline_0_0.operand1
    var80 := DontCare
    val var81 = mulf_outline_0_0.result
    val addf_outline_0_0 = Module(new AddSubFBase(10, 11, 53, true))
    addf_outline_0_0.ce := true.B
    val var82 = addf_outline_0_0.operand0
    var82 := DontCare
    val var83 = addf_outline_0_0.operand1
    var83 := DontCare
    val var84 = addf_outline_0_0.result
    val var85 = Reg(UInt(32.W))
    when (go) {
      var85 := var11
    }
    when (go) {
      var17 := var11
    }
    when (go) {
      var18 := var12
    }
    when (go) {
      var19 := var13
    }
    when (go) {
      var20 := var14
    }
    when (go) {
      var21 := var15
    }
    when (go) {
      var47 := 0.U
    }
    val var0 = IO(Output(UInt(1.W)))
    var0 := false.B
    val var1 = IO(Output(UInt(12.W)))
    var1 := DontCare
    val var3 = IO(Output(UInt(1.W)))
    var3 := false.B
    val var4 = IO(Output(UInt(12.W)))
    var4 := DontCare
    val var2 = IO(Input(UInt(64.W)))
    val var5 = IO(Input(UInt(64.W)))
    val shift_register = RegInit(0.U(3.W))
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
	shift_register(1)
      } else if (stage == 22) {
	shift_register(1)
      } else if (stage == 23) {
	shift_register(2)
      } else if (stage == 24) {
	shift_register(2)
      } else if (stage == 25) {
	shift_register(2)
      } else {
	new_input
      }
    }
    val counter = RegInit(0.U(4.W))
    when (counter === 10.U) {
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
	var22 := var85
      }
      when (valid(11)) {
	var33 := var32
      }
      when (valid(11)) {
	var58 := var57
      }
      when (valid(22)) {
	var44 := var43
      }
    }
    when (counter === 1.U) {
      val var86 = var20 + var22
      when (valid(1)) {
	var63 := var86
      }
      when (valid(1)) {
	var23 := var22
      }
      when (valid(1)) {
	var48 := var47
      }
      when (valid(12)) {
	var34 := var33
      }
      when (valid(12)) {
	var59 := var58
      }
      when (valid(23)) {
	var45 := var44
      }
    }
    when (counter === 2.U) {
      var76 := var23
      var77 := 64.U
      var1 := var63
      var0 := 1.U
      when (valid(2)) {
	var24 := var23
      }
      when (valid(2)) {
	var49 := var48
      }
      when (valid(2)) {
	var64 := var63
      }
      when (valid(13)) {
	var35 := var34
      }
      when (valid(13)) {
	var60 := var59
      }
      when (valid(24)) {
	var46 := var45
      }
    }
    when (counter === 3.U) {
      when (valid(3)) {
	var25 := var24
      }
      when (valid(3)) {
	var50 := var49
      }
      when (valid(14)) {
	var36 := var35
      }
      when (valid(14)) {
	var61 := var60
      }
      when (valid(25)) {
	var61 := var84
	var16 := var84
	when (!valid(14)) {
	  done := true.B
	}
      }
    }
    when (counter === 4.U) {
      when (valid(4)) {
	var66 := var2
      }
      when (valid(4)) {
	var26 := var25
      }
      when (valid(4)) {
	var51 := var50
      }
      when (valid(15)) {
	var75 := var81
      }
      var82 := var61
      var83 := var81
      when (valid(15)) {
	var37 := var36
      }
      when (valid(15)) {
	var62 := var61
      }
    }
    when (counter === 5.U) {
      when (valid(5)) {
	var27 := var26
      }
      when (valid(5)) {
	var52 := var51
      }
      when (valid(5)) {
	var67 := var66
      }
      when (valid(16)) {
	var38 := var37
      }
    }
    when (counter === 6.U) {
      when (valid(6)) {
	var65 := var78
      }
      val var87 = var78 + var15
      when (valid(6)) {
	var72 := var87
      }
      when (valid(6)) {
	var28 := var27
      }
      when (valid(6)) {
	var53 := var52
      }
      when (valid(6)) {
	var68 := var67
      }
      when (valid(17)) {
	var39 := var38
      }
    }
    when (counter === 7.U) {
      var4 := var72
      var3 := 1.U
      when (valid(7)) {
	var29 := var28
      }
      when (valid(7)) {
	var54 := var53
      }
      when (valid(7)) {
	var69 := var68
      }
      when (valid(7)) {
	var73 := var72
      }
      when (valid(18)) {
	var40 := var39
      }
    }
    when (counter === 8.U) {
      when (valid(8)) {
	var30 := var29
      }
      when (valid(8)) {
	var55 := var54
      }
      when (valid(8)) {
	var70 := var69
      }
      when (valid(19)) {
	var41 := var40
      }
    }
    when (counter === 9.U) {
      when (valid(9)) {
	var74 := var5
      }
      var79 := var70
      var80 := var5
      when (valid(9)) {
	var31 := var30
      }
      when (valid(9)) {
	var56 := var55
      }
      when (valid(9)) {
	var71 := var70
      }
      when (valid(20)) {
	var42 := var41
      }
    }
    when (counter === 10.U) {
      when (valid(10)) {
	var32 := var31
      }
      when (valid(10)) {
	var57 := var56
      }
      when (valid(21)) {
	var43 := var42
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
      when (var85 <= upper_bound) {
	when (counter === 10.U) {
	  var85 := var85 + step
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
    val var88 = muli_main_0.operand0
    var88 := DontCare
    val var89 = muli_main_0.operand1
    var89 := DontCare
    val var90 = muli_main_0.result
    val var91 = Reg(UInt(1.W))
    val var92 = Reg(UInt(32.W))
    val var93 = Reg(UInt(1.W))
    val var94 = Reg(UInt(32.W))
    val var95 = Reg(UInt(64.W))
    val var96 = Reg(UInt(64.W))
    val var97 = Reg(UInt(64.W))
    val outline_0_0 = Module(new outline_0)
    outline_0_0.go := 0.U
    val var98 = outline_0_0.var11
    var98 := DontCare
    val var99 = outline_0_0.var12
    var99 := DontCare
    val var100 = outline_0_0.var13
    var100 := DontCare
    val var101 = outline_0_0.var14
    var101 := DontCare
    val var102 = outline_0_0.var15
    var102 := DontCare
    val var103 = outline_0_0.var16
    val var104 = outline_0_0.done
    val var0 = IO(Output(UInt(1.W)))
    var0 := outline_0_0.var0
    val var1 = IO(Output(UInt(12.W)))
    var1 := outline_0_0.var1
    val var3 = IO(Output(UInt(1.W)))
    var3 := outline_0_0.var3
    val var4 = IO(Output(UInt(12.W)))
    var4 := outline_0_0.var4
    val var2 = IO(Input(UInt(64.W)))
    outline_0_0.var2 := var2
    val var5 = IO(Input(UInt(64.W)))
    outline_0_0.var5 := var5
    val var6 = IO(Output(UInt(1.W)))
    var6 := false.B
    val var8 = IO(Output(UInt(12.W)))
    var8 := DontCare
    val var9 = IO(Output(UInt(64.W)))
    var9 := DontCare
    object State extends ChiselEnum {
      val s0, s1, s1_entry, s2, s2_entry, s3, s3_0, s3_1, s3_2, s4, s5, s5_wait, s6, s7, s8, s9, s10, s11 = Value
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
	val var105 = var92 <= 63.U
	var91 := var105
	val var106 = !var105
	var92 := 0.U
	state := State.s2;
	when (var106.asBool()) {
	  state := State.s11;
	}
      }
      is (State.s1_entry) {
	val var107 = !var91
	state := State.s2;
	when (var107.asBool()) {
	  state := State.s11;
	}
      }
      is (State.s2) {
	val var108 = var94 <= 63.U
	var93 := var108
	val var109 = !var108
	var94 := 0.U
	state := State.s3;
	when (var109.asBool()) {
	  state := State.s10;
	}
      }
      is (State.s2_entry) {
	val var110 = !var93
	state := State.s3;
	when (var110.asBool()) {
	  state := State.s10;
	}
      }
      is (State.s3) {
	var88 := var92
	var89 := 64.U
	state := State.s3_0;
      }
      is (State.s3_0) {
	state := State.s3_1;
      }
      is (State.s3_1) {
	state := State.s3_2;
      }
      is (State.s3_2) {
	var95 := var90
	state := State.s4;
      }
      is (State.s4) {
	state := State.s5;
      }
      is (State.s5) {
	var98 := 0.U
	var99 := 63.U
	var100 := 1.U
	var101 := var95
	var102 := var94
	outline_0_0.go := 1.U
	when (var104.asBool()) {
	  var96 := var103
	}
	state := State.s5_wait;
	when (var104.asBool()) {
	  state := State.s6;
	}
      }
      is (State.s5_wait) {
	when (var104.asBool()) {
	  var96 := var103
	}
	when (var104.asBool()) {
	  state := State.s6;
	}
      }
      is (State.s6) {
	state := State.s7;
      }
      is (State.s7) {
	val var111 = var95 + var94
	var97 := var111
	var8 := var111
	var9 := var96
	var6 := true.B
	state := State.s8;
      }
      is (State.s8) {
	state := State.s9;
      }
      is (State.s9) {
	val var112 = var94 + 1.U
	var94 := var112
	val var113 = var112 <= 63.U
	var93 := var113
	state := State.s2_entry;
      }
      is (State.s10) {
	val var114 = var92 + 1.U
	var92 := var114
	val var115 = var114 <= 63.U
	var91 := var115
	state := State.s1_entry;
      }
      is (State.s11) {
	done := 1.U
      }
    }
  }
  val main = Module(new main)
  mem_global_0.dataIn(0).valid := main.var0
  mem_global_0.dataIn(0).bits := main.var1
  mem_global_1.dataIn(0).valid := main.var3
  mem_global_1.dataIn(0).bits := main.var4
  mem_global_2.writeIn(0).valid := main.var6
  mem_global_2.writeIn(0).bits := main.var8
  mem_global_2.readIn(0).bits := main.var8
  mem_global_2.readIn(0).valid := false.B
  mem_global_2.w_dataIn(0).bits := main.var9
  val go = IO(Input(Bool()))
  main.go := go
  val done = IO(Output(Bool()))
  done := main.done
  main.var2 := var2
  main.var5 := var5

  val test_addr = IO(Input(UInt(12.W)))
  val test_data = IO(Output(UInt(64.W)))
  mem_global_2.test_addr := test_addr
  test_data := mem_global_2.test_data
  mem_global_2.finished := main.done
}

