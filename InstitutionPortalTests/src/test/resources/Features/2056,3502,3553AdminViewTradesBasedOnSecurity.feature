#@regression
Feature: Filter trade based on security and side in Trade Blotter
  As a admin of an institution
  I want to filter trade by security and side
  so that I can narrow down search for specific security

  @side
  Scenario: View Trade based on selected security and side
    Given I am on Trade Blotter Page
# Security
    When I select the security in trade blotter
    Then I click on search button in trade blotter
    When I can see the list of trades filtered by user
    #Then I can validate the security in the trade list
# Side - Buy
    When I select the buy side
    Then I click on search button in trade blotter
    When I can see the list of trades filtered by user
    #Then I can validate buy side in the trade list
    # Side - Sell
    When I select the sell side
    Then I click on search button in trade blotter
    When I can see the list of trades filtered by user
   # Then I can validate sell side in the trade list
    And I log out of the Application