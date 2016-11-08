@suite1
Feature: Manage users who have insufficient evidence for IV or are on the 'exception' list
  As a user
  Even if I am excluded from completing IV, I am able to file my Self Assessment

  JIRA story history: MTA-2368

  Scenario: An Active Online Filer who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'Access your Self Assessment information' on the page
    And user sees text 'You can still view and file your Self Assessment return online' on the page
    Then user clicks on 'Continue' button which redirect to the Portal SA page

  Scenario: An Activated online filer who has completed 2FA and who is on the IV exception list arrives in PTA
    Given User who is in the IV exception list is logged into the service using gg
    And user completes 2FA Journey
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'Access your Self Assessment information' on the page
    And user sees text 'You can still view and file your Self Assessment return online' on the page
    Then user clicks on 'Continue' button which redirect to the Portal SA page

  Scenario: A Not yet activated online filer and who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given User who has enrolled for Self Assessment and Not Yet Activated is logged into the service using gg
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'Activate your Self Assessment registration' on the page
    And user sees text 'Your activation code was sent to you by post when you registered to do your Self Assessment online' on the page
    And user sees 'Activate your Self Assessment registration' link on the page and its href is as expected
    And user sees 'call the Online Services Helpdesk (opens in a new window)' link on the page and its href is as expected

  Scenario: A Not yet activated online filer who has completed 2FA and is on the IV exception list arrives  in PTA
    Given User not yet activated SA and on exception list is logged into the service using gg
    And user completes 2FA Journey
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'Activate your Self Assessment registration' on the page
    And user sees text 'Your activation code was sent to you by post when you registered to do your Self Assessment online' on the page
    And user sees 'Activate your Self Assessment registration' link on the page and its href is as expected
    And user sees 'call the Online Services Helpdesk (opens in a new window)' link on the page and its href is as expected

  Scenario: An Ambiguous SA User and who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given User with gg credentials not linked to SA is logged into the service using gg
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees text 'You can't access your Self Assessment' on the page
    And user sees text 'If you send your tax return online' on the page
    And user sees text 'If you send your tax return by post' on the page
    And user sees 'sign out' link on the page and its href is as expected
    And user sees 'recover your user ID' link on the page and its href is as expected
    And user sees 'Send your tax return by post (opens in a new window).' link on the page and its href is as expected

  Scenario: A non-SA Filer who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given User with a PAYE account, but no SA account is logged into the service using gg
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
    And user sees 'Try to confirm your identity again' link on the page and its href is as expected
    And user sees 'contact HM Revenue and Customs (opens in a new window)' link on the page and its href is as expected










