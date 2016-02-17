@wip
Feature: Link to tax Credits in benefits and Credits
  As a user
  I must be able to use the link to tax Credits from Benefits and Credits


  JIRA story history: MTA-1646, MTA-1750

  Scenario: Verify user can see TCS link in Benefits and Credits section
    Given user 'Martin Hempton' is logged into the service
    And user sees 'Benefits and tax credits' link on the page and its href is as expected
    And user clicks on 'Benefits and tax credits' link
    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
    And user sees 'View or update your tax credits claim' link on the page and its href is as expected

  Scenario: GG User if Uplifted can see TCS link in Benefits and Credits section
    Given GG user 'SA Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user navigates to personal tax account home page
    And user sees 'Benefits and tax credits' link on the page and its href is as expected
    And user clicks on 'Benefits and tax credits' link
    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
    And user sees 'View or update your tax credits claim' link on the page and its href is as expected

  Scenario: GG User if Not Uplifted can Not see TCS link in Benefits and Credits section
    Given GG user 'SA Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    And user Continues the journey to PTA
    And user navigates to personal tax account home page
    And user sees 'Benefits and tax credits' link on the page and its href is as expected
    And user clicks on 'Benefits and tax credits' link
    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
    And text 'You can see this part of your account if you complete some additional security steps.' is visible on Benefits and Credits Page




