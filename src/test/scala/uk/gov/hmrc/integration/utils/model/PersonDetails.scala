package uk.gov.hmrc.integration.utils.model

import org.joda.time.DateTime
import play.api.libs.json.Json

object Person {
  implicit val formats = Json.format[Person]
}
case class Person(
  firstName: Option[String],
  middleName: Option[String],
  lastName: Option[String],
  initials: Option[String],
  title: Option[String],
  honours: Option[String],
  sex: Option[String],
  dateOfBirth: Option[DateTime],
  nino: Option[String]
)
{
  lazy val shortName = List(firstName, lastName).flatten.mkString(" ")
  lazy val titledName = List(title, firstName, lastName).flatten.mkString(" ")
  lazy val fullName = List(title, firstName, middleName, lastName, honours).flatten.mkString(" ")
  lazy val niNumber = List(nino).flatten.mkString(" ")
}


object Address {
  implicit val formats = Json.format[Address]
}
case class Address(
  houseName: Option[String],
  addressLine1: Option[String],
  addressLine2: Option[String],
  addressLine3: Option[String],
  addressLine4: Option[String],
  addressLine5: Option[String],
  postcode: Option[String],
  homeCountry: Option[String],
  foreignCountry: Option[String],
  startDatetime: Option[DateTime]
) {
  lazy val postCode = List (postcode).flatten.mkString(" ")
  lazy val fullAddress = List(addressLine1, addressLine2, addressLine3, addressLine4, postcode).flatten.mkString("\n")
}

object Contact {
  implicit val formats = Json.format[Contact]
}

case class Contact(
  daytimeTelephone: Option[String],
  eveningTelephone: Option[String],
  primaryEmail: Option[String]
)
{
  lazy val email = List(primaryEmail).flatten.mkString(" ")
  lazy val noEmail = List().flatten.mkString(" ")
  
 }
object PersonDetails {
  implicit val formats = Json.format[PersonDetails]
}
case class PersonDetails(
  person: Person,
  contact: Contact,
  addressHistory: Seq[Address]
)