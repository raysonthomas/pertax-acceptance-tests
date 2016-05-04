package uk.gov.hmrc.integration.utils

import play.api.libs.json.Json
import scala.io.Source
import uk.gov.hmrc.integration.utils.model._

case class TestPersonProperties(nino: Option[String], sautr: Option[String], username: String, password: String)


object TestDataSource {
  private val personalDetailsCache = new java.util.concurrent.ConcurrentHashMap[String, PersonDetails]

  val personProperties = Map(
    "John Densmore"              -> TestPersonProperties(Some("CS700100A"), None, "jdensmore", "password"),
    "Robert Jeffries"            -> TestPersonProperties(Some("ZN522915C"), None, "rjeffries", "password"),
    "Timothy Bull"               -> TestPersonProperties(Some("GC306515D"), None, "tbull", "password"),
    "Jane Tidy"                  -> TestPersonProperties(Some("AA000113B"), None, "jtidy", "password"),
    "Jim Ferguson"               -> TestPersonProperties(Some("AA000003D"), None, "jferguson", "password"),
    "Martin Hempton"             -> TestPersonProperties(Some("AB216913B"), None, "mhempton", "password"),
    "M Andrew"                   -> TestPersonProperties(Some("JZ013615D"), None, "mandrew", "password"),
    "Jayne Rockle"               -> TestPersonProperties(Some("PJ523813C"), None, "jrockle", "password"),
    "Scott The Booth"            -> TestPersonProperties(Some("CE123457D"), None, "scott", "testing123"),
    "Christopher Grantham"       -> TestPersonProperties(Some("CE123457D"), None, "chris", "testing123"),
    "Bob Jones"                  -> TestPersonProperties(Some("AA000003B"), None, "bjones", "password"),
    "Verify User1"               -> TestPersonProperties(None             , Some("111111111"), "vuser1", "password"),
    "SA Bob Jones"               -> TestPersonProperties(Some("AA000003B"), Some("111112222"),"bjones", "password"),
    "SA Christopher Grantham"    -> TestPersonProperties(Some("CE123457D"), Some("333333333"), "chris", "testing123"),
    "Hazel Young"                -> TestPersonProperties(Some("AM242413B"), None, "hyoung", "password"),
    "Sharaine Cowling"           -> TestPersonProperties(Some("AR822513A"), None, "scowling", "password"),
    "SA Hazel Young"             -> TestPersonProperties(Some("AM242413B"), Some("444444444"), "hazel", "testing123"),
    "SA Sharaine Cowling"        -> TestPersonProperties(Some("AR822513A"), Some("555555555"), "scowling", "password"),
    "SA M Andrew"                -> TestPersonProperties(Some("JZ013615D"), Some("111113333"), "mandrew", "password"),
    "SA Jayne Rockle"            -> TestPersonProperties(Some("PJ523813C"), Some("111114444"), "jrockle", "password")


  )


  val pathForLink = Map(
    "login"                                                         -> "/ida/startlogin",
    "View all HM Revenue and Customs forms"                         -> "/government/collections/hmrc-forms",
    "Your messages"                                                 -> "/personal-account/messages",
    "Income tax"                                                    -> "/check-income-tax/income-tax",
    "Pay As You Earn (PAYE)"                                        -> "/check-income-tax/income-tax-refresh",
    "Check if you can get Marriage Allowance"                       -> "/marriage-allowance-application/history",
    "feedback"                                                      -> "/contact/beta-feedback-unauthenticated?service=PTA",
    "Benefits and tax credits"                                      -> "/personal-account/benefits-credits-summary",
    "National Insurance"                                            -> "/personal-account/national-insurance-summary",
    "Pension"                                                       -> "/personal-account/pensions-summary",
    "View your trusted helper contacts"                             -> "/trusted-helpers",
    "Update your address"                                           -> "/personal-account/your-address",
    "Track your forms"                                              -> "/track",
    "Manage your paperless settings"                                -> "/personal-account/preferences",
    "Self Assessment"                                               -> "/personal-account/self-assessment-summary",
    "Go to your messages"                                           -> "/personal-account/messages",
    "your business tax account"                                     -> "/business-account",
    "Renew your tax credit claim"                                   -> "/tax-credits-service/renewals/do-you-want-to-renew-now",
    "Try again"                                                     -> "/personal-account/do-uplift",
    "try to confirm your identity again"                            -> "/personal-account/do-uplift",
    "Try to confirm your identity again"                            -> "/personal-account/do-uplift",
    "contact HM Revenue and Customs (opens in a new window)"        -> "/contact-hmrc",
    "Check your National Insurance record"                          -> "/checkmystatepension/account/nirecord/pta",
    "Back to account home"                                          -> "/personal-account",
    "State Pension forecast"                                        -> "/checkmystatepension/account/pta",
    "check your taxable income"                                     -> "/check-income-tax/taxable-income"



  )

  val pathForTitle = Map(
    "Your personal tax account"                                     -> "/personal-account",
    "Signed out"                                                    -> "/personal-account/signed-out",
    "Trusted Helper contacts"                                       -> "/trusted-helpers",
    "Your address"                                                  -> "/personal-account/your-address",
    "Your address has been updated"                                 -> "/personal-account/your-address/thank-you",
    "Update your address"                                           -> "/personal-account/your-address",
    "List of messages"                                              -> "/personal-account/messages",
    "Check your Income Tax"                                         -> "/check-income-tax/income-tax",
    "Benefits and tax credits summary"                              -> "/personal-account/benefits-credits-summary",
    "National Insurance summary"                                    -> "/personal-account/national-insurance-summary",
    "Pensions summary"                                              -> "/personal-account/pensions-summary",
    "Manage your paperless settings"                                -> "/personal-account/preferences",
    "Self Assessment summary"                                       -> "/personal-account/self-assessment-summary",
    "Identity verification confirmation"                            -> "http://localhost:9232/personal-account/identity-check-complete",
    "There's a technical problem"                                   -> "http://localhost:9232/personal-account/identity-check-complete",
    "We've confirmed your identity"                                 -> "http://localhost:9232/personal-account/identity-check-complete",
    "You’ve tried to confirm your identity too many times"          -> "http://localhost:9232/personal-account/identity-check-complete",
    "We're unable to confirm your identity"                         -> "http://localhost:9232/personal-account/identity-check-complete"

  )

}