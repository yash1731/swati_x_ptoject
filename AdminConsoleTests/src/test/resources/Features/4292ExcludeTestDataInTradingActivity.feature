#@regression
Feature: View the trading activities by including/excluding Test Data
  As an admin user
  I want to view list of trading activities by excluding Test Data
  So that I can see the activities done by Clients

  @severity=normal
  @testData
  Scenario: View the trading activity including/excluding Test Data
    Given I am on the Trading activity page
    #include test data
    When I select the date and time to view the trading events
    When I select the institution to view trading activity shown below:
      |   Field           |    Value          |
      | Institution1 Name | institution1 name |
      | User1 Name        | user1 name        |
    When I click on serach button
    Then Verify add more institution error message "Please select one or more users for the selected Institution."
    When I select the second institution to view the trading activity shown below:
      |   Field           |    Value           |
      | Institution2 Name | institution2 name  |
    When I click on serach button
    Then I should able to see the trading activity which includes Test Data
    #exclude test data
    When I exclude the Test Data
    When I click on serach button
    Then Verify the validation Message "Test data is excluded"
