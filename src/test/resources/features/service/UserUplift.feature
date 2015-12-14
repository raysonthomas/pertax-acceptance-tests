@wip
Feature: Uplift feature used by user - success and failure pages
  As a user
  I must be able to use the uplift feature
  So that I can access the service successfully and I get the proper Failure messages


  JIRA story history: MTA-1482

  Scenario: Positive Uplift Journey

    Given user 'xxx' logs into the IV uplift service
    And text 'You are attempting to perform a user uplift' is visible on IV Page
    And user clicks on Success radio button
    And user is on the page with title 'Your personal tax account' and URL is as expected