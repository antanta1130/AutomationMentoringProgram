package com.task.task15;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

public class Task2 {
    private WebDriver driver;
    private final String exePath = "C:\\Users\\Tetiana\\Documents\\AutomationMentoringProgram\\";
    private static final Logger log = LoggerFactory.getLogger(Task2.class);

    @Before
    public void createDriver() {
        System.setProperty("webdriver.chrome.chromeDriver", exePath +
                "chromedriver.exe");
        driver = new ChromeDriver();

        // System.setProperty("webdriver.gecko.driver", exePath +
        // "geckodriver.exe");
        // driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void task2() {
        log.info("task15.2");
        // GIVEN
        StoreMainPage smp = PageFactory.initElements(driver, StoreMainPage.class);
        WomenCategoryPage womenCategoryPage = smp.open().navigateWomanCategoryPage();

        // WHEN
        int expectedNumberOfProductsIntoContainer = womenCategoryPage.clickOnColorMenuItem("Orange").getSize();
        int actualNumberOfProductsInColorMenu = womenCategoryPage.getNumberOfProductsFromColorMenuItems("Orange");

        // THEN
        assertThat(actualNumberOfProductsInColorMenu, is(expectedNumberOfProductsIntoContainer));
    }

}
