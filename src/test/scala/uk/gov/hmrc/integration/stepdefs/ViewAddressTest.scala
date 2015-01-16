package uk.gov.hmrc.integration.stepdefs


import cucumber.api.java.{After, Before}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebDriver, By}
import org.scalatest._
import uk.gov.hmrc.integration.page.{LandingPageActions, IDAActions}
import uk.gov.hmrc.integration.selenium.{CurrentDriver, DriverFactory}
import scala.collection.JavaConversions._


class ViewAddressTest extends ScalaDsl with EN with Matchers {

  throw new RuntimeException

  implicit def webDriver = CurrentDriver.getWebDriver
  
  val idaActions = new IDAActions
  
  Then( """^'Address' should be displayed$""") {

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
