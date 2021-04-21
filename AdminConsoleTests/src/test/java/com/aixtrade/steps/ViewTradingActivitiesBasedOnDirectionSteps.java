package com.aixtrade.steps;

import com.aixtrade.pages.TradingActivityPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;

public class ViewTradingActivitiesBasedOnDirectionSteps {

    private WorldHelper helper;
    private TradingActivityPage tradingActivityPage;

    public ViewTradingActivitiesBasedOnDirectionSteps(WorldHelper helper) {
        this.helper = helper;
    }


    @Then("^I select the inbound direction of the events$")
    public void iSelectTheInboundDirectionOfTheEvents() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("utterance event");
        String quoteRequestEvents = TestData.getValue("quoteRequest event");
        String inbound = TestData.getValue("inbound direction");
        String direction = TestData.getValue("direction title");
        tradingActivityPage = helper.getTradingActivityPage()
                .eventsSelector(utteranceEvents).selectAllEvents(allEvents)
                .selectEvent(quoteRequestEvents).eventsSelector(quoteRequestEvents)
                .clickDirection(direction).selectDirection(inbound).fromDate();
    }

    @Then("^I should able to see the list of events performed by the institutions for selected inbound direction$")
    public void iShouldAbleToSeeTheListOfEventsPerformedByTheInstitutionsForSelectedInboundDirection() throws Throwable {
        String inbound = TestData.getValue("inbound direction");
        tradingActivityPage.verifyDirectionInTradingActivityList(inbound);
    }

    @Then("^I select the outbound direction of the events$")
    public void iSelectTheOutboundDirectionOfTheEvents() throws Throwable {
        String inbound = TestData.getValue("inbound direction");
        String outbound = TestData.getValue("outbound direction");
        tradingActivityPage.clickDirection(inbound).selectDirection(outbound).fromDate();
    }

    @Then("^I should able to see the list of events performed by the institutions for selected outbound direction$")
    public void iShouldAbleToSeeTheListOfEventsPerformedByTheInstitutionsForSelectedOutboundDirection() throws Throwable {
        String outbound = TestData.getValue("outbound direction");
        tradingActivityPage.verifyDirectionInTradingActivityList(outbound);
    }

}
