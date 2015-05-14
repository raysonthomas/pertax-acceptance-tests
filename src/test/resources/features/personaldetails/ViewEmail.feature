@suite
Feature: View Email
  As an HMRC Customer
  I need to view my email address,
  So that I can verify that HMRC holds my correct e-mail address

  JIRA story history: MTA-264

  Scenario: View Email in Your personal details Page
    Given user 'Robert Jeffries' is logged into the service
    And Page is: '/pertax'
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then Page is: '/pertax/personalDetails'
    And 'rjeffries@example.com' is displayed as email address

  Scenario: No Email is held on record
    Given user 'Timothy Bull' is logged into the service
    And Page is: '/pertax'
    When 'Timothy Bull' clicks on 'Personal details' link
    Then Page is: '/pertax/personalDetails'
    And 'Your email' label is not displayed