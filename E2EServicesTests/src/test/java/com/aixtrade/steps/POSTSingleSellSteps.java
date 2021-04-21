package com.aixtrade.steps;

import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.JsonReader;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class POSTSingleSellSteps {

    private WorldHelper helper;
    private Response response;
    private JsonPath jsonPath;

    public POSTSingleSellSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I create a Single SELL order as market maker A - createSingleOrderSell$")
    public void iCreateASingleSELLOrderAsMarketMakerACreateSingleOrderSell() throws Throwable {
        helper.baseVerb().setUp();
        String endpoint = TestData.getValue("order service");
        String data = JsonReader.getData("04aCreateSingleOrderSell.json");
        response = helper.postVerb().postOnApi(endpoint, data);
        jsonPath = new JsonPath(response.thenReturn().asString());
        String orderId = jsonPath.get("order.id");
        helper.getOrderIdControl().storeOrderId(orderId);
    }

    @Then("^I should be able to get the details of the new order - Sell$")
    public void iShouldBeAbleToGetTheDetailsOfTheNewOrderSell() {
        int statusCode = response.getStatusCode();
        jsonPath = new JsonPath(response.thenReturn().asString());

        String symbol = jsonPath.get("order.symbol");
        float price = jsonPath.get("order.price");
        int quantity = jsonPath.get("order.quantity");
        String side = jsonPath.get("order.side");
        int originalQuantity = jsonPath.get("order.originalQuantity");
        int liveQuantity = jsonPath.get("order.liveQuantity");
        int executionQuantity = jsonPath.get("order.executionQuantity");
        String orderId = jsonPath.get("order.id");

        System.out.println("OrderData currency is "+symbol);
        System.out.println("Price for the order is "+ price);
        System.out.println("OrderData quantity is "+quantity);
        System.out.println("OrderData side is "+side);
        System.out.println("Original OrderData quantity is "+originalQuantity);
        System.out.println("Live OrderData quantity is "+liveQuantity);
        System.out.println("Execution quantity is "+executionQuantity);
        System.out.println("OrderData Id is "+orderId);

        assertEquals(201, statusCode);
        assertEquals(response.getContentType(), "application/json;charset=UTF-8");
        assertThat("The time entered is less than the expected time of " + response.getTime(), response.getTime(), lessThanOrEqualTo(3500L));
    }

    @Then("^I should get the quote which should contain an offer and an empty bid$")
    public void iShouldGetTheQuoteWhichShouldContainAnOfferAndAnEmptyBid() {
        response = helper.postVerb().getResponse();
        int statusCode = response.getStatusCode();
        jsonPath = new JsonPath(response.thenReturn().asString());

        int quantity = jsonPath.get("quoteRequest.latestQuote.quantity");
        String symbol = jsonPath.get("quoteRequest.latestQuote.symbol");
        String quoteStatus = jsonPath.get("quoteRequest.latestQuote.status");
        Float bidPrice = jsonPath.get("quoteRequest.latestQuote.bid.price");
        Float offerPrice = jsonPath.get("quoteRequest.latestQuote.offer.price");

        System.out.println("Quote quantity is "+quantity);
        System.out.println("Quote currency is "+symbol);
        System.out.println("Quote bid price is "+bidPrice);
        System.out.println("Quote offer price is "+offerPrice);
        System.out.println("Quote status is "+quoteStatus);

        assertEquals(statusCode, 201);
        assertNull(bidPrice);
        assertNotNull(offerPrice);
        assertEquals(response.getContentType(), "application/json;charset=UTF-8");
        assertThat("The time entered is less than the expected time of " + response.getTime(), response.getTime(), lessThanOrEqualTo(3500L));
    }
}
