package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.IDAActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._

import scala.collection.JavaConversions._

class ViewNINOTest extends ScalaDsl with EN with Matchers {

  Then("""^'QQ123456A' should be displayed$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.cssSelector(".content__body > p"))
        .filter(_.getText == "CS700100A") should not be 'empty
    }
  }
}
