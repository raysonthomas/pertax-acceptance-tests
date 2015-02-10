@wip
Feature: Breadcrumb for Personal Tax Account
As a user of PTA
I need to be able to navigate easily back to parent pages and to see where I am at any time
So that I dont get lost
  
  Scenario: View breadcrumb for personal tax account
    Given Robert Jeffries is logged in to PTA
    And Your account page is displayed
    And Accounthome breadcrumb is displayed
    When Robert Jeffries clicks on Personal Details link
    Then Your personal details page is displayed
    And Account home and Perosonal details breadcrumb is displayed
    
  Scenario: Navigate back to parent page using breadcrunb
    Given Robert Jeffires is in personal details page
    And personal details page is displayed
    And Account home and Perosonal details breadcrumb is displayed
    When Robert Jeffries click on Account home breadcrumb
    Then Robert Jeffries is navigate to Account home
    And Account home page is displayed
    