package uk.gov.hmrc.integration.utils

import java.util.logging.Level

import org.apache.commons.lang3.StringEscapeUtils
import org.openqa.selenium.WebDriver
import org.openqa.selenium.logging.LogType
import play.api.libs.json.{JsObject, JsString, JsValue, Json}

import scala.collection.JavaConversions._

object GoogleAnalytics {

  case class GaCall(arguments: Seq[String])

  def getAllGaCalls(webDriver: WebDriver): Seq[GaCall] = {
    val logEntries = webDriver.manage.logs.get(LogType.BROWSER)



    val r = (for(e <- logEntries if e.getLevel == Level.INFO) yield {
      println(e)
      extractGaCallFromLogMessage(e.getMessage.replace(",\\\"5\\\":{}", "")) map { jsVal =>
        GaCall(jsVal.as[JsObject].fields.map(t => t._2.as[JsString].value))
      }
    }).flatten.toSeq
    r
  }

  def extractGaCallFromLogMessage(msg: String): Option[JsValue] = {

    val MsgRegex = """^([^ ]+) ([0-9]+)[:]([0-9]+) ["](.*)["]$""".r

    msg match {
      case MsgRegex(url, line, col, json) =>
        val x = StringEscapeUtils.unescapeJava(json)
        val j = Json.parse(x)
//        if ( (j \ "call").as[JsString].value == "ga" ) Some(j \ "args")
        if ( (j \ "call").as[JsString].value == "ga" ) Some(j)
        else None
      case _ => None
    }
  }
}
