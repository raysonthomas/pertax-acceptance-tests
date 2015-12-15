package uk.gov.hmrc.integration.stepdefs.service

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebElement}
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.Configuration
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebDriver, By}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import uk.gov.hmrc.integration.page.{GlobalActions, IDAActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.Configuration
import uk.gov.hmrc.integration.utils.TestDataSource._

import scala.collection.JavaConversions._

class UserUplift extends ScalaDsl with EN {

  Then( """^user Christopher Grantham logs into the IV uplift service$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.get("http://localhost:9232/personal-account/start-self-assessment")
      webDriver.findElement(By.cssSelector(".button.button-get-started.start-verify-action")).click()
      webDriver.findElement(By.cssSelector("#userId")).sendKeys("543212300020")
      webDriver.findElement(By.cssSelector("#password")).sendKeys("testing123")
      webDriver.findElement(By.cssSelector(".button")).click()
      webDriver.get("http://localhost:9232/personal-account/full")
    }
  }


  And( """^text '(.*)' is visible on IV Page$""") {(text:String)=>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }

  And( """^user clicks on Success radio button$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-success")).click()

    }
  }

  And( """^user clicks on Locked Out radio button$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-lockedout")).click()

    }
  }

  And( """^user clicks on User Aborted radio button$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-useraborted")).click()

    }
  }

  And( """^user clicks on Insufficient Evidence radio button$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-insufficientevidence")).click()

    }
  }

  And( """^user clicks on Technical Issue radio button$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-technicalissue")).click()

    }
  }

  And( """^user clicks on Timed Out radio button$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-timeout")).click()

    }
  }

  And( """^user clicks on Submit button$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }

  Then( """^user is on the page with title '(.*)' with expected URL$""") {
    (expectedPageTitle: String) => withCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.startsWith(pathForTitle(expectedPageTitle)), s"\n current page URL was:\n $currentUrl \nit did not start with:\n ${pathForTitle(expectedPageTitle)}")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }


  And( """^user sees text '(.*)' on the page$""") {(text:String)=>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }

  And( """^user clicks on Continue button$""") { () =>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#continueFailure")).click()

    }

  }
}