@suite
Feature: View NINO
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct NINO

  JIRA story history: MTA-260

  Scenario: View NINO in Your personal details Page
    Given 'Robert Jeffries' is logged in to PTA
    And Page is: '/pertax'
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then Page is: '/pertax/personalDetails'
    And NINO 'ZN522915C' is visible