package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.IDAActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.Configuration
import uk.gov.hmrc.integration.utils.TestDataSource._

class LogInTest extends ScalaDsl with EN {

  Given( """^'(.*)' is logged in to PTA$""") {
    (user: String) =>
      val personProperty = personProperties(user)
      withCurrentDriver { implicit webDriver =>
        if (Configuration.environment("id") == "local")
          IDAActions.logInLocalEnv(personProperty.username, personProperty.password)
        else
          IDAActions.logInLiveLikeEnv(personProperty.username, personProperty.password)
      }
  }
}
