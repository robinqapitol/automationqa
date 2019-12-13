package com.qapitol.automationqa.mobile.feature;


import com.qapitol.automationqa.mobile.steps.Steps;

import io.qameta.allure.Step;

public class Feature extends Steps {

	@Step("Connecting Server")
	public void gotoConnectServer() {
		clickOnConnectServer();
		
	}

	@Step("Entering Credentials")
	public void enterCredentials() {
		enterServerDetail();
		enterUsername();
		enterPassword();
	}
	
	@Step("Entering Credentials")
	public void enterAutomatahon() {
		clickOnAutomatahon();
	}
	
}
