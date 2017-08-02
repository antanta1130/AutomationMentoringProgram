package com.task.task14;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Task1 {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    @Before
    public void createDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tetiana\\Documents\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(5, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testLogin() {
        driver.get("https://facebook.com");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("tetkotova@gmail.com");

        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("1q2w3e4r5t");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("userNav")));

    }

}
