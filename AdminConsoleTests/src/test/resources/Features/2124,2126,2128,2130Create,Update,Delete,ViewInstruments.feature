@regression
Feature: Add, Update, Delete an Instruments in Admin Console
  As a admin user
  I want to manage an instrument
  so that I can update instrument according to requirements

  @severity=normal
  @instruments
 Scenario: View, Create and Edit Instruments
   Given I am on Instruments page
#View Instruments list
   Then I can view Instruments list
#View Validations
#   When I click on add Instruments tab
#   And I click on 'Add' button on Add Instruments page
#   Then I can view validations for mandatory fields
##Add Instrument
#   When I enter all the fields to create Instrument
#    |             Field                          |        Value                        |
#    |   Instrument Symbol                        |      instrument symbol              |
#    |   Instrument Description                   |   instrument description            |
#    |   Instrument SecurityType                  |   instrument securityType           |
#    |   Instrument BaseCurrency                  |   instrument baseCurrency           |
#    |   Instrument AssetType                     |   instrument assetType              |
#    |   Instrument SettlementCurrency            |   instrument settlementCurrency     |
#    |   Instrument SettlementCurrencySign        |   instrument settlementCurrencySign |
#    |   Instrument VolumePrecision1              |   instrument volumePrecision1       |
#    |   Instrument PricePrecision1               |   instrument pricePrecision1        |
#    |   Instrument nluSynonyms                   |   instrument nluSynonyms            |
#   And I click on 'Add' button on Add Instruments page
#    Given I am on Instruments page
#    #Then I click on Instruments tab
#   Then I can view Instruments list
#Update Instrument
   When I filter "instrument symbol" on View Instruments list
   And I click on edit an Instrument
   And I update the fields in the instruments form
    |             Field                           |        Value                        |
    |   Instrument VolumePrecision2               |   instrument volumePrecision2       |
    |   Instrument PricePrecision2                |   instrument pricePrecision2        |
   And I click on 'Update' button on Add Instruments page
   Then Volume and Price Precision validation is thrown
   And I update the fields in the instruments form with valid values
    |             Field                           |        Value                        |
    |   Instrument VolumePrecision3               |   instrument volumePrecision3       |
    |   Instrument PricePrecision3                |   instrument pricePrecision3        |
   And I enable the instrument and test fields
   And I enter the mock fields
    |      Field          |        Value       |
    |   Mock Open         |      mock open     |
    |   Mock Low          |   mock low         |
    |   Mock High         |   mock high        |
    |   Mock Source       |   mock source      |
    |   Mock SourceURL    |   mock sourceURL   |
   And I click on 'Update' button on Add Instruments page
   Then I can view "Instrument saved." message
#   Given I am on Instruments page
   #Then I click on Instruments tab
   #Delete Instrument
#   When I filter "Instrument Symbol" on View Instruments list
#   Then I can view Instruments list
#   And I click on Delete an Instrument button
#   Then I can view "Instrument deleted." message


