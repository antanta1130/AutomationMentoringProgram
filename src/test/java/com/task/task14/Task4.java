package com.task.task14;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Task4 {
    private WebDriver internetExplorerDriver;
    private FluentWait<WebDriver> wait;
    private final String exePath = "C:\\Users\\Tetiana\\Documents\\AutomationMentoringProgram\\";

    @Before
    public void createDriver() {
        System.setProperty("webdriver.ie.driver", exePath + "IEDriverServer.exe");
        internetExplorerDriver = new InternetExplorerDriver();
        internetExplorerDriver.manage().window().maximize();

        wait = new FluentWait<WebDriver>(internetExplorerDriver);
        wait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);

    }

    @After
    public void quitDriver() {
        internetExplorerDriver.quit();
    }

    /*
     * Cannot find any elements in Selenium using Internet Explorer Driver
     *
     * For those experiencing the issue on IE11, here is why: Microsoft released
     * update KB3025390 via Windows Update[1] as part of its normal
     * "patch Tuesday" update cycle. For most users, this update is downloaded
     * and installed without user interaction. This update breaks the IE driver
     * when using it with IE11.
     * https://groups.google.com/forum/m/#!topic/selenium-users/TdY_rRNF-gw
     */

    @Test
    public void task4_collectLinks_IE() {
        internetExplorerDriver.get("https://en.wikipedia.org/wiki/Main_Page");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#n-mainpage-description")));
        List<WebElement> links = internetExplorerDriver.findElements(By.tagName("a"));
        for (WebElement element : links) {
            System.out.println(element.getText());
        }
    }

}
