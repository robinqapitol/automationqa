package com.qapitol.automationqa.mobile.steps;

import com.qapitol.automationqa.mobile.AutomationQA;
import com.qapitol.automationqa.mobile.po.PageObject;

import io.qameta.allure.Step;

public class Steps extends AutomationQA {

	@Step("Clicking on Connect Server")
	public static void clickOnConnectServer() {
		click("AccessibilityId", PageObject.CONNECT_SERVER);
	}

	@Step("Entering New Server Details")
	public static void enterServerDetail() {
		enterText("AccessibilityId", PageObject.NEW_SERVER, "http://101.53.157.237:3000/");
	}

	@Step("Entering username")
	public static void enterUsername() {
		enterText("AccessibilityId", PageObject.USERNAME, "qapios");
		
	}

	@Step("Entering Password")
	public static void enterPassword() {
		enterText("AccessibilityId", PageObject.PASSWORD, "Qapitol@123");
	}
	
	@Step("Clicking on Login Button")
	public static void clickOnLogin() {
		click("AccessibilityId", PageObject.LOGIN);
	}
	
	@Step("Clicking on automatahon2019")
	public static void clickOnAutomatahon() {
		click("AccessibilityId", PageObject.AUTOMATAHON);
	}
	
}
