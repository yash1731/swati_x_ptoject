@regression
Feature: OTC screen should not be available for Market Makers
  As an admin user
  I do not want to allow a user who is Market Maker to select portal as a channel
  So that Market Maker get the validation error when selecting portal channel

  @severity=minor
  @noOTC
  Scenario: Validation thrown when Market Maker selects 'Portal' as a channel
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions
    And I click on the 'Users' button
    Then I should be able to see users associated with that specific institution
    When I search for "uit1-ac-otc01@aixtrade.com" in Users
    Then I Click on 'Edit' users button
    When I enable user as market maker
    And I enable Portal as a channel for Market Maker
    Then Verify Market Maker get validation Message "Only Traders may use the OTC screen."
