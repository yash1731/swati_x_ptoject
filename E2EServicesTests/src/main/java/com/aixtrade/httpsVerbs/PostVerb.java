package com.aixtrade.httpsVerbs;

import io.restassured.response.Response;

public class PostVerb extends BaseVerb {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public Response postOnApi(String uri, Object body) {
        response = setUp().body(body).post(uri);
        return response;
    }
}
