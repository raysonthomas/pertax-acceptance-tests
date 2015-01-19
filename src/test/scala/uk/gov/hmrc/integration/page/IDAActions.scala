package uk.gov.hmrc.integration.page

import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils._

class IDAActions  {

   def enterURL(implicit webDriver: WebDriver) = {
     webDriver.get(Configuration("url"))
   }

   def clickLoginStub(implicit webDriver: WebDriver): Unit = {
     webDriver.findElement(By.cssSelector("input[value='John Densmore']")).click()
     (new WebDriverWait(webDriver, 5)).until(CustomExpectedConditions.urlEndsWith("/pertax"))
   }
}
