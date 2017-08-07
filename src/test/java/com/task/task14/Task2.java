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

public class Task2 {

    private WebDriver chromeDriver;
    private FluentWait<WebDriver> wait;
    private FluentWait<WebDriver> waitAd;
    private final String exePath = "C:\\Users\\Tetiana\\Documents\\AutomationMentoringProgram\\";

    @Before
    public void createDriver() {
        System.setProperty("webdriver.chrome.chromeDriver", exePath + "chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        System.setProperty("webdriver.ie.driver", exePath + "IEDriverServer.exe");

        wait = new FluentWait<WebDriver>(chromeDriver);
        wait.withTimeout(5, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);

        waitAd = new FluentWait<WebDriver>(chromeDriver);
        waitAd.withTimeout(5, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
    }

    @After
    public void quitDriver() {
        chromeDriver.quit();
    }

    @Test
    public void task2_1_takeScreenShots() throws Throwable {
        chromeDriver.get("https://en.wikipedia.org/wiki/Main_Page");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//[@id='mp-left']//img")));
        WebElement image = chromeDriver.findElement(By.xpath("//[@id='mp-left']//img"));

        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView();", image);

        try {
            waitAd.until(ExpectedConditions.elementToBeClickable(By.xpath("//[@id='B1718_0721_enUA_dsk_p1_lg_seq_A']//span[contains(@class,'frb-close')]")));
            chromeDriver.findElement(By.xpath("//[@id='B1718_0721_enUA_dsk_p1_lg_seq_A']//span[contains(@class,'frb-close')]")).click();
        } finally {
            File scr1 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);

            BufferedImage fullImg = ImageIO.read(scr1);
            Point point = image.getLocation();
            Dimension size = image.getSize();

            BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), 0, size.getWidth(), size.getHeight());
            ImageIO.write(elementScreenshot, "png", scr1);

            try {
                FileUtils.copyFile(scr1, new File(exePath + "screenShots\\" + System.currentTimeMillis() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void task2_2_takeScreenShots() throws Throwable {
        chromeDriver.get("https://en.wikipedia.org/wiki/Main_Page");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//[@id='mp-right']/tbody[1]/tr[1]")));
        WebElement image = chromeDriver.findElement(By.xpath("//[@id='mp-right']/tbody[1]/tr[1]"));
        WebElement helper = chromeDriver.findElement(By.xpath("//[@id='mp-right']/tbody[1]/tr[3]"));

        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView();", image);
        Thread.sleep(800);

        try {
            waitAd.until(ExpectedConditions.elementToBeClickable(By.xpath("//[@id='B1718_0721_enUA_dsk_p1_lg_seq_A']//span[contains(@class, 'frb-close')]")));
            chromeDriver.findElement(By.xpath("//[@id='B1718_0721_enUA_dsk_p1_lg_seq_A']//span[contains(@class,'frb-close')]")).click();
        } finally {
            File scr1 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);

            BufferedImage fullImg = ImageIO.read(scr1);

            BufferedImage elementScreenshot = fullImg.getSubimage(image.getLocation().getX(), 0, image.getSize().getWidth(),
                    helper.getLocation().getY() - image.getLocation().getY());
            ImageIO.write(elementScreenshot, "png", scr1);

            try {
                FileUtils.copyFile(scr1, new File(exePath + "screenShots\\" + System.currentTimeMillis() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
