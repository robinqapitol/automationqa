package com.qapitol.automationqa.apitest.serviceTest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qapitol.automationqa.api.pojo.UserEntry;
import com.qapitol.automationqa.api.pojo.UserResponse;
import com.qapitol.automationqa.api.services.client.ServiceClient;

public class TestService {
	
	ServiceClient client = new ServiceClient();
	
	@Test
	public void CheckImage() throws ClientProtocolException, IOException {
		String user = "qapios";
		String password = "Qapitol@123";
		UserEntry userEntry = new UserEntry();
		userEntry.setUser(user);
		userEntry.setPassword(password);
		
		UserResponse userResponse =  client.doLogin(userEntry);
		
		//userResponse.ge
		
		
	}

}
