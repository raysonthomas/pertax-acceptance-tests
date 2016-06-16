@suite
Feature: Verify my home address
  As a HMRC Customer who’s not got more than one home,
  Having effective from date other than 06 April 2016,
  I need to tell HMRC about my home, and be able to change my home address,
  and prompted with correct error messages for invalid inputs

  JIRA story history: MTA-1691 , MTA-1701 , MTA-1702

  Scenario: User has an effective from date other than ( Before) 6th April 2016 and able to view correct details
    Given A user with Effective From date other than 06 April 2016 is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user is able to see a section 'This has been your main home since'
    And user sees 'Change where we send your letters' link on the page and its href is as expected


  Scenario Outline: User tries to change home address and enters an invalid date and gets correct error messages
    Given A user with Effective From date other than 06 April 2016 is logged into the service using verify
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
    Then user sees text 'When did you start living here?' on the page
    And user updates date field 'startDate.day' with '<dayContent>'
    And user updates date field 'startDate.month' with '<monthContent>'
    And user updates date field 'startDate.year' with '<yearContent>'
    Then user continues from Enter start date page
    And error message for date field is '<dateErrorMsg>' and main error message is '<mainErrorMsg>'


    Examples:

      | dayContent      | monthContent    | yearContent     | dateErrorMsg                                                |mainErrorMsg                                     |
      |                 |                 |                 | Enter a date                                                | You need to enter a date                        |
      |01               |31               |2016             | Enter a valid date                                          | Check the date you entered                      |
      |01               |01               |xxxx             | Enter a valid date                                          | Check the date you entered                      |
      |\"£$             |\"£$             |\"£$             | Enter a valid date                                          | Check the date you entered                      |
      |01               |01               |2050             | Enter today's date or a date in the past                    | You can't enter a date in the future            |
      |01               |01               |16               | Enter a valid date                                          | Check the date you entered                      |
      |01               |01               |999              | Enter a valid date                                          | Check the date you entered                      |
      |01               |01               |0000             | Enter a valid date                                          | Check the date you entered                      |
