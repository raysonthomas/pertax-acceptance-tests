@suite
Feature: Google Analytics Tracking

  I want to make sure that links are Trackeable by Google Analytics
  JIRA story history: MTA-1949, MTA-1954

  Scenario: link 'check your taxable income' is Trackeable in Google Analytics
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    And  'check your taxable income' link has Google Analytics tracking enabled

  Scenario: link 'Renew your tax credit claim' is Trackeable in Google Analytics
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    Then user clicks on 'Benefits and tax credits' link
    And  'Renew your tax credit claim' link has Google Analytics tracking enabled

  Scenario: Continue button for 'Do you get tax credits?' is Trackeable in Google Analytics
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    And user clicks on 'Update your address' link
    And user clicks on 'Change your address' link
    And  Continue button has Google Analytics tracking enabled








