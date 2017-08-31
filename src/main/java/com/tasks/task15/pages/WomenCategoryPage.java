package com.tasks.task15.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tasks.task14.utils.MyFluentWait;

public class WomenCategoryPage extends Page {
    private static final Logger log = LoggerFactory.getLogger(WomenCategoryPage.class);

    @FindBy(id = "selectProductSort")
    private WebElement selectElement;
    private Select sortByDropdown = new Select(selectElement);;

    @FindBy(xpath= "//*[@id='center_column']/ul")
    private WebElement productListContainer;
    
    @FindBy(id="ul_layered_id_attribute_group_3")
    private WebElement colorMenuContainer; 

    public WomenCategoryPage(WebDriver driver) {
        super(driver);
    }

    public ListOfProducts sortBy(String option) {
        sortByDropdown.selectByVisibleText(option);
        
        log.info("sort by: {}", option);

        try {
            MyFluentWait.wait(driver).until(ExpectedConditions.attributeToBe(productListContainer, "style", "opacity: 1;"));
        } catch (NoSuchElementException ex) {
            log.error("waiter exception, dropdown list is visible");
            log.error(ex.getMessage());
            throw ex;
        }
        
        return new ListOfProducts(productListContainer);
    }
    
    public ListOfProducts clickOnColorMenuItem(final String item){
    	colorMenuContainer.findElement(By.partialLinkText(item));
    	
    	log.info("selected color: {}", item);

        try {
            MyFluentWait.wait(driver).until(ExpectedConditions.attributeToBe(productListContainer, "style", "opacity: 1;"));
        } catch (NoSuchElementException ex) {
            log.error("waiter exception, dropdown list is visible");
            log.error(ex.getMessage());
            throw ex;
        }
        
    	return new ListOfProducts(productListContainer);
    }

}
