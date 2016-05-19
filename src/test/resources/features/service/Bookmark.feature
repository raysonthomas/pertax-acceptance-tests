@suite @smoke
Feature: Test the bookmark feature

  As a user
  I must be able to return to a bookmarked page
  So that I can navigate through PTA appropriately

  JIRA story history: MTA-2016

  Scenario: User should be returned to the 'your Address' page when directly navigating to the 'your address' page
    Given GG user 'SA Christopher Grantham' is not logged into the service
    And Directly navigates to 'your address' page
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user is on the page with title 'Your address' and URL is as expected

  Scenario: User should be returned to the 'your Address' page when directly navigating to the 'check your answers' page
    Given GG user 'SA Christopher Grantham' is not logged into the service
    And Directly navigates to 'check your answers' page
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user is on the page with title 'Your address' and URL is as expected

  Scenario: User should be returned to the 'benefits & tax credits' page when directly navigating to the 'benefits and tax credits' page
    Given GG user 'SA Christopher Grantham' is not logged into the service
    And Directly navigates to 'benefits & tax credits' page
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user is on the page with title 'benefits & tax credits' and URL is as expected

  Scenario: User should be returned to the 'address already updated' page when directly navigating to the 'done' page
    Given GG user 'SA Christopher Grantham' is not logged into the service
    And Directly navigates to 'address already updated' page
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user is on the page with title 'benefits & tax credits' and URL is as expected