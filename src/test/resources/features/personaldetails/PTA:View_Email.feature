@suite
Feature: PTA:View Email
  As an HMRC Customer
  I need to view my email address,
  So that I can verify that HMRC holds my correct e-mail address


  Scenario: View Email in Personal Details Page
    Given Robert Jeffries is logged in to PTA
    And PTA landing page is displayed
    And Personal Details link is visible
    When Robert Jeffries clicks on Personal Details link
    Then Personal Details page is displayed
    And rjeffries@example.com is displayed as email address
    

  Scenario: No Email is held on record
    Given Timothy Bull is logged in to PTA
    And PTA landing page is displayed
    And Personal Details link is visible
    When Timothy Bull clicks on Personal Details link
    Then Your email label is not displayed



# JIRA story history: MTA-264