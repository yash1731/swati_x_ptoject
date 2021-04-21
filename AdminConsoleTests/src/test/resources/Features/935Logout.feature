@regression

@severity=normal

@issue=2

@tmsLink=13
Feature: Test that user can logout of the system
  As a user
  I want to successfully logout of the system

  @logout
  Scenario: Logout of the Admin Console
    Given I am on the home page
    When I click the sign out button
    Then I should be able to successfully sign out and navigated to the login page