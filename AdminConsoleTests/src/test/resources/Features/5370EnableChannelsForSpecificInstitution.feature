@regression

  Feature: Enable Channels for an institution
  As a admin user
  I am able to enable channels for a specific institution
  So that institution can add channels id respectively

  @severity=normal
  @channels
  Scenario: Enable channel on Institution level
    Given I am on the Institutions page
    Then I should be able to see all institutions
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Institution Info' button
    #Select All
    Then I click on Enable channel to select all channels
    When I add settlement and commission charge for an institution
    And I click on 'Update' institution button
    Then I can see Institution updated success message
    #Deselect All
    Then I click on Enable channel to deselect all channels
    #When I add settlement and commission charge for an institution
    And I click on 'Update' institution button
    Then I can see Institution updated success message
    #Enable Telegram and FIX
    Then I click on Enable channel to select Telegram and FIX
    And I click on 'Update' institution button
    Then I can see Institution updated success message
    #verify enabled channel in users page
    Given I go back to Institutions page
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Users' button
    Then I should be able to see users associated with that specific institution
    When I search for "uit1-ac-all-channels01@aixtrade.com" in Users
    Then I Click on 'Edit' users button
    And Verify TelegramId and FixId fields are enabled
    #Disable all the channels
    Given I go back to Institutions page
    When I search for "UIT1" in Institutions to enable Channels
    And I click on the 'Institution Info' button
    Then I click on Enable channel to deselect Telegram and Fix channels
    And I click on 'Update' institution button
    Then I can see Institution updated success message


