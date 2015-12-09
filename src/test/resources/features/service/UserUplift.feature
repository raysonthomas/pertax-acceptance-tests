@wip
Feature: Uplift feature used by user - success and failure pages
  As a user
  I must be able to use the uplift feature
  So that I can access the service successfully and I get the proper Failure messages


  JIRA story history: MTA-1482

  Scenario: Positive Uplift Journey
    Given user 'xxx' logs into the IV uplift service
    When user is on the page with title 'Your personal tax account' and URL is as expected
    Then user sees 'feedback' link on the page and its href is as expected