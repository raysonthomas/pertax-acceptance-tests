@suite
Feature: Update Personal Details
  As a user
  I need to be able to change my address
  So that HMRC holds the correct info about me

  JIRA story history: MTA-1349,MTA_1420, MTA-1848, MTA-1691

  Scenario: Positive update address entering postcode
    Given user 'M Andrew' is logged into the service
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user is able to see a section 'This has been your main home since'
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option No
    Then user continues from Your address page
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And user selects the address '11 Test Street, Testtown, FX97 4TU' and continues
    Then user continues from Edit the address page
    Then user sees text 'When did you start living here?' on the page
    And user updates date field 'startDate.day' with '01'
    And user updates date field 'startDate.month' with '01'
    And user updates date field 'startDate.year' with '2016'
    Then user continues from Enter start date page
    Then user clicks on Confirm and save button on Check your answers page
    And user is on the page with title 'Your address has been updated' and whose URL is as expected
    And user clicks on 'Return to your account home' link
    And user is on the page with title 'Personal tax account' and URL is as expected



  Scenario: Positive update address entering postcode without space
    Given user 'M Andrew' is logged into the service
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user is able to see a section 'This has been your main home since'
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option No
    Then user continues from Your address page
    And user updates 'postcode' with 'FX974TU'
    Then user clicks on 'submitAddressFinder' button
    And user selects the address '11 Test Street, Testtown, FX97 4TU' and continues
    Then user continues from Edit the address page
    Then user sees text 'When did you start living here?' on the page
    And user updates date field 'startDate.day' with '02'
    And user updates date field 'startDate.month' with '01'
    And user updates date field 'startDate.year' with '2016'
    Then user continues from Enter start date page
    Then user clicks on Confirm and save button on Check your answers page
    And user is on the page with title 'Your address has been updated' and whose URL is as expected
    And user clicks on 'Return to your account home' link
    And user is on the page with title 'Personal tax account' and URL is as expected


  Scenario: Positive update address entering postcode and address line
    Given user 'M Andrew' is logged into the service
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user is able to see a section 'This has been your main home since'
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option No
    Then user continues from Your address page
    And user updates 'filter' with '11'
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And address '11 Test Street','Testtown','FX97 4TU' is displayed
    Then user continues from Edit the address page
    Then user sees text 'When did you start living here?' on the page
    And user updates date field 'startDate.day' with '03'
    And user updates date field 'startDate.month' with '01'
    And user updates date field 'startDate.year' with '2016'
    Then user continues from Enter start date page
    Then user clicks on Confirm and save button on Check your answers page
    And user is on the page with title 'Your address has been updated' and whose URL is as expected
    And user clicks on 'Return to your account home' link
    And user is on the page with title 'Personal tax account' and URL is as expected


  Scenario: Negative - User does not have their Postcode in the database
    Given user 'M Andrew' is logged into the service
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user is able to see a section 'This has been your main home since'
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option No
    Then user continues from Your address page
    And user updates 'postcode' with 'NE7 7HN'
    Then user clicks on 'submitAddressFinder' button
    And the error message for 'postcode' is 'Your address cannot be found. You can try again or enter your address yourself.'

  Scenario: Negative - User finds their Postcode but not their address
    Given user 'M Andrew' is logged into the service
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user is able to see a section 'This has been your main home since'
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option No
    Then user continues from Your address page
    And user updates 'filter' with '100'
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And the error message for 'postcode' is 'Your address cannot be found. You can try again or enter your address yourself.'

  Scenario: User uses an Invalid Postcode
    Given user 'M Andrew' is logged into the service
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user is able to see a section 'This has been your main home since'
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option No
    Then user continues from Your address page
    And user updates 'postcode' with 'ZZZ ZZZ'
    Then user clicks on 'submitAddressFinder' button
    And the error message for 'postcode' is 'Enter a valid UK postcode'







