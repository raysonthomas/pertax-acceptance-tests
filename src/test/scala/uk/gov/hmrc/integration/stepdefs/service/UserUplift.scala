package uk.gov.hmrc.integration.stepdefs.service


import cucumber.api.scala.{EN, ScalaDsl}

import org.openqa.selenium.{By, WebElement}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebDriver, By}
import uk.gov.hmrc.integration.page.{GlobalActions, IDAActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

import uk.gov.hmrc.integration.utils.TestDataSource._


class UserUplift extends ScalaDsl with EN {


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

  And( """^user is Locked Out of the service for IV Uplift$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-lockedout")).click()
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }

  And( """^user is Aborted for IV Uplift$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-useraborted")).click()
      webDriver.findElement(By.cssSelector(".button")).click()


    }
  }

  And( """^user has Insufficient Evidence for IV Uplift$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-insufficientevidence")).click()
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }

  And( """^user has technical issues for IV Uplift$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-technicalissue")).click()
      webDriver.findElement(By.cssSelector(".button")).click()


    }
  }

  And( """^user is Timed Out for IV Uplift$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-timeout")).click()
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

  And( """^user Continues the journey to PTA$""") { () =>
    withCurrentDriver { implicit webDriver =>
           webDriver.findElement(By.cssSelector("#continueFailure")).click()

    }
  }

  And( """^user does not go through IV Uplift Journey$""") {()=>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-lockedout")).click()
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }
}