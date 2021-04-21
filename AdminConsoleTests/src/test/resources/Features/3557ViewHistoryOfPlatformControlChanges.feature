@regression
Feature: View the historical list of platform control changes
  As a admin User
  I want to view the historical list of platform control changes
  So that I can see the restrictions applied to Platform, Instruments, Institutions and Users

  @severity=trivial
  @history
  Scenario: View the history of platform control changes
    Given I am on Platform Control page
    And I click on history tab in platform control
    Then I validate the list of restrictions performed in platform control