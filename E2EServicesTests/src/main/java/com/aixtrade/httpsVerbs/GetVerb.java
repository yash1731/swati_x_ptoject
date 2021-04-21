package com.aixtrade.httpsVerbs;


import io.restassured.response.Response;


public class GetVerb extends BaseVerb {


    private Response response;


    public Response getResponse() {
        return response;
    }

    public Response getApi(String uri) {
        response = setUp().get(uri);
        return response;
    }
}
