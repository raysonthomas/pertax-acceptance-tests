package uk.gov.hmrc.integration.utils.model

import org.joda.time.DateTime
import play.api.libs.json.Json

object Person {
  implicit val formats = Json.format[Person]
}

case class Person(firstName: Option[String], middleName: Option[String], lastName: Option[String],
  initials: Option[String], title: Option[String], honours: Option[String], sex: Option[String], 
  dateOfBirth: Option[DateTime], nino: Option[String]) {
  
  lazy val shortName = List(firstName, lastName).flatten.mkString(" ")
  lazy val fullName = List(title, firstName, middleName, lastName, honours).flatten.mkString(" ")
}

object Contact {
  implicit val formats = Json.format[Contact]
}

case class Contact(primaryEmail: Option[String], daytimeTelephone: Option[String], eveningTelephone: Option[String]) {

  lazy val contact = List(primaryEmail, daytimeTelephone, eveningTelephone)
}

object AddressHistory {
  implicit val formats = Json.format[AddressHistory]
}

case class AddressHistory(houseName: Option[String], addressLine1: Option[String], addressLine2: Option[String], 
  addressLine3: Option[String], addressLine4: Option[String], addressLine5: Option[String], postcode: Option[String], 
  homeCountry: Option[String], foreignCountry: Option[String], startDateTime: Option[String]) {

  lazy val address = List(houseName, addressLine1, addressLine2, addressLine3, addressLine4, addressLine5, postcode, 
    homeCountry, foreignCountry, startDateTime).flatten.mkString(" ")
}