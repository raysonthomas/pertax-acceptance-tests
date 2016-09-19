@suite
Feature: NI Bucket
  As a user
  I want to see my National Insurance Record

  JIRA story history: MTA-1788, MTA-1818, MTA-1985

  Scenario: As Verify user, check that the NI Bucket page is displayed as expected
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    Then user clicks on 'National Insurance' link
    And Breadcrumb is: 'Account home'
    Then user is on the page with title 'National Insurance summary' and URL is as expected
    And heading 'National Insurance' is visible on NI page
    And user sees text 'Your National Insurance number is' on the NI page
#    And user sees nino 'AB 21 69 13 B' on the NI page
    And user sees text 'See a record of the National Insurance contributions which count towards your State Pension and check for any gaps.' on the NI page
    And user sees text 'Check your National Insurance contributions' on the NI page
    And user sees text 'Print proof of your National Insurance number' on the NI page
    And user sees text 'If you start a new job your employer will ask for your National Insurance number. You may also need your National Insurance number at other times, for example if you apply for a student loan or for certain benefits.' on the NI page
    And user sees 'Check your National Insurance contributions' link on the page and its href is as expected
    And user sees 'Print proof of your National Insurance number' link on the page and its href is as expected
    And user clicks on 'Print proof of your National Insurance number' link
    Then user is on the page with title 'Print your National Insurance summary' and URL is as expected
#    And user sees nino 'AB 21 69 13 B' on the NI Print page
    And user sees name and address 'Mrs M R HEMPTON', '6 Howsell Road', 'Llanddew', 'DN16 3FB' on the NI Print page
    And user sees name 'Mrs MARTIN ROGER HEMPTON' on the NI Print page
    And user sees today's date on the NI Print page
    And user sees text 'This number is unique to you and will not change.' on the NI page
    And user sees text 'What your National Insurance contributions are for' on the NI page
    And user clicks the Back button to go back to account home






