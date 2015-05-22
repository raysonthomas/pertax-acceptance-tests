package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

import scala.collection.JavaConversions._

class UsefulFormsTest extends ScalaDsl with EN {

  Given( """^View Income Tax forms link is visible$""") {
    () =>
    withCurrentDriver { implicit webDriver =>
      val s = "View Income Tax forms"
      val href = "https://www.gov.uk/government/collections/income-tax-forms"
      assert(webDriver.findElements(By.cssSelector(".useful-forms-row a"))
        .filter(e => e.getAttribute("href") == href && e.getText == s).nonEmpty,
        s"$s was not found in '.useful-forms-row' field"
      )
    }
  }

}
