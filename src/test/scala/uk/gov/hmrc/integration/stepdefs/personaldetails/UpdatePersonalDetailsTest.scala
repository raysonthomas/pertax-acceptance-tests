package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._

import scala.collection.JavaConversions._

class UpdatePersonalDetailsTest extends ScalaDsl with EN {

  Then( """^user updates .*'(.*)' with '(.*)'$""") {
    (objID: String,value: String) => withCurrentDriver { implicit webDriver =>
      val field = webDriver.findElement(By.id(objID))
      field.clear()
      field.sendKeys(value)
    }
  }

}