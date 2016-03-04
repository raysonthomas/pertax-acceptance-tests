package uk.gov.hmrc.integration.page

import org.openqa.selenium.support.ui.{Select, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.Configuration


object GGActions {

  def logInLocalEnv(user: String, pass: String, sautr: Option[String], nino: Option[String])(implicit webDriver: WebDriver) = {
    webDriver.get(Configuration("url") + "/start-government-gateway")
    webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[1]/input")).sendKeys(user)
    webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[2]/input")).clear()
    webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[2]/input")).sendKeys("http://localhost:9232/personal-account/full")
    val select = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[3]/select")))
    select.selectByValue("weak")
    val select1 = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[4]/select")))
    select1.selectByValue("50")

    sautr.map{s=>

      webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[5]/div[1]/input")).sendKeys(s)
    }

    nino.map {
      webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[5]/div[9]/input")).sendKeys(_)
    }

    webDriver.findElement(By.xpath(".//*[@id='inputForm']/p/input")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.pageContains("2-Step verification Stub"))

  }

  def logInLiveLikeEnv(user: String, pass: String, sautr: Option[String], nino: Option[String])(implicit webDriver: WebDriver) = {
    webDriver.get(Configuration("url") + "/start-self-assessment")
    webDriver.findElement(By.id("no-im-not-new")).click()
    webDriver.findElement(By.cssSelector("[value='Post Office Stub']")).click()
    webDriver.findElement(By.id("username")).sendKeys(user)
    webDriver.findElement(By.id("password")).sendKeys(pass)
    webDriver.findElement(By.id("login")).click()
    webDriver.findElement(By.id("agree")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.urlEndsWith("/personal-account"))
  }

}
