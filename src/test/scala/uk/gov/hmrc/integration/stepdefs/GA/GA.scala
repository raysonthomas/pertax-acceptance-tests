package uk.gov.hmrc.integration.stepdefs.GA

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class GA extends ScalaDsl with EN {

//  And( """^user sees '(.*)' link for EU Referendum$""") { (link: String) =>
// withCurrentDriver { implicit webDriver =>
//   val href = webDriver.findElement(By.partialLinkText(link)).getAttribute("href")
//   assert(href.contains("eureferendum.gov.uk"), "link href did not match expected")
//
//  }
// }
}