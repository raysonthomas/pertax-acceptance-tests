@suite
Feature: Uplift feature used by user - success and failure pages
  As a user
  I must be able to use the uplift feature
  So that I can access the service successfully and I get the proper Failure messages


  JIRA story history: MTA-1482

  Scenario: Positive Uplift Journey
    Given user Christopher Grantham logs into the IV uplift service
    And text 'You are attempting to perform a user uplift' is visible on IV Page
    And user clicks on Success radio button
    And user clicks on Submit button
    And user is on the page with title 'Identity verification confirmation' with expected URL
    And user clicks on Continue button
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Locked Out screen
    Given user Christopher Grantham logs into the IV uplift service
    And text 'You are attempting to perform a user uplift' is visible on IV Page
    And user clicks on Locked Out radio button
    And user clicks on Submit button
    And user is on the page with title 'Identity Verification Failed' with expected URL
    And user sees text 'Continue to your personal tax account' on the page
    And user sees text 'you can try again in 24 hours' on the page
    And user clicks on Continue button
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Insufficient Evidence
    Given user Christopher Grantham logs into the IV uplift service
    And text 'You are attempting to perform a user uplift' is visible on IV Page
    And user clicks on Insufficient Evidence radio button
    And user clicks on Submit button
    And user is on the page with title 'Identity Verification Failed' with expected URL
    And user sees text 'Continue to your personal tax account' on the page
    And user sees text 'Your details are still secure' on the page
    And user clicks on Continue button
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for User Aborted
    Given user Christopher Grantham logs into the IV uplift service
    And text 'You are attempting to perform a user uplift' is visible on IV Page
    And user clicks on User Aborted radio button
    And user clicks on Submit button
    And user is on the page with title 'Identity Verification Failed' with expected URL
    And user sees text 'Continue to your personal tax account' on the page
    And user sees text 'Your details are still secure' on the page
    And user clicks on Continue button
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Technical Issue
    Given user Christopher Grantham logs into the IV uplift service
    And text 'You are attempting to perform a user uplift' is visible on IV Page
    And user clicks on Technical Issue radio button
    And user clicks on Submit button
    And user is on the page with title 'Identity Verification Failed' with expected URL
    And user sees text 'There's a technical problem' on the page
    And user sees text 'This online service is experiencing technical difficulties.' on the page
    And user clicks on Continue button
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Timeout
    Given user Christopher Grantham logs into the IV uplift service
    And text 'You are attempting to perform a user uplift' is visible on IV Page
    And user clicks on Timed Out radio button
    And user clicks on Submit button
    And user sees text 'Session Timed Out' on the page
    And user navigates to personal tax account





