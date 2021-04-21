@regression
Feature: Send Email to AiX Support
  As a user
  I want to be able to send an email to AiX Support
  So that I can get any issues I have resolved as soon as possible

#  STEPS COMMENTED OUT DUE TO CONSTANT EMAIL BEING SENT TO SUPPORT.
  @email
  Scenario: Send Email to AiX Support
    Given I have selected the Help menu
    When I enter the details below:
      | Field   | Value        |
      | Subject | test subject |
      | Message | test message |
    Then I should be able to see a "successEmail message" for email successfully sent
#    And I can see message sent to the support team

