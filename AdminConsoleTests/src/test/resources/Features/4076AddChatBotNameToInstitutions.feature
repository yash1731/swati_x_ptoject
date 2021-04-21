#ChatBot details function is removed from the Institution info
#
# @regression
#Feature: Add ChatBot name to an Institution
#  As an admin user
#  I want to assign ChatBot name and token to an institution
#  So that users of associated institution can use ChatBot for trade
#
#  @chatBot
#  Scenario: Add ChatBot name and ChatBot Token to an Institution
#    Given I am on the Institutions page
#    Then I should be able to see all institutions
#    When I search for "Swati Automation User" in Institutions
#    And I click on the 'Institution Info' button
#    Then I clear the ChatBot details of an institution
#    When I add the ChatBot name and token to an Institution
#    And I click on 'Update' institution button
#    Then I can see Institution updated success message