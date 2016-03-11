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

}
