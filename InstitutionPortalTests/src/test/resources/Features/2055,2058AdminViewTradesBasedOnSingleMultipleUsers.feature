@regression
Feature: Filter trade based on single and multiple user a in Trade Blotter
  As a admin of an institution
  I want to filter trade by users
  so that I can narrow down search for specific user

  @tradesUsers
  Scenario: View Trade based on selected traders
    Given I am on Trade Blotter Page
# Single Users
    When I select the user in trade blotter
    Then I click on search button in trade blotter
    When I can see the list of trades filtered by user
    #Then I can validate the trader in the trade list
    And I log out of the Application
