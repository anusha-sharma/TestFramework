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
import com.training.pom.Simple_Extra_RTTC_023_POM;
import com.training.pom.Simple_Extra_RTTC_023_POM;
import com.training.pom.Simple_Extra_RTTC_023_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Simple_Extra_RTTC_023_Tests {
	private WebDriver driver;
	private String baseUrl;
	private Simple_Extra_RTTC_023_POM RTTC_023_POM;
	private ScreenShot screenShot;
	private ExtentTest logger;
	ExtentReports extent;
	Properties properties;
	
	@Parameters ("myBrowser")
	
	@BeforeClass
	public void setUpBeforeClass(String myBrowser) throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/Simple_Extra_RTTC_023_Tests.html", true); 
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
		
		RTTC_023_POM = new Simple_Extra_RTTC_023_POM(driver); 
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
	public void RTTC_023_Test() throws InterruptedException {
		RTTC_023_POM.sendUserName("admin");
		try {
			Assert.assertEquals(RTTC_023_POM.userName.getAttribute("value"), Simple_Extra_RTTC_023_POM.expecteduserName);
			logger.log(LogStatus.PASS, "Username Validation", "Username exists.");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Username Validation", "Username doesn't exist");
			Assert.fail();
		}
		
	RTTC_023_POM.sendPassword("admin@123");
	try {
		Assert.assertEquals(RTTC_023_POM.password.getAttribute("value"), Simple_Extra_RTTC_023_POM.expectedPassword);
		logger.log(LogStatus.PASS, "Password Validation", "Correct Password entered");
	} catch (AssertionError e) {
		logger.log(LogStatus.FAIL, "Password Validation", "INVALID Password");
		Assert.fail();
	}
	
	RTTC_023_POM.clickLoginBtn();
	try {
		Assert.assertEquals(driver.getTitle(), Simple_Extra_RTTC_023_POM.expectedAdminPageTitle);
		logger.log(LogStatus.PASS, "RetailSite Validation", "Logged In Successfully, User Dashboard is launched");
	} catch (AssertionError e) {
		logger.log(LogStatus.FAIL, "RetailSite Validation", "User Dashboard is NOT launched");
		Assert.fail();
	}
	System.out.println(RTTC_023_POM.sales.isDisplayed());
	RTTC_023_POM.clickReport();
	System.out.println(RTTC_023_POM.sales.isDisplayed());
	try {
		Assert.assertTrue(RTTC_023_POM.sales.isDisplayed());
		logger.log(LogStatus.PASS, "Report Validation", "Sales, Products, Customers, Marketing links are displayed in the list");
	} catch (AssertionError e) {
		logger.log(LogStatus.FAIL, "Report Validation", "Sales, Products, Customers, Marketing links are NOT displayed in the list");
		Assert.fail();
	}
	System.out.println(RTTC_023_POM.tax.isDisplayed());
	RTTC_023_POM.clickSales();
	System.out.println(RTTC_023_POM.tax.isDisplayed());
	try {
		Assert.assertTrue(RTTC_023_POM.tax.isDisplayed());
		logger.log(LogStatus.PASS, "Sales Validation", "Orders, Tax, Shipping, Returns, Coupons links are displayed in the list");
	} catch (AssertionError e) {
		logger.log(LogStatus.FAIL, "Sales Validation", "Orders, Tax, Shipping, Returns, Coupons links are NOT displayed in the list");
		Assert.fail();
	}
	
	RTTC_023_POM.clickTax();
	try {
		Assert.assertEquals(driver.getTitle(), Simple_Extra_RTTC_023_POM.expectedTitle);
		logger.log(LogStatus.PASS, "Tax Page Validation", "Total number of orders, products details are displayed");
	} catch (AssertionError e) {
		logger.log(LogStatus.FAIL, "Tax Page Validation", "Total number of orders, products details are NOT displayed");
		Assert.fail();
	}
	
	RTTC_023_POM.clickGroupBy();
	Select s = new Select(RTTC_023_POM.groupBy);
	if(s.getFirstSelectedOption().getText().equalsIgnoreCase(RTTC_023_POM.expectedValue))
		logger.log(LogStatus.PASS, "Selected value in Group By list box IS displayed");
	else
		logger.log(LogStatus.PASS, "Selected value in Group By list box IS NOT displayed");
	
	RTTC_023_POM.clickFilter();
	logger.log(LogStatus.PASS, "Total number of tax for orders made in a week is displayed");
	
	screenShot.captureScreenShot("Simple_RTTC_023");
	
	}

}
