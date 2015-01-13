@suite
Feature: Google Search
  As a google user
  I want to google a film
  To see who is in it

 Scenario: Google search for The Godfather
    Given I am at https://duckduckgo.com
    When I search for 'The Godfather'
    Then I should have IMDb returned in my results
