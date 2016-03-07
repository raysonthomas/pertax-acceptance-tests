@suite @smoke
Feature: Test the breadcrumb
  As a user
  I must be able to see the correct breadcrumb
  So that I can navigate through PTA appropriately

  JIRA story history: MTA-1119, 1848

  Scenario: See the correct breadcrumb when navigating to messages with a SAUTR User
    Given GG user 'SA Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    When user is on the page with title 'Your personal tax account' and URL is as expected
    And Breadcrumb is: ''
    And user clicks on 'Go to your messages' link
    And Breadcrumb is: 'Account home'
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Self Assessment' link
    And Breadcrumb is: 'Account home'
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Your personal tax account' and URL is as expected

    
