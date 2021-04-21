package com.aixtrade.steps;

import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.JsonReader;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;


public class POSTNoQuoteSteps {

    private WorldHelper helper;
    private Response response;
    private String endpoint;

    public POSTNoQuoteSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I have received the spot price for a \"([^\"]*)\" from the Market Data Service$")
    public void iHaveReceivedTheSpotPriceForAFromTheMarketDataService(String symbol) throws Throwable {
        helper.baseVerb().setUp();
        symbol = TestData.getValue(symbol);
        String marketDataURI = TestData.getValue("marketData service");
        endpoint = marketDataURI + symbol;
        response = helper.getVerb().getApi(endpoint);
    }

    @When("^I submit a quote request via the Quote Service where there exists no order for that symbol$")
    public void iSubmitAQuoteRequestViaTheQuoteServiceWhereThereExistsNoOrderForThatSymbol() throws Throwable {
        Thread.sleep(1000);
        endpoint = TestData.getValue("quote service");
        String data = JsonReader.getData("002CreateQuoteRequest.json");
        response = helper.postVerb().postOnApi(endpoint, data);
    }

    @Then("^I should get the quote which should contain an empty bid and an empty offer value with a status of \"([^\"]*)\"$")
    public void iShouldGetTheQuoteWhichShouldContainAnEmptyBidAndAnEmptyOfferValueWithAStatusOf(String status) throws Throwable {
        response = helper.postVerb().getResponse();
        int statusCode = response.getStatusCode();
        JsonPath jsonPath = new JsonPath(response.thenReturn().asString());

        int quantity = jsonPath.get("quoteRequest.latestQuote.quantity");
        String symbol = jsonPath.get("quoteRequest.latestQuote.symbol");
        String quoteStatus = jsonPath.get("quoteRequest.latestQuote.status");
        String trader = jsonPath.get("quoteRequest.trader");
        Float bidPrice = jsonPath.get("quoteRequest.latestQuote.bid.price");
        Boolean bidQuote = jsonPath.get("quoteRequest.latestQuote.bid.isQuote");
        Float offerPrice = jsonPath.get("quoteRequest.latestQuote.offer.price");
        Boolean offerQuote = jsonPath.get("quoteRequest.latestQuote.offer.isQuote");

        System.out.println("Quote quantity is "+ quantity);
        System.out.println("Quote currency is "+ symbol);
        System.out.println("Trader is "+trader);

        response.getContentType();
        response.header("Connections");
        response.getCookies();

        for (Header header : response.getHeaders())
            System.out.println(header);

        assertEquals(statusCode, 201);
        assertNull(bidPrice);
        assertNull(bidQuote);
        assertNull(offerPrice);
        assertNull(offerQuote);
        assertEquals(status, quoteStatus);
        assertEquals(response.getContentType(), "application/json;charset=UTF-8");
        assertThat("The time entered is less than the expected time of " + response.getTime(), response.getTime(), lessThanOrEqualTo(3500L));
    }
}

