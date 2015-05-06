@wip
Feature: Annual Taxable Income estimate for the current tax year is visible on the home page
  As a user
  I want to see my Annual Taxable Income estimate on the home page
  So I can be sure that HMRC holds my correct taxable income details

  JIRA story history: MTA-489

  Scenario: Annual Taxable Income estimate is visible on the home page
    Given 'Jim Ferguson' is logged in to PTA
    And Page address path is: '/home'
    Then Annual Taxable Income estimate Heading is: 'Annual taxable income'
    And Annual Taxable Income estimate Subheading is: 'Estimate for <currentYear> to <nextYear>'
    And Annual Taxable Income estimate value is: '£9,999.99'
    And Annual Taxable Income estimate hyperlink that leads to more details name is: 'View details'
    And Annual Taxable Income estimate hyperlink that leads to more details destination is: '/pertax'
