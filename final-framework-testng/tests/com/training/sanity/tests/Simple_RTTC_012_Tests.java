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
import com.training.pom.Simple_RTTC_012_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Simple_RTTC_012_Tests {
	private WebDriver driver;
	private String baseUrl;
	private Simple_RTTC_012_POM RTTC_012_POM;
	private ScreenShot screenShot;
	private ExtentTest logger;
	ExtentReports extent;
	Properties properties;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/Simple_RTTC_012_Tests.html", true); 
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
		RTTC_012_POM = new Simple_RTTC_012_POM(driver); 
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
	@Test (groups = {"SimpleTestCases"})
	public void RTTC_012_Test() {
		
		RTTC_012_POM.sendUserName("admin");
			try {
				Assert.assertEquals(RTTC_012_POM.userName.getAttribute("value"), Simple_RTTC_012_POM.expecteduserName);
				logger.log(LogStatus.PASS, "Username Validation", "Username exists.");
			} catch (AssertionError e) {
				logger.log(LogStatus.FAIL, "Username Validation", "Username doesn't exist");
				Assert.fail();
			}
			
		RTTC_012_POM.sendPassword("admin@123");
		try {
			Assert.assertEquals(RTTC_012_POM.password.getAttribute("value"), Simple_RTTC_012_POM.expectedPassword);
			logger.log(LogStatus.PASS, "Password Validation", "Correct Password entered");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Password Validation", "INVALID Password");
			Assert.fail();
		}
		
		RTTC_012_POM.clickLoginBtn();
		try {
			Assert.assertEquals(driver.getTitle(), Simple_RTTC_012_POM.expectedAdminPageTitle);
			logger.log(LogStatus.PASS, "RetailSite Validation", "Logged In Successfully, User Dashboard is launched");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "RetailSite Validation", "User Dashboard is NOT launched");
			Assert.fail();
		}
		
		RTTC_012_POM.clickCatalog();
		if (RTTC_012_POM.categories.isDisplayed())
			logger.log(LogStatus.PASS, "Clicked on Catalog Icon. Categories, Products, Recurring Products links are displayed");
		else
			logger.log(LogStatus.FAIL, "Categories, Products, Recurring Products links are NOT displayed");
		
		RTTC_012_POM.clickCategories();
		try {
			Assert.assertEquals(RTTC_012_POM.categoryList.getText(), Simple_RTTC_012_POM.expectedText);
			logger.log(LogStatus.PASS, "Categories Validation", "Categories page containing Category Name, Sort Order & Actions for list of categories IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Categories Validation", "Categories page containing Category Name, Sort Order & Actions for list of categories IS NOT displayed");
			Assert.fail();
		}
		screenShot.captureScreenShot("Simple_RTTC_012");
				
	}


}
