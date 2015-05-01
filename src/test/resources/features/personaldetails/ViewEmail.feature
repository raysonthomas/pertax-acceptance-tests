@suite
Feature: View Email
  As an HMRC Customer
  I need to view my email address,
  So that I can verify that HMRC holds my correct e-mail address

  JIRA story history: MTA-264

  Scenario: View Email in Your personal details Page
    Given 'Robert Jeffries' is logged in to PTA
    And Page is: '/pertax'
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then Page is: '/pertax/personalDetails'
    And 'rjeffries@example.com' is displayed as email address

  Scenario: No Email is held on record
    Given 'Timothy Bull' is logged in to PTA
    And Page is: '/pertax'
    When 'Timothy Bull' clicks on 'Personal details' link
    Then Page is: '/pertax/personalDetails'
    And 'Your email' label is not displayed