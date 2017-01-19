@suite
Feature: SA Activation
  As a user
  I want to see correct SA features based on SA Activation

  JIRA story history: MTA-2112, MTA-2439, MTA-2443

#  Scenario: When a gg user has enrolled for self assessment and been issued their activation code then navigates to PTA
#    Given User who has enrolled for Self Assessment and Not Yet Activated is logged into the service using gg
#    And user completes 2FA Journey
#    And user completes IV Uplift Journey
#    And user Continues the journey to PTA
#    Then user is on the page with title 'Personal tax account' and URL is as expected
#    And user sees 'Self Assessment' link on page and its href is as expected
#    And user sees text 'Activate your Self Assessment using the 12-digit activation code you received in the post.' on the home page

  Scenario: User who has an SA UTR logs in to PTA with gg credentials which do not have an SA enrolment, has link to Webchat
    Given  User with gg credentials not linked to SA is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user waits for 'Personal tax account' page
    And user clicks on 'Self Assessment' link
    Then user is on the You can't access your Self Assessment information from this account page with Url and title as expected
    Then user sees the text 'You can't access your Self Assessment information from this account' on SA page
    And user sees the text 'If you send your tax return online' on SA page
    And user sees 'sign out' link on the page and its href is as expected
    And user sees 'Recover your user ID' link on the page and its href is as expected
    And user sees the text 'If you have never sent your tax return online' on SA page
    And user sees 'enrol for Self Assessment online (opens in a new window)' link on the page and its href is as expected
    And user sees 'request a new activation code (opens in a new window)' link on the page and its href is as expected
    And user sees the text 'Use this within 28 days to activate your account' on SA page
    And user sees the text 'If you send your tax return by post' on SA page
    And user sees 'do your tax return online (opens in a new window)' link on the page and its href is as expected
    And user sees 'Chat online with one of our advisers' link on the page and its href is as expected
    And user clicks on 'Chat online with one of our advisers' link
    And user verifies that the chat window is opened as expected

