package uk.gov.hmrc.integration.utils

import play.api.libs.json.Json
import scala.io.Source
import uk.gov.hmrc.integration.utils.model._

case class TestPersonProperties(nino: Option[String], sautr: Option[String], username: String, password: String)

object AuthProviders {
  val Verify = "verify"
  val GG     = "gg"
}
case class UserProperties(
  verify: Option[VerifyUserProperties],
  gg: Option[GGUserProperties]
)
object UserProperties {
  def build(nino: Option[String] = None, sautr: Option[String] = None, name: Option[String] = None,  verify: Boolean = false, gg: Boolean = false) = {
    UserProperties(
      if(verify) Some(VerifyUserProperties(nino, sautr)) else None,
      if(gg) Some(GGUserProperties(name.get, nino, sautr)) else None
    )
  }
}
case class VerifyUserProperties(nino: Option[String], sautr: Option[String])
case class GGUserProperties(name: String, nino: Option[String], sautr: Option[String])

object TestDataSource {
  //private val personalDetailsCache = new java.util.concurrent.ConcurrentHashMap[String, PersonDetails]

  private val userProperties = Map(
    "A user with a PAYE account, but no SA account"                       -> UserProperties.build(nino = Some("AB216913B"), verify = true),  //Martin Hempton
    "A user with Tax Code ending with M"                                  -> UserProperties.build(nino = Some("JZ013615D"), verify = true),  //M Andrew
    "A user with Tax Code ending with N"                                  -> UserProperties.build(nino = Some("PJ523813C"), verify = true),  //Jayne Rockle
    "A user with No Active PAYE account, but SA account"                  -> UserProperties.build(name = Some("KellyBillson"), nino = Some("TA936115D"), sautr = Some("444444444"), verify = true),  //xxxx
    "A user with No PAYE but SA account"                                  -> UserProperties.build(name = Some("MAndrew"), nino = None, sautr = Some("222222222"), verify = true),  //M Andrew
    "A user with a PAYE account and SA account"                           -> UserProperties.build(nino = Some("AB216913B"), sautr = Some("111111111"), verify = true),//Martin Hempton
    "A user with a Correspondence Address"                                -> UserProperties.build(nino = Some("AA000003B"), sautr = Some("111111111"), verify = true),//Bob Jones
    "A user with Effective From date 06 April 2016"                       -> UserProperties.build(nino = Some("AA000003B"), sautr = Some("111111111"), verify = true),//Bob Jones
    "A user with Effective From date other than 06 April 2016"            -> UserProperties.build(nino = Some("JZ013615D"), sautr = Some("111111111"), verify = true),//M Andrew
    "A user with No Effective From date"                                  -> UserProperties.build(nino = Some("CE123457D"), sautr = Some("111111111"), verify = true),//Christopher Grantham
    "A user"                                                              -> UserProperties.build(nino = Some("JZ013615D"), sautr = Some("111111111"), verify = true),//M Andrew
    "A user with a PAYE account and not in NPS"                           -> UserProperties.build(nino = Some("CS700100A"), sautr = Some("111111111"), verify = true),//John Densmore
    "A user who has not requested a refund yet"                           -> UserProperties.build(nino = Some("NA000938A"), sautr = Some("111111111"), verify = true),
    "A user who has requested a refund currently being processed"         -> UserProperties.build(nino = Some("AM242413A"), sautr = Some("111111111"), verify = true),
    "A user who has has been sent a BACS payment"                         -> UserProperties.build(nino = Some("JZ013615A"), sautr = Some("111111111"), verify = true),
    "A user who has has been sent a cheque"                               -> UserProperties.build(nino = Some("JN333333A"), sautr = Some("111111111"), verify = true),
    "A user without a tax underpayment"                                   -> UserProperties.build(nino = Some("AB216913B"), sautr = Some("111111111"), verify = true),
    "A user with MCI Indicator set as true"                               -> UserProperties.build(nino = Some("ST281614D"), sautr = Some("111111111"), verify = true),//MCI
    "A user who has paid too little tax"                                  -> UserProperties.build(nino = Some("AH498813B"), sautr = Some("111111111"), verify = true),//UnderPayment

    "User with a PAYE account, but no SA account"                     -> UserProperties.build(name = Some("Chris"), nino = Some("CE123457D"), gg = true), //GG Chris
    "User with a PAYE account and SA account"                         -> UserProperties.build(name = Some("BobJones"), nino = Some("AA000003B"), sautr = Some("111112222"), gg = true), //GG Bob Jones
    "User with active company benefits"                               -> UserProperties.build(name = Some("MartinHempton"), nino = Some("AB216913B"), sautr = Some("111113333"), gg = true), //Martin Hempton
    "User without active company benefits"                            -> UserProperties.build(name = Some("AnthonyKellegher"), nino = Some("CK720413B"), sautr = Some("111114444"), gg = true), //Anthony Kellegher
//    "A user with a PAYE account and SA account"                     -> UserProperties.build(name = Some("MartinHempton"), nino = Some("AB216913B"), sautr = Some("111111111"), gg = true),//Martin Hempton GG
    "User with Tax Code ending with M and SA"                         -> UserProperties.build(name = Some("MAndrew"), nino = Some("JZ013615D"), sautr = Some("222222222"), gg = true),  //M Andrew
    "User with Tax Code ending with N and SA"                         -> UserProperties.build(name = Some("JayneRockle"), nino = Some("PJ523813C"), sautr = Some("333333333"), gg = true),  //Jayne Rockle
    "User with No Active PAYE and No SA account"                      -> UserProperties.build(name = Some("KellyBillson"), nino = Some("TA936115D"), sautr = None, gg = true),  //Kelly Billson
    "User with No Active PAYE account, but SA account"                -> UserProperties.build(name = Some("KellyBillson"), nino = Some("TA936115D"), sautr = Some("444444444"), gg = true),  //xxxx
    "User"                                                            -> UserProperties.build(name = Some("HazelYoung"), nino = Some("AM242413B"), sautr = Some("444444444"), gg = true),  //xxxx
    "TCS user"                                                        -> UserProperties.build(name = Some("HazelYoung"), nino = Some("AM242413B"), sautr = Some("111111111"), gg = true),//Hazel Young
    "User with No Correspondence Address"                             -> UserProperties.build(name = Some("HazelYoung"), nino = Some("AM242413B"), sautr = Some("111111111"), gg = true),//Hazel Young
    "User without active company benefits but marriage allowance"     -> UserProperties.build(name = Some("MAndrew"), nino = Some("JZ013615D"), sautr = Some("222222222"), gg = true),  //M Andrew
    "User who has enrolled for Self Assessment and been issued an activation code" -> UserProperties.build(name = Some("XXXX"), nino = Some("XXXXX"), sautr = Some("222222222"), gg = true),  //XXXXXX
    "User with gg credentials"                                        -> UserProperties.build(name = Some("XXXX"), nino = Some("XXXXX"), sautr = Some("222222222"), gg = true)  //XXXXXX
  )

