@wip
Feature: Tax and Contributions are visible on the home page
  As a user
  I want to view my Tax and Contributions
  So I know how much money is being deducted in tax and contributions

  JIRA story history: none yet

  Scenario: Income Tax Estimate value is displayed on Income Tax Estimate Summary
    Given 'Jim Ferguson' is logged in to PTA
    And Page address path is: '/pertax'
    Then Tax and Contributions Heading is: 'Tax youll pay'
    And Tax and Contributions value is: '£1,361.40'
    And Tax and Contributions hyperlink that leads to more details name is: 'Income Tax'
    And Tax and Contributions hyperlink that leads to more details destination is: '/pertax'


