@regression
Feature: View the trading activities based on selection of date and time
  As an admin user
  I want to view list of trading activities from selected date and time range
  So I can view the trading activities performed by the institutions

  @severity=normal
  @date
  Scenario: View the trading activity based on date and time range
    Given I am on the Trading activity page
    When I click on calender to select from date
    Then I should able to see the current date
    And I should able to see the time defaulted for last hour
    When I click on previous month calender
    Then I select the first day of the month
    And I select the time in hour, minutes and seconds
    When I click on calender to select to date
    Then I should able to see the current date
    And I should able to see the current time
    Then I click on previous month calender
    And I select the last day of the month
    And I select the time in hour, minutes and seconds for till date
    When I select order events from events dropdown
    When I click on serach button
    Then I should able to see the list of events performed by the institutions
