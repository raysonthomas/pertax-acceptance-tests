@suite

Feature: Deep Links
  As a user
  I want to make sure Deep Links are as expected

  JIRA story history: MTA-1953


  Scenario Outline: User navigates to 'Do you get tax credits' and 'not your address page'
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
  Examples:
  | NavigatedTo                                         | PageURL                                                                               | ExpectedEndOfURL     |
  | Do you get tax credits                              | http://localhost:9232/personal-account/your-address/tax-credits-choice                | /your-address        |


  Scenario Outline: User navigates to 'Do you live in more than one place' and not indicated that they receive Tax Credits
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user clicks on 'Change your address' link
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
  Examples:
  | NavigatedTo                                           | PageURL                                                                               | ExpectedEndOfURL     |
  | Do you live in more than one place                    | http://localhost:9232/personal-account/your-address/residency-choice                  | /your-address        |


  Scenario Outline: User navigates to 'Find your address' and not submitted data for 'do you live in more than one place'
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user clicks on 'Change your address' link
    Then user selects the option No for Tax Credits
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
  Examples:
  | NavigatedTo                                        | PageURL                                                                                | ExpectedEndOfURL     |
  | Find Your Address                                  | http://localhost:9232/personal-account/your-address/sole/find-address                  | /your-address        |


  Scenario Outline: User navigates to 'Select your address' and not submitted data for 'Find your address'
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user clicks on 'Change your address' link
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option No
    Then user continues from Your address page
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
  Examples:
  | NavigatedTo                                        | PageURL                                                                                                      | ExpectedEndOfURL     |
  | Select Your Address                                |http://localhost:9232/personal-account/your-address/sole/select-address?postcode=FX97+4TU                     | /your-address        |


  Scenario Outline: User navigates to 'Edit Your Address' and not submitted data for 'Do you live in more than one place'
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user clicks on 'Change your address' link
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user sees text 'Do you live in more than one place?' on the page
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
  Examples:
  | NavigatedTo                                        | PageURL                                                                                                    | ExpectedEndOfURL     |
  | Edit Your Address                                  | http://localhost:9232/personal-account/your-address/sole/edit-address                                      | /your-address        |


  Scenario Outline: User navigates to 'When did you start living here' and not submitted data for 'Address details'
    Given A user is logged into the service using verify
    And user clicks on 'Update your address' link
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option No
    Then user continues from Your address page
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
    Examples:
      | NavigatedTo                                                     | PageURL                                                                                                        | ExpectedEndOfURL     |
      | When did you start living here                                  | http://localhost:9232/personal-account/your-address/sole/enter-start-date                                      | /your-address        |


  Scenario Outline: User navigates to 'Check your details' and not submitted data for 'Date'
    Given A user is logged into the service using verify
    And user clicks on 'Update your address' link
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
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
    Examples:
      | NavigatedTo                                                     | PageURL                                                                                                        | ExpectedEndOfURL     |
      | Check your details                                              | http://localhost:9232/personal-account/your-address/sole/changes                                               | /your-address        |


  Scenario Outline: User navigates directly to 'Done' page
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
    And user is on the page with title 'Your address has already been updated' and URL is correct
    Then user sees 'current address' link on the page and its href is as expected
    Then user sees 'personal tax account home' link on the page and its href is as expected

    Examples:
      | NavigatedTo                                                     | PageURL                                                                                                                            | ExpectedEndOfURL                |
      | Your address has been saved                                     | http://localhost:9232/personal-account/your-address/sole/thank-you                                                                 | /your-address/sole/thank-you    |


  Scenario Outline: Correspondence Address: User navigates to 'Find an address' page and not viewed page 'Your address'
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
    Examples:
      | NavigatedTo                                                     | PageURL                                                                                                        | ExpectedEndOfURL     |
      | Find an address                                                 | http://localhost:9232/personal-account/your-address/postal/find-address                                        | /your-address        |


  Scenario Outline: Correspondence Address: User navigates to 'Select an address' page and not submitted data for 'Find an address'
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user clicks on 'Change where we send your letters' link
    Then user is on the page with title 'Find an address' and URL is as expected
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
    Examples:
      | NavigatedTo                                                     | PageURL                                                                                                                            | ExpectedEndOfURL     |
      | Select an address                                               | http://localhost:9232/personal-account/your-address/postal/select-address?postcode=FX97+4TU                                        | /your-address        |


  Scenario Outline: Correspondence Address: User navigates to 'Edit the address' page and not viewed page 'Your address'
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
    Examples:
      | NavigatedTo                                                     | PageURL                                                                                                                            | ExpectedEndOfURL     |
      | Edit the address                                                | http://localhost:9232/personal-account/your-address/postal/edit-address                                                            | /your-address        |


  Scenario Outline: Correspondence Address: User navigates directly to 'Done' page
    Given A user is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user navigates to <NavigatedTo> page with <PageURL> url
    And url ends with <ExpectedEndOfURL>
    And user is on the page with title 'Your address has already been updated' and URL is as expected for the postal address change
    Then user sees 'current address' link on the page and its href is as expected
    Then user sees 'personal tax account home' link on the page and its href is as expected

    Examples:
      | NavigatedTo                                                     | PageURL                                                                                                                            | ExpectedEndOfURL                |
      | Your address has been saved                                     | http://localhost:9232/personal-account/your-address/postal/thank-you                                                               | /your-address/postal/thank-you  |