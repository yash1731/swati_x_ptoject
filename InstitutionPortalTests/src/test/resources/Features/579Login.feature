@regression
Feature: Testing Login requirement feature
  As a user
  I want to be able to login to the application
  So I can submit an application

  @login
  Scenario: Login test of Institution Portal application
    Given I am on the login page
    When I login with "user email" & "user password"
    Then I should be able to see the text "login message"
    And I log out of the Application
