package com.mindtree.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.ProductPageUI;

public class ProductPage {
	WebDriver driver;

	public ProductPage(WebDriver driver2) {
		this.driver = driver2;
	}

	public WebElement getWishlist() {
		return driver.findElement(ProductPageUI.productwishlist);
	}

	public WebElement getAddtocart() {
		return driver.findElement(ProductPageUI.addtocart);
	}

	public WebElement getQuantity() {
		return driver.findElement(ProductPageUI.quantity);
	}

	public WebElement getAdd() {
		return driver.findElement(ProductPageUI.add);
	}

	public WebElement getCloseShoppinglist() {
		return driver.findElement(ProductPageUI.closingshoppinglist);
	}

	public WebElement getSortBy() {
		return driver.findElement(ProductPageUI.sortBy);
	}

	public List<WebElement> getProducts() {
		return driver.findElements(ProductPageUI.prodName);
	}

}
