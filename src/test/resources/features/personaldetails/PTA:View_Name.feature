@suite
Feature: PTA:View Name
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds the correct name.

  Scenario: View Name in Personal Details Page

    Given Ryan Little has logged in to his account
    And should be on 'Personal tax account' page
    And should see the 'Personal details' link
    When Ryan Little click on 'Personal details' link
    Then Ryan little should be see 'Personal Details' page
    And Mr Ryan Little should be displayed


# JIRA story history: MTA-7