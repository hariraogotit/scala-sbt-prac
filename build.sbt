name := "Animals"

organization := "farm"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.6"

resolvers += "Sonatype Releases Repository" at "https://oss.sonatype.org/content/repositories/releases"

{
  val liftVersion = "3.1.0"

  libraryDependencies ++= List(
     "net.liftweb" %% "lift-util" % liftVersion,
     "net.liftweb" %% "lift-json" % liftVersion
  )
}
