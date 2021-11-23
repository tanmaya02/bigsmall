package com.mindtree.runner;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mindtree.reusablecomponents.BaseClass;

public class BigSmallApplication extends BaseClass {

	// Test case to open the website and create a new account
	@Test(priority = 1)
	public void createAccount() throws IOException, InterruptedException {

		driver.get(config.getURL());
		log.info("Driver open URL and entered into Landing Page");
		homepage.sigin().click();
		createAcc.getCreateAcc().click();
		ArrayList<String> fname = ex.getData("firstname");
		ArrayList<String> lname = ex.getData("lastname");
		ArrayList<String> email = ex.getData("email");
		ArrayList<String> password = ex.getData("password");
		for (int i = 1; i < fname.size(); i++) {
			createAcc.getfname().sendKeys(fname.get(i));
			createAcc.getlname().sendKeys(lname.get(i));
			createAcc.getEmail().sendKeys(email.get(i));
			createAcc.getPassword().sendKeys(password.get(i));
			er.startTest("Successfully entered User details");
			log.info("Entering user details in create account page");
			Thread.sleep(2000);
			createAcc.getfname().clear();
			createAcc.getlname().clear();
			createAcc.getEmail().clear();
			createAcc.getPassword().clear();
		}

		er.endTest();
	}

	// Test case to Sign in
	@Test(priority = 2)
	public void signIN() throws IOException, InterruptedException {

		homepage.logo().click();
		homepage.sigin().click();
		log.info("Successfully clicked on Sign in button");
		ArrayList<String> username = ex.getData("username");
		ArrayList<String> password = ex.getData("password for signin");
		for (int i = 1; i < username.size(); i++) {
			signin.customeremailid().sendKeys(username.get(i));
			signin.customerpass().sendKeys(password.get(i));
			Thread.sleep(2000);
			er.startTest("Signing in using user details");
			signin.customeremailid().clear();
			signin.customerpass().clear();
			Thread.sleep(2000);
			log.info("Entering username and password in the Sign in page");
		}

		er.endTest();
	}

	// Test case to check the COD availability of the DC Merchandise product
	@Test(priority = 3)
	public void CODAvailability() throws IOException, InterruptedException {

		homepage.logo().click();
		Actions a = new Actions(driver);
		WebElement move = homepage.officialM();
		a.moveToElement(move).build().perform();
		homepage.DC().click();
		log.info("Clicking the DC merchandise under the Official Merchandise dropdown");
		ArrayList<String> DCproduct = ex.getData("DCProduct");
		ArrayList<String> pin = ex.getData("Pincode");
		for (int i = 0; i < officialMerchandise.getProdname().size(); i++) {
			if (officialMerchandise.getProdname().get(i).getText().contains(DCproduct.get(1))) {
				System.out.println("Product found!");
				officialMerchandise.getProdname().get(i).click();
				break;
			}
		}
		log.info("Clicked on the DC product");
		officialMerchandise.getPinCode().sendKeys(pin.get(1));
		officialMerchandise.getCheckBtn().click();
		er.startTest("Checking for the availability of cod for the selected product");
		log.info("Checking for the availability of cod for the selected product");
		Thread.sleep(2000);
		System.out.println(officialMerchandise.getValidateText().getText());
		er.endTest();

	}

	// Test case to add the product on the second page of the shop by category to
	// wish list
	@Test(priority = 4)
	public void ShopByCategory() throws IOException, InterruptedException {

		homepage.logo().click();
		Actions a = new Actions(driver);
		WebElement move = shopbycat.getShopbycat();
		a.moveToElement(move).build().perform();
		shopbycat.getJewellery().click();
		shopbycat.getNext().click();
		ArrayList<String> shop = ex.getData("shopbycategory");
		for (int i = 0; i < shopbycat.getJewpro().size(); i++) {
			if (shopbycat.getJewpro().get(i).getText().contains(shop.get(1))) {
				System.out.println("Product found!");
				shopbycat.getJewpro().get(i).click();
				break;
			}
		}
		productcmon.getWishlist().click();
		Thread.sleep(2000);
		er.startTest("Adding the product in the second page to the wishlist");
		er.endTest();
	}

//		Test case to add a gift card to cart
	@Test(priority = 5)
	public void Giftcard() throws InterruptedException, IOException {

		homepage.logo().click();
		homepage.giftcard().click();
		String text = giftcard.validate().getText();
		Assert.assertEquals(text, "Gift Card");
		for (int i = 0; i < 6; i++) {
			giftcard.add().click();
		}
		Thread.sleep(2000);
		giftcard.addgifttocart().click();
		er.startTest("Successfully added gift cards to the cart");
		giftcard.gotocheckout().click();
		Thread.sleep(5000);
		giftcard.closingwhatsappframe().click();
		Thread.sleep(7000);
		giftcard.goingbacktocart().click();
		if (driver.getPageSource().contains("Shopping Cart")) {
			System.out.println("Succesfully added to cart");
		}
		er.endTest();
	}

//	Test case for clicking on a product on the home page and adding it to card after adding it to the wish list

	@Test(priority = 6)
	public void AddToCart() throws InterruptedException, IOException {

		homepage.logo().click();
		Thread.sleep(2000);
		homepage.product().click();
		productcmon.getWishlist().click();
		for (int i = 0; i < 1; i++) {
			productcmon.getAdd().click();
		}
		Thread.sleep(5000);
		productcmon.getAddtocart().click();
		er.startTest("Adding a product from the home page to cart");
		productcmon.getCloseShoppinglist().click();
		Thread.sleep(2000);
		er.endTest();
	}

	// Test case for searching products in the search box
	@Test(priority = 7)
	public void SearchForProduct() throws IOException, InterruptedException {
		homepage.logo().click();
		ArrayList<String> products = ex.getData("search");
		for (int i = 1; i < products.size(); i++) {
			homepage.searchbox().clear();
			homepage.searchbox().sendKeys(products.get(i));
			homepage.searchbox().sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			log.info("Searching for products");
			if (homepage.getSearchtext().getText().contains("Search Results")) {
				Assert.assertTrue(true);
			}
			er.startTest("Successfully searched for the product");

		}
		er.endTest();

	}

	// Test case for adding the best selling product to wish list in the What's new
	// page
	@Test(priority = 8)
	public void validateWhatsnewPage() throws IOException, InterruptedException {

		homepage.logo().click();
		whatsnew.getBtn().click();
		if (whatsnew.getValidate().getText().contains("What'S New")) {
			Assert.assertTrue(true);
			log.info("Validating text in What's new page");
		}
		Select s = new Select(productcmon.getSortBy());
		s.selectByValue("best-selling");
		productcmon.getProducts().get(0).click();
		productcmon.getWishlist().click();
		er.startTest("Successfully added to wishlist from what's new page");
		Thread.sleep(2000);
		er.endTest();
	}

	// Test case to check the name of the least priced product in gifts page
	@Test(priority = 9)
	public void GiftsPage() throws IOException {

		homepage.logo().click();
		Actions a = new Actions(driver);
		WebElement move = gift.getGifts();
		a.moveToElement(move).build().perform();
		gift.getDIY().click();
		log.info("Clicking on DIY gifts under Gifts option");
		if (gift.getValidate().getText().contains("DIY Gifts")) {
			Assert.assertTrue(true);
		}
		Select s = new Select(gift.getSortBy());
		s.selectByValue("price-ascending");
		er.startTest("Successfully searched the least priced product and the price");
		System.out.println(productcmon.getProducts().get(0).getText());
		System.out.println(gift.getProductsPrice().get(0).getText());
		log.info("Finding the name and price of the least priced product");
		er.endTest();
	}

	// Test case to find a product in the Personalized Gifts page
	@Test(priority = 10)
	public void PersonalisedGiftsPage() throws IOException, InterruptedException {

		ArrayList<String> name = ex.getData("personalised");
		homepage.logo().click();
		int i = 1;
		personalGifts.getPGBtn().click();
		if (personalGifts.getValidate().getText().contains(name.get(i))) {
			i++;
			Assert.assertTrue(true);
			log.info("Validating the text in Personalized Gifts page");
		}
		for (int j = 0; j < personalGifts.getProducts().size(); j++) {
			if (personalGifts.getProducts().get(j).getText().contains(name.get(i))) {
				personalGifts.getProducts().get(j).click();
				er.startTest("Successfully searched for the product from Personalized Gifts page");
				Thread.sleep(2000);
				System.out.println("Product found!");
				log.info("Finding a required product");
				break;
			}
		}
		er.endTest();
	}

}
