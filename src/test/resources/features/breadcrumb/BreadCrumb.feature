@wip
Feature: Breadcrumb for Personal Tax Account
As a PTA user
I must be able to see navigation links to the current and all parent pages
So that I don't get lost
  
  Background:
    Given 'Robert Jeffries' is logged in to PTA
    And 'Your account' page is displayed
    
  Scenario: View breadcrumb on Your account page
    Then 'Home' breadcrumb link is displayed
         
  Scenario: View breadcrumb on Your personal details page
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then 'Home' breadcrumb link is displayed
    And 'Personal Details' breadcrumb link is displayed
          
  Scenario: Navigate to Your account page using breadcrumb
    And 'Robert Jeffries' clicks on 'Personal details' link
    And 'Your personal details' page is displayed
    When 'Robert Jeffries' clicks on 'Home' breadcrumb link
    Then 'Your account' page is displayed



# JIRA story history: MTA-292
