// import Mill dependency
import mill._
import mill.scalalib._
import mill.scalalib.scalafmt.ScalafmtModule
import mill.scalalib.publish._
import coursier.maven.MavenRepository
import mill.scalalib.TestModule.Utest
// support BSP
import mill.bsp._

val defaultVersions = Map(
  "chisel3" -> "3.3-SNAPSHOT",
)

def getVersion(dep: String, org: String = "edu.berkeley.cs") = {
  val version = sys.env.getOrElse(dep + "Version", defaultVersions(dep))
  ivy"$org::$dep:$version"
}

object hardfloat extends ScalaModule with SbtModule with PublishModule { m =>
  def scalaVersion = "2.12.8"
  // different scala version shares same sources
  // mill use foo/2.11.12 foo/2.12.11 as millSourcePath by default

  def chisel3Module: Option[PublishModule] = None

  def chisel3IvyDeps = if(chisel3Module.isEmpty) Agg(
    getVersion("chisel3")
  ) else Agg.empty[Dep]

  def moduleDeps = super.moduleDeps ++ chisel3Module 

  def ivyDeps = super.ivyDeps() ++ chisel3IvyDeps

  def scalacOptions = Seq("-Xsource:2.11")

  def publishVersion = "1.3-SNAPSHOT"
  
  def artifactName = "hardfloat"

  def repositories() = super.repositories ++ Seq(
    MavenRepository("https://oss.sonatype.org/content/repositories/snapshots"),
    MavenRepository("https://oss.sonatype.org/service/local/staging/deploy/maven2")
  )

  object test extends Tests {
    def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.2.0")
    def testFrameworks = Seq("org.scalatest.tools.Framework")
  }

  def pomSettings = PomSettings(
    description = artifactName(),
    organization = "edu.berkeley.cs",
    url = "http://chisel.eecs.berkeley.edu",
    licenses = Seq(License.`BSD-3-Clause`),
    versionControl = VersionControl.github("ucb-bar", "berkeley-hardfloat"),
    developers = Seq(
      Developer("jhauser-ucberkeley", "John Hauser", "https://www.colorado.edu/faculty/hauser/about/"),
      Developer("aswaterman", "Andrew Waterman", "https://aspire.eecs.berkeley.edu/author/waterman/"),
      Developer("yunsup", "Yunsup Lee", "https://aspire.eecs.berkeley.edu/author/yunsup/")
    )
  )
}

object playground extends ScalaModule with ScalafmtModule { m =>
  def moduleDeps = Seq(hardfloat)
  override def scalaVersion = "2.12.13"
  override def scalacOptions = Seq(
    "-Xsource:2.11",
    "-language:reflectiveCalls",
    "-deprecation",
    "-feature",
    "-Xcheckinit",
    // Enables autoclonetype2 in 3.4.x (on by default in 3.5)
    "-P:chiselplugin:useBundlePlugin"
  )
  override def ivyDeps = Agg(
    ivy"edu.berkeley.cs::chisel3:3.4.3",
    // ivy"edu.berkeley.cs::hardfloat:1.2.4"
  )
  override def scalacPluginIvyDeps = Agg(
    ivy"edu.berkeley.cs:::chisel3-plugin:3.4.3",
    ivy"org.scalamacros:::paradise:2.1.1"
  )
  object test extends Tests with Utest {
    override def ivyDeps = m.ivyDeps() ++ Agg(
      ivy"com.lihaoyi::utest:0.7.10",
      ivy"edu.berkeley.cs::chiseltest:0.3.3",
    )
  }
}
