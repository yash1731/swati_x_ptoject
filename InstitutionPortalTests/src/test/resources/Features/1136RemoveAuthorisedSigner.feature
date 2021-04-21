@regression
Feature: Remove Authorised Signer from an application
  As a user
  I want to delete an authorised signer from an application
  So I can remove signer's access to an application

  @auth
  Scenario: Remove Authorised Signer from an application
    Given I am on the Authorised Signer page
    And I fill the details of the first authorised user on the Authorised Signers page as below:
      | Field            | Value            |
      | First Name       | first name       |
      | Last Name        | last name        |
      | Authoriser Title | authoriser title |
      | Date Of Birth    | dateOf birth     |
      | Email Address    | email address    |
      | Contact Number   | contact number   |
      | Signer Country   | signer country   |
      | Signer SSN       | signer ssn       |
      | Passport Number  | passport number  |
      | Passport Expiry  | passport expiry  |
      | Passport Issue   | passport issue   |
      | Building No      | building no      |
      | Signer Street    | signer street    |
      | Signer City      | signer city      |
      | Signer Postcode  | signer postcode  |
    When I select to delete an Authorised Signer
    Then I should be able to see the Authorised Signers details deleted
    And I log out of the Application