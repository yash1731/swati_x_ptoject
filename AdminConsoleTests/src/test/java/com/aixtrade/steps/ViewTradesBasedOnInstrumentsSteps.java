package com.aixtrade.steps;

import com.aixtrade.pages.TradeBlotterPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewTradesBasedOnInstrumentsSteps {

    private WorldHelper helper;
    private TradeBlotterPage tradeBlotterPage;

    public ViewTradesBasedOnInstrumentsSteps(WorldHelper helper) {
        this.helper = helper;
    }


    @Given("^I am on Trade Blotter Page$")
    public void iAmOnTradeBlotterPage() throws Throwable {
        String username = TestData.getValue("admin email");
        String password = TestData.getValue("admin password");
        tradeBlotterPage = helper.getBasePage().loginWith(username,password).goToTradeBlotterPage();
    }

    @When("^I select the time range to view trade in trade blotter$")
    public void iSelectTheTimeRangeToViewTradeInTradeBlotter() throws Throwable {
        tradeBlotterPage.clickFromDate().selectDate();
    }

    @When("^I select the Instrument in trade blotter$")
    public void iSelectTheInstrumentInTradeBlotter() throws Throwable {
        String instrument = TestData.getValue("selected security");
        tradeBlotterPage.clickInstrumentsDropdown().selectFromDropDown(instrument).clickInstrumentsDropdown();
    }

    @Then("^I can see the list of trades filtered by instrument$")
    public void iCanSeeTheListOfTradesFilteredByInstrument() throws Throwable {
       Assert.assertTrue(tradeBlotterPage.validateTradeList());
    }

    @Then("^I can validate the instrument in the trade list$")
    public void iCanValidateTheInstrumentInTheTradeList() throws Throwable {
        String instrument = TestData.getValue("selected security");
        Assert.assertTrue(tradeBlotterPage.validateInstrumentinList(instrument));
    }


    @Then("^I select multiple Instrument in trade blotter$")
    public void iSelectMultipleInstrumentInTradeBlotter() throws Throwable {
        String instrument = TestData.getValue("selected security2");
        tradeBlotterPage.clickInstrumentsDropdown().selectFromDropDown(instrument).clickInstrumentsDropdown();
    }

    @Then("^I click on search button in trade blotter$")
    public void iClickOnSearchButtonInTradeBlotter() throws Throwable {
       tradeBlotterPage.clickSearchButton();
    }

    @Then("^I can see the list of trades filtered by multiple instruments$")
    public void iCanSeeTheListOfTradesFilteredByMultipleInstruments() throws Throwable {
        Assert.assertTrue(tradeBlotterPage.validateTradeList());
    }

    @Then("^I can validate the multiple instruments in the trade list$")
    public void iCanValidateTheMultipleInstrumentsInTheTradeList() throws Throwable {
        String instrument1 = TestData.getValue("selected security");
        String instrument2 = TestData.getValue("selected security2");
        Assert.assertTrue(tradeBlotterPage.validateInstrumentinList(instrument1));
        Assert.assertTrue(tradeBlotterPage.validateInstrumentinList(instrument2));
    }


}
