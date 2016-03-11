package uk.gov.hmrc.integration.stepdefs.external

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import java.util.ArrayList

import uk.gov.hmrc.integration.utils.TestDataSource._

class HomePage extends ScalaDsl with EN {

   Then( """^heading '(.*)' is visible$""") {
    (name: String) =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.getPageSource.contains(name), s"\n$name heading was not found in page"
        )
      }
  }

  And( """^user sees text '(.*)' on the home page$""") { (text: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }
}