package uk.gov.hmrc.integration.utils

import play.api.libs.json.Json
import scala.io.Source
import uk.gov.hmrc.integration.utils.model._

case class TestPersonProperties(nino: String, username: String, password: String)

object TestDataSource {
  private val personalDetailsCache = new java.util.concurrent.ConcurrentHashMap[String, PersonDetails]

  val personProperties = Map(
    "John Densmore"              -> TestPersonProperties("CS700100A", "jdensmore", "password"),
    "Robert Jeffries"            -> TestPersonProperties("ZN522915C", "rjeffries", "password"),
    "Timothy Bull"               -> TestPersonProperties("GC306515D", "tbull", "password"),
    "Jane Tidy"                  -> TestPersonProperties("AA000113B", "jtidy", "password"),
    "Jim Ferguson"               -> TestPersonProperties("AA000003D", "jferguson", "password"),
    "Martin Hempton"             -> TestPersonProperties("AB216913B", "mhempton", "password"),
    "M Andrew"                   -> TestPersonProperties("JZ013615D", "mandrew", "password"),
    "Jayne Rockle"               -> TestPersonProperties("PJ523813C", "jrockle", "password"),
    "Scott The Booth"            -> TestPersonProperties("CE123457D", "543212300020", "testing123"),
    "Christopher Grantham"       -> TestPersonProperties("CE123457D", "543212300022", "testing123")

  )

  val pathForLink = Map(
    "login"                                     -> "/ida/startlogin",
    "View all HM Revenue and Customs forms"     -> "/government/collections/hmrc-forms",
    "Your messages"                             -> "/personal-account/messages",
    "Income tax"                                -> "/check-income-tax/income-tax",
    "Check if you can get Marriage Allowance"   -> "/marriage-allowance-application/status",
    "feedback"                                  -> "/contact/beta-feedback-unauthenticated?service=PTA",
    "Benefits and tax credits"                  -> "/personal-account/benefits-credits-summary",
    "National Insurance"                        -> "/personal-account/national-insurance-summary",
    "Pension"                                   -> "/personal-account/pensions-summary",
    "View your trusted helper contacts"         -> "/trusted-helpers",
    "Update your address"                       -> "/personal-account/your-address",
    "Track your forms"                          -> "/track",
    "Manage your paperless settings"            ->"/personal-account/preferences",
    "Self Assessment"                           ->"/personal-account/self-assessment-summary",
    "Go to your messages"                       ->"/personal-account/messages",
    "your business tax account."                ->"/business-account"

  )


  val pathForTitle = Map(
    "Your personal tax account"                 -> "/personal-account",
    "Signed out"                                -> "/personal-account/signed-out",
    "Trusted Helper contacts"                   -> "/trusted-helpers",
    "Your address"                              -> "/personal-account/your-address",
    "Your address has been updated"             -> "/personal-account/your-address/thank-you",
    "Update your address"                       -> "/personal-account/your-address",
    "List of messages"                          -> "/personal-account/messages",
    "Check your Income Tax"                     -> "/check-income-tax/income-tax",
    "Benefits and tax credits summary"          -> "/personal-account/benefits-credits-summary",
    "National Insurance summary"                -> "/personal-account/national-insurance-summary",
    "Pensions summary"                          -> "/personal-account/pensions-summary",
    "Manage your paperless settings"            -> "/personal-account/preferences",
    "Self Assessment summary"                   -> "/personal-account/self-assessment-summary",
    "Identity verification confirmation"        -> "http://localhost:9232/personal-account/identity-check-complete",
    "Identity Verification Failed"              -> "http://localhost:9232/personal-account/identity-check-failed",
    "Confirm your identity"                     -> "/personal-account/full"
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