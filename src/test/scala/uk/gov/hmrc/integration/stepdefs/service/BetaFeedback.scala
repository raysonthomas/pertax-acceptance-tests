package uk.gov.hmrc.integration.stepdefs.service

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class BetaFeedback extends ScalaDsl with EN {

  Then( """^the Beta banner is displayed$""") {
    () => withCurrentDriver { implicit webDriver =>
      assert(!webDriver.findElements(By.cssSelector(".beta-banner")).isEmpty, "'.beta-banner' was not found on the page")
    }
  }

  Then( """^the feedback link is displayed$""") {
    () => withCurrentDriver { implicit webDriver =>
      assert(!webDriver.findElements(By.cssSelector("#feedback-link")).isEmpty, "'#feedback-link' was not found on the page")
    }
  }

  Then( """^the feedback url path leads to feedback page$""") {
    () => withCurrentDriver { implicit webDriver =>
      assert(webDriver.findElement(By.cssSelector("#feedback-link")).getAttribute("href").endsWith("/contact/beta-feedback-unauthenticated"),
        "'#feedback-link' url path did not end with '/contact/beta-feedback-unauthenticated'")
    }
  }

}
