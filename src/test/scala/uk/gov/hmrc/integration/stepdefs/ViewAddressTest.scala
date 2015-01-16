package uk.gov.hmrc.integration.stepdefs


import cucumber.api.java.{After, Before}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebDriver, By}
import org.scalatest._
import uk.gov.hmrc.integration.page.{LandingPageActions, IDAActions}
import uk.gov.hmrc.integration.selenium.{CurrentDriver, DriverFactory}
import scala.collection.JavaConversions._


class ViewAddressTest extends ScalaDsl with EN with Matchers {

 // throw new RuntimeException

  implicit def webDriver = CurrentDriver.getWebDriver

  val idaActions = new IDAActions

  Then( """^'60 Edinburgh Drive, Bedlington, Northumberland, NE22 6NY' should be displayed as a current address$""") {

    val cta = webDriver.findElements(By.cssSelector(".content__body>address>address"))
    val hs = webDriver.findElements(By.cssSelector(".heading-small"))

    cta.filter(_.getText == "Benton Park View\nLongbenton\nTyne and Wear\nNorth Tyneside\nNE1 1AA") should not be 'empty
    hs.filter(_.getText == "Your address") should not be 'empty
  }
}
