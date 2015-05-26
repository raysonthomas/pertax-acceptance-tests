package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.IDAActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
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

  When( """^user signs out$""") {

    withCurrentDriver { implicit webDriver =>

      webDriver.findElement(By.linkText("Sign out")).click()
    }
  }

  And( """^user is unable to access the application$""") {

    withCurrentDriver { implicit webDriver =>

      webDriver.get(Configuration("url"))
      assert(webDriver.getCurrentUrl.endsWith(pathFor("login")), "User was not redirected to the login page")
    }
  }

}
