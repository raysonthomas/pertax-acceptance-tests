package uk.gov.hmrc.integration.page

import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.utils._

class IDAActions  {

   def enterURL(implicit webDriver: WebDriver) = {
     webDriver.get(Configuration("url"))
   }

   def clickLoginStub(implicit webDriver: WebDriver) = {
     webDriver.findElement(By.cssSelector("input[value='John Densmore']")).click()
   }
}
