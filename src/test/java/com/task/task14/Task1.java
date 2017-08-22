package com.task.task14;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/*
 * 1.Launch new Browser
 * 2.Open URL http://facebook.com
 * 3.Type Login 
 * 4.Type Password 
 * 5.Click on ¬ход button
 * 6.Check that you have logged in
 * 7.Close the Browser
 */

public class Task1 {

    private WebDriver chromeDriver;
    private FluentWait<WebDriver> wait;
    private final String exePath = "C:\\Users\\Tetiana\\Documents\\AutomationMentoringProgram\\";
    private static final Logger log = LoggerFactory.getLogger(Task1.class);

    @Before
    public void createDriver() {
        System.setProperty("webdriver.chrome.chromeDriver", exePath + "chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        wait = new FluentWait<WebDriver>(chromeDriver);
        wait.withTimeout(5, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
    }

    @After
    public void quitDriver() {
        chromeDriver.quit();
    }

    @Test
    public void task1_testLogin() {
    	log.info("task1.1: http://facebook.com, check that you have logged in");
        chromeDriver.get("https://facebook.com");

        chromeDriver.findElement(By.id("email")).clear();
        chromeDriver.findElement(By.id("email")).sendKeys("tetkotova@gmail.com");

        chromeDriver.findElement(By.id("pass")).clear();
        chromeDriver.findElement(By.id("pass")).sendKeys("1q2w3e4r5t");

        chromeDriver.findElement(By.xpath("//input[@type='submit']")).click();
        
        try{
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='blueBarDOMInspector']//a[@data-testid='blue_bar_profile_link']/span")));
        } catch(NoSuchElementException ex){
        	log.equals(ex.getMessage());
        	Assert.fail();
        }

    }

}
