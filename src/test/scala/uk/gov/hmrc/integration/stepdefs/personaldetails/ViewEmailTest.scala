package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._
import scala.collection.JavaConversions._

class ViewEmailTest extends ScalaDsl with EN with Matchers {

  Then( """^(.*) is displayed as email address$""") {
    (email: String) =>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.cssSelector(""))
        .filter(_.getText == s"$email") should not be 'empty
    }
  }

}
