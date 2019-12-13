package com.qapitol.automationqa.api.client;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

public class Processor {

    public HttpResponse get() throws IOException {
        HttpResponse httpResponse = ApiClient.httpExecute("http://reqres.in", null, ApiMethod.GET, "/api/users", null, null, null, null, ContentType.APPLICATION_JSON, Accept.APPLICATION_JSON);
        return httpResponse;
    }
    public HttpResponse get(String hostName, Map<String, String> headers, String endPoint,
                            Map<String, String> pathParams, Map<String, String> queryParams, String payload, Map<String, Object> form,
                            ContentType contentType, Accept accept) throws IOException {
        HttpResponse httpResponse = ApiClient.httpExecute("http://reqres.in", null, ApiMethod.GET, "/api/users", null, null, null, null, ContentType.APPLICATION_JSON, Accept.APPLICATION_JSON);
        return httpResponse;
    }

}
