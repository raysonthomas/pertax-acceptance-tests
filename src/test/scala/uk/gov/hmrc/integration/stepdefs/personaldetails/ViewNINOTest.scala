package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.IDAActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._

import scala.collection.JavaConversions._

class ViewNINOTest extends ScalaDsl with EN {

  Then( """^NINO (.*) is visible$""") { (nino: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".content__body > p")).filter(_.getText == nino).isEmpty == false,
        s"$nino was not found"
      )
    }
  }

}
