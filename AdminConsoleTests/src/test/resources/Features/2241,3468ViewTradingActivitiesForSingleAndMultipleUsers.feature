@regression
Feature: View the trading activities of single/multiple users associated to respective institutions
  As an admin user
  I want to view list of trading activities performed by institutions and users
  So I can track the users and their actions

  @severity=normal
  @userActivity
  Scenario: View the trading activity of Single/Multiple Users
    Given I am on the Trading activity page
    When I select the date and time to view the trading events
    When I select the institution to view trading activity shown below:
      |   Field           |    Value          |
      | Institution1 Name | institution1 name |
#      | User1 Name        | user1 name        |
#    Then I should able to see the selected user for search
#      |   Field           |    Value          |
#      | Institution1 Name | institution1 name |
#      | User1 Name        | user1 name        |
    When I click on serach button
#    Then I should able to see the list of events performed by the specific user
    Then Verify add more institution error message "Please select one or more users for the selected Institution."
# Search by Multiple Users
    When I select the second institution to view the trading activity shown below:
      |   Field           |    Value           |
      | Institution2 Name | institution2 name  |
#      | User2 Name        | user2 name         |
#    Then I should able to see the selected users for search
#      |   Field           |    Value           |
#      | Institution2 Name | institution2 name  |
#      | User2 Name        | user2 name         |
    When I click on serach button
    Then I should able to see the list of events performed by the multiple user