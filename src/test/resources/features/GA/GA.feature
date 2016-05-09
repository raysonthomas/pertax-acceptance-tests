@suite
Feature: Google Analytics Tracking

  I want to make sure that links are Trackeable by Google Analytics
  JIRA story history: MTA-1949, MTA-1954

  Scenario: TCS link 'Renew your tax credits' is Trackeable in Google Analytics
    Given user 'Martin Hempton' is logged into the service
    And  'check your taxable income' link has Google Analytics tracking enabled









