package com.aixtrade.steps;

import com.aixtrade.Streams.OrderStreams.OrderStreamData;
import com.aixtrade.Streams.OrderStreams.OrderStreamResponse;
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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.junit.Assert.*;

import java.util.List;


public class MatchSingleOrderSteps {

    private WorldHelper helper;
    private Response response;
    private String endpoint;
    private int statusCode;
    private JsonPath jsonPath;
    private String data;
    private StreamWorldHelper streamWorldHelper;

    public MatchSingleOrderSteps(WorldHelper helper, StreamWorldHelper streamWorldHelper) {
        this.helper = helper;
        this.streamWorldHelper = streamWorldHelper;
    }

    @Given("^I expect to receive the following stream updates$")
    public void iExpectToReceiveTheFollowingStreamUpdates(List<StreamUpdateCount> streamUpdateCounts) {
        streamWorldHelper.initCountDownLatch(
                streamUpdateCounts,
                "order",
                streamUpdateCount -> streamWorldHelper.initStreamCountDownLatch(streamUpdateCount.getCount()));
    }

    @When("^I create a matching SELL order as trader B - CreateSingleSellOrderMatchingBuyOrder$")
    public void iCreateAMatchingSELLOrderAsTraderBCreateSingleSellOrderMatchingBuyOrder() throws Throwable {
        helper.baseVerb().setUp();
        endpoint = TestData.getValue("order service");
        data = JsonReader.getData("06dCreateSingleSellOrderMatchingBuyOrder.json");
        response = helper.postVerb().postOnApi(endpoint, data);
        jsonPath = new JsonPath(response.thenReturn().asString());
    }

    @And("^I search for the executed SELL order - SearchCreateSingleSellOrderMatchingBuyOrder$")
    public void iSearchForTheExecutedSELLOrderSearchCreateSingleSellOrderMatchingBuyOrder() throws Throwable {
        endpoint = TestData.getValue("searchOrder service");
        data = JsonReader.getData("06eSearchCreateSingleSellOrderMatchingBuyOrder.json");
        response = helper.postVerb().postOnApi(endpoint, data);
    }

    @Then("^I should be able to see the SELL order with the order status as \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheSELLOrderWithTheOrderStatusAs(String arg0) throws Throwable {
        response = helper.postVerb().getResponse();
        statusCode = response.getStatusCode();
        jsonPath = new JsonPath(response.thenReturn().asString());
        assertEquals(statusCode, 200);
    }

    @And("^an order stream payload with the following$")
    public void anOrderStreamPayloadWithTheFollowing(List<OrderStreamData> expectedOrderUpdates) throws InterruptedException, JsonProcessingException {
        streamWorldHelper.awaitStreamCountDownLatch();
        List<OrderStreamResponse> actualOrderUpdates = streamWorldHelper.getOrderStreamUpdates();
        System.out.println("actual update is " + actualOrderUpdates);
        System.out.println("expected update is " + expectedOrderUpdates);
        streamWorldHelper.assertJsonObjectMatch(expectedOrderUpdates, actualOrderUpdates);
    }

    @When("^I submit a quote request via the Quote Service where order has been executed for trader A$")
    public void iSubmitAQuoteRequestViaTheQuoteServiceWhereOrderHasBeenExecutedForTraderA() throws Throwable {
        Thread.sleep(1000);
        endpoint = TestData.getValue("quote service");
        data = JsonReader.getData("002CreateQuoteRequest.json");
        response = helper.postVerb().postOnApi(endpoint, data);
    }

    @When("^I submit a quote request via the Quote Service where order has been executed for trader B$")
    public void iSubmitAQuoteRequestViaTheQuoteServiceWhereOrderHasBeenExecutedForTraderB() throws Throwable {
        Thread.sleep(1000);
        endpoint = TestData.getValue("quote service");
        data = JsonReader.getData("06aCreateQuoteTraderB.json");
        response = helper.postVerb().postOnApi(endpoint, data);
    }

    @When("^I create a matching BUY order as trader B - CreateSingleBuyOrderMatchingSellOrder$")
    public void iCreateAMatchingBUYOrderAsTraderBCreateSingleBuyOrderMatchingSellOrder() throws Throwable {
        helper.baseVerb().setUp();
        endpoint = TestData.getValue("order service");
        data = JsonReader.getData("06bCreateSingleBuyOrderMatchingSellOrder.json");
        response = helper.postVerb().postOnApi(endpoint, data);
    }

    @And("^I search for the executed BUY order - SearchCreateSingleBuyOrderMatchingSellOrder$")
    public void iSearchForTheExecutedBUYOrderSearchCreateSingleBuyOrderMatchingSellOrder() throws Throwable {
        endpoint = TestData.getValue("searchOrder service");
        data = JsonReader.getData("06cSearchCreate SingleBuyOrderMatchingSellOrder.json");
        response = helper.postVerb().postOnApi(endpoint, data);
    }

    @Then("^I should be able to see the BUY order with the order status as \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheBUYOrderWithTheOrderStatusAs(String arg0) throws Throwable {
        response = helper.postVerb().getResponse();
        statusCode = response.getStatusCode();
        jsonPath = new JsonPath(response.thenReturn().asString());
        assertEquals(statusCode, 200);
    }
}
