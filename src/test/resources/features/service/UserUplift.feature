@wip
Feature: IV Uplift feature used by user - success and failure pages
  As a user
  I must be able to use the IV uplift feature
  So that I can access the service successfully and I get the proper Failure Pages and Messages


  JIRA story history: MTA-1482, MTA-1736

  Scenario: Positive Uplift Journey
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user is on the page with title 'We've confirmed your identity' with expected URL
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

  Scenario: IV Failure Journey for Locked Out screen for SA user
    Given GG user 'SA Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user is Locked Out of the service for IV Uplift
    And user is on the page with title 'You’ve tried to confirm your identity too many times' with expected URL
    And user sees text 'You’ve tried to confirm your identity too many times' on the page
    And user sees text 'You can try again in 24 hours.' on the page
    And user sees text 'You can continue to your personal tax account but you will not be able to access all parts of the service. Your details are still secure.' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Insufficient Evidence / Precondition Failed / Failed Matching for SA user
    Given GG user 'SA Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    And user is on the page with title 'We’re unable to confirm your identity' with expected URL
    And user sees text 'You can try to confirm your identity again or continue to your personal tax account but you will not be able to access all parts of the service. Your details are still secure.' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for User Aborted / Incomplete Journey for SA user
    Given GG user 'SA Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    And user is on the page with title 'We’re unable to confirm your identity' with expected URL
    And user sees text 'You can try to confirm your identity again or continue to your personal tax account but you will not be able to access all parts of the service. Your details are still secure.' on the page
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected

  Scenario: IV Failure Journey for User Aborted / Incomplete Journey for Non SA user
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    And user is on the page with title 'We’re unable to confirm your identity' with expected URL
    And user sees text 'To help protect your data, you can access your personal tax account once we’ve confirmed who you are.' on the page
    And user sees text 'If you can’t confirm your identity and you have a query you can contact HM Revenue and Customs to get help.' on the page

  Scenario: IV Failure Journey for Insufficient Evidence / Precondition Failed / Failed Matching for Non SA user
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    And user is on the page with title 'We’re unable to confirm your identity' with expected URL
    And user sees text 'If you can’t confirm your identity and you have a query you can contact HM Revenue and Customs to get help.' on the page

  Scenario: IV Failure Journey for Locked Out screen for Non SA user
    Given GG user 'Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user is Locked Out of the service for IV Uplift
    And user is on the page with title 'You’ve tried to confirm your identity too many times' with expected URL
    And user sees text 'You’ve tried to confirm your identity too many times' on the page
    And user sees text 'You can try again in 24 hours.' on the page
    And user sees text 'If you have a query you can contact HM Revenue and Customs to get help.' on the page











