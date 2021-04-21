@regression
Feature: Preview an Invite
  As an admin user
  I want to be able to preview both sent invitations and ready to be sent invites
  So that I can view client's invite

  @severity=normal
  @preview
  Scenario: Preview Invitations to clients
    Given I am on the Invitations page
    When I fill client's details on the 'Invite Institution' section as below:
      | Field            | Value            |
      | Institution Name | institution name |
      | First Name       | first name       |
      | Last Name        | last name        |
      | Email Address    | email address    |
    And I click on the 'Preview' button
    Then I should be able to preview invite to be sent with the below keywords:
      | Field          | Value          |
      | Invite Content | invite content |
      | Login Details  | login details  |
      | User Name      | user name      |
    When I preview any of the existing invitations
    Then I should be able to preview sent invite with the below keywords:
      | Field          | Value          |
      | Invite Content | invite content |
      | Login Details  | login details  |