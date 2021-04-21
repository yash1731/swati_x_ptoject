@regression
Feature: View phone number of a user of  an Institution
  As an admin user
  I want to view the phone number of the user of an institution
  So that when necessary I can call them up

  @severity=trivial
  @userPhoneNo
  Scenario: View Phone number of a user of associated Institution
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT2" in Institutions
    And I click on the 'Users' button
    Then I should be able to see users associated with that specific institution
    When I search for "uit2-ac-user01@aixtrade.com" in Users
    And Verify the phone number of a user is present
    When I search for "uit2-ac-user01@aixtrade.com" in Users
    Then I Click on 'Edit' users button
    When I update the phone Number of the user
    Then Verify user validation Message "User updated."
