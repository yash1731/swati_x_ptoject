@regression
Feature: Filter trade based on Instrument in Trade Blotter
  As a admin user
  I want to filter trade by instrument
  so that I can narrow down search for specific instrument

  @severity=critical
  @tradesInstrument
  Scenario: View Trade based on selected securities
    Given I am on Trade Blotter Page
    When I select the time range to view trade in trade blotter
# Single Instrument LTCUSD
    And I select the Instrument in trade blotter
    And I click on search button in trade blotter
    Then I can see the list of trades filtered by instrument
    And I can validate the instrument in the trade list
# Multiple Instrument LTCUSD and FKFUSD
    And I select multiple Instrument in trade blotter
    And I click on search button in trade blotter
    Then I can see the list of trades filtered by multiple instruments
    And I can validate the multiple instruments in the trade list