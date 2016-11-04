@suite
Feature: IV Uplift feature used by user - success and failure pages
  As a user
  I must be able to use the IV uplift feature
  So that I can access the service successfully and I get the proper Failure Pages and Messages


  JIRA story history: MTA-1482, MTA-1736

  Scenario: Positive Uplift Journey
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    Then user waits for 'We've confirmed your identity' page
    And user is on the page with title 'We've confirmed your identity' with expected URL
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Technical Issue
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user has technical issues for IV Uplift
    Then user waits for 'There's a technical problem' page
    And user is on the page with title 'There's a technical problem' with expected URL
    And user sees text 'There's a technical problem' on the page
    And user sees text 'This online service is experiencing technical difficulties.' on the page
    And user sees text 'Please try again in 5 minutes.' on the page
    And user sees 'Try again' link on the page and its href is as expected

  Scenario: IV Failure Journey for Locked Out screen for SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user is Locked Out of the service for IV Uplift
    Then user waits for 'You’ve tried to confirm your identity too many times' page
    And user is on the page with title 'You’ve tried to confirm your identity too many times' with expected URL
    And user sees text 'You’ve tried to confirm your identity too many times' on the page
    And user sees text 'You can try again in 7 days.' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected

  Scenario: IV Failure Journey for Precondition Failed for SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user has Precondition Failed for IV Uplift
    Then user waits for 'We're unable to confirm your identity' page
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected

  Scenario: IV Failure Journey for Failed Matching for SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Failed Matching for IV Uplift
    Then user waits for 'We're unable to confirm your identity' page
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'If you can’t confirm your identity and you have a query you can' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected

  Scenario: IV Failure Journey for User Aborted / Incomplete Journey for SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    Then user waits for 'We're unable to confirm your identity' page
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'To help protect your data, you can access your personal tax account once we’ve confirmed who you are.' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected

  Scenario: IV Failure Journey for User Aborted / Incomplete Journey for Non SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    Then user waits for 'We're unable to confirm your identity' page
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'To help protect your data, you can access your personal tax account once we’ve confirmed who you are.' on the page
    And user sees text 'If you can’t confirm your identity and you have a query you can ' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected

  Scenario: IV Failure Journey for Precondition Failed / Failed Matching for Non SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user has Precondition Failed for IV Uplift
    Then user waits for 'We're unable to confirm your identity' page
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'We're unable to confirm your identity' on the page
    And user sees text 'If you can’t confirm your identity and you have a query you can ' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected

  Scenario: IV Failure Journey for Locked Out screen for Non SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user is Locked Out of the service for IV Uplift
    Then user waits for 'You’ve tried to confirm your identity too many times' page
    And user is on the page with title 'You’ve tried to confirm your identity too many times' with expected URL
    And user sees text 'You’ve tried to confirm your identity too many times' on the page
    And user sees text 'You can try again in 7 days.' on the page
    And user sees text 'If you have a query you can ' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected

