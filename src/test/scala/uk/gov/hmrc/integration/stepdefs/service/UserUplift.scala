package uk.gov.hmrc.integration.stepdefs.service

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebElement}
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.Configuration

import scala.collection.JavaConversions._

class UserUplift extends ScalaDsl with EN {

  Then( """^user '(.*)' logs into the IV uplift service$""") {

    def logInLocalEnv(user: String, pass: String)(implicit webDriver: WebDriver) = {
          webDriver.get(Configuration("url") + "/start-self-assessment")
          webDriver.findElement(By.cssSelector(".button.button-get-started.start-verify-action")).click()
          webDriver.findElement(By.id("userId")).sendKeys(user)
          webDriver.findElement(By.id("password")).sendKeys(pass)
          webDriver.findElement(By.cssSelector(".button")).click()
          (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until
          (CustomExpectedConditions.urlEndsWith("/personal-account"))
          webDriver.get(Configuration("url") + "/full")
          webDriver.findElement(By.cssSelector("#requiredResult-success")).click()
          webDriver.findElement(By.cssSelector(".button")).click()
          webDriver.findElement(By.cssSelector("#continueFailure")).click()
          (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until
          (CustomExpectedConditions.urlEndsWith("/personal-account"))

        }

}