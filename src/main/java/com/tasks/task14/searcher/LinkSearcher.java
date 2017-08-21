package com.tasks.task14.searcher;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tasks.task14.pages.GoogleSearchPage;
import com.tasks.task14.pages.GoogleSearchResultPage;

public class LinkSearcher {
    private static final int MAX_NUMBERS_OF_PAGES = 25;
    private static final Logger log = LoggerFactory.getLogger(LinkSearcher.class);

    public int search(WebDriver driver, String searchString, String expectedUrl) {
    	log.debug("Begin of search() method");
    	log.info("MAX_NUMBERS_OF_PAGES for searching = {}", MAX_NUMBERS_OF_PAGES);
    	
        int pageNumber = -1;
        GoogleSearchResultPage googleSearchResultPage = PageFactory.initElements(driver, GoogleSearchPage.class).search(searchString);

        while (googleSearchResultPage.getCurrentPageNumber() < MAX_NUMBERS_OF_PAGES) {
            pageNumber = googleSearchResultPage.linkIsPresentOnCurrentPage(expectedUrl);       	
            if (pageNumber != -1) {
                return pageNumber;
            }
            
            try{
            	googleSearchResultPage = googleSearchResultPage.clickNextPageButton();
            } catch(NoSuchElementException ex){
            	log.error("There are less search results pages than is set to variable MAX_NUMBERS_OF_PAGES");
            	log.error(ex.getMessage());
            	break;
            }
        }
        
        log.debug("End of search() method");
        
        return pageNumber;
    }
}
