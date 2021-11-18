import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class stencil extends MultiIOModule {
  val mem_global_0 = Module(new ReadMem(8192, 32, 1))
  val var0 = mem_global_0.r_en
  val var1 = mem_global_0.addr
  val var2 = mem_global_0.r_data
  val mem_global_1 = Module(new WriteMem(8192, 32, 1))
  val var3 = mem_global_1.w_en
  val var4 = mem_global_1.addr
  val var5 = mem_global_1.w_data
  val mem_global_2 = Module(new ReadMem(9, 32, 1))
  val var6 = mem_global_2.r_en
  val var7 = mem_global_2.addr
  val var8 = mem_global_2.r_data
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
    val muli_outline_0_0 = Module(new MulI())
    muli_outline_0_0.ce := true.B
    val var45 = muli_outline_0_0.operand0
    var45 := DontCare
    val var46 = muli_outline_0_0.operand1
    var46 := DontCare
    val var47 = muli_outline_0_0.result
    val var48 = Reg(UInt(32.W))
    when (go) {
      var48 := var9
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
      var29 := var15
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
    val shift_register = RegInit(0.U(6.W))
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
	shift_register(1)
      } else if (stage == 3) {
	shift_register(2)
      } else if (stage == 4) {
	shift_register(3)
      } else if (stage == 5) {
	shift_register(4)
      } else {
	new_input
      }
    }
//    when (start) {
      shift_register := Cat(shift_register(4, 0), new_input)
//    }
    when (true.B) {
      when (valid(0)) {
	var24 := var48
      }
      val var49 = var22 << 1.U
      when (valid(1)) {
	var34 := var49
      }
      val var50 = var22 + var49
      when (valid(1)) {
	var35 := var50
      }
      val var51 = var50 + var24
      when (valid(1)) {
	var36 := var51
      }
      val var52 = var20 + var22
      when (valid(1)) {
	var38 := var52
      }
      val var53 = var52 << 6.U
      when (valid(1)) {
	var39 := var53
      }
      val var54 = var53 + var21
      when (valid(1)) {
	var40 := var54
      }
      val var55 = var54 + var24
      when (valid(1)) {
	var41 := var55
      }
      when (valid(1)) {
	var25 := var24
      }
      when (valid(1)) {
	var30 := var29
      }
      var7 := var36
      when (valid(2)) {
	var6 := 1.U
      }
      var1 := var41
      when (valid(2)) {
	var0 := 1.U
      }
      when (valid(2)) {
	var26 := var25
      }
      when (valid(2)) {
	var31 := var30
      }
      when (valid(2)) {
	var37 := var36
      }
      when (valid(2)) {
	var42 := var41
      }
      when (valid(3)) {
	var43 := var8
      }
      when (valid(3)) {
	var44 := var2
      }
      var45 := var8
      var46 := var2
      when (valid(3)) {
	var27 := var26
      }
      when (valid(3)) {
	var32 := var31
      }
      when (valid(4)) {
	var28 := var27
      }
      when (valid(4)) {
	var33 := var32
      }
      val var56 = var33 + var47
      when (valid(5)) {
	var33 := var56
	var16 := var56
      }
      when (valid(5)) {
	done := !valid(4)
      }
    }
    when (done) {
      shift_register := 0.U
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
      when (var48 <= upper_bound) {
	var48 := var48 + step
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
    val var57 = Reg(UInt(1.W))
    val var58 = Reg(UInt(32.W))
    val var59 = Reg(UInt(1.W))
    val var60 = Reg(UInt(32.W))
    val var61 = Reg(UInt(1.W))
    val var62 = Reg(UInt(32.W))
    val var63 = Reg(UInt(32.W))
    val var64 = Reg(UInt(32.W))
    val var65 = Reg(UInt(32.W))
    val outline_0_0 = Module(new outline_0)
    outline_0_0.go := 0.U
    val var66 = outline_0_0.var9
    var66 := DontCare
    val var67 = outline_0_0.var10
    var67 := DontCare
    val var68 = outline_0_0.var11
    var68 := DontCare
    val var69 = outline_0_0.var12
    var69 := DontCare
    val var70 = outline_0_0.var13
    var70 := DontCare
    val var71 = outline_0_0.var14
    var71 := DontCare
    val var72 = outline_0_0.var15
    var72 := DontCare
    val var73 = outline_0_0.var16
    val var74 = outline_0_0.done
    val outline_0_0_var0 = IO(Output(UInt(1.W)))
    outline_0_0_var0 := outline_0_0.var0
    val outline_0_0_var1 = IO(Output(UInt(13.W)))
    outline_0_0_var1 := outline_0_0.var1
    val outline_0_0_var6 = IO(Output(UInt(1.W)))
    outline_0_0_var6 := outline_0_0.var6
    val outline_0_0_var7 = IO(Output(UInt(4.W)))
    outline_0_0_var7 := outline_0_0.var7
    val outline_0_0_var2 = IO(Input(UInt(32.W)))
    outline_0_0.var2 := outline_0_0_var2
    val outline_0_0_var8 = IO(Input(UInt(32.W)))
    outline_0_0.var8 := outline_0_0_var8
    val var3 = IO(Output(UInt(1.W)))
    var3 := false.B
    val var4 = IO(Output(UInt(13.W)))
    var4 := DontCare
    val var5 = IO(Output(UInt(32.W)))
    var5 := DontCare
    object State extends ChiselEnum {
      val s0, s1, s1_entry, s2, s2_entry, s3, s3_entry, s4, s4_wait, s5, s6, s7, s8, s9, s10, s11, s12 = Value
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
	val var75 = 0.U <= 125.U
	var57 := var75
	val var76 = !var75
	var58 := 0.U
	state := State.s2;
	when (var76.asBool()) {
	  state := State.s12;
	}
      }
      is (State.s1_entry) {
	val var77 = !var57
	state := State.s2;
	when (var77.asBool()) {
	  state := State.s12;
	}
      }
      is (State.s2) {
	val var78 = 0.U <= 61.U
	var59 := var78
	val var79 = !var78
	var60 := 0.U
	state := State.s3;
	when (var79.asBool()) {
	  state := State.s11;
	}
      }
      is (State.s2_entry) {
	val var80 = !var59
	state := State.s3;
	when (var80.asBool()) {
	  state := State.s11;
	}
      }
      is (State.s3) {
	val var81 = 0.U <= 2.U
	var61 := var81
	val var82 = !var81
	var62 := 0.U
	var63 := 0.U
	when (var82.asBool()) {
	  var64 := 0.U
	}
	state := State.s4;
	when (var82.asBool()) {
	  state := State.s6;
	}
      }
      is (State.s3_entry) {
	val var83 = !var61
	when (var83.asBool()) {
	  var64 := var63
	}
	state := State.s4;
	when (var83.asBool()) {
	  state := State.s6;
	}
      }
      is (State.s4) {
	var66 := 0.U
	var67 := 2.U
	var68 := 1.U
	var69 := var58
	var70 := var60
	var71 := var62
	var72 := var63
	outline_0_0.go := 1.U
	when (var74.asBool()) {
	  var63 := var73
	}
	state := State.s4_wait;
	when (var74.asBool()) {
	  state := State.s5;
	}
      }
      is (State.s4_wait) {
	when (var74.asBool()) {
	  var63 := var73
	}
	when (var74.asBool()) {
	  state := State.s5;
	}
      }
      is (State.s5) {
	var63 := var63
	val var84 = var62 + 1.U
	var62 := var84
	val var85 = var84 <= 2.U
	var61 := var85
	state := State.s3_entry;
      }
      is (State.s6) {
	state := State.s7;
      }
      is (State.s7) {
	val var86 = var58 << 6.U
	var65 := var86
	val var87 = var86 + var60
	var62 := var87
	state := State.s8;
      }
      is (State.s8) {
	state := State.s9;
      }
      is (State.s9) {
	var4 := var62
	var5 := var64
	var3 := true.B
	state := State.s10;
      }
      is (State.s10) {
	val var88 = var60 + 1.U
	var60 := var88
	val var89 = var88 <= 61.U
	var59 := var89
	state := State.s2_entry;
      }
      is (State.s11) {
	val var90 = var58 + 1.U
	var58 := var90
	val var91 = var90 <= 125.U
	var57 := var91
	state := State.s1_entry;
      }
      is (State.s12) {
	done := 1.U
      }
    }
  }
  val main = Module(new main)
  mem_global_0.dataIn(0).valid := main.outline_0_0_var0
  mem_global_0.dataIn(0).bits := main.outline_0_0_var1
  mem_global_2.dataIn(0).valid := main.outline_0_0_var6
  mem_global_2.dataIn(0).bits := main.outline_0_0_var7
  mem_global_1.dataIn(0).valid := main.var3
  mem_global_1.dataIn(0).bits := main.var4
  mem_global_1.w_dataIn(0).bits := main.var5
  val go = IO(Input(Bool()))
  main.go := go
  val done = IO(Output(Bool()))
  done := main.done
  main.outline_0_0_var2 := var2
  main.outline_0_0_var8 := var8
  val mem_global_1_test_addr = IO(Input(UInt(log2Ceil(8192).W)))
  mem_global_1.test_addr := mem_global_1_test_addr
  val mem_global_1_test_data = IO(Output(UInt(32.W)))
  mem_global_1_test_data := mem_global_1.test_data
  mem_global_1.finished := done
  mem_global_0.initMem("data_set/stencil_stencil2d/in_0.txt")
  mem_global_2.initMem("data_set/stencil_stencil2d/in_1.txt")
}

