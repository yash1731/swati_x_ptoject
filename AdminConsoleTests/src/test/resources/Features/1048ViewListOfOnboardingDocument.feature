@regression
Feature: View List of Onboarding Document
  As an admin user
  I want to view list of documents
  So I confirm all required document types are in the list

  @severity=trivial
  @docs
  Scenario: View List of Users within an institution
    Given I am on the Document Types page
    When I select a "specific country"
#    Then I should be able to see all required document types for that country as below:
#      | Field                | Value                |
#      | Document Code        | document code        |
#      | Country Code         | country code         |
#      | Document Description | document description |
    Then I should be able to see all required document types for that country
