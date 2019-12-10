package com.qapitol.automationqa.apitest;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qapitol.automationqa.api.client.Accept;
import com.qapitol.automationqa.api.client.ApiClient;
import com.qapitol.automationqa.api.client.ApiMethod;
import com.qapitol.automationqa.api.client.ContentType;
import com.qapitol.automationqa.commons.Config;

public class SampleTest {
	
	Logger log = LogManager.getLogger(getClass());

	ApiClient client = new ApiClient();
	
	@Test
	public void testGetApi() throws ClientProtocolException, IOException {
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("page", "2");
		HttpResponse httpResponse = ApiClient.httpExecute("http://reqres.in", null, ApiMethod.GET, "/api/users", null, null, null, null, ContentType.APPLICATION_JSON, Accept.APPLICATION_JSON);
		log.info("Response:"+EntityUtils.toString(httpResponse.getEntity()));
	}
	
	@Test
		public void testPostApi2() throws ClientProtocolException, IOException {
			HttpResponse httpResponse = ApiClient.httpExecute("http://dummy.restapiexample.com", null, ApiMethod.POST, "/api/v1/create", null, null, "{\"name\":\"tes7868686t\",\"salary\":\"123\",\"age\":\"23\"}", null, ContentType.APPLICATION_JSON, Accept.APPLICATION_JSON);
			log.info("Response:"+EntityUtils.toString(httpResponse.getEntity()));
		}
	
	@Test
	public void testPostApi3() throws ClientProtocolException, IOException {
		String url = Config.getValue("baseUrl");
		log.info("Base url in config is:"+url);
	}
}
