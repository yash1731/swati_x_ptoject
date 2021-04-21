@regression
Feature: Run or Reset AML and KYC Checks
  As an admin user
  I want to reset the AML amd KYC checks for authorised signer
  So I can run manually AML and KYC checks for the users

  @severity=normal
  @aml
  Scenario: View AML and KYC reports
    Given I am on the Applications page
    When I search for "UIT-APP1" applications
    When I click on selected applicant's application
    And I select the Authorised Signer menu
    Then I should be able to view the Authorised signer of the application
    #View AML Report
    When I click on 'View' AML report button
    Then I should see the AML report of the selected Authorised Signer
    And I click on 'Close' AML report button
    #View KYC Report
    When I click on 'View' KYC report button
    Then I should see the KYC report of the selected Authorised Signer
    And I click on 'Close' KYC report button
    #Reset AML Report
    When I click on 'Reset' AML report button
    Then I should able to see "AML checks reset."
    #Reset KYC Report
    When I click on 'Reset' KYC report button
    Then I should able to see "KYC checks reset."
    #Run AML Checks
    When I click on 'Run' AML checks for all authorised signer
    Then I should able to see "AML Checked. Please click on the Institution Legal Name to view the report"
    #Run KYC Checks
    When I search for "UIT-APP1" applications
    When I click on selected applicant's application
    And I select the Authorised Signer menu
    Then I should be able to view the Authorised signer of the application
    When I click on 'Run' KYC checks for all authorised signer
    Then I should able to see "KYC Checked. Please click on the Institution Legal Name to view the report"
