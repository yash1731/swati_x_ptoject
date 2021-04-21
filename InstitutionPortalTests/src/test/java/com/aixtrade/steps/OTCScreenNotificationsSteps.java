package com.aixtrade.steps;

import com.aixtrade.pages.AlertsAndPopovers;
import com.aixtrade.pages.OTCScreenPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class OTCScreenNotificationsSteps {

    private WorldHelper helper;
    private OTCScreenPage otcScreenPage;
    private AlertsAndPopovers alertsAndPopovers;

    public OTCScreenNotificationsSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the OTC Screen$")
    public void iAmOnTheOTCScreen() throws Throwable {
        String username = TestData.getValue("tester7 email");
        String password = TestData.getValue("user2 password");
        otcScreenPage = helper.getBasePage().loginWith(username, password)
                .goToOTCScreenPage();
    }

    //Quote Request

    @When("^I select the 'Symbol' for Base currency on OTC Screen$")
    public void iSelectTheSymbolForBaseCurrencyOnOTCScreen() throws Throwable {
        String baseCurrency = TestData.getValue("baseCurrency otc");
        helper.getOTCScreenPage().selectBaseCurrency(baseCurrency);
    }

    @When("^I select the 'Symbol' for Quote currency on OTC Screen$")
    public void iSelectTheSymbolForQuoteCurrencyOnOTCScreen() throws Throwable {
        String quoteCurrency = TestData.getValue("quoteCurrency otc");
        helper.getOTCScreenPage().selectQuoteCurrency(quoteCurrency);
    }

    @When("^I add 'Quantity' in OTC Screen to request for price$")
    public void iAddQuantityInOTCScreenToRequestForPrice() throws Throwable {
        String quantity = TestData.getValue("otc quantity");
        otcScreenPage.enterQuantity(quantity);
    }

    @When("^I click on 'Request Quote' button$")
    public void iClickOnRequestQuoteButton() throws Throwable {
        otcScreenPage.clickRequestQuoteButton();
    }

    @Then("^I should receive notification \"([^\"]*)\"$")
    public void iShouldReceiveNotification(String message) throws Throwable {
        Assert.assertTrue(otcScreenPage.validateOTCNotify(message));
    }

    //Displayed BUY and SELL buttons with Awaiting Price

    @Then("^I can view buy and sell buttons are displayed with awaiting price$")
    public void iCanViewBuyAndSellButtonsAreDisplayedWithAwaitingPrice() throws Throwable {
        String text = TestData.getValue("price text");
        otcScreenPage.showBUYAndSELLButtons(text);
    }


    //Cancel Quote Request

    @When("^I cancel the Quote Request by clicking 'Cancel Request' button$")
    public void iCancelTheQuoteRequestByClickingCancelRequestButton() throws Throwable {
        alertsAndPopovers = otcScreenPage.clickCancelQuoteButton()
                .completeDelete();

    }

    @Given("^I am on the OTC Screen to check funds$")
    public void iAmOnTheOTCScreenToCheckFunds() throws Throwable {
        String username = TestData.getValue("tester8 email");
        String password = TestData.getValue("user2 password");
        otcScreenPage = helper.getBasePage().loginWith(username, password)
                .goToOTCScreenPage();
    }

    //insufficient funds

    @When("^I select the 'Symbol' for Base currency on OTC Screen for insufficient fund$")
    public void iSelectTheSymbolForBaseCurrencyOnOTCScreenForInsufficientFund() throws Throwable {
        String baseCurrency = TestData.getValue("baseCurrency otc2");
        helper.getOTCScreenPage().selectBaseCurrency(baseCurrency);
    }

    @Then("^I should receive error notification \"([^\"]*)\"$")
    public void iShouldReceiveErrorNotification(String message) throws Throwable {
        Assert.assertTrue(otcScreenPage.validateOTCErrorNotify(message));
    }

}
