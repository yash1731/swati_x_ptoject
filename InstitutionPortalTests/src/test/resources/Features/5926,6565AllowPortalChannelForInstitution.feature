@regression
Feature: Allow two valid combination of channels for a user of  an Institution
  As an admin user of an institution
  I want to allow a user to select telegram and portal channels
  So that user get the valid combination of channels

    @validChannels
  Scenario: Allow telegram and portal as a valid combination of channels for a user
    Given I am on the users page
    Then I should be able to see a list of all the users
    #Allow two channels combination
    When I edit user and mark user as a Trader to allow user for two channels
    Then I should be able to see user added as a Trader with an "updateSuccess message"
    #tooltip for Valid Combination of Channels
    When I click on the valid combination of channel tooltip
    Then Verify the combined channels header and text
    And I click the close button of channels tooltip modal
    #Not valid combination of channel
    When I enable Symphony as a channel for user
    Then Verify 'Telegram' and 'Portal' channels get disabled
    #Set user to default
    When I enable Symphony as a channel for user
    And I click on 'Update User' button
    #Then Verify user validation Message "User updated."
    Then I should be able to see user added as a Trader with an "updateSuccess message"

  @noOTC
  Scenario: Validation thrown when Market Maker selects 'Portal' as a channel
    Given I am on the users page
    Then I should be able to see a list of all the users
    #Do not allow portal channel to MM
    When I edit user and mark user as a Market Maker to not allow Portal channel
    Then Verify Market Maker get validation Message "Only Traders may use the OTC screen."
