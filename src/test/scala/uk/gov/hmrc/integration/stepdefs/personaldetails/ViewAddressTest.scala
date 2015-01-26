package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class ViewAddressTest extends ScalaDsl with EN with Matchers {

  Then("""^Benton Park View, Longbenton, Tyne and Wear, North Tyneside, NE1 1AA should be displayed as a current address$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.cssSelector(".content__body > address > address"))
        .filter(_.getText == "Benton Park View\nLongbenton\nTyne and Wear\nNorth Tyneside\nNE1 1AA") should not be 'empty
      webDriver.findElements(By.cssSelector(".heading-small"))
        .filter(_.getText == "Your address") should not be 'empty
    }
  }
}
