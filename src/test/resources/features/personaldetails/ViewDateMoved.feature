@wip
Feature: PTA:View Valid From
  As an HMRC Customer
  I need to view my current Address's Valid From date,
  So I can verify HMRC holds the correct details
  
  Scenario: Correct Valid From date is visible in Personal Details page
    Given John Densmore is logged in to PTA
    And PTA landing page is displayed
    When John Densmore clicks on Personal Details link
    Then Personal Details page is displayed
    And 23 April 2013 is displayed as the Date moved to this address
    And From date supporting content is displayed

  Scenario: Missing Valid From date is not displayed in Personal Details page
    Given Timothy Bull is logged in to PTA
    And PTA landing page is displayed
    When Timothy Bull clicks on Personal Details link
    Then Personal Details page is displayed
    And Date moved to this address label is not displayed



# JIRA story history: MTA-272
