package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.AuthActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._

class SAActivation extends ScalaDsl with EN {

  And( """^user sees the text '(.*)' on SA page$""") {
    (expectedText: String) => provisioningCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was not found on the page")
    }
  }
  And( """^user is on the SA activate page with Url as expected$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      val currentUrl = webDriver.getCurrentUrl
      val pageTitle = webDriver.getTitle
      assert(currentUrl.contains("/service/self-assessment?action=activate&step=enteractivationpin"), "\nSA activation url not as expected")

    }
  }

  And( """^user is on the Your Self Assessment cannot be shown page with Url and title as expected$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      val currentUrl = webDriver.getCurrentUrl
      val pageTitle = webDriver.getTitle
      assert(currentUrl.contains("/personal-account/self-assessment"), "\nSPage url not as expected")
      assert(pageTitle.contains("Your Self Assessment cannot be shown"), "\nPage title not as expected")

    }
  }


  When( """^user sees '(.*)' link on page and its href is as expected$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      val href = webDriver.findElement(By.partialLinkText(linkName)).getAttribute("href")
      assert(href.endsWith("/personal-account/self-assessment"), s"\n'$linkName' link href did not match expected\n")
    }
  }

  When( """^Not Yet activated user clicks on '(.*)' link$""") {
    (link: String) => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.linkText(link)).click()
    }
  }

}
