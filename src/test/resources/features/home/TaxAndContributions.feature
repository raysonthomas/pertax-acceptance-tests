@wip
Feature: Tax and Contributions are visible on the home page
  As a user
  I want to view my current year Tax and Contributions estimate
  So I know how much money will be deducted in tax and contributions this tax year

  JIRA story history: MTA-495

  Scenario: Income Tax Estimate value is displayed on Income Tax Estimate Summary
    Given 'Jim Ferguson' is logged in to PTA
    And Page address path is: '/pertax'
    Then Tax and Contributions Heading is: 'Tax you'll pay'
    And Tax and Contributions value is: '£1,361.40'
    And Tax and Contributions hyperlink that leads to more details name is: 'Income Tax'
    And Tax and Contributions hyperlink that leads to more details destination is: '/tai'


