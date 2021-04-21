@regression
Feature: This is a test to reset password
  As an an authorised user
  I want to reset my password
  So I can have access to my account

  @severity=normal
  @reset
  Scenario: Confirm that user can reset password
    Given I am on the login page
    When I click the forgot password link
    And I enter and submit "admin email" on the reset password page
    Then I should be able to see a "success message" that lets user know email has been sent for password request

#  Scenario: NOT AUTOMATED - Email received
#    When I check email
#    Then I should be able to see a reset password link with a link to rest credentials
#    When I click the link
#    Then I should be able to enter a new password and also confirm password
#    And I should be able to successfully reset my password
