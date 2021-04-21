package com.aixtrade.steps;

import com.aixtrade.pages.TradeBlotterPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TradeBasedOnSingleMultipleUserSteps {

    private WorldHelper helper;
    private TradeBlotterPage tradeBlotterPage;

    public TradeBasedOnSingleMultipleUserSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on Trade Blotter Page$")
    public void iAmOnTradeBlotterPage() throws Throwable {
        String username = TestData.getValue("user2 email");
        String password = TestData.getValue("user2 password");
        tradeBlotterPage = helper.getBasePage().loginWith(username, password)
               // .closeCookiePolicy()
                .goToTradeBlotterPage();
    }

    @When("^I select the user in trade blotter$")
    public void iSelectTheUserInTradeBlotter() throws Throwable {
        String user = TestData.getValue("select user1");
       tradeBlotterPage = helper.getTradeBlotterPage().fromDate().selectDate().selectInstrument().selectUser(user);
    }

    @Then("^I click on search button in trade blotter$")
    public void iClickOnSearchButtonInTradeBlotter() throws Throwable {
        tradeBlotterPage.clickSearchButton();
    }

    @When("^I can see the list of trades filtered by user$")
    public void iCanSeeTheListOfTradesFilteredByUser() throws Throwable {
       tradeBlotterPage.validateTradeBlotterList();
    }

    @Then("^I can validate the trader in the trade list$")
    public void iCanValidateTheTraderInTheTradeList() throws Throwable {
        String user = TestData.getValue("select user1");
        Assert.assertTrue(tradeBlotterPage.validateTraderInList(user));
    }

}
