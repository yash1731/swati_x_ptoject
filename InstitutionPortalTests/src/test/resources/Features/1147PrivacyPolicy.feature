@regression
Feature: Display Privacy Policy
  As a user
  I want to be able to view the Privacy Policy
  So that I can see all required company details

  @privacy
  Scenario: View Privacy Policy
    Given I have selected to view Privacy Policy page
    Then I should be able to see the "Privacy Policy" page
    And I log out of the Application