name := "WebGLPlayground"

version := "0.1"
scalaVersion := "2.12.4"
workbenchStartMode := WorkbenchStartModes.OnCompile
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-Xlint",
  "-Ywarn-unused",
  "-Ywarn-dead-code",
  "-feature",
  "-language:_"
)

lazy val myMacros = (project in file("macros")).settings(
  scalaVersion := "2.12.4",
  libraryDependencies ++= Seq("org.scala-lang" % "scala-reflect" % scalaVersion.value)
)

lazy val root = (project in file(".")).settings(
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.6",
    "com.lihaoyi" %%% "scalatags" % "0.6.7"
  ),
  jsDependencies ++= Seq(
    "org.webjars.npm" % "gl-matrix" % "2.7.1" / "dist/gl-matrix-min.js"
  ),
  skip in packageJSDependencies := false
).dependsOn(myMacros)
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)