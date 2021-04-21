package com.aixtrade.QuoteSchemaModel;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class HttpVerbs {


    protected RequestSpecification requestSpecification;
    private Response response;

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public Response getResponse() {
        return response;
    }

    public RequestSpecification setUp() {
        requestSpecification = given().contentType("application/json").accept("application/json");
        return requestSpecification;
    }

    public Response postOnApi(String uri, Object body) {
        response = setUp().body(body).post(uri);
        return response;
    }

    public Response getApi(String uri) {
        response = setUp().get(uri);
        return response;
    }

    public Response deleteOnApi(String uri, Object body) {
        response = setUp().delete(uri);
        return response;
    }
}
