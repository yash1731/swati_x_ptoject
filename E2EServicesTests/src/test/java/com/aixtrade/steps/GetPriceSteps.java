package com.aixtrade.steps;

import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;

public class GetPriceSteps {

    private WorldHelper helper;
    private Response response;

    public GetPriceSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I request to get the spot price from the Market Data Service$")
    public void iRequestToGetTheSpotPriceFromTheMarketDataService() {
        helper.baseVerb().setUp();
    }

    @When("^I enter the \"([^\"]*)\" on the symbol field$")
    public void iEnterTheOnTheSymbolField(String symbol) {
        symbol = TestData.getValue(symbol);
        String endpoint = "/marketdata/price/" + symbol;
        response = helper.getVerb().getApi(endpoint);
    }

    @Then("^I should be able to get the spot price as requested which should contain:$")
    public void iShouldBeAbleToGetTheSpotPriceAsRequestedWhichShouldContain(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        String priceCurrency = TestData.getValue(data.get(1).get(1));
        String priceSource = TestData.getValue(data.get(2).get(1));

        String stringResponse = response.thenReturn().asString();
        JsonPath jsonPath = new JsonPath(stringResponse);

        String currency = jsonPath.get("priceData.currency");
        float price = jsonPath.get("priceData.price");
        String source = jsonPath.get("priceData.source");
        String time = jsonPath.get("priceData.generatedTimeStamp");

        System.out.println("Currency is "+currency);
        System.out.println("Price for the "+currency+ "is "+price);
        System.out.println("Source is from "+source);
        System.out.println("Generated timestamp is "+time);

        for (Header header : response.getHeaders())
            System.out.println(header);

        assertEquals(priceCurrency, currency);
        assertEquals(priceSource, source);
        assertEquals(response.statusCode(), 200);
        assertThat("The time entered is less than the expected time of " + response.getTime(), response.getTime(), lessThanOrEqualTo(2000L));
        assertEquals(response.getContentType(), "application/json;charset=UTF-8");
    }
}



