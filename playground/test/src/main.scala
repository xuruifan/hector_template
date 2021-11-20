import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class TopModule extends MultiIOModule {
  val mem_global_0 = Module(new ReadMem(1666, 64))
  val var0 = mem_global_0.r_en
  val var1 = mem_global_0.addr
  val var2 = mem_global_0.r_data
  val mem_global_1 = Module(new ReadMem(1666, 32))
  val var3 = mem_global_1.r_en
  val var4 = mem_global_1.addr
  val var5 = mem_global_1.r_data
  val mem_global_2 = Module(new ReadMem(495, 32))
  val var6 = mem_global_2.r_en
  val var7 = mem_global_2.addr
  val var8 = mem_global_2.r_data
  val mem_global_3 = Module(new ReadMem(494, 64))
  val var9 = mem_global_3.r_en
  val var10 = mem_global_3.addr
  val var11 = mem_global_3.r_data
  val mem_global_4 = Module(new WriteMem(494, 64))
  val var12 = mem_global_4.w_en
  val var13 = mem_global_4.addr
  val var14 = mem_global_4.w_data
  mem_global_0.initMem("data_set/spmv_crs_kernel/mem_0.txt")
  mem_global_1.initMem("data_set/spmv_crs_kernel/mem_1.txt")
  mem_global_2.initMem("data_set/spmv_crs_kernel/mem_2.txt")
  mem_global_3.initMem("data_set/spmv_crs_kernel/mem_3.txt")

  class outline_0 extends MultiIOModule {
    val go = IO(Input(Bool()))
    val start = RegInit(false.B)
    val new_input = Wire(Bool())
    new_input := false.B
    val done = IO(Output(Bool()))
    done := 0.U
    val var15 = IO(Input(UInt(32.W)))
    val var16 = IO(Input(UInt(32.W)))
    val var17 = IO(Input(UInt(32.W)))
    val var18 = IO(Output(UInt(64.W)))
    var18 := DontCare
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
    val var44 = Reg(UInt(64.W))
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
    val var57 = Reg(UInt(32.W))
    val var58 = Reg(UInt(32.W))
    val var59 = Reg(UInt(32.W))
    val var60 = Reg(UInt(32.W))
    val var61 = Reg(UInt(32.W))
    val var62 = Reg(UInt(32.W))
    val var63 = Reg(UInt(64.W))
    val var64 = Reg(UInt(64.W))
    val var65 = Reg(UInt(64.W))
    val mulf_outline_0_0 = Module(new MulFBase(6, 11, 53))
    mulf_outline_0_0.ce := true.B
    val var66 = mulf_outline_0_0.operand0
    var66 := DontCare
    val var67 = mulf_outline_0_0.operand1
    var67 := DontCare
    val var68 = mulf_outline_0_0.result
    val addf_outline_0_0 = Module(new AddSubFBase(10, 11, 53, true))
    addf_outline_0_0.ce := true.B
    val var69 = addf_outline_0_0.operand0
    var69 := DontCare
    val var70 = addf_outline_0_0.operand1
    var70 := DontCare
    val var71 = addf_outline_0_0.result
    val var72 = Reg(UInt(32.W))
    when(go) {
      var72 := var15
    }
    when(go) {
      var19 := var15
    }
    when(go) {
      var20 := var16
    }
    when(go) {
      var21 := var17
    }
    when(go) {
      var44 := 0.U
    }
    val var0 = IO(Output(UInt(1.W)))
    var0 := false.B
    val var1 = IO(Output(UInt(11.W)))
    var1 := DontCare
    val var3 = IO(Output(UInt(1.W)))
    var3 := false.B
    val var4 = IO(Output(UInt(11.W)))
    var4 := DontCare
    val var9 = IO(Output(UInt(1.W)))
    var9 := false.B
    val var10 = IO(Output(UInt(9.W)))
    var10 := DontCare
    val var2 = IO(Input(UInt(64.W)))
    val var5 = IO(Input(UInt(32.W)))
    val var11 = IO(Input(UInt(64.W)))
    val shift_register = RegInit(0.U(3.W))
    when(go) {
      when(var15 > var16) {
        done := true.B
      }.otherwise {
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
      } else {
        new_input
      }
    }

    val counter = RegInit(0.U(4.W))
    when(counter === 10.U) {
      counter := 0.U
    }.otherwise {
      when(start || counter =/= 0.U) {
        counter := counter + 1.U
      }
    }
    when(counter === 0.U && start) {
      shift_register := Cat(shift_register(1, 0), new_input)
    }
    when(counter === 0.U) {
      when(valid(0)) {
        var22 := var72
      }
      when(valid(11)) {
        var33 := var32
      }
      when(valid(11)) {
        var55 := var54
      }
      when(valid(22)) {
        var55 := var71
        var18 := var71
        when(!valid(11)) {
          done := true.B
        }
      }
    }
    when(counter === 1.U) {
      val var73 = var22 - var19
      when(valid(1)) {
        var57 := var73
      }
      val var74 = var73 + var19
      when(valid(1)) {
        var58 := var74
      }
      when(valid(1)) {
        var23 := var22
      }
      when(valid(1)) {
        var45 := var44
      }
      when(valid(12)) {
        var65 := var68
      }
      var69 := var55
      var70 := var68
      when(valid(12)) {
        var34 := var33
      }
      when(valid(12)) {
        var56 := var55
      }
    }
    when(counter === 2.U) {
      var4 := var58
      var3 := 1.U
      when(valid(2)) {
        var24 := var23
      }
      when(valid(2)) {
        var46 := var45
      }
      when(valid(2)) {
        var59 := var58
      }
      when(valid(13)) {
        var35 := var34
      }
    }
    when(counter === 3.U) {
      when(valid(3)) {
        var25 := var24
      }
      when(valid(3)) {
        var47 := var46
      }
      when(valid(3)) {
        var60 := var59
      }
      when(valid(14)) {
        var36 := var35
      }
    }
    when(counter === 4.U) {
      when(valid(4)) {
        var62 := var5
      }
      var1 := var60
      var0 := 1.U
      var10 := var5
      var9 := 1.U
      when(valid(4)) {
        var26 := var25
      }
      when(valid(4)) {
        var48 := var47
      }
      when(valid(4)) {
        var61 := var60
      }
      when(valid(15)) {
        var37 := var36
      }
    }
    when(counter === 5.U) {
      when(valid(5)) {
        var27 := var26
      }
      when(valid(5)) {
        var49 := var48
      }
      when(valid(16)) {
        var38 := var37
      }
    }
    when(counter === 6.U) {
      when(valid(6)) {
        var63 := var2
      }
      when(valid(6)) {
        var64 := var11
      }
      var66 := var2
      var67 := var11
      when(valid(6)) {
        var28 := var27
      }
      when(valid(6)) {
        var50 := var49
      }
      when(valid(17)) {
        var39 := var38
      }
    }
    when(counter === 7.U) {
      when(valid(7)) {
        var29 := var28
      }
      when(valid(7)) {
        var51 := var50
      }
      when(valid(18)) {
        var40 := var39
      }
    }
    when(counter === 8.U) {
      when(valid(8)) {
        var30 := var29
      }
      when(valid(8)) {
        var52 := var51
      }
      when(valid(19)) {
        var41 := var40
      }
    }
    when(counter === 9.U) {
      when(valid(9)) {
        var31 := var30
      }
      when(valid(9)) {
        var53 := var52
      }
      when(valid(20)) {
        var42 := var41
      }
    }
    when(counter === 10.U) {
      when(valid(10)) {
        var32 := var31
      }
      when(valid(10)) {
        var54 := var53
      }
      when(valid(21)) {
        var43 := var42
      }
    }
    val ub_reg = Reg(UInt(32.W))
    when(go) {
      ub_reg := var16
    }
    val step_reg = Reg(UInt(32.W))
    when(go) {
      step_reg := var17
    }
    val upper_bound = Mux(go, var16, ub_reg)
    val step = Mux(go, var17, step_reg)
    new_input := start
    when(start) {
      when(var72 <= upper_bound) {
        when(counter === 10.U) {
          var72 := var72 + step
        }
      }.otherwise {
        start := false.B
        new_input := false.B
      }
    }
    when(done) {
      shift_register := 0.U
    }
  }

  class main extends MultiIOModule {
    val go = IO(Input(Bool()))
    val done = IO(Output(Bool()))
    done := 0.U
    val var75 = Reg(UInt(1.W))
    val var76 = Reg(UInt(32.W))
    val var77 = Reg(UInt(32.W))
    val var78 = Reg(UInt(32.W))
    val var79 = Reg(UInt(64.W))
    val outline_0_0 = Module(new outline_0)
    outline_0_0.go := 0.U
    val var80 = outline_0_0.var15
    var80 := DontCare
    val var81 = outline_0_0.var16
    var81 := DontCare
    val var82 = outline_0_0.var17
    var82 := DontCare
    val var83 = outline_0_0.var18
    val var84 = outline_0_0.done
    val var0 = IO(Output(UInt(1.W)))
    var0 := outline_0_0.var0
    val var1 = IO(Output(UInt(11.W)))
    var1 := outline_0_0.var1
    val var3 = IO(Output(UInt(1.W)))
    var3 := outline_0_0.var3
    val var4 = IO(Output(UInt(11.W)))
    var4 := outline_0_0.var4
    val var9 = IO(Output(UInt(1.W)))
    var9 := outline_0_0.var9
    val var10 = IO(Output(UInt(9.W)))
    var10 := outline_0_0.var10
    val var2 = IO(Input(UInt(64.W)))
    outline_0_0.var2 := var2
    val var5 = IO(Input(UInt(32.W)))
    outline_0_0.var5 := var5
    val var11 = IO(Input(UInt(64.W)))
    outline_0_0.var11 := var11
    val var6 = IO(Output(UInt(1.W)))
    var6 := false.B
    val var7 = IO(Output(UInt(9.W)))
    var7 := DontCare
    val var12 = IO(Output(UInt(1.W)))
    var12 := false.B
    val var13 = IO(Output(UInt(9.W)))
    var13 := DontCare
    val var14 = IO(Output(UInt(64.W)))
    var14 := DontCare
    val var8 = IO(Input(UInt(32.W)))

    object State extends ChiselEnum {
      val s0, s1, s1_entry, s2, s3, s4, s5, s6, s7, s7_wait, s8, s9, s9_0, s10, s11 = Value
    }

    val state = RegInit(State.s0)
    val ready = go & (state === State.s0)
    switch(state) {
      is(State.s0) {
        when(go) {
          state := State.s1;
        }
      }
      is(State.s1) {
        val var85 = var76 <= 493.U
        var75 := var85
        val var86 = !var85
        var76 := 0.U
        state := State.s2;
        when(var86.asBool()) {
          state := State.s11;
        }
      }
      is(State.s1_entry) {
        val var87 = !var75
        state := State.s2;
        when(var87.asBool()) {
          state := State.s11;
        }
      }
      is(State.s2) {
        var7 := var76
        var6 := true.B
        val var88 = var76 + 1.U
        var77 := var88
        state := State.s3;
      }
      is(State.s3) {
        var77 := var8
        var7 := var77
        var6 := true.B
        state := State.s4;
      }
      is(State.s4) {
        var78 := var8
        state := State.s5;
      }
      is(State.s5) {
        val var89 = var78 - 1.U
        var78 := var89
        state := State.s6;
      }
      is(State.s6) {
        state := State.s7;
      }
      is(State.s7) {
        var80 := var77
        var81 := var78
        var82 := 1.U
        outline_0_0.go := 1.U
        when(var84.asBool()) {
          var79 := var83
        }
        state := State.s7_wait;
        when(var84.asBool()) {
          state := State.s8;
        }
      }
      is(State.s7_wait) {
        when(var84.asBool()) {
          var79 := var83
        }
        when(var84.asBool()) {
          state := State.s8;
        }
      }
      is(State.s8) {
        state := State.s9;
      }
      is(State.s9) {
        var13 := var76
        var14 := var79
        var12 := true.B
        state := State.s9_0;
      }
      is(State.s9_0) {
        state := State.s10;
      }
      is(State.s10) {
        val var90 = var76 + 1.U
        var76 := var90
        val var91 = var90 <= 493.U
        var75 := var91
        state := State.s1_entry;
      }
      is(State.s11) {
        done := 1.U
      }
    }
  }

  val main = Module(new main)
  mem_global_0.dataIn(0).valid := main.var0
  mem_global_0.dataIn(0).bits := main.var1
  mem_global_1.dataIn(0).valid := main.var3
  mem_global_1.dataIn(0).bits := main.var4
  mem_global_3.dataIn(0).valid := main.var9
  mem_global_3.dataIn(0).bits := main.var10
  mem_global_2.dataIn(0).valid := main.var6
  mem_global_2.dataIn(0).bits := main.var7
  mem_global_4.dataIn(0).valid := main.var12
  mem_global_4.dataIn(0).bits := main.var13
  mem_global_4.w_dataIn(0).bits := main.var14
  val go = IO(Input(Bool()))
  main.go := go
  val done = IO(Output(Bool()))
  done := main.done
  main.var2 := var2
  main.var5 := var5
  main.var11 := var11
  main.var8 := var8
  val mem_global_4_test_addr = IO(Input(UInt(log2Ceil(494).W)))
  mem_global_4.test_addr := mem_global_4_test_addr
  val mem_global_4_test_data = IO(Output(UInt(64.W)))
  mem_global_4_test_data := mem_global_4.test_data
  mem_global_4.finished := done
}

