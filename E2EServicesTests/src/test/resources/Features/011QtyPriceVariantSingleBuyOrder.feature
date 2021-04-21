@regression
@QtyVariant
Feature: Create a SINGLE BUY order not matching an existing SELL order - different quantity, different price
  As a trader
  I want to create a single BUY order that does not match an existing SELL order in price and quantity
  So I can have a quote for the quantity I want to buy

  Background:
    Given I have received the spot price for a "specific symbol" from the Market Data Service

  @BuyVariantA @cancelOrder
  Scenario: Create a BUY order (5620 LTCUSD @57) when a SELL order (5520 LTCUSD @58) exists - Higher BUY Price but lower BUY Quantity
    When I create a Single SELL order as market maker A - createSingleOrderSell
    And I create a matching BUY order as trader B - createSingleOrderBuy
    And I submit a quote request via the Quote Service for trader A
    Then I should get the quote which should contain a bid and an offer value
    When I submit a quote request via the Quote Service for trader B
    Then I should get the quote which should contain a bid and an offer value

  @BuyVariantB @cancelOrder
  Scenario: Create a BUY order (5520 LTCUSD @58.5)when a SELL order (5700 LTCUSD @57) exists - Lower BUY Price but higher BUY Quantity
    When I create a Single SELL order as trader A - CreateSellOrderQtyMatchA
    And I create a matching BUY order as trader B - CreateBuyOrderNoPriceMatchB
    And I search for the executed BUY order - SearchCreateBuyOrderNoPriceMatchB
    When I submit a quote request via the Quote Service for trader B
    Then I should get the quote which should contain an offer and an empty bid
    And the status of the offer should be "PartiallyExecuted"

  @BuyVariantC @cancelOrder
  Scenario: Create a BUY order (5520 LTCUSD @56)when a SELL order (5620 LTCUSD @58) exists - Lower BUY Price and lower BUY Quantity
    And I create a Single SELL order as trader A - CreateSellOrderNoPriceMatchA
    And I create a matching BUY order as trader B - CreateBuyOrderNoPriceMatchA
    And I submit a quote request via the Quote Service for trader A
    Then I should get the quote which should contain a bid and an offer value
    When I submit a quote request via the Quote Service for trader B
    Then I should get the quote which should contain a bid and an offer value

  @BuyVariantD @cancelOrder
  Scenario: Create a BUY order (5620 LTCUSD @58)when a SELL order (5550 LTCUSD @57) exists - Higher BUY Price and higher BUY Quantity
    And I create a Single SELL order as trader A - CreateSellOrderQtyMatchB
    And I create a matching BUY order as trader B - CreateBuyOrderQtyMatchB
    When I submit a quote request via the Quote Service for trader B
    Then I should get the quote which should contain a bid and an empty offer
    And the status of the bid should be "PartiallyExecuted"