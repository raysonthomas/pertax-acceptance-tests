package uk.gov.hmrc.integration.page

import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.utils._

class IDAActions(val webDriver: WebDriver)  {

   def enterURL = {
     webDriver.get(Configuration("url"))
   }

   def clickLoginStub = {
     webDriver.findElement(By.cssSelector("input[value='John Densmore']")).click()
   }
  
  def logout = {
    webDriver.findElement(By.cssSelector("#proposition-links>a")).click()
  }
}
