@wip
Feature: Marriage Allowance journeys
  As a tester
  I want to test that as an eligible user I see the Marriage Allowance link under 'Recommended for you' section

  JIRA story history: MTA-1194

  Scenario: Login as a user Not already enrolled for Marriage Allowance (tax code does not end with a 'N' or 'M')
    Given user 'John Densmore' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user is able to see Recommendation section 'Recommended for you'
    And user sees the MA Link 'Check if you're eligible for Marriage Allowance' with correct redirection URL '/marriage-allowance/marriage-allowance-s23'


  Scenario: Login as a user already enrolled for Marriage Allowance (tax code ends with a 'N' or 'M')
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user is able to see Recommendation section 'Recommended for you'
    And user does not see the MA Link 'Check if you're eligible for Marriage Allowance'