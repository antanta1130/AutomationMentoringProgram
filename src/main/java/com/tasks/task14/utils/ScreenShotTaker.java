package com.tasks.task14.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenShotTaker {
	private static final Logger log = LoggerFactory.getLogger(ScreenShotTaker.class);
	private final static String exePath = "C:\\Users\\Tetiana\\Documents\\AutomationMentoringProgram\\";

    public static File takeScreenshot(WebDriver driver, WebElement el) throws IOException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
        File scr1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr1, new File(exePath + "screenShots\\" + System.currentTimeMillis() + ".png"));
        
        log.info("Screenshot has been taken");
        
        return scr1;
    }

}
