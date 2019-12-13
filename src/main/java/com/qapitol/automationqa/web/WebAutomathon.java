package com.qapitol.automationqa.web;

import com.qapitol.automationqa.commons.validator.ValidateFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class WebAutomathon {
    Logger log = LogManager.getLogger(getClass());
    String url;
    WebDriver driver;
    ValidateFiles validatefiles = new ValidateFiles();
    Commons commons=new Commons();
    @BeforeTest
    public void setUp() throws Exception {
        commons.setUp();
    }
    @Test
    public void validateDownlodedImages() {
        driver.findElement(By.xpath("//a[@href='/group/automatahon2019']")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//a[@href='/file-upload/MiLtoF4GNFZ6vCZxh/AutomATAhon2019.jpg']")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//a[@href='/file-upload/7sybTvFPjhmRpdamy/AutomATAhon2019%20image%20L.jpg']")).click();
        // validatefiles.assertFilesAreCommon("http://101.53.157.237:3000/file-upload/MiLtoF4GNFZ6vCZxh/AutomATAhon2019.jpg?download","http://101.53.157.237:3000/7sybTvFPjhmRpdamy/AutomATAhon2019%20image%20L.jpg/AutomATAhon2019.jpg?download");
    }
    @Test
    public void validateChannelCreation() {
        driver.findElement(By.xpath("//button[@aria-label='Create new']")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("  //span[@class='rc-popover__item-text' and text()= 'Channel']")).click();
    }
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}