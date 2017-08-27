package com.tasks.task15.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tasks.task14.utils.MyFluentWait;

public class StoreMainPage extends Page {
    private static final String URL = "http://automationpractice.com";
    private static final Logger log = LoggerFactory.getLogger(StoreMainPage.class);

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
    private WebElement menuItem1;

    public StoreMainPage(WebDriver driver) {
        super(driver);
    }

    public StoreMainPage open() {
        driver.get(URL);
        MyFluentWait.wait(driver).until(ExpectedConditions.visibilityOf(menuItem1));
        return this;
    }

    public WomenCategoryPage clickMenuItem() {
        log.info("Choosen menu item: {}", menuItem1.getText());

        menuItem1.click();
        MyFluentWait.wait(driver).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("center_column")));
        log.info("Transfer to {} category page", menuItem1.getText());
        return new WomenCategoryPage(driver);
    }
}
