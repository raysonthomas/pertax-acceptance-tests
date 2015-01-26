package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._
import scala.collection.JavaConversions._

class ViewEmailTest extends ScalaDsl with EN with Matchers {
  Then("""^john.densmore@gmail.com is displayed as his email address$""") {
    withCurrentDriver { implicit webDriver =>
  val pd = getTestPersonDetailsByName("John Densmore")
      webDriver.findElements(By.cssSelector(""))
        .filter(_.getText == "pd.contact.e") should not be 'empty
      webDriver.findElements(By.cssSelector(".heading-small"))
        .filter(_.getText == "Your email") should not be 'empty
    }
  }

}
