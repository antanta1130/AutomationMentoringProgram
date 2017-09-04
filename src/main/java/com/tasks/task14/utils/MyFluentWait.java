package com.tasks.task14.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class MyFluentWait {

    public static Wait<WebDriver> wait(WebDriver driver) {
        return new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS).pollingEvery(50, TimeUnit.MILLISECONDS);
    }

}
