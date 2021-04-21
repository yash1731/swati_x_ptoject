@regression
Feature: Allow two valid combination of channels for a user of  an Institution
  As an admin user
  I want to allow a user to select telegram and portal channels
  So that user get the valid combination of channels

  @severity=normal
  @validChannels
  Scenario: Allow telegram and portal as a valid combination of channels for a user
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT2" in Institutions
    And I click on the 'Users' button
    Then I should be able to see users associated with that specific institution
    When I search for "uit2-ac-user03@aixtrade.com" in Users
    Then I Click on 'Edit' users button
    #tooltip for Valid Combination of Channels
    When I click on the valid combination of channel tooltip
    Then Verify the combined channels header and text
    And I click the close button of channels tooltip modal
    #Allow two channels combination
    When I enable telegram and OTC channels for a user
    And I click on 'Update User' button
    Then Verify user validation Message "User updated."
    #Not valid combination of channel
    When I enable Symphony as a channel for user
    Then Verify 'Telegram' and 'Portal' channels get disabled
    #Set user to default
    When I enable Symphony as a channel for user
    And I click on 'Update User' button
    Then Verify user validation Message "User updated."