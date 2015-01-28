@wip
Feature: PTA:View Email
  As an HMRC Customer
  I need to view my email address,
  So that I can verify that HMRC holds my correct e-mail address

  Scenario: View Email in Personal Details Page
    Given John Densmore has logged in to PTA
    And PTA landing page is displayed
    And Personal Details link is visible
    When John Densmore clicks on Personal Details link
    Then Personal Details page is displayed
    And john.densmore@gmail.com is displayed as email address
    
  Scenario: No Email is held on record
    Given John Densmore has logged in to PTA
    And PTA landing page is displayed
    And Personal Details link is visible
    When John Densmore clicks on Personal Details link
    Then Personal Details page is displayed
    And No email held is displayed as email address
