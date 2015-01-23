@suite
Feature: PTA:View NINO
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds the correct NINO.

  Scenario: View NINO in Personal Details Page

    Given Ryan Little has logged in to his account
    And should be on 'Personal tax account' page
    And should see the 'Personal details' link
    When Ryan Little click on 'Personal details' link
    Then Ryan little should be see 'Personal Details' page
    And 'QQ123456A' should be displayed


# JIRA story history: MTA-260