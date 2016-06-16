package uk.gov.hmrc.integration.stepdefs.TCS

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._


class BenefitsandCredits extends ScalaDsl with EN {


  And( """^text '(.*)' is visible on Benefits and Credits Page$""") {(text:String)=>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }

  And( """^text '(.*)' is visible on Tax credits Page$""") {(text:String)=>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }

  And( """^text '(.*)' is visible on Child Benefit Page$""") {(text:String)=>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }


}