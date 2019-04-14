Feature: Google Search

  Scenario: Search for term
    Given I navigate to google home page
    When I search for term "example"
    Then I should see search results

