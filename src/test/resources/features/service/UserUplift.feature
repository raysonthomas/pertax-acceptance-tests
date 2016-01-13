@wip
Feature: IV Uplift feature used by user - success and failure pages
  As a user
  I must be able to use the IV uplift feature
  So that I can access the service successfully and I get the proper Failure Pages and Messages


  JIRA story history: MTA-1482

  Scenario: Positive Uplift Journey
    Given GG user 'Christopher Grantham' is logged into the service
    And user is on the page with title 'Confirm your identity' and URL is as expected
    And user goes through IV Uplift Journey
    And user is on the page with title 'Identity verification confirmation' with expected URL
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Locked Out screen
    Given GG user 'Christopher Grantham' is logged into the service
    And user is on the page with title 'Confirm your identity' and URL is as expected
    And user is Locked Out of the service for IV Uplift
    And user is on the page with title 'Identity Verification Failed' with expected URL
    And user sees text 'Continue to your personal tax account' on the page
    And user sees text 'you can try again in 24 hours' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Insufficient Evidence
    Given GG user 'Christopher Grantham' is logged into the service
    And user is on the page with title 'Confirm your identity' and URL is as expected
    And user has Insufficient Evidence for IV Uplift
    And user is on the page with title 'Identity Verification Failed' with expected URL
    And user sees text 'Continue to your personal tax account' on the page
    And user sees text 'Your details are still secure' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for User Aborted
    Given GG user 'Christopher Grantham' is logged into the service
    And user is on the page with title 'Confirm your identity' and URL is as expected
    And user is Aborted for IV Uplift
    And user is on the page with title 'Identity Verification Failed' with expected URL
    And user sees text 'Continue to your personal tax account' on the page
    And user sees text 'Your details are still secure' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Technical Issue
    Given GG user 'Christopher Grantham' is logged into the service
    And user is on the page with title 'Confirm your identity' and URL is as expected
    And user has technical issues for IV Uplift
    And user is on the page with title 'Identity Verification Failed' with expected URL
    And user sees text 'There's a technical problem' on the page
    And user sees text 'This online service is experiencing technical difficulties.' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Timeout
    Given GG user 'Christopher Grantham' is logged into the service
    And user is on the page with title 'Confirm your identity' and URL is as expected
    And user is Timed Out for IV Uplift
    And user sees text 'Session Timed Out' on the page
    And user navigates to personal tax account





