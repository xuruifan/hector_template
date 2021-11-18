package hls
import scala.collection.mutable.TreeMap

object IPLogger {
  private var IPLog = new TreeMap[String, TreeMap[String, String]]

  /**
    * @param moduleName
    * @param configDict  The dictionary of IP configurations which will be printed in Tcl form.
    *                    Some fields are required. Such as ""
    */
  def addIP(moduleName: String, configDict: TreeMap[String, String]): Unit = {
    val config = IPLog.get(moduleName)
    config match {
      case None => {
        IPLog.update(moduleName, configDict)
      }
      case Some(x) => ()
    }
  }
  def dumpTcl(): String = {
    var result_str = "": String

    for (x <- IPLog) {
      val moduleName = x._1
      val dict       = x._2

      val ip_name = dict("ip_name")
      val version = dict("version")
      val create_ip_cmd =
        s"create_ip -name ${ip_name} -vendor xilinx.com -library ip -version ${version} -module_name ${moduleName}\n"
      var config_dict_str = "": String
      for (entry <- dict) {
        if (entry._1 != "ip_name" && entry._1 != "version")
          config_dict_str = config_dict_str + "CONFIG." + entry._1 + " " + entry._2 + " "
      }
      // TODO FIXME
      // config_dict_str = config_dict_str + "CONFIG.maximum_latency false "
      // config_dict_str = config_dict_str + "CONFIG.has_result_tready false "
      // config_dict_str = config_dict_str + "CONFIG.flow_control NonBlocking "
      val config_cmd = s"set_property -dict [list ${config_dict_str}] -object [get_ips ${moduleName}] \n"
      result_str = result_str + create_ip_cmd + config_cmd
      //val config_cmd = s"set_property -dict [list CONFIG.Component_Name {${module_Name}} CONFIG.Operation_Type {${op_type}}] [get_ips ${moduleName}]"
    }

    result_str = result_str + "generate_target all [get_ips] \n"
    result_str
  }
}
