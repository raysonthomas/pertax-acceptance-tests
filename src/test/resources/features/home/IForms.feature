@suite
Feature: IForms section with links to different forms
  As a user
  I want to see commonly used IForms
  So I can easily navigate to them from PTA
  Also test the breadcrumb is as expected

  JIRA story history: MTA-1135, MTA-1848

  Scenario: Check that the IForms section is displayed and the links to forms have correct redirection urls
    Given user 'Martin Hempton' is logged into the service
    When user is on the page with title 'Your personal tax account' and URL is as expected
    Then Breadcrumb is: ''
    And user sees 'Benefits and tax credits' link on the page and its href is as expected
    Then user clicks on 'Benefits and tax credits' link
    And Breadcrumb is: 'Account home'
    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
    And heading 'Benefits and tax credits' is visible
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Your personal tax account' and URL is as expected

    And user sees 'National Insurance' link on the page and its href is as expected
    Then Breadcrumb is: ''
    Then user clicks on 'National Insurance' link
    And Breadcrumb is: 'Account home'
    Then user is on the page with title 'National Insurance summary' and URL is as expected
    And heading 'National Insurance' is visible
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Your personal tax account' and URL is as expected

    And user sees 'Pension' link on the page and its href is as expected
    Then user clicks on 'Pension' link
    And Breadcrumb is: 'Account home'
    Then user is on the page with title 'Pensions summary' and URL is as expected
    And heading 'Pension' is visible
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Your personal tax account' and URL is as expected
