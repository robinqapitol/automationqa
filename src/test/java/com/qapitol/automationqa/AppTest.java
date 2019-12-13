package com.qapitol.automationqa;

import org.testng.annotations.Test;

import com.qapitol.automationqa.mobile.feature.Feature;

public class AppTest extends Feature {

	@Test(description = "Valid Login")
	public void testValidLogin() {
		gotoConnectServer();
		enterCredentials();
		enterAutomatahon();
	}
}