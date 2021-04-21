@regression
Feature: Clone and delete an Onboarding Document Types
  As an admin user
  I want to copy document types from one country to another and then delete copied document
  So I can have all required documents for a country

  @severity=minor
  @clone
  Scenario:Clone Document Type
    Given I am on the Document Types page
    And I have created a new document Type for a specified country
    When I select an "export country" to copy document Type into
    And I click on the copy button
    And I confirm 'Copy Document Types'
    Then I should be able to see a success message - "cloneDoc message"
#    Delete Onboarding Document
    When I select to delete the document Type
    Then I should be able to successfully delete document type
#    Select export country and confirm document was successfully cloned
    When I select the "export country"
    Then I should be able to see cloned documents displayed for the country as below:
      | Field                | Value                |
     # | Document Code        | document code        |
      | Document Description | document description |
#    1047 Delete Onboarding Document
    When I select to delete the document Type for the export country
    Then I should be able to successfully delete document type
