package com.tasks.task15.pages;

import java.util.List;

import org.openqa.selenium.support.Color;

public class ProductPageElement {
    private String name;
    private String price;
    private List<Color> colors;
    
	public ProductPageElement(String name, String price, List<Color> colors) {
		this.name = name;
		this.price = price;
		this.colors = colors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	@Override
	public String toString() {
		return "ProductPageElement [name=" + name + ", price=" + price + ", colors=" + colors + "]";
	}
	
	
	
}
