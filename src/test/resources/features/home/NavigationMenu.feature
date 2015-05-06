@wip
Feature: Navigation menu is visible on the home page
  As a user
  I want to see navigation menu on the home page
  So I can navigate to other pages of the service

  JIRA story history: none yet

  Scenario: Annual Taxable Income estimate is visible on the home page
    Given 'Jim Ferguson' is logged in to PTA
    And Page address path is: '/home'
    Then Annual Taxable Income estimate Heading is: 'Annual taxable income'
    And Annual Taxable Income estimate Subheading is: 'Estimate for <currentYear> to <nextYear>'
    And Annual Taxable Income estimate value is: '£9,999.99'
    And Annual Taxable Income estimate hyperlink that leads to more details name is: 'View details'
    And Annual Taxable Income estimate hyperlink that leads to more details destination is: '/pertax'
