@regression @clearingInstruments

Feature: Enable instruments for an institution
  As a admin user
  I can enable instruments for a specific institution
  So that institution users can see on user preferences list

  @severity=normal
  @enableInstruments
  Scenario: Enable instruments to see it on User Preferences list
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Clearing Partners Mapping' button
    Then Clearing Partners tab is displayed
    When I click on Instruments tab to enable instruments
    And I choose the base currencies to enable instruments
    And I choose the quote currencies to enable instruments
    Then I see the instrument in clearing partner per instrument list
    When I enable the security to be with SeedCX Clearing Partner
    And I click on Save instrument button
    Then I see the acknowledgement message for enabling instruments
    Given I go back to Institutions page
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Users' button
    Then I should be able to see users associated with that specific institution
    When I search for "uit1-ac-cp02@aixtrade.com" in Users
    Then I Click on 'Edit' users button
    And I see the enabled instrument in the User Preferences list


  @disableInstruments
  Scenario: Disable instruments to see it on User Preferences list
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Clearing Partners Mapping' button
    Then Clearing Partners tab is displayed
    When I click on Instruments tab to enable instruments
    Then I see the instrument in clearing partner per instrument list
    When I enable the security to be with SeedCX Clearing Partner
    And I click on Save instrument button
    Then I see the acknowledgement message for enabling instruments
    Given I go back to Institutions page
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Users' button
    Then I should be able to see users associated with that specific institution
    When I search for "uit1-ac-cp02@aixtrade.com" in Users
    Then I Click on 'Edit' users button
    And I should not see instrument in the User Preferences list
