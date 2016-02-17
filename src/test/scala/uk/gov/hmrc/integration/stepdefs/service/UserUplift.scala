package uk.gov.hmrc.integration.stepdefs.service


import java.net.URL

import cucumber.api.scala.{EN, ScalaDsl}

import org.openqa.selenium.{By, WebElement}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebDriver, By}
import uk.gov.hmrc.integration.page.{GlobalActions, IDAActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

import uk.gov.hmrc.integration.utils.TestDataSource._


class UserUplift extends ScalaDsl with EN {


  And( """^text '(.*)' is visible on IV Page$""") { (text: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }

  And( """^user clicks on Success radio button$""") { () =>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-success")).click()

    }
  }

  And( """^user is Locked Out of the service for IV Uplift$""") { () =>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-lockedout")).click()
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }

  And( """^user Aborts the IV Uplift$""") { () =>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-useraborted")).click()
      webDriver.findElement(By.cssSelector(".button")).click()


    }
  }

  And( """^user has an Incomplete journey$""") { () =>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-incomplete")).click()
      webDriver.findElement(By.cssSelector(".button")).click()


    }
  }

  And( """^user has Precondition Failed$""") { () =>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-preconditionfailed")).click()
      webDriver.findElement(By.cssSelector(".button")).click()


    }
  }

  And( """^user has Insufficient Evidence for IV Uplift$""") { () =>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-insufficientevidence")).click()
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }

  And( """^user has technical issues for IV Uplift$""") { () =>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-technicalissue")).click()
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


  And( """^user sees text '(.*)' on the page$""") { (text: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }

  And( """^user is asked to complete the IV Uplift journey$""") { () =>
    withCurrentDriver { implicit webDriver =>
      val text:String ="Identity Verification Stub"
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }


  And( """^user Continues the journey to PTA$""") { () =>
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#continue")).click()

      if (new URL(webDriver.getCurrentUrl).getPath.startsWith("/paperless/choose/")) {
        webDriver.findElement(By.xpath(".//*[@id='opt-in-out']")).click()
        webDriver.findElement(By.xpath(".//*[@id='submitEmailButton']")).click()
      }
    }

  }
}
