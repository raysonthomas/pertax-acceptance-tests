@wip
Feature: PTA:View Email
  As an HMRC Customer
  I need to view my email address,
  So that I can verify that HMRC holds my correct e-mail address for me

  Scenario: View Name in Personal Details Page

    Given John Densmore has logged in to PTA
    And PTA landing page is displayed
    And sees the Personal Details link
    When John Densmore clicks on Personal Details link
    Then John Densmore sees Personal Details page
    And 'john.densmore@gmail.com' is dispalyed as his email address