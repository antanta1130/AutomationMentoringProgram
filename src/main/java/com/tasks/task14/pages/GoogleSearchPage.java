package com.tasks.task14.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tasks.task14.utils.MyFluentWait;

public class GoogleSearchPage {
    private final WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(GoogleSearchPage.class);

    @FindBy(id = "lst-ib")
    private WebElement searchInputField;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleSearchResultPage search(String searchText) {
        driver.get("https://www.google.com.ua/");
        MyFluentWait.wait(driver).until(ExpectedConditions.elementToBeClickable(searchInputField));
        searchInputField.sendKeys(searchText);
        searchInputField.sendKeys(Keys.ENTER);
        MyFluentWait.wait(driver).until(ExpectedConditions.urlContains("search"));
        
        log.info("googling: {}", searchText);
        
        return PageFactory.initElements(driver, GoogleSearchResultPage.class);
    }

}
