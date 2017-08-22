package com.task.task14;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 1.Navigateto https://en.wikipedia.org/wiki/Main_Page
 * 2.Take Screenshot of the first Image  in the “Did you know...” container
 * 3.Take Screenshot of the “In the news” container
 */

public class Task2 {

    private WebDriver chromeDriver;
    private FluentWait<WebDriver> wait;
    //private final String exePath = "C:\\Users\\Tetiana\\Documents\\AutomationMentoringProgram\\";
    private final String exePath = "D:\\AutomationMentoringProgram\\";
    private static final Logger log = LoggerFactory.getLogger(Task2.class);

    @Before
    public void createDriver() {
        System.setProperty("webdriver.chrome.chromeDriver", exePath + "chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        System.setProperty("webdriver.ie.driver", exePath + "IEDriverServer.exe");

        wait = new FluentWait<WebDriver>(chromeDriver);
        wait.withTimeout(5, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
    }

    @After
    public void quitDriver() {
        chromeDriver.quit();
    }

    @Test
    public void task2_1_takeScreenShots() throws Throwable {
    	log.info("task2.1: Take Screenshot of the \"In the news\" container");
        chromeDriver.get("https://en.wikipedia.org/wiki/Main_Page");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mp-left']//img")));
        WebElement image = chromeDriver.findElement(By.xpath("//*[@id='mp-left']//img"));

        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView();", image);

        File scr1 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);

        BufferedImage fullImg = ImageIO.read(scr1);
        Point point = image.getLocation();
        Dimension size = image.getSize();

        BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), 0, size.getWidth(), size.getHeight());
        ImageIO.write(elementScreenshot, "png", scr1);

        try {
            FileUtils.copyFile(scr1, new File(exePath + "screenShots\\" + System.currentTimeMillis() + ".png"));
            log.info("Screenshot has been taken");
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }

    @Test
    public void task2_2_takeScreenShots() throws Throwable {
    	log.info("task2.2: Take Screenshot of the first Image in the \"Did you know...\" container");
        chromeDriver.get("https://en.wikipedia.org/wiki/Main_Page");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mp-right']")));
        WebElement image = chromeDriver.findElement(By.xpath("//*[@id='mp-right']"));
        WebElement helper = chromeDriver.findElement(By.xpath("//*[@id='mp-otd-h2']"));

        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView();", image);
        Thread.sleep(800);

        File scr1 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);

        BufferedImage fullImg = ImageIO.read(scr1);

        BufferedImage elementScreenshot = fullImg.getSubimage(image.getLocation().getX(), 0, image.getSize().getWidth(), helper.getLocation().getY() - image.getLocation().getY());
        ImageIO.write(elementScreenshot, "png", scr1);

        try {
            FileUtils.copyFile(scr1, new File(exePath + "screenShots\\" + System.currentTimeMillis() + ".png"));
            log.info("Screenshot has been taken");
        } catch (IOException e) {
        	log.error(e.getMessage());
        }

    }

}
