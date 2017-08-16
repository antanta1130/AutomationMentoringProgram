package com.tasks.task14.searcher;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenShotTaker {

    private final static String exePath = "C:\\Users\\Tetiana\\Documents\\AutomationMentoringProgram\\";

    public static File takeScreenshot(WebDriver driver, WebElement el) throws IOException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
        File scr1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr1, new File(exePath + "screenShots\\" + System.currentTimeMillis() + ".png"));
        return scr1;
    }

}
