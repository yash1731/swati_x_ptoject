@regression
Feature: Broadcast Message to an Institution
  As an admin user
  I want to broadcast message to an Institution
  so that the institution gets the latest announcements

  @severity=blocker
  @castInstitution @broadcast
  Scenario: Find an Institutions to broadcast message
    Given I am on the Broadcast Messages page
    # Single Institution
    When I select a institution to Broadcast Message
    And I enter the announcements to broadcast
    And I send the broadcast message
    Then I can verify the broadcasted message in the list
    When I open the Broadcasted Info Details
    Then I can verify an institution
    # Multiple Institution
    When I select multiple institutions to Broadcast Message
    And I enter the announcements to broadcast to multiple Institutions
    And I send the broadcast message
    Then I can verify the broadcasted message to multiple Institutions in the list
    When I open the Broadcasted Info Details for multiple institution
    Then I can verify multiple institutions