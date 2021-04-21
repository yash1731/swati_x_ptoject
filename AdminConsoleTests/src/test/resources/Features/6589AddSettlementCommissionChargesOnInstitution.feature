@regression

Feature: Add Settlement and Commission charges for an institution
  As a admin user
  I am able to add settlement and commission charges for a specific institution
  So that when trade happens it takes off the commission according to percentage set

  @severity=normal
  @charges
  Scenario: Add settlement and commission charges on Institution level
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Institution Info' button
    #AddSettlement and commission charges
    When I add settlement and commission charge for an institution
    And I click on 'Update' institution button
    Then I can see Institution updated success message