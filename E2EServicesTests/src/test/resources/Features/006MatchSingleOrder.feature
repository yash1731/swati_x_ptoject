#@regression
@match
Feature: Create a single SELL/BUY order that matches a BUY/SELL order - equal quantity and price
  As a trader
  I want to create a single order that matches an existing order
  So I can have my request completed as being executed

  Background:
    Given I have received the spot price for a "specific symbol" from the Market Data Service


  Scenario: Create a SELL order when a matching BUY order exists - 5620 LTCUSD @57
    Given I expect to receive the following stream updates
      | name  | count |
      | order | 4     |

    When I create a Single BUY order as market maker A - createSingleOrderBuy
    When I create a matching SELL order as trader B - CreateSingleSellOrderMatchingBuyOrder
    And I search for the executed SELL order - SearchCreateSingleSellOrderMatchingBuyOrder
    Then I should be able to see the SELL order with the order status as "Executed"

    And an order stream payload with the following
      | symbol | price | side | quantity | originalQuantity | liveQuantity | executionQuantity | trader      | orderType | orderStatus |
      | LTCUSD | 57.00 | BUY  | 5620     | 5620             | 5620         | 0                 | mm1         | Limit     | Open        |
      | LTCUSD | 57.00 | SELL | 5620     | 5620             | 5620         | 0                 | AIX_tester4 | Limit     | Open        |
      | LTCUSD | 57.00 | BUY  | 5620     | 5620             | 0            | 5620              | mm1         | Limit     | Executed    |
      | LTCUSD | 57.00 | SELL | 5620     | 5620             | 0            | 5620              | AIX_tester4 | Limit     | Executed    |

    When I submit a quote request via the Quote Service where order has been executed for trader A
    Then I should get the quote which should contain an empty bid and an empty offer value with a status of "Open"
    When I submit a quote request via the Quote Service where order has been executed for trader B
    Then I should get the quote which should contain an empty bid and an empty offer value with a status of "Open"

  Scenario: Create a BUY order when a matching SELL order exists - 5520 LTCUSD @58
    Given I expect to receive the following stream updates

      | name  | count |
      | order | 4     |

    When I create a Single SELL order as market maker A - createSingleOrderSell
    When I create a matching BUY order as trader B - CreateSingleBuyOrderMatchingSellOrder
    And I search for the executed BUY order - SearchCreateSingleBuyOrderMatchingSellOrder
    Then I should be able to see the BUY order with the order status as "Executed"

    And an order stream payload with the following
      | symbol | price | side | quantity | originalQuantity | liveQuantity | executionQuantity | trader      | orderType | orderStatus |
      | LTCUSD | 58.00 | SELL | 5520     | 5520             | 5520         | 0                 | mm1         | Limit     | Open        |
      | LTCUSD | 58.00 | BUY  | 5520     | 5520             | 5520         | 0                 | AIX_tester3 | Limit     | Open        |
      | LTCUSD | 58.00 | SELL | 5520     | 5520             | 0            | 5520              | mm1         | Limit     | Executed    |
      | LTCUSD | 58.00 | BUY  | 5520     | 5520             | 0            | 5520              | AIX_tester3 | Limit     | Executed    |

    When I submit a quote request via the Quote Service where order has been executed for trader A
    Then I should get the quote which should contain an empty bid and an empty offer value with a status of "Open"
    When I submit a quote request via the Quote Service where order has been executed for trader B
    Then I should get the quote which should contain an empty bid and an empty offer value with a status of "Open"