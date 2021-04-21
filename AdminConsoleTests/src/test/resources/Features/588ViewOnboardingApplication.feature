@regression
Feature: View Onboarding Applications
  As an admin user
  I want to view all applications
  So I review application status

  @severity=minor
  @viewApps
  Scenario: View all Client Applications
    Given I am on the Applications page
    Then I should be able to see all applications and their status
    When I select to view a specific user's application
    Then I should be able to see client's individual application