name := "pertax-acceptance-tests"

version := "0.0.2"

scalaVersion := "2.11.8"

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

val hmrcRepoHost = java.lang.System.getProperty("hmrc.repo.host", "https://nexus-preview.tax.service.gov.uk")

resolvers ++= Seq(
  "hmrc-snapshots" at hmrcRepoHost + "/content/repositories/hmrc-snapshots",
  "hmrc-releases" at hmrcRepoHost + "/content/repositories/hmrc-releases",
  "typesafe-releases" at hmrcRepoHost + "/content/repositories/typesafe-releases")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "HMRC Bintray" at "https://dl.bintray.com/hmrc/releases"

resolvers += "HMRC Bintray RCs" at "https://dl.bintray.com/hmrc/release-candidates"

val cucumberVersion = "1.2.5"


libraryDependencies ++= Seq(
  "com.codeborne" % "phantomjsdriver" % "1.2.1",
  "org.reactivemongo" %% "reactivemongo" % "0.10.5.0.akka23",
  "org.scala-lang" % "scala-library" % "2.11.8",
  "info.cukes" % "cucumber-junit" % cucumberVersion,
  "info.cukes" % "cucumber-picocontainer" % cucumberVersion,
  "info.cukes" % "cucumber-scala_2.11" % cucumberVersion,
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "uk.gov.hmrc" %% "scala-webdriver" % "5.14.0",
  "org.apache.poi" % "poi-ooxml" % "3.13",
  "org.apache.poi" % "poi-ooxml-schemas" % "3.13",
  "net.sourceforge.htmlunit" % "htmlunit" % "2.19",
  "org.seleniumhq.selenium" % "selenium-htmlunit-driver" % "2.52.0",
  "org.seleniumhq.selenium" % "selenium-java" % "2.53.0",
  "org.seleniumhq.selenium" % "selenium-firefox-driver" % "2.53.0",
  "com.typesafe.play" %% "play-iteratees" % "2.4.6",
  "org.mongodb" %% "casbah" % "3.1.0",
  "com.typesafe.play" %% "play-json" % "2.3.0",
  "org.pegdown" % "pegdown" % "1.6.0" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4",
  "uk.gov.hmrc" %% "accessibility-driver" % "1.6.0",
  "org.scalaj" %% "scalaj-http" % "1.1.0",
  "org.jsoup" % "jsoup" % "1.7.3"

)
