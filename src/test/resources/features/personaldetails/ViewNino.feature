@suite
Feature: View NINO
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct NINO

  JIRA story history: MTA-260

  Scenario: View NINO in Your personal details Page
    Given user 'Robert Jeffries' is logged into the service
    And user is on the home page
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then user is on the personal details page
    And NINO 'ZN 52 29 15 C' is visible