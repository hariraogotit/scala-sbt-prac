name := "Animals"

organization := "farm"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.6"

resolvers += "Sonatype Releases Repository" at "https://oss.sonatype.org/content/repositories/releases"

val liftVersion = "3.1.0"

// pomExtra := <issueManagment><system>GitHub</system><url>www.GitHub.com/hariraogotit</url></issueManagment>
//
// publishTo := Some("Sonatype Release Repository" at "https://oss.sonatype.org/content/repositories/releases")
//
// credentials := Credentials(Path.userHome/".ivy2"/credentials)

lazy val animals = project in file("animals")

lazy val animalsCopy = (project in file("animals-copy"))
                            .settings(
                              libraryDependencies ++=List(
                                "net.liftweb" %% "lift-util" % liftVersion,
                                "net.liftweb" %% "lift-json" % liftVersion
                              )
                            )
                            .dependsOn(animals)  
