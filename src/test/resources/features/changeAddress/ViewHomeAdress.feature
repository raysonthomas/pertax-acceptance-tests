@suite
Feature: View Home Address Details
  As a user
  I need to view my personal details,
  So that I can verify that HMRC holds my correct name, address and nino

  JIRA story history: MTA-7, MTA-8, MTA-260, MTA-516, MTA-1691

  Scenario: View personal details page
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    And Home address '6 Howsell Road', 'Llanddew', '', '', 'DN16 3FB' should be visible

    