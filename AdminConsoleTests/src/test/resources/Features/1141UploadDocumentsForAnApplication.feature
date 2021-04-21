#@regression - This function is removed from Admin Console
Feature: Update Documents for an Application
  As an admin user
  I want to upload onboarding document for an applicant via the Admin Console Application
  So I can ensure all required documents are present

  @severity=minor
  @upload
  Scenario: Upload required Documents
    Given I am on the Applications page
    When I select to view a specific user's application
    And I select the Additional Documents page
    Then I should be able to see 'Add Documents' button
    When I select to add document
    And I click on the 'Start Upload' button
    Then I can successfully upload a document
#Add More Document
    When I select to Add More Document
    Then I should be able to see the 'Add Documents' button to enable me add more document
#View Document
    When I select to view document by clicking 'View Document' button
    Then I can view selected document
#Delete Document
    When I select to delete document
    Then I should be able to delete selected document
#Cancel Upload
    When I select to add document
    And I click on the 'Cancel Upload' button
    Then document should not be uploaded




