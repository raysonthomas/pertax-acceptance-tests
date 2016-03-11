@suite
Feature: TES/TAI/PAYE
  As a PAYE user
  I need to be able to access my PAYE record
  So that I can manage my affairs

  JIRA story history: MTA-1190

  Scenario: User is enrolled in PAYE regime and should be able to see link to PAYE
    Given user 'Martin Hempton' is logged into the service
    And user sees text 'How you pay Income Tax' on the home page
    And user sees 'Pay As You Earn (PAYE)' link on the page and its href is as expected

