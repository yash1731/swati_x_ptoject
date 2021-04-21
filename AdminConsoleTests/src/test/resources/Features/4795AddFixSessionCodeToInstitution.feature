@regression

Feature: Add Fix Session Code for an institution
  As a admin user
  I am able to add fix session for a specific institution
  So that as an admin I can view fix session of an Institution with which they are connected

  @severity=trivial
  @fix_session
  Scenario: Add Fix session on Institution level
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Institution Info' button
    When I click on clear Institution info
    And I enter the fix session code on Institution level
    And I click on 'Update' institution button
    Given I go back to Institutions page
    When I search for "UIT1" in Institutions to enable Channels
    Then I can view Fix session code is added against institution in the list