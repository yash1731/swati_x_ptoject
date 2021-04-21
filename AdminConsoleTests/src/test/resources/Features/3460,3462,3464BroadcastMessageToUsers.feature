@regression
Feature: Broadcast Message to Users
  As an admin user
  I want to broadcast message to users
  so that the users gets the latest announcements

  @severity=blocker
  @castUser @broadcast
  Scenario: Find a Users to broadcast message
    Given I am on the Broadcast Messages page
    # Single User
    When I select a institution to Broadcast Message
    Then I select a user associated to selected institution
    And I enter the announcements to broadcast to a user
    And I send the broadcast message
    Then I can verify the broadcasted message to a user in the list
    When I open the Broadcasted Info Details sent to user
    Then I can verify a selected user of an Institution
    # Multiple Users of specific Institution
    When I select a institution to Broadcast Message to multiple users
    When I select multiple users of an institution to Broadcast Message
    And I enter the announcements to broadcast to multiple Users
    And I send the broadcast message
    Then I can verify the broadcasted message to multiple Users of an Institution in the list
    When I open the Broadcasted Info Details sent to multiple user
    Then I can verify multiple users associated to an institution