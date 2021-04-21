@regression
Feature: User cannot add duplicate telegram and fix id
  As a admin of an institution
  I want to add unique telegram and fix id to users
  so that I never get duplication error

  @duplicateId
  Scenario: Verify error when duplicate Telegram and FIX Id is set
    Given I am on the users page
    When I add duplicate telegram and fix id to selected user
    Then Verify the duplication validation message text
    And I log out of the Application