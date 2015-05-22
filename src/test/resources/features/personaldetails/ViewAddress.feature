@suite
Feature: View Address
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct address

  JIRA story history: MTA-8

  Scenario: View Address in Your personal details Page
    Given user 'Robert Jeffries' is logged into the service
    And user is on the home page
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then user is on the personal details page
    And Current Address 'Benton Park View', 'Longbenton', 'Tyne and Wear', 'North Tyneside', 'NE1 1AA' should be visible