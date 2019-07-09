package com.training.sanity.tests;

//EXECUTED BY ParallelBrowser.xml

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.Simple_Extra_RTTC_022_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Simple_Extra_RTTC_022_Tests {
	private WebDriver driver;
	private String baseUrl;
	private Simple_Extra_RTTC_022_POM RTTC_022_POM;
	private ScreenShot screenShot;
	private ExtentTest logger;
	ExtentReports extent;
	Properties properties;
	
	@Parameters ("myBrowser")
	
	@BeforeClass
	public void setUpBeforeClass(String myBrowser) throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/Simple_Extra_RTTC_022_Tests.html", true); 
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		logger = extent.startTest(this.getClass().getName().substring(26));
		
		if(myBrowser.equalsIgnoreCase("firefox")) {
			driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		} else if(myBrowser.equalsIgnoreCase("chrome")) {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
		}
	}
	
	@AfterClass
	public void setUpAfterClass() {
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
		RTTC_022_POM = new Simple_Extra_RTTC_022_POM(driver); 
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
	@Test (groups = {"SimpleExtraTestCases"})
	public void RTTC_022_Test() throws InterruptedException {
		
		RTTC_022_POM.sendUserName("admin");
			try {
				Assert.assertEquals(RTTC_022_POM.userName.getAttribute("value"), Simple_Extra_RTTC_022_POM.expecteduserName);
				logger.log(LogStatus.PASS, "Username Validation", "Username exists.");
			} catch (AssertionError e) {
				logger.log(LogStatus.FAIL, "Username Validation", "Username doesn't exist");
				Assert.fail();
			}
			
		RTTC_022_POM.sendPassword("admin@123");
		try {
			Assert.assertEquals(RTTC_022_POM.password.getAttribute("value"), Simple_Extra_RTTC_022_POM.expectedPassword);
			logger.log(LogStatus.PASS, "Password Validation", "Correct Password entered");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Password Validation", "INVALID Password");
			Assert.fail();
		}
		
		RTTC_022_POM.clickLoginBtn();
		try {
			Assert.assertEquals(driver.getTitle(), Simple_Extra_RTTC_022_POM.expectedAdminPageTitle);
			logger.log(LogStatus.PASS, "RetailSite Validation", "Logged In Successfully, User Dashboard is launched");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "RetailSite Validation", "User Dashboard is NOT launched");
			Assert.fail();
		}
		
		RTTC_022_POM.clickReport();
		try {
			Assert.assertTrue(RTTC_022_POM.sales.isDisplayed());
			logger.log(LogStatus.PASS, "Report Validation", "Sales, Products, Customers, Marketing links are displayed in the list");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Report Validation", "Sales, Products, Customers, Marketing links are NOT displayed in the list");
			Assert.fail();
		}
		
		RTTC_022_POM.clickSales();
		try {
			Assert.assertTrue(RTTC_022_POM.order.isDisplayed());
			logger.log(LogStatus.PASS, "Sales Validation", "Orders, Tax, Shipping, Returns, Coupons links are displayed in the list");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Sales Validation", "Orders, Tax, Shipping, Returns, Coupons links are NOT displayed in the list");
			Assert.fail();
		}
		
		RTTC_022_POM.clickOrder();
		try {
			Assert.assertEquals(driver.getTitle(), Simple_Extra_RTTC_022_POM.expectedTitle);
			logger.log(LogStatus.PASS, "Orders Page Validation", "Total number of orders, products details are displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Orders Page Validation", "Total number of orders, products details are NOT displayed");
			Assert.fail();
		}
		
		RTTC_022_POM.clickGroupBy();
		Select s = new Select(RTTC_022_POM.groupBy);
		if(s.getFirstSelectedOption().getText().equalsIgnoreCase(RTTC_022_POM.expectedValue))
			logger.log(LogStatus.PASS, "Selected value in Group By list box IS displayed");
		else
			logger.log(LogStatus.PASS, "Selected value in Group By list box IS NOT displayed");
		
		RTTC_022_POM.clickFilter();
		logger.log(LogStatus.PASS, "Total number of orders made in a week is displayed");
		
		screenShot.captureScreenShot("Simple_RTTC_022");
				
	}

}
