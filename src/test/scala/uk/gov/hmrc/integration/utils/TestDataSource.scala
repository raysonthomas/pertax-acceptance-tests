package uk.gov.hmrc.integration.utils

import play.api.libs.json.Json
import scala.io.Source
import uk.gov.hmrc.integration.utils.model._

object TestDataSource {
  private val personalDetailsCache = new java.util.concurrent.ConcurrentHashMap[String, PersonDetails]


  val nameMap = Map(
    "Graham Salmon"   -> "AA026813B",
    "John Densmore"   -> "CS700100A",
    "Robert Jeffries" -> "ZN522915C"
  )


  def getTestPersonDetailsByName(name: String) = getTestPersonDetailsByNino(nameMap(name))

  def getTestPersonDetailsByNino(nino: String): PersonDetails = {

    def fetchTestPersonDetails(nino: String): Option[PersonDetails] = {
      Option(getClass.getResourceAsStream(s"/testdata/dev/$nino.json")) flatMap { is =>
        val json = Source.fromInputStream(is).getLines.mkString("\n")
        Json.parse(json).asOpt[PersonDetails]
      }
    }

    Option(personalDetailsCache.get(nino)) match {
      case Some(personDetails) => personDetails
      case None => {
        val pd = fetchTestPersonDetails(nino)  //Get from service
        pd.foreach(a => personalDetailsCache.put(nino, a))  //Maybe store result
        pd getOrElse(throw new RuntimeException(s"PersonDetails for $nino not found"))
      }
    }
  }
}