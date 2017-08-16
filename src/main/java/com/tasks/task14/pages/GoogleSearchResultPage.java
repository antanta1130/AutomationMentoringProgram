package com.tasks.task14.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tasks.task14.searcher.ScreenShotTaker;
import com.tasks.task14.utils.MyFluentWait;

public class GoogleSearchResultPage {

    private static final Logger log = LoggerFactory.getLogger(GoogleSearchResultPage.class);

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id='ires']")
    private WebElement resultContainer;

    @FindBy(xpath = "//*[@id='ires']//cite[@class='_Rm']")
    private List<WebElement> links;

    @FindBy(id = "pnnext")
    private WebElement nextPageButton;

    @FindBy(xpath = "//*[@id='resultStats']")
    private WebElement resultStats;

    @FindBy(xpath = "//*[@id='navcnt']//*[@class='cur']")
    private WebElement currentPageNumber;

    public GoogleSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleSearchResultPage clickNextPageButton() {
        MyFluentWait.wait(driver).until(ExpectedConditions.elementToBeClickable(nextPageButton));
        nextPageButton.click();
        MyFluentWait.wait(driver).until(ExpectedConditions.visibilityOf(resultStats));
        return PageFactory.initElements(driver, GoogleSearchResultPage.class);
    }

    public int linkIsPresentOnCurrentPage(String expectedUrl) {
        for (WebElement el : links) {
            if (el.getText().contains(expectedUrl)) {
                try {
                    ScreenShotTaker.takeScreenshot(driver, el);
                } catch (IOException e) {
                    log.error("Cannot take screenshot of web element");
                }
                return getCurrentPageNumber();
            }
        }
        return -1;
    }

    public int getCurrentPageNumber() {
        return Integer.parseInt(currentPageNumber.getText());
    }

}
