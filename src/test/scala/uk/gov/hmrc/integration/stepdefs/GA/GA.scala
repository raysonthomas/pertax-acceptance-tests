package uk.gov.hmrc.integration.stepdefs.GA
import cucumber.api.scala.{EN, ScalaDsl}
import org.jsoup.Jsoup
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

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
      val selectedSource = Jsoup.parse(webDriver.getPageSource).select( """.send-tcs-ga-event""").head.parent()
      assert(selectedSource.html().contains("http://localhost:9362/tax-credits-service/personal/change-address"), "\nGA Tracking url not found in the section")
//      assert(webDriver.getPageSource.contains("data-tcs-ga-event-url"),"The GA url not found on the page" )
    }
  }
}