package uk.gov.hmrc.integration.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import scalaj.http.{HttpOptions, Http}

class ServiceStepDefs extends ScalaDsl with EN {

  And( """^Protections are added$""") { () =>
    val responseOfDelete = Http("http://localhost:9012/test-only/protections/removeAll").method("DELETE").asString
    val responseOfInsert = Http("http://localhost:9012/test-only/protections/insert")
      .method("POST")
      .postData(
        """{
           "pensionSchemeAdministratorCheckReference": "PSA12345678A",
           "nino": "AA321456",
           "id": 4294967270,
           "version": 10,
           "type": 2,
           "status": 1,
           "protectionReference": "FAKE1PRIMARY",
           "certificateDate" : "2013-12-18",
           "certificateTime" : "14:30:40",
           "protectedAmount": 2000000.00,
           "relevantAmount": 2000000.00,
           "uncrystallisedRights" : 500000.00,
           "preADayPensionInPayment": 500000.00,
           "postADayBCE": 500000.00,
           "nonUKRights": 500000.00
           }"""
      )
      .header("Content-Type", "application/json")
      .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000))
      .asString

    val responseOfInsert2 = Http("http://localhost:9012/test-only/protections/insert")
      .method("POST")
      .postData(
        """{
          "pensionSchemeAdministratorCheckReference": "PSA12345678A",
          "nino": "AA322456",
          "id": 4294967271,
          "version": 12,
          "type": 3,
          "status": 1,
          "protectionReference": "FAKE1PRIMARY",
          "certificateDate" : "2013-12-18",
          "certificateTime" : "14:30:40",
          "protectedAmount": 2000000.00,
          "relevantAmount": 2000000.00,
          "uncrystallisedRights" : 500000.00,
          "preADayPensionInPayment": 500000.00,
          "postADayBCE": 500000.00,
          "nonUKRights": 500000.00
          }"""
      )
      .header("Content-Type", "application/json")
      .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000))
      .asString

    Thread.sleep(1000)
  }

}
