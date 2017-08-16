package com.tasks.task14.searcher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tasks.task14.pages.GoogleSearchPage;
import com.tasks.task14.pages.GoogleSearchResultPage;

public class LinkSearcher {
    private static final int MAX_NUMBERS_OF_PAGES = 25;

    public int search(WebDriver driver, String searchString, String expectedUrl) {
        int pageNumber = -1;
        GoogleSearchResultPage googleSearchResultPage = PageFactory.initElements(driver, GoogleSearchPage.class).search(searchString);

        while (googleSearchResultPage.getCurrentPageNumber() < MAX_NUMBERS_OF_PAGES) {
            pageNumber = googleSearchResultPage.linkIsPresentOnCurrentPage(expectedUrl);
            if (pageNumber != -1) {
                return pageNumber;
            }
            googleSearchResultPage = googleSearchResultPage.clickNextPageButton();
        }
        return pageNumber;
    }
}
