# scala-sbt-prac

1. cd scala-sbt-prac
2. Type sbt enter
3. Type compile enter
4. This creates two directories - project and target
5. All sbt related info are in project directory and all application related info are in target directory
6. build.sbt has the artifact info. They are equivalent to pom.xml
7. sbt commands like show name, show organization will result in printing the values that are declared in build.sbt
8. reload - reloads the project. After #2, imagine you are opening the build.sbt in atom or in any text editor, changing some info and saving it. Now while you are in sbt window you can reload the project using reload command. 
9. Resolvers are the source from which the depedencies are downloaded. In our example it is 
resolvers += "Sonatype Releases Repository" at "https://oss.sonatype.org/content/repositories/releases"
10. Dependencies declared - libraryDependencies += "net.liftweb" % "lift-util_2.11" % "3.1.0". Here _2.11 tells sbt to download the net.liftweb that is compatable for scala 2.11 that we are using.
11. This will be annoying if you want to build the project with different scala versions. So sbt lets us not to mention the scala version if we provide two %% (ibraryDependencies += "net.liftweb" %% "lift-util" % "3.1.0"). This way sbt makes sures to download the correct version of the dependencies based on the scala version used.
12. More than one dependencies can be declaired as follows

libraryDependencies += "net.liftweb" %% "lift-util" % "3.1.0"

libraryDependencies += "net.liftweb" %% "lift-json" % "3.1.0"

14. Since build.sbt is a scala file, we can extract the build version to a variable and have the above in a block as shown below

{  
  val liftVersion = "3.1.0"

  libraryDependencies ++= List(
     "net.liftweb" %% "lift-util" % liftVersion,
     "net.liftweb" %% "lift-json" % liftVersion    
  )
}

15. Publishing - you can publish to many repositories like maven repo etc. 
16. To publish locally - command publishLocal is used. If the version does not end in -SNAPSHOT then they are immutable i.e you cannot publish the same 1.0.0 version twice
17. publishMavenStyle is set to true default. This publishes the project in maven style. If publishMavenStyle is set to false then the pom files will not be generated. 
18. pomExtra is empty by default in sbt. If you want to add extra info to the pom file that is being published then pomExtra can be used. 
example - If you add the following 
pomExtra := <issueManagment><system>GitHub</system><url>www.GitHub.com/hariraogotit</url></issueManagment>
###The following will be in the published pom file
<issueManagment>
        <system>GitHub</system>
        <url>www.GitHub.com/hariraogotit</url>
</issueManagment>

19. publishTo is the settings that points to the remote repo in which the project needs to be published. 
example :- publishTo := Some("Sonatype Release Repository" at "https://oss.sonatype.org/content/repositories/releases")

20. When you execute the command publishTo, the project is published to the remote repo. In our case it will fail as we do not have access. Hence we need to set another property called credentails pointing to a properties file (example - credentials := Credentials(Path.userHome/".ivy2"/credentials)) which  has username password etc. 






