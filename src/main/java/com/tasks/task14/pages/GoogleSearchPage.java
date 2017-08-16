package com.tasks.task14.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {
@FindBy(id = "lst-ib")
private WebElement searchInputField;

@FindBy(xpath = "//*[@id='ires']")
private WebElement resultContainer;

@FindBy(xpath = "//*[@id='ires']//cite[@class='_Rm']")
private List<WebElement> links;

@FindBy(id = "pnnext")
private WebElement nextPageButton;

private final WebDriver driver;

public GoogleSearchPage(WebDriver driver){
	this.driver = driver;
}

public GoogleSearchResutlPage search(String searchText){
	searchInputField.sendKeys(searchText);
	searchInputField.sendKeys(Keys.ENTER);
	return new GoogleSearchResutlPage();
}

}
