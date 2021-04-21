#SEEDCX FUNCTIONALITY IS REDUNDANT ON INSTITUTION PORTAL WHILE APPLYING TO BECOME INSTITUTION IN AIX
#
#
# @regression
#Feature: Enable and Disable SeedCX Participant ID
#  As a user
#  I want to ensure that I can enable and add SeedCX id or disable seedCX field
#  So I can add or remove existing seedCX participant
#
#  @seedCXId
#  Scenario: Enable or Disable Existing SeedCX Participant ID
#    Given I am on the Applications page
#    When I disable the SeedCX Participant ID field
#    And I select to proceed to the next page
#    Then I should see "seedCXIdError message" displayed
#    When I then enter a "seedCX participantID"
#    And I select to proceed to the next page
#    Then I can successfully proceed to the "Authorised Signers" page
#    When I go back to the Applications page and I enable the SeedCX Participant ID field
#    And I select to proceed to the next page
#    Then I can successfully proceed to the "Authorised Signers" page
#    And I log out of the Application
