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
11. This will be annoying if you want to build the project with different scala versions. So sbt lets us not to mention the scala version if we provide two %%. This way sbt makes sures to download the correct version of the dependencies based on the scala version used
libraryDependencies += "net.liftweb" %% "lift-util" % "3.1.0"
