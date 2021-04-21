package com.aixtrade.httpsVerbs;

import io.restassured.response.Response;

public class DeleteVerb extends BaseVerb {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public Response deleteOnApi(String uri, Object body) {
        response = setUp().delete(uri);
        return response;
    }
}
