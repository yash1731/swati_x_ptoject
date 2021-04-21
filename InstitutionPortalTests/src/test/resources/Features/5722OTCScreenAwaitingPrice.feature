@regression @otc
Feature: Get the buy and sell button enabled and wait for price to be displayed

  As an OTC User
  I want to sumbit the RFQ
  So that I get prices back on buy and sell side till then awaiting for price

  @awtPrice
  Scenario: Awaiting for price on both buy and sell side when done the price request
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