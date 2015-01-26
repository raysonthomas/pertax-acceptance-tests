@suite
Feature: PTA:View Address
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct address

  Scenario: View Address in Personal Details Page

    Given John Densmore has logged in to PTA
    And PTA landing page is displayed
    And sees the Personal Details link
    When John Densmore clicks on Personal Details link
    Then John Densmore sees Personal Details page
    And 'Benton Park View, Longbenton, Tyne and Wear, North Tyneside, NE1 1AA' should be displayed as a current address


# JIRA story history: MTA-8