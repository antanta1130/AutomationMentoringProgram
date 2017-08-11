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



public class Task4 {
    private WebDriver chromeDriver;
    private FluentWait<WebDriver> wait;
    private final String exePath = "D:\\AutomationMentoringProgram\\";

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
    public void task4_collectLinks() {
    	chromeDriver.get("https://en.wikipedia.org/wiki/Main_Page");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("n-mainpage-description")));
        List<WebElement> links = chromeDriver.findElements(By.tagName("a"));
        for (WebElement element : links) {
            System.out.println(element.getAttribute("href"));
        }
    }

}
