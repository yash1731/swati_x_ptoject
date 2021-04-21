package com.aixtrade.steps;

import com.aixtrade.pages.TradeBlotterPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TradesBasedOnSecurityAndSidesSteps {

    private WorldHelper helper;
    private TradeBlotterPage tradeBlotterPage;

    public TradesBasedOnSecurityAndSidesSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select the security in trade blotter$")
    public void iSelectTheSecurityInTradeBlotter() throws Throwable {
        String security = TestData.getValue("trade security");
        helper.getBasePage().closeCookiePolicy();
        tradeBlotterPage = helper.getTradeBlotterPage().fromDate().selectDate().selectInstrument().chooseInstrument(security).selectInstrument();
    }

    @Then("^I can validate the security in the trade list$")
    public void iCanValidateTheSecurityInTheTradeList() throws Throwable {
        String security = TestData.getValue("trade security");
        Assert.assertTrue(tradeBlotterPage.validateSecurityInList(security));
    }

    @When("^I select the buy side$")
    public void iSelectTheBuySide() throws Throwable {
        String side = TestData.getValue("buy side");
        tradeBlotterPage = helper.getTradeBlotterPage().fromDate().selectInstrument().clickSide().selectSide(side);

    }

    @Then("^I can validate buy side in the trade list$")
    public void iCanValidateBuySideInTheTradeList() throws Throwable {
        String side = TestData.getValue("buy side");
        Assert.assertTrue(tradeBlotterPage.validateSideIntheList(side));
    }

    @When("^I select the sell side$")
    public void iSelectTheSellSide() throws Throwable {
        String side = TestData.getValue("sell side");
        tradeBlotterPage = helper.getTradeBlotterPage().fromDate().selectInstrument().clickSide().deselectSide().selectSide(side);

    }

    @Then("^I can validate sell side in the trade list$")
    public void iCanValidateSellSideInTheTradeList() throws Throwable {
        String side = TestData.getValue("sell side");
        Assert.assertTrue(tradeBlotterPage.validateSideIntheList(side));
    }

}
