package com.aixtrade.steps;

import com.aixtrade.SchemaModel.QuoteResponse;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.Assert.*;

public class AcceptQuoteExistingOrderSteps {

    private WorldHelper helper;
    private Response response;
    private JsonPath jsonPath;
    private static int quoteId;


    public AcceptQuoteExistingOrderSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Then("^I can get the Quote id for the bid$")
    public void iCanGetTheQuoteIdForTheBid() {
        response = helper.postVerb().getResponse();
        jsonPath = new JsonPath(response.thenReturn().asString());
        quoteId = jsonPath.get("quoteRequest.latestQuote.quoteId");
        System.out.println("Quote id is " + quoteId);
        helper.getQuoteIdControl().storeQuoteId(quoteId);
    }

    @When("^I accept the bid by creating a Quote Response for an offer as below:$")
    public void iAcceptTheBidByCreatingAQuoteResponseForAnOfferAsBelow(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        String timeInSecs = TestData.getValue(data.get(1).get(1));
        String offerPrice = TestData.getValue(data.get(2).get(1));
        String offerQuantity = TestData.getValue(data.get(3).get(1));
        String symbol = TestData.getValue(data.get(4).get(1));
        String type = TestData.getValue(data.get(5).get(1));
        String userId = TestData.getValue(data.get(6).get(1));
        String endpoint = TestData.getValue("quoteService quoteResponse");

        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setExpirationInSeconds(timeInSecs);
        quoteResponse.setOfferPrice(offerPrice);
        quoteResponse.setOfferQuantity(offerQuantity);
        quoteResponse.setSymbol(symbol);
        quoteResponse.setType(type);
        quoteResponse.setUserId(userId);
        quoteResponse.setQuoteId(quoteId);
        response = helper.postVerb().postOnApi(endpoint, quoteResponse);
    }

    @Then("^I should be able to see order executed$")
    public void iShouldBeAbleToSeeOrderExecuted() {
        int statusCode = response.getStatusCode();
        assertEquals(201, statusCode);
    }

    @When("^I accept the bid by creating a Quote Response for a bid as below:$")
    public void iAcceptTheBidByCreatingAQuoteResponseForABidAsBelow(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        String timeInSecs = TestData.getValue(data.get(1).get(1));
        String bidPrice = TestData.getValue(data.get(2).get(1));
        String bidQuantity = TestData.getValue(data.get(3).get(1));
        String symbol = TestData.getValue(data.get(4).get(1));
        String type = TestData.getValue(data.get(5).get(1));
        String userId = TestData.getValue(data.get(6).get(1));

        String endpoint = TestData.getValue("quoteService quoteResponse");
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setExpirationInSeconds(timeInSecs);
        quoteResponse.setBidPrice(bidPrice);
        quoteResponse.setBidQuantity(bidQuantity);
        quoteResponse.setSymbol(symbol);
        quoteResponse.setType(type);
        quoteResponse.setUserId(userId);
        quoteResponse.setQuoteId(quoteId);
        response = helper.postVerb().postOnApi(endpoint, quoteResponse);
    }
}
