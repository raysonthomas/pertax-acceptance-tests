package uk.gov.hmrc.integration.page


import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.TestDataSource._
import uk.gov.hmrc.integration.utils._

object AuthActions {

  var authorityIdVerify = 0
  var authorityIdGG = 0

  def logIn(user: String, authProvider: String)(implicit webDriver: WebDriver) = {
    provisioningCurrentDriver { implicit webDriver =>
      val userProperties = getUserProperties(user, authProvider)
      authProvider match {
        case AuthProviders.Verify => {
          authorityIdVerify += 1
          userProperties.verify.fold(throw new RuntimeException("No verify details for user"))(loginUsingVerify)
        }
        case AuthProviders.GG     => {
          authorityIdGG += 1
          userProperties.gg.fold(throw new RuntimeException("No gg details for user"))(loginUsingGovernmentGateway)
        }
      }
    }
  }


  def logInforBookmark(user: String, authProvider: String)(implicit webDriver: WebDriver) = {
    provisioningCurrentDriver { implicit webDriver =>
      val userProperties = getUserProperties(user, authProvider)
      authProvider match {
//        case AuthProviders.Verify => userProperties.verify.fold(throw new RuntimeException("No verify details for user"))(loginUsingVerifyforBookmark)
        case AuthProviders.GG     => userProperties.gg.fold(throw new RuntimeException("No gg details for user"))(loginUsingGovernmentGatewayforBookmark)
      }
    }
  }


  
  def loginUsingVerify(verifyUserProperties: VerifyUserProperties)(implicit webDriver: WebDriver) = {
    webDriver.get(Configuration("url")+"/verify-sign-in?continue=http://localhost:9232/personal-account")
    webDriver.findElement(By.name("authorityId")).sendKeys(authorityIdVerify.toString)
    verifyUserProperties.nino.map(webDriver.findElement(By.cssSelector("input[name=\"nino\"][type=\"text\"]")).sendKeys(_))
    verifyUserProperties.sautr.map(webDriver.findElement(By.cssSelector("input[name = \"saUtr\"][type = \"text\"]")).sendKeys(_))

    webDriver.findElement(By.cssSelector(".button")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.urlEndsWith("/personal-account"))
  }


  def loginUsingGovernmentGateway(ggUserProperties: GGUserProperties)(implicit webDriver: WebDriver) = {
    webDriver.get(Configuration("url") + "/gg-sign-in?continue=http://localhost:9232/personal-account")
    webDriver.findElement(By.name("authorityId")).sendKeys(authorityIdGG.toString)

    val select = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[4]/select")))
    select.selectByValue("weak")
    val select1 = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[5]/select")))
    select1.selectByValue("50")

    ggUserProperties.nino.map(webDriver.findElement(By.cssSelector("input[name=\"nino\"][type=\"text\"]")).sendKeys(_))

    webDriver.findElement(By.id("add-preset")).click()
    ggUserProperties.sautr.map(webDriver.findElement(By.cssSelector("input[id =\"input-4-0-value\"][name =\"enrolment[4].taxIdentifier[0].value\"]")).sendKeys(_))
    val select2 = new Select(webDriver.findElement(By.name("enrolment[4].state")))
    select2.selectByVisibleText(ggUserProperties.saEnrolmentStatus)

    webDriver.findElement(By.cssSelector("input[value=\"Submit\"][type=\"submit\"]")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.pageContains("2-Step verification Stub"))
  }


  def loginUsingGovernmentGatewayforBookmark(ggUserProperties: GGUserProperties)(implicit webDriver: WebDriver) = {
    webDriver.findElement(By.name("authorityId")).sendKeys(authorityIdGG.toString)
    val select = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[4]/select")))
    select.selectByValue("weak")
    val select1 = new Select(webDriver.findElement(By.xpath(".//*[@id='inputForm']/div/div[5]/select")))
    select1.selectByValue("50")

    ggUserProperties.nino.map(webDriver.findElement(By.cssSelector("input[name=\"nino\"][type=\"text\"]")).sendKeys(_))

    webDriver.findElement(By.id("add-preset")).click()
    ggUserProperties.sautr.map(webDriver.findElement(By.cssSelector("input[id =\"input-4-0-value\"][name =\"enrolment[4].taxIdentifier[0].value\"]")).sendKeys(_))
    val select2 = new Select(webDriver.findElement(By.name("enrolment[4].state")))
    select2.selectByVisibleText(ggUserProperties.saEnrolmentStatus)

    webDriver.findElement(By.cssSelector("input[value=\"Submit\"][type=\"submit\"]")).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.pageContains("2-Step verification Stub"))
  }
}
