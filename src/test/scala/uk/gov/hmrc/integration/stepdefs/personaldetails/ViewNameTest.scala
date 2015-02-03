package uk.gov.hmrc.integration.stepdefs.personaldetails

import uk.gov.hmrc.integration.utils.TestDataSource._

import scala.collection.JavaConversions._
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.{GlobalActions, IDAActions, LandingPageActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

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