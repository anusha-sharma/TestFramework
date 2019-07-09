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
import com.training.pom.Medium_RTTC_043_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium_RTTC_043_Tests {

	private WebDriver driver;
	private String baseUrl;
	private Medium_RTTC_043_POM RTTC_043_POM;
	private ScreenShot screenShot;
	private ExtentTest logger;
	ExtentReports extent;
	Properties properties;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/Medium_RTTC_043_Tests.html", true); 
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
		RTTC_043_POM = new Medium_RTTC_043_POM(driver); 
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
	public void RTTC_043_Test() {
		
		RTTC_043_POM.sendUserName("admin");
			try {
				Assert.assertEquals(RTTC_043_POM.userName.getAttribute("value"), Medium_RTTC_043_POM.expectedUserName);
				logger.log(LogStatus.PASS, "Username Validation", "Username exists.");
			} catch (AssertionError e) {
				logger.log(LogStatus.FAIL, "Username Validation", "Username doesn't exist");
				Assert.fail();
			}
			
		RTTC_043_POM.sendPassword("admin@123");
		try {
			Assert.assertEquals(RTTC_043_POM.password.getAttribute("value"), Medium_RTTC_043_POM.expectedPassWord);
			logger.log(LogStatus.PASS, "Password Validation", "Correct Password entered");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Password Validation", "INVALID Password");
			Assert.fail();
		}
		
		RTTC_043_POM.clickLoginBtn();
		logger.log(LogStatus.PASS, "Logged In Successfully");	
		
		RTTC_043_POM.clickCatalog();
		logger.log(LogStatus.PASS, "Clicked on Catalog Icon");
		
		RTTC_043_POM.clickProducts();
		logger.log(LogStatus.PASS, "Clicked on Products link");
		try {
			Assert.assertEquals(driver.getTitle(), Medium_RTTC_043_POM.expectedTitle);
			logger.log(LogStatus.PASS, "ProductsPage Validation", "Products Page Opened");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "ProductsPage Validation", "Products Page DIDn't Open");
			Assert.fail();
		}
		
		RTTC_043_POM.clickEditIcon();
		logger.log(LogStatus.PASS, "clicked on Edit Icon");
		try {
			Assert.assertEquals(RTTC_043_POM.pageTitle.getText(), Medium_RTTC_043_POM.expectedPageTitle);
			logger.log(LogStatus.PASS, "PageTitle Validation", "Edit Product Page Opened");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "PageTitle Validation", "Edit Product Page DID NOT Open");
			Assert.fail();
		}
		
		RTTC_043_POM.clickData();
		logger.log(LogStatus.PASS, "Data tab fields are displayed");
		RTTC_043_POM.clearQuantity();
		logger.log(LogStatus.PASS, "Data present in Quantity textbox is erased");
		RTTC_043_POM.sendQuantity(2000);
		logger.log(LogStatus.PASS, "Entered credentials in Quantity textbox is displayed");
		RTTC_043_POM.sendSeoUrl("abcd");
		
		RTTC_043_POM.saveProduct();
		try {
			Assert.assertEquals(RTTC_043_POM.success.getText().substring(0, 36), Medium_RTTC_043_POM.expectedAlertMessage);
			logger.log(LogStatus.PASS, "Save Validation", "Success: You have modified products! is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Save Validation", "Success message not displayed");
			Assert.fail();
		}
		screenShot.captureScreenShot("Medium_RTTC_043");
				
	}

}
