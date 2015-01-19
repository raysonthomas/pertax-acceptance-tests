package uk.gov.hmrc.integration.stepdefs


import scala.collection.JavaConversions._

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.IDAActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class ViewAddressTest extends ScalaDsl with EN with Matchers {

  val idaActions = new IDAActions

  Then("""^'60 Edinburgh Drive, Bedlington, Northumberland, NE22 6NY' should be displayed as a current address$""") {
    withCurrentDriver { implicit webDriver =>
      val cta = webDriver.findElements(By.cssSelector(".content__body>address>address"))
      val hs = webDriver.findElements(By.cssSelector(".heading-small"))

      cta.filter(_.getText == "Benton Park View\nLongbenton\nTyne and Wear\nNorth Tyneside\nNE1 1AA") should not be 'empty
      hs.filter(_.getText == "Your address") should not be 'empty
    }
  }
}
