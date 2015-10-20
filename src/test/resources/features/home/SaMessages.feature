@suite
Feature: SA Messages
  As a user
  I want to see SA messages if got right permission

  JIRA story history: MTA-1024, MTA-983

  Scenario: User is enrolled in SA regime and should be able to see link to messages
    Given user 'John Densmore' is logged into the service
    When user sees 'Self Assessment messages' link on the page and its href is as expected
    Then user clicks on 'Self Assessment messages' link
    And user is on the page with title 'List of messages' and URL is as expected
    And Breadcrumb is: 'Account home'
    
  Scenario: User doesn't have SA permission and can't see link to messages
    Given user 'Martin Hempton' is logged into the service
    Then user does not see 'Self Assessment messages' link on the page
