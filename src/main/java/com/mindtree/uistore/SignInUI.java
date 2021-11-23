package com.mindtree.uistore;

import org.openqa.selenium.By;

public class SignInUI {

	public static By mail = By.id("CustomerEmail");
	public static By password = By.id("CustomerPassword");
	public static By signinBtn = By.xpath("(//input[@type='submit'])[1]");
	public static By CreateaccountBtn = By.id("customer_register_link");
}
