@regression

  @severity=normal


Feature: Testing Login requirement feature
  As a user
  I want to be able to login to the Admin Console
  So I can configure my applications

  @login
  Scenario: Login test of Admin console application
    Given I am on the login page
    When I login with "admin email" & "admin password"
    Then I should be able to see the text "admin console"
