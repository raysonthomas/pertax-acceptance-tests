@suite
Feature: Sign out of Personal Tax Account
  As a user
  I must be able to sign out of the system
  So that other users are not able to access my account

  JIRA story history: MTA-591, MTA-805

  Scenario: Sign out of Personal Tax Account
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    When user signs out
    Then user is on the page with title 'Give feedback - Were you able to do what you needed to do today?' and URL is as expected
    And user is unable to access the application