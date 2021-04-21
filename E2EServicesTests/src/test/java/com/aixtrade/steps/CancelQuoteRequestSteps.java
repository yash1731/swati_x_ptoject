package com.aixtrade.steps;

import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class CancelQuoteRequestSteps {

    private WorldHelper helper;
    private Response response;
    private JsonPath jsonPath;
    private static int quoteRequestId;

    public CancelQuoteRequestSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Then("^I can get the Quote Request id for the bid$")
    public void iCanGetTheQuoteRequestIdForTheBid() {
        response = helper.postVerb().getResponse();
        jsonPath = new JsonPath(response.thenReturn().asString());
        quoteRequestId = jsonPath.get("quoteRequest.quoteRequestId");
        System.out.println("Quote request id is " + quoteRequestId);
        helper.getQuoteRequestIdControl().storeQuoteRequestId(quoteRequestId);
    }

    @When("^I cancel the quote request$")
    public void iCancelTheQuoteRequest() {
        String baseEndpoint = TestData.getValue("quoteService baseUrl");
        String uri = TestData.getValue("cancelQuoteRequest service");
        String endpoint = baseEndpoint + uri +"/" +quoteRequestId;
        response = helper.deleteVerb().deleteOnApi(endpoint, null);
    }

    @Then("^I should be able to see the quote request cancelled$")
    public void iShouldBeAbleToSeeTheQuoteRequestCancelled() {
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }
}
