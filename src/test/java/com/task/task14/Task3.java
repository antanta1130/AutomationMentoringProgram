package com.task.task14;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 1.Initialize IE Driver
 * 2.Navigate to the interested web page for e.g. https://en.wikipedia.org/wiki/Main_Page
 * 3.Create a list of type WebElement to store all the Link elements in to it.
 * 4.Collect all the links from the web page. All the links are associated with the Tag 'a'.
 * 5.Now iterate through every link and print the Link Text on the console screen.
 * 
 */

public class Task3 {
    private WebDriver chromeDriver;
    private FluentWait<WebDriver> wait;
    private final String exePath = "C:\\Users\\Tetiana\\Documents\\AutomationMentoringProgram\\";
    private static final Logger log = LoggerFactory.getLogger(Task3.class);

    @Before
    public void createDriver() {
        System.setProperty("webdriver.chrome.chromeDriver", exePath + "chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        wait = new FluentWait<WebDriver>(chromeDriver);
        wait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);

    }

    @After
    public void quitDriver() {
        chromeDriver.quit();
    }

    @Test
    public void task3_collectLinks() {
    	log.info("task3.1: Collect all the links from the web page");
        chromeDriver.get("https://en.wikipedia.org/wiki/Main_Page");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("n-mainpage-description")));
        List<WebElement> links = chromeDriver.findElements(By.tagName("a"));
        for (WebElement element : links) {
        	log.info(element.getAttribute("href"));
        }
    }

}
