@regression2
Feature: Create Quote Request, Quote and Quote Response
  As a trader
  I want to ask for a quote request, respond to Quote Request and create a counter in form of Quote Response

  @cancelQR
  Scenario: Create Quote Request
    Given I create a Quote Request
    Then I can see quote request created
