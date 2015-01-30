@wip
Feature: PTA:View Valid From
  As an HMRC Customer
  I need to view my current Address's Valid From date,
  So that I can verify that HMRC holds my correct current address's Valid From date

  Scenario: Correct Valid From date is visible in Personal Details page
    Given John Densmore is logged in to PTA
    And PTA landing page is displayed
    And Personal Details link is visible
    When John Densmore clicks on Personal Details link
    Then Personal Details page is displayed
    And 27 January 2004 is displayed as the Address's Valid From date

  Scenario: Missing Valid From date is visible as "?" in Personal Details page
    Given Robert Jeffries is logged in to PTA
    And PTA landing page is displayed
    And Personal Details link is visible
    When Robert Jeffries clicks on Personal Details link
    Then Personal Details page is displayed
    And ? is displayed as the Address's Valid From date



# JIRA story history: MTA-272