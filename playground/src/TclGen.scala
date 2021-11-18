package hls

import chisel3._
import chisel3.util._
import chisel3.stage.ChiselStage

object TclGen {
  def apply[T <: RawModule](genT: => T, projectPath: String, topModule: String): Unit = {
    val part = "xc7z020clg484"

    val RTL   = ChiselStage.emitVerilog(genT)
    val IPGen = IPLogger.dumpTcl()

    val projectDir = os.pwd / os.RelPath(projectPath)

    if (os.exists(projectDir))
      os.remove.all(projectDir)
    os.makeDir(projectDir)

    os.write(projectDir / "kernel.v", RTL)

    var TclCode: String = ""
    TclCode = TclCode + "set_part \"" + s"${part}" + "\" \n" + "read_verilog kernel.v\n" + IPLogger.dumpTcl() +
    "synth_ip [get_ips]\n" + 
    s"synth_design -top ${topModule} -part ${part}\n" +
    "create_clock -name clkin -period 5 -add [get_ports clock]\n"
    TclCode = TclCode + "opt_design\n" + "place_design\n" + "route_design\n" + 
    s"report_timing_summary -file timing_summary.rpt\n" + 
    s"report_utilization -file util_summary.rpt"

    os.write(projectDir / "run.tcl", TclCode)
  }
}
