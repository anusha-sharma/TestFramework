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
import com.training.dataproviders.Complex_RTTC_072_DataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Complex_RTTC_072_POM;
import com.training.pom.Complex_RTTC_072_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Complex_RTTC_072_Tests {
	private WebDriver driver;
	private String baseUrl;
	private Complex_RTTC_072_POM RTTC_072_POM;
	private ScreenShot screenShot;
	private ExtentTest logger;
	ExtentReports extent;
	Properties properties;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/Complex_RTTC_072_Tests.html", true); 
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
		RTTC_072_POM = new Complex_RTTC_072_POM(driver); 
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
	

	@Test (groups = {"ComplexTestCases"}, dataProvider = "RTTC_072_excel-inputs", dataProviderClass = Complex_RTTC_072_DataProviders.class)
	public void RTTC_072_Test(String userName, String password, String ProductName, String MetaTitle, String Model, String Price, String Category, String Quantity, String DiscountPrice, String Points) {
		
		RTTC_072_POM.sendUserName("admin");
		try {
			Assert.assertEquals(RTTC_072_POM.userName.getAttribute("value"), userName);
			logger.log(LogStatus.PASS, "Username Validation", "Username exists.");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Username Validation", "Username doesn't exist");
			Assert.fail();
		}
		
		RTTC_072_POM.sendPassword("admin@123");
		try {
			Assert.assertEquals(RTTC_072_POM.password.getAttribute("value"), password);
			logger.log(LogStatus.PASS, "Password Validation", "Correct Password entered");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Password Validation", "INVALID Password");
			Assert.fail();
		}
		
		RTTC_072_POM.clickLoginBtn();
		logger.log(LogStatus.PASS, "Logged In Successfully");
		
		RTTC_072_POM.clickCatalog();
		logger.log(LogStatus.PASS, "Clicked on Catalog Icon");
		
		RTTC_072_POM.clickProducts();
		logger.log(LogStatus.PASS, "Clicked on Products link");
		try {
			Assert.assertEquals(driver.getTitle(), Complex_RTTC_072_POM.expectedTitle);
			logger.log(LogStatus.PASS, "ProductsPage Validation", "Products Page Opened");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "ProductsPage Validation", "Products Page DIDn't Open");
			Assert.fail();
		}
		
		RTTC_072_POM.clickAddNew();
		try {
			Assert.assertEquals(RTTC_072_POM.pageTitle.getText(), Complex_RTTC_072_POM.expectedPageTitle);
			logger.log(LogStatus.PASS, "PageTitle Validation", "Add Product page is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "PageTitle Validation", "Add Product page is NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendProductName(ProductName);
		try {
			Assert.assertEquals(RTTC_072_POM.productName.getAttribute("value"), ProductName);
			logger.log(LogStatus.PASS, "ProductName Validation", "Entered credentials in Product Name of General tab is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "ProductName Validation", "Entered credentials in Product Name of General tab is NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendMetaTagTitle(MetaTitle);
		try {
			Assert.assertEquals(RTTC_072_POM.metaTagTitle.getAttribute("value"), MetaTitle);
			logger.log(LogStatus.PASS, "MetaTitle Validation", "Entered credentials in Meta Tag Title of General tab IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "MetaTitle Validation", "Entered credentials in Meta Tag Title of General tab is NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.clickDataTab();
		try {
			Assert.assertTrue(RTTC_072_POM.modelLabel.isDisplayed());
			logger.log(LogStatus.PASS, "DataTab Validation", "Data tab fields IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "DataTab Validation", "Data tab fields IS NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendModelName(Model);
		try {
			Assert.assertEquals(RTTC_072_POM.modelName.getAttribute("value"), Model);
			logger.log(LogStatus.PASS, "Model Validation", "Entered credentials in Model textbox IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Model Validation", "Entered credentials in Model textbox IS NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendPrice(Price);
		try {
			Assert.assertEquals(RTTC_072_POM.price.getAttribute("value"), Price);
			logger.log(LogStatus.PASS, "Price Validation", "Entered credentials in Price textbox IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Price Validation", "Entered credentials in Price textbox IS NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendQuantity(Quantity);
		try {
			Assert.assertEquals(RTTC_072_POM.quantity.getAttribute("value"), Quantity);
			logger.log(LogStatus.PASS, "Quantity Validation", "Entered credentials in Quantity textbox IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Quantity Validation", "Entered credentials in Quantity textbox IS NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.clickLinkTab();
		try {
			Assert.assertTrue(RTTC_072_POM.manufacturer.isDisplayed());
			logger.log(LogStatus.PASS, "LinkTab Validation", "Links tab fields IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "LinkTab Validation", "Links tab fields IS NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendCategory(Category);
		try {
			Assert.assertTrue(RTTC_072_POM.selectedCategory.getText().contains(Category));
			logger.log(LogStatus.PASS, "Category Validation", "Selected Value IS added in the textbox");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Category Validation", "Selected Value IS NOT added in the textbox");
			Assert.fail();
		}
		
		RTTC_072_POM.clickDiscountTab();
		try {
			Assert.assertTrue(RTTC_072_POM.customerGroup.isDisplayed());
			logger.log(LogStatus.PASS, "DiscountTab Validation", "Discount tab IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "DiscountTab Validation", "Discount tab IS NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.clickAddDiscount();
		try {
			Assert.assertTrue(RTTC_072_POM.discountQuantity.isEnabled());
			logger.log(LogStatus.PASS, "AddDiscount Validation", "Fields to add discount is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "AddDiscount Validation", "Fields to add discount is NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendDiscountQuantity(Quantity);
		try {
			Assert.assertEquals(RTTC_072_POM.discountQuantity.getAttribute("value"), Quantity);
			logger.log(LogStatus.PASS, "DiscountQuantity Validation", "Entered credentials in Quantity textbox of Discount tab IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "DiscountQuantity Validation", "Entered credentials in Quantity textbox of Discount tab IS NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendDiscountPrice(DiscountPrice);;
		try {
			Assert.assertEquals(RTTC_072_POM.discountPrice.getAttribute("value"), DiscountPrice);
			logger.log(LogStatus.PASS, "DiscountPrice Validation", "Entered credentials in Price textbox of Discount tab IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "DiscountPrice Validation", "Entered credentials in Price textbox of Discount tab IS NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendStartDate("2019-07-05");
		try {
			Assert.assertEquals(RTTC_072_POM.startDate.getAttribute("value"), RTTC_072_POM.expectedStartDate);
			logger.log(LogStatus.PASS, "StartDate Validation", "selected date in start date is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "StartDate Validation", "selected date in start date is NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendEndDate("2019-07-07");
		try {
			Assert.assertEquals(RTTC_072_POM.endDate.getAttribute("value"), RTTC_072_POM.expectedEndDate);
			logger.log(LogStatus.PASS, "EndDate Validation", "selected date in end date is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "EndDate Validation", "selected date in end date is NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.clickRewardPointsTab();
		try {
			Assert.assertTrue(RTTC_072_POM.points.isEnabled());
			logger.log(LogStatus.PASS, "RewardPointsTab Validation", "Rewards Points tab is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "RewardPointsTab Validation", "Rewards Points tab is NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.sendPoints(Points);
		try {
			Assert.assertEquals(RTTC_072_POM.points.getAttribute("value"), Points);
			logger.log(LogStatus.PASS, "Points Validation", "entered credentials in Points textbox IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Points Validation", "entered credentials in Points textbox IS NOT displayed");
			Assert.fail();
		}
		
		RTTC_072_POM.clickSave();
		try {
			Assert.assertTrue(RTTC_072_POM.warning.getText().contains(RTTC_072_POM.expectedAlertMessage));
			logger.log(LogStatus.PASS, "Save Validation", "Error message is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Save Validation", "Error message is NOT displayed");
			Assert.fail();
		}
		
		/*System.out.println(userName);
		System.out.println(password);
		System.out.println(ProductName);
		System.out.println(MetaTitle);
		System.out.println(Model);
		System.out.println(Price);
		System.out.println(Category);
		System.out.println(Quantity);
		System.out.println(DiscountPrice);
		System.out.println(Points);*/
		
		screenShot.captureScreenShot("Complex_RTTC_072");
	}

}
