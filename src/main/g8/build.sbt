import sbt._
import sbt.Keys._

lazy val `$name;format="norm"$` =  (project in file("."))
  .enablePlugins(CloudflowAkkaStreamsApplicationPlugin)
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

    scalaVersion := "2.12.10",
    crossScalaVersions := Vector(scalaVersion.value)
  )
