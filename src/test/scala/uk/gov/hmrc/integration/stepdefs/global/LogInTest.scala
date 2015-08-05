package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebDriver, By}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import uk.gov.hmrc.integration.page.{GlobalActions, IDAActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.Configuration
import uk.gov.hmrc.integration.utils.TestDataSource._

class LogInTest extends ScalaDsl with EN {



  Given( """^user '(.*)' is logged into the service$""") { (user: String) =>
    withCurrentDriver { implicit webDriver =>
      val personProperty = personProperties(user)
      if (Configuration.environment("id") == "local")
        IDAActions.logInLocalEnv(personProperty.username, personProperty.password)
      else
        IDAActions.logInLiveLikeEnv(personProperty.username, personProperty.password)
    }
  }

  When( """^user signs out$""") { () =>
    withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      webDriver.findElement(By.linkText("Sign out")).click()
      (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/signed-out")))
    }
  }

  And( """^user is unable to access the application$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.get(Configuration("url"))
      (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/ida/startlogin")))
      assert(webDriver.getCurrentUrl.endsWith(pathFor("login")), "User should be on the login page")
    }
  }

}
