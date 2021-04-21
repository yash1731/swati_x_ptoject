package com.aixtrade.steps;

import com.aixtrade.QuoteSchemaModel.QuoteRequest;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.EnvConfig;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class APITestSteps {

    private WorldHelper helper;
    private Response response;
    private JsonPath jsonPath;

    public APITestSteps (WorldHelper helper)  {
        this.helper = helper;
    }


    @Given("^I create a Quote Request$")
    public void iCreateAQuoteRequest() {
        String timeInSecs = TestData.getValue("time secs");
        String quantity = TestData.getValue("requested quantity");
        String symbol = TestData.getValue("requested.symbol");
        String trader = TestData.getValue("trader id");
        String endpoint = EnvConfig.getValue("quoteRequest uri");

        QuoteRequest quoteRequest = new QuoteRequest();
        quoteRequest.setExpirationInSeconds(timeInSecs);
        quoteRequest.setQuantity(quantity);
        quoteRequest.setSymbol(symbol);
        quoteRequest.setTrader(trader);
        response = helper.verbs().postOnApi(endpoint, null);
        jsonPath = new JsonPath(response.thenReturn().asString());
    }

    @Then("^I can see quote request created$")
    public void iCanSeeQuoteRequestCreated() {
    }
}
