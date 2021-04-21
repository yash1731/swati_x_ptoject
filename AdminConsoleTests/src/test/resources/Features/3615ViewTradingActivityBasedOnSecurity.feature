@regression
Feature: View the trading activities based on selection of securities
  As an admin user
  I want to search trading activities by selected securities
  So I can view the trading activities performed by the institutions for selected securities

  @severity=normal
  @security
  Scenario: View the trading activity based on selected security
    Given I am on the Trading activity page
    And I select the date and time to search security
    When I select the 'Quote Request' Event from Event selector
    Then I select the security from the Instrument list
    When I click on serach button
    Then I should able to see the list of events performed by the institutions for selected securities