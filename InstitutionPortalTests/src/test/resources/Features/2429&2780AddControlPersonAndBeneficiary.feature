@regression
Feature: Add Control Person and Beneficiary to Authorised Signer from an application
  As a user
  I want to add role to an authorised signer from an application
  So I can have Authorised signer who is a control person or/and beneficiary of an application

  @control
  Scenario: Add role to  Authorised Signer from an application
    Given I am on the Authorised Signer page for selected application
    When I select to edit an Authorised Signer
# Enable Control Person and Beneficial Owner
    And I enable the Authorised signer as a control person and beneficial owner
    Then I should able to see "updatedSigner message"
# Remove Control Person and Beneficial Owner
    When I select to edit an Authorised Signer
    And I disable the Authorised signer as a control person  and beneficial owner
    Then I should able to see "updatedSigner message"
    And I log out of the Application
