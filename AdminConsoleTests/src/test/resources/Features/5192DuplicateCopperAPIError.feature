@regression

Feature: Throw validation error when duplicate Copper API's provided to the institution
  As a admin user
  If duplicate copper api's provided to the institution
  So that admin should know the copper api provided is already in use

  @severity=minor
  @copperError
  Scenario: Verify Copper Error validation when duplicate copper api is provided
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Clearing Partners Mapping' button
    Then Clearing Partners tab is displayed
    When I enter the Copper api key and api secret to specified institution
    And I save the Copper api key and secret
    Then Verify the copper api validation message is displayed