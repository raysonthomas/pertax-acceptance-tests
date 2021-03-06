@suite
Feature: Tax Credits Page without dependency on NPS
  As a user
  I want to go into Tax Credits page from PTA home without dependency on NPS


  JIRA story history: MTA-2071

  Scenario: Check that user not in NPS is able to access Tax Credits via PTA
    Given A user with a PAYE account and not in NPS is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    Then user navigates to Tax Credits page
#    And Breadcrumb is: 'Account home'
#    And text 'Your tax credits' is visible on Tax credits Page
    Then user is on the page with Tax Credits URL
    And user navigates to personal tax account home page
    And user is on the page with title 'Personal tax account' and URL is as expected










