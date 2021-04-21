@regression
Feature: Change the state of Instruments in platform control
  As a admin user
  I want to change the state of selected instruments
  So that I can restrict institutions and users to use selected instruments

  @severity=minor
  @instrumentControl @platformControl
  Scenario: Change the state of the instruments in platform control
    Given I am on Platform Control page
#Instruments validation message
    When I select an instrument on platform control
    And I click on 'Apply' button on Instruments
    Then I can see the validation message for fields requirement in Instruments form
#Instrument - settlement halted
    When I select an instrument on platform control
    And I select the state of instrument to settlement halted
    And I enter the reason for instrument to be settlement halted
    And I click on 'Apply' button on Instruments
    Then I can see the notification of 'INSTRUMENT status changed'
#Instrument - Trading halted
    When I select an instrument trading halted
    And I select the state of instrument to trading halted
    And I enter the reason for instrument to be trading halted
    And I click on 'Apply' button on Instruments
    Then I can see the notification of 'INSTRUMENT status changed'
#Instrument - Suspended
    When I select an instrument to suspend
    And I select the state of instrument to suspend
    And I enter the reason for instrument to be suspended
    And I click on 'Apply' button on Instruments
    Then I can see the notification of 'INSTRUMENT status changed'
    And I select an instrument on platform control
#Instrument - Continuous Trading
    When I click on the link of instrument suspended from the chart
    And I click on 'Change State' button
    Then I change the state from suspended to continuous trading of instrument
    And I enter the reason for instrument to be continuous trading
    And I click on 'Apply' button on Instruments
    Then  I can see the notification of 'INSTRUMENT status changed'