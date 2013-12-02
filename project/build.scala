import sbt._
import sbt.Keys._

object Build extends Build {
    lazy val info = Seq(
        name := "interpreter-example",
        organization := "eri",
        version := "0.1-SNAPSHOT",
        scalaVersion := "2.10.3"
    )

    lazy val repos = Seq(
    )

    lazy val libs = Seq(
      "org.scala-lang" % "scala-compiler" % "2.10.3"
    )

    lazy val projectDef = Project(id = "interpreter-example", base = file(".")).
        settings(info: _*).
        settings(resolvers ++= repos,
        libraryDependencies ++= libs,
        autoAPIMappings := true,
        javacOptions in(Compile, test) ++= Seq("-source", "1.6", "-target", "1.6"),
        scalacOptions in(Compile, doc) ++= Seq("-groups", "-implicits", "-diagrams"))

}
