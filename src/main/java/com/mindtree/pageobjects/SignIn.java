package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.SignInUI;

public class SignIn {
	WebDriver driver;

	public SignIn(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement customeremailid() {
		return driver.findElement(SignInUI.mail);
	}

	public WebElement customerpass() {
		return driver.findElement(SignInUI.password);
	}

	public WebElement signinbutton() {
		return driver.findElement(SignInUI.signinBtn);
	}

	public WebElement createaccount() {
		return driver.findElement(SignInUI.CreateaccountBtn);
	}

}
