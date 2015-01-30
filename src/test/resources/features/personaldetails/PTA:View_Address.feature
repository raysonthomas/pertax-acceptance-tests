@suite
Feature: PTA:View Address
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct address

  Scenario: View Address in Personal Details Page
    Given John Densmore is logged in to PTA
    And PTA landing page is displayed
    And Personal Details link is visible
    When John Densmore clicks on Personal Details link
    Then Personal Details page is displayed
    And Current Address Benton Park View, Longbenton, Tyne and Wear, North Tyneside, NE1 1AA should be visible



# JIRA story history: MTA-8