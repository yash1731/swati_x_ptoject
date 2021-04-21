@regression
      Feature: View the trading activities of single/multiple institutions
      As an admin user
      I want to view list of trading activities performed by institutions
      So I can track the institutions and their actions

        @severity=normal
      @multipleInstitutions
      Scenario: View the trading activity of Single/Multiple Institutions
        Given I am on the Trading activity page
        When I select the multiple institutions to view trading activities shown below:
          |   Field           |    Value          |
          | Institution1 Name | institution1 name |
          | Institution2 Name | institution2 name |
        When I click on serach button
        Then I should able to see the list of events performed by the selected multiple institutions
