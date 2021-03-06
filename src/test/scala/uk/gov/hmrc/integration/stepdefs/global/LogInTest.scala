package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import uk.gov.hmrc.integration.page._
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.Configuration

class LogInTest extends ScalaDsl with EN {



  Given( """^(.*) is logged into the service using (.*)$""") { (user: String, authProvider: String) =>
    provisioningCurrentDriver { implicit webDriver =>
      AuthActions.logIn(user, authProvider)
//      Thread.sleep(4000)
    }
  }


  When( """^user signs out$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      webDriver.findElement(By.linkText("Sign out")).click()
      (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/feedback-survey/ableToDo")))
    }
  }


  And( """^user is unable to access the application$""") { () =>
    provisioningCurrentDriver { implicit webDriver =>
      webDriver.get("http://localhost:9232/personal-account")
      (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("personal-account&accountType=individual&origin=PERTAX")))
      assert(webDriver.getCurrentUrl.endsWith("personal-account&accountType=individual&origin=PERTAX"), "User should be on the start page")
    }
  }



}
