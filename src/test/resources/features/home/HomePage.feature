@suite
Feature: Home Page segmentation
  As a user
  I want to see PTA home page with proper segmentation and bucketing
  Also test the breadcrumb is as expected

  JIRA story history: MTA-1135, MTA-1848, MTA-1783, MTA-1966

  Scenario: Check that the home page has proper segmentation
    Given user 'Martin Hempton' is logged into the service
    When user is on the page with title 'Your personal tax account' and URL is as expected
    Then Breadcrumb is: ''
    And user sees text 'Your benefits and tax credits' on the home page
    And user sees 'Benefits and tax credits' link on the page and its href is as expected
    Then user clicks on 'Benefits and tax credits' link
    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
    And Breadcrumb is: 'Account home'
    And heading 'Benefits and tax credits' is visible
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Your personal tax account' and URL is as expected

    And user sees text 'Your State Pension' on the home page
    And user sees 'National Insurance' link on the page and its href is as expected

    And user sees 'State Pension forecast' link on the page and its href is as expected

    And user sees text 'On Thursday 23 June there will be a vote on the UK’s membership of the European Union' on the home page
    And user sees 'More information (opens in a new window)' link for EU Referendum










