package uk.gov.hmrc.integration.utils

import play.api.libs.json.Json
import scala.io.Source
import uk.gov.hmrc.integration.utils.model._

case class TestPersonProperties(nino: String, username: String, password: String)

object TestDataSource {
  private val personalDetailsCache = new java.util.concurrent.ConcurrentHashMap[String, PersonDetails]

  val personProperties = Map(
    "John Densmore"   -> TestPersonProperties("CS700100A", "jdensmore", "password"),
    "Robert Jeffries" -> TestPersonProperties("ZN522915C", "rjeffries", "password"),
    "Timothy Bull"    -> TestPersonProperties("GC306515D", "tbull", "password"),
    "Jane Tidy"       -> TestPersonProperties("AA000113B", "jtidy", "password"),
    "Jim Ferguson"    -> TestPersonProperties("AA000003D", "jferguson", "password")
  )
  
  val pathFor = Map(
    "home"             -> "/personal-account",
    "personal details" -> "/personal-account/personal-details",
    "login"            -> "/ida/startlogin"
  )

  def getTestPersonDetailsByName(name: String) = getTestPersonDetailsByNino(personProperties(name).nino)

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
        val pd = fetchTestPersonDetails(nino) //Get from service
        pd.foreach(a => personalDetailsCache.put(nino, a)) //Maybe store result
        pd getOrElse (throw new RuntimeException(s"PersonDetails for $nino not found"))
      }
    }
  }
}