package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

import scala.collection.JavaConversions._

class ViewEmailTest extends ScalaDsl with EN {

  Then( """^(.*) is displayed as email address$""") { (email: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".content__body > p")).filter(_.getText == email).isEmpty == false,
        s"$email was not found"
      )
    }
  }

  Then( """^(.*) label is not displayed$""") { (emailField:String)  =>
    withCurrentDriver { implicit webDriver =>
      assert( !webDriver.findElement(By.cssSelector("#content")).getText.contains("Your email"), s"'$emailField' was found" )
    }
  }
  }