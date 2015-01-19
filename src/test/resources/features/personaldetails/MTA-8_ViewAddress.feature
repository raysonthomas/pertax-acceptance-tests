@suite
Feature: MTA-8_View Address
  As a HMRC Customer
  I need to be able to view my current address details
  So that I know HMRC has my correct current address

  Scenario: View address in 'personal details' page

    Given Ryan Little has logged in to his account
    And should be on 'Personal tax account' page
    And should see the 'Personal details' link
    When Ryan Little click on 'Personal details' link
    Then Ryan little should be see 'Personal Details' page
    And '60 Edinburgh Drive, Bedlington, Northumberland, NE22 6NY' should be displayed as a current address