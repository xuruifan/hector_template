import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals
import utest._
import chisel3.experimental._
import hls._

class spmv extends MultiIOModule {
  val mem_global_0 = Module(new ReadMem(1666, 64))
  val var0 = mem_global_0.r_en
  val var1 = mem_global_0.addr
  val var2 = mem_global_0.r_data
  val mem_global_1 = Module(new ReadMem(1666, 32))
  val var3 = mem_global_1.r_en
  val var4 = mem_global_1.addr
  val var5 = mem_global_1.r_data
  val mem_global_3 = Module(new ReadMem(494, 64))
  val var9 = mem_global_3.r_en
  val var10 = mem_global_3.addr
  val var11 = mem_global_3.r_data
  class outline_0 extends MultiIOModule {
    val start = RegInit(false.B)
    val new_input = Wire(Bool())
    new_input := false.B
    val done = Wire(Bool())
    done := 0.U
    val d_var15 = IO(Flipped(DecoupledIO(UInt(32.W))))
    val var15 = d_var15.bits
    val d_var16 = IO(Flipped(DecoupledIO(UInt(32.W))))
    val var16 = d_var16.bits
    val d_var17 = IO(Flipped(DecoupledIO(UInt(32.W))))
    val var17 = d_var17.bits
    val d_var18 = IO(DecoupledIO(UInt(64.W)))
    val var18 = d_var18.bits
    var18 := DontCare
    val all_valid = d_var15.valid & d_var16.valid & d_var17.valid
    val go = all_valid & d_var18.ready
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
    when (go) {
      var72 := var15
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
          var22 := var72
        }
        when (valid(11)) {
          var33 := var32
        }
        when (valid(11)) {
          var55 := var54
        }
        when (valid(22)) {
          var55 := var71
          var18 := var71
          when (!valid(11)) {
            done := true.B
          }
        }
      }
      when (counter === 1.U) {
        val var73 = var22 - var19
        when (valid(1)) {
          var57 := var73
        }
        val var74 = var73 + var19
        when (valid(1)) {
          var58 := var74
        }
        when (valid(1)) {
          var23 := var22
        }
        when (valid(1)) {
          var45 := var44
        }
        when (valid(12)) {
          var65 := var68
        }
        var69 := var55
        var70 := var68
        when (valid(12)) {
          var34 := var33
        }
        when (valid(12)) {
          var56 := var55
        }
      }
      when (counter === 2.U) {
        var4 := var58
        var3 := 1.U
        when (valid(2)) {
          var24 := var23
        }
        when (valid(2)) {
          var46 := var45
        }
        when (valid(2)) {
          var59 := var58
        }
        when (valid(13)) {
          var35 := var34
        }
      }
      when (counter === 3.U) {
        when (valid(3)) {
          var25 := var24
        }
        when (valid(3)) {
          var47 := var46
        }
        when (valid(3)) {
          var60 := var59
        }
        when (valid(14)) {
          var36 := var35
        }
      }
      when (counter === 4.U) {
        when (valid(4)) {
          var62 := var5
        }
        var1 := var60
        var0 := 1.U
        var10 := var5
        var9 := 1.U
        when (valid(4)) {
          var26 := var25
        }
        when (valid(4)) {
          var48 := var47
        }
        when (valid(4)) {
          var61 := var60
        }
        when (valid(15)) {
          var37 := var36
        }
      }
      when (counter === 5.U) {
        when (valid(5)) {
          var27 := var26
        }
        when (valid(5)) {
          var49 := var48
        }
        when (valid(16)) {
          var38 := var37
        }
      }
      when (counter === 6.U) {
        when (valid(6)) {
          var63 := var2
        }
        when (valid(6)) {
          var64 := var11
        }
        var66 := var2
        var67 := var11
        when (valid(6)) {
          var28 := var27
        }
        when (valid(6)) {
          var50 := var49
        }
        when (valid(17)) {
          var39 := var38
        }
      }
      when (counter === 7.U) {
        when (valid(7)) {
          var29 := var28
        }
        when (valid(7)) {
          var51 := var50
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
          var52 := var51
        }
        when (valid(19)) {
          var41 := var40
        }
      }
      when (counter === 9.U) {
        when (valid(9)) {
          var31 := var30
        }
        when (valid(9)) {
          var53 := var52
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
          var54 := var53
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
        when (var72 <= upper_bound) {
          when (counter === 10.U) {
            var72 := var72 + step
          }
          }.otherwise {
            start := false.B
            new_input := false.B
          }
      }
      val init = RegInit(true.B)
      when (done) {
        init := true.B
      }
      when (new_input) {
        init := false.B
      }
      d_var15.ready := all_valid & init
      d_var16.ready := all_valid & init
      d_var17.ready := all_valid & init
      d_var18.valid := done
  }
  val var75 = IO(Flipped(DecoupledIO(UInt(0.W))))
  val var76 = IO(DecoupledIO(UInt(0.W)))
  var76 := DontCare
  val mem_0 = Module(new DynMem(2,0)(495,32))
  val var77 = mem_0.load_address apply 0
  var77 := DontCare
  val var78 = mem_0.load_data apply 0
  var78 := DontCare
  val var79 = mem_0.load_address apply 1
  var79 := DontCare
  val var80 = mem_0.load_data apply 1
  var80 := DontCare
  val mem_1 = Module(new DynMem(0,1)(494,64))
  val var81 = mem_1.store_address apply 0
  var81 := DontCare
  val var82 = mem_1.store_data apply 0
  var82 := DontCare
  val cmpi_sle_2 = Module(new LessEqualthanIDynamic(32))
  val var83 = cmpi_sle_2.operand0
  var83 := DontCare
  val var84 = cmpi_sle_2.operand1
  var84 := DontCare
  val var85 = cmpi_sle_2.result
  var85 := DontCare
  val const_3 = Module(new Constant(32))
  val var86 = const_3.control
  var86 := DontCare
  val var87 = const_3.dataIn
  var87 := DontCare
  val var88 = const_3.dataOut
  var88 := DontCare
  val m_4 = Module(new Merge(0)())
  val var89 = m_4.dataIn apply 0
  var89 := DontCare
  val var90 = m_4.dataIn apply 1
  var90 := DontCare
  val var91 = m_4.dataOut
  var91 := DontCare
  val buf_5 = Module(new ElasticBuffer(0))
  val var92 = buf_5.dataIn
  var92 := DontCare
  val var93 = buf_5.dataOut
  var93 := DontCare
  val b_6 = Module(new Branch(0))
  val var94 = b_6.condition
  var94 := DontCare
  val var95 = b_6.dataIn
  var95 := DontCare
  val var96 = b_6.dataOut apply 0
  var96 := DontCare
  val var97 = b_6.dataOut apply 1
  var97 := DontCare
  val m_7 = Module(new Merge(32)())
  val var98 = m_7.dataIn apply 0
  var98 := DontCare
  val var99 = m_7.dataIn apply 1
  var99 := DontCare
  val var100 = m_7.dataOut
  var100 := DontCare
  val buf_8 = Module(new ElasticBuffer(32))
  val var101 = buf_8.dataIn
  var101 := DontCare
  val var102 = buf_8.dataOut
  var102 := DontCare
  val const_9 = Module(new Constant(32))
  val var103 = const_9.control
  var103 := DontCare
  val var104 = const_9.dataIn
  var104 := DontCare
  val var105 = const_9.dataOut
  var105 := DontCare
  val b_10 = Module(new Branch(32))
  val var106 = b_10.condition
  var106 := DontCare
  val var107 = b_10.dataIn
  var107 := DontCare
  val var108 = b_10.dataOut apply 0
  var108 := DontCare
  val var109 = b_10.dataOut apply 1
  var109 := DontCare
  val m_11 = Module(new Merge(32)())
  val var110 = m_11.dataIn apply 0
  var110 := DontCare
  val var111 = m_11.dataIn apply 1
  var111 := DontCare
  val var112 = m_11.dataOut
  var112 := DontCare
  val buf_12 = Module(new ElasticBuffer(32))
  val var113 = buf_12.dataIn
  var113 := DontCare
  val var114 = buf_12.dataOut
  var114 := DontCare
  val const_13 = Module(new Constant(32))
  val var115 = const_13.control
  var115 := DontCare
  val var116 = const_13.dataIn
  var116 := DontCare
  val var117 = const_13.dataOut
  var117 := DontCare
  val b_14 = Module(new Branch(32))
  val var118 = b_14.condition
  var118 := DontCare
  val var119 = b_14.dataIn
  var119 := DontCare
  val var120 = b_14.dataOut apply 0
  var120 := DontCare
  val var121 = b_14.dataOut apply 1
  var121 := DontCare
  val m_15 = Module(new Merge(32)())
  val var122 = m_15.dataIn apply 0
  var122 := DontCare
  val var123 = m_15.dataIn apply 1
  var123 := DontCare
  val var124 = m_15.dataOut
  var124 := DontCare
  val buf_16 = Module(new ElasticBuffer(32))
  val var125 = buf_16.dataIn
  var125 := DontCare
  val var126 = buf_16.dataOut
  var126 := DontCare
  val b_17 = Module(new Branch(32))
  val var127 = b_17.condition
  var127 := DontCare
  val var128 = b_17.dataIn
  var128 := DontCare
  val var129 = b_17.dataOut apply 0
  var129 := DontCare
  val var130 = b_17.dataOut apply 1
  var130 := DontCare
  val m_18 = Module(new Merge(32)())
  val var131 = m_18.dataIn apply 0
  var131 := DontCare
  val var132 = m_18.dataIn apply 1
  var132 := DontCare
  val var133 = m_18.dataOut
  var133 := DontCare
  val buf_19 = Module(new ElasticBuffer(32))
  val var134 = buf_19.dataIn
  var134 := DontCare
  val var135 = buf_19.dataOut
  var135 := DontCare
  val b_20 = Module(new Branch(32))
  val var136 = b_20.condition
  var136 := DontCare
  val var137 = b_20.dataIn
  var137 := DontCare
  val var138 = b_20.dataOut apply 0
  var138 := DontCare
  val var139 = b_20.dataOut apply 1
  var139 := DontCare
  val addi_21 = Module(new AddIDynamic(32))
  val var140 = addi_21.operand0
  var140 := DontCare
  val var141 = addi_21.operand1
  var141 := DontCare
  val var142 = addi_21.result
  var142 := DontCare
  val load_22 = Module(new Load(495,32))
  val var143 = load_22.address_in
  var143 := DontCare
  val var144 = load_22.data_out
  var144 := DontCare
  val var145 = load_22.address_out
  var145 := DontCare
  val var146 = load_22.data_in
  var146 := DontCare
  val addi_23 = Module(new AddIDynamic(32))
  val var147 = addi_23.operand0
  var147 := DontCare
  val var148 = addi_23.operand1
  var148 := DontCare
  val var149 = addi_23.result
  var149 := DontCare
  val const_24 = Module(new Constant(32))
  val var150 = const_24.control
  var150 := DontCare
  val var151 = const_24.dataIn
  var151 := DontCare
  val var152 = const_24.dataOut
  var152 := DontCare
  val load_25 = Module(new Load(495,32))
  val var153 = load_25.address_in
  var153 := DontCare
  val var154 = load_25.data_out
  var154 := DontCare
  val var155 = load_25.address_out
  var155 := DontCare
  val var156 = load_25.data_in
  var156 := DontCare
  val subi_26 = Module(new SubIDynamic(32))
  val var157 = subi_26.operand0
  var157 := DontCare
  val var158 = subi_26.operand1
  var158 := DontCare
  val var159 = subi_26.result
  var159 := DontCare
  val const_27 = Module(new Constant(32))
  val var160 = const_27.control
  var160 := DontCare
  val var161 = const_27.dataIn
  var161 := DontCare
  val var162 = const_27.dataOut
  var162 := DontCare
  val outline_0_0 = Module(new outline_0)
  val var163 = outline_0_0.d_var15
  var163 := DontCare
  val var164 = outline_0_0.d_var16
  var164 := DontCare
  val var165 = outline_0_0.d_var17
  var165 := DontCare
  val var166 = outline_0_0.d_var18
  val const_28 = Module(new Constant(32))
  val var167 = const_28.control
  var167 := DontCare
  val var168 = const_28.dataIn
  var168 := DontCare
  val var169 = const_28.dataOut
  var169 := DontCare
  val store_29 = Module(new Store(494,64))
  val var170 = store_29.address_in
  var170 := DontCare
  val var171 = store_29.data_in
  var171 := DontCare
  val var172 = store_29.address_out
  var172 := DontCare
  val var173 = store_29.data_out
  var173 := DontCare
  val f_30 = Module(new Fork(1)(5))
  val var174 = f_30.dataIn
  var174 := DontCare
  val var175 = f_30.dataOut apply 0
  var175 := DontCare
  val var176 = f_30.dataOut apply 1
  var176 := DontCare
  val var177 = f_30.dataOut apply 2
  var177 := DontCare
  val var178 = f_30.dataOut apply 3
  var178 := DontCare
  val var179 = f_30.dataOut apply 4
  var179 := DontCare
  val f_31 = Module(new Fork(32)(2))
  val var180 = f_31.dataIn
  var180 := DontCare
  val var181 = f_31.dataOut apply 0
  var181 := DontCare
  val var182 = f_31.dataOut apply 1
  var182 := DontCare
  val f_32 = Module(new Fork(0)(4))
  val var183 = f_32.dataIn
  var183 := DontCare
  val var184 = f_32.dataOut apply 0
  var184 := DontCare
  val var185 = f_32.dataOut apply 1
  var185 := DontCare
  val var186 = f_32.dataOut apply 2
  var186 := DontCare
  val var187 = f_32.dataOut apply 3
  var187 := DontCare
  val f_33 = Module(new Fork(32)(2))
  val var188 = f_33.dataIn
  var188 := DontCare
  val var189 = f_33.dataOut apply 0
  var189 := DontCare
  val var190 = f_33.dataOut apply 1
  var190 := DontCare
  val f_34 = Module(new Fork(32)(2))
  val var191 = f_34.dataIn
  var191 := DontCare
  val var192 = f_34.dataOut apply 0
  var192 := DontCare
  val var193 = f_34.dataOut apply 1
  var193 := DontCare
  val f_35 = Module(new Fork(32)(2))
  val var194 = f_35.dataIn
  var194 := DontCare
  val var195 = f_35.dataOut apply 0
  var195 := DontCare
  val var196 = f_35.dataOut apply 1
  var196 := DontCare
  val f_36 = Module(new Fork(32)(4))
  val var197 = f_36.dataIn
  var197 := DontCare
  val var198 = f_36.dataOut apply 0
  var198 := DontCare
  val var199 = f_36.dataOut apply 1
  var199 := DontCare
  val var200 = f_36.dataOut apply 2
  var200 := DontCare
  val var201 = f_36.dataOut apply 3
  var201 := DontCare
  var86 <> var75
  var87.bits := 0.U
  var87.valid := true.B
  var92 <> var91
  var89 <> var75
  var94 <> var179
  var95 <> var93
  var90 <> var187
  var103 <> var75
  var104.bits := 493.U
  var104.valid := true.B
  var101 <> var100
  var98 <> var105
  var106 <> var178
  var107 <> var190
  var99 <> var108
  var115 <> var75
  var116.bits := 1.U
  var116.valid := true.B
  var113 <> var112
  var110 <> var117
  var118 <> var177
  var119 <> var114
  var111 <> var193
  var125 <> var124
  var122 <> var182
  var127 <> var176
  var128 <> var126
  var123 <> var129
  var134 <> var133
  var131 <> var181
  var83 <> var196
  var84 <> var189
  var136 <> var175
  var137 <> var195
  var140 <> var201
  var141 <> var192
  var132 <> var142
  var143 <> var200
  var77 <> var145
  var146 <> var78
  var147 <> var199
  var150 <> var186
  var151.bits := 1.U
  var151.valid := true.B
  var148 <> var152
  var153 <> var149
  var79 <> var155
  var156 <> var80
  var157 <> var154
  var160 <> var185
  var161.bits := 1.U
  var161.valid := true.B
  var158 <> var162
  var163 <> var144
  var164 <> var159
  var167 <> var184
  var168.bits := 1.U
  var168.valid := true.B
  var165 <> var169
  var170 <> var198
  var171 <> var166
  var81 <> var172
  var82 <> var173
  var174 <> var85
  var180 <> var88
  var183 <> var96
  var188 <> var102
  var191 <> var120
  var194 <> var135
  var197 <> var138
  var97.ready := true.B
  var109.ready := true.B
  var121.ready := true.B
  var130.ready := true.B
  var139.ready := true.B
  mem_global_0.dataIn(0).valid := outline_0_0.var0
  mem_global_0.dataIn(0).bits := outline_0_0.var1
  mem_global_1.dataIn(0).valid := outline_0_0.var3
  mem_global_1.dataIn(0).bits := outline_0_0.var4
  mem_global_3.dataIn(0).valid := outline_0_0.var9
  mem_global_3.dataIn(0).bits := outline_0_0.var10
  outline_0_0.var2 := var2
  outline_0_0.var5 := var5
  outline_0_0.var11 := var11
  val finish = IO(Input(Bool()))
  mem_0.read_address := DontCare
  mem_0.finish := DontCare
  mem_1.read_address := DontCare
  mem_1.finish := DontCare
  mem_1.finish := finish
  val mem_1_addr = IO(Input(UInt(log2Ceil(494).W)))
  mem_1.read_address := mem_1_addr
  val mem_1_data = IO(Output(UInt(64.W)))
  mem_1_data := mem_1.out_data
  mem_global_0.initMem("data_set/spmv_crs_kernel/mem_0.txt")
  mem_global_1.initMem("data_set/spmv_crs_kernel/mem_1.txt")
  mem_0.initMem("data_set/spmv_crs_kernel/mem_2.txt")
  mem_global_3.initMem("data_set/spmv_crs_kernel/mem_3.txt")
}