  def getUserProperties(token: String, authProvider: String) = userProperties( token )

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
    "SA Jayne Rockle"            -> TestPersonProperties(Some("PJ523813C"), Some("111114444"), "jrockle", "password"),
    "Kelly Billson"              -> TestPersonProperties(Some("TA936115D"), None, "kbillson", "testing123"),
    "SA Kelly Billson"           -> TestPersonProperties(Some("TA936115D"), Some("111115555"), "kbillson", "testing123")
  )




  val pathForLink = Map(
    "login"                                                         -> "/ida/startlogin",
    "Print proof of your National Insurance number"                 -> "/personal-account/national-insurance-summary/print-letter",
    "Check your National Insurance contributions"                   -> "/checkmystatepension/account/nirecord",
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
    "Find out about call charges (opens in a new window)"           -> "/call-charges",
    "try to confirm your identity again"                            -> "/personal-account/do-uplift",
    "Try to confirm your identity again"                            -> "/personal-account/do-uplift",
    "contact HM Revenue and Customs (opens in a new window)"        -> "/contact-hmrc",
    "Check your National Insurance record"                          -> "/checkmystatepension/account/nirecord/pta",
    "Back to account home"                                          -> "/personal-account",
    "State Pension forecast"                                        -> "/checkmystatepension/account/pta",
    "View your company benefits"                                    -> "/check-income-tax/taxable-income",
    "current address"                                               -> "/personal-account/your-address",
    "personal tax account home"                                     -> "/personal-account",
    "Change your address"                                           -> "/personal-account/your-address/tax-credits-choice",
//    "Update your address"                                           -> "/personal-account/your-address/residency-choice",
    "Change where we send your letters"                             -> "/personal-account/your-address/postal/find-address",
    "Tax credits"                                                   -> "/personal-account/tax-credits-summary",
    "Child Benefit forms"                                           -> "/personal-account/child-benefit-forms",
    "sign in to your account again"                                 -> "/personal-account",
    "Check if you can claim Child Benefit (opens in new window)"    -> "/child-benefit/overview",
    "Get your refund"                                               -> "/tax-you-paid/status",
    "Get more details"                                              -> "/tax-you-paid/status"


  )

  val pathForTitle = Map(
    "Personal tax account"                                          -> "/personal-account",
    "Signed out"                                                    -> "/personal-account/signed-out",
    "Trusted Helper contacts"                                       -> "/trusted-helpers",
    "Your address"                                                  -> "/personal-account/your-address",
    "Your address has been updated"                                 -> "/personal-account/your-address/thank-you",
    "Update your address"                                           -> "/personal-account/your-address",
    "List of messages"                                              -> "/personal-account/messages",
    "Check your Income Tax"                                         -> "/check-income-tax/income-tax",
    "Benefits and tax credits summary"                              -> "/personal-account/benefits-credits-summary",
    "National Insurance summary"                                    -> "/personal-account/national-insurance-summary",
    "Print"                                                         -> "/personal-account/national-insurance-summary/print-letter",
    "Pensions summary"                                              -> "/personal-account/pensions-summary",
    "Manage your paperless settings"                                -> "/personal-account/preferences",
    "Self Assessment summary"                                       -> "/personal-account/self-assessment-summary",
    "Identity verification confirmation"                            -> "http://localhost:9232/personal-account/identity-check-complete",
    "There's a technical problem"                                   -> "http://localhost:9232/personal-account/identity-check-complete",
    "We've confirmed your identity"                                 -> "http://localhost:9232/personal-account/identity-check-complete",
    "You’ve tried to confirm your identity too many times"          -> "http://localhost:9232/personal-account/identity-check-complete",
    "We're unable to confirm your identity"                         -> "http://localhost:9232/personal-account/identity-check-complete",
    "Your address has already been updated"                         -> "/personal-account/address-already-updated",
    "Find an address"                                               -> "/personal-account/your-address/postal/find-address",
    "Your address has been updated"                                 -> "/personal-account/your-address/primary/thank-you",
    "Your address"                                                  -> "/personal-account/your-address",
    "Service not available"                                              -> "/personal-account/tax-credits-summary",
    "Child Benefit forms"                                           -> "/personal-account/child-benefit-forms",
    "There's a problem"                                             -> "/personal-account",
    "Thanks for your feedback"                                      -> "/personal-account/feedback-thanks",
    "Print your National Insurance summary"                         -> "/personal-account/national-insurance-summary/print-letter"


  )

}