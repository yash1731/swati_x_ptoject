@regression
Feature: Add and Remove a beneficiary from an application
  As a user
  I want to add and delete a beneficiary from an application
  So I can remove beneficiary access to an application after access is been given

  @ben
  Scenario: Add and Remove a beneficiary from an application
    Given I am on the legal page
    And I add a beneficiary as below:
      | Field                  | Value                  |
      | Beneficiary DOB        | beneficiary dob        |
      | Beneficiary Address    | beneficiary address    |
      | Beneficiary PassportNo | beneficiary passportNo |
    Then I should see beneficiary added
    And I should be able to see a "benAddedSuccess message"
#    Update Beneficiary
    When I update beneficiary as below:
      | Field                  | Value                |
      | Beneficiary DOB        | updateBen dob        |
      | Beneficiary Address    | updateBen address    |
      | Beneficiary PassportNo | updateBen passportNo |
    Then I should see beneficiary's details updated as below:
      | Field                  | Value                |
      | Beneficiary Address    | updateBen address    |
      | Beneficiary PassportNo | updateBen passportNo |
    And I should be able to see an "UpdateBenSuccess message"
#    Delete Beneficiary
    When I select to delete beneficiary
    Then I should be able to see beneficiary details deleted
    And I log out of the Application