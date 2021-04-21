@regression
Feature: View Onboarded Institutions
  As an admin user
  I want to view all onboarded institutions
  So I can view all institution users

  @severity=trivial
  @institutions
  Scenario: View all Institutions
    Given I am on the Institutions page
    Then I should be able to see all institutions