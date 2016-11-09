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
    And user is on the page with title 'We've confirmed your identity' with expected URL
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected

  Scenario: IV Failure Journey for Technical Issue
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user has technical issues for IV Uplift
    And user is on the page with title 'There's a technical problem' with expected URL
    And user sees text 'There's a technical problem' on the page
    And user sees text 'This online service is experiencing technical difficulties.' on the page
    And user sees text 'Please try again in 5 minutes.' on the page
    And user sees 'Try again' link on the page and its href is as expected

  Scenario: IV Failure Journey for Locked Out screen for SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user is Locked Out of the service for IV Uplift
    And user is on the page with title 'You’ve tried to confirm your identity too many times' with expected URL
    And user sees text 'You’ve tried to confirm your identity too many times' on the page
    And user sees text 'You can try again in 7 days.' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected

  Scenario: IV Failure Journey for Precondition Failed for SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected

  Scenario: IV Failure Journey for Failed Matching for SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Failed Matching for IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'If you can’t confirm your identity and you have a query you can' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected

  Scenario: IV Failure Journey for User Aborted / Incomplete Journey for SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'To help protect your data, you can access your personal tax account once we’ve confirmed who you are.' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected

  Scenario: IV Failure Journey for User Aborted / Incomplete Journey for Non SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'To help protect your data, you can access your personal tax account once we’ve confirmed who you are.' on the page
    And user sees text 'If you can’t confirm your identity and you have a query you can ' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected

  Scenario: IV Failure Journey for Precondition Failed / Failed Matching for Non SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'We're unable to confirm your identity' on the page
    And user sees text 'If you can’t confirm your identity and you have a query you can ' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected

  Scenario: IV Failure Journey for Locked Out screen for Non SA user
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user is Locked Out of the service for IV Uplift
    And user is on the page with title 'You’ve tried to confirm your identity too many times' with expected URL
    And user sees text 'You’ve tried to confirm your identity too many times' on the page
    And user sees text 'You can try again in 7 days.' on the page
    And user sees text 'If you have a query you can ' on the page
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected

Scenario: 1.  An SA user who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given A user with an SA account is logged into the service using gg
    When user successfully completes 2FA Journey
    And the user completes the IV journey where the result was that they had insufficient evidence
    Then user is on the page with text 'placeholder for SA redirect page' with expected URL

Scenario: 2. An SA user who has completed 2FA and who is on the IV exception list arrives in PTA
    Given A user with an SA account and who is on the IV exception list is logged into the service using gg
    When user successfully completes 2FA Journey
    Then user is on the page with text 'placeholder for SA redirect page' with expected URL

Scenario: 3. A user who needs to activate their SA code and who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given A user who needs to activate their SA code is logged into the service using gg
    When user successfully completes 2FA Journey
    And the user completes the IV journey where the result was that they had insufficient evidence
    Then user is on the page with text 'placeholder for SA Activate redirect page' with expected URL

Scenario: 4. A user who needs to activate their SA code who has completed 2FA and is on the IV exception list arrives  in PTA
       Given A user who needs to activate their SA code and who is on the IV exception list is logged into the service using gg
       When user successfully completes 2FA Journey
       Then user is on the page with text 'placeholder for SA Activate redirect page' with expected URL

Scenario: 5. SA User using credentials not linked to their SA account and who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given an SA User using credentials not linked to their SA account  is logged into the service using gg
    When user successfully completes 2FA Journey
    And the user completes the IV journey where the result was that they had insufficient evidence
    Then user is on the page with text 'placeholder for wrong creds redirect page' with expected URL

Scenario:6.  an SA User using credentials not linked to their SA account who has completed 2FA and who is on the IV exception list arrives in PTA
    Given an SA User using credentials not linked to their SA account  and who is on the IV exception list is logged into the service using gg
    When user successfully completes 2FA Journey
    Then user is on the page with text 'placeholder for wrong creds redirect page'' with expected URL

Scenario: 7. A non-SA user who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given A user with no SA account is logged into the service using gg
    When user successfully completes 2FA Journey
    And the user completes the IV journey where the result was that they had insufficient evidence
    Then user is on the page with text 'placeholder for non-SA insufficient evidence' with expected URL


