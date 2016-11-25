package uk.gov.hmrc.integration.stepdefs

import java.awt._
import java.io.{BufferedWriter, File, FileWriter}
import javax.imageio.ImageIO

import cucumber.api.Scenario
import cucumber.api.java.{After, Before}
import cucumber.api.scala.{EN, ScalaDsl}
import org.apache.commons.io.FileUtils
import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.Augmenter
import org.scalatest.Matchers
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.{CurrentDriver, Snapshotter}
import uk.gov.hmrc.integration.utils.Configuration

import scala.List
import scala.io.Source
import scala.tools.nsc.doc.html.HtmlPage
import scala.util.{Random, Try}
import scala.xml.NodeSeq



class Hooks extends ScalaDsl with EN with Matchers {

  val urlList: List[String] = List()
  @Before
  def initialize = {

  }

  //Executes after each scenario in a feature
  @After
  def tearDown(result: Scenario){

    if (result.isFailed) {
      ifCurrentDriverTakesSnapshot {
        takesSnapshot =>
        Snapshotter.takeErrorSnapshot(takesSnapshot, result)
      }
    }

    if (Configuration.getUrlScreenshots) {
      val newFile = new File(System.getProperty("user.dir") + "/target/cucumber/urlList.html")

      val pageUrl = getWebDriver.getCurrentUrl().replace("http://localhost:9232", "")

      if (!newFile.exists()) {
        newFile.createNewFile()
      }

      val urlListString = Source.fromFile(newFile).getLines.mkString

      if (!urlListString.contains(pageUrl)) {
        ifCurrentDriverTakesSnapshot { takesSnapShot =>
          Snapshotter.takeSnapshot(takesSnapShot, result)

          val pngQuantity = Option(new File(System.getProperty("user.dir") + "/target/cucumber/images").list).map(_.filter(_.endsWith(".png")).size).getOrElse(0)
          Try(new File(System.getProperty("user.dir") + "/target/cucumber/images/urlScreenshot.png")
            .renameTo(new File(System.getProperty("user.dir") + "/target/cucumber/images/pertaxUrl" + pngQuantity + ".png"))).getOrElse(false)

          val imageFile = new File("images/pertaxUrl" + pngQuantity + ".png")
          val html = "<li><a href='" + imageFile + "'>" + pageUrl + "</a></li>"
          val bufferWriter = new BufferedWriter(new FileWriter(newFile, true))
          bufferWriter.write(html)
          bufferWriter.close()
        }
      }
    }
    CurrentDriver.clearSession()
  }
}

