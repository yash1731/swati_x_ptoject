@regression
Feature: Create a Quote when no order exists
  As a trader
  I want to ask for a quote if available
  So I can have a quote for the quantity I want to order

  @noQuote
  Scenario: Empty quote when non exist in the system
    Given I have received the spot price for a "specific symbol" from the Market Data Service
    When I submit a quote request via the Quote Service where there exists no order for that symbol
    Then I should get the quote which should contain an empty bid and an empty offer value with a status of "Open"