@regression
Feature: Create, Update and Delete an Onboarding Document Type
  As an admin user
  I want to add a new document type for a country
  I want to Update new document added and delete updated document
  So I can only have all the required document type for that country

  @severity=normal
  @createDoc
  Scenario: Add New Document Type
    Given I am on the Document Types page
    When I select country and add the values to the fields as below:
      | Field                | Value                |
      | Preferred Country    | preferred country    |
      | Document Code        | document code        |
      | Document Description | document description |
    And I click the Add New button
    Then I should be able to add new document Type on the Document Type table as below:
      | Field                | Value                |
     # | Document Code        | document code        |
      | Document Description | document description |
    Then I should be able to see a "createDoc message"
#    1046 Update An Onboarding Document
    When I edit the document
    And I make changes to the below:
      | Field                        | Value                 |
    #  | Updated Document Code        | updateDoc code        |
      | Updated Document Description | updateDoc description |
    And I click on the update button
    Then document type is updated with the changes made as below:
      | Field                        | Value                 |
     # | Updated Document Code        | updateDoc code        |
      | Updated Document Description | updateDoc description |
    Then I should be able to see an "updateDoc message"
#    1047 Delete Onboarding Document
    When I select to delete document Type
    And I confirm deletion
    Then I should be able to delete document type successfully with a "deleteDoc message" displayed
