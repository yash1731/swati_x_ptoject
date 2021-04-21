@regression
Feature: Add A User To Account
  As a user
  I want to add user on the Users menu
  So I can give access to a user

  @add
  Scenario: Register a user on the institution portal
    Given I am on the users page
    #When I select Add/Edit user tab
   # When I add a user with the details below:
   #   | Field       | Value       |
   #   | Last Name   | user last   |
   #   | Telegram ID | telegram id |
   # Then I should be able to successfully add a user with a "addedUser message" displayed
   #And I should be able to see the new user displayed on the Users Table
#    Mark User As Admin
    When I edit user and mark user as Admin
    Then I should be able to see user added as Admin with an "updateSuccess message"
#    Mark User As Trader
    When I edit user and mark user as a Trader
    Then I should be able to see user added as a Trader with an "updateSuccess message"
    #    Mark User As A Market Maker
    When I edit user and mark user as a Market Maker
    Then I should be able to see user added as a Market Maker with an "updateSuccess message"
#    Delete New User
   # When I delete new user
   # Then I should be able to see user successfully deleted with a "deleteUser message" displayed
#   PreferredChannel
   # When I edit market maker user
   # Then I should able to see User Preferences
   # And  I choose the Preferred Channel
   # Then I should see the "updateSuccess message"
     #Disable RFQ security For BTC and ETH
#    When I uncheck receive BTC security
#    Then I should see the "userPreferencesRemoved message"
#    Then I should not able to see quote expiry, min and max price field
#    When I uncheck receive ETH security
#    Then I should see the "userPreferencesRemoved message"
#    Then I should not able to see ETH quote expiry, min and max price field
#   ReceiveSecurity(BTC)
    When I check receive BTC security
    #Then I should able to see quote expiry, min and max price field
    When I enter the quote expiry time
    Then I should see the "userPreferencesSaved message"
    When I enter minimum BTC price
    Then I should see the "userPreferencesSaved message"
    When I enter maximum BTC price
    Then I should see the "userPreferencesSaved message"
 #  ReceiveSecurity(ETH)
    When I check receive ETH security
   # Then I should able to see ETH quote expiry, min and max price field
    When I enter the ETH quote expiry time
    Then I should see the "userPreferencesSaved message"
    When I enter minimum ETH price
    Then I should see the "userPreferencesSaved message"
    When I enter maximum ETH price
    Then I should see the "userPreferencesSaved message"
    #ResetPreferredChannel to Telegram
    And I choose the Preferred Channel set to default
    Then I should see the "updateSuccess message"
# #QuoteExpiryValidation For BTC and ETH
#    When I enter the invalid quote expiry time
#    Then I should see the validation "quoteExpiry message"
#    When I enter the invalid quote expiry time for ETH
#    Then I should see the validation "quoteExpiry message"
#    Disable user as Market Maker
#    When I edit user and mark user as Admin
#    Then I should be able to see user added as Admin with an "updateSuccess message"
    When I edit user and disable user as an admin and a  Market Maker
    Then I should be able to see user added as a Market Maker with an "updateSuccess message"
 #Min and Max price validation for BTC and ETH
   # When I enter invalid minimum BTC price
   # Then I should see the validation "minBTCPrice message"
   # When I enter invalid maximum BTC price
   # Then I should see the validation "maxBTCPrice message"
   # When I enter invalid minimum ETH price
   # Then I should see the validation "minETHPrice message"
   # When I enter invalid maximum ETH price
   # Then I should see the validation "maxETHPrice message"
    And I log out of the Application