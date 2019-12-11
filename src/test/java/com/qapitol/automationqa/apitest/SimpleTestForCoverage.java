package com.qapitol.automationqa.apitest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qapitol.automationqa.api.client.ApiClient;
import com.qapitol.automationqa.api.client.ApiMethod;
import com.qapitol.automationqa.commons.Config;

public class SimpleTestForCoverage {

	Logger log = LogManager.getLogger(getClass());

	String baseUrl = null;

	@BeforeClass
	public void getBaseUrl() throws IOException {
		baseUrl = Config.getValue("baseUrl");
	}

	@Test
	public void testHealth() throws ClientProtocolException, IOException {
		HttpResponse httpResponse = ApiClient.httpExecute(baseUrl, null, ApiMethod.GET,
				"/simplerestapp/v1/base/healthCheck", null, null, null, null, null, null);
		log.info("Response:" + EntityUtils.toString(httpResponse.getEntity()));
	}

	@Test
	public void testallAccounts() throws ClientProtocolException, IOException {
		HttpResponse httpResponse = ApiClient.httpExecute(baseUrl, null, ApiMethod.GET,
				"/simplerestapp/v1/accounts/all", null, null, null, null, null, null);
		log.info("Response:" + EntityUtils.toString(httpResponse.getEntity()));
	}

	@Test
	public void testSingleAccounts() throws ClientProtocolException, IOException {
		HttpResponse httpResponse = ApiClient.httpExecute(baseUrl, null, ApiMethod.GET, "/simplerestapp/v1/accounts/2",
				null, null, null, null, null, null);
		log.info("Response:" + EntityUtils.toString(httpResponse.getEntity()));
	}

}
