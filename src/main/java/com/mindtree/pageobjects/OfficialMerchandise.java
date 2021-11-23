package com.mindtree.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.OfficialMerchandiseUI;

public class OfficialMerchandise {

	WebDriver driver;

	public OfficialMerchandise(WebDriver driver2) {
		this.driver = driver2;
	}

	public List<WebElement> getProdname() {
		return driver.findElements(OfficialMerchandiseUI.prodName);
	}

	public WebElement getPinCode() {
		return driver.findElement(OfficialMerchandiseUI.pinCode);
	}

	public WebElement getCheckBtn() {
		return driver.findElement(OfficialMerchandiseUI.check);
	}

	public WebElement getValidateText() {
		return driver.findElement(OfficialMerchandiseUI.text);
	}
}
