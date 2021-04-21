package com.aixtrade.steps;

import com.aixtrade.Streams.QuoteStreams.QuoteRequestStreamData;
import com.aixtrade.Streams.QuoteStreams.QuoteStreamResponse;
import com.aixtrade.Streams.StreamUpdateCount;
import com.aixtrade.Streams.StreamWorldHelper;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.JsonReader;
import com.aixtrade.utilities.TestData;
import com.fasterxml.jackson.core.JsonProcessingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.util.List;

public class RequestNegotiationsExistingOrdersSteps {

    private WorldHelper helper;
    private Response response;
    private StreamWorldHelper streamWorldHelper;

    public RequestNegotiationsExistingOrdersSteps(WorldHelper helper, StreamWorldHelper  streamWorldHelper) {
        this.helper = helper;
        this.streamWorldHelper = streamWorldHelper;
    }

    @Given("^I expect to receive the following quote stream updates$")
    public void iExpectToReceiveTheFollowingQuoteStreamUpdates(List<StreamUpdateCount> streamUpdateCounts) {
        streamWorldHelper.initCountDownLatch(
                streamUpdateCounts,
                "quote",
                streamUpdateCount -> streamWorldHelper.initStreamCountDownLatch(streamUpdateCount.getCount()));
    }

    @When("^I then submit a quote request via the Quote Service within the existing order limit$")
    public void iThenSubmitAQuoteRequestViaTheQuoteServiceWithinTheExistingOrderLimit() throws Throwable {
        Thread.sleep(1000);
        String endpoint = TestData.getValue("quote service");
        String data = JsonReader.getData("002CreateQuoteRequest.json");
        response = helper.postVerb().postOnApi(endpoint, data);
    }

    @And("^a quote request stream payload with the following$")
    public void aQuoteRequestStreamPayloadWithTheFollowing(List<QuoteRequestStreamData> expectedQuoteUpdates) throws InterruptedException, JsonProcessingException {
        streamWorldHelper.awaitStreamCountDownLatch();
        List<QuoteStreamResponse> actualQuoteUpdates = streamWorldHelper.getQuoteStreamUpdates();
        System.out.println("actual update is " + actualQuoteUpdates);
        System.out.println("expected update is " + expectedQuoteUpdates);
        streamWorldHelper.assertJsonObjectMatch(expectedQuoteUpdates, actualQuoteUpdates);
    }

    @When("^I create a second quote request within the existing order limit$")
    public void iCreateASecondQuoteRequestWithinTheExistingOrderLimit() throws Throwable{
        String endpoint = TestData.getValue("quote service");
        String data = JsonReader.getData("002CreateQuoteRequest.json");
        response = helper.postVerb().postOnApi(endpoint, data);
    }

    @Then("^I should still get the same quote for existing orders$")
    public void iShouldStillGetTheSameQuoteForExistingOrders() {
    }
}
