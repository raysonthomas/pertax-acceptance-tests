@suite
Feature: Verify my home address
  As a HMRC Customer who’s changing the home address
  I should be able to see an appropriate page for entering an earlier date

  JIRA story history: MTA-1691 , MTA-1701 , MTA-1702


  Scenario Outline: User tries to change home address and enters an invalid date and gets correct error messages
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
    And user updates date field 'startDate.day' with '<dayContent>'
    And user updates date field 'startDate.month' with '<monthContent>'
    And user updates date field 'startDate.year' with '<yearContent>'
    Then user continues from Enter start date page
    Then user sees text 'You can't use this service to update your address' on the page
    Then user sees text 'The date you entered is earlier than a date previously held on your address record' on the page
    And user clicks on 'go back to enter another date' link
    Then user sees text 'When did you start living here?' on the page


    Examples:

      | dayContent      | monthContent    | yearContent     |
      |01               |01               |1900             |


