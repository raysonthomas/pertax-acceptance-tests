@suite
Feature: Update Personal Details
  As a user
  I need to be able to change my address
  So that HMRC holds the correct info about me

  JIRA story history: MTA-1349,MTA_1420

  Scenario: Positive update address journey
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user clicks on 'Update your postal address' link
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And user selects the address '11 Test Street',' Testtown','','',' FX97 4TU' and continues
    Then user clicks on 'updateAddress' button
    And user is on the page with title 'Your address has been updated' and URL is as expected
    And user clicks on 'Return to your personal details' link
    And user is on the page with title 'Your address' and URL is as expected
    And Updated Address '11 Test Street',' Testtown','','',' FX97 4TU' should be visible
#   last step is executed only on QA environment


#  Scenario Outline: Negative update address journey
#    Given user 'Martin Hempton' is logged into the service
#    And user is on the page with title 'Your personal tax account' and URL is as expected
#    And user clicks on 'Update your address' link
#    And user is on the page with title 'Your address' and URL is as expected
#    Then user clicks on 'Update your postal address' link
#    Then user clicks on 'submitAddressFinder' button
#    Then user clicks on 'Enter your address if it isn't shown' link
#    And user updates address 'line1' with '<line1_content>'
#    And user updates address 'line2' with '<line2_content>'
#    And user updates address 'line3' with '<line3_content>'
#    And user updates address 'line4' with '<line4_content>'
#    And user updates 'postcode' with '<postcode_content>'
#    Then user clicks on 'updateAddress' button
#    And error message for address 'line1' is '<line1_error_msg>'
#    And error message for address 'line2' is '<line2_error_msg>'
#    And error message for address 'line3' is '<line3_error_msg>'
#    And error message for address 'line4' is '<line4_error_msg>'
#    And error message for 'postcode' is '<postcode_error_msg>'
#    Examples:
#      | line1_content   | line2_content   | line3_content   | line4_content             | postcode_content | line1_error_msg                                                                                                                                                              | line2_error_msg                                                                                                                                                              | line3_error_msg                                                                                                                                                              | line4_error_msg                                                                                                                                                              | postcode_error_msg        |
#      |                 |                 |                 |                           |                  | This line is required                                                                                                                                                        | This line is required                                                                                                                                                        | None                                                                                                                                                                         | None                                                                                                                                                                         | Enter a valid UK postcode |
#      | £               | ¬               |                 | π                         | NE12AB           | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | This line is required                                                                                                                                                        | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Enter a valid UK postcode |
#      | !#$%&’()*+,-./: | ;<=>?@[\]^_‘{}~ | ;<=>?@[\]^_‘{}~ | <script>alert(1)</script> | NE1 2AB          | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | None                      |
#      | &’(),  -./      | &’(),  -./      | &’(),  -./      | <script>alert(1)</script> | &’(),  -./       | None                                                                                                                                                                         | None                                                                                                                                                                         | None                                                                                                                                                                         | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) , full stops (.), ampersands (&) and round brackets. | Enter a valid UK postcode |
#      | My 42 Road      | Clean county    |                 | Northumbria               | TF34ER           | None                                                                                                                                                                         | None                                                                                                                                                                         | This line is required                                                                                                                                                        | None                                                                                                                                                                         | Enter a valid UK postcode |
