package uk.gov.hmrc.integration.stepdefs


import scala.collection.JavaConversions._
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.IDAActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class ViewAddressTest extends ScalaDsl with EN with Matchers {

  val idaActions = new IDAActions
  
  Then( """^'Address' should be displayed$""") {
    withCurrentDriver { implicit webDriver =>
      val dts = webDriver.findElements(By.cssSelector(".pertax-address-from>dt"))
      val dds = webDriver.findElements(By.cssSelector(".pertax-address-from>dd"))
      val hdl = webDriver.findElements(By.cssSelector(".heading-large"))

      hdl.filter(_.getText == "Address") should not be 'empty

      dts.filter(_.getText == "Address from 23/04/2013") should not be 'empty
      dds.filter(_.getText == "Benton Park View\nLongbenton\nTyne and Wear\nNorth Tyneside\nNE1 1AA") should not be 'empty

      dts.filter(_.getText == "Address from 23/04/2012") should not be 'empty
      dds.filter(_.getText == "MATHESON HOUSE COP TESTING\nGRANGE CENTRAL\nTELFORD\nSHROPSHIRE\nTF3 4HQ") should not be 'empty

      dts.filter(_.getText == "Address from unknown date") should not be 'empty
      dds.filter(_.getText == "Benton Park View\nLongbenton\nTyne and Wear\nNorth Tyneside\nNE1 1AA") should not be 'empty
    }
  }

}
