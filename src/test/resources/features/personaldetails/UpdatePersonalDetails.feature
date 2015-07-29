@wip
Feature: Update Personal Details
  As a user
  I need to be able to change my address
  So that HMRC hold the correct info about me

  JIRA story history: MTA-715

  Scenario: Update Address
    Given user 'Robert Jeffries' is logged into the service
    And user is on the page with title 'Your personal tax account'
    And user clicks on 'Personal details' link
    And user is on the page with title 'Personal details'
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your personal details'
    And user updates address 'line1' with '42 Jeffry Road'
    And user updates address 'line2' with 'Newcastle Upon Tyne'
    And user updates address 'line3' with 'North East England'
    And user updates address 'line4' with 'England'
    And user updates 'postcode' with 'NE1 4JR'
    When user clicks on '.button' button
    And user is on the page with title 'Address updated'
    And user clicks on 'Return to your personal details' link
    And user is on the page with title 'Personal details'
    And Current Address '42 Jeffry Road', 'Newcastle Upon Tyne', 'North East England', 'England', 'NE1 4JR' should be visible