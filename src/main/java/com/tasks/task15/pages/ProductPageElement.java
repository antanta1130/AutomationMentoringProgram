package com.tasks.task15.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductPageElement {
    private WebElement product;
    private static final Logger log = LoggerFactory.getLogger(ProductPageElement.class);
    private static final Pattern HEX_PATTERN = Pattern.compile("background:#(\\p{XDigit}+);");

    public ProductPageElement(WebElement product) {
        this.product = product;
    }

    public String getProductName() {
        return product.findElement(By.xpath("//a[@class='product-name']")).getText();
    }

    public int getPrice() {
        return Integer.parseInt(product.findElement(By.xpath("//span[@itemprop='price']")).getText().trim().replace("$", ""));
    }

    public List<Color> getListOfColors() {
        List<Color> colors = new ArrayList<Color>();
        List<WebElement> tmpList = product.findElements(By.xpath("//a[@class='color_pick']"));

        for (WebElement el : tmpList) {
            colors.add(Color.fromString(HEX_PATTERN.matcher(el.getAttribute("style")).group(1)));
        }

        return colors;
    }

    public WebElement getProduct() {
        log.info("product name: {}", getProductName());
        log.info("product colors: {}", getListOfColors());
        log.info("product price: {}", getPrice());

        return product;
    }

    public void setProduct(WebElement product) {
        this.product = product;
    }

}
