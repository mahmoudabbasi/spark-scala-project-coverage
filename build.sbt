name := "unitTestScala01"

version := "1.0"

scalaVersion := "2.12.8"

idePackagePrefix := Some("ir.test")

val sparkVersion = "3.1.1"

//resolvers += "Maven Central" at "https://repo1.maven.org/maven2/"

resolvers ++= Seq(
  "Local Maven Central" at "https://repo1.maven.org/maven2/",
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


sonarProperties ++= Map(
  "sonar.projectKey" -> "ir.test:wordcount",
  "sonar.projectName" -> "WordCount Project",
  "sonar.host.url" -> "http://localhost:9000",   // آدرس SonarQube
  "sonar.login" -> "your_token_here",            // توکن ادمین یا پروژه
  "sonar.scala.coverage.reportPaths" -> "target/scala-2.12/scoverage-report/scoverage.xml"
)