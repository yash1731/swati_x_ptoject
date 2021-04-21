@regression
Feature: Save an Incomplete Application
  As a user
  I want to be able to save an incomplete application
  So I can submit finish the application at a later time

  @incomplete
  Scenario: Save an incomplete application
    Given I logged in to the application with "tester5 email" and "user password"
    When I proceed to the Application Information page
    And I fill and save my details on the Application Information page as below:
      | Field                   | Value                |
      | Applicant Name          | application2 name     |
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
    And I log out of the Application
    And I log into the application "tester5 email" and "user password"
    And navigate to the application information page
    Then I should be able to see all my saved details populate on this page as below:
      | Field                   | Value                |
      | Applicant Name          | application2 name     |
      | Comp Reg Number         | company regNumber    |
      | EIN                     | company EIN          |
    And I log out of the Application