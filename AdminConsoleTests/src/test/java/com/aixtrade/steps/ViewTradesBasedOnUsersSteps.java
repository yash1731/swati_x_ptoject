package com.aixtrade.steps;

import com.aixtrade.pages.TradeBlotterPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewTradesBasedOnUsersSteps {

    private WorldHelper helper;
    private TradeBlotterPage tradeBlotterPage;

    public ViewTradesBasedOnUsersSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select the Institution in trade blotter$")
    public void iSelectTheInstitutionInTradeBlotter() throws Throwable {
        String institution1 = TestData.getValue("trade institution1");
        tradeBlotterPage = helper.getTradeBlotterPage().clickInstitutionDropdown().selectFromDropDown(institution1);
    }

    @Then("^I select the user associated to the selected institution$")
    public void iSelectTheUserAssociatedToTheSelectedInstitution() throws Throwable {
        String user1 = TestData.getValue("trade institution1");
        tradeBlotterPage.clickUsersDropdown().selectUsersDropdown(user1)
                .clickFromDate().selectDate();
    }

    @Then("^I can see the list of trades filtered by institution and user$")
    public void iCanSeeTheListOfTradesFilteredByInstitutionAndUser() throws Throwable {
        Assert.assertTrue(tradeBlotterPage.validateTradeList());
    }

    @Then("^I can validate the institution and trader in the trade list$")
    public void iCanValidateTheInstitutionAndTraderInTheTradeList() throws Throwable {
        String institution1 = TestData.getValue("trade institution1");
        String user1 = TestData.getValue("trade user1");
        Assert.assertTrue(tradeBlotterPage.validateInstitutioninList(institution1));
        Assert.assertTrue(tradeBlotterPage.validateUsersinList(user1));
        Assert.assertTrue(tradeBlotterPage.validateCounterPartyUsersinList(user1));
    }

    @When("^I select the multiple Institution in trade blotter$")
    public void iSelectTheMultipleInstitutionInTradeBlotter() throws Throwable {
        String institution2 = TestData.getValue("trade institution2");
        tradeBlotterPage.clickInstitutionDropdown().selectFromDropDown(institution2);
    }

    @Then("^I select the user associated to the selected multiple institution$")
    public void iSelectTheUserAssociatedToTheSelectedMultipleInstitution() throws Throwable {
        String user2 = TestData.getValue("trade user2");
        tradeBlotterPage.clickUsersDropdown().selectUsersDropdown(user2);
    }

    @Then("^I can see the list of trades filtered by multiple institutions and users$")
    public void iCanSeeTheListOfTradesFilteredByMultipleInstitutionsAndUsers() throws Throwable {
        Assert.assertTrue(tradeBlotterPage.validateTradeList());
    }

    @Then("^I can validate multiple institutions and traders in the trade list$")
    public void iCanValidateMultipleInstitutionsAndTradersInTheTradeList() throws Throwable {
        String institution1 = TestData.getValue("trade institution1");
        String user1 = TestData.getValue("trade user1");
        String institution2 = TestData.getValue("trade institution2");
        String user2 = TestData.getValue("trade user2");
        Assert.assertTrue(tradeBlotterPage.validateInstitutioninList(institution1));
        Assert.assertTrue(tradeBlotterPage.validateUsersinList(user1));
        Assert.assertTrue(tradeBlotterPage.validateCounterPartyUsersinList(user1));
        Assert.assertTrue(tradeBlotterPage.validateInstitutioninList(institution2));
        Assert.assertTrue(tradeBlotterPage.validateUsersinList(user2));
        Assert.assertTrue(tradeBlotterPage.validateCounterPartyUsersinList(user2));
    }


}
