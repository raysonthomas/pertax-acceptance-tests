@suite @smoke
Feature: Feedback From Anywhere in the Service
  As a user
  I must be able to see feedback link to all pages
  So that I can leave feedback about the all service accessed from PTA

  JIRA story history: MTA-1119

  Scenario: See Feedback Link while navigating through PTA & other integrated Services
    Given user 'Martin Hempton' is logged into the service
    When user is on the page with title 'Your personal tax account' and URL is as expected
    And Breadcrumb is: ''
    Then user sees 'feedback' link on the page and its href is as expected