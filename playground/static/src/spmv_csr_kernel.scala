import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class spmv extends MultiIOModule {
  val mem_global_0 = Module(new ReadMem(1666, 64, 1))
  val var0 = mem_global_0.r_en
  val var1 = mem_global_0.addr
  val var2 = mem_global_0.r_data
  val mem_global_1 = Module(new ReadMem(1666, 32, 1))
  val var3 = mem_global_1.r_en
  val var4 = mem_global_1.addr
  val var5 = mem_global_1.r_data
  val mem_global_2 = Module(new ReadMem(495, 32, 1))
  val var6 = mem_global_2.r_en
  val var7 = mem_global_2.addr
  val var8 = mem_global_2.r_data
  val mem_global_3 = Module(new ReadMem(494, 64, 1))
  val var9 = mem_global_3.r_en
  val var10 = mem_global_3.addr
  val var11 = mem_global_3.r_data
  val mem_global_4 = Module(new WriteMem(494, 64, 1))
  val var12 = mem_global_4.w_en
  val var13 = mem_global_4.addr
  val var14 = mem_global_4.w_data
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
    val var44 = Reg(UInt(32.W))
    val var45 = Reg(UInt(32.W))
    val var46 = Reg(UInt(32.W))
    val var47 = Reg(UInt(32.W))
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
    val var62 = Reg(UInt(32.W))
    val var63 = Reg(UInt(32.W))
    val var64 = Reg(UInt(32.W))
    val var65 = Reg(UInt(32.W))
    val var66 = Reg(UInt(32.W))
    val var67 = Reg(UInt(64.W))
    val var68 = Reg(UInt(64.W))
    val var69 = Reg(UInt(64.W))
    val mulf_outline_0_0 = Module(new MulFBase(9, 11, 53))
    mulf_outline_0_0.ce := true.B
    val var70 = mulf_outline_0_0.operand0
    var70 := DontCare
    val var71 = mulf_outline_0_0.operand1
    var71 := DontCare
    val var72 = mulf_outline_0_0.result
    val addf_outline_0_0 = Module(new AddSubFBase(13, 11, 53, true))
    addf_outline_0_0.ce := true.B
    val var73 = addf_outline_0_0.operand0
    var73 := DontCare
    val var74 = addf_outline_0_0.operand1
    var74 := DontCare
    val var75 = addf_outline_0_0.result
    val var76 = Reg(UInt(32.W))
    when (go) {
      var76 := var15
    }
    when (go) {
      var19 := var15
    }
    when (go) {
      var20 := var16
    }
    when (go) {
      var21 := var17
    }
    when (go) {
      var48 := 0.U
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
    val shift_register = RegInit(0.U(2.W))
    when (go) {
      when (var15 > var16) {
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
          var22 := var76
        }
        when (valid(14)) {
          var36 := var35
        }
      }
      when (counter === 1.U) {
        val var77 = var22 - var19
        when (valid(1)) {
          var62 := var77
        }
        val var78 = var77 + var19
        when (valid(1)) {
          var63 := var78
        }
        when (valid(1)) {
          var23 := var22
        }
        when (valid(1)) {
          var49 := var48
        }
        when (valid(15)) {
          var37 := var36
        }
      }
      when (counter === 2.U) {
        var4 := var63
        when (valid(2)) {
          var3 := 1.U
        }
        when (valid(2)) {
          var24 := var23
        }
        when (valid(2)) {
          var50 := var49
        }
        when (valid(2)) {
          var64 := var63
        }
        when (valid(16)) {
          var38 := var37
        }
      }
      when (counter === 3.U) {
        when (valid(3)) {
          var66 := var5
        }
        var1 := var64
        when (valid(3)) {
          var0 := 1.U
        }
        var10 := var5
        when (valid(3)) {
          var9 := 1.U
        }
        when (valid(3)) {
          var25 := var24
        }
        when (valid(3)) {
          var51 := var50
        }
        when (valid(3)) {
          var65 := var64
        }
        when (valid(17)) {
          var39 := var38
        }
      }
      when (counter === 4.U) {
        when (valid(4)) {
          var67 := var2
        }
        when (valid(4)) {
          var68 := var11
        }
        var70 := var2
        var71 := var11
        when (valid(4)) {
          var26 := var25
        }
        when (valid(4)) {
          var52 := var51
        }
        when (valid(18)) {
          var40 := var39
        }
      }
      when (counter === 5.U) {
        when (valid(5)) {
          var27 := var26
        }
        when (valid(5)) {
          var53 := var52
        }
        when (valid(19)) {
          var41 := var40
        }
      }
      when (counter === 6.U) {
        when (valid(6)) {
          var28 := var27
        }
        when (valid(6)) {
          var54 := var53
        }
        when (valid(20)) {
          var42 := var41
        }
      }
      when (counter === 7.U) {
        when (valid(7)) {
          var29 := var28
        }
        when (valid(7)) {
          var55 := var54
        }
        when (valid(21)) {
          var43 := var42
        }
      }
      when (counter === 8.U) {
        when (valid(8)) {
          var30 := var29
        }
        when (valid(8)) {
          var56 := var55
        }
        when (valid(22)) {
          var44 := var43
        }
      }
      when (counter === 9.U) {
        when (valid(9)) {
          var31 := var30
        }
        when (valid(9)) {
          var57 := var56
        }
        when (valid(23)) {
          var45 := var44
        }
      }
      when (counter === 10.U) {
        when (valid(10)) {
          var32 := var31
        }
        when (valid(10)) {
          var58 := var57
        }
        when (valid(24)) {
          var46 := var45
        }
      }
      when (counter === 11.U) {
        when (valid(11)) {
          var33 := var32
        }
        when (valid(11)) {
          var59 := var58
        }
        when (valid(25)) {
          var47 := var46
        }
      }
      when (counter === 12.U) {
        when (valid(12)) {
          var34 := var33
        }
        when (valid(12)) {
          var60 := var59
        }
        when (valid(26)) {
          var60 := var75
          var18 := var75
        }
      }
      when (counter === 13.U) {
        when (valid(13)) {
          var69 := var72
        }
        var73 := var60
        var74 := var72
        when (valid(13)) {
          var35 := var34
        }
        when (valid(13)) {
          var61 := var60
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
        ub_reg := var16
      }
      val step_reg = Reg(UInt(32.W))
      when (go) {
        step_reg := var17
      }
      val upper_bound = Mux(go, var16, ub_reg)
      val step = Mux(go, var17, step_reg)
      new_input := start
      when (start) {
        when (var76 <= upper_bound) {
          when (counter === 13.U) {
            var76 := var76 + step
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
    val var81 = Reg(UInt(32.W))
    val var82 = Reg(UInt(32.W))
    val var83 = Reg(UInt(64.W))
    val outline_0_0 = Module(new outline_0)
    outline_0_0.go := 0.U
    val var84 = outline_0_0.var15
    var84 := DontCare
    val var85 = outline_0_0.var16
    var85 := DontCare
    val var86 = outline_0_0.var17
    var86 := DontCare
    val var87 = outline_0_0.var18
    val var88 = outline_0_0.done
    val outline_0_0_var0 = IO(Output(UInt(1.W)))
    outline_0_0_var0 := outline_0_0.var0
    val outline_0_0_var1 = IO(Output(UInt(11.W)))
    outline_0_0_var1 := outline_0_0.var1
    val outline_0_0_var3 = IO(Output(UInt(1.W)))
    outline_0_0_var3 := outline_0_0.var3
    val outline_0_0_var4 = IO(Output(UInt(11.W)))
    outline_0_0_var4 := outline_0_0.var4
    val outline_0_0_var9 = IO(Output(UInt(1.W)))
    outline_0_0_var9 := outline_0_0.var9
    val outline_0_0_var10 = IO(Output(UInt(9.W)))
    outline_0_0_var10 := outline_0_0.var10
    val outline_0_0_var2 = IO(Input(UInt(64.W)))
    outline_0_0.var2 := outline_0_0_var2
    val outline_0_0_var5 = IO(Input(UInt(32.W)))
    outline_0_0.var5 := outline_0_0_var5
    val outline_0_0_var11 = IO(Input(UInt(64.W)))
    outline_0_0.var11 := outline_0_0_var11
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
      val s0, s1, s1_entry, s2, s3, s4, s5, s6, s6_wait, s7, s8, s9, s10 = Value
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
        val var89 = 0.U <= 493.U
        var79 := var89
        val var90 = !var89
        var80 := 0.U
        state := State.s2;
        when (var90.asBool()) {
          state := State.s10;
        }
      }
      is (State.s1_entry) {
        val var91 = !var79
        state := State.s2;
        when (var91.asBool()) {
          state := State.s10;
        }
      }
      is (State.s2) {
        var7 := var80
        var6 := true.B
        val var92 = var80 + 1.U
        var82 := var92
        state := State.s3;
      }
      is (State.s3) {
        var81 := var8
        var7 := var82
        var6 := true.B
        state := State.s4;
      }
      is (State.s4) {
        var82 := var8
        val var93 = var8 - 1.U
        var82 := var93
        state := State.s5;
      }
      is (State.s5) {
        state := State.s6;
      }
      is (State.s6) {
        var84 := var81
        var85 := var82
        var86 := 1.U
        outline_0_0.go := 1.U
        when (var88.asBool()) {
          var83 := var87
        }
        state := State.s6_wait;
        when (var88.asBool()) {
          state := State.s7;
        }
      }
      is (State.s6_wait) {
        when (var88.asBool()) {
          var83 := var87
        }
        when (var88.asBool()) {
          state := State.s7;
        }
      }
      is (State.s7) {
        state := State.s8;
      }
      is (State.s8) {
        var13 := var80
        var14 := var83
        var12 := true.B
        state := State.s9;
      }
      is (State.s9) {
        val var94 = var80 + 1.U
        var80 := var94
        val var95 = var94 <= 493.U
        var79 := var95
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
  mem_global_3.dataIn(0).valid := main.outline_0_0_var9
  mem_global_3.dataIn(0).bits := main.outline_0_0_var10
  mem_global_2.dataIn(0).valid := main.var6
  mem_global_2.dataIn(0).bits := main.var7
  mem_global_4.dataIn(0).valid := main.var12
  mem_global_4.dataIn(0).bits := main.var13
  mem_global_4.w_dataIn(0).bits := main.var14
  val go = IO(Input(Bool()))
  main.go := go
  val done = IO(Output(Bool()))
  done := main.done
  main.outline_0_0_var2 := var2
  main.outline_0_0_var5 := var5
  main.outline_0_0_var11 := var11
  main.var8 := var8
  val mem_global_4_test_addr = IO(Input(UInt(log2Ceil(494).W)))
  mem_global_4.test_addr := mem_global_4_test_addr
  val mem_global_4_test_data = IO(Output(UInt(64.W)))
  mem_global_4_test_data := mem_global_4.test_data
  mem_global_4.finished := done
  mem_global_0.initMem("data_set/spmv_crs_kernel/mem_0.txt")
  mem_global_1.initMem("data_set/spmv_crs_kernel/mem_1.txt")
  mem_global_2.initMem("data_set/spmv_crs_kernel/mem_2.txt")
  mem_global_3.initMem("data_set/spmv_crs_kernel/mem_3.txt")
}

