package com.aixtrade.steps;

import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.*;

public class CancelOrdersSteps {

    private WorldHelper helper;
    private Response response;

    public CancelOrdersSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I cancel order$")
    public void iCancelOrder() throws InterruptedException {
        String endpoint = TestData.getValue("order service");
        String orderId = helper.getOrderIdControl().getOrderId();
        String endpoint2 = endpoint + "/" + orderId;
        Thread.sleep(5000);
        response = helper.deleteVerb().deleteOnApi(endpoint2, null);
    }

    @Then("^I should be able to see order cancelled$")
    public void iShouldBeAbleToSeeOrderCancelled() {
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }
}
