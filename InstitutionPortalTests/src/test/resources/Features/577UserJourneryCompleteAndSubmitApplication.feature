@regression
Feature: End to End user journey - Fill and submit an application
  As an an authorised user
  I want to fill my application form
  So I can successfully submit my application

  @end
  Scenario: Fill and Submit an Application
    Given I am on the home page
    When I select Apply button
    And I Continue Application
    And I tick the Disclosures checkbox and proceed to the next page
    And I fill all required field on the application information page as below:
      | Field                   | Value                |
      | Applicant Name          | application name     |
      | Address Line 1          | address line1        |
      | Address Line 2          | address line2        |
      | City                    | applicant city       |
      | State                   | applicant state      |
      | PostCode                | applicant postcode   |
      | Country                 | applicant country    |
      | Business Website        | business website     |
      | Organisation Type       | organisation type    |
      | Date Established        | date established     |
      | Comp Reg Number         | company regNumber    |
      | EIN                     | company EIN          |
      | Legal Entity Identifier | entity identifier    |
      | SeedCX Participant ID   | seedCX participantID |
      | Trading Exp Level       | trading expLevel     |
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
    #And I fill the details of the second authorised user on the Authorised Signers page as below:
     # | Field             | Value             |
     # | First Name2       | first name2       |
     # | Last Name2        | last name2        |
     # | Authoriser Title2 | authoriser title2 |
     # | Contact Number2   | contact number2   |
     # | Date Of Birth2    | dateOf birth2     |
     # | Email Address2    | email address2    |
     # | Signer Country2   | signer country2   |
     # | Passport Number2  | passport number2  |
     # | Passport Expiry2  | passport expiry2  |
     # | Passport Issue2   | passport issue2   |
     # | Building No2      | building no2      |
     # | Signer Street2    | signer street2    |
     # | Signer City2      | signer city2      |
     # | Signer Postcode2  | signer postcode2  |
    And I add the documents for the authorised signer
    And I select options on the financial Information page
    And I select options on the Legal page and add a beneficiary as below:
      | Field                  | Value                  |
#      | Beneficiary Name       | beneficiary name       |
      | Beneficiary DOB        | beneficiary dob        |
      | Beneficiary Address    | beneficiary address    |
      | Beneficiary PassportNo | beneficiary passportNo |
#    And I select options on the Legal page
    And I select an ECP status option
    And I upload required documents
    And I submit my application
    Then I should be able to get a "successful message" for submitting application
    And I log out of the Application

