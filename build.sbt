
organization := "com.shareaholic"

name := "slf4s"

version := "1.0.0"

scalaVersion := "2.9.2"

crossScalaVersions := Seq(
  "2.8.0",
  "2.8.2",
  "2.9.1",
  "2.9.2",
  "2.10.1")

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.5")

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

publishTo <<= version { v: String =>
  val nexus = "http://ec2-54-242-229-18.compute-1.amazonaws.com:8081/nexus/content/repositories/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "snapshots")
  else
    Some("releases" at nexus + "releases")
}

resolvers ++= Seq(
  "shareaholic-snapshots" at "http://ec2-54-242-229-18.compute-1.amazonaws.com:8081/nexus/content/repositories/snapshots",
  "shareaholic-releases" at "http://ec2-54-242-229-18.compute-1.amazonaws.com:8081/nexus/content/repositories/releases"
)
