#@regression
Feature: Change the state of Platform in platform control
  As a admin user
  I want to change the state of platform
  So that I can restrict institutions and users to use AIX platform

  @severity=normal
  @platform @platformControl
  Scenario: Change restrictions to the platform in platform control
    Given I am on Platform Control page
#Platform validation message
    And I click on 'Apply' button
    Then I can see the validation message for fields requirement
# Platform - Suspended
    When I select the platform suspended option
    And I enter the platform suspended reason
    And I click on 'Apply' button
    Then I can see the notification of 'Platform status changed'
    And I can see 'Y' across the platform suspended
    And I can see in control table all the fields are greyed out
# Platform - Halt trading
    When I select the platform halt for trading option
    And I enter the platform trading halted reason
    And I click on 'Apply' button
    Then I can see the notification of 'Platform status changed'
    And I can see 'Y' across the platform halted for trading
    And I can see in control table all the fields are greyed out except suspended
# Platform - Halt Settlement
    When I select the platform halt for settlement option
    And I enter the platform settlement halted reason
    And I click on 'Apply' button
    Then I can see the notification of 'Platform status changed'
    And I can see 'Y' across the platform halted for settlement
    And I can see in control table all the fields are greyed out except trading halted and suspended
# Platform - Continuous trading
    When I select the platform continuous for trading option
    And I enter the platform trading continuously reason
    And I click on 'Apply' button
    Then I can see the notification of 'Platform status changed'
    And I can see 'Y' across the platform continuous for trading
    And I can see in control table all the fields are enabled