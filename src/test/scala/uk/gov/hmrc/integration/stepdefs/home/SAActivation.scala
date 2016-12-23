package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

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

  And( """^user is on the Your Self Assessment details cannot be shown page with Url and title as expected$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      val currentUrl = webDriver.getCurrentUrl
      val pageTitle = webDriver.getTitle
      assert(currentUrl.contains("/personal-account/self-assessment"), "\nPage url not as expected")
      assert(pageTitle.contains("Your Self Assessment details cannot be shown"), "\nPage title not as expected")

    }
  }

  And( """^user verifies that the chat window is opened as expected$""") {
    () => provisioningCurrentDriver {implicit webDriver =>
      val originalWindowHandle = webDriver.getWindowHandle
      println(originalWindowHandle)
      webDriver.switchTo().window("newwin")
      assert(webDriver.getCurrentUrl.contains("http://webchat-dev.tax.service.gov.uk/webchatprod/templates/chat/hmrc7"), "\nPage url not as expected")
      assert(webDriver.getCurrentUrl.contains("entryPointId=1004"), "\nSPage url not as expected")
      webDriver.switchTo().window(originalWindowHandle)
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
