@suite
Feature: PTA:View Name
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct name

  Scenario: View Name in Personal Details Page

    Given John Densmore has logged in to PTA
    And PTA landing page is displayed
    And sees the Personal Details link
    When John Densmore clicks on Personal Details link
    Then John Densmore sees Personal Details page
    And Mr John Densmore is displayed


# JIRA story history: MTA-7