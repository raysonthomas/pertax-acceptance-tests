package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

import scala.collection.JavaConversions._

class ViewNameTest extends ScalaDsl with EN {

  Then( """^Name (.*) is visible$""") { (name: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".personal-details > p")).filter(_.getText == name).isEmpty == false,
        s"$name was not found"
      )
    }
  }

}