package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._

class NIBucket extends ScalaDsl with EN {

  And( """^user is able to see a section '(.*)' on NI Page$""") {
    (expectedText: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was not found on the page")
    }
  }

  And( """^user sees text '(.*)' on the NI page$""") {
    (expectedText: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was not found on the page")
    }
  }

  And( """^user sees nino '(.*)' on the NI page$""") {
    (expectedNino: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedNino), s"\n'$expectedNino' nino was not found on the page")
    }
  }

  Then( """^user sees link '(.*)' on NI page and its href is as expected$""") {
    (link: String) => withCurrentDriver { implicit webDriver =>
      val linkhref = webDriver.findElement(By.id(link)).getAttribute("href")
      assert(linkhref.contains("/personal-account/do-uplift?redirectUrl"), "Link href is not as expected")
    }
  }

  Then( """^heading '(.*)' is visible on NI page$""") {
    (name: String) =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.getPageSource.contains(name), s"\n$name heading was not found in page"
        )
      }
  }

  And( """^user sees nino '(.*)' on the NI Print page$""") {
    (expectedNino: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedNino), s"\n'$expectedNino' nino was not found on the page")
    }
  }

  And( """^user sees name and address '(.*)', '(.*)', '(.*)', '(.*)' on the NI Print page$""") {
    (name: String, addressLine1: String, addressLine2: String, postCode: String) =>
      withCurrentDriver { implicit webDriver =>
        val pageSource = webDriver.getPageSource
        assert(pageSource.contains(name), s"\n'$name' name was not found on the page")
        assert(pageSource.contains(addressLine1), s"\n'$addressLine1' address line was not found on the page")
        assert(pageSource.contains(addressLine2), s"\n'$addressLine2' address line was not found on the page")
        assert(pageSource.contains(postCode), s"\n'$postCode' address was not found on the page")
    }
  }

  And( """^user sees name '(.*)' on the NI Print page$""") {
    (expectedName: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedName), s"\n'$expectedName' name was not found on the page")
    }
  }


  And( """^user sees today's date on the NI Print page$""") {
    withCurrentDriver { implicit webDriver =>
      val date = org.joda.time.DateTime.now.toString("dd/MM/yyyy")
      assert(webDriver.getPageSource.contains(date), s"\n'$date' Today's date was not found on the page")
    }
  }

  And( """^user clicks the Back button to go back to account home$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector(".column-half.back-link>a")).click()
    }
  }

}
