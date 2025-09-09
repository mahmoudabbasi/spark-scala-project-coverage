name := "unitTestScala01"

version := "1.0"

scalaVersion := "2.12.8"

idePackagePrefix := Some("ir.test")

val sparkVersion = "3.1.1"

//resolvers += "Maven Central" at "https://repo1.maven.org/maven2/"

resolvers ++= Seq(
  "Local Maven Central" at "https://repo1.maven.org/maven2/",
//  "Local Maven Repo 1" at "https://repo.sadad.co.ir/repository/BCS-maven-release/",
//  "Local Maven Repo 2" at "https://repo.sadad.co.ir/repository/oxygen-maven-group/",
//  "Local Maven Repo 3" at "https://nexus.sadad.local/repository/maven-group/",
//  "Local Maven Repo 4" at "https://repo.sadad.co.ir/repository/oxygen-maven-group/",
//  "Local Maven Repo 5" at "https://nexus.sadad.local/repository/maven-releases/",
//  "Local Maven Repo 6" at "https://repo.sadad.co.ir/repository/oxygen-maven-snapshots/",
//  "Local Maven Repo 7" at "https://repo.sadad.co.ir/repository/oxygen-maven-releases/"
)
//credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")



libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.scalatest" %% "scalatest" % "3.2.16" % Test,
  "org.scoverage" %% "scalac-scoverage-plugin" % "1.3.1"

)