package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GoogleAnalyticsAssertions
import uk.gov.hmrc.integration.selenium.CurrentDriver._


class NIBucket extends ScalaDsl with EN {

  And("""^an outbound click event to '(.*)' is sent to google analytics$""") {
    (expectedUrl: String) => provisioningCurrentDriver { implicit webDriver =>
      GoogleAnalyticsAssertions.assertGoogleAnalyticsEventSent("outbound", "click", expectedUrl)
    }
  }

  And("""^an link-click language select event to '(.*)' is sent to google analytics$""") {
    (expectedLang: String) => provisioningCurrentDriver { implicit webDriver =>
      GoogleAnalyticsAssertions.assertGoogleAnalyticsEventSent("link - click", "lang-select", expectedLang)
    }
  }

  And("""^a pageview event to '(.*)' is sent to google analytics$""") {
    (expectedAddressURL: String) => provisioningCurrentDriver { implicit webDriver =>
      GoogleAnalyticsAssertions.assertGoogleAnalyticsPageViewSent(expectedAddressURL)
    }
  }

  And( """^user is able to see a section '(.*)' on NI Page$""") {
    (expectedText: String) => provisioningCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was not found on the page")
    }
  }

  And( """^user sees text '(.*)' on the NI page$""") {
    (expectedText: String) => provisioningCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was not found on the page")
    }
  }

  And( """^user sees nino '(.*)' on the NI page$""") {
    (expectedNino: String) => provisioningCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedNino), s"\n'$expectedNino' nino was not found on the page")
    }
  }

  Then( """^user sees link '(.*)' on NI page and its href is as expected$""") {
    (link: String) => provisioningCurrentDriver { implicit webDriver =>
      val linkhref = webDriver.findElement(By.id(link)).getAttribute("href")
      assert(linkhref.contains("/personal-account/do-uplift?redirectUrl"), "Link href is not as expected")
    }
  }

  Then( """^heading '(.*)' is visible on NI page$""") {
    (name: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        assert(webDriver.getPageSource.contains(name), s"\n$name heading was not found in page"
        )
      }
  }

  And( """^user sees nino '(.*)' on the NI Print page$""") {
    (expectedNino: String) => provisioningCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedNino), s"\n'$expectedNino' nino was not found on the page")
    }
  }

  And( """^user sees name and address '(.*)', '(.*)', '(.*)', '(.*)' on the NI Print page$""") {
    (name: String, addressLine1: String, addressLine2: String, postCode: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        val pageSource = webDriver.getPageSource
        assert(pageSource.contains(name), s"\n'$name' name was not found on the page")
        assert(pageSource.contains(addressLine1), s"\n'$addressLine1' address line was not found on the page")
        assert(pageSource.contains(addressLine2), s"\n'$addressLine2' address line was not found on the page")
        assert(pageSource.contains(postCode), s"\n'$postCode' address was not found on the page")
    }
  }

  And( """^user sees name '(.*)' on the NI Print page$""") {
    (expectedName: String) => provisioningCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedName), s"\n'$expectedName' name was not found on the page")
    }
  }


  And( """^user sees today's date on the NI Print page$""") {
    provisioningCurrentDriver { implicit webDriver =>
      val date = org.joda.time.DateTime.now.toString("dd/MM/yyyy")
      assert(webDriver.getPageSource.contains(date), s"\n'$date' Today's date was not found on the page")
    }
  }

  And( """^user clicks the Back button$""") {
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector(".column-half.back-link>a")).click()
    }
  }

}
