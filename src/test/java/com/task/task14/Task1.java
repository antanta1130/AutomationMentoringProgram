package com.task.task14;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Task1 {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private FluentWait<WebDriver> waitAd;

    @Before
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\AutomationMentoringProgram\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(5, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
        
        waitAd = new FluentWait<WebDriver>(driver);
        waitAd.withTimeout(5, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='blueBarDOMInspector']//a[@data-testid='blue_bar_profile_link']/span")));

    }
    
    @Test
    public void takeScreenShots() throws Throwable {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mp-left']//img")));
        WebElement image = driver.findElement(By.xpath("//*[@id='mp-left']//img"));
 
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", image);
        Thread.sleep(800); 
        
        try{
        	waitAd.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='B1718_0721_enUA_dsk_p1_lg_seq_A']//span[contains(@class, 'frb-close')]")));
        	driver.findElement(By.xpath("//*[@id='B1718_0721_enUA_dsk_p1_lg_seq_A']//span[contains(@class, 'frb-close')]")).click();
        }
        finally{
            File scr1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            try {
    			FileUtils.copyFile(scr1, new File("D:\\AutomationMentoringProgram\\screenShots\\" + System.currentTimeMillis() + ".png" ));
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
            
            BufferedImage fullImg = ImageIO.read(scr1);
            Point point = image.getLocation();
            Dimension size = image.getSize();

            BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), 0, size.getWidth(), size.getHeight());
            ImageIO.write(elementScreenshot, "png", scr1);
            
            try {
    			FileUtils.copyFile(scr1, new File("D:\\AutomationMentoringProgram\\screenShots\\" + System.currentTimeMillis() + ".png" ));
    		} catch (IOException e) {
    			e.printStackTrace();
    		}	
        }


    }

}
