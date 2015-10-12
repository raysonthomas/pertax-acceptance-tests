@suite
Feature: Sign out of Personal Tax Account
  As a user
  I must be able to sign out of the system
  So that other users are not able to access my account

  JIRA story history: MTA-591, MTA-805

  Scenario: Sign out of Personal Tax Account
    Given user 'Jim Ferguson' is logged into the service
    When user signs out
    Then user is on the page with title 'Signed out' and URL is as expected
    And user is unable to access the application