@regression
Feature: Filter trade based on Side in Trade Blotter
  As a admin user
  I want to filter trade by side
  so that I can seperate buyers and sellers in the trade list

  @severity=minor
  @side
  Scenario: View Trade based on side
    Given I am on Trade Blotter Page
    When I select the time range to view trade in trade blotter
# Sell Side
    And I select the sell side in trade blotter
    And I click on search button in trade blotter
    Then I can validate the sell side in the trade list
# Buy Side
    And I select the buy side in trade blotter
    And I click on search button in trade blotter
    Then I can validate the buy side in the trade list
