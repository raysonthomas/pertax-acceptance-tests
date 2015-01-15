package uk.gov.hmrc.integration.stepdefs


import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.{LandingPageActions, IDAActions}
import uk.gov.hmrc.integration.selenium.DriverContainer._
import scala.collection.JavaConversions._


class ViewAddressTest extends ScalaDsl with EN with Matchers {



    Then( """^"'Address' should be displayed$""") {
      () => {

      }
    }

}
