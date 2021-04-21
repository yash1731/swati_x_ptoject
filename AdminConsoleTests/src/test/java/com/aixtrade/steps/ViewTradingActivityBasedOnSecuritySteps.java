package com.aixtrade.steps;

import com.aixtrade.pages.TradingActivityPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewTradingActivityBasedOnSecuritySteps {

    private WorldHelper helper;
    private TradingActivityPage tradingActivityPage;

    public ViewTradingActivityBasedOnSecuritySteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Then("^I select the security from the Instrument list$")
    public void iSelectTheSecurityFromTheInstrumentList() throws Throwable {
        String selectedSecurity = TestData.getValue("selected security");
        tradingActivityPage = helper.getTradingActivityPage().selectSecurity(selectedSecurity);
    }

    @Given("^I select the date and time to search security$")
    public void iSelectTheDateAndTimeToSearchSecurity() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().fromDate().getTimeForSecuritySearch();
    }


    @Then("^I should able to see the list of events performed by the institutions for selected securities$")
    public void iShouldAbleToSeeTheListOfEventsPerformedByTheInstitutionsForSelectedSecurities() throws Throwable {
        String selectedSecurity = TestData.getValue("selected security");
        Assert.assertTrue(tradingActivityPage.validateSelectedUserinList());
        tradingActivityPage.clickViewDetailsButton().validateSymbol(selectedSecurity);
    }

    @When("^I select the 'Quote Request' Event from Event selector$")
    public void iSelectTheQuoteRequestEventFromEventSelector() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("utterance event");
        String quoteEvents = TestData.getValue("quote event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(utteranceEvents).selectAllEvents(allEvents).selectEvent(quoteEvents).eventsSelector(quoteEvents);

    }

}
