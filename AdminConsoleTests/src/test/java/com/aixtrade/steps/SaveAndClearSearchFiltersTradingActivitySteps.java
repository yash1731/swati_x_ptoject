package com.aixtrade.steps;

import com.aixtrade.pages.TradingActivityPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SaveAndClearSearchFiltersTradingActivitySteps {

    private WorldHelper helper;
    private TradingActivityPage tradingActivityPage;

    public SaveAndClearSearchFiltersTradingActivitySteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I click on 'Save' Search button in Trading Activity$")
    public void iClickOnSaveSearchButtonInTradingActivity() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().clickSaveFiltersButton();
    }

    @Then("^I can see the message \"([^\"]*)\"$")
    public void iCanSeeTheMessage(String saveClearMessage) throws Throwable {
        Assert.assertTrue(tradingActivityPage.validateSavedClearSearchMessage(saveClearMessage));
    }

    @When("^I click on 'Clear' filter button$")
    public void iClickOnClearFilterButton() throws Throwable {
       tradingActivityPage.clickClearFiltersButton();
    }
}
