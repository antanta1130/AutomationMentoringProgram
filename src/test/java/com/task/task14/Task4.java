package com.task.task14;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

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
 * 1.We  enter “selenium automation testing” and find that “seleniumhq.org”  is on the 1st page
 * 2. We  enter “îñöèëëîãðàô” and find that “vit.ua”  is on the 17th page3. 
 * We enter “àáðàêàäàáðà” and find that “kpi.ua” is not in the search results
 * 
 */

public class Task4 {
    private WebDriver chromeDriver;
    private FluentWait<WebDriver> wait;
    private final String exePath = "D:\\AutomationMentoringProgram\\";
    private static final int MAX_NUMBERS_OF_PAGES = 25;

 /*   @DataProvider(name = "getData")
    public static Object[][] parametersSet() {
	return new Object[][] { { new String[] {"îñöèëëîãðàô", "www.skif.biz"}, 17 },
		{ new String[] {"selenium automation testing", "seleniumhq.org"}, 1 },
		{ new String[] {"àáðàêàäàáðà", "kpi.ua"}, -1 } };}*/
    
    
    @Before
    public void createDriver() {
        System.setProperty("webdriver.chrome.chromeDriver", exePath + "chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        wait = new FluentWait<WebDriver>(chromeDriver);
        wait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);

    }

    
/*    @Test(dataProvider="getData")
    public void testSearch(String[] searchParams, String expectedPage) {
    	Assert.assertEquals(expectedPage, search(searchParams[0], searchParams[1]));
    }
    */
    @Test
    public void testSearchOn1Page() {
    	Assert.assertEquals(1, search("selenium automation testing", "seleniumhq.org"));
    }
    
    @Test
    public void testSearchOnNthPage() {
    	Assert.assertEquals(17, search("îñöèëëîãðàô", "www.skif.biz"));
    }
    
    @Test
    public void testSearchNotFoundUsingMaxPagesCount() {
    	Assert.assertEquals(-1, search("àáðàêàäàáðà", "kpi.ua"));
    }

    @After
    public void quitDriver() {
    	chromeDriver.quit();
    }

    
    
    private int search(String searchString, String expectedUrl){
    	int resultPage = 1;
    	chromeDriver.get("https://www.google.com.ua/");
 
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lst-ib")));
        WebElement searchField = chromeDriver.findElement(By.id("lst-ib"));
        searchField.sendKeys(searchString);
        searchField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ires']")));
        
        while(resultPage < MAX_NUMBERS_OF_PAGES){
        List<WebElement> links = chromeDriver.findElements(By.xpath("//*[@id='ires']//cite[@class='_Rm']"));
        for(WebElement el: links){
        	if(el.getText().contains(expectedUrl)) {
                ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView();", el);
                File scr1 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
                
                try {
                    FileUtils.copyFile(scr1, new File(exePath + "screenShots\\" + System.currentTimeMillis() + ".png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        		return resultPage;
        	}	
        }  
        chromeDriver.findElement(By.id("pnnext")).click();
        resultPage++;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ires']")));
        } 

        return -1; 
        
    }

}
