package com.tasks.task15.pages;

import org.openqa.selenium.By;
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
    private final Select sortByDropdown = new Select(selectElement);

    @FindBy(xpath = "//*[@id='center_column']/ul")
    private WebElement productListContainer;

    @FindBy(id = "ul_layered_id_attribute_group_3")
    private WebElement colorMenuContainer;

    public WomenCategoryPage(WebDriver driver) {
        super(driver);
    }

    public ListOfProducts sortBy(String option) {
        sortByDropdown.selectByVisibleText(option);

        log.info("sort by: {}", option);
        MyFluentWait.wait(driver).until(ExpectedConditions.attributeToBe(productListContainer, "style", "opacity: 0.7;"));
        MyFluentWait.wait(driver).until(ExpectedConditions.attributeToBe(productListContainer, "style", "opacity: 1;"));

        return new ListOfProducts(productListContainer);
    }

    public ListOfProducts clickOnColorMenuItem(final String item) {
        MyFluentWait.wait(driver).until(ExpectedConditions.visibilityOf(colorMenuContainer));
        WebElement we = getProductListContainer(); // since we need to have an
                                                   // element before click
        colorMenuContainer.findElement(By.xpath("li[label/a[contains(text(),'" + item + "')]]/input[@type='button']")).click();
        log.info("selected color: {}", item);
        MyFluentWait.wait(driver).until(ExpectedConditions.stalenessOf(we));
        return new ListOfProducts(getProductListContainer());
    }

    public int getNumberOfProductsFromColorMenuItems(final String item) {
        return Integer.parseInt(colorMenuContainer.findElement(
                By.partialLinkText(item))
                .findElement(By.tagName("span"))
                .getText()
                .replace("(", "").replace(")", ""));
    }

    private WebElement getProductListContainer() {
        return driver.findElement(By.xpath("//*[@id='center_column']/ul"));
    }

}
