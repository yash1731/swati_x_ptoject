#@regression
Feature: User can view telegram tooltip
  As a admin of an institution
  I want to view telegram tooltip
  so that I never get confused what to put in telegramId

  # This feature is redundant - @telegramId
  Scenario: View Telegram Tooltip
    Given I am on the users page
    When I click on telegram tooltip
    Then Verify the text "Please enter your Telegram User ID instead of the Username"
    And I click on Close tooltip button
    And I log out of the Application

