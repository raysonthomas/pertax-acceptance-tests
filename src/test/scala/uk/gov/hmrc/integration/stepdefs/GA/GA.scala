package uk.gov.hmrc.integration.stepdefs.GA
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class GA extends ScalaDsl with EN {

  And( """^'(.*)' link has Google Analytics tracking enabled$""") { (link: String) =>
  withCurrentDriver { implicit webDriver =>
    val nameOfClass:String = webDriver.findElement(By.linkText(link)).getAttribute("class")
    assert((nameOfClass == "cb-link trackLink"), "Expected classname not found for GA")
  }
 }

    And( """^'(.*)' link on Benefits and Credits page has Google Analytics tracking enabled$""") { (link: String) =>
    withCurrentDriver { implicit webDriver =>
      val nameOfClass:String = webDriver.findElement(By.linkText(link)).getAttribute("class")
      assert((nameOfClass == "trackLink"), "Expected classname not found for GA")
    }
  }

  And( """^Continue button has Google Analytics tracking enabled$""") { () =>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains("data-tcs-ga-event-url"),"The GA url not found on the page" )
    }
  }
}