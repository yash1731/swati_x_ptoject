package com.aixtrade.steps;

import com.aixtrade.pages.TradingActivityPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewTradingActivityDetailsSteps {

    private WorldHelper helper;
    private TradingActivityPage tradingActivityPage;

    public ViewTradingActivityDetailsSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I can view the direction and utterance description in the list$")
    public void iCanViewTheDirectionAndUtteranceDescriptionInTheList() throws Throwable {
         String utterance = TestData.getValue("utterance direction");
         //tradingActivityPage = helper.getTradingActivityPage().viewUtteranceDirection(utterance).getUtteranceDescription();
        tradingActivityPage = helper.getTradingActivityPage().getEventDetails(utterance);
    }

    @When("^I click on 'View Details' button$")
    public void iClickOnViewDetailsButton() throws Throwable {
         tradingActivityPage.clickViewDetailsButton();
    }

    @Then("^I should able to see the Activity Details opened with same description$")
    public void iShouldAbleToSeeTheActivityDetailsOpenedWithSameDescription() throws Throwable {
        helper.getTradingActivityPage().viewDetails();
    }

    @Then("^I close the detailed view of trading activity$")
    public void iCloseTheDetailedViewOfTradingActivity() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().clickCloseDetailsButton();
    }

    @When("^I select order events from events dropdown$")
    public void iSelectOrderEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("utterance event");
        String orderEvents = TestData.getValue("order event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(utteranceEvents).selectAllEvents(allEvents).selectEvent(orderEvents).eventsSelector(orderEvents);

    }

    @Then("^I should able to see 'Orders' Trading activity$")
    public void iShouldAbleToSeeOrdersTradingActivity() throws Throwable {
        String orderEvents = TestData.getValue("order event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(orderEvents));
        //tradingActivityPage = helper.getTradingActivityPage().getEventType().getEventDescription();
        tradingActivityPage = helper.getTradingActivityPage().getEventDetails(orderEvents);
    }

    @Then("^I should able to see the activity details$")
    public void iShouldAbleToSeeTheOrdersActivityDetails() throws Throwable {
       helper.getTradingActivityPage().viewEventNameInDetails();
        helper.getTradingActivityPage().viewDetails();
    }

    @When("^I select Quote events from events dropdown$")
    public void iSelectQuoteEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String orderEvents = TestData.getValue("utterance event");
        String quoteEvents = TestData.getValue("quote event");
        tradingActivityPage= helper.getTradingActivityPage().eventsSelector(orderEvents).selectAllEvents(allEvents).selectEvent(quoteEvents).eventsSelector(quoteEvents);
    }

    @Then("^I should able to see 'Quote' Trading activity$")
    public void iShouldAbleToSeeQuoteTradingActivity() throws Throwable {
        String quoteEvents = TestData.getValue("quote event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(quoteEvents));
        tradingActivityPage.getEventDetails(quoteEvents);
    }

    @When("^I select Quote Request events from events dropdown$")
    public void iSelectQuoteRequestEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String quoteEvents = TestData.getValue("utterance event");
        String quoteRequestEvents = TestData.getValue("quoteRequest event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(quoteEvents).selectAllEvents(allEvents).selectEvent(quoteRequestEvents).eventsSelector(quoteRequestEvents);
    }

    @Then("^I should able to see 'Quote Request' Trading activity$")
    public void iShouldAbleToSeeQuoteRequestTradingActivity() throws Throwable {
        String quoteRequestEvents = TestData.getValue("quoteRequest event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(quoteRequestEvents));
        tradingActivityPage.getEventDetails(quoteRequestEvents);
    }

    @When("^I select Quote Response events from events dropdown$")
    public void iSelectQuoteResponseEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String quoteRequestEvents = TestData.getValue("utterance event");
        String quoteResponseEvents = TestData.getValue("quoteResponse event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(quoteRequestEvents).selectAllEvents(allEvents).selectEvent(quoteResponseEvents).eventsSelector(quoteResponseEvents);
    }

    @Then("^I should able to see 'Quote Response' Trading activity$")
    public void iShouldAbleToSeeQuoteResponseTradingActivity() throws Throwable {
        String quoteResponseEvents = TestData.getValue("quoteResponse event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(quoteResponseEvents));
        tradingActivityPage.getEventDetails(quoteResponseEvents);
    }


    @When("^I select Trade events from events dropdown$")
    public void iSelectTradeEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String quoteResponseEvents = TestData.getValue("utterance event");
        String tradeEvents = TestData.getValue("trade event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(quoteResponseEvents).selectAllEvents(allEvents).selectEvent(tradeEvents).eventsSelector(tradeEvents);
    }

    @Then("^I should able to see 'Trade' Trading activity$")
    public void iShouldAbleToSeeTradeTradingActivity() throws Throwable {
        String tradeEvents = TestData.getValue("trade event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(tradeEvents));
        tradingActivityPage.getEventDetails(tradeEvents);
    }

    @When("^I select Trade Confirmation events from events dropdown$")
    public void iSelectTradeConfirmationEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String tradeEvents = TestData.getValue("utterance event");
        String tradeConfEvents = TestData.getValue("tradeConfirmation event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(tradeEvents).selectAllEvents(allEvents).selectEvent(tradeConfEvents).eventsSelector(tradeConfEvents);
    }

    @Then("^I should able to see 'Trade Confirmation' Trading activity$")
    public void iShouldAbleToSeeTradeConfirmationTradingActivity() throws Throwable {
        String tradeConfEvents = TestData.getValue("tradeConfirmation event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(tradeConfEvents));
        tradingActivityPage.getEventDetails(tradeConfEvents);
    }
    @When("^I select from date and time for Utterence$")
    public void iSelectFromDateAndTimeForUtterence() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().fromDate().getTimeForUtterances();
    }

    @When("^I select the date and time for Order Events$")
    public void iSelectTheDateAndTimeForOrderEvents() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().fromDate().getTimeForOrderEvents();
    }


    @When("^I select the date and time for FIX Order Events$")
    public void iSelectTheDateAndTimeForFIXOrderEvents() throws Throwable {
     tradingActivityPage = helper.getTradingActivityPage().fromDate().getTimeForFIXOrders();
    }

    @When("^I select FIX Order events from events dropdown$")
    public void iSelectFIXOrderEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("utterance event");
        String fixEvents = TestData.getValue("fix event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(utteranceEvents).selectAllEvents(allEvents).selectEvent(fixEvents).eventsSelector(fixEvents);
    }

    @Then("^I should able to see 'FIX Order' Trading activity$")
    public void iShouldAbleToSeeFIXOrderTradingActivity() throws Throwable {
        String fixEvents = TestData.getValue("fix event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(fixEvents));
        tradingActivityPage.getEventDetails(fixEvents);
    }

    @When("^I select the date and time for Settlement Events$")
    public void iSelectTheDateAndTimeForSettlementEvents() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().fromDate().getTimeForSettlement();
    }

    @When("^I select Settlement events from events dropdown$")
    public void iSelectSettlementEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("utterance event");
        String settlementEvents = TestData.getValue("settlement event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(utteranceEvents).selectAllEvents(allEvents).selectEvent(settlementEvents).eventsSelector(settlementEvents);
    }

    @Then("^I should able to see 'Settlement' Trading activity$")
    public void iShouldAbleToSeeSettlementTradingActivity() throws Throwable {
        String settlementEvents = TestData.getValue("settlement event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(settlementEvents));
        tradingActivityPage.getEventDetails(settlementEvents);
    }

    @When("^I select Warning events from events dropdown$")
    public void iSelectWarningEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("settlement event");
        String warningEvents = TestData.getValue("warning event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(utteranceEvents).selectAllEvents(allEvents).selectEvent(warningEvents).eventsSelector(warningEvents);
    }

    @Then("^I should able to see 'Warning' Trading activity$")
    public void iShouldAbleToSeeWarningTradingActivity() throws Throwable {
        String warningEvents = TestData.getValue("warning event");
        Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(warningEvents));
        tradingActivityPage.getEventType().getEventDescription();
    }

    @When("^I select the date and time for REST Price Taker Events$")
    public void iSelectTheDateAndTimeForRESTPriceTakerEvents() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().fromDate().getTimeForRESTPriceTaker();
    }

    @When("^I select REST Price Taker events from events dropdown$")
    public void iSelectRESTPriceTakerEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("utterance event");
        String restEvents = TestData.getValue("rest event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(utteranceEvents).selectAllEvents(allEvents).selectEvent(restEvents).eventsSelector(restEvents);

    }

    @Then("^I should able to see 'REST Price Taker' Trading activity$")
    public void iShouldAbleToSeeRESTPriceTakerTradingActivity() throws Throwable {
        String restTakerEvents = TestData.getValue("rest event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(restTakerEvents));
        tradingActivityPage.getEventDetails(restTakerEvents);
    }

    @When("^I select the date and time for FIX Price Maker Events$")
    public void iSelectTheDateAndTimeForFIXPriceMakerEvents() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().fromDate().getTimeForFIXPriceMaker();
    }

    @When("^I select FIX Price Maker events from events dropdown$")
    public void iSelectFIXPriceMakerEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("utterance event");
        String fixMakerEvents = TestData.getValue("fixMaker event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(utteranceEvents).selectAllEvents(allEvents).selectEvent(fixMakerEvents).eventsSelector(fixMakerEvents);
    }

    @Then("^I should able to see 'FIX Price Maker' Trading activity$")
    public void iShouldAbleToSeeFIXPriceMakerTradingActivity() throws Throwable {
        String fixMakerEvents = TestData.getValue("fixMaker event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(fixMakerEvents));
        tradingActivityPage.getEventDetails(fixMakerEvents);
    }

    @When("^I select the date and time for REST Price Maker Events$")
    public void iSelectTheDateAndTimeForRESTPriceMakerEvents() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().fromDate().getTimeForRestPriceMaker();
    }

    @When("^I select REST Price Maker events from events dropdown$")
    public void iSelectRESTPriceMakerEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("utterance event");
        String restMakerEvents = TestData.getValue("restMaker event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(utteranceEvents).selectAllEvents(allEvents).selectEvent(restMakerEvents).eventsSelector(restMakerEvents);
    }

    @Then("^I should able to see 'REST Price Maker' Trading activity$")
    public void iShouldAbleToSeeRESTPriceMakerTradingActivity() throws Throwable {
        String restMakerEvents = TestData.getValue("restMaker event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(restMakerEvents));
        tradingActivityPage.getEventDetails(restMakerEvents);
    }

    @When("^I select the date and time for CryptoBroker Bridge Events$")
    public void iSelectTheDateAndTimeForCryptoBrokerBridgeEvents() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().fromDate().getTimeForRestPriceMaker();
    }

    @When("^I select CryptoBroker Bridge events from events dropdown$")
    public void iSelectCryptoBrokerBridgeEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("utterance event");
        String restCBEvents = TestData.getValue("restCB event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(utteranceEvents).selectAllEvents(allEvents).selectEvent(restCBEvents).eventsSelector(restCBEvents);

    }

    @Then("^I should able to see 'CryptoBroker Bridge' Trading activity$")
    public void iShouldAbleToSeeCryptoBrokerBridgeTradingActivity() throws Throwable {
        String restCBEvents = TestData.getValue("restCB event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(restCBEvents));
        tradingActivityPage.getEventDetails(restCBEvents);
    }

    @When("^I select the date and time for FTX Bridge Events$")
    public void iSelectTheDateAndTimeForFTXBridgeEvents() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().fromDate().getTimeForRestPriceMaker();
    }

    @When("^I select FTX Bridge events from events dropdown$")
    public void iSelectFTXBridgeEventsFromEventsDropdown() throws Throwable {
        String allEvents = TestData.getValue("deselectAll events");
        String utteranceEvents = TestData.getValue("utterance event");
        String restFTXEvents = TestData.getValue("restFTX event");
        tradingActivityPage = helper.getTradingActivityPage().eventsSelector(utteranceEvents).selectAllEvents(allEvents).selectEvent(restFTXEvents).eventsSelector(restFTXEvents);
    }

    @Then("^I should able to see 'FTX Bridge' Trading activity$")
    public void iShouldAbleToSeeFTXBridgeTradingActivity() throws Throwable {
        String restFTXEvents = TestData.getValue("restFTX event");
        //Assert.assertTrue(tradingActivityPage.viewOrderEventsInList(restFTXEvents));
        tradingActivityPage.getEventDetails(restFTXEvents);
    }
}
