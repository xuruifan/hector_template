import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class gemm extends MultiIOModule {
  val mem_global_0 = Module(new ReadMem(4096, 64, 1))
  val var0 = mem_global_0.r_en
  val var1 = mem_global_0.addr
  val var2 = mem_global_0.r_data
  val mem_global_1 = Module(new ReadMem(4096, 64, 1))
  val var3 = mem_global_1.r_en
  val var4 = mem_global_1.addr
  val var5 = mem_global_1.r_data
  val mem_global_2 = Module(new WriteMem(4096, 64, 1))
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
    val var13 = IO(Input(UInt(32.W)))
    val var14 = IO(Output(UInt(64.W)))
    var14 := DontCare
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
    val var60 = Reg(UInt(32.W))
    val var61 = Reg(UInt(32.W))
    val var62 = Reg(UInt(32.W))
    val var63 = Reg(UInt(64.W))
    val var64 = Reg(UInt(64.W))
    val var65 = Reg(UInt(32.W))
    val var66 = Reg(UInt(32.W))
    val var67 = Reg(UInt(64.W))
    val var68 = Reg(UInt(64.W))
    val mulf_outline_0_0 = Module(new MulFBase(9, 11, 53))
    mulf_outline_0_0.ce := true.B
    val var69 = mulf_outline_0_0.operand0
    var69 := DontCare
    val var70 = mulf_outline_0_0.operand1
    var70 := DontCare
    val var71 = mulf_outline_0_0.result
    val addf_outline_0_0 = Module(new AddSubFBase(13, 11, 53, true))
    addf_outline_0_0.ce := true.B
    val var72 = addf_outline_0_0.operand0
    var72 := DontCare
    val var73 = addf_outline_0_0.operand1
    var73 := DontCare
    val var74 = addf_outline_0_0.result
    val var75 = Reg(UInt(32.W))
    when (go) {
      var75 := var9
    }
    when (go) {
      var15 := var9
    }
    when (go) {
      var16 := var10
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
      var46 := 0.U
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
    val shift_register = RegInit(0.U(2.W))
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
          var20 := var75
        }
        when (valid(14)) {
          var34 := var33
        }
      }
      when (counter === 1.U) {
        val var76 = var19 + var20
        when (valid(1)) {
          var60 := var76
        }
        when (valid(1)) {
          var21 := var20
        }
        when (valid(1)) {
          var47 := var46
        }
        when (valid(15)) {
          var35 := var34
        }
      }
      when (counter === 2.U) {
        val var77 = var21 << 6.U
        when (valid(2)) {
          var62 := var77
        }
        var1 := var60
        when (valid(2)) {
          var0 := 1.U
        }
        val var78 = var77 + var18
        when (valid(2)) {
          var65 := var78
        }
        when (valid(2)) {
          var22 := var21
        }
        when (valid(2)) {
          var48 := var47
        }
        when (valid(2)) {
          var61 := var60
        }
        when (valid(16)) {
          var36 := var35
        }
      }
      when (counter === 3.U) {
        when (valid(3)) {
          var63 := var2
        }
        var4 := var65
        when (valid(3)) {
          var3 := 1.U
        }
        when (valid(3)) {
          var23 := var22
        }
        when (valid(3)) {
          var49 := var48
        }
        when (valid(3)) {
          var66 := var65
        }
        when (valid(17)) {
          var37 := var36
        }
      }
      when (counter === 4.U) {
        when (valid(4)) {
          var67 := var5
        }
        var69 := var63
        var70 := var5
        when (valid(4)) {
          var24 := var23
        }
        when (valid(4)) {
          var50 := var49
        }
        when (valid(4)) {
          var64 := var63
        }
        when (valid(18)) {
          var38 := var37
        }
      }
      when (counter === 5.U) {
        when (valid(5)) {
          var25 := var24
        }
        when (valid(5)) {
          var51 := var50
        }
        when (valid(19)) {
          var39 := var38
        }
      }
      when (counter === 6.U) {
        when (valid(6)) {
          var26 := var25
        }
        when (valid(6)) {
          var52 := var51
        }
        when (valid(20)) {
          var40 := var39
        }
      }
      when (counter === 7.U) {
        when (valid(7)) {
          var27 := var26
        }
        when (valid(7)) {
          var53 := var52
        }
        when (valid(21)) {
          var41 := var40
        }
      }
      when (counter === 8.U) {
        when (valid(8)) {
          var28 := var27
        }
        when (valid(8)) {
          var54 := var53
        }
        when (valid(22)) {
          var42 := var41
        }
      }
      when (counter === 9.U) {
        when (valid(9)) {
          var29 := var28
        }
        when (valid(9)) {
          var55 := var54
        }
        when (valid(23)) {
          var43 := var42
        }
      }
      when (counter === 10.U) {
        when (valid(10)) {
          var30 := var29
        }
        when (valid(10)) {
          var56 := var55
        }
        when (valid(24)) {
          var44 := var43
        }
      }
      when (counter === 11.U) {
        when (valid(11)) {
          var31 := var30
        }
        when (valid(11)) {
          var57 := var56
        }
        when (valid(25)) {
          var45 := var44
        }
      }
      when (counter === 12.U) {
        when (valid(12)) {
          var32 := var31
        }
        when (valid(12)) {
          var58 := var57
        }
        when (valid(26)) {
          var58 := var74
          var14 := var74
        }
      }
      when (counter === 13.U) {
        when (valid(13)) {
          var68 := var71
        }
        var72 := var58
        var73 := var71
        when (valid(13)) {
          var33 := var32
        }
        when (valid(13)) {
          var59 := var58
        }
      }
      when (counter === 12.U && valid(26)) {
        done := !valid(12)
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
        when (var75 <= upper_bound) {
          when (counter === 13.U) {
            var75 := var75 + step
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
    val var79 = Reg(UInt(1.W))
    val var80 = Reg(UInt(32.W))
    val var81 = Reg(UInt(1.W))
    val var82 = Reg(UInt(32.W))
    val var83 = Reg(UInt(32.W))
    val var84 = Reg(UInt(64.W))
    val var85 = Reg(UInt(32.W))
    val outline_0_0 = Module(new outline_0)
    outline_0_0.go := 0.U
    val var86 = outline_0_0.var9
    var86 := DontCare
    val var87 = outline_0_0.var10
    var87 := DontCare
    val var88 = outline_0_0.var11
    var88 := DontCare
    val var89 = outline_0_0.var12
    var89 := DontCare
    val var90 = outline_0_0.var13
    var90 := DontCare
    val var91 = outline_0_0.var14
    val var92 = outline_0_0.done
    val outline_0_0_var0 = IO(Output(UInt(1.W)))
    outline_0_0_var0 := outline_0_0.var0
    val outline_0_0_var1 = IO(Output(UInt(12.W)))
    outline_0_0_var1 := outline_0_0.var1
    val outline_0_0_var3 = IO(Output(UInt(1.W)))
    outline_0_0_var3 := outline_0_0.var3
    val outline_0_0_var4 = IO(Output(UInt(12.W)))
    outline_0_0_var4 := outline_0_0.var4
    val outline_0_0_var2 = IO(Input(UInt(64.W)))
    outline_0_0.var2 := outline_0_0_var2
    val outline_0_0_var5 = IO(Input(UInt(64.W)))
    outline_0_0.var5 := outline_0_0_var5
    val var6 = IO(Output(UInt(1.W)))
    var6 := false.B
    val var7 = IO(Output(UInt(12.W)))
    var7 := DontCare
    val var8 = IO(Output(UInt(64.W)))
    var8 := DontCare
    object State extends ChiselEnum {
      val s0, s1, s1_entry, s2, s2_entry, s3, s4, s5, s5_wait, s6, s7, s8, s9, s10 = Value
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
        val var93 = 0.U <= 63.U
        var79 := var93
        val var94 = !var93
        var80 := 0.U
        state := State.s2;
        when (var94.asBool()) {
          state := State.s10;
        }
      }
      is (State.s1_entry) {
        val var95 = !var79
        state := State.s2;
        when (var95.asBool()) {
          state := State.s10;
        }
      }
      is (State.s2) {
        val var96 = 0.U <= 63.U
        var81 := var96
        val var97 = !var96
        var82 := 0.U
        state := State.s3;
        when (var97.asBool()) {
          state := State.s9;
        }
      }
      is (State.s2_entry) {
        val var98 = !var81
        state := State.s3;
        when (var98.asBool()) {
          state := State.s9;
        }
      }
      is (State.s3) {
        val var99 = var80 << 6.U
        var83 := var99
        state := State.s4;
      }
      is (State.s4) {
        state := State.s5;
      }
      is (State.s5) {
        var86 := 0.U
        var87 := 63.U
        var88 := 1.U
        var89 := var82
        var90 := var83
        outline_0_0.go := 1.U
        when (var92.asBool()) {
          var84 := var91
        }
        state := State.s5_wait;
        when (var92.asBool()) {
          state := State.s6;
        }
      }
      is (State.s5_wait) {
        when (var92.asBool()) {
          var84 := var91
        }
        when (var92.asBool()) {
          state := State.s6;
        }
      }
      is (State.s6) {
        state := State.s7;
      }
      is (State.s7) {
        val var100 = var83 + var82
        var85 := var100
        var7 := var100
        var8 := var84
        var6 := true.B
        state := State.s8;
      }
      is (State.s8) {
        val var101 = var82 + 1.U
        var82 := var101
        val var102 = var101 <= 63.U
        var81 := var102
        state := State.s2_entry;
      }
      is (State.s9) {
        val var103 = var80 + 1.U
        var80 := var103
        val var104 = var103 <= 63.U
        var79 := var104
        state := State.s1_entry;
      }
      is (State.s10) {
        done := 1.U
      }
    }
  }
  val main = Module(new main)
  mem_global_0.dataIn(0).valid := main.outline_0_0_var0
  mem_global_0.dataIn(0).bits := main.outline_0_0_var1
  mem_global_1.dataIn(0).valid := main.outline_0_0_var3
  mem_global_1.dataIn(0).bits := main.outline_0_0_var4
  mem_global_2.dataIn(0).valid := main.var6
  mem_global_2.dataIn(0).bits := main.var7
  mem_global_2.w_dataIn(0).bits := main.var8
  val go = IO(Input(Bool()))
  main.go := go
  val done = IO(Output(Bool()))
  done := main.done
  main.outline_0_0_var2 := var2
  main.outline_0_0_var5 := var5
  val mem_global_2_test_addr = IO(Input(UInt(log2Ceil(4096).W)))
  mem_global_2.test_addr := mem_global_2_test_addr
  val mem_global_2_test_data = IO(Output(UInt(64.W)))
  mem_global_2_test_data := mem_global_2.test_data
  mem_global_2.finished := done
}

