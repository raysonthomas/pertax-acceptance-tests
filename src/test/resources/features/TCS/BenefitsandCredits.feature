@suite
Feature: Link to tax Credits in benefits and Credits
  As a user
  I must be able to use the link to tax Credits from Benefits and Credits


  JIRA story history: MTA-1646, MTA-1750

  Scenario: Verify user can see TCS link in Benefits and Credits section
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    And Breadcrumb is: ''
    And user sees 'Benefits and tax credits' link on the page and its href is as expected
    And user clicks on 'Benefits and tax credits' link
    And Breadcrumb is: 'Account home'
    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
    And user sees 'Renew your tax credit claim' link on the page and its href is as expected

  Scenario: GG User if Uplifted can see TCS link in Benefits and Credits section
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user navigates to personal tax account home page
    And user sees 'Benefits and tax credits' link on the page and its href is as expected
    And user clicks on 'Benefits and tax credits' link
    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
    And user sees 'Renew your tax credit claim' link on the page and its href is as expected

  Scenario: GG User if Not Uplifted can Not see TCS link in Benefits and Credits section
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL
