package uk.gov.hmrc.integration.stepdefs.accessibility

import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import org.openqa.selenium.JavascriptExecutor

class AccessibilityTests extends ScalaDsl with EN {

  Then( """^Accessibility Tests are executed for the page$""") {
    () => withCurrentDriver { implicit webDriver =>

      val cache = collection.mutable.Map[String, String]()
      val js: JavascriptExecutor = webDriver.asInstanceOf[JavascriptExecutor]

      def getUrlSource(arg: String): String = cache get arg match {
        case Some(result) => result
        case None =>
          val result: String = scala.io.Source.fromURL(arg).mkString
          cache(arg) = result
          result
      }

      js.executeScript(getUrlSource("https://raw.githubusercontent.com/GoogleChrome/" +
        "accessibility-developer-tools/stable/dist/js/axs_testing.js"))
      val report = js.executeScript("var results = axs.Audit.run();return axs.Audit.createReport(results);")
      println(report)
    }
  }

}