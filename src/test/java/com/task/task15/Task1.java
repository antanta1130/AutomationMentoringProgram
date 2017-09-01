package com.task.task15;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

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
    private static final List<String> expectedPriceArraySortingOrderAsc = Arrays.asList("16.40", "16.51", "26.00", "27.00", "28.98", "30.50", "50.99");

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
    /*
     * @Test public void task1() { log.info("task15.1"); // GIVEN
     * WomenCategoryPage womenCategoryPage =
     * PageFactory.initElements(chromeDriver,
     * StoreMainPage.class).open().clickMenuItem();
     * 
     * // WHEN List<String> actualPriceArraySortingOrderAsc =
     * womenCategoryPage.sortBy("Price: Lowest first").getListOfPrices();
     * 
     * // THEN assertThat(actualPriceArraySortingOrderAsc,
     * is(expectedPriceArraySortingOrderAsc)); }
     */

    @Test
    public void task2() {
        log.info("task15.2");
        // GIVEN
        WomenCategoryPage womenCategoryPage = PageFactory.initElements(chromeDriver, StoreMainPage.class).open().clickMenuItem();

        // WHEN
        int expectedNumberOfProductsIntoContainer = womenCategoryPage.clickOnColorMenuItem("Orange").getSize();
        int actualNumberOfProductsInColorMenu = womenCategoryPage.getNumberOfProductsFromColorMenuItems("Orange");

        // THEN
        assertThat(actualNumberOfProductsInColorMenu, is(expectedNumberOfProductsIntoContainer));
    }

}
