@regression
@wipQ
Feature: Request Negotiations when a BUY and SELL order exists in the system
  As a trader
  I want to make a second Quote Request when an order exists
  So I get a better quote

  Background:
    Given I have received the spot price for a "specific symbol" from the Market Data Service


  Scenario: Get A Quote for existing Orders
    Given I expect to receive the following quote stream updates
      | name  | count |
      | quote | 2     |
    When I create a Single BUY order as market maker A - createSingleOrderBuy
    And I create a Single SELL order as market maker A - createSingleOrderSell
    When I then submit a quote request via the Quote Service within the existing order limit
    Then I should get the quote which should contain a bid and an offer value
    And a quote request stream payload with the following
      | symbol | quantity | channel  | direction | trader | status |
      | LTCUSD | 5500     | Telegram | Inbound   | t1     | Open   |