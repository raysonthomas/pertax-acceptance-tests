@suite
Feature: SA Activation
  As a user
  I want to see correct SA features based on SA Activation

  JIRA story history: MTA-2112

  Scenario: When a gg user has enrolled for self assessment and been issued their activation code then navigates to PTA
    Given   'User who has enrolled for Self Assessment and been issued an activation code' is logged into the service using gg
    Then    user is on the page with title 'Personal tax account' and URL is as expected
    And     user sees 'Self Assessment' link on the page and its href is as expected
    And     user sees text 'Activate your Self Assessment using the 12-digit activation code you received in the post.' on the home page


  Scenario: User logs in to PTA with gg credentials which are not linked to his SA enrolment
    Given  User with gg credentials is logged into the service using gg
    Then   user is on the page with title 'Personal tax account' and URL is as expected
#    And    An event is sent to GA to log the fact the user hit this page
    And    user sees text 'Check your Self Assessment details.' on the home page
    And    user clicks on 'Self Assessment' link
    Then   user sees the text 'Your Self Assessment cannot be shown' on SA page
    And    user sees the text 'You previously activated your Self Assessment using different Government Gateway sign in details.' on SA page
    And    user sees the text 'You can see your Self Assessment if you sign out and then sign in using your different Government Gateway details.' on SA page
    When   user signs out
    Then   user is on the page with title 'Signed out' and URL is as expected




