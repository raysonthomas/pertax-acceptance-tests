@wip
Feature: PTA:View PAYE Summary
  As an HMRC Customer
  I must be able to view Tax Details on my PAYE records
  So I can be sure HMRC holds all my correct PAYE details

  Scenario: PAYE summary is displayed on PTA landing page
    Given John Densmore has logged in to PTA
    And PTA landing page is displayed
    Then Income Tax Estimate is displayed as 5,445

  Scenario: Navigation link to PAYE
    Given John Densmore has logged in to PTA
    And PTA landing page is displayed
    Then Check your income tax link is visible that points to protocol://host:port/beta10/beta10-index


# JIRA story history: MTA-269
