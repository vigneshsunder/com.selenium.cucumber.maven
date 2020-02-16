Feature: Google Search
Scenario: Open google page and search
    Given Google page is opened
    When I search for "India"
    Then search results should be displayed