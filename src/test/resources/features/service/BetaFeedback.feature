@suite
Feature:
  As a user
  I need to know that the service I am using is in beta and have a way to provide feedback on it
  So that my expectations are managed and I can help improve the service

  JIRA story history: MTA-497

  Scenario: user can see the beta banner
    Given user 'Robert Jeffries' is logged into the service
    Then the Beta banner is displayed

  Scenario: feedback link is visible and its path leads to feedback page
    Given user 'Robert Jeffries' is logged into the service
    Then the feedback link is displayed
    And the feedback url path leads to feedback page
