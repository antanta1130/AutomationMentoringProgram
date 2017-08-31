package com.tasks.task15.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListOfProducts {
    private WebElement productListContainer;
    private List<ProductPageElement> listOfProducts = new ArrayList<ProductPageElement>();;
    private static final Logger log = LoggerFactory.getLogger(ListOfProducts.class);

    public ListOfProducts(WebElement productListContainer) {
        this.productListContainer = productListContainer;
        fillProductList();
    }

    private String getProductName(final WebElement elem) {
        return elem.findElement(By.className("product-name")).getText();
    }

    private String getPrice(final WebElement elem) {
        return elem.findElement(By.className("product-price")).getText().trim().replace("$", "");
    }

    private List<Color> getListOfColors(final WebElement elem) {
        List<Color> colors = new ArrayList<Color>();
        List<WebElement> tmpList = elem.findElements(By.className("color_pick"));

        for (WebElement el : tmpList) {
            colors.add(Color.fromString(el.getCssValue("background-color")));
        }
        return colors;
    }

    private void fillProductList() {
    	List<WebElement> tempListOfProducts = new ArrayList<WebElement>();
    	tempListOfProducts = productListContainer.findElements(By.className("right-block"));
    	
    	for(WebElement elem : tempListOfProducts){
    		listOfProducts.add(new ProductPageElement(getProductName(elem), getPrice(elem), getListOfColors(elem)));
    		log.info("name: {}, price {}, colors {}", getProductName(elem), getPrice(elem), getListOfColors(elem));
    	}   
    }
    
    public List<String> getListOfPrices(){
    	List<String> prices = new ArrayList<String>();
    	
    	for (ProductPageElement pr : listOfProducts){
    		prices.add(pr.getPrice());
    	}
    	
    	return prices;
    }
}
