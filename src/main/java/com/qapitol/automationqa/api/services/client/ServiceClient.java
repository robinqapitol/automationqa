package com.qapitol.automationqa.api.services.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qapitol.automationqa.api.client.Accept;
import com.qapitol.automationqa.api.client.ApiClient;
import com.qapitol.automationqa.api.client.ApiMethod;
import com.qapitol.automationqa.api.client.ApiUtils;
import com.qapitol.automationqa.api.client.ContentType;
import com.qapitol.automationqa.api.pojo.UserEntry;
import com.qapitol.automationqa.api.pojo.UserResponse;
import com.qapitol.automationqa.commons.Config;

public class ServiceClient {
	
	Logger log = LogManager.getLogger(getClass());

	public HttpResponse doLogin(UserEntry userentry) throws ClientProtocolException, IOException {
		HttpResponse httpResponse = null;
		String stringUserentry = null;
		ObjectMapper objectMapper = new ObjectMapper();
		stringUserentry = objectMapper.writeValueAsString(userentry);
		log.info("request is:"+stringUserentry);
		httpResponse = ApiClient.httpExecute(Config.getValue("baseUrl"), null, ApiMethod.POST,
				"/api/v1/login", null, null, stringUserentry, null, ContentType.APPLICATION_JSON,
				Accept.APPLICATION_JSON);
		//userResponse = ApiUtils.convertJsonStringToPojoObject(ApiUtils.getEntityInString(httpResponse),
		//		UserResponse.class);
		return httpResponse;
	}
	
	public HttpResponse getRoom(String xAuthTocken, String xUserId) throws ClientProtocolException, IOException {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Auth-Token", xAuthTocken);
		headers.put("X-User-Id", xUserId);
		HttpResponse httpResponse = ApiClient.httpExecute(Config.getValue("baseUrl"), headers, ApiMethod.GET,
				"/api/v1/rooms.get", null, null, null, null, null,
				Accept.APPLICATION_JSON);
		
		return httpResponse;
	}

}
