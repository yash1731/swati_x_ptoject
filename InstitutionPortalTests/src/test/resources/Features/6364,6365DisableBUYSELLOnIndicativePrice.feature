
  #@otcInd
  #TO DO
  #6365, 6364 - Institution Portal - Internal users allowed the use the OTC screen to only be able to request indicative quotes

Feature: Internal users allowed the use the OTC screen to only be able to request indicative quotes
  As an AiX Internal User
  I want to submit quote request with indicatives toggle on
  So that I view the electronics pricing

  @createTwoWayOrder
  Scenario: Create two way order
    Given I have received the spot price for a "specific symbol" from the Market Data Service
#    Create a Two Way Order
    When I create a Single BUY and SELL order via the createTwoWayOrder endpoint as Trader A
    Then I should be able to successfully create the two way order with a status of "PendingOpen" for both the BUY and the SELL side


  @indQuote
  Scenario: Internal user submitting price request with indicative price
    Given I am on the OTC Screen
    When I select the 'Symbol' for Base currency on OTC Screen
    And I select the 'Symbol' for Quote currency on OTC Screen
    And I add 'Quantity' in OTC Screen to request for price
    And And I enable 'Indicative Quotes' button
    And I click on 'Request Quote' button
    Then I should verify buy and sell buttons are disabled but have prices on it
    And I should receive notification "You cannot trade against indicative prices. Cancel your request and raise one without indicative pricing"