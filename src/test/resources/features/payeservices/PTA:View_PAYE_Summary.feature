@workinprogress
Feature: PTA:View PAYE Summary
  As an HMRC Customer
  I must be able to view Tax Details on my PAYE records
  So I can be sure HMRC holds all my correct PAYE details

  Scenario: PAYE summary is displayed on PTA landing page
    Given John Densmore has logged in to PTA
    And PTA landing page is displayed
    Then PAYE summary displays Estimated Tax Income amount

  Scenario: PAYE summary is displayed on PTA landing page
    Given John Densmore has logged in to PTA
    And PTA landing page is displayed
    Then PAYE summary displays Estimated Tax Income amount


# JIRA story history: MTA-269