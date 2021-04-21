@regression
Feature: Add, Update and Delete a user pref of a user of  an Institution
  As an admin user
  I want to add,update and delete a user of an institution
  So that I can edit user from Admin Console

  @severity=normal
  @editUserPref
  Scenario: Edit a user preferences of a user of associated Institution
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT2" in Institutions
    And I click on the 'Users' button
    Then I should be able to see users associated with that specific institution
    When I search for "uit2-ac-upref02@aixtrade.com" in Users
    Then I Click on 'Edit' users button
    When I enable user as market maker
    #And I click on 'Update User' button
    #Then Verify user validation Message "User updated."
    # Set user Preference Channel
#    When I search for "tester20@aixtrade.com" in Users
#    Then I Click on 'Edit' users button
    When I set the preferred channel of the user
    And I click on 'Update User' button
    Then Verify user validation Message "User updated."
   # Then Verify user validation Message "User Preference saved."
    # Set user preference
    When I set the security for the user
    Then Verify user validation Message "User Preference saved."
   # And I see the quote expiry, min and max volume field is displayed
    #Disable User Preference
    When I disable the security for the user
    Then Verify user validation Message "User Preferences removed."
   # And I see the quote expiry, min and max volume field is not displayed
    #Disable user as Market Maker
    When I set the preferred channel of the user to default
    When I enable user as market maker
    And I click on 'Update User' button
    Then Verify user validation Message "User updated."

