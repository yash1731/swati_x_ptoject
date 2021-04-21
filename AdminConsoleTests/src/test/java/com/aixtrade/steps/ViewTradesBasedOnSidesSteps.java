package com.aixtrade.steps;

import com.aixtrade.pages.TradeBlotterPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewTradesBasedOnSidesSteps {

    private WorldHelper helper;
    private TradeBlotterPage tradeBlotterPage;

    public ViewTradesBasedOnSidesSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select the sell side in trade blotter$")
    public void iSelectTheSellSideInTradeBlotter() throws Throwable {
        String sell = TestData.getValue("sell side");
        tradeBlotterPage = helper.getTradeBlotterPage().clickSidesDropdown().selectFromDropDown(sell).clickSidesDropdown();
    }

    @Then("^I can validate the sell side in the trade list$")
    public void iCanValidateTheSellSideInTheTradeList() throws Throwable {
        String sell = TestData.getValue("sell side");
        Assert.assertTrue(tradeBlotterPage.validateSide(sell));
    }

    @Then("^I select the buy side in trade blotter$")
    public void iSelectTheBuySideInTradeBlotter() throws Throwable {
        String buy = TestData.getValue("buy side");
        tradeBlotterPage.clickSidesDropdown().deselectSide().selectFromDropDown(buy).clickSidesDropdown();
    }

    @Then("^I can validate the buy side in the trade list$")
    public void iCanValidateTheBuySideInTheTradeList() throws Throwable {
        String buy = TestData.getValue("buy side");
        Assert.assertTrue(tradeBlotterPage.validateSide(buy));
    }


}
