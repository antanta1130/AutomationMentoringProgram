package com.tasks.task15.pages;

import java.util.ArrayList;
import java.util.List;

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
    private Select sortByDropdown;

    @FindBy(xpath = "//*[@id='center_column']/ul/li/div[@class='product-container']")
    private List<WebElement> listOfProducts;

    public WomenCategoryPage(WebDriver driver) {
        super(driver);
    }

    public WomenCategoryPage sortBy(String option) {
        log.info("sort by method");

        sortByDropdown = new Select(selectElement);
        sortByDropdown.selectByVisibleText(option);

        try {
            MyFluentWait.wait(driver).until(ExpectedConditions.invisibilityOf(selectElement));
        } catch (NoSuchElementException ex) {
            log.error("waiter exception, dropdown list is visible");
            log.error(ex.getMessage());
            throw ex;
        }

        WomenCategoryPage w = new WomenCategoryPage(driver);

        for (ProductPageElement el : extractProductData()) {
            el.getProduct();
        }

        return w;

    }

    private List<ProductPageElement> extractProductData() {
        List<ProductPageElement> products = new ArrayList<ProductPageElement>();

        for (WebElement product : listOfProducts) {
            products.add(new ProductPageElement(product));
        }

        return products;
    }

}
