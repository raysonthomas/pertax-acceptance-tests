name := "pertax-qa-tests"

version := "0.0.1"

scalaVersion := "2.11.5"

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

val hmrcRepoHost = java.lang.System.getProperty("hmrc.repo.host", "https://nexus-preview.tax.service.gov.uk")

resolvers ++= Seq(
  "hmrc-snapshots" at hmrcRepoHost + "/content/repositories/hmrc-snapshots",
  "hmrc-releases" at hmrcRepoHost + "/content/repositories/hmrc-releases",
  "typesafe-releases" at hmrcRepoHost + "/content/repositories/typesafe-releases")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "HMRC Bintray" at "https://dl.bintray.com/hmrc/releases"

resolvers += "HMRC Bintray RCs" at "https://dl.bintray.com/hmrc/release-candidates"


libraryDependencies ++= Seq(
  "com.github.detro.ghostdriver" % "phantomjsdriver" % "1.1.0",
  "org.reactivemongo" %% "reactivemongo" % "0.10.5.0.akka23",
  "org.seleniumhq.selenium" % "selenium-java" % "2.45.0",
  "org.seleniumhq.selenium" % "selenium-firefox-driver" % "2.45.0",
  "com.typesafe.play" %% "play-json" % "2.3.0",
  "org.scalatest" %% "scalatest" % "2.2.1",
  "org.pegdown" % "pegdown" % "1.1.0" % "test",
  "org.scala-lang" % "scala-library" % "2.10.4",
  "org.scalaj" %% "scalaj-http" % "1.1.0",
  "info.cukes" % "cucumber-scala_2.11" % "1.2.2",
  "info.cukes" % "cucumber-junit" % "1.2.2",
  "info.cukes" % "cucumber-picocontainer" % "1.2.2",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test",
  "uk.gov.hmrc" %% "accessibility-driver" % "1.6.0"
)
