package com.task.task14;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.tasks.task14.searcher.LinkSearcher;

/*
 *
 * 1. For Chrome, IE and Safari – open the browser
 * 2. Goto google.com
 * 3. Search for something that:
 * 3.1 is located on the first page of search results
 * 3.2 is located further then 10th page
 * 3.3 is not in the search results
 * 4. Save  screenshot if result is found
 * 5. Provide user with the corresponding error message if result is not found
 * 6. Print to Console Page number if result is found
 *
 * Example:
 * 1. We  enter “selenium automation testing” and find that “seleniumhq.org”  is on the 1st page
 * 2. We  enter “осцилограф” and find that “vit.ua”  is on the 17th page
 * 3. We enter “grgrgzsfdd” and find that “kpi.ua” is not in the search results
 *
 */

public class Task4 {
    private final LinkSearcher linkSearcher = new LinkSearcher();
    private WebDriver chromeDriver;
    private final String exePath = "C:\\Users\\Tetiana\\Documents\\AutomationMentoringProgram\\";

    @Before
    public void createDriver() {
        System.setProperty("webdriver.chrome.chromeDriver", exePath + "chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @Test
    public void testSearchOn1Page() {
        Assert.assertEquals(1, linkSearcher.search(chromeDriver, "selenium automation testing", "seleniumhq.org"));
    }

    @Test
    public void testSearchOnNthPage() {
        // link and page should be changed according to your search results
        // Assert.assertEquals(14, linkSearcher.search(chromeDriver,
        // "осциллограф", "gs-systems.ru"));
        System.out.println(linkSearcher.search(chromeDriver, "осциллограф", "gs-systems.ru"));
    }

    @Test
    public void testSearchNotFoundUsingMaxPagesCount() {
        Assert.assertEquals(-1, linkSearcher.search(chromeDriver, "adfgffgdgj", "kpi.ua"));
    }

    @After
    public void quitDriver() {
        chromeDriver.quit();
    }

}
