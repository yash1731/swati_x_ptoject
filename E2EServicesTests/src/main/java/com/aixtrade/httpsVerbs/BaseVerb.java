package com.aixtrade.httpsVerbs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseVerb {


    protected RequestSpecification requestSpecification;

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public RequestSpecification setUp() {
        requestSpecification = given().contentType("application/json").accept("application/json");
        return requestSpecification;
    }
}
