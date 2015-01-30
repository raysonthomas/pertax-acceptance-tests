
Feature: PTA:View Email
  As an HMRC Customer
  I need to view my email address,
  So that I can verify that HMRC holds my correct e-mail address

  @suite
  Scenario: View Email in Personal Details Page
    Given Robert Jeffries is logged in to PTA
    And PTA landing page is displayed
    And Personal Details link is visible
    When Robert Jeffries clicks on Personal Details link
    Then Personal Details page is displayed
    And rjeffries@example.com is displayed as email address
    
    @wip
  Scenario: No Email is held on record
    Given John Densmore is logged in to PTA
    And PTA landing page is displayed
    And Personal Details link is visible
    When John Densmore clicks on Personal Details link
    Then Your email header field is not displayed



# JIRA story history: MTA-264