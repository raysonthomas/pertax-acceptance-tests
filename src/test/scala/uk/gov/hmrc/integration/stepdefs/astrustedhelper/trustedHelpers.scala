package uk.gov.hmrc.integration.stepdefs.astrustedhelper

import cucumber.api.scala.{EN, ScalaDsl}
import org.jsoup.Jsoup
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.Configuration

import scala.collection.JavaConversions._

class trustedHelpers extends ScalaDsl with EN {

  Then( """^user clicks on '(.*)' link on Trusted Helpers page$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      webDriver.findElement(By.linkText(linkName)).click()
      (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/stop-helping-this-person")))
    }
  }

}