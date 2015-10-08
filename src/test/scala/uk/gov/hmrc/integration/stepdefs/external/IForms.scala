package uk.gov.hmrc.integration.stepdefs.external

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import java.util.ArrayList

import uk.gov.hmrc.integration.utils.TestDataSource._

class IForms extends ScalaDsl with EN {


  And( """^user is able to see IForm section '(.*)'$""") {
    (expectedText: String) =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.getPageSource.contains("Popular forms on GOV.UK"), s"\n$expectedText text was not found on the page")
      }
  }


  When( """^user sees the Iform Link '(.*)' with correct redirection URL '(.*)'$""") {
    (linkName: String, redirectUrl:String) => withCurrentDriver { implicit webDriver =>
      val linkObject = webDriver.findElement(By.linkText(linkName))
      val linkPath = linkObject.getAttribute("href")
     assert(linkPath.equals(redirectUrl), s"$linkPath is not the expected redirection path")
    }
  }


}