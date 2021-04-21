package com.aixtrade.hooks;


import com.aixtrade.OrderControl.OrderIdControl;
import com.aixtrade.Streams.StreamWorldHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;


public class ScenarioHooks {

    @Before(order = 2)
    public void beforeTests() {
        RestAssured.baseURI = "https://qa-marketdata-service.private.apps.pcf.ai-x.ai";
        OrderIdControl.resetOrderIds();
        StreamWorldHelper.resetOrderUpdates();
        StreamWorldHelper.resetQuoteUpdates();
    }

    @After(value = "@cancelOrder", order = 0)
    public void afterCancel() {
        OrderIdControl.deleteOrderIds();
    }
}
