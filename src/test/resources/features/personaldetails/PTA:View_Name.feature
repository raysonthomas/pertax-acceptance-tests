@suite
Feature: PTA:View Name
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct name

  Scenario: View Name in Personal Details Page

    Given John Densmore has logged in to PTA
    And PTA landing page is displayed
    And Personal Details link is visible
    When John Densmore clicks on Personal Details link
    Then Personal Details page is displayed
    And Name Mr John Densmore is visible


# JIRA story history: MTA-7