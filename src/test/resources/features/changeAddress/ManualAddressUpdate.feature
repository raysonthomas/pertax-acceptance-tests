@suite1
Feature: Change Address Manually link visibility
  As a user
  I need to be able to change my address manually also
  So that HMRC holds the correct info about me

  JIRA story history: MTA-1975, MTA-2390

  Background:
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user is able to see a section 'This has been your main home since'
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user waits for residency choice
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option No
    Then user continues from Your address page
    And user waits for find address page

  Scenario: User leaves Postcode blank
    And user updates 'postcode' with ''
    Then user clicks on 'submitAddressFinder' button
    And the error message for 'postcode' is 'Enter a valid UK postcode'
    And user does not see a manual entry link matching: 'Enter your address yourself'

  Scenario: User enters Invalid Postcode
    And user updates 'postcode' with 'ZZZZ ZZZ'
    Then user clicks on 'submitAddressFinder' button
    And user does not see a manual entry link matching: 'Enter your address yourself'

  Scenario: User enters valid Postcode that can not be found
    And user updates 'postcode' with 'NE61 6DB'
    Then user clicks on 'submitAddressFinder' button
    And user sees a manual entry link matching: 'Enter your address yourself'

  Scenario: User enters valid Postcode that can not be found with valid House Number
    And user updates 'filter' with '10000001'
    And user updates 'postcode' with 'NE61 6DB'
    Then user clicks on 'submitAddressFinder' button
    And user sees a manual entry link matching: 'Enter your address yourself'

  Scenario: User enters valid Postcode that can not be found with invalid House Number
    And user updates 'filter' with '%$£'
    And user updates 'postcode' with 'NE61 6DB'
    Then user clicks on 'submitAddressFinder' button
    And user does not see a manual entry link matching: 'Enter your address yourself'

  Scenario: User enters valid Postcode that Can be found with House Number not found
    And Breadcrumb is: 'Account home>Your address'
    And user updates 'filter' with '100000001'
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And user sees a manual entry link matching: 'Enter your address yourself'
    And user clicks on 'Enter your address yourself' link
    Then user waits for Enter your address page
    And user is on the page with title 'Enter your address' and URL is as expected
    Then user is able to see a section 'Enter your address'


  Scenario: User enters valid Postcode that Can be found with invalid House Number
    And user updates 'filter' with '%%£$'
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And user does not see a manual entry link matching: 'Enter your address yourself'







