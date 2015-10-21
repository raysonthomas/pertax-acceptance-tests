@suite
Feature: IForms section with links to different forms
  As a user
  I want to see commonly used IForms
  So I can easily navigate to them from PTA

  JIRA story history: MTA-1135

  Scenario Outline: Check that the IForms section is displayed and the links to forms have correct redirection urls
    Given user 'John Densmore' is logged into the service
    And user is able to see IForm section 'Popular forms on GOV.UK'
    And user sees the Iform Link '<iform_link>' with correct redirection URL '<redirection_url>'

    Examples:
      | iform_link                                                                | redirection_url                                                                                                    |
      | Apply for Child Benefit                                                   | https://www.gov.uk/government/publications/child-benefit-claim-form-ch2                                            |
      | Disagree with a tax credits overpayment decision                          | https://www.gov.uk/government/publications/tax-credits-overpayment-tc846                                           |
      | Tell your bank or building society that you qualify for tax-free interest | https://www.gov.uk/government/publications/income-tax-get-interest-without-tax-taken-off-r85-from-6-april-2015     |
      | Register for Self Assessment for a reason other than self employment      | https://www.gov.uk/government/publications/self-assessment-register-for-self-assessment-and-get-a-tax-return-sa1   |
      | Get your National Insurance number in writing                             | https://www.gov.uk/government/publications/national-insurance-get-your-national-insurance-number-in-writing-ca5403 |