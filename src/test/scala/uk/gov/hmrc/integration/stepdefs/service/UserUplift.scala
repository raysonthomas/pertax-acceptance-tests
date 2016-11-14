package uk.gov.hmrc.integration.stepdefs.service


import java.net.URL

import cucumber.api.scala.{EN, ScalaDsl}

import org.openqa.selenium.{By, WebElement}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebDriver, By}
import uk.gov.hmrc.integration.page.{GlobalActions, AuthActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

import uk.gov.hmrc.integration.utils.TestDataSource._


class UserUplift extends ScalaDsl with EN {


  And( """^text '(.*)' is visible on IV Page$""") { (text: String) =>
    provisioningCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }

  And( """^user clicks on Success radio button$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-success")).click()

    }
  }

  And( """^user is Locked Out of the service for IV Uplift$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-lockedout")).click()
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }

  And( """^user Aborts the IV Uplift$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-useraborted")).click()
      webDriver.findElement(By.cssSelector(".button")).click()


    }
  }

  And( """^user has an Incomplete journey$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-incomplete")).click()
      webDriver.findElement(By.cssSelector(".button")).click()


    }
  }

  And( """^user has Precondition Failed for IV Uplift$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-preconditionfailed")).click()
      webDriver.findElement(By.cssSelector(".button")).click()


    }
  }

  And( """^user has Insufficient Evidence for IV Uplift$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-insufficientevidence")).click()
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }

  And( """^user Failed Matching for IV Uplift$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-failedmatching")).click()
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }

  And( """^user has technical issues for IV Uplift$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#requiredResult-technicalissue")).click()
      webDriver.findElement(By.cssSelector(".button")).click()


    }
  }


  Then( """^user is on the page with title '(.*)' with expected URL$""") {
    (expectedPageTitle: String) => provisioningCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.startsWith(pathForTitle(expectedPageTitle)), s"\n current page URL was:\n $currentUrl \nit did not start with:\n ${pathForTitle(expectedPageTitle)}")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")

    }
  }


  And( """^user sees text '(.*)' on the page$""") { (text: String) =>
    provisioningCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }

  And( """^user is asked to complete the IV Uplift journey$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      val text:String ="Identity Verification Stub"
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }
  And( """^User added in Exception List$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>

      webDriver.get("localhost:8533/enrolment-exception-list")
      webDriver.findElement(By.cssSelector("#reference")).sendKeys("123459876")
      webDriver.findElement(By.cssSelector("#name")).sendKeys("R T")
      webDriver.findElement(By.cssSelector("#reason")).sendKeys("Test Exception")
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }


  And( """^user Continues the journey to PTA$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("#continue")).click()

      if (new URL(webDriver.getCurrentUrl).getPath.startsWith("/paperless/choose/")) {
        webDriver.findElement(By.xpath(".//*[@id='opt-in-out']")).click()
        webDriver.findElement(By.xpath(".//*[@id='submitEmailButton']")).click()
      }
    }

  }
}
