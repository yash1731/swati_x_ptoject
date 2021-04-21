@regression @details   @severity=critical
Feature: View the trading activities details of all events
  As an admin user
  I want to view the details of trading activities of the specific events
  So I can view the deep details of trading activities performed by the institutions


  Background:
    Given I am on the Trading activity page

  @utter
  Scenario: View the trading activity of Utterence Events
    When I select from date and time for Utterence
    And I click on serach button
    And I can view the direction and utterance description in the list
#    When I click on 'View Details' button
#    Then I should able to see the Activity Details opened with same description
#    And I close the detailed view of trading activity

    @order
  Scenario: View the trading activity of Order Events
    When I select the date and time for Order Events
    When I select order events from events dropdown
    And I click on serach button
    Then I should able to see 'Orders' Trading activity
#    When I click on 'View Details' button
#    Then I should able to see the activity details
#    And I close the detailed view of trading activity

    @quote
  Scenario: View the trading activity of Quote Events
    When I select Quote events from events dropdown
    And I click on serach button
    Then I should able to see 'Quote' Trading activity
#    When I click on 'View Details' button
#    Then I should able to see the activity details
#    And I close the detailed view of trading activity

    @quoteReq
  Scenario: View the trading activity of Quote Request Events
    When I select Quote Request events from events dropdown
    And I click on serach button
    Then I should able to see 'Quote Request' Trading activity
#    When I click on 'View Details' button
#    Then I should able to see the activity details
#    And I close the detailed view of trading activity

  @quoteResp
  Scenario: View the trading activity of Quote Response Events
    When I select Quote Response events from events dropdown
    And I click on serach button
    Then I should able to see 'Quote Response' Trading activity
#    When I click on 'View Details' button
#    Then I should able to see the activity details
#    And I close the detailed view of trading activity

    @tradeEvents
  Scenario: View the trading activity of Trade Events
    When I select Trade events from events dropdown
    And I click on serach button
    Then I should able to see 'Trade' Trading activity
#    When I click on 'View Details' button
#    Then I should able to see the activity details
#    And I close the detailed view of trading activity

     @settlement
  Scenario: View the trading activity of Settlement Events
    When I select the date and time for Settlement Events
    When I select Settlement events from events dropdown
    And I click on serach button
    Then I should able to see 'Settlement' Trading activity
#    When I click on 'View Details' button
#    Then I should able to see the activity details
#    And I close the detailed view of trading activity

    # @warning (Raised a bug for Warning Service)
 # Scenario: View the trading activity of Order Events
#    When I select Warning events from events dropdown
#    And I click on serach button
#    Then I should able to see 'Warning' Trading activity
#    When I click on 'View Details' button
#    Then I should able to see the activity details
#    And I close the detailed view of trading activity

    @tradeConf
  Scenario: View the trading activity of Trade Confirmation Events
    When I select Trade Confirmation events from events dropdown
    And I click on serach button
    Then I should able to see 'Trade Confirmation' Trading activity
#    When I click on 'View Details' button
#    Then I should able to see the activity details
#    And I close the detailed view of trading activity

  @FIXOrders
  Scenario: View the trading activity of FIX Order Events
    When I select the date and time for FIX Order Events
    When I select FIX Order events from events dropdown
    And I click on serach button
    Then I should able to see 'FIX Order' Trading activity
#    When I click on 'View Details' button
#    Then I should able to see the activity details
#    And I close the detailed view of trading activity

    @REST_Taker
  Scenario: View the trading activity of REST Price Taker Events
    When I select the date and time for REST Price Taker Events
    When I select REST Price Taker events from events dropdown
    And I click on serach button
    Then I should able to see 'REST Price Taker' Trading activity
#    When I click on 'View Details' button
#    And I close the detailed view of trading activity

  @FIX_Maker
  Scenario: View the trading activity of FIX Price Maker Events
    When I select the date and time for FIX Price Maker Events
    When I select FIX Price Maker events from events dropdown
    And I click on serach button
    Then I should able to see 'FIX Price Maker' Trading activity
#    When I click on 'View Details' button
#    And I close the detailed view of trading activity

  @REST_Maker
  Scenario: View the trading activity of REST Price Maker Events
    When I select the date and time for REST Price Maker Events
    When I select REST Price Maker events from events dropdown
    And I click on serach button
    Then I should able to see 'REST Price Maker' Trading activity
#    When I click on 'View Details' button
#    And I close the detailed view of trading activity

  @CB
  Scenario: View the trading activity of CryptoBroker Bridge Events
    When I select the date and time for CryptoBroker Bridge Events
    When I select CryptoBroker Bridge events from events dropdown
    And I click on serach button
    Then I should able to see 'CryptoBroker Bridge' Trading activity
#    When I click on 'View Details' button
#    And I close the detailed view of trading activity

  @FTX
  Scenario: View the trading activity of FTX Bridge Events
    When I select the date and time for FTX Bridge Events
    When I select FTX Bridge events from events dropdown
    And I click on serach button
    Then I should able to see 'FTX Bridge' Trading activity
#    When I click on 'View Details' button
#    And I close the detailed view of trading activity




