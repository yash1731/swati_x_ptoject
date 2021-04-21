@regression
Feature: Filter trade based on Institution and user associated to institution in Trade Blotter
  As a admin user
  I want to filter trade by institutions and users
  so that I can narrow down search for specific institutions and users

  @severity=normal
  @tradesUsers
  Scenario: View Trade based on selected securities
    Given I am on Trade Blotter Page
# Single Institution and user associated to it
    When I select the Institution in trade blotter
    Then I select the user associated to the selected institution
    When I click on search button in trade blotter
    Then I can see the list of trades filtered by institution and user
    And I can validate the institution and trader in the trade list
# Multiple Institution and user associated to it
    When I select the multiple Institution in trade blotter
    Then I select the user associated to the selected multiple institution
    When I click on search button in trade blotter
    Then I can see the list of trades filtered by multiple institutions and users
    And I can validate multiple institutions and traders in the trade list