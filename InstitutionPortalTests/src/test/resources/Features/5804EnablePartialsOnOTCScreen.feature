#5804 - Price Taker switch to enable or disable partials
@regression @otc

Feature: Price Taker switch to enable or disable partials on OTC Screen

  As an OTC User
  I want to enable or disable partials
  So that I get more chances to create trade

  @showPartials
  Scenario: Enable or disable partials on OTC Screen
    Given I am on the OTC Screen
    Then Verify 'Show Partial' button is disabled
    #Enable Show Partials
    When I select the 'Symbol' for Base currency on OTC Screen
    And I select the 'Symbol' for Quote currency on OTC Screen
    And I add 'Quantity' in OTC Screen to request for price
    And I enable 'Show Partials' button
    And I click on 'Request Quote' button
    Then Verify 'Show Partials' button is disabled
    #Disable Show Partials
    When I cancel the Quote Request by clicking 'Cancel Request' button
    Then I can disable 'Show Partials' button
    And I log out of the Application