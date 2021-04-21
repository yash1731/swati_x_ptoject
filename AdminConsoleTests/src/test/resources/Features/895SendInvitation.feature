@regression
Feature: Send an Invite
  As an admin user
  I want to be able to send an invite to a client
  So that the client can complete application process

  @severity=normal
  @send
  Scenario: Send an Invitation to a client
    Given I am on the Invitations page
    When I click on the 'Resend' Invite button for any of the invitations on the list
    Then I should be able to receive a "successful message" for invite sent to the client