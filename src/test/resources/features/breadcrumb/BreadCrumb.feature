@wip
Feature: Breadcrumb for Personal Tax Account
As a user of PTA
I need to be able to navigate easily back to parent pages and to see where I am at any time
So that I don't get lost
  
  Background:
    Given Robert Jeffries is logged in to PTA
    And Your account page is displayed
    
  Scenario: View breadcrumb on Your account page
    Then Account home breadcrumb link is displayed
         
  Scenario: View breadcrumb on Your personal details page
    When Robert Jeffries clicks on Personal Details link
    Then Account home breadcrumb link is displayed
    And Personal details breadcrumb link is displayed
          
  Scenario: Navigate to Your account page using breadcrumb
    And Robert Jeffries clicks on Personal Details link
    And Your personal details page is displayed
    When Robert Jeffries click on Account home breadcrumb link
    Then Your account page is displayed
    
    
    
    # JIRA story history: MTA-292