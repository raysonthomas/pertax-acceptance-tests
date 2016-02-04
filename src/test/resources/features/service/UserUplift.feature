@wip
Feature: IV Uplift feature used by user - success and failure pages
  As a user
  I must be able to use the IV uplift feature
  So that I can access the service successfully and I get the proper Failure Pages and Messages


  JIRA story history: MTA-1482

  Scenario: Positive Uplift Journey
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user is on the page with title 'We've confirmed your identity' with expected URL
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Locked Out screen
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user is Locked Out of the service for IV Uplift
    And user is on the page with title 'You’ve tried to confirm your identity too many times' with expected URL
    And user sees text 'You can still complete your Self Assessment but you will not be able to access other areas of your personal tax account.' on the page
    And user sees text 'You can try again in 24 hours.' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Insufficient Evidence
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    And user is on the page with title 'We can't confirm your identity' with expected URL
    And user sees text 'Based on your answers, we can’t confirm your identity' on the page
    And user sees text 'You can continue to complete your Self Assessment. Your details are still secure.' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for User Aborted
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    And user is on the page with title 'We can't confirm your identity' with expected URL
    And user sees text 'Continue to your personal tax account' on the page
    And user sees text 'You can still complete your Self Assessment.' on the page
    And user sees text 'Because we were unable to confirm your identity, you will not be able to access all the areas of your personal tax account.' on the page
    And user sees text 'Your details are still secure' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Technical Issue
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user has technical issues for IV Uplift
    And user is on the page with title 'Identity Verification Failed' with expected URL
    And user sees text 'There's a technical problem' on the page
    And user sees text 'This online service is experiencing technical difficulties.' on the page
    And user sees text 'Please try again in 5 minutes.' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Incomplete Journey
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user has an Incomplete journey
    And user is on the page with title 'We can't confirm your identity' with expected URL
    And user sees text 'We can't confirm your identity' on the page
    And user sees text 'You can continue to complete your Self Assessment. Your details are still secure. We’ll ask you to confirm your identity the next time you sign in.' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Precondition Failed
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user has Precondition Failed
    And user is on the page with title 'We can't confirm your identity' with expected URL
    And user sees text 'You can continue to complete your Self Assessment. Your details are still secure. We’ll ask you to confirm your identity the next time you sign in.' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected




