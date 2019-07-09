package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
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
import com.training.pom.Medium_RTTC_044_POM;
import com.training.pom.Medium_RTTC_046_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium_RTTC_046_Tests {
	private WebDriver driver;
	private String baseUrl;
	private Medium_RTTC_046_POM RTTC_046_POM;
	private ScreenShot screenShot;
	private ExtentTest logger;
	ExtentReports extent;
	Properties properties;
	String productToAdd = "Lorem ipsum dolor sit amet";
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/Medium_RTTC_046_Tests.html", true); 
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
		RTTC_046_POM = new Medium_RTTC_046_POM(driver); 
		baseUrl = properties.getProperty("adminURL");
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

	@Test (groups = {"MediumTestCases"})
	public void RTTC_046_Test() throws InterruptedException {
		RTTC_046_POM.sendUserName("admin");
		try {
			Assert.assertEquals(RTTC_046_POM.userName.getAttribute("value"), Medium_RTTC_046_POM.expectedUserName);
			logger.log(LogStatus.PASS, "Username Validation", "Username exists.");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Username Validation", "Username doesn't exist");
			Assert.fail();
		} 
		
		RTTC_046_POM.sendPassword("admin@123");
		 try {
			Assert.assertEquals(RTTC_046_POM.password.getAttribute("value"), Medium_RTTC_046_POM.expectedPassWord);
			logger.log(LogStatus.PASS, "Password Validation", "Correct Password entered");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Password Validation", "INVALID Password");
			Assert.fail();
		} 
		
		RTTC_046_POM.clickLoginBtn();
		logger.log(LogStatus.PASS, "Logged In Successfully");
		
		RTTC_046_POM.clickSales();
		logger.log(LogStatus.PASS, "Clicked on Sales Icon");
		
		RTTC_046_POM.clickOrders();
		logger.log(LogStatus.PASS, "Clicked On Orders Link");
		try {
			Assert.assertEquals(driver.getTitle(), Medium_RTTC_046_POM.expectedTitle);
			logger.log(LogStatus.PASS, "OrdersPage Validation", "Orders Page Opened, Order List displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "OrdersPage Validation", "Orders Page DIDn't Open");
			Assert.fail();
		}
		
		RTTC_046_POM.editOrderClick();
		try {
			Assert.assertEquals(RTTC_046_POM.pageTitle.getText(), Medium_RTTC_046_POM.expectedPageTitle);
			logger.log(LogStatus.PASS, "EditOrderPage Validation", "Edit Order Page displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "EditOrderPage Validation", "Edit Order Page NOT displayed");
			Assert.fail();
		}
		
		RTTC_046_POM.clickContinue();
		Thread.sleep(2000);
		try {
			Assert.assertEquals(RTTC_046_POM.productsTab.getText(), Medium_RTTC_046_POM.expectedTab);
			logger.log(LogStatus.PASS, "ProductTab Validation", "Products Tab is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "ProductTab Validation", "Products Tab is NOT displayed");
			Assert.fail();
		}
		
		RTTC_046_POM.clickRemove();
		Thread.sleep(4000);
		System.out.println(RTTC_046_POM.afterRemove.getText());
		try {
			Assert.assertEquals(RTTC_046_POM.afterRemove.getText(), Medium_RTTC_046_POM.expectedTextAfterRemove);
			logger.log(LogStatus.PASS, "Remove Validation", "Product is deleted");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Remove Validation", "Products is NOT deleted");
			Assert.fail();
		}
		
		RTTC_046_POM.sendChooseProduct(productToAdd);
		if(RTTC_046_POM.chooseProduct.isDisplayed())
			logger.log(LogStatus.PASS, "entered credentials in Choose Product textbox is displayed");
		else
			logger.log(LogStatus.FAIL, "entered credentials in Choose Product textbox is NOT displayed");
		
		RTTC_046_POM.sendQuantity("4");
		if(RTTC_046_POM.quantity.isDisplayed())
			logger.log(LogStatus.PASS, "entered credentials in Quantity textbox is displayed");
		else
			logger.log(LogStatus.FAIL, "entered credentials in Quantity textbox is NOT displayed");
		
		RTTC_046_POM.clickAddProduct();
		System.out.println(RTTC_046_POM.product.getText());
		if(RTTC_046_POM.product.getText().contains(productToAdd))
			logger.log(LogStatus.PASS, "Product Added! Product is displayed in products section");
		else
			logger.log(LogStatus.FAIL, "Products is NOT Added!");
		
		RTTC_046_POM.clickContinueProduct();
		Thread.sleep(2000);
		try {
			Assert.assertEquals(RTTC_046_POM.paymentTab.getText(), Medium_RTTC_046_POM.expectedPaymentTab);
			logger.log(LogStatus.PASS, "continueProduct Validation", "Payment details tab is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "continueProduct Validation", "Payment details tab is NOT displayed");
			Assert.fail();
		}
		
		RTTC_046_POM.clickContinuePayment();
		Thread.sleep(2000);
		try {
			Assert.assertEquals(RTTC_046_POM.shippingTab.getText(), Medium_RTTC_046_POM.expectedShippingTab);
			logger.log(LogStatus.PASS, "continuePayment Validation", "Shipping details tab is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "continuePayment Validation", "Shipping details tab is NOT displayed");
			Assert.fail();
		}
		
		RTTC_046_POM.clickContinueShipping();
		Thread.sleep(2000);
		try {
			Assert.assertEquals(RTTC_046_POM.totalsTab.getText(), Medium_RTTC_046_POM.expectedTotalTab);
			logger.log(LogStatus.PASS, "continueShipping Validation", "Totals tab is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "continueShipping Validation", "Totals tab is NOT displayed");
			Assert.fail();
		}
		
		RTTC_046_POM.selectInput();		
		RTTC_046_POM.clickSave();
		System.out.println(RTTC_046_POM.success.getText().substring(0, 34));
		try {
			Assert.assertEquals(RTTC_046_POM.success.getText().substring(0, 34), Medium_RTTC_046_POM.expectedAlertMessage);
			logger.log(LogStatus.PASS, "Save Validation", "'Success: You have modified orders!' is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Save Validation", "Success message not displayed");
			Assert.fail();
		}	
		
		screenShot.captureScreenShot("Medium_RTTC_046");
		}

}
