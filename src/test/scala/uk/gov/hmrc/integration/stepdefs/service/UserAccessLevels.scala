package uk.gov.hmrc.integration.stepdefs.service

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class UserAccessLevels extends ScalaDsl with EN {


  Then( """^user sees name '(.*)' on the page$""") {
    (name: String) =>
      withCurrentDriver { implicit webDriver =>
        if(webDriver.getPageSource.contains(name)) {
        val actualName = webDriver.findElement(By.cssSelector(".heading-xlarge.no-margin-bottom")).getText
        assert(name == actualName, s"$name did not match $actualName")
      }
        else
          assert(name=="none",s"$name present when not expected")
      }
  }


  Then( """^user sees nino '(.*)' on the page$""") {
    (nino: String) =>
      withCurrentDriver { implicit webDriver =>
        if(webDriver.getPageSource.contains(nino)) {
          val actualNino = webDriver.findElement(By.cssSelector(".gray-sub-heading")).getText
          assert(actualNino contains(nino), s"$nino did not match $actualNino")
        }
        else
          assert(nino=="none",s"$nino present when not expected")
      }
  }

  And( """^user can not see '(.*)' section$""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      assert(!webDriver.getPageSource.contains(linkName), s"$linkName is present on the page while it should not be")
    }
  }

  And( """^user can not see '(.*)' link$""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      println(webDriver.getPageSource)
      assert(!webDriver.getPageSource.contains(linkName), s"$linkName is present on the page while it should not be")
    }
  }

  And( """^user sees '(.*)' section$""") {
    (text: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"$text is not present on the page while it should be")
    }
  }

  Then( """^text '(.*)' is visible on the page$""") {
    (saText: String) =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.getPageSource.contains(saText), s"\n$saText text was not found on page while it should be")
      }
  }


}