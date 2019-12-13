package com.qapitol.automationqa.webTest;

import com.qapitol.automationqa.commons.validator.ValidateFiles;
import com.qapitol.automationqa.web.Commons;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    String channel="qapios";
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
    public void validateSameChannelCannotbeCreated() {
        driver.findElement(By.xpath("//button[@aria-label='Create new']")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath(" //span[@class='rc-popover__item-text' and text()= 'Channel']")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//input[@class='rc-input__element']")).sendKeys("teamqapios");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//div[text()='The channel already exists.']")).isDisplayed();
    }

    @Test
    public void testName() throws InterruptedException {
        String avatar="//*[@id=\"rocket-chat\"]/aside/header/div[1]/div[1]/img";
        String myAccount="//html/body/div[8]/div/div/ul[3]/li[1]/span[2]";
        String profile="//*[@id=\"rocket-chat\"]/aside/div[4]/aside/div/ul/li[2]/a/div[2]/div/div[1]/div/div";
       // String upload="//*[@id=\"profile\"]/fieldset[1]/div/div[1]/div/div[2]/div[2]/label";
        String upload="//label[@class='rc-select-avatar__upload-label avatar']";
        String filePath="./src/main/resources/myPhoto.jpeg";
        commons.clickOnXpath(avatar);
        commons.clickOnXpath(myAccount);
        commons.clickOnXpath(profile);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement((By.xpath(upload))).click();
    }

    @Test
    public void testTask5() throws InterruptedException {
        String channelQapios="//*[@id=\"rocket-chat\"]/aside/div[2]/ul[2]/li[6]/a";
        String messageBox="//*[@id=\"chat-window-vLZG94AD8HzdfRton\"]/div/div/footer/div/label/textarea";
        String smily="//*[@id=\"chat-window-vLZG94AD8HzdfRton\"]/div/div/footer/div/label/span[1]/svg";
        String smile="/html/body/div[8]/div[3]/ul[3]/li[2]/span";
        commons.clickOnXpath(channelQapios);
        commons.clickOnXpath(smily);
        commons.clickOnXpath(smile);
        commons.sendTextOnXpath(messageBox,"hey there i  m cool");
    }
    @Test
    public void validateDiscussionCreation() {
        driver.findElement(By.xpath("//button[@aria-label='Create new']")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//span[@class='rc-popover__item-text' and text()='Discussion']")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//input[@id='parentChannel']")).sendKeys("teamqapios");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//input[@name='discussion_name']")).sendKeys("test123");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//button[@form='create-discussion']")).click();
    }

    @AfterClass
    public void tearDown() throws Exception {
//        driver.quit();
    }
}