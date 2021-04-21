@regression
@accept
Feature: Create a Quote Response when a BUY and SELL order exists in the system
  As a trader
  I want to create a Quote Response when a satisfying order exists
  So I have an executed order

  Background:
    Given I have received the spot price for a "specific symbol" from the Market Data Service

  @accept1 @cancelOrder
  Scenario: Existing Buy Order 5620 LTCUSD and Quote Response - Offer @57 for 5500 LTCUSD
    When I create a Single BUY order as market maker A - createSingleOrderBuy
    When I then submit a quote request via the Quote Service
    Then I should get the quote which should contain a bid and an empty offer
    Then I can get the Quote id for the bid
    When I accept the bid by creating a Quote Response for an offer as below:
      | Field               | Value            |
      | ExpirationInSeconds | expIn sec        |
      | OfferPrice          | offer price      |
      | OfferQuantity       | offer quantity   |
      | Symbol              | symbol requested |
      | Type                | type requested   |
      | UserId              | user id          |
    Then I should be able to see order executed

  @accept2 @cancelOrder
  Scenario: Existing Sell Order 5520 LTCUSD and Quote Response - Buy @58 for 5500 LTCUSD
    And I create a Single SELL order as market maker A - createSingleOrderSell
    When I then submit a quote request via the Quote Service
    Then I should get the quote which should contain an offer and an empty bid
    When I accept the bid by creating a Quote Response for a bid as below:
      | Field               | Value            |
      | ExpirationInSeconds | expIn sec        |
      | bidPrice            | bid price        |
      | bidQuantity         | bid quantity     |
      | Symbol              | symbol requested |
      | Type                | type requested   |
      | UserId              | user id          |
    Then I should be able to see order executed

  @accept3 @cancelOrder
  Scenario: Existing Order 5620/5520 LTCUSD and Quote Response - Offer @57 for 5500 LTCUSD
    When I create a Single BUY order as market maker A - createSingleOrderBuy
    And I create a Single SELL order as market maker A - createSingleOrderSell
    When I then submit a quote request via the Quote Service
    Then I should get the quote which should contain a bid and an offer value
    When I accept the bid by creating a Quote Response for an offer as below:
    Then I should be able to see order executed

  @accept4 @cancelOrder
  Scenario: Existing Order 5620/5520 LTCUSD and Quote Response - Offer @57 for 5500 LTCUSD
    When I create a Single BUY order as market maker A - createSingleOrderBuy
    And I create a Single SELL order as market maker A - createSingleOrderSell
    When I then submit a quote request via the Quote Service
    Then I should get the quote which should contain a bid and an offer value
    When I accept the bid by creating a Quote Response for a bid as below:
    Then I should be able to see order executed