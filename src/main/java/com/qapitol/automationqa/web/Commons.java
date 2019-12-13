package com.qapitol.automationqa.web;

import com.qapitol.automationqa.commons.validator.ValidateFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Commons {
    Logger log = LogManager.getLogger(getClass());
    String url;
    WebDriver driver;
    ValidateFiles validatefiles = new ValidateFiles();

    public void setUp() throws Exception {
        url="http://101.53.157.237:3000/home";
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/BrowserDrivers/ChromeDriverMac");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//input[@id='emailOrUsername']")).sendKeys("qapios");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Qapitol@123");
        driver.findElement(By.xpath("//button[@class='rc-button rc-button--primary login']")).click();
    }
}
