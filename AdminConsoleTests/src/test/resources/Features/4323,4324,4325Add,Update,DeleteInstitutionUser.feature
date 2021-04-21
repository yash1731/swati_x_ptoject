@regression
Feature: Add, Update and Delete a user of  an Institution
  As an admin user
  I want to add,update and delete a user of an institution
  So that I can edit user from Admin Console

  @severity=normal
  @editInstitutionUser
  Scenario: Edit a user of associated Institution
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT2" in Institutions
    And I click on the 'Users' button
    Then I should be able to see users associated with that specific institution
    When I search for "uit2-ac-user02@aixtrade.com" in Users
    Then I Click on 'Edit' users button
    #User as admin
    When I enable user as admin
    And I click on 'Update User' button
    Then Verify user validation Message "User updated."
#    When I search for "tester20@aixtrade.com" in Users
#    Then I Click on 'Edit' users button
    When I disable user as admin
    And I click on 'Update User' button
    Then Verify user validation Message "User updated."
    #User as trader
#    When I search for "tester20@aixtrade.com" in Users
#    Then I Click on 'Edit' users button
    When I enable user as trader
    When I set the preferred channel of the user
    And I click on 'Update User' button
    Then Verify user validation Message "User updated."
#    When I search for "tester20@aixtrade.com" in Users
#    Then I Click on 'Edit' users button
    When I disable user as trader
    And I click on 'Update User' button
    Then Verify user validation Message "User updated."
    #User as Market Maker
#    When I search for "tester20@aixtrade.com" in Users
#    Then I Click on 'Edit' users button
    When I enable user as market maker
    And I click on 'Update User' button
    Then Verify user validation Message "User updated."
#    When I search for "tester20@aixtrade.com" in Users
#    Then I Click on 'Edit' users button
    When I disable user as market maker
    When I set the preferred channel of the user to default
    And I click on 'Update User' button
    Then Verify user validation Message "User updated."

