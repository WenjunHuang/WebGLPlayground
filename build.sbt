enablePlugins(ScalaJSPlugin,WorkbenchPlugin)
name := "WebGLPlayground"

version := "0.1"

scalaVersion := "2.12.4"
workbenchStartMode := WorkbenchStartModes.OnCompile

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "com.lihaoyi" %%% "scalatags" % "0.6.7"
)