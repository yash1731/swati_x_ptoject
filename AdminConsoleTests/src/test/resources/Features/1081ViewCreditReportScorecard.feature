#This function is redundant
# @regression
#Feature: View Credit Report Scorecard
#  As an admin user
#  I want to view credit card report scorecard for a specific application
#  So I can review application status
#
#  @scorecard
#  Scenario: View Credit Report Scorecard
#    Given I am on the Applications page
#    When I search for "approved applications" on this page
#    And I select to view the credit report scorecard for any of the displayed applications
#    Then I should be able to see the credit score card displayed
#    And the credit score card will have the following details below:
#      | Field        | Value          |
#      | Risk Level   | risk level     |
#      | Credit Limit | credit limit   |
#      | Status       | account status |