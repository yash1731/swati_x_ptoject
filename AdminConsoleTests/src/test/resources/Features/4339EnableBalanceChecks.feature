@regression
Feature: Enable/Disable Balance checks of an Institution
  As an admin user
  I want to enable balance checks of an institution
  So that as a admin not to perform balance check again for an Institution

  @severity=trivial
  @balance
  Scenario: Enable balance check of an Institution
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions for balance check
    And I click on the 'Institution Info' button
    # Disable Balance Check
    When I disable the balance check
    And I click on 'Update' institution button
    Then I can see Institution updated success message
    # Enable Balance Check
    When I enable the balance Check
    And I click on 'Update' institution button
    Then I can see Institution updated success message
    # Verify balance check signal is enabled in the institutions list
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions for balance check
    Then Balance check signal is enabled in the institutions list
