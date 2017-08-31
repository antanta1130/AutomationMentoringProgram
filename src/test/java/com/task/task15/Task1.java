package com.task.task15;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tasks.task15.pages.StoreMainPage;
import com.tasks.task15.pages.WomenCategoryPage;

public class Task1 {
    private WebDriver chromeDriver;
    private final String exePath = "D:\\AutomationMentoringProgram\\";
    private static final Logger log = LoggerFactory.getLogger(Task1.class);

    @Before
    public void createDriver() {
        System.setProperty("webdriver.chrome.chromeDriver", exePath + "chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @After
    public void quitDriver() {
        chromeDriver.quit();
    }

    @Test
    public void task1() {
        log.info("task15.1");
        // GIVEN
        WomenCategoryPage womenCategoryPage = PageFactory.initElements(chromeDriver, StoreMainPage.class).open().clickMenuItem();

        // WHEN
        womenCategoryPage.sortBy("Price: Lowest first");

        // THEN
    }

}
