@suite
Feature: View Personal Details
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct name, address and nino

  JIRA story history: MTA-7, MTA-8, MTA-260

  Scenario: View personal details page
    Given user 'Robert Jeffries' is logged into the service
    And user is on the home page
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then user is on the personal-details page
    And Name 'Robert Jeffries' is visible
    And Current Address 'Benton Park View', 'Longbenton', 'Tyne and Wear', 'North Tyneside', 'NE1 1AA' should be visible
    And NINO 'ZN 52 29 15 C' is visible
    