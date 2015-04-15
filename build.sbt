sbtPlugin := true

organization := "org.scala-sbt"

name := "sbt-closure"

version <<= sbtVersion(v =>
  if(v.startsWith("0.12")) "0.2.41"
  else if(v.startsWith("0.13")) "0.2.41"
  else sys.error("unsupported sbt version %s" format v)
)

libraryDependencies += "com.google.javascript" % "closure-compiler" % "v20150315"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

scalacOptions := Seq("-deprecation", "-unchecked", "-encoding", "utf8")

homepage := Some(url("https://github.com/alexmnyc/sbt-closure"))

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

seq(bintrayPublishSettings:_*)

bintrayPublishSettings

bintray.Keys.repository in bintray.Keys.bintray := "maven"

licenses  += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))


bintray.Keys.bintrayOrganization in bintray.Keys.bintray := None
