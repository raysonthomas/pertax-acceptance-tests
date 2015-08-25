@wip
Feature: Update Personal Details
  As a user
  I need to be able to change my address
  So that HMRC holds the correct info about me

  JIRA story history: MTA-715, MTA-790

  Scenario: Positive update address journey
    Given user 'Robert Jeffries' is logged into the service
    And user is on the page with title 'Your personal tax account'
    And user clicks on 'Personal details' link
    And user is on the page with title 'Personal details'
    And user clicks on 'Update your address' link
    And user is on the page with title 'Update your address'
    And user updates address 'line1' with '42 Jeffry Road'
    And user updates address 'line2' with 'Newcastle Upon Tyne'
    And user updates address 'line3' with 'North East England'
    And user updates address 'line4' with 'England'
    And user updates 'postcode' with 'NE1 4JR'
    When user clicks on 'submit' button
    And user is on the page with title 'Address updated'
    And user clicks on 'Return to your personal details' link
    And user is on the page with title 'Personal details'
    And Updated Address '42 Jeffry Road', 'Newcastle Upon Tyne', 'North East England', 'England', 'NE1 4JR' should be visible
    # last step is executed only on QA environment

  Scenario Outline: Negative update address journey
    Given user 'Robert Jeffries' is logged into the service
    And user is on the page with title 'Your personal tax account'
    And user clicks on 'Personal details' link
    And user is on the page with title 'Personal details'
    And user clicks on 'Update your address' link
    And user is on the page with title 'Update your address'
    And user updates address 'line1' with '<line1_content>'
    And user updates address 'line2' with '<line2_content>'
    And user updates address 'line3' with '<line3_content>'
    And user updates address 'line4' with '<line4_content>'
    And user updates 'postcode' with '<postcode_content>'
    And user clicks on 'submit' button
    And error message for address 'line1' is '<line1_error_msg>'
    And error message for address 'line2' is '<line2_error_msg>'
    And error message for address 'line3' is '<line3_error_msg>'
    And error message for address 'line4' is '<line4_error_msg>'
    And error message for 'postcode' is '<postcode_error_msg>'
  Examples:
    | line1_content                  | line2_content                  | line3_content                  | line4_content                  | postcode_content | line1_error_msg                                                                                                                | line2_error_msg                                                                                                                | line3_error_msg                                                                                                                | line4_error_msg                                                                                                                | postcode_error_msg                                                                                                             |
    |                                |                                |                                |                                |                  | This field is required                                                                                                         | This field is required                                                                                                         | This field is required                                                                                                         | This field is required                                                                                                         | Enter a valid UK postcode                                                                                                      |
    | \ b@d - symbol /               | \ b@d - symbol /               | \ b@d - symbol /               | \ b@d - symbol /               | \ b@d - symbol / | Entry can only include letters a to z, numbers, spaces, hyphens, apostrophes, commas, forward slashes ( / ) and ampersands (&) | Entry can only include letters a to z, numbers, spaces, hyphens, apostrophes, commas, forward slashes ( / ) and ampersands (&) | Entry can only include letters a to z, numbers, spaces, hyphens, apostrophes, commas, forward slashes ( / ) and ampersands (&) | Entry can only include letters a to z, numbers, spaces, hyphens, apostrophes, commas, forward slashes ( / ) and ampersands (&) | Entry can only include letters a to z, numbers, spaces, hyphens, apostrophes, commas, forward slashes ( / ) and ampersands (&) |
    | !#$%&’()*+,-./:;<=>?@[\]^_‘{}~ | !#$%&’()*+,-./:;<=>?@[\]^_‘{}~ | !#$%&’()*+,-./:;<=>?@[\]^_‘{}~ | !#$%&’()*+,-./:;<=>?@[\]^_‘{}~ |                  |                                                                                                                                |                                                                                                                                |                                                                                                                                |                                                                                                                                | Enter a valid UK postcode                                                                                                      |