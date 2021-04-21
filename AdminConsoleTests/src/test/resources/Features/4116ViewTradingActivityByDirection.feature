@regression
Feature: View the trading activities based on selection of direction
  As an admin user
  I want to search trading activities by selected direction
  So I can view the trading activities performed by the institutions for inbound and outbound direction

  @severity=minor
  @direction
  Scenario: View the trading activity based on selected direction
    Given I am on the Trading activity page
    #When I select from date and time for Utterence
    #Inbound
    Then I select the inbound direction of the events
    When I click on serach button
    Then I should able to see the list of events performed by the institutions for selected inbound direction
    #Outbound
    Then I select the outbound direction of the events
    When I click on serach button
    Then I should able to see the list of events performed by the institutions for selected outbound direction