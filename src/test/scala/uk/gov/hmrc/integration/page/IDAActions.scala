package uk.gov.hmrc.integration.page


import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils._

object IDAActions {

  def logInLocalEnv(user: String, pass: String, sautr: Option[String], nino: Option[String])(implicit webDriver: WebDriver) = {
    webDriver.get(Configuration("url")+"/start-verify")
    webDriver.findElement(By.name("authorityId")).sendKeys("Verify")
    webDriver.findElement(By.name("redirectionUrl")).clear()
    webDriver.findElement(By.name("redirectionUrl")).sendKeys("http://localhost:9232/personal-account")
    val select = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[3]/select")))
    select.selectByValue("strong")
    val select1 = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[4]/select")))
    select1.selectByValue("200")
    sautr.map { s =>
      webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[5]/div[2]/input")).sendKeys(s)
    }
    nino.map
    {
      webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[5]/div[1]/input")).sendKeys(_)
    }

    webDriver.findElement(By.cssSelector(".button")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.urlEndsWith("/personal-account"))
  }



  def logInLiveLikeEnv(user: String, pass: String, sautr: Option[String], nino: Option[String])(implicit webDriver: WebDriver) = {
    webDriver.get(Configuration("url"))
    webDriver.findElement(By.id("no-im-not-new")).click()
    webDriver.findElement(By.cssSelector("[value='Post Office Stub']")).click()
    webDriver.findElement(By.id("username")).sendKeys(user)
    webDriver.findElement(By.id("password")).sendKeys(pass)
    webDriver.findElement(By.id("login")).click()
    webDriver.findElement(By.id("agree")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.urlEndsWith("/personal-account"))
  }

}
