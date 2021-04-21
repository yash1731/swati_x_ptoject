@regression
Feature: View Attached Documents
  As an admin user
  I want to view attachments
  So I review all required documents

  @severity=trivial
  @doc
  Scenario: View Client's attached Documents
    Given I am on the Applications page
    Then I should be able to see all applications and their status
    When I select to view a specific user's application
    Then I should be able to see client's individual application
    When I select the Document page
    Then I should be able to see client's attached documents
    And I can see 'View Document' button for all required documents