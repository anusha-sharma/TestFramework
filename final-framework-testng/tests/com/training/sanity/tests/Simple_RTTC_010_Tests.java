package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.Simple_RTTC_010_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Simple_RTTC_010_Tests {
	private WebDriver driver;
	private String baseUrl;
	private Simple_RTTC_010_POM RTTC_010_POM;
	private ScreenShot screenShot;
	private ExtentTest logger;
	ExtentReports extent;
	Properties properties;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/Simple_RTTC_010_Tests.html", true); 
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		logger = extent.startTest(this.getClass().getName().substring(26));
	}
	
	@AfterClass
	public void setUpAfterClass() {
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RTTC_010_POM = new Simple_RTTC_010_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger.log(LogStatus.PASS, "Admin URL opened");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		logger.log(LogStatus.PASS, "Browser Closed");
	}
	@Test (groups = {"SimpleTestCases"})
	public void RTTC_010_Test() throws InterruptedException {
		RTTC_010_POM.clickEthnic();
		System.out.println(driver.getTitle());
		try {
			Assert.assertEquals(driver.getTitle(), Simple_RTTC_010_POM.expectedTitle);
			logger.log(LogStatus.PASS, "EthnicPage Validation", "Product matching ETHNIC category is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "EthnicPage Validation", "Product matching ETHNIC category is NOT displayed");
			Assert.fail();
		}
		
		RTTC_010_POM.clickInteger();
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		Thread.sleep(2000);
		System.out.println(tabs);
		driver.switchTo().window(tabs.get(1));
		System.out.println(driver.getTitle());
		try {
			Assert.assertEquals(driver.getTitle(), Simple_RTTC_010_POM.expectedTitle1);
			logger.log(LogStatus.PASS, "IntegerPage Validation", "Complete Details of Integer Vitae Iaculis Massa is displayed in the next page");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "IntegerPage Validation", "Complete Details of Integer Vitae Iaculis Massa IS NOT displayed in the next page");
			Assert.fail();
		}
		
		RTTC_010_POM.clickAddToCart();
		logger.log(LogStatus.PASS, "Clicked on Add To Cart");
		try {
			Assert.assertEquals(RTTC_010_POM.message.getText(), Simple_RTTC_010_POM.expectedMessage);
			logger.log(LogStatus.PASS, "Message Validation", "'Shopping Cart updated!' Message is displayed on pop up window");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Message Validation", "'Shopping Cart updated!' Message IS NOT displayed on pop up window");
			Assert.fail();
		}
		Thread.sleep(2000);
		
		RTTC_010_POM.clickClosePopUp();
		logger.log(LogStatus.PASS, "Closed POP UP Window");
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(RTTC_010_POM.shoppingCart).build().perform();
		logger.log(LogStatus.PASS, "Mouseover to Cart Icon performed");
		Thread.sleep(5000);
		try {
			Assert.assertEquals(RTTC_010_POM.popUpWindow.getText(), Simple_RTTC_010_POM.expectedTitle1);
			logger.log(LogStatus.PASS, "popUpMessage Validation", "Pop up window displaying the product details is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "popUpMessage Validation", "Pop up window displaying the product details IS NOT displayed");
			Assert.fail();
		}
		act.moveToElement(RTTC_010_POM.viewCart).click().build().perform();
		logger.log(LogStatus.PASS, "Clicked on VIEW CART button");
		Thread.sleep(2000);
		try {
			Assert.assertEquals(driver.getTitle(), Simple_RTTC_010_POM.expectedTitle2);
			logger.log(LogStatus.PASS, "Shopping Cart Page Validation", "Product details containing Image, Product Name, Model, Quantity, Unit Price & Total is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Shopping Cart Page Validation", "Product details containing Image, Product Name, Model, Quantity, Unit Price & Total IS NOT displayed");
			Assert.fail();
		}
		Thread.sleep(2000);
		
		RTTC_010_POM.clickRemove();
		RTTC_010_POM.clickUpdate();
		try {
			Assert.assertEquals(RTTC_010_POM.msg.getText(), Simple_RTTC_010_POM.expectedMsg);
			logger.log(LogStatus.PASS, "Remove Validation", "'Your shopping cart is empty!'- Message IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Remove Validation", "'Your shopping cart is empty!'- Message IS NOT displayed");
			Assert.fail();
		}
		Thread.sleep(2000);
		screenShot.captureScreenShot("Simple_RTTC_010");
	}

}
