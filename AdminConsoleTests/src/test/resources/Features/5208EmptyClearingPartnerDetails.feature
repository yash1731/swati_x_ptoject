@regression @emptyClearingPartners

Feature: Empty Clearing Partner details for an institution
  As a admin user
  I haven't provided clearing partners details for a specific institution
  So that institution users cannot see the instruments tab

  @severity=normal
  @emptyPartners
  Scenario: Verify instruments tab is not displayed when empty clearing partners details are provided
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Clearing Partners Mapping' button
    Then Clearing Partners tab is displayed
    When I clear SeedCX Participant id
    And I save the Copper api key and secret
    Then I see the validation message where clearing partner is associated for an instrument is still enabled
    #And I verify instruments tab is not displayed

  @emptyPartnersWithIns
  Scenario: Verify error is thrown when empty clearing partners is provided for an institution which has associated clearing partner details
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Clearing Partners Mapping' button
    Then Clearing Partners tab is displayed
    When I enter SeedCX Participant id details
    And I save the Copper api key and secret
    Then I see the acknowledgement message for duplicate clearing Partners
    When I click on Instruments tab to enable instruments
    And I choose the base currencies to enable instruments
    And I choose the quote currencies to enable instruments
    Then I see the instrument in clearing partner per instrument list
    When I enable the security to be with SeedCX Clearing Partner
    And I click on Save instrument button
    Then I see the acknowledgement message for enabling instruments
    When I click on Clearing Partners tab to clear seedcx id
    When I clear SeedCX Participant id
    And I save the Copper api key and secret
    Then I see the validation message where clearing partner is associated for an instrument is still enabled
    When I enter SeedCX Participant id details
    And I save the Copper api key and secret
    When I click on Instruments tab to enable instruments
    Then I see the instrument in clearing partner per instrument list
    When I disable the security to be with SeedCX Clearing Partner
    And I click on Save instrument button
    Then I see the acknowledgement message for enabling instruments