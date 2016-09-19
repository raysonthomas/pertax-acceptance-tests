package uk.gov.hmrc.integration.page


import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.TestDataSource._
import uk.gov.hmrc.integration.utils._

object AuthActions {

  def logIn(user: String, authProvider: String)(implicit webDriver: WebDriver) = {
    withCurrentDriver { implicit webDriver =>
      val userProperties = getUserProperties(user, authProvider)
      authProvider match {
        case AuthProviders.Verify => userProperties.verify.fold(throw new RuntimeException("No verify details for user"))(loginUsingVerify)
        case AuthProviders.GG     => userProperties.gg.fold(throw new RuntimeException("No gg details for user"))(loginUsingGovernmentGateway)
      }
    }
  }


  def logInforBookmark(user: String, authProvider: String)(implicit webDriver: WebDriver) = {
    withCurrentDriver { implicit webDriver =>
      val userProperties = getUserProperties(user, authProvider)
      authProvider match {
//        case AuthProviders.Verify => userProperties.verify.fold(throw new RuntimeException("No verify details for user"))(loginUsingVerifyforBookmark)
        case AuthProviders.GG     => userProperties.gg.fold(throw new RuntimeException("No gg details for user"))(loginUsingGovernmentGatewayforBookmark)
      }
    }
  }


  
  def loginUsingVerify(verifyUserProperties: VerifyUserProperties)(implicit webDriver: WebDriver) = {
    webDriver.get(Configuration("url")+"/start-verify")
    webDriver.findElement(By.name("authorityId")).sendKeys("Verify")
    webDriver.findElement(By.name("redirectionUrl")).clear()
    webDriver.findElement(By.name("redirectionUrl")).sendKeys("http://localhost:9232/personal-account/do-uplift")
    val select = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[3]/select")))
    select.selectByValue("strong")
    val select1 = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[4]/select")))
    select1.selectByValue("200")

    verifyUserProperties.sautr.map(webDriver.findElement(By.cssSelector("input[name=\"taxIdInfo[1].value\"][type=\"text\"]")).sendKeys(_))
    verifyUserProperties.nino.map(webDriver.findElement(By.cssSelector("input[name=\"taxIdInfo[0].value\"][type=\"text\"]")).sendKeys(_))

    webDriver.findElement(By.cssSelector(".button")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.urlEndsWith("/personal-account"))
  }


  def loginUsingGovernmentGateway(ggUserProperties: GGUserProperties)(implicit webDriver: WebDriver) = {
    webDriver.get(Configuration("url") + "/start-government-gateway")
    webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[1]/input")).sendKeys(ggUserProperties.name)
    webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[2]/input")).clear()
    webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[2]/input")).sendKeys("http://localhost:9232/personal-account/full")
    val select = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[3]/select")))
    select.selectByValue("weak")
    val select1 = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[4]/select")))
    select1.selectByValue("50")

    ggUserProperties.sautr.map(webDriver.findElement(By.cssSelector("input[name=\"taxIdInfo[0].value\"][type=\"text\"]")).sendKeys(_))
    val select2 = new Select(webDriver.findElement(By.name("taxIdInfo[0].state")))
    select2.selectByVisibleText(ggUserProperties.saEnrolmentStatus)

    ggUserProperties.nino.map(webDriver.findElement(By.cssSelector("input[name=\"taxIdInfo[8].value\"][type=\"text\"]")).sendKeys(_))

    webDriver.findElement(By.xpath(".//*[@id='inputForm']/p/input")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.pageContains("2-Step verification Stub"))
  }


    def loginUsingGovernmentGatewayforBookmark(ggUserProperties: GGUserProperties)(implicit webDriver: WebDriver) = {
      webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[1]/input")).sendKeys(ggUserProperties.name)
      val select = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[3]/select")))
      select.selectByValue("weak")
      val select1 = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[4]/select")))
      select1.selectByValue("50")

      ggUserProperties.sautr.map(webDriver.findElement(By.cssSelector("input[name=\"taxIdInfo[0].value\"][type=\"text\"]")).sendKeys(_))

      ggUserProperties.nino.map(webDriver.findElement(By.cssSelector("input[name=\"taxIdInfo[8].value\"][type=\"text\"]")).sendKeys(_))

      webDriver.findElement(By.xpath(".//*[@id='inputForm']/p/input")).click()
      (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.pageContains("2-Step verification Stub"))
  }


}
