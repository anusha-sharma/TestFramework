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
import com.training.pom.Medium_RTTC_045_POM;
import com.training.pom.Medium_RTTC_045_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium_RTTC_045_Tests {
	private WebDriver driver;
	private String baseUrl;
	private Medium_RTTC_045_POM RTTC_045_POM;
	private ScreenShot screenShot;
	private ExtentTest logger;
	ExtentReports extent;
	Properties properties;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/Medium_RTTC_045_Tests.html", true); 
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
		RTTC_045_POM = new Medium_RTTC_045_POM(driver); 
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
	public void RTTC_045_Test() {
		RTTC_045_POM.sendUserName("admin");
		try {
			Assert.assertEquals(RTTC_045_POM.userName.getAttribute("value"), Medium_RTTC_045_POM.expectedUserName);
			logger.log(LogStatus.PASS, "Username Validation", "Username exists.");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Username Validation", "Username doesn't exist");
			Assert.fail();
		} 
		
		RTTC_045_POM.sendPassword("admin@123");
		 try {
			Assert.assertEquals(RTTC_045_POM.password.getAttribute("value"), Medium_RTTC_045_POM.expectedPassWord);
			logger.log(LogStatus.PASS, "Password Validation", "Correct Password entered");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Password Validation", "INVALID Password");
			Assert.fail();
		} 
		
		RTTC_045_POM.clickLoginBtn();
		logger.log(LogStatus.PASS, "Logged In Successfully");
		
		RTTC_045_POM.clickSales();
		logger.log(LogStatus.PASS, "Clicked on Sales Icon");
		
		RTTC_045_POM.clickOrders();
		logger.log(LogStatus.PASS, "Clicked On Orders Link");
		try {
			Assert.assertEquals(driver.getTitle(), Medium_RTTC_045_POM.expectedTitle);
			logger.log(LogStatus.PASS, "OrdersPage Validation", "Orders Page Opened, Order List displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "OrdersPage Validation", "Orders Page DIDn't Open");
			Assert.fail();
		}
		
		RTTC_045_POM.clickViewIcon();
		logger.log(LogStatus.PASS, "Clicked on View Icon");
		try {
			Assert.assertEquals(RTTC_045_POM.ODT.getText(), Medium_RTTC_045_POM.expectedODT);
			logger.log(LogStatus.PASS, "ODT Validation", "Details of Ordered Product displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "ODT Validation", "Details of Ordered Product NOT displayed");
			Assert.fail();
		}
		
		RTTC_045_POM.clickGenerate();
		logger.log(LogStatus.PASS, "Clicked on Generate Icon");
		if(RTTC_045_POM.invoice.isDisplayed())
			logger.log(LogStatus.PASS, "Invoice validation", "Invoice number is displayed");
		else
			logger.log(LogStatus.FAIL, "Invoice validation", "Invoice number is NOT displayed");
		
		screenShot.captureScreenShot("Medium_RTTC_044");
		}

}
