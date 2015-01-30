package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._
import scala.collection.JavaConversions._

class ViewEmailTest extends ScalaDsl with EN with Matchers {

  Then( """^rjeffries@example.com is displayed as email address$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.cssSelector(".content__body>p:nth-of-type(3)"))
        .filter(_.getText == "rjeffries@example.com") should not be 'empty
    }
  }

  Then( """^Your email header field is not displayed$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.cssSelector(".heading-small:nth-of-type(4)"))
        .filter(_.getText == "") should not be 'empty
    }
  }
  
}
