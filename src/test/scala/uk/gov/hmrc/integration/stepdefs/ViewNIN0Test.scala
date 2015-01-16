package uk.gov.hmrc.integration.stepdefs

import cucumber.api.java.{After, Before}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebDriver, By}
import org.scalatest._
import uk.gov.hmrc.integration.page.{LandingPageActions, IDAActions}
import uk.gov.hmrc.integration.selenium.{CurrentDriver, DriverFactory}
import scala.collection.JavaConversions._


class ViewNIN0Test extends ScalaDsl with EN with Matchers {

  implicit def webDriver = CurrentDriver.getWebDriver

  val idaActions = new IDAActions

  Then( """^'QQ123456A' should be displayed$""") {
    val dds = webDriver.findElements(By.cssSelector(".content__body>p"))
    dds.filter(_.getText == "CS700100A") should not be 'empty
  }

}
