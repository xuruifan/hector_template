import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.experimental.BundleLiterals._
import utest._
import testing._
import chisel3.experimental._
import hls._

class main extends MultiIOModule {
  val var0 = IO(Flipped(DecoupledIO(UInt(32.W))))
  val var1 = IO(DecoupledIO(UInt(32.W)))
  var1 := DontCare
  val m1 = Module(new Merge()())
  val var2 = m1.dataIn apply 0
  var2 := DontCare
  val var3 = m1.dataIn apply 1
  var3 := DontCare
  val var4 = m1.dataOut
  var4 := DontCare
  val m2 = Module(new Merge()())
  val var5 = m2.dataIn apply 0
  var5 := DontCare
  val var6 = m2.dataIn apply 1
  var6 := DontCare
  val var7 = m2.dataOut
  var7 := DontCare
  val f1 = Module(new Fork()(3))
  val var8 = f1.dataIn
  var8 := DontCare
  val var9 = f1.dataOut apply 0
  var9 := DontCare
  val var10 = f1.dataOut apply 1
  var10 := DontCare
  val var11 = f1.dataOut apply 2
  var11 := DontCare
  val f2 = Module(new Fork()())
  val var12 = f2.dataIn
  var12 := DontCare
  val var13 = f2.dataOut apply 0
  var13 := DontCare
  val var14 = f2.dataOut apply 1
  var14 := DontCare
  val b1 = Module(new Branch())
  val var15 = b1.condition
  var15 := DontCare
  val var16 = b1.dataIn
  var16 := DontCare
  val var17 = b1.dataOut apply 0
  var17 := DontCare
  val var18 = b1.dataOut apply 1
  var18 := DontCare
  val b2 = Module(new Branch())
  val var19 = b2.condition
  var19 := DontCare
  val var20 = b2.dataIn
  var20 := DontCare
  val var21 = b2.dataOut apply 0
  var21 := DontCare
  val var22 = b2.dataOut apply 1
  var22 := DontCare
  val eq = Module(new GreaterthanIDynamic())
  val var23 = eq.operand0
  var23 := DontCare
  val var24 = eq.operand1
  var24 := DontCare
  val var25 = eq.result
  var25 := DontCare
  val a1 = Module(new AddIDynamic())
  val var26 = a1.operand0
  var26 := DontCare
  val var27 = a1.operand1
  var27 := DontCare
  val var28 = a1.result
  var28 := DontCare
  val a2 = Module(new AddIDynamic())
  val var29 = a2.operand0
  var29 := DontCare
  val var30 = a2.operand1
  var30 := DontCare
  val var31 = a2.result
  var31 := DontCare
  var3.bits := 0.U
  var3.valid := true.B
  var6.bits := 0.U
  var6.valid := true.B
  var8 <> var4
  var2 <> var17
  var5 <> var21
  var23 <> var9
  var12 <> var25
  var15 <> var13
  var19 <> var14
  var26 <> var10
  var27.bits := 1.U
  var27.valid := true.B
  var16 <> var28
  var29 <> var11
  var30 <> var7
  var20 <> var31
}

object Elaborate extends App {
  //  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new branch_prediction())))
  //  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new main())))
  // (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new main())))
  val stage = new chisel3.stage.ChiselStage
  stage.emitVerilog(new FMul64)
  stage.emitVerilog(new FMul64)
  stage.emitVerilog(new FMul32)
  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new ReadWriteMem(1024))))
}

