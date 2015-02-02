package uk.gov.hmrc.integration.stepdefs.landing

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class ViewSummaryTest extends ScalaDsl with EN {

  Given( """^Income Tax Estimate is displayed as (.+)""") { (value: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".bold-large")).filter(_.getText == value).isEmpty == false,
        s"$value not found"
      )
    }
  }

}
