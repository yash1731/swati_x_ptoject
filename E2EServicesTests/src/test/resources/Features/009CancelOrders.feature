@regression
@cancel
Feature: Cancel orders - Single orders
  As a trader
  I want to cancel orders
  So I can delete unwanted orders

  Background:
    Given I have received the spot price for a "specific symbol" from the Market Data Service

  @cancelSell
  Scenario: Cancel a Single SELL order
    When I create a Single SELL order as market maker A - createSingleOrderSell
    Then I should be able to get the details of the new order - Sell
    When I then submit a quote request via the Quote Service
    Then I should get the quote which should contain an offer and an empty bid
    When I cancel order
    Then I should be able to see order cancelled

  @cancelBuy
  Scenario: Cancel a Single BUY order
    When I create a Single BUY order as market maker A - createSingleOrderBuy
    Then I should be able to get the details of the new order
    When I then submit a quote request via the Quote Service
    Then I should get the quote which should contain a bid and an empty offer
    When I cancel order
    Then I should be able to see order cancelled

  @cancelPartiallyExecutedSell
  Scenario: Cancel Partially Executed SELL order - Sell 5620 LTCUSD @55&Buy 5500 LTCUSD @58 = Partially Executed SELL 120 LTCUSD @55
    When I create a Single BUY order as trader A - CreateBuyOrderQtyMatchA
    And I create a matching SELL order as trader B - CreateSellOrderNoPriceMatchB
    When I submit a quote request via the Quote Service for trader B
    Then I should get the quote which should contain an offer and an empty bid
    And the status of the offer should be "PartiallyExecuted"
    When I cancel order
    Then I should be able to see order cancelled

  @cancelPartiallyExecutedBuy
  Scenario: Cancel Partially Executed BUY order - Sell 5550 LTCUSD @57&Buy 5620 LTCUSD @58 = Partially Executed BUY 70 LTCUSD @58
    When I create a Single BUY order as trader A - CreateBuyOrderQtyMatchB
    And I create a matching SELL order as trader B - CreateSellOrderQtyMatchB
    When I submit a quote request via the Quote Service for trader B
    Then I should get the quote which should contain a bid and an empty offer
    And the status of the bid should be "PartiallyExecuted"
    When I cancel order
    Then I should be able to see order cancelled