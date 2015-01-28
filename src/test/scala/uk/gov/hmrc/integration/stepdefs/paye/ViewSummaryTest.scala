package uk.gov.hmrc.integration.stepdefs.paye

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class ViewSummaryTest extends ScalaDsl with EN with Matchers {

  Given( """^Income Tax Estimate is displayed as 5,445$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.cssSelector(""))
        .filter(_.getText == "£5,445") should not be 'empty
    }
  }

}
