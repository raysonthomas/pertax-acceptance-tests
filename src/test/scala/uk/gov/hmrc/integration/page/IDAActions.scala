package uk.gov.hmrc.integration.page

import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils._

object IDAActions {

  def logInLocalEnv(user: String, pass: String)(implicit webDriver: WebDriver) = {

    println("IDAActions.logInLocalEnv")

    webDriver.get(Configuration("url"))
    webDriver.findElement(By.id("username")).sendKeys(user)
    webDriver.findElement(By.id("password")).sendKeys(pass)
    webDriver.findElement(By.id("submit")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.urlEndsWith("/pertax"))
  }

  def logInLiveLikeEnv(user: String, pass: String)(implicit webDriver: WebDriver) = {
    webDriver.get(Configuration("url"))
    webDriver.findElement(By.id("no-im-not-new")).click()
    webDriver.findElement(By.cssSelector("[value='Post Office Stub']")).click()
    webDriver.findElement(By.id("username")).sendKeys(user)
    webDriver.findElement(By.id("password")).sendKeys(pass)
    webDriver.findElement(By.id("login")).click()
    webDriver.findElement(By.id("agree")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.urlEndsWith("/pertax"))
  }

}
