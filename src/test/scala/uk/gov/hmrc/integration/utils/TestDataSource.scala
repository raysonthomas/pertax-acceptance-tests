package uk.gov.hmrc.integration.utils

import play.api.libs.json.Json
import scala.io.Source
import scalaj.http.Http
import uk.gov.hmrc.integration.utils.model._

object TestDataSource {
  private val personalDetailsCache = new java.util.concurrent.ConcurrentHashMap[String, Person]

  def getTestPersonDetails(nino: String): Person = {
    def fetchTestPersonDetails(nino: String): Option[Person] = {
      val response = Source.fromFile(s"testdata/dev/$nino").mkString
      Json.parse(response).asOpt[Person]
    }

    Option(personalDetailsCache.get(nino)) match {
      case Some(personDetails) => personDetails
      case None =>   {
        val pd = fetchTestPersonDetails(nino)  //Get from service
        pd.foreach(a => personalDetailsCache.put(nino, a))  //Maybe store result
        pd getOrElse(throw new RuntimeException(s"PersonDetails for $nino not found"))
      }
    }
  }
}