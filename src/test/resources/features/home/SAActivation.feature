@suite
Feature: SA Activation
  As a user
  I want to see correct SA features based on SA Activation

  JIRA story history: MTA-2112

  Scenario: When a gg user has enrolled for self assessment and been issued their activation code then navigates to PTA

    Given User who has enrolled for Self Assessment and Not Yet Activated is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user is on the page with title 'Personal tax account' and URL is as expected
    And user sees 'Self Assessment' link on page and its href is as expected
    And user sees text 'Activate your Self Assessment using the 12-digit activation code you received in the post.' on the home page

  Scenario: User who has an SA UTR logs in to PTA with gg credentials which do not have an SA enrolment
    Given  User with gg credentials not linked to SA is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user waits for 'Personal tax account' page
    And user clicks on 'Self Assessment' link
    Then user is on the Your Self Assessment details cannot be shown page with Url and title as expected
    Then user sees the text 'Your Self Assessment details cannot be shown' on SA page
    And user sees the text 'If you send your tax return online' on SA page
    And user sees the text 'You may have previously activated Self Assessment using different Government Gateway sign in details.' on SA page
    And user sees the text 'You can see your Self Assessment if you' on SA page
    And user sees the text 'If you send your tax return by post' on SA page
    And user sees the text 'You cannot currently see your Self Assessment details online.' on SA page
    And user sees 'Send your tax return by post (opens in a new window)' link on the page and its href is as expected

