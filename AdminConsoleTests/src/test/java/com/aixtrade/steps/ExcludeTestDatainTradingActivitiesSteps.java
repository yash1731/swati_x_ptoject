package com.aixtrade.steps;

import com.aixtrade.pages.TradingActivityPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ExcludeTestDatainTradingActivitiesSteps {

    private WorldHelper helper;
    private TradingActivityPage tradingActivityPage;

    public ExcludeTestDatainTradingActivitiesSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Then("^I should able to see the trading activity which includes Test Data$")
    public void iShouldAbleToSeeTheTradingActivityWhichIncludesTestData() throws Throwable {
        Assert.assertTrue(helper.getTradingActivityPage().validateSelectedUserinList());
    }

    @When("^I exclude the Test Data$")
    public void iExcludeTheTestData() throws Throwable {
         tradingActivityPage = helper.getTradingActivityPage().excudeTestData();
    }

    @Then("^Verify the validation Message \"([^\"]*)\"$")
    public void verifyTheValidationMessage(String message) throws Throwable {
        Assert.assertTrue(tradingActivityPage.verifyTestExcludeMessage(message));

    }

}
