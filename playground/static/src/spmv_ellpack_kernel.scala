import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class ellpack extends MultiIOModule {
  val mem_global_0 = Module(new ReadMem(4940, 64))
  val var0 = mem_global_0.r_en
  val var1 = mem_global_0.addr
  val var2 = mem_global_0.r_data
  mem_global_0.initMem("spmv_ellpack/in_0.txt");
  val mem_global_1 = Module(new ReadMem(4940, 32))
  val var3 = mem_global_1.r_en
  val var4 = mem_global_1.addr
  val var5 = mem_global_1.r_data
  mem_global_1.initMem("spmv_ellpack/in_1.txt");
  val mem_global_2 = Module(new ReadMem(494, 64))
  val var6 = mem_global_2.r_en
  val var7 = mem_global_2.addr
  val var8 = mem_global_2.r_data
  mem_global_2.initMem("spmv_ellpack/in_2.txt");
  val mem_global_3 = Module(new ReadWriteMem(494, 64))
  val var9 = mem_global_3.w_en
  val var10 = mem_global_3.r_en
  val var11 = mem_global_3.addr
  val var12 = mem_global_3.w_data
  val var13 = mem_global_3.r_data
  class outline_0 extends MultiIOModule {
    val go = IO(Input(Bool()))
    val start = RegInit(false.B)
    val new_input = Wire(Bool())
    new_input := false.B
    val done = IO(Output(Bool()))
    done := 0.U
    val var14 = IO(Input(UInt(32.W)))
    val var15 = IO(Input(UInt(32.W)))
    val var16 = IO(Input(UInt(32.W)))
    val var17 = IO(Input(UInt(32.W)))
    val var18 = IO(Input(UInt(64.W)))
    val var19 = IO(Output(UInt(64.W)))
    var19 := DontCare
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
    val var68 = Reg(UInt(32.W))
    val var69 = Reg(UInt(64.W))
    val var70 = Reg(UInt(64.W))
    val var71 = Reg(UInt(64.W))
    val muli_outline_0_0 = Module(new MulI())
    val var72 = muli_outline_0_0.operand0
    var72 := DontCare
    val var73 = muli_outline_0_0.operand1
    var73 := DontCare
    val var74 = muli_outline_0_0.result
    val mulf_outline_0_0 = Module(new MulFBase(6, 11, 53))
    mulf_outline_0_0.ce := true.B
    val var75 = mulf_outline_0_0.operand0
    var75 := DontCare
    val var76 = mulf_outline_0_0.operand1
    var76 := DontCare
    val var77 = mulf_outline_0_0.result
    val addf_outline_0_0 = Module(new AddSubFBase(10, 11, 53, true))
    addf_outline_0_0.ce := true.B
    val var78 = addf_outline_0_0.operand0
    var78 := DontCare
    val var79 = addf_outline_0_0.operand1
    var79 := DontCare
    val var80 = addf_outline_0_0.result
    val var81 = Reg(UInt(32.W))
    when (go) {
      var81 := var14
    }
    when (go) {
      var20 := var14
    }
    when (go) {
      var21 := var15
    }
    when (go) {
      var22 := var16
    }
    when (go) {
      var46 := var18
    }
    val var0 = IO(Output(UInt(1.W)))
    var0 := false.B
    val var1 = IO(Output(UInt(13.W)))
    var1 := DontCare
    val var3 = IO(Output(UInt(1.W)))
    var3 := false.B
    val var4 = IO(Output(UInt(13.W)))
    var4 := DontCare
    val var6 = IO(Output(UInt(1.W)))
    var6 := false.B
    val var7 = IO(Output(UInt(9.W)))
    var7 := DontCare
    val var2 = IO(Input(UInt(64.W)))
    val var5 = IO(Input(UInt(32.W)))
    val var8 = IO(Input(UInt(64.W)))
    val shift_register = RegInit(0.U(3.W))
    when (go) {
      when (var14 > var15) {
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
      } else if (stage == 26) {
	shift_register(2)
      } else {
	new_input
      }
    }
    val counter = RegInit(0.U(4.W))
    when (counter === 10.U) {
      counter := 0.U
    }.otherwise {
      when (start || counter =/= 0.U) {
	counter := counter + 1.U
      }
    }
    when (counter === 0.U && start) {
      shift_register := Cat(shift_register(1, 0), new_input)
    }
    when (counter === 0.U) {
      when (valid(11)) {
	var31 := var30
      }
      when (valid(11)) {
	var57 := var56
      }
      when (valid(22)) {
	var42 := var41
      }
    }
    when (counter === 1.U) {
      var72 := var23
      var73 := var21
      when (valid(1)) {
	var47 := var46
      }
      when (valid(12)) {
	var32 := var31
      }
      when (valid(12)) {
	var58 := var57
      }
      when (valid(23)) {
	var43 := var42
      }
    }
    when (counter === 2.U) {
      when (valid(2)) {
	var48 := var47
      }
      when (valid(13)) {
	var33 := var32
      }
      when (valid(13)) {
	var59 := var58
      }
      when (valid(24)) {
	var44 := var43
      }
    }
    when (counter === 3.U) {
      when (valid(3)) {
	var49 := var48
      }
      when (valid(14)) {
	var34 := var33
      }
      when (valid(14)) {
	var60 := var59
      }
      when (valid(25)) {
	var45 := var44
      }
    }
    when (counter === 4.U) {
      when (valid(4)) {
	var50 := var49
      }
      when (valid(15)) {
	var35 := var34
      }
      when (valid(15)) {
	var61 := var60
      }
      when (valid(26)) {
	var61 := var80
	var19 := var80
	when (!valid(15)) {
	  done := true.B
	}
      }
    }
    when (counter === 5.U) {
      when (valid(5)) {
	var63 := var74
      }
      val var82 = var24 + var74
      when (valid(5)) {
	var64 := var82
      }
      when (valid(5)) {
	var25 := var24
      }
      when (valid(5)) {
	var51 := var50
      }
      when (valid(16)) {
	var71 := var77
      }
      var78 := var61
      var79 := var77
      when (valid(16)) {
	var36 := var35
      }
      when (valid(16)) {
	var62 := var61
      }
    }
    when (counter === 6.U) {
      var4 := var64
      var3 := 1.U
      when (valid(6)) {
	var26 := var25
      }
      when (valid(6)) {
	var52 := var51
      }
      when (valid(6)) {
	var65 := var64
      }
      when (valid(17)) {
	var37 := var36
      }
    }
    when (counter === 7.U) {
      when (valid(7)) {
	var27 := var26
      }
      when (valid(7)) {
	var53 := var52
      }
      when (valid(7)) {
	var66 := var65
      }
      when (valid(18)) {
	var38 := var37
      }
    }
    when (counter === 8.U) {
      when (valid(8)) {
	var68 := var5
      }
      var1 := var66
      var0 := 1.U
      var7 := var5
      var6 := 1.U
      when (valid(8)) {
	var28 := var27
      }
      when (valid(8)) {
	var54 := var53
      }
      when (valid(8)) {
	var67 := var66
      }
      when (valid(19)) {
	var39 := var38
      }
    }
    when (counter === 9.U) {
      when (valid(9)) {
	var29 := var28
      }
      when (valid(9)) {
	var55 := var54
      }
      when (valid(20)) {
	var40 := var39
      }
    }
    when (counter === 10.U) {
      when (valid(10)) {
	var69 := var2
      }
      when (valid(10)) {
	var70 := var8
      }
      var75 := var2
      var76 := var8
      when (valid(10)) {
	var30 := var29
      }
      when (valid(10)) {
	var56 := var55
      }
      when (valid(21)) {
	var41 := var40
      }
    }
    val ub_reg = Reg(UInt(32.W))
    when (go) {
      ub_reg := var15
    }
    val step_reg = Reg(UInt(32.W))
    when (go) {
      step_reg := var16
    }
    val upper_bound = Mux(go, var15, ub_reg)
    val step = Mux(go, var16, step_reg)
    new_input := start
    when (start) {
      when (var81 <= upper_bound) {
	when (counter === 10.U) {
	  var81 := var81 + step
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
    val var83 = Reg(UInt(1.W))
    val var84 = Reg(UInt(32.W))
    val var85 = Reg(UInt(64.W))
    val outline_0_0 = Module(new outline_0)
    outline_0_0.go := 0.U
    val var86 = outline_0_0.var14
    var86 := DontCare
    val var87 = outline_0_0.var15
    var87 := DontCare
    val var88 = outline_0_0.var16
    var88 := DontCare
    val var89 = outline_0_0.var17
    var89 := DontCare
    val var90 = outline_0_0.var18
    var90 := DontCare
    val var91 = outline_0_0.var19
    val var92 = outline_0_0.done
    val var0 = IO(Output(UInt(1.W)))
    var0 := outline_0_0.var0
    val var1 = IO(Output(UInt(13.W)))
    var1 := outline_0_0.var1
    val var3 = IO(Output(UInt(1.W)))
    var3 := outline_0_0.var3
    val var4 = IO(Output(UInt(13.W)))
    var4 := outline_0_0.var4
    val var6 = IO(Output(UInt(1.W)))
    var6 := outline_0_0.var6
    val var7 = IO(Output(UInt(9.W)))
    var7 := outline_0_0.var7
    val var2 = IO(Input(UInt(64.W)))
    outline_0_0.var2 := var2
    val var5 = IO(Input(UInt(32.W)))
    outline_0_0.var5 := var5
    val var8 = IO(Input(UInt(64.W)))
    outline_0_0.var8 := var8
    val var9 = IO(Output(UInt(1.W)))
    var9 := false.B
    val var10 = IO(Output(UInt(1.W)))
    var10 := false.B
    val var11 = IO(Output(UInt(9.W)))
    var11 := DontCare
    val var12 = IO(Output(UInt(64.W)))
    var12 := DontCare
    val var13 = IO(Input(UInt(64.W)))
    object State extends ChiselEnum {
      val s0, s1, s1_entry, s2, s2_0, s3, s4, s4_wait, s5, s6, s6_0, s7, s8 = Value
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
	val var93 = var84 <= 494.U
	var83 := var93
	val var94 = !var93
	var84 := 0.U
	state := State.s2;
	when (var94.asBool()) {
	  state := State.s8;
	}
      }
      is (State.s1_entry) {
	val var95 = !var83
	state := State.s2;
	when (var95.asBool()) {
	  state := State.s8;
	}
      }
      is (State.s2) {
	var11 := var84
	var10 := true.B
	state := State.s2_0;
      }
      is (State.s2_0) {
	var85 := var13
	state := State.s3;
      }
      is (State.s3) {
	state := State.s4;
      }
      is (State.s4) {
	var86 := 0.U
	var87 := 10.U
	var88 := 1.U
	var89 := var84
	var90 := var85
	outline_0_0.go := 1.U
	when (var92.asBool()) {
	  var85 := var91
	}
	state := State.s4_wait;
	when (var92.asBool()) {
	  state := State.s5;
	}
      }
      is (State.s4_wait) {
	when (var92.asBool()) {
	  var85 := var91
	}
	when (var92.asBool()) {
	  state := State.s5;
	}
      }
      is (State.s5) {
	state := State.s6;
      }
      is (State.s6) {
	var11 := var84
	var12 := var85
	var9 := true.B
	state := State.s6_0;
      }
      is (State.s6_0) {
	state := State.s7;
      }
      is (State.s7) {
	val var96 = var84 + 1.U
	var84 := var96
	val var97 = var96 <= 494.U
	var83 := var97
	state := State.s1_entry;
      }
      is (State.s8) {
	done := 1.U
      }
    }
  }
  val main = Module(new main)
  mem_global_0.dataIn(0).valid := main.var0
  mem_global_0.dataIn(0).bits := main.var1
  mem_global_1.dataIn(0).valid := main.var3
  mem_global_1.dataIn(0).bits := main.var4
  mem_global_2.dataIn(0).valid := main.var6
  mem_global_2.dataIn(0).bits := main.var7
  mem_global_3.writeIn(0).valid := main.var9
  mem_global_3.readIn(0).valid := main.var10
  mem_global_3.writeIn(0).bits := main.var11
  mem_global_3.readIn(0).bits := main.var11
  mem_global_3.w_dataIn(0).bits := main.var12

  val test_addr = IO(Input(UInt(9.W)))
  val test_data = IO(Output(UInt(64.W)))

  mem_global_3.test_addr := test_addr
  test_data := mem_global_3.test_data

  val go = IO(Input(Bool()))
  main.go := go
  val done = IO(Output(Bool()))
  mem_global_3.finished := done
  done := main.done
  main.var2 := var2
  main.var5 := var5
  main.var8 := var8
  main.var13 := var13
}

