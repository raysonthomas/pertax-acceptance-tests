package uk.gov.hmrc.integration.stepdefs

import uk.gov.hmrc.integration.utils.TestDataSource._

import scala.collection.JavaConversions._

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.{GlobalActions, IDAActions, LandingPageActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class ViewNameTest extends ScalaDsl with EN with Matchers {

  Then( """^Mr John Densmore is displayed$""") {
    withCurrentDriver { implicit webDriver =>
      val pd = getTestPersonDetailsByName("John Densmore")
      webDriver.findElements(By.cssSelector(".content__body > p"))
        .filter(_.getText == pd.person.titledName) should not be 'empty
    }
  }

}