@wip
Feature: Tax Credits Page without dependency on NPS
  As a user
  I want to go into Tax Credits page from PTA home without dependency on NPS


  JIRA story history: MTA-2071

  Scenario: Check that user not in NPS is able to access Tax Credits via PTA
    Given A user with a PAYE account, but no SA account is logged into the tax credits service using verify
    When user is on the page with title 'Personal tax account' and URL is as expected
    Then user is on the page with title 'Your tax credits' and URL is as expected
    And Breadcrumb is: 'Account home'
    And text 'Your tax credits' is visible on Tax credits Page
    And user clicks on 'Account home' breadcrumb link










