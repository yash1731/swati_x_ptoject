@regression
Feature: View list of User Preferences of a User of respective Institutions
  As an admin user
  I want to view the list of user preferences of a user
  So I can see the preferred channel and preferences of a user of an Institution

  @severity=minor
  @userPref
  Scenario: View list of User Preferences of a user
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT2" in Institutions
    And I click on the 'Users' button
    Then I should be able to see users associated with that specific institution
    When I search for "uit2-ac-upref01@aixtrade.com" in Users
    When I click on user preferences info button
    Then I should able to see the user preferences of the specific user