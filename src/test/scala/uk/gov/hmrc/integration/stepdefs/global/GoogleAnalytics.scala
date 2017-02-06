package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class GoogleAnalytics extends ScalaDsl with EN {

  And("""^clicking the '(.*)' link sends event to google analytics$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      ifCurrentDriverExecutesJavascript { jsExecutor =>
        jsExecutor.executeScript(
          s"""
            |$$('a:contains("$linkName")').attr("href", "#");
            |$$('a:contains("$linkName")').removeAttr('target');
          """.stripMargin
        )
      }
    }
  }
}
