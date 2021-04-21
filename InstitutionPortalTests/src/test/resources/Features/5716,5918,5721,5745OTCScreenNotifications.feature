#5889 - Price taker quote responses should be submitted as FOK
#5717 - Price Taker is presented with quote updates
#5719 - Price Taker responds to a quote (buy/sell) and gets notified of the outcome (trade/cancellation)
#5914 - No message/notification appeared in OTC Screen when platform is suspended
#5915 - Wrong message was displayed in OTC screen when self matching order is found in orderbook to prevent self trade
#6506 - Institution Portal - [OTC Screen] Indicative toggle cannot enable/disable when price request is active.
#6362 - Institution Portal - 'Indicative quotes' selection on OTC screen


  @regression @otc

  Feature: Get the notifications on OTC Screen when Quote request is submitted, cancelled etc

    As an OTC User
    I want to get notification when quote request is submitted or cancelled
    So that I get acknowledgement from the system to step further

    @ackOTC
    Scenario: Receive notification when quote request is submitted and cancelled
    Given I am on the OTC Screen
    When I select the 'Symbol' for Base currency on OTC Screen
    And I select the 'Symbol' for Quote currency on OTC Screen
    And I add 'Quantity' in OTC Screen to request for price
    And I click on 'Request Quote' button
    Then I should receive notification "Quote Request submitted"
    And I can view buy and sell buttons are displayed with awaiting price
    When I cancel the Quote Request by clicking 'Cancel Request' button
    Then I should receive notification "Quote Request cancelled"
    And I log out of the Application

    @lessFunds
    Scenario: Receive notification when insufficient funds
      Given I am on the OTC Screen to check funds
      When I select the 'Symbol' for Base currency on OTC Screen for insufficient fund
      And I select the 'Symbol' for Quote currency on OTC Screen
      And I add 'Quantity' in OTC Screen to request for price
      And I click on 'Request Quote' button
      Then I should receive error notification "You do not have sufficient funds to trade this amount - please fund your account and retry"
      And I log out of the Application


