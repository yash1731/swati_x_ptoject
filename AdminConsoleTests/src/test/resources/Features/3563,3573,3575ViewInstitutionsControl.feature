@regression
Feature: Change the state of Institution in platform control
  As a admin user
  I want to change the state of selected institutions
  So that I can restrict institutions to use AIX platform

  @severity=minor
  @institutionControl @platformControl
  Scenario: Change the state of the institutions in platform control
    Given I am on Platform Control page
#institutions validation message
    When I select an institutions on platform control
    And I click on 'Apply' button on institution control
    Then I can see the validation message for fields requirement on Institutions form
#institutions - settlement halted
#    When I select an institutions on platform control
    And I select the state of institutions to settlement halted
    And I enter the reason for institutions to be settlement halted
    And I click on 'Apply' button on institution control
    Then I can see the notification of 'institutions status changed'
#institutions - Trading halted
    When I select an institutions trading halted
    And I select the state of institutions to trading halted
    And I enter the reason for institutions to be trading halted
    And I click on 'Apply' button on institution control
    Then I can see the notification of 'institutions status changed'
#institutions - Suspended
    When I select an institutions to suspend
    And I select the state of institutions to suspend
    And I enter the reason for institutions to be suspended
    And I click on 'Apply' button on institution control
    Then I can see the notification of 'institutions status changed'
#    When I select an institutions on platform control
#institutions - Continuous Trading
#    When I click on the link of institutions suspended from the chart
#    And I click on 'Change State' button of Suspended Institution
    When I select an institutions to Continuous trading
    Then I change the state from suspended to continuous trading of institutions
    And I enter the reason for institutions to be continuous trading
    And I click on 'Apply' button on institution control
    Then  I can see the notification of 'institutions status changed'