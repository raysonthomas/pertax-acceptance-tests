package uk.gov.hmrc.integration.stepdefs

import scala.collection.JavaConversions._

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.IDAActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class ViewNIN0Test extends ScalaDsl with EN with Matchers {

  val idaActions = new IDAActions

  Then("""^'QQ123456A' should be displayed$""") {
    withCurrentDriver { implicit webDriver =>
      val dds = webDriver.findElements(By.cssSelector(".content__body>p"))
      dds.filter(_.getText == "CS700100A") should not be 'empty
    }
  }
}
