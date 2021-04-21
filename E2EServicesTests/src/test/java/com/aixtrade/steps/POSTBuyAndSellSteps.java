package com.aixtrade.steps;

import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;

public class POSTBuyAndSellSteps {

    private WorldHelper helper;

    public POSTBuyAndSellSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Then("^I should get the quote which should contain a bid and an offer value$")
    public void iShouldGetTheQuoteWhichShouldContainABidAndAnOfferValue() {
        Response response = helper.postVerb().getResponse();
        int statusCode = response.getStatusCode();
        JsonPath jsonPath = new JsonPath(response.thenReturn().asString());

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
        assertNotNull(bidPrice);
        assertNotNull(offerPrice);
        assertEquals(response.getContentType(), "application/json;charset=UTF-8");
        assertThat("The time entered is less than the expected time of " + response.getTime(), response.getTime(), lessThanOrEqualTo(3500L));
    }
}
