@regression
Feature: Test that user can logout of the system
  As a user
  I want to successfully logout of the system

  @logout
  Scenario: Confirm that user can logout of the system
    Given I am on the home page
    When I click the sign out button
    Then I should be able to successfully sign out and navigated to the login page