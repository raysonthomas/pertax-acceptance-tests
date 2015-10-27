@wip
Feature: Update Personal Details
  As a user
  I need to be able to change my address
  So that HMRC holds the correct info about me

  JIRA story history: MTA-715, MTA-790, MTA-887

  Scenario: Positive update address journey
    Given user 'Robert Jeffries' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Personal details' link
    And user is on the page with title 'Personal details' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Update your address' and URL is as expected
    And user updates address 'line1' with '42 Jeffry Road'
    And user updates address 'line2' with 'Newcastle Upon Tyne'
    And user updates address 'line3' with 'North East England'
    And user updates address 'line4' with 'England'
    And user updates 'postcode' with 'NE1 4JR'
    When user clicks on 'submit' button
    And user is on the page with title 'Address updated' and URL is as expected
    And user clicks on 'Return to your personal details' link
    And user is on the page with title 'Personal details' and URL is as expected
    And Updated Address '42 Jeffry Road', 'Newcastle Upon Tyne', 'North East England', 'England', 'NE1 4JR' should be visible
#   last step is executed only on QA environment

  Scenario Outline: Negative update address journey
    Given user 'Robert Jeffries' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Personal details' link
    And user is on the page with title 'Personal details' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Update your address' and URL is as expected
    And user updates address 'line1' with '<line1_content>'
    And user updates address 'line2' with '<line2_content>'
    And user updates address 'line3' with '<line3_content>'
    And user updates address 'line4' with '<line4_content>'
    And user updates 'postcode' with '<postcode_content>'
    And user clicks on 'submit' button
    And error message for address line'1' is '<line1_error_msg>'
    And error message for address line'2' is '<line2_error_msg>'
    And error message for address line'3' is '<line3_error_msg>'
    And error message for address line'4' is '<line4_error_msg>'
    And error message for postcode'5' is '<postcode_error_msg>'
  Examples:
    | line1_content   | line2_content   | line3_content   | line4_content             | postcode_content | line1_error_msg                                                                                                                             | line2_error_msg                                                                                                                             | line3_error_msg                                                                                                                                                          | line4_error_msg                                                                                                                             | postcode_error_msg        |
    |                 |                 |                 |                           |                  | This field is required                                                                                                                      | This field is required                                                                                                                      | None                                                                                                                                                                     | None                                                                                                                                        | Enter a valid UK postcode |
    | £               | ¬               |                 | π                         | NE12AB           | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) and ampersands (&)  | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) and ampersands (&)  | This field is required                                                                                                                                                   | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) and ampersands (&)  | Enter a valid UK postcode |
    | !#$%&’()*+,-./: | ;<=>?@[\]^_‘{}~ | ;<=>?@[\]^_‘{}~ | <script>alert(1)</script> | NE1 2AB          | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) and ampersands (&)  | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) and ampersands (&)  | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) and ampersands (&)                               | Your address can include letters a to z, numbers, spaces, hyphens (-), apostrophes (‘), commas (,), forward slashes (/) and ampersands (&)  | None                      |
    | &’(),  -./      | &’(),  -./      | &’(),  -./      | &’(),  -./                | NE1 2AB          | None                                                                                                                                        | None                                                                                                                                        | None                                                                                                                                                                     | None                                                                                                                                        | None                      |
    | My 42 Road      | Clean county    |                 | Northumbria               | TF34ER           | None                                                                                                                                        | None                                                                                                                                        | This field is required                                                                                                                                                   | None                                                                                                                                        | Enter a valid UK postcode |
