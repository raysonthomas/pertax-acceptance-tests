@suite
Feature: Sign out of Personal Tax Account
  As a PTA user
  I must be able to sign out of the system
  So that (something about security and ending sessions)

  JIRA story history: MTA-591

  Scenario: Sign out of Personal Tax Account
    Given user 'Jim Ferguson' is logged into the service
    When user signs out
    Then user is on the login page
    And user is unable to access the application

