@suite
Feature: Manage users who have insufficient evidence for IV or are on the 'exception' list
  As a user
  Even if I am excluded from completing IV, I am able to file my Self Assessment

  JIRA story history: MTA-2368, MTA-2443

  Scenario: An Active Online Filer who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    Then user waits for 'We are processing your details' page
    And user is on the page with title 'We are processing your details' with correct URL
    Then a SA-IV-bypass click event is sent with the label 'User type - activated online SA filer' to google analytics
    And user clicks on 'click here' link
    And user is on the SA portal page

  Scenario: User is added to Exception List
    Given User added in Exception List

  Scenario: An Activated online filer who has completed 2FA and who is on the IV exception list arrives in PTA
    Given User who is in the IV exception list is logged into the service using gg
    And user completes 2FA Journey
    Then user waits for 'We are processing your details' page
    And user is on the page with title 'We are processing your details' with correct URL
    Then a SA-IV-bypass click event is sent with the label 'User type - activated online SA filer' to google analytics
    And user clicks on 'click here' link
    And user is on the SA portal page

  Scenario: A Not yet activated online filer and who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given User who has enrolled for Self Assessment and Not Yet Activated is logged into the service using gg
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    Then user waits for 'Activate your Self Assessment' page
    And user is on the page with title 'Activate your Self Assessment' with correct URL
    Then a self-assessment user type event is sent with the label 'User type - not yet activated SA filer' to google analytics
    And user sees text 'Activate your Self Assessment registration' on the page
    And user sees text 'Your activation code was sent to you by post when you registered to do your Self Assessment online' on the page
    And user sees 'call the Online Services Helpdesk (opens in a new window)' link on the page and its href is as expected
    And clicking the 'call the Online Services Helpdesk (opens in a new window)' link sends event to google analytics
    And user clicks on 'call the Online Services Helpdesk (opens in a new window)' link
    And a self-assessment click event is sent with the label 'Call OSH' to google analytics
    And user sees 'Activate your Self Assessment registration' link on the page and its href is as expected
    And clicking the 'Activate your Self Assessment registration' link sends event to google analytics
    And user clicks on 'Activate your Self Assessment registration' link
    And a self-assessment click event is sent with the label 'Activate SA registration' to google analytics

  Scenario: A Not yet activated online filer who has completed 2FA and is on the IV exception list arrives in PTA
    Given User not yet activated SA and on exception list is logged into the service using gg
    And user completes 2FA Journey
    Then user waits for 'Activate your Self Assessment' page
    And user is on the page with title 'Activate your Self Assessment' with correct URL
    Then a self-assessment user type event is sent with the label 'User type - not yet activated SA filer' to google analytics
    And user sees text 'Activate your Self Assessment registration' on the page
    And user sees text 'Your activation code was sent to you by post when you registered to do your Self Assessment online' on the page
    And user sees 'call the Online Services Helpdesk (opens in a new window)' link on the page and its href is as expected
    And clicking the 'call the Online Services Helpdesk (opens in a new window)' link sends event to google analytics
    And user clicks on 'call the Online Services Helpdesk (opens in a new window)' link
    And a self-assessment click event is sent with the label 'Call OSH' to google analytics
    And user sees 'Activate your Self Assessment registration' link on the page and its href is as expected
    And clicking the 'Activate your Self Assessment registration' link sends event to google analytics
    And user clicks on 'Activate your Self Assessment registration' link
    And a self-assessment click event is sent with the label 'Activate SA registration' to google analytics

  Scenario: An Ambiguous SA User and who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given User with gg credentials not linked to SA is logged into the service using gg
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    Then user is on the You can't access your Self Assessment information page with Url and title as expected
    Then a self-assessment user type event is sent with the label 'User type - Ambiguous SA filer' to google analytics
    Then user sees the text 'You can't access your Self Assessment information from this account' on SA page
    And user sees the text 'If you send your tax return online' on SA page
    And user sees 'sign out' link on the page and its href is as expected
    And clicking the 'sign out' link sends event to google analytics
    And user clicks on 'sign out' link
    And a self-assessment click event is sent with the label 'Ambiguous SA user - Sign out' to google analytics
    And user sees 'Recover your user ID' link on the page and its href is as expected
    And clicking the 'Recover your user ID' link sends event to google analytics
    And user clicks on 'Recover your user ID' link
    And a self-assessment click event is sent with the label 'Ambiguous SA user - Recover ID' to google analytics
    And user sees the text 'If you have never sent your tax return online' on SA page
    And user sees 'enrol for Self Assessment online (opens in a new window)' link on the page and its href is as expected
    And clicking the 'enrol for Self Assessment online (opens in a new window)' link sends event to google analytics
    And user clicks on 'enrol for Self Assessment online (opens in a new window)' link
    And a self-assessment click event is sent with the label 'Ambiguous SA user - Enrol for SA' to google analytics
    And user sees 'request a new activation code (opens in a new window)' link on the page and its href is as expected
    And clicking the 'request a new activation code (opens in a new window)' link sends event to google analytics
    And user clicks on 'request a new activation code (opens in a new window)' link
    And a self-assessment click event is sent with the label 'Ambiguous SA user - Activate SA' to google analytics
    And user sees the text 'Use this within 28 days to activate your account' on SA page
    And user sees the text 'If you send your tax return by post' on SA page
    And user sees 'do your tax return online (opens in a new window)' link on the page and its href is as expected
    And clicking the 'do your tax return online (opens in a new window)' link sends event to google analytics
    And user clicks on 'do your tax return online (opens in a new window)' link
    And a self-assessment click event is sent with the label 'Ambiguous SA user - Send by post' to google analytics
    And user sees 'Chat online with one of our advisers' link on the sa continue page
    And user clicks on 'Chat online with one of our advisers' link
    And user verifies that the chat window is opened as expected

  Scenario: A non-SA Filer who has completed 2FA but has insufficient evidence to complete IV arrives in PTA
    Given User with a PAYE account, but no SA account is logged into the service using gg
    And user completes 2FA Journey
    And user has Insufficient Evidence for IV Uplift
    Then user waits for 'We're unable to confirm your identity' page
    And user is on the page with title 'We're unable to confirm your identity' with correct URL
    And user sees text 'You can't access this service because HM Revenue and Customs (HMRC) doesn't know enough about you to be able to confirm your identity' on the page
    And user sees 'contact HMRC (opens in a new window)' link on the page and its href is as expected









