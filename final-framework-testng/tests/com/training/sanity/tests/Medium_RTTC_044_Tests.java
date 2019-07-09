package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
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
import com.training.pom.Medium_RTTC_044_POM;
import com.training.pom.Medium_RTTC_044_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium_RTTC_044_Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private Medium_RTTC_044_POM RTTC_044_POM;
	private ScreenShot screenShot;
	private ExtentTest logger;
	ExtentReports extent;
	Properties properties;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/Medium_RTTC_044_Tests.html", true); 
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
		RTTC_044_POM = new Medium_RTTC_044_POM(driver); 
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
	public void RTTC_044_Test() {
		
		RTTC_044_POM.sendUserName("admin");
			try {
				Assert.assertEquals(RTTC_044_POM.userName.getAttribute("value"), Medium_RTTC_044_POM.expectedUserName);
				logger.log(LogStatus.PASS, "Username Validation", "Username exists.");
			} catch (AssertionError e) {
				logger.log(LogStatus.FAIL, "Username Validation", "Username doesn't exist");
				Assert.fail();
			} 
			
		RTTC_044_POM.sendPassword("admin@123");
		 try {
			Assert.assertEquals(RTTC_044_POM.password.getAttribute("value"), Medium_RTTC_044_POM.expectedPassWord);
			logger.log(LogStatus.PASS, "Password Validation", "Correct Password entered");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Password Validation", "INVALID Password");
			Assert.fail();
		} 
		
		RTTC_044_POM.clickLoginBtn();
		logger.log(LogStatus.PASS, "Logged In Successfully");
		
		RTTC_044_POM.clickCatalog();
		logger.log(LogStatus.PASS, "Clicked on Catalog Icon");
		
		RTTC_044_POM.clickProducts();
		logger.log(LogStatus.PASS, "Clicked on Products link");
		try {
			Assert.assertEquals(driver.getTitle(), Medium_RTTC_044_POM.expectedTitle);
			logger.log(LogStatus.PASS, "ProductsPage Validation", "Products Page Opened");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "ProductsPage Validation", "Products Page DIDn't Open");
			Assert.fail();
		}
		
		RTTC_044_POM.check1();
		if(RTTC_044_POM.checkbox.get(0).isSelected())
			logger.log(LogStatus.PASS, "Check1 validation", "Checkbox-1 selected");
		else
			logger.log(LogStatus.FAIL, "Check1 validation", "Checkbox-1 NOT selected");
		
		RTTC_044_POM.check2();
		if(RTTC_044_POM.checkbox.get(1).isSelected())
			logger.log(LogStatus.PASS, "Check2 validation", "Checkbox-2 selected");
		else
			logger.log(LogStatus.FAIL, "Check2 validation", "Checkbox-2 NOT selected");
		
		RTTC_044_POM.earRingCheck();
		if(RTTC_044_POM.earRing.isSelected())
			logger.log(LogStatus.PASS, "earRingCheck validation", "Ear-Ring Checkbox selected");
		else
			logger.log(LogStatus.FAIL, "earRingCheck validation", "Ear-Ring Checkbox NOT selected");
		
		RTTC_044_POM.fingerRingCheck();
		if(RTTC_044_POM.fingerRing.isSelected())
			logger.log(LogStatus.PASS, "fingerRingCheck validation", "Finger-Ring Checkbox selected");
		else
			logger.log(LogStatus.FAIL, "fingerRingCheck validation", "Finger-Ring Checkbox NOT selected");
		
		RTTC_044_POM.clickDelete();		
		Alert a = driver.switchTo().alert();
		try {
			Assert.assertEquals(a.getText(), Medium_RTTC_044_POM.expectedAlertMsg);
			logger.log(LogStatus.PASS, "Alert Validation", "Delete Button clicked, Alert seen with msg-'Are you sure?'");
			a.accept();
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Alert Validation", "Delete Button NOT clicked, Alert NOT SEEN");
			Assert.fail();
		}
		
		try {
			Assert.assertEquals(RTTC_044_POM.success.getText().substring(0, 36), Medium_RTTC_044_POM.expectedAlertMessage);
			logger.log(LogStatus.PASS, "Delete Validation", "Products deleted. 'Success: You have modified products!' is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Delete Validation", "Success message not displayed");
			Assert.fail();
		}
		screenShot.captureScreenShot("Medium_RTTC_044");
		
	}

}
