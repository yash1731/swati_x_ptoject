@regression
Feature: List Users
  As a user
  I want to be able to see a list of users
  So that I can see all users of the system

  @users
  Scenario: List all Users on Institution Portal
    Given I am on the users page
    Then I should be able to see a list of all the users
    And I can be able to filter users entries
    And I log out of the Application