@suite
Feature: View Personal Details
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct name, address and nino

  JIRA story history: MTA-7, MTA-8, MTA-260

  Scenario: View personal details page
    Given user 'Robert Jeffries' is logged into the service
    And user is on the page with title 'Your personal tax account'
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then user is on the page with title 'Personal details'
    And Name 'ROBERT JEFFRIES' is visible
    And Current Address '71 LYNCROFT ROAD', 'LEAMINGTON SPA', 'KENT', '', 'SS9 1HA' should be visible
    And NINO 'ZN 52 29 15 C' is visible
    