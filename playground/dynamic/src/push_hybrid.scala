import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class push_hybrid extends MultiIOModule {
  class submodule2 extends MultiIOModule {
    val new_input = Wire(Bool())
    new_input := false.B
    val done = Wire(Bool())
    done := false.B
    val new_output = IO(Output(Bool()))
    new_output := 0.U
    val d_var0 = IO(Flipped(DecoupledIO(UInt(64.W))))
    val var0 = d_var0.bits
    d_var0.ready := false.B
    val d_var1 = IO(Flipped(DecoupledIO(UInt(64.W))))
    val var1 = d_var1.bits
    d_var1.ready := false.B
    val d_var2 = IO(DecoupledIO(UInt(64.W)))
    val var2 = d_var2.bits
    var2 := DontCare
    d_var2.valid := false.B
    val all_valid = d_var0.valid & d_var1.valid
    val continue = d_var2.ready
    val go = all_valid
    val var3 = Reg(UInt(64.W))
    val var4 = Reg(UInt(64.W))
    val var5 = Reg(UInt(64.W))
    val var6 = Reg(UInt(64.W))
    val var7 = Reg(UInt(64.W))
    val var8 = Reg(UInt(1.W))
    val var9 = Reg(UInt(1.W))
    val var10 = Reg(UInt(1.W))
    val var11 = Reg(UInt(1.W))
    val var12 = Reg(UInt(1.W))
    val var13 = Reg(UInt(1.W))
    val var14 = Reg(UInt(1.W))
    val var15 = Reg(UInt(1.W))
    val var16 = Reg(UInt(1.W))
    val var17 = Reg(UInt(1.W))
    val var18 = Reg(UInt(1.W))
    val var19 = Reg(UInt(1.W))
    val var20 = Reg(UInt(64.W))
    val var21 = Reg(UInt(64.W))
    val var22 = Reg(UInt(64.W))
    val var23 = Reg(UInt(64.W))
    val var24 = Reg(UInt(64.W))
    val var25 = Reg(UInt(1.W))
    val var26 = Reg(UInt(64.W))
    val subf_submodule2_0 = Module(new AddSubFBase(13, 11, 53, false))
    subf_submodule2_0.ce := true.B
    val var27 = subf_submodule2_0.operand0
    var27 := DontCare
    val var28 = subf_submodule2_0.operand1
    var28 := DontCare
    val var29 = subf_submodule2_0.result
    val cmpf_submodule2_0 = Module(new CmpFBase(2, 11, 53))
    cmpf_submodule2_0.ce := true.B
    cmpf_submodule2_0.opcode := 2.U
    val var30 = cmpf_submodule2_0.operand0
    var30 := DontCare
    val var31 = cmpf_submodule2_0.operand1
    var31 := DontCare
    val var32 = cmpf_submodule2_0.result
    val addf_submodule2_0 = Module(new AddSubFBase(13, 11, 53, true))
    addf_submodule2_0.ce := true.B
    val var33 = addf_submodule2_0.operand0
    var33 := DontCare
    val var34 = addf_submodule2_0.operand1
    var34 := DontCare
    val var35 = addf_submodule2_0.result
    when (go & continue) {
      var3 := var0
    }
    when (go & continue) {
      var5 := var1
    }
    val shift_register = RegInit(0.U(16.W))
    def valid(stage: Int): Bool = {
      if (stage == 1) {
        shift_register(0)
      } else if (stage == 2) {
        shift_register(0)
      } else if (stage == 3) {
        shift_register(1)
      } else if (stage == 4) {
        shift_register(1)
      } else if (stage == 5) {
        shift_register(2)
      } else if (stage == 6) {
        shift_register(2)
      } else if (stage == 7) {
        shift_register(3)
      } else if (stage == 8) {
        shift_register(3)
      } else if (stage == 9) {
        shift_register(4)
      } else if (stage == 10) {
        shift_register(4)
      } else if (stage == 11) {
        shift_register(5)
      } else if (stage == 12) {
        shift_register(5)
      } else if (stage == 13) {
        shift_register(6)
      } else if (stage == 14) {
        shift_register(6)
      } else if (stage == 15) {
        shift_register(7)
      } else if (stage == 16) {
        shift_register(7)
      } else if (stage == 17) {
        shift_register(8)
      } else if (stage == 18) {
        shift_register(8)
      } else if (stage == 19) {
        shift_register(9)
      } else if (stage == 20) {
        shift_register(9)
      } else if (stage == 21) {
        shift_register(10)
      } else if (stage == 22) {
        shift_register(10)
      } else if (stage == 23) {
        shift_register(11)
      } else if (stage == 24) {
        shift_register(11)
      } else if (stage == 25) {
        shift_register(12)
      } else if (stage == 26) {
        shift_register(12)
      } else if (stage == 27) {
        shift_register(13)
      } else if (stage == 28) {
        shift_register(13)
      } else if (stage == 29) {
        shift_register(14)
      } else if (stage == 30) {
        shift_register(14)
      } else {
        new_input
      }
    }
    val counter = RegInit(0.U(1.W))
    when (continue) {
      when (new_input || shift_register =/= 0.U) {
        when (counter === 1.U) {
          counter := 0.U
          }.otherwise {
            counter := counter + 1.U
          }
          }.otherwise {
            counter := 0.U
          }
          new_input := all_valid & (counter === 0.U)
          when (counter === 0.U) {
            shift_register := Cat(shift_register(14, 0), new_input)
          }
          when (counter === 0.U) {
            when (valid(14)) {
              var7 := var29
            }
            var30 := var29
            var31 := 0L.U
            var27 := 4607182418800017408L.U
            var28 := var29
            var33 := 4607182418800017408L.U
            var34 := var29
            when (valid(16)) {
              var8 := var32
            }
            when (valid(18)) {
              var10 := var9
            }
            when (valid(20)) {
              var12 := var11
            }
            when (valid(22)) {
              var14 := var13
            }
            when (valid(24)) {
              var16 := var15
            }
            when (valid(26)) {
              var18 := var17
            }
            when (valid(28)) {
              var23 := var22
            }
            new_output := valid(30)
            var2 := var26
          }
          when (counter === 1.U) {
            var27 := var3
            var28 := var5
            when (valid(1)) {
              var4 := var3
            }
            when (valid(1)) {
              var6 := var5
            }
            when (valid(17)) {
              var9 := var8
            }
            when (valid(19)) {
              var11 := var10
            }
            when (valid(21)) {
              var13 := var12
            }
            when (valid(23)) {
              var15 := var14
            }
            when (valid(25)) {
              var17 := var16
            }
            when (valid(27)) {
              var20 := var29
            }
            when (valid(27)) {
              var21 := var35
            }
            val var36 = Mux(var18.asBool(), var29, var35)
            when (valid(27)) {
              var22 := var36
            }
            var30 := var36
            var31 := 0L.U
            when (valid(27)) {
              var19 := var18
            }
            when (valid(29)) {
              var25 := var32
            }
            val var37 = Mux(var32.asBool(), var23, 0L.U)
            when (valid(29)) {
              var26 := var37
            }
            when (valid(29)) {
              var24 := var23
            }
          }
          when (counter === 0.U && valid(30)) {
            done := true.B
          }
    }
    when (continue) {
      when (counter === 0.U) {
        d_var0.ready := all_valid
        d_var1.ready := all_valid
      }
      d_var2.valid := done
    }
  }
  class submodule3 extends MultiIOModule {
    val new_input = Wire(Bool())
    new_input := false.B
    val done = Wire(Bool())
    done := false.B
    val new_output = IO(Output(Bool()))
    new_output := 0.U
    val d_var38 = IO(Flipped(DecoupledIO(UInt(64.W))))
    val var38 = d_var38.bits
    d_var38.ready := false.B
    val d_var39 = IO(Flipped(DecoupledIO(UInt(64.W))))
    val var39 = d_var39.bits
    d_var39.ready := false.B
    val d_var40 = IO(DecoupledIO(UInt(64.W)))
    val var40 = d_var40.bits
    var40 := DontCare
    d_var40.valid := false.B
    val all_valid = d_var38.valid & d_var39.valid
    val continue = d_var40.ready
    val go = all_valid
    val var41 = Reg(UInt(64.W))
    val var42 = Reg(UInt(64.W))
    val var43 = Reg(UInt(64.W))
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
    val var87 = Reg(UInt(64.W))
    val var88 = Reg(UInt(64.W))
    val var89 = Reg(UInt(64.W))
    val subf_submodule3_0 = Module(new AddSubFBase(13, 11, 53, false))
    subf_submodule3_0.ce := true.B
    val var90 = subf_submodule3_0.operand0
    var90 := DontCare
    val var91 = subf_submodule3_0.operand1
    var91 := DontCare
    val var92 = subf_submodule3_0.result
    val divf_submodule3_0 = Module(new DivFBase(30, 11, 53))
    divf_submodule3_0.ce := true.B
    val var93 = divf_submodule3_0.operand0
    var93 := DontCare
    val var94 = divf_submodule3_0.operand1
    var94 := DontCare
    val var95 = divf_submodule3_0.result
    val addf_submodule3_0 = Module(new AddSubFBase(13, 11, 53, true))
    addf_submodule3_0.ce := true.B
    val var96 = addf_submodule3_0.operand0
    var96 := DontCare
    val var97 = addf_submodule3_0.operand1
    var97 := DontCare
    val var98 = addf_submodule3_0.result
    when (go & continue) {
      var41 := var38
    }
    when (go & continue) {
      var43 := var39
    }
    val shift_register = RegInit(0.U(29.W))
    def valid(stage: Int): Bool = {
      if (stage == 1) {
        shift_register(0)
      } else if (stage == 2) {
        shift_register(0)
      } else if (stage == 3) {
        shift_register(1)
      } else if (stage == 4) {
        shift_register(1)
      } else if (stage == 5) {
        shift_register(2)
      } else if (stage == 6) {
        shift_register(2)
      } else if (stage == 7) {
        shift_register(3)
      } else if (stage == 8) {
        shift_register(3)
      } else if (stage == 9) {
        shift_register(4)
      } else if (stage == 10) {
        shift_register(4)
      } else if (stage == 11) {
        shift_register(5)
      } else if (stage == 12) {
        shift_register(5)
      } else if (stage == 13) {
        shift_register(6)
      } else if (stage == 14) {
        shift_register(6)
      } else if (stage == 15) {
        shift_register(7)
      } else if (stage == 16) {
        shift_register(7)
      } else if (stage == 17) {
        shift_register(8)
      } else if (stage == 18) {
        shift_register(8)
      } else if (stage == 19) {
        shift_register(9)
      } else if (stage == 20) {
        shift_register(9)
      } else if (stage == 21) {
        shift_register(10)
      } else if (stage == 22) {
        shift_register(10)
      } else if (stage == 23) {
        shift_register(11)
      } else if (stage == 24) {
        shift_register(11)
      } else if (stage == 25) {
        shift_register(12)
      } else if (stage == 26) {
        shift_register(12)
      } else if (stage == 27) {
        shift_register(13)
      } else if (stage == 28) {
        shift_register(13)
      } else if (stage == 29) {
        shift_register(14)
      } else if (stage == 30) {
        shift_register(14)
      } else if (stage == 31) {
        shift_register(15)
      } else if (stage == 32) {
        shift_register(15)
      } else if (stage == 33) {
        shift_register(16)
      } else if (stage == 34) {
        shift_register(16)
      } else if (stage == 35) {
        shift_register(17)
      } else if (stage == 36) {
        shift_register(17)
      } else if (stage == 37) {
        shift_register(18)
      } else if (stage == 38) {
        shift_register(18)
      } else if (stage == 39) {
        shift_register(19)
      } else if (stage == 40) {
        shift_register(19)
      } else if (stage == 41) {
        shift_register(20)
      } else if (stage == 42) {
        shift_register(20)
      } else if (stage == 43) {
        shift_register(21)
      } else if (stage == 44) {
        shift_register(21)
      } else if (stage == 45) {
        shift_register(22)
      } else if (stage == 46) {
        shift_register(22)
      } else if (stage == 47) {
        shift_register(23)
      } else if (stage == 48) {
        shift_register(23)
      } else if (stage == 49) {
        shift_register(24)
      } else if (stage == 50) {
        shift_register(24)
      } else if (stage == 51) {
        shift_register(25)
      } else if (stage == 52) {
        shift_register(25)
      } else if (stage == 53) {
        shift_register(26)
      } else if (stage == 54) {
        shift_register(26)
      } else if (stage == 55) {
        shift_register(27)
      } else if (stage == 56) {
        shift_register(27)
      } else if (stage == 57) {
        shift_register(28)
      } else {
        new_input
      }
    }
    val counter = RegInit(0.U(1.W))
    when (continue) {
      when (new_input || shift_register =/= 0.U) {
        when (counter === 1.U) {
          counter := 0.U
          }.otherwise {
            counter := counter + 1.U
          }
          }.otherwise {
            counter := 0.U
          }
          new_input := all_valid & (counter === 0.U)
          when (counter === 0.U) {
            shift_register := Cat(shift_register(27, 0), new_input)
          }
          when (counter === 0.U) {
            when (valid(2)) {
              var45 := var44
            }
            when (valid(4)) {
              var47 := var46
            }
            when (valid(6)) {
              var49 := var48
            }
            when (valid(8)) {
              var51 := var50
            }
            when (valid(10)) {
              var53 := var52
            }
            when (valid(12)) {
              var55 := var54
            }
            when (valid(14)) {
              var88 := var92
            }
            var93 := var92
            var94 := 4636350340667277731L.U
            when (valid(14)) {
              var57 := var56
            }
            when (valid(16)) {
              var59 := var58
            }
            when (valid(18)) {
              var61 := var60
            }
            when (valid(20)) {
              var63 := var62
            }
            when (valid(22)) {
              var65 := var64
            }
            when (valid(24)) {
              var67 := var66
            }
            when (valid(26)) {
              var69 := var68
            }
            when (valid(28)) {
              var71 := var70
            }
            when (valid(30)) {
              var73 := var72
            }
            when (valid(32)) {
              var75 := var74
            }
            when (valid(34)) {
              var77 := var76
            }
            when (valid(36)) {
              var79 := var78
            }
            when (valid(38)) {
              var81 := var80
            }
            when (valid(40)) {
              var83 := var82
            }
            when (valid(42)) {
              var85 := var84
            }
            when (valid(44)) {
              var89 := var95
            }
            var96 := var86
            var97 := var95
            when (valid(44)) {
              var87 := var86
            }
          }
          when (counter === 1.U) {
            var90 := var41
            var91 := 4591705168176610867L.U
            when (valid(1)) {
              var42 := var41
            }
            when (valid(1)) {
              var44 := var43
            }
            when (valid(3)) {
              var46 := var45
            }
            when (valid(5)) {
              var48 := var47
            }
            when (valid(7)) {
              var50 := var49
            }
            when (valid(9)) {
              var52 := var51
            }
            when (valid(11)) {
              var54 := var53
            }
            when (valid(13)) {
              var56 := var55
            }
            when (valid(15)) {
              var58 := var57
            }
            when (valid(17)) {
              var60 := var59
            }
            when (valid(19)) {
              var62 := var61
            }
            when (valid(21)) {
              var64 := var63
            }
            when (valid(23)) {
              var66 := var65
            }
            when (valid(25)) {
              var68 := var67
            }
            when (valid(27)) {
              var70 := var69
            }
            when (valid(29)) {
              var72 := var71
            }
            when (valid(31)) {
              var74 := var73
            }
            when (valid(33)) {
              var76 := var75
            }
            when (valid(35)) {
              var78 := var77
            }
            when (valid(37)) {
              var80 := var79
            }
            when (valid(39)) {
              var82 := var81
            }
            when (valid(41)) {
              var84 := var83
            }
            when (valid(43)) {
              var86 := var85
            }
            new_output := valid(57)
            var40 := var98
          }
          when (counter === 1.U && valid(57)) {
            done := true.B
          }
    }
    when (continue) {
      when (counter === 0.U) {
        d_var38.ready := all_valid
        d_var39.ready := all_valid
      }
      d_var40.valid := done
    }
  }
  val var99 = IO(Flipped(DecoupledIO(UInt(0.W))))
  val var100 = IO(DecoupledIO(UInt(64.W)))
  var100 := DontCare
  val var101 = IO(DecoupledIO(UInt(0.W)))
  var101 := DontCare
  val mem_0 = Module(new DynMem(2,0)(1024,64))
  val var102 = mem_0.load_address apply 0
  var102 := DontCare
  val var103 = mem_0.load_data apply 0
  var103 := DontCare
  val var104 = mem_0.load_address apply 1
  var104 := DontCare
  val var105 = mem_0.load_data apply 1
  var105 := DontCare
  val mem_1 = Module(new DynMem(2,0)(1024,32))
  val var106 = mem_1.load_address apply 0
  var106 := DontCare
  val var107 = mem_1.load_data apply 0
  var107 := DontCare
  val var108 = mem_1.load_address apply 1
  var108 := DontCare
  val var109 = mem_1.load_data apply 1
  var109 := DontCare
  val cmpi_sle_2 = Module(new LessEqualthanIDynamic(32))
  val var110 = cmpi_sle_2.operand0
  var110 := DontCare
  val var111 = cmpi_sle_2.operand1
  var111 := DontCare
  val var112 = cmpi_sle_2.result
  var112 := DontCare
  val m_3 = Module(new Control_Merge(0))
  val var113 = m_3.dataIn apply 0
  var113 := DontCare
  val var114 = m_3.dataIn apply 1
  var114 := DontCare
  val var115 = m_3.dataOut
  var115 := DontCare
  val var116 = m_3.condition
  var116 := DontCare
  val buf_4 = Module(new ElasticBuffer(0))
  val var117 = buf_4.dataIn
  var117 := DontCare
  val var118 = buf_4.dataOut
  var118 := DontCare
  val b_5 = Module(new Branch(0))
  val var119 = b_5.condition
  var119 := DontCare
  val var120 = b_5.dataIn
  var120 := DontCare
  val var121 = b_5.dataOut apply 0
  var121 := DontCare
  val var122 = b_5.dataOut apply 1
  var122 := DontCare
  val m_6 = Module(new MuxDynamic(64)())
  val var123 = m_6.dataIn apply 0
  var123 := DontCare
  val var124 = m_6.dataIn apply 1
  var124 := DontCare
  val var125 = m_6.dataOut
  var125 := DontCare
  val var126 = m_6.condition
  var126 := DontCare
  val buf_7 = Module(new ElasticBuffer(64))
  val var127 = buf_7.dataIn
  var127 := DontCare
  val var128 = buf_7.dataOut
  var128 := DontCare
  val b_8 = Module(new Branch(64))
  val var129 = b_8.condition
  var129 := DontCare
  val var130 = b_8.dataIn
  var130 := DontCare
  val var131 = b_8.dataOut apply 0
  var131 := DontCare
  val var132 = b_8.dataOut apply 1
  var132 := DontCare
  val const_9 = Module(new Constant(64))
  val var133 = const_9.control
  var133 := DontCare
  val var134 = const_9.dataIn
  var134 := DontCare
  val var135 = const_9.dataOut
  var135 := DontCare
  val const_10 = Module(new Constant(32))
  val var136 = const_10.control
  var136 := DontCare
  val var137 = const_10.dataIn
  var137 := DontCare
  val var138 = const_10.dataOut
  var138 := DontCare
  val m_11 = Module(new MuxDynamic(32)())
  val var139 = m_11.dataIn apply 0
  var139 := DontCare
  val var140 = m_11.dataIn apply 1
  var140 := DontCare
  val var141 = m_11.dataOut
  var141 := DontCare
  val var142 = m_11.condition
  var142 := DontCare
  val buf_12 = Module(new ElasticBuffer(32))
  val var143 = buf_12.dataIn
  var143 := DontCare
  val var144 = buf_12.dataOut
  var144 := DontCare
  val b_13 = Module(new Branch(32))
  val var145 = b_13.condition
  var145 := DontCare
  val var146 = b_13.dataIn
  var146 := DontCare
  val var147 = b_13.dataOut apply 0
  var147 := DontCare
  val var148 = b_13.dataOut apply 1
  var148 := DontCare
  val const_14 = Module(new Constant(32))
  val var149 = const_14.control
  var149 := DontCare
  val var150 = const_14.dataIn
  var150 := DontCare
  val var151 = const_14.dataOut
  var151 := DontCare
  val m_15 = Module(new MuxDynamic(32)())
  val var152 = m_15.dataIn apply 0
  var152 := DontCare
  val var153 = m_15.dataIn apply 1
  var153 := DontCare
  val var154 = m_15.dataOut
  var154 := DontCare
  val var155 = m_15.condition
  var155 := DontCare
  val buf_16 = Module(new ElasticBuffer(32))
  val var156 = buf_16.dataIn
  var156 := DontCare
  val var157 = buf_16.dataOut
  var157 := DontCare
  val b_17 = Module(new Branch(32))
  val var158 = b_17.condition
  var158 := DontCare
  val var159 = b_17.dataIn
  var159 := DontCare
  val var160 = b_17.dataOut apply 0
  var160 := DontCare
  val var161 = b_17.dataOut apply 1
  var161 := DontCare
  val const_18 = Module(new Constant(32))
  val var162 = const_18.control
  var162 := DontCare
  val var163 = const_18.dataIn
  var163 := DontCare
  val var164 = const_18.dataOut
  var164 := DontCare
  val m_19 = Module(new MuxDynamic(32)())
  val var165 = m_19.dataIn apply 0
  var165 := DontCare
  val var166 = m_19.dataIn apply 1
  var166 := DontCare
  val var167 = m_19.dataOut
  var167 := DontCare
  val var168 = m_19.condition
  var168 := DontCare
  val buf_20 = Module(new ElasticBuffer(32))
  val var169 = buf_20.dataIn
  var169 := DontCare
  val var170 = buf_20.dataOut
  var170 := DontCare
  val b_21 = Module(new Branch(32))
  val var171 = b_21.condition
  var171 := DontCare
  val var172 = b_21.dataIn
  var172 := DontCare
  val var173 = b_21.dataOut apply 0
  var173 := DontCare
  val var174 = b_21.dataOut apply 1
  var174 := DontCare
  val addi_22 = Module(new AddIDynamic(32))
  val var175 = addi_22.operand0
  var175 := DontCare
  val var176 = addi_22.operand1
  var176 := DontCare
  val var177 = addi_22.result
  var177 := DontCare
  val load_23 = Module(new Load(1024,32))
  val var178 = load_23.address_in
  var178 := DontCare
  val var179 = load_23.data_out
  var179 := DontCare
  val var180 = load_23.address_out
  var180 := DontCare
  val var181 = load_23.data_in
  var181 := DontCare
  val var182 = load_23.control
  var182 := DontCare
  val trunci_24 = Module(new TruncIDynamic(32,1))
  val var183 = trunci_24.operand
  var183 := DontCare
  val var184 = trunci_24.result
  var184 := DontCare
  val b_25 = Module(new Branch(0))
  val var185 = b_25.condition
  var185 := DontCare
  val var186 = b_25.dataIn
  var186 := DontCare
  val var187 = b_25.dataOut apply 0
  var187 := DontCare
  val var188 = b_25.dataOut apply 1
  var188 := DontCare
  val b_26 = Module(new Branch(32))
  val var189 = b_26.condition
  var189 := DontCare
  val var190 = b_26.dataIn
  var190 := DontCare
  val var191 = b_26.dataOut apply 0
  var191 := DontCare
  val var192 = b_26.dataOut apply 1
  var192 := DontCare
  val b_27 = Module(new Branch(64))
  val var193 = b_27.condition
  var193 := DontCare
  val var194 = b_27.dataIn
  var194 := DontCare
  val var195 = b_27.dataOut apply 0
  var195 := DontCare
  val var196 = b_27.dataOut apply 1
  var196 := DontCare
  val m_28 = Module(new MuxDynamic(64)())
  val var197 = m_28.dataIn apply 0
  var197 := DontCare
  val var198 = m_28.dataIn apply 1
  var198 := DontCare
  val var199 = m_28.dataOut
  var199 := DontCare
  val var200 = m_28.condition
  var200 := DontCare
  val cmpi_sle_29 = Module(new LessEqualthanIDynamic(32))
  val var201 = cmpi_sle_29.operand0
  var201 := DontCare
  val var202 = cmpi_sle_29.operand1
  var202 := DontCare
  val var203 = cmpi_sle_29.result
  var203 := DontCare
  val m_30 = Module(new Control_Merge(0))
  val var204 = m_30.dataIn apply 0
  var204 := DontCare
  val var205 = m_30.dataIn apply 1
  var205 := DontCare
  val var206 = m_30.dataOut
  var206 := DontCare
  val var207 = m_30.condition
  var207 := DontCare
  val buf_31 = Module(new ElasticBuffer(0))
  val var208 = buf_31.dataIn
  var208 := DontCare
  val var209 = buf_31.dataOut
  var209 := DontCare
  val b_32 = Module(new Branch(0))
  val var210 = b_32.condition
  var210 := DontCare
  val var211 = b_32.dataIn
  var211 := DontCare
  val var212 = b_32.dataOut apply 0
  var212 := DontCare
  val var213 = b_32.dataOut apply 1
  var213 := DontCare
  val m_33 = Module(new MuxDynamic(64)())
  val var214 = m_33.dataIn apply 0
  var214 := DontCare
  val var215 = m_33.dataIn apply 1
  var215 := DontCare
  val var216 = m_33.dataOut
  var216 := DontCare
  val var217 = m_33.condition
  var217 := DontCare
  val buf_34 = Module(new ElasticBuffer(64))
  val var218 = buf_34.dataIn
  var218 := DontCare
  val var219 = buf_34.dataOut
  var219 := DontCare
  val b_35 = Module(new Branch(64))
  val var220 = b_35.condition
  var220 := DontCare
  val var221 = b_35.dataIn
  var221 := DontCare
  val var222 = b_35.dataOut apply 0
  var222 := DontCare
  val var223 = b_35.dataOut apply 1
  var223 := DontCare
  val const_36 = Module(new Constant(32))
  val var224 = const_36.control
  var224 := DontCare
  val var225 = const_36.dataIn
  var225 := DontCare
  val var226 = const_36.dataOut
  var226 := DontCare
  val m_37 = Module(new MuxDynamic(32)())
  val var227 = m_37.dataIn apply 0
  var227 := DontCare
  val var228 = m_37.dataIn apply 1
  var228 := DontCare
  val var229 = m_37.dataOut
  var229 := DontCare
  val var230 = m_37.condition
  var230 := DontCare
  val buf_38 = Module(new ElasticBuffer(32))
  val var231 = buf_38.dataIn
  var231 := DontCare
  val var232 = buf_38.dataOut
  var232 := DontCare
  val b_39 = Module(new Branch(32))
  val var233 = b_39.condition
  var233 := DontCare
  val var234 = b_39.dataIn
  var234 := DontCare
  val var235 = b_39.dataOut apply 0
  var235 := DontCare
  val var236 = b_39.dataOut apply 1
  var236 := DontCare
  val const_40 = Module(new Constant(32))
  val var237 = const_40.control
  var237 := DontCare
  val var238 = const_40.dataIn
  var238 := DontCare
  val var239 = const_40.dataOut
  var239 := DontCare
  val m_41 = Module(new MuxDynamic(32)())
  val var240 = m_41.dataIn apply 0
  var240 := DontCare
  val var241 = m_41.dataIn apply 1
  var241 := DontCare
  val var242 = m_41.dataOut
  var242 := DontCare
  val var243 = m_41.condition
  var243 := DontCare
  val buf_42 = Module(new ElasticBuffer(32))
  val var244 = buf_42.dataIn
  var244 := DontCare
  val var245 = buf_42.dataOut
  var245 := DontCare
  val b_43 = Module(new Branch(32))
  val var246 = b_43.condition
  var246 := DontCare
  val var247 = b_43.dataIn
  var247 := DontCare
  val var248 = b_43.dataOut apply 0
  var248 := DontCare
  val var249 = b_43.dataOut apply 1
  var249 := DontCare
  val const_44 = Module(new Constant(32))
  val var250 = const_44.control
  var250 := DontCare
  val var251 = const_44.dataIn
  var251 := DontCare
  val var252 = const_44.dataOut
  var252 := DontCare
  val m_45 = Module(new MuxDynamic(32)())
  val var253 = m_45.dataIn apply 0
  var253 := DontCare
  val var254 = m_45.dataIn apply 1
  var254 := DontCare
  val var255 = m_45.dataOut
  var255 := DontCare
  val var256 = m_45.condition
  var256 := DontCare
  val buf_46 = Module(new ElasticBuffer(32))
  val var257 = buf_46.dataIn
  var257 := DontCare
  val var258 = buf_46.dataOut
  var258 := DontCare
  val b_47 = Module(new Branch(32))
  val var259 = b_47.condition
  var259 := DontCare
  val var260 = b_47.dataIn
  var260 := DontCare
  val var261 = b_47.dataOut apply 0
  var261 := DontCare
  val var262 = b_47.dataOut apply 1
  var262 := DontCare
  val m_48 = Module(new MuxDynamic(32)())
  val var263 = m_48.dataIn apply 0
  var263 := DontCare
  val var264 = m_48.dataIn apply 1
  var264 := DontCare
  val var265 = m_48.dataOut
  var265 := DontCare
  val var266 = m_48.condition
  var266 := DontCare
  val buf_49 = Module(new ElasticBuffer(32))
  val var267 = buf_49.dataIn
  var267 := DontCare
  val var268 = buf_49.dataOut
  var268 := DontCare
  val b_50 = Module(new Branch(32))
  val var269 = b_50.condition
  var269 := DontCare
  val var270 = b_50.dataIn
  var270 := DontCare
  val var271 = b_50.dataOut apply 0
  var271 := DontCare
  val var272 = b_50.dataOut apply 1
  var272 := DontCare
  val addi_51 = Module(new AddIDynamic(32))
  val var273 = addi_51.operand0
  var273 := DontCare
  val var274 = addi_51.operand1
  var274 := DontCare
  val var275 = addi_51.result
  var275 := DontCare
  val load_52 = Module(new Load(1024,64))
  val var276 = load_52.address_in
  var276 := DontCare
  val var277 = load_52.data_out
  var277 := DontCare
  val var278 = load_52.address_out
  var278 := DontCare
  val var279 = load_52.data_in
  var279 := DontCare
  val var280 = load_52.control
  var280 := DontCare
  val load_53 = Module(new Load(1024,64))
  val var281 = load_53.address_in
  var281 := DontCare
  val var282 = load_53.data_out
  var282 := DontCare
  val var283 = load_53.address_out
  var283 := DontCare
  val var284 = load_53.data_in
  var284 := DontCare
  val var285 = load_53.control
  var285 := DontCare
  val submodule2_0 = Module(new submodule2)
  val var286 = submodule2_0.d_var0
  var286 := DontCare
  val var287 = submodule2_0.d_var1
  var287 := DontCare
  val var288 = submodule2_0.d_var2
  val load_54 = Module(new Load(1024,32))
  val var289 = load_54.address_in
  var289 := DontCare
  val var290 = load_54.data_out
  var290 := DontCare
  val var291 = load_54.address_out
  var291 := DontCare
  val var292 = load_54.data_in
  var292 := DontCare
  val var293 = load_54.control
  var293 := DontCare
  val trunci_55 = Module(new TruncIDynamic(32,1))
  val var294 = trunci_55.operand
  var294 := DontCare
  val var295 = trunci_55.result
  var295 := DontCare
  val cmpi_56 = Module(new NotEqualIDynamic(32))
  val var296 = cmpi_56.operand0
  var296 := DontCare
  val var297 = cmpi_56.operand1
  var297 := DontCare
  val var298 = cmpi_56.result
  var298 := DontCare
  val and_57 = Module(new AndDynamic(1))
  val var299 = and_57.operand0
  var299 := DontCare
  val var300 = and_57.operand1
  var300 := DontCare
  val var301 = and_57.result
  var301 := DontCare
  val b_58 = Module(new Branch(0))
  val var302 = b_58.condition
  var302 := DontCare
  val var303 = b_58.dataIn
  var303 := DontCare
  val var304 = b_58.dataOut apply 0
  var304 := DontCare
  val var305 = b_58.dataOut apply 1
  var305 := DontCare
  val b_59 = Module(new Branch(64))
  val var306 = b_59.condition
  var306 := DontCare
  val var307 = b_59.dataIn
  var307 := DontCare
  val var308 = b_59.dataOut apply 0
  var308 := DontCare
  val var309 = b_59.dataOut apply 1
  var309 := DontCare
  val b_60 = Module(new Branch(64))
  val var310 = b_60.condition
  var310 := DontCare
  val var311 = b_60.dataIn
  var311 := DontCare
  val var312 = b_60.dataOut apply 0
  var312 := DontCare
  val var313 = b_60.dataOut apply 1
  var313 := DontCare
  val m_61 = Module(new MuxDynamic(64)())
  val var314 = m_61.dataIn apply 0
  var314 := DontCare
  val var315 = m_61.dataIn apply 1
  var315 := DontCare
  val var316 = m_61.dataOut
  var316 := DontCare
  val var317 = m_61.condition
  var317 := DontCare
  val submodule3_0 = Module(new submodule3)
  val var318 = submodule3_0.d_var38
  var318 := DontCare
  val var319 = submodule3_0.d_var39
  var319 := DontCare
  val var320_tmp = submodule3_0.d_var40
  val var320_buf = Module(new ElasticFIFO(1, 64))
  val var320 = var320_buf.dataOut
  var320_tmp <> var320_buf.dataIn
  val f_62 = Module(new Fork(1)(5))
  val var321 = f_62.dataIn
  var321 := DontCare
  val var322 = f_62.dataOut apply 0
  var322 := DontCare
  val var323 = f_62.dataOut apply 1
  var323 := DontCare
  val var324 = f_62.dataOut apply 2
  var324 := DontCare
  val var325 = f_62.dataOut apply 3
  var325 := DontCare
  val var326 = f_62.dataOut apply 4
  var326 := DontCare
  val f_63 = Module(new Fork(1)(4))
  val var327 = f_63.dataIn
  var327 := DontCare
  val var328 = f_63.dataOut apply 0
  var328 := DontCare
  val var329 = f_63.dataOut apply 1
  var329 := DontCare
  val var330 = f_63.dataOut apply 2
  var330 := DontCare
  val var331 = f_63.dataOut apply 3
  var331 := DontCare
  val f_64 = Module(new Fork(0)(3))
  val var332 = f_64.dataIn
  var332 := DontCare
  val var333 = f_64.dataOut apply 0
  var333 := DontCare
  val var334 = f_64.dataOut apply 1
  var334 := DontCare
  val var335 = f_64.dataOut apply 2
  var335 := DontCare
  val f_65 = Module(new Fork(32)(2))
  val var336 = f_65.dataIn
  var336 := DontCare
  val var337 = f_65.dataOut apply 0
  var337 := DontCare
  val var338 = f_65.dataOut apply 1
  var338 := DontCare
  val f_66 = Module(new Fork(32)(2))
  val var339 = f_66.dataIn
  var339 := DontCare
  val var340 = f_66.dataOut apply 0
  var340 := DontCare
  val var341 = f_66.dataOut apply 1
  var341 := DontCare
  val f_67 = Module(new Fork(32)(2))
  val var342 = f_67.dataIn
  var342 := DontCare
  val var343 = f_67.dataOut apply 0
  var343 := DontCare
  val var344 = f_67.dataOut apply 1
  var344 := DontCare
  val f_68 = Module(new Fork(32)(3))
  val var345 = f_68.dataIn
  var345 := DontCare
  val var346 = f_68.dataOut apply 0
  var346 := DontCare
  val var347 = f_68.dataOut apply 1
  var347 := DontCare
  val var348 = f_68.dataOut apply 2
  var348 := DontCare
  val f_69 = Module(new Fork(1)(4))
  val var349 = f_69.dataIn
  var349 := DontCare
  val var350 = f_69.dataOut apply 0
  var350 := DontCare
  val var351 = f_69.dataOut apply 1
  var351 := DontCare
  val var352 = f_69.dataOut apply 2
  var352 := DontCare
  val var353 = f_69.dataOut apply 3
  var353 := DontCare
  val f_70 = Module(new Fork(0)(4))
  val var354 = f_70.dataIn
  var354 := DontCare
  val var355 = f_70.dataOut apply 0
  var355 := DontCare
  val var356 = f_70.dataOut apply 1
  var356 := DontCare
  val var357 = f_70.dataOut apply 2
  var357 := DontCare
  val var358 = f_70.dataOut apply 3
  var358 := DontCare
  val f_71 = Module(new Fork(1)(6))
  val var359 = f_71.dataIn
  var359 := DontCare
  val var360 = f_71.dataOut apply 0
  var360 := DontCare
  val var361 = f_71.dataOut apply 1
  var361 := DontCare
  val var362 = f_71.dataOut apply 2
  var362 := DontCare
  val var363 = f_71.dataOut apply 3
  var363 := DontCare
  val var364 = f_71.dataOut apply 4
  var364 := DontCare
  val var365 = f_71.dataOut apply 5
  var365 := DontCare
  val f_72 = Module(new Fork(1)(5))
  val var366 = f_72.dataIn
  var366 := DontCare
  val var367 = f_72.dataOut apply 0
  var367 := DontCare
  val var368 = f_72.dataOut apply 1
  var368 := DontCare
  val var369 = f_72.dataOut apply 2
  var369 := DontCare
  val var370 = f_72.dataOut apply 3
  var370 := DontCare
  val var371 = f_72.dataOut apply 4
  var371 := DontCare
  val f_73 = Module(new Fork(0)(5))
  val var372 = f_73.dataIn
  var372 := DontCare
  val var373 = f_73.dataOut apply 0
  var373 := DontCare
  val var374 = f_73.dataOut apply 1
  var374 := DontCare
  val var375 = f_73.dataOut apply 2
  var375 := DontCare
  val var376 = f_73.dataOut apply 3
  var376 := DontCare
  val var377 = f_73.dataOut apply 4
  var377 := DontCare
  val f_74 = Module(new Fork(32)(2))
  val var378 = f_74.dataIn
  var378 := DontCare
  val var379 = f_74.dataOut apply 0
  var379 := DontCare
  val var380 = f_74.dataOut apply 1
  var380 := DontCare
  val f_75 = Module(new Fork(32)(2))
  val var381 = f_75.dataIn
  var381 := DontCare
  val var382 = f_75.dataOut apply 0
  var382 := DontCare
  val var383 = f_75.dataOut apply 1
  var383 := DontCare
  val f_76 = Module(new Fork(32)(3))
  val var384 = f_76.dataIn
  var384 := DontCare
  val var385 = f_76.dataOut apply 0
  var385 := DontCare
  val var386 = f_76.dataOut apply 1
  var386 := DontCare
  val var387 = f_76.dataOut apply 2
  var387 := DontCare
  val f_77 = Module(new Fork(32)(2))
  val var388 = f_77.dataIn
  var388 := DontCare
  val var389 = f_77.dataOut apply 0
  var389 := DontCare
  val var390 = f_77.dataOut apply 1
  var390 := DontCare
  val f_78 = Module(new Fork(32)(4))
  val var391 = f_78.dataIn
  var391 := DontCare
  val var392 = f_78.dataOut apply 0
  var392 := DontCare
  val var393 = f_78.dataOut apply 1
  var393 := DontCare
  val var394 = f_78.dataOut apply 2
  var394 := DontCare
  val var395 = f_78.dataOut apply 3
  var395 := DontCare
  val f_79 = Module(new Fork(1)(4))
  val var396 = f_79.dataIn
  var396 := DontCare
  val var397 = f_79.dataOut apply 0
  var397 := DontCare
  val var398 = f_79.dataOut apply 1
  var398 := DontCare
  val var399 = f_79.dataOut apply 2
  var399 := DontCare
  val var400 = f_79.dataOut apply 3
  var400 := DontCare
  val fifo_80 = Module(new ElasticFIFO(57,64))
  val var401 = fifo_80.dataIn
  var401 := DontCare
  val var402 = fifo_80.dataOut
  var402 := DontCare
  val fifo_81 = Module(new ElasticFIFO(87,64))
  val var403 = fifo_81.dataIn
  var403 := DontCare
  val var404 = fifo_81.dataOut
  var404 := DontCare
  val fifo_82 = Module(new ElasticFIFO(30,64))
  val var405 = fifo_82.dataIn
  var405 := DontCare
  val var406 = fifo_82.dataOut
  var406 := DontCare
  val fifo_83 = Module(new ElasticFIFO(30,64))
  val var407 = fifo_83.dataIn
  var407 := DontCare
  val var408 = fifo_83.dataOut
  var408 := DontCare
  val fifo_84 = Module(new ElasticFIFO(30,1))
  val var409 = fifo_84.dataIn
  var409 := DontCare
  val var410 = fifo_84.dataOut
  var410 := DontCare
  var120 <> var118
  var117 <> var115
  var119 <> var326
  var113 <> var99
  var130 <> var128
  var127 <> var125
  var129 <> var325
  var133 <> var99
  var134.bits := 0L.U
  var134.valid := true.B
  var123 <> var135
  var126 <> var331
  var136 <> var99
  var137.bits := 0.U
  var137.valid := true.B
  var146 <> var144
  var143 <> var141
  var145 <> var324
  var149 <> var99
  var150.bits := 1.U
  var150.valid := true.B
  var139 <> var151
  var140 <> var338
  var142 <> var330
  var159 <> var341
  var156 <> var154
  var158 <> var323
  var162 <> var99
  var163.bits := 1024.U
  var163.valid := true.B
  var152 <> var164
  var153 <> var160
  var155 <> var329
  var169 <> var167
  var165 <> var138
  var110 <> var344
  var111 <> var340
  var171 <> var322
  var172 <> var343
  var175 <> var348
  var176 <> var337
  var166 <> var177
  var168 <> var328
  var178 <> var347
  var182 <> var335
  var106 <> var180
  var181 <> var107
  var183 <> var179
  var185 <> var353
  var186 <> var334
  var189 <> var352
  var190 <> var346
  var193 <> var351
  var194 <> var131
  var200 <> var350
  var211 <> var209
  var208 <> var206
  var210 <> var365
  var204 <> var358
  var221 <> var219
  var218 <> var216
  var220 <> var364
  var214 <> var195
  var217 <> var371
  var224 <> var357
  var225.bits := 0.U
  var225.valid := true.B
  var234 <> var232
  var231 <> var229
  var233 <> var363
  var237 <> var356
  var238.bits := 1.U
  var238.valid := true.B
  var227 <> var239
  var228 <> var380
  var230 <> var370
  var247 <> var383
  var244 <> var242
  var246 <> var362
  var250 <> var355
  var251.bits := 1024.U
  var251.valid := true.B
  var240 <> var252
  var241 <> var248
  var243 <> var369
  var260 <> var258
  var257 <> var255
  var259 <> var361
  var253 <> var191
  var254 <> var387
  var256 <> var368
  var267 <> var265
  var263 <> var226
  var201 <> var390
  var202 <> var382
  var269 <> var360
  var270 <> var389
  var273 <> var395
  var274 <> var379
  var264 <> var275
  var266 <> var367
  var276 <> var386
  var280 <> var377
  var102 <> var278
  var279 <> var103
  var281 <> var394
  var285 <> var376
  var104 <> var283
  var284 <> var105
  var289 <> var393
  var293 <> var375
  var108 <> var291
  var292 <> var109
  var294 <> var290
  var296 <> var385
  var297 <> var392
  var299 <> var295
  var300 <> var298
  var302 <> var400
  var303 <> var374
  var307 <> var288
  var310 <> var398
  var311 <> var222
  var317 <> var397
  var315 <> var320
  var314 <> var313
  var215 <> var316
  var205 <> var373
  var198 <> var223
  var197 <> var196
  var124 <> var199
  var114 <> var333
  var100 <> var132
  var321 <> var112
  var327 <> var116
  var332 <> var121
  var336 <> var147
  var339 <> var157
  var342 <> var170
  var345 <> var173
  var349 <> var184
  var354 <> var187
  var359 <> var203
  var366 <> var207
  var372 <> var212
  var378 <> var235
  var381 <> var245
  var384 <> var261
  var388 <> var268
  var391 <> var271
  var396 <> var301
  var401 <> var308
  var318 <> var402
  var403 <> var312
  var319 <> var404
  var405 <> var277
  var286 <> var406
  var407 <> var282
  var287 <> var408
  var409 <> var399
  var306 <> var410
  var122.ready := true.B
  var148.ready := true.B
  var161.ready := true.B
  var174.ready := true.B
  var188.ready := true.B
  var192.ready := true.B
  var213.ready := true.B
  var236.ready := true.B
  var249.ready := true.B
  var262.ready := true.B
  var272.ready := true.B
  var304.ready := true.B
  var305.ready := true.B
  var309.ready := true.B
  val finish = IO(Input(Bool()))
  mem_0.read_address := DontCare
  mem_0.finish := DontCare
  mem_1.read_address := DontCare
  mem_1.finish := DontCare
  mem_0.initMem("data_set/aeloss_push/in_0.txt")
  mem_1.initMem("data_set/aeloss_push/in_1.txt")
}

