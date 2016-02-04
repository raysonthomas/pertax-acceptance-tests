@suite
Feature: IForms section with links to different forms
  As a user
  I want to see commonly used IForms
  So I can easily navigate to them from PTA

  JIRA story history: MTA-1135

  Scenario: Check that the IForms section is displayed and the links to forms have correct redirection urls
    Given user 'Martin Hempton' is logged into the service
    And user sees 'Benefits and tax credits' link on the page and its href is as expected
    Then user clicks on 'Benefits and tax credits' link
    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
    And heading 'Benefits and tax credits' is visible
    And user navigates to personal tax account home page

    And user sees 'National Insurance' link on the page and its href is as expected
    Then user clicks on 'National Insurance' link
    Then user is on the page with title 'National Insurance summary' and URL is as expected
    And heading 'National Insurance' is visible
    And user navigates to personal tax account home page

    And user sees 'Pension' link on the page and its href is as expected
    Then user clicks on 'Pension' link
    Then user is on the page with title 'Pensions summary' and URL is as expected
    And heading 'Pension' is visible
    And user navigates to personal tax account home page



