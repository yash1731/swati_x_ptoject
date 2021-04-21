@regression
Feature: View List of Users within an institution
  As an admin user
  I want to view list of users within an institution
  So I confirm users associated within an institution

  @severity=trivial
  @users
  Scenario: View List of Users within an institution
    Given I am on the Institutions page
    When I select a specific institution
#    Then I should be able to see all institutions
#    When I search for "Tester15" in Institutions to enable Channels
    And I click on the 'View Users' button
    Then I should be able to see users associated with that specific institution