@regression
Feature: Admin can able to clear ans save search in Trading Activity
  As an admin user
  I want to save the searched Trading Activity
  So that the admin user can find the saved search when revisiting to trading activity

  @severity=minor
  @saveClear
  Scenario: Save and clear search of Trading Activity
    Given I am on the Trading activity page
    When I select the multiple institutions to view trading activities shown below:
      |   Field           |    Value          |
      | Institution1 Name | institution1 name |
      | Institution2 Name | institution2 name |
    And I click on 'Save' Search button in Trading Activity
    Then I can see the message "Search filters saved"
    When I click on 'Clear' filter button
    Then I can see the message "Search filters cleared"