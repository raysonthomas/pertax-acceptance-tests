package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.jsoup.Jsoup
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

import scala.collection.JavaConversions._

class PAFAddress extends ScalaDsl with EN {

  When( """^user selects the address '(.*)' and continues$""") {
    (address: String) =>
      withCurrentDriver { implicit webDriver =>
        if (webDriver.getPageSource.contains(address))
          webDriver.findElement(By.xpath(".//*[@type='radio' and @value='GB990091234582']")).click()
        webDriver.findElement(By.id("submitAddressSelector")).click()
      }
  }
  When( """^address '(.*)','(.*)','(.*)' is displayed$""") {
    (Line1: String, Line2: String, Postcode: String) =>
      withCurrentDriver { implicit webDriver =>
          assert(webDriver.findElement(By.id("line1")).getAttribute("value") == Line1, s"\nexpected text:\n $Line1 did not match actual address line")
          assert(webDriver.findElement(By.id("line2")).getAttribute("value") == Line2, s"\nexpected text:\n $Line2 did not match actual address line")
          assert(webDriver.findElement(By.id("postcode")).getAttribute("value") == Postcode, s"\nexpected text:\n $Postcode did not match actual address line")

      }

  }
}
