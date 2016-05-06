@wip
Feature: Google Analytics Tracking

  I want to make sure that links are Trackeable by Google Analytics
  JIRA story history: MTA-1954

  Scenario: TCS link 'renew your tax credits' is Trackeable in Google Analytics
    Given user 'Martin Hempton' is logged into the service
    And user clicks on 'Benefits and tax credits' link
    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
    And user sees 'Renew your tax credit claim' link on the page and its href is as expected









