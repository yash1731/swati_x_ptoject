@regression
Feature: View Invitations and filter invitation entries
  As an admin user
  I want to be able to view and filter invitations
  So that I can arrange invitations based on my preferred choice

  @severity=trivial
  @sort
  Scenario: View and Sort Invitations
    Given I am on the Invitations page
    Then I can view all invitations
    And I can sort entries based on preferred choice
