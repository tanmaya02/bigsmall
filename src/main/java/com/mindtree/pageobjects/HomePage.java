package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.HomePageUI;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement Whatsnew() {
		return driver.findElement(HomePageUI.whatsnew);
	}

	public WebElement searchbox() {
		return driver.findElement(HomePageUI.searchbox);
	}

	public WebElement sigin() {
		return driver.findElement(HomePageUI.sigin);
	}

	public WebElement wishlist() {
		return driver.findElement(HomePageUI.wishlist);
	}

	public WebElement giftcard() {
		return driver.findElement(HomePageUI.giftcard);
	}

	public WebElement cart() {
		return driver.findElement(HomePageUI.cart);
	}

	public WebElement product() {
		return driver.findElement(HomePageUI.product);
	}

	public WebElement logo() {
		return driver.findElement(HomePageUI.logo);
	}

	public WebElement producttextafterclicking() {
		return driver.findElement(HomePageUI.producttextafterclicking);
	}

	public WebElement officialM() {
		return driver.findElement(HomePageUI.officialMerchandise);
	}

	public WebElement DC() {
		return driver.findElement(HomePageUI.DCgift);
	}

	public WebElement getSearchtext() {
		return driver.findElement(HomePageUI.searchText);
	}

	public WebElement getCartText() {
		return driver.findElement(HomePageUI.cartText);
	}
}
