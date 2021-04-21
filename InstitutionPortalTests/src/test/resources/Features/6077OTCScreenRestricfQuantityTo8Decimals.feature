# 6077 - Institution Portal - Restrict quantity on OTC screen to 8 decimals

@regression @otc

Feature: Restrict quantity on OTC screen to 8 decimals

  As an OTC User
  I want to submit quote request with quantity in decimal places if exceeds 8 decimals
  So that I get error to not use more than 8 decimals

  @volRestrict
  Scenario: Error thrown when using more than 8 decimal places in quantity when submitting price request
    Given I am on the OTC Screen
    When I select the 'Symbol' for Base currency on OTC Screen
    And I select the 'Symbol' for Quote currency on OTC Screen
    And I add 'Quantity' more than 8 decimal places in OTC Screen to request for price
    And I click on 'Request Quote' button
    Then I should receive error notification on OTC Screen "Quantity precision cannot be more than 8"