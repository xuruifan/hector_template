import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class pull_hybrid extends MultiIOModule {
  val mem_global_0 = Module(new ReadMem(1024, 64, 1))
  val var0 = mem_global_0.r_en
  val var1 = mem_global_0.addr
  val var2 = mem_global_0.r_data
  val mem_global_1 = Module(new ReadMem(1024, 64, 1))
  val var3 = mem_global_1.r_en
  val var4 = mem_global_1.addr
  val var5 = mem_global_1.r_data
  class submodule1 extends MultiIOModule {
    val new_input = Wire(Bool())
    new_input := false.B
    val done = Wire(Bool())
    done := false.B
    val new_output = IO(Output(Bool()))
    new_output := 0.U
    val d_var6 = IO(Flipped(DecoupledIO(UInt(32.W))))
    val var6 = d_var6.bits
    d_var6.ready := false.B
    val d_var7 = IO(DecoupledIO(UInt(64.W)))
    val var7 = d_var7.bits
    var7 := DontCare
    d_var7.valid := false.B
    val d_var8 = IO(DecoupledIO(UInt(64.W)))
    val var8 = d_var8.bits
    var8 := DontCare
    d_var8.valid := false.B
    val all_valid = d_var6.valid
    val continue = d_var7.ready & d_var8.ready
    val go = all_valid
    val var9 = Reg(UInt(32.W))
    val var10 = Reg(UInt(32.W))
    val var11 = Reg(UInt(64.W))
    val var12 = Reg(UInt(64.W))
    val var13 = Reg(UInt(64.W))
    val var14 = Reg(UInt(64.W))
    val var15 = Reg(UInt(64.W))
    val var16 = Reg(UInt(64.W))
    val var17 = Reg(UInt(64.W))
    val var18 = Reg(UInt(64.W))
    val var19 = Reg(UInt(64.W))
    val var20 = Reg(UInt(64.W))
    val var21 = Reg(UInt(64.W))
    val var22 = Reg(UInt(64.W))
    val var23 = Reg(UInt(64.W))
    val var24 = Reg(UInt(64.W))
    val var25 = Reg(UInt(64.W))
    val var26 = Reg(UInt(64.W))
    val var27 = Reg(UInt(64.W))
    val var28 = Reg(UInt(64.W))
    val var29 = Reg(UInt(64.W))
    val var30 = Reg(UInt(64.W))
    val var31 = Reg(UInt(64.W))
    val var32 = Reg(UInt(64.W))
    val var33 = Reg(UInt(64.W))
    val var34 = Reg(UInt(64.W))
    val var35 = Reg(UInt(64.W))
    val var36 = Reg(UInt(64.W))
    val var37 = Reg(UInt(64.W))
    val var38 = Reg(UInt(64.W))
    val var39 = Reg(UInt(64.W))
    val var40 = Reg(UInt(64.W))
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
    val var90 = Reg(UInt(64.W))
    val var91 = Reg(UInt(64.W))
    val var92 = Reg(UInt(64.W))
    val var93 = Reg(UInt(64.W))
    val var94 = Reg(UInt(64.W))
    val var95 = Reg(UInt(64.W))
    val var96 = Reg(UInt(64.W))
    val var97 = Reg(UInt(64.W))
    val var98 = Reg(UInt(64.W))
    val var99 = Reg(UInt(64.W))
    val var100 = Reg(UInt(64.W))
    val var101 = Reg(UInt(64.W))
    val var102 = Reg(UInt(64.W))
    val var103 = Reg(UInt(64.W))
    val var104 = Reg(UInt(64.W))
    val var105 = Reg(UInt(64.W))
    val var106 = Reg(UInt(64.W))
    val var107 = Reg(UInt(64.W))
    val var108 = Reg(UInt(64.W))
    val var109 = Reg(UInt(64.W))
    val addf_submodule1_0 = Module(new AddSubFBase(13, 11, 53, true))
    addf_submodule1_0.ce := true.B
    val var110 = addf_submodule1_0.operand0
    var110 := DontCare
    val var111 = addf_submodule1_0.operand1
    var111 := DontCare
    val var112 = addf_submodule1_0.result
    val mulf_submodule1_0 = Module(new MulFBase(9, 11, 53))
    mulf_submodule1_0.ce := true.B
    val var113 = mulf_submodule1_0.operand0
    var113 := DontCare
    val var114 = mulf_submodule1_0.operand1
    var114 := DontCare
    val var115 = mulf_submodule1_0.result
    val subf_submodule1_0 = Module(new AddSubFBase(13, 11, 53, false))
    subf_submodule1_0.ce := true.B
    val var116 = subf_submodule1_0.operand0
    var116 := DontCare
    val var117 = subf_submodule1_0.operand1
    var117 := DontCare
    val var118 = subf_submodule1_0.result
    val mulf_submodule1_1 = Module(new MulFBase(9, 11, 53))
    mulf_submodule1_1.ce := true.B
    val var119 = mulf_submodule1_1.operand0
    var119 := DontCare
    val var120 = mulf_submodule1_1.operand1
    var120 := DontCare
    val var121 = mulf_submodule1_1.result
    when (go & continue) {
      var9 := var6
    }
    val var0 = IO(Output(UInt(1.W)))
    var0 := false.B
    val var1 = IO(Output(UInt(10.W)))
    var1 := DontCare
    val var3 = IO(Output(UInt(1.W)))
    var3 := false.B
    val var4 = IO(Output(UInt(10.W)))
    var4 := DontCare
    val var2 = IO(Input(UInt(64.W)))
    val var5 = IO(Input(UInt(64.W)))
    val shift_register = RegInit(0.U(35.W))
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
      } else if (stage == 58) {
        shift_register(28)
      } else if (stage == 59) {
        shift_register(29)
      } else if (stage == 60) {
        shift_register(29)
      } else if (stage == 61) {
        shift_register(30)
      } else if (stage == 62) {
        shift_register(30)
      } else if (stage == 63) {
        shift_register(31)
      } else if (stage == 64) {
        shift_register(31)
      } else if (stage == 65) {
        shift_register(32)
      } else if (stage == 66) {
        shift_register(32)
      } else if (stage == 67) {
        shift_register(33)
      } else if (stage == 68) {
        shift_register(33)
      } else if (stage == 69) {
        shift_register(34)
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
            shift_register := Cat(shift_register(33, 0), new_input)
          }
          when (counter === 0.U) {
            when (valid(2)) {
              var11 := var2
            }
            when (valid(2)) {
              var35 := var5
            }
            var110 := var2
            var111 := var5
            when (valid(4)) {
              var13 := var12
            }
            when (valid(4)) {
              var37 := var36
            }
            when (valid(6)) {
              var15 := var14
            }
            when (valid(6)) {
              var39 := var38
            }
            when (valid(8)) {
              var17 := var16
            }
            when (valid(8)) {
              var41 := var40
            }
            when (valid(10)) {
              var19 := var18
            }
            when (valid(10)) {
              var43 := var42
            }
            when (valid(12)) {
              var21 := var20
            }
            when (valid(12)) {
              var45 := var44
            }
            when (valid(14)) {
              var23 := var22
            }
            when (valid(14)) {
              var47 := var46
            }
            when (valid(16)) {
              var25 := var24
            }
            when (valid(16)) {
              var49 := var48
            }
            when (valid(18)) {
              var27 := var26
            }
            when (valid(18)) {
              var51 := var50
            }
            when (valid(20)) {
              var29 := var28
            }
            when (valid(20)) {
              var53 := var52
            }
            when (valid(22)) {
              var31 := var30
            }
            when (valid(22)) {
              var55 := var54
            }
            when (valid(24)) {
              var59 := var115
            }
            var116 := var56
            var117 := var115
            when (valid(24)) {
              var33 := var32
            }
            when (valid(24)) {
              var57 := var56
            }
            when (valid(26)) {
              var61 := var60
            }
            when (valid(28)) {
              var63 := var62
            }
            when (valid(30)) {
              var65 := var64
            }
            when (valid(32)) {
              var67 := var66
            }
            when (valid(34)) {
              var69 := var68
            }
            when (valid(36)) {
              var71 := var70
            }
            when (valid(38)) {
              var105 := var118
            }
            var113 := var118
            var114 := var118
            when (valid(38)) {
              var73 := var72
            }
            when (valid(40)) {
              var75 := var74
            }
            when (valid(42)) {
              var77 := var76
            }
            when (valid(44)) {
              var79 := var78
            }
            when (valid(46)) {
              var106 := var121
            }
            when (valid(46)) {
              var81 := var80
            }
            when (valid(48)) {
              var83 := var82
            }
            when (valid(50)) {
              var85 := var84
            }
            when (valid(52)) {
              var87 := var86
            }
            when (valid(54)) {
              var89 := var88
            }
            when (valid(56)) {
              var91 := var90
            }
            when (valid(58)) {
              var93 := var92
            }
            when (valid(60)) {
              var109 := var112
            }
            var119 := var112
            var120 := 4591705420666420376L.U
            when (valid(60)) {
              var95 := var94
            }
            when (valid(62)) {
              var97 := var96
            }
            when (valid(64)) {
              var99 := var98
            }
            when (valid(66)) {
              var101 := var100
            }
            when (valid(68)) {
              var103 := var102
            }
          }
          when (counter === 1.U) {
            var1 := var9
            when (valid(1)) {
              var0 := 1.U
            }
            var4 := var9
            when (valid(1)) {
              var3 := 1.U
            }
            when (valid(1)) {
              var10 := var9
            }
            when (valid(3)) {
              var12 := var11
            }
            when (valid(3)) {
              var36 := var35
            }
            when (valid(5)) {
              var14 := var13
            }
            when (valid(5)) {
              var38 := var37
            }
            when (valid(7)) {
              var16 := var15
            }
            when (valid(7)) {
              var40 := var39
            }
            when (valid(9)) {
              var18 := var17
            }
            when (valid(9)) {
              var42 := var41
            }
            when (valid(11)) {
              var20 := var19
            }
            when (valid(11)) {
              var44 := var43
            }
            when (valid(13)) {
              var22 := var21
            }
            when (valid(13)) {
              var46 := var45
            }
            when (valid(15)) {
              var58 := var112
            }
            var113 := var112
            var114 := 4602678819172646912L.U
            when (valid(15)) {
              var24 := var23
            }
            when (valid(15)) {
              var48 := var47
            }
            when (valid(17)) {
              var26 := var25
            }
            when (valid(17)) {
              var50 := var49
            }
            when (valid(19)) {
              var28 := var27
            }
            when (valid(19)) {
              var52 := var51
            }
            when (valid(21)) {
              var30 := var29
            }
            when (valid(21)) {
              var54 := var53
            }
            when (valid(23)) {
              var32 := var31
            }
            when (valid(23)) {
              var56 := var55
            }
            var116 := var33
            var117 := var59
            when (valid(25)) {
              var34 := var33
            }
            when (valid(25)) {
              var60 := var59
            }
            when (valid(27)) {
              var62 := var61
            }
            when (valid(29)) {
              var64 := var63
            }
            when (valid(31)) {
              var66 := var65
            }
            when (valid(33)) {
              var68 := var67
            }
            when (valid(35)) {
              var70 := var69
            }
            when (valid(37)) {
              var104 := var118
            }
            var119 := var118
            var120 := var118
            when (valid(37)) {
              var72 := var71
            }
            when (valid(39)) {
              var74 := var73
            }
            when (valid(41)) {
              var76 := var75
            }
            when (valid(43)) {
              var78 := var77
            }
            when (valid(45)) {
              var80 := var79
            }
            when (valid(47)) {
              var108 := var115
            }
            var110 := var115
            var111 := var106
            when (valid(47)) {
              var82 := var81
            }
            when (valid(47)) {
              var107 := var106
            }
            when (valid(49)) {
              var84 := var83
            }
            when (valid(51)) {
              var86 := var85
            }
            when (valid(53)) {
              var88 := var87
            }
            when (valid(55)) {
              var90 := var89
            }
            when (valid(57)) {
              var92 := var91
            }
            when (valid(59)) {
              var94 := var93
            }
            when (valid(61)) {
              var96 := var95
            }
            when (valid(63)) {
              var98 := var97
            }
            when (valid(65)) {
              var100 := var99
            }
            when (valid(67)) {
              var102 := var101
            }
            new_output := valid(69)
            var7 := var103
            var8 := var121
          }
          when (counter === 1.U && valid(69)) {
            done := true.B
          }
    }
    when (continue) {
      when (counter === 0.U) {
        d_var6.ready := all_valid
      }
      d_var7.valid := done
      d_var8.valid := done
    }
  }
  val var122 = IO(Flipped(DecoupledIO(UInt(0.W))))
  val var123 = IO(DecoupledIO(UInt(64.W)))
  var123 := DontCare
  val var124 = IO(DecoupledIO(UInt(0.W)))
  var124 := DontCare
  val mem_0 = Module(new DynMem(0,1)(1024,64))
  val var125 = mem_0.store_address apply 0
  var125 := DontCare
  val var126 = mem_0.store_data apply 0
  var126 := DontCare
  val mem_1 = Module(new DynMem(1,0)(1024,32))
  val var127 = mem_1.load_address apply 0
  var127 := DontCare
  val var128 = mem_1.load_data apply 0
  var128 := DontCare
  val cmpi_sle_2 = Module(new LessEqualthanIDynamic(32))
  val var129 = cmpi_sle_2.operand0
  var129 := DontCare
  val var130 = cmpi_sle_2.operand1
  var130 := DontCare
  val var131 = cmpi_sle_2.result
  var131 := DontCare
  val m_3 = Module(new Control_Merge(0))
  val var132 = m_3.dataIn apply 0
  var132 := DontCare
  val var133 = m_3.dataIn apply 1
  var133 := DontCare
  val var134 = m_3.dataOut
  var134 := DontCare
  val var135 = m_3.condition
  var135 := DontCare
  val buf_4 = Module(new ElasticBuffer(0))
  val var136 = buf_4.dataIn
  var136 := DontCare
  val var137 = buf_4.dataOut
  var137 := DontCare
  val b_5 = Module(new Branch(0))
  val var138 = b_5.condition
  var138 := DontCare
  val var139 = b_5.dataIn
  var139 := DontCare
  val var140 = b_5.dataOut apply 0
  var140 := DontCare
  val var141 = b_5.dataOut apply 1
  var141 := DontCare
  val m_6 = Module(new MuxDynamic(64)())
  val var142 = m_6.dataIn apply 0
  var142 := DontCare
  val var143 = m_6.dataIn apply 1
  var143 := DontCare
  val var144 = m_6.dataOut
  var144 := DontCare
  val var145 = m_6.condition
  var145 := DontCare
  val buf_7 = Module(new ElasticBuffer(64))
  val var146 = buf_7.dataIn
  var146 := DontCare
  val var147 = buf_7.dataOut
  var147 := DontCare
  val b_8 = Module(new Branch(64))
  val var148 = b_8.condition
  var148 := DontCare
  val var149 = b_8.dataIn
  var149 := DontCare
  val var150 = b_8.dataOut apply 0
  var150 := DontCare
  val var151 = b_8.dataOut apply 1
  var151 := DontCare
  val const_9 = Module(new Constant(64))
  val var152 = const_9.control
  var152 := DontCare
  val var153 = const_9.dataIn
  var153 := DontCare
  val var154 = const_9.dataOut
  var154 := DontCare
  val const_10 = Module(new Constant(32))
  val var155 = const_10.control
  var155 := DontCare
  val var156 = const_10.dataIn
  var156 := DontCare
  val var157 = const_10.dataOut
  var157 := DontCare
  val m_11 = Module(new MuxDynamic(32)())
  val var158 = m_11.dataIn apply 0
  var158 := DontCare
  val var159 = m_11.dataIn apply 1
  var159 := DontCare
  val var160 = m_11.dataOut
  var160 := DontCare
  val var161 = m_11.condition
  var161 := DontCare
  val buf_12 = Module(new ElasticBuffer(32))
  val var162 = buf_12.dataIn
  var162 := DontCare
  val var163 = buf_12.dataOut
  var163 := DontCare
  val b_13 = Module(new Branch(32))
  val var164 = b_13.condition
  var164 := DontCare
  val var165 = b_13.dataIn
  var165 := DontCare
  val var166 = b_13.dataOut apply 0
  var166 := DontCare
  val var167 = b_13.dataOut apply 1
  var167 := DontCare
  val const_14 = Module(new Constant(32))
  val var168 = const_14.control
  var168 := DontCare
  val var169 = const_14.dataIn
  var169 := DontCare
  val var170 = const_14.dataOut
  var170 := DontCare
  val m_15 = Module(new MuxDynamic(32)())
  val var171 = m_15.dataIn apply 0
  var171 := DontCare
  val var172 = m_15.dataIn apply 1
  var172 := DontCare
  val var173 = m_15.dataOut
  var173 := DontCare
  val var174 = m_15.condition
  var174 := DontCare
  val buf_16 = Module(new ElasticBuffer(32))
  val var175 = buf_16.dataIn
  var175 := DontCare
  val var176 = buf_16.dataOut
  var176 := DontCare
  val b_17 = Module(new Branch(32))
  val var177 = b_17.condition
  var177 := DontCare
  val var178 = b_17.dataIn
  var178 := DontCare
  val var179 = b_17.dataOut apply 0
  var179 := DontCare
  val var180 = b_17.dataOut apply 1
  var180 := DontCare
  val const_18 = Module(new Constant(32))
  val var181 = const_18.control
  var181 := DontCare
  val var182 = const_18.dataIn
  var182 := DontCare
  val var183 = const_18.dataOut
  var183 := DontCare
  val m_19 = Module(new MuxDynamic(32)())
  val var184 = m_19.dataIn apply 0
  var184 := DontCare
  val var185 = m_19.dataIn apply 1
  var185 := DontCare
  val var186 = m_19.dataOut
  var186 := DontCare
  val var187 = m_19.condition
  var187 := DontCare
  val buf_20 = Module(new ElasticBuffer(32))
  val var188 = buf_20.dataIn
  var188 := DontCare
  val var189 = buf_20.dataOut
  var189 := DontCare
  val b_21 = Module(new Branch(32))
  val var190 = b_21.condition
  var190 := DontCare
  val var191 = b_21.dataIn
  var191 := DontCare
  val var192 = b_21.dataOut apply 0
  var192 := DontCare
  val var193 = b_21.dataOut apply 1
  var193 := DontCare
  val addi_22 = Module(new AddIDynamic(32))
  val var194 = addi_22.operand0
  var194 := DontCare
  val var195 = addi_22.operand1
  var195 := DontCare
  val var196 = addi_22.result
  var196 := DontCare
  val submodule1_0 = Module(new submodule1)
  val var197 = submodule1_0.d_var6
  var197 := DontCare
  val var198 = submodule1_0.d_var7
  val var199 = submodule1_0.d_var8
  val store_23 = Module(new Store(1024,64))
  val var200 = store_23.address_in
  var200 := DontCare
  val var201 = store_23.data_in
  var201 := DontCare
  val var202 = store_23.address_out
  var202 := DontCare
  val var203 = store_23.data_out
  var203 := DontCare
  val var204 = store_23.control
  var204 := DontCare
  val load_24 = Module(new Load(1024,32))
  val var205 = load_24.address_in
  var205 := DontCare
  val var206 = load_24.data_out
  var206 := DontCare
  val var207 = load_24.address_out
  var207 := DontCare
  val var208 = load_24.data_in
  var208 := DontCare
  val var209 = load_24.control
  var209 := DontCare
  val trunci_25 = Module(new TruncIDynamic(32,1))
  val var210 = trunci_25.operand
  var210 := DontCare
  val var211 = trunci_25.result
  var211 := DontCare
  val b_26 = Module(new Branch(0))
  val var212 = b_26.condition
  var212 := DontCare
  val var213 = b_26.dataIn
  var213 := DontCare
  val var214 = b_26.dataOut apply 0
  var214 := DontCare
  val var215 = b_26.dataOut apply 1
  var215 := DontCare
  val b_27 = Module(new Branch(64))
  val var216 = b_27.condition
  var216 := DontCare
  val var217 = b_27.dataIn
  var217 := DontCare
  val var218 = b_27.dataOut apply 0
  var218 := DontCare
  val var219 = b_27.dataOut apply 1
  var219 := DontCare
  val b_28 = Module(new Branch(64))
  val var220 = b_28.condition
  var220 := DontCare
  val var221 = b_28.dataIn
  var221 := DontCare
  val var222 = b_28.dataOut apply 0
  var222 := DontCare
  val var223 = b_28.dataOut apply 1
  var223 := DontCare
  val m_29 = Module(new MuxDynamic(64)())
  val var224 = m_29.dataIn apply 0
  var224 := DontCare
  val var225 = m_29.dataIn apply 1
  var225 := DontCare
  val var226 = m_29.dataOut
  var226 := DontCare
  val var227 = m_29.condition
  var227 := DontCare
  val addf_30 = Module(new AddFDynamic(13, 11, 53))
  val var228 = addf_30.operand0
  var228 := DontCare
  val var229 = addf_30.operand1
  var229 := DontCare
  val var230 = addf_30.result
  var230 := DontCare
  val f_31 = Module(new Fork(1)(5))
  val var231 = f_31.dataIn
  var231 := DontCare
  val var232 = f_31.dataOut apply 0
  var232 := DontCare
  val var233 = f_31.dataOut apply 1
  var233 := DontCare
  val var234 = f_31.dataOut apply 2
  var234 := DontCare
  val var235 = f_31.dataOut apply 3
  var235 := DontCare
  val var236 = f_31.dataOut apply 4
  var236 := DontCare
  val f_32 = Module(new Fork(1)(4))
  val var237 = f_32.dataIn
  var237 := DontCare
  val var238 = f_32.dataOut apply 0
  var238 := DontCare
  val var239 = f_32.dataOut apply 1
  var239 := DontCare
  val var240 = f_32.dataOut apply 2
  var240 := DontCare
  val var241 = f_32.dataOut apply 3
  var241 := DontCare
  val f_33 = Module(new Fork(0)(4))
  val var242 = f_33.dataIn
  var242 := DontCare
  val var243 = f_33.dataOut apply 0
  var243 := DontCare
  val var244 = f_33.dataOut apply 1
  var244 := DontCare
  val var245 = f_33.dataOut apply 2
  var245 := DontCare
  val var246 = f_33.dataOut apply 3
  var246 := DontCare
  val f_34 = Module(new Fork(32)(2))
  val var247 = f_34.dataIn
  var247 := DontCare
  val var248 = f_34.dataOut apply 0
  var248 := DontCare
  val var249 = f_34.dataOut apply 1
  var249 := DontCare
  val f_35 = Module(new Fork(32)(2))
  val var250 = f_35.dataIn
  var250 := DontCare
  val var251 = f_35.dataOut apply 0
  var251 := DontCare
  val var252 = f_35.dataOut apply 1
  var252 := DontCare
  val f_36 = Module(new Fork(32)(2))
  val var253 = f_36.dataIn
  var253 := DontCare
  val var254 = f_36.dataOut apply 0
  var254 := DontCare
  val var255 = f_36.dataOut apply 1
  var255 := DontCare
  val f_37 = Module(new Fork(32)(4))
  val var256 = f_37.dataIn
  var256 := DontCare
  val var257 = f_37.dataOut apply 0
  var257 := DontCare
  val var258 = f_37.dataOut apply 1
  var258 := DontCare
  val var259 = f_37.dataOut apply 2
  var259 := DontCare
  val var260 = f_37.dataOut apply 3
  var260 := DontCare
  val f_38 = Module(new Fork(1)(4))
  val var261 = f_38.dataIn
  var261 := DontCare
  val var262 = f_38.dataOut apply 0
  var262 := DontCare
  val var263 = f_38.dataOut apply 1
  var263 := DontCare
  val var264 = f_38.dataOut apply 2
  var264 := DontCare
  val var265 = f_38.dataOut apply 3
  var265 := DontCare
  val fifo_39 = Module(new ElasticFIFO(82,64))
  val var266 = fifo_39.dataIn
  var266 := DontCare
  val var267 = fifo_39.dataOut
  var267 := DontCare
  val fifo_40 = Module(new ElasticFIFO(13,64))
  val var268 = fifo_40.dataIn
  var268 := DontCare
  val var269 = fifo_40.dataOut
  var269 := DontCare
  val fifo_41 = Module(new ElasticFIFO(69,32))
  val var270 = fifo_41.dataIn
  var270 := DontCare
  val var271 = fifo_41.dataOut
  var271 := DontCare
  val fifo_42 = Module(new ElasticFIFO(69,0))
  val var272 = fifo_42.dataIn
  var272 := DontCare
  val var273 = fifo_42.dataOut
  var273 := DontCare
  val fifo_43 = Module(new ElasticFIFO(69,1))
  val var274 = fifo_43.dataIn
  var274 := DontCare
  val var275 = fifo_43.dataOut
  var275 := DontCare
  val fifo_44 = Module(new ElasticFIFO(69,32))
  val var276 = fifo_44.dataIn
  var276 := DontCare
  val var277 = fifo_44.dataOut
  var277 := DontCare
  var139 <> var137
  var136 <> var134
  var138 <> var236
  var132 <> var122
  var149 <> var147
  var146 <> var144
  var148 <> var235
  var152 <> var122
  var153.bits := 0L.U
  var153.valid := true.B
  var142 <> var154
  var145 <> var241
  var155 <> var122
  var156.bits := 0.U
  var156.valid := true.B
  var165 <> var163
  var162 <> var160
  var164 <> var234
  var168 <> var122
  var169.bits := 1.U
  var169.valid := true.B
  var158 <> var170
  var159 <> var249
  var161 <> var240
  var178 <> var252
  var175 <> var173
  var177 <> var233
  var181 <> var122
  var182.bits := 1024.U
  var182.valid := true.B
  var171 <> var183
  var172 <> var179
  var174 <> var239
  var188 <> var186
  var184 <> var157
  var129 <> var255
  var130 <> var251
  var190 <> var232
  var191 <> var254
  var194 <> var260
  var195 <> var248
  var185 <> var196
  var187 <> var238
  var201 <> var198
  var125 <> var202
  var126 <> var203
  var205 <> var257
  var209 <> var245
  var127 <> var207
  var208 <> var128
  var210 <> var206
  var212 <> var265
  var213 <> var244
  var216 <> var264
  var217 <> var150
  var221 <> var199
  var227 <> var262
  var225 <> var230
  var224 <> var219
  var143 <> var226
  var133 <> var243
  var123 <> var151
  var231 <> var131
  var237 <> var135
  var242 <> var140
  var247 <> var166
  var250 <> var176
  var253 <> var189
  var256 <> var192
  var261 <> var211
  var266 <> var218
  var228 <> var267
  var268 <> var222
  var229 <> var269
  var270 <> var258
  var200 <> var271
  var272 <> var246
  var204 <> var273
  var274 <> var263
  var220 <> var275
  var276 <> var259
  var197 <> var277
  var141.ready := true.B
  var167.ready := true.B
  var180.ready := true.B
  var193.ready := true.B
  var214.ready := true.B
  var215.ready := true.B
  var223.ready := true.B
  mem_global_0.dataIn(0).valid := submodule1_0.var0
  mem_global_0.dataIn(0).bits := submodule1_0.var1
  mem_global_1.dataIn(0).valid := submodule1_0.var3
  mem_global_1.dataIn(0).bits := submodule1_0.var4
  submodule1_0.var2 := var2
  submodule1_0.var5 := var5
  val finish = IO(Input(Bool()))
  mem_0.read_address := DontCare
  mem_0.finish := DontCare
  mem_0.finish := finish
  val mem_0_addr = IO(Input(UInt(log2Ceil(1024).W)))
  mem_0.read_address := mem_0_addr
  val mem_0_data = IO(Output(UInt(64.W)))
  mem_0_data := mem_0.out_data
  mem_1.read_address := DontCare
  mem_1.finish := DontCare
}

