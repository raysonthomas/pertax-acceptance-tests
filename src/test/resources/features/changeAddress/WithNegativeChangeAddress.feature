@suite
Feature: Change/Modify my home address
  As a HMRC Customer ,
  I need to be able to change my home address and prompted with proper error messages for invalid inputs

  JIRA story history: MTA-7, MTA-8, MTA-260, MTA-516, MTA-1691


  Scenario Outline: Negative update address journey
    Given User is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user waits for 'Personal tax account' page
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on visible 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user waits for residency choice
    Then user selects the option No
    Then user continues from Your address page
    And user updates 'postcode' with 'NE7 7HN'
    Then user clicks on 'submitAddressFinder' button
    Then user clicks on 'Enter your address yourself' link
    And user updates address 'line1' with '<line1_content>'
    And user updates address 'line2' with '<line2_content>'
    And user updates address 'line3' with '<line3_content>'
    And user updates address 'line4' with '<line4_content>'
    And user updates 'postcode' with '<postcode_content>'
    Then user clicks on 'updateAddress' button
    And the error message for address 'line1' is '<line1_error_msg>'
    And the error message for address 'line2' is '<line2_error_msg>'
    And the error message for address 'line3' is '<line3_error_msg>'
    And the error message for address 'line4' is '<line4_error_msg>'
    And the error message for 'postcode' is '<postcode_error_msg>'
    Examples:
      | line1_content   | line2_content   | line3_content   | line4_content             | postcode_content | line1_error_msg                                                                                                                                                              | line2_error_msg                                                                                                                                                              | line3_error_msg                                                                                                                                                              | line4_error_msg                                                                                                                                                              | postcode_error_msg        |
      |                 |                 |                 |                           |                  | This line is required                                                                                                                                                        | This line is required                                                                                                                                                        | None                                                                                                                                                                         | None                                                                                                                                                                         | Enter a valid UK postcode |
      | £               | ¬               |                 | π                         | NE12AB           | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | This line is required                                                                                                                                                        | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | None                      |
      | !#$%&’()*+,-./: | ;<=>?@[\]^_‘{}~ | ;<=>?@[\]^_‘{}~ | <script>alert(1)</script> | NE1 2AB          | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | None                      |
      | &’(),  -./      | &’(),  -./      | &’(),  -./      | <script>alert(1)</script> | &’(),  -./       | None                                                                                                                                                                         | None                                                                                                                                                                         | None                                                                                                                                                                         | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Enter a valid UK postcode |
      | My 42 Road      | Clean county    |                 | Northumbria               | TF34ER           | None                                                                                                                                                                         | None                                                                                                                                                                         | This line is required                                                                                                                                                        | None                                                                                                                                                                         | None                      |
