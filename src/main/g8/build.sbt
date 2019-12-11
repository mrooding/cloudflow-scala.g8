import sbt._
import sbt.Keys._

lazy val `$name;format="norm"$` =  (project in file("."))
  $if(enableAkkaStreamsPlugin.truthy)$
  .enablePlugins(CloudflowAkkaStreamsApplicationPlugin)
  $endif$
  $if(enableFlinkPlugin.truthy)$
  .enablePlugins(CloudflowFlinkApplicationPlugin)
  $endif$
  $if(enableSparkPlugin.truthy)$
  .enablePlugins(CloudflowSparkApplicationPlugin)
  $endif$
  .settings(
    libraryDependencies ++= Seq(
      "com.lightbend.akka"     %% "akka-stream-alpakka-file"  % "1.1.2",
      "com.typesafe.akka"      %% "akka-http-spray-json"      % "10.1.10",
      "ch.qos.logback"         %  "logback-classic"           % "1.2.3",
      "com.typesafe.akka"      %% "akka-http-testkit"         % "10.1.10" % "test"
    ),
    name := "$name$",
    organization := "$organization$",
    version := "$version$",
    
    crossScalaVersions := Vector(scalaVersion.value),
    scalacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-target:jvm-1.8",
      "-Xlog-reflective-calls",
      "-Xlint",
      "-Ywarn-unused",
      "-Ywarn-unused-import",
      "-deprecation",
      "-feature",
      "-language:_",
      "-unchecked"
    ),

    scalacOptions in (Compile, console) --= Seq("-Ywarn-unused", "-Ywarn-unused-import"),
    scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value,
  )
