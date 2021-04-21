@regression
Feature: Change the state of Users in platform control
  As a admin user
  I want to change the state of selected Users
  So that I can restrict Users to use AIX platform

  @severity=minor
  @usersControl @platformControl
  Scenario: Change the state of the Users in platform control
    Given I am on Platform Control page
#Users validation message
    When I select an Users on platform control
    And I click on 'Apply' button on Users control
    Then I can see the validation message for fields requirement on Users control
#Users - settlement halted
    #When I select an Users on platform control
    And I select the state of Users to settlement halted
    And I enter the reason for Users to be settlement halted
    And I click on 'Apply' button on Users control
    Then I can see the notification of 'Users status changed'
#Users - Trading halted
    When I select an Users trading halted
    And I select the state of Users to trading halted
    And I enter the reason for Users to be trading halted
    And I click on 'Apply' button on Users control
    Then I can see the notification of 'Users status changed'
#Users - Suspended
    When I select an Users to suspend
    And I select the state of Users to suspend
    And I enter the reason for Users to be suspended
    And I click on 'Apply' button on Users control
    Then I can see the notification of 'Users status changed'
    When I select an Users on platform control
#Users - Continuous Trading
    When I click on the link of Users suspended from the chart
    And I click on 'Change State' button on Users control
    Then I change the state from suspended to continuous trading of Users
    And I enter the reason for Users to be continuous trading
    And I click on 'Apply' button on Users control
    Then  I can see the notification of 'Users status changed'