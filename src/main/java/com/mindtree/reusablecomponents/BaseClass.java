package com.mindtree.reusablecomponents;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.mindtree.pageobjects.CreateAccount;
import com.mindtree.pageobjects.GiftCardPage;
import com.mindtree.pageobjects.Gifts;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.OfficialMerchandise;
import com.mindtree.pageobjects.PersonalisedGifts;
import com.mindtree.pageobjects.ProductPage;
import com.mindtree.pageobjects.ShopByCatPage;
import com.mindtree.pageobjects.SignIn;
import com.mindtree.pageobjects.WhatsNew;
import com.mindtree.utilities.ConfigsProvider;
import com.mindtree.utilities.Excel;
import com.mindtree.utilities.Extentreports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public static WebDriver driver;
	public static Logger log;
	public static ConfigsProvider config;
	// public static ExtentReports reporter;
	public static ExtentTest test;
	public static Extentreports er;

	public static HomePage homepage;
	public static SignIn signin;
	public static GiftCardPage giftcard;
	public static ProductPage productcmon;
	public static OfficialMerchandise officialMerchandise;
	public static ShopByCatPage shopbycat;
	public static CreateAccount createAcc;
	public static WhatsNew whatsnew;
	public static Gifts gift;
	public static PersonalisedGifts personalGifts;
	public Excel ex = new Excel();

	@BeforeSuite
	public void startup() throws IOException {

		log = Logger.getLogger(getClass());
		config = new ConfigsProvider();
//		reporter = new ExtentReporter(config.getExtentPath());
//		test = reporter.startTest("HomePage");
	}

	@BeforeClass
	public void beforeClass() {
		driver = WebDriverHelper.driverInitializer(driver, config.getBrowser(), config.implicitWait());
		log.info("Driver Initialised");
		er = new Extentreports(driver);

		homepage = new HomePage(driver);
		signin = new SignIn(driver);
		giftcard = new GiftCardPage(driver);
		productcmon = new ProductPage(driver);
		officialMerchandise = new OfficialMerchandise(driver);
		shopbycat = new ShopByCatPage(driver);
		createAcc = new CreateAccount(driver);
		whatsnew = new WhatsNew(driver);
		gift = new Gifts(driver);
		personalGifts = new PersonalisedGifts(driver);

	}

	@AfterClass
	public void classTeardown() {
		WebDriverHelper.quitDriver(driver);
		log.info("Driver Closed");
	}

}
