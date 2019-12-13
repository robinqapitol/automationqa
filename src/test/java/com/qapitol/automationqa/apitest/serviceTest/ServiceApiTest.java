package com.qapitol.automationqa.apitest.serviceTest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qapitol.automationqa.api.client.ApiUtils;
import com.qapitol.automationqa.api.pojo.UserEntry;
import com.qapitol.automationqa.api.services.client.ServiceClient;

public class ServiceApiTest {
	
	Logger log = LogManager.getLogger(getClass());

	ServiceClient client = new ServiceClient();
	
	@Test
	public void tc_01_getTwoImageAndCompareAndVerify() throws ClientProtocolException, IOException {
		String user = "qapios";
		String password = "Qapitol@123";
		UserEntry userEntry = new UserEntry();
		userEntry.setUser(user);
		userEntry.setPassword(password);
		
		HttpResponse httpResponse =  client.doLogin(userEntry);
		String jsonString = ApiUtils.getEntityInString(httpResponse);
		log.info(jsonString);
		JSONObject jsonObject = new JSONObject(jsonString);
		JSONObject data  = jsonObject.getJSONObject("data");
		String userId = data.getString("userId");
		String authToken = data.getString("authToken");
		
		HttpResponse httpResponse2 = client.getRoom(authToken, userId);
		String roomResponseString = ApiUtils.getEntityInString(httpResponse2);
		log.info("Response is:"+roomResponseString);
		
	}
	
	

}
