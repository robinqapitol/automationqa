package com.qapitol.automationqa.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutomationQA {
	public static AppiumDriver driver = null;
	
	@BeforeClass
	public static void getDriver() {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.APP, "chat.rocket.ios");
		ds.setCapability(MobileCapabilityType.UDID, "5105471cd626f9895d93de8b9d19365a602f8141");
		ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.2.2");
		ds.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "IPhone 7");
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		ds.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
		ds.setCapability(MobileCapabilityType.NO_RESET, true);
		ds.setCapability("connectHardwareKeyboard", false);
		try {
			driver = new IOSDriver(new URL("http://192.168.2.228:4723/wd/hub"), ds);
		} catch (MalformedURLException e) {
			log.error("Error while connecting to appium" + e.getMessage());
		}
	}
	
	@Step("Getting value by {type} on {selector}}")
	public static String getText(String type, String selector) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (type.equals("xpath")) {
			return driver.findElement(By.xpath(selector)).getText();
		} else if (type.equals("id")) {
			return driver.findElement(By.id(selector)).getText();
		} else if (type.equals("AccessibilityId")) {
			return driver.findElementByAccessibilityId(selector).getText();
		}
		else
			return null;
	}
	
	@Step("Clicking by {type} on {selector}}")
	public static void click(String type, String selector) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (type.equals("xpath")) {
			driver.findElement(By.xpath(selector)).click();
		} else if (type.equals("id")) {
			driver.findElement(By.id(selector)).click();
		} else if (type.equals("AccessibilityId")) {
			driver.findElementByAccessibilityId(selector).click();
		}
	}
	@Step("Enter by {type} on {selector}}")
	public static void enterText(String type, String selector, String keysToSend) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (type.equals("xpath")) {
			driver.findElement(By.xpath(selector)).sendKeys(keysToSend);
		} else if (type.equals("id")) {
			driver.findElement(By.id(selector)).sendKeys(keysToSend);
		} else if (type.equals("AccessibilityId")) {
			driver.findElementByAccessibilityId(selector).sendKeys(keysToSend);
		}
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
