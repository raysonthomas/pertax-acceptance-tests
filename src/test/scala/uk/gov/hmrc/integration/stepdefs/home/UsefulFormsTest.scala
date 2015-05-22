package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

import scala.collection.JavaConversions._

class UsefulFormsTest extends ScalaDsl with EN {

  Given( """^View Income Tax forms link is visible$""") {
    () =>
    withCurrentDriver { implicit webDriver =>
      val testable = "View Income Tax forms"
      assert(webDriver.findElements(By.cssSelector(".useful-forms-row a")).filter(_.getText == testable).nonEmpty,
        s"$testable was not found in '.useful-forms-row' field"
      )
    }
  }

}
