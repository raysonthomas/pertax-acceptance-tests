@suite


Feature: Test the bookmark feature

  As a user
  I must be able to return to a bookmarked page
  So that I can navigate through PTA appropriately

  JIRA story history: MTA-2016

  Scenario Outline: User should be returned to the 'your Address' page when directly navigating to the 'your address' page
    Given user navigates to <NavigatedTo> page with <PageURL> url
    And user is redirected to Sign In page and url ends with <ExpectedEndOfURL>
    Then User logs into the service using gg
    Then user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user is on the page with title 'Your address' and URL is as expected
    Examples:
      | NavigatedTo                    | PageURL                                                                         | ExpectedEndOfURL                        |
      | Your address                   | http://localhost:9232/personal-account/your-address/tax-credits-choice          | accountType=individual&origin=PERTAX    |


  Scenario Outline: User should be returned to the 'your Address' page when directly navigating to the 'Check your details' page
    Given user navigates to <NavigatedTo> page with <PageURL> url
    And user is redirected to Sign In page and url ends with <ExpectedEndOfURL>
    Then User logs into the service using gg
    Then user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user is on the page with title 'Your address' and URL is as expected
    Examples:
      | NavigatedTo                          | PageURL                                                                         | ExpectedEndOfURL                        |
      | Check your details                   | http://localhost:9232/personal-account/your-address/sole/changes                | accountType=individual&origin=PERTAX    |


  Scenario Outline: User should be returned to the 'National Insurance' page when directly navigating to the 'National Insurance' page
    Given user navigates to <NavigatedTo> page with <PageURL> url
    And user is redirected to Sign In page and url ends with <ExpectedEndOfURL>
    Then User logs into the service using gg
    Then user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user is on the page with title 'National Insurance summary' and URL is as expected
    Examples:
      | NavigatedTo                          | PageURL                                                                          | ExpectedEndOfURL                        |
      | National Insurance                   | http://localhost:9232/personal-account/national-insurance-summary                | accountType=individual&origin=PERTAX    |


  Scenario Outline: User should be returned to the 'address already updated' page when directly navigating to the 'done' page
    Given user navigates to <NavigatedTo> page with <PageURL> url
    And user is redirected to Sign In page and url ends with <ExpectedEndOfURL>
    Then User logs into the service using gg
    Then user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Your address has already been updated' and URL is correct
    Examples:
      | NavigatedTo                                   | PageURL                                                                           | ExpectedEndOfURL                        |
      | Your address has been saved                   | http://localhost:9232/personal-account/your-address/sole/thank-you                | accountType=individual&origin=PERTAX    |



