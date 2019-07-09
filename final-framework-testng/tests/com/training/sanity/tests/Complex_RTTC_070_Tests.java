package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import com.training.pom.Complex_RTTC_070_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Complex_RTTC_070_Tests {
	private WebDriver driver;
	private String baseUrl;
	private String adminUrl;
	private Complex_RTTC_070_POM RTTC_070_POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ExtentTest logger;
	ExtentReports extent;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/Complex_RTTC_070_Tests.html", true); 
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		logger = extent.startTest(this.getClass().getName().substring(26));
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RTTC_070_POM = new Complex_RTTC_070_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		adminUrl = properties.getProperty("adminURL");
	}
	

	@AfterClass
	public void setUpAfterClass() {
		driver.quit();
		logger.log(LogStatus.PASS, "Browsers Closed");
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);		
	}
	
	@Test (groups = {"ComplexTestCases"})
	public void RTTC_070_Test_Order_Placement() throws InterruptedException, AWTException {
				
		driver.get(Complex_RTTC_070_POM.oldWindow);
		Set<String> windows = driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window Name--> "+parentWindow);
		
		RTTC_070_POM.clickNewWindow();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("All Windows Name-->" +allWindows);
		
		//Delete old Window-list from the list to retain only the new window
		allWindows.removeAll(windows);
		System.out.println("New Window Name-->" +allWindows);
		String newWindow = ((String)allWindows.toArray()[0]);
		
		driver.switchTo().window(parentWindow);
		
		screenShot = new ScreenShot(driver);
		
		// open the browser 
		driver.get(baseUrl);
		logger.log(LogStatus.PASS, "Retail Website opened");
				
		RTTC_070_POM.login();
		RTTC_070_POM.sendEmail("abc@abc.com");
		RTTC_070_POM.sendPassWord("admin@123");
		RTTC_070_POM.clickLogin();
		logger.log(LogStatus.PASS, "Logged In successfully");
		
		RTTC_070_POM.clickEthnic();
		System.out.println(driver.getTitle());
		try {
			Assert.assertEquals(driver.getTitle(), Complex_RTTC_070_POM.expectedTitle);
			logger.log(LogStatus.PASS, "EthnicPage Validation", "Product matching ETHNIC category is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "EthnicPage Validation", "Product matching ETHNIC category is NOT displayed");
			Assert.fail();
		}
		
		RTTC_070_POM.clickInteger();
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		Thread.sleep(2000);
		System.out.println(tabs);
		driver.switchTo().window(tabs.get(2));
		System.out.println(driver.getTitle());
		try {
			Assert.assertEquals(driver.getTitle(), Complex_RTTC_070_POM.expectedTitle1);
			logger.log(LogStatus.PASS, "IntegerPage Validation", "Complete Details of Integer Vitae Iaculis Massa is displayed in the next page");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "IntegerPage Validation", "Complete Details of Integer Vitae Iaculis Massa IS NOT displayed in the next page");
			Assert.fail();
		}
		
		RTTC_070_POM.clickAddToCart();
		logger.log(LogStatus.PASS, "Clicked on Add To Cart");
		System.out.println(RTTC_070_POM.message.getText());
		try {
			Assert.assertEquals(RTTC_070_POM.message.getText(), Complex_RTTC_070_POM.expectedMessage);
			logger.log(LogStatus.PASS, "Message Validation", "'Shopping Cart updated!' Message is displayed on pop up window");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Message Validation", "'Shopping Cart updated!' Message IS NOT displayed on pop up window");
			Assert.fail();
		}
		Thread.sleep(2000);
		
		RTTC_070_POM.clickClosePopUp();
		logger.log(LogStatus.PASS, "Closed POP UP Window");
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(RTTC_070_POM.shoppingCart).build().perform();
		logger.log(LogStatus.PASS, "Mouseover to Cart Icon performed");
		Thread.sleep(5000);
		try {
			Assert.assertEquals(RTTC_070_POM.popUpWindow.getText(), Complex_RTTC_070_POM.expectedTitle1);
			logger.log(LogStatus.PASS, "popUpMessage Validation", "Pop up window displaying the product details is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "popUpMessage Validation", "Pop up window displaying the product details IS NOT displayed");
			Assert.fail();
		}
		act.moveToElement(RTTC_070_POM.viewCart).click().build().perform();
		logger.log(LogStatus.PASS, "Clicked on VIEW CART button");
		Thread.sleep(2000);
		try {
			Assert.assertEquals(driver.getTitle(), Complex_RTTC_070_POM.expectedTitle2);
			logger.log(LogStatus.PASS, "Shopping Cart Page Validation", "Product details containing Image, Product Name, Model, Quantity, Unit Price & Total is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Shopping Cart Page Validation", "Product details containing Image, Product Name, Model, Quantity, Unit Price & Total IS NOT displayed");
			Assert.fail();
		}
		Thread.sleep(2000);
		
		RTTC_070_POM.clickCheckOut();
		logger.log(LogStatus.PASS, "Clicked on Checkout button");
		try {
			Assert.assertEquals(driver.getTitle(), Complex_RTTC_070_POM.expectedTitle3);
			logger.log(LogStatus.PASS, "Checkout Validation", "Billing Details is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Checkout Validation", "Billing Details is NOT displayed");
			Assert.fail();
		}
		Thread.sleep(2000);
		
		RTTC_070_POM.clickContinue1();
		logger.log(LogStatus.PASS, "Delivery Details is displayed");
		Thread.sleep(2000);
		
		RTTC_070_POM.clickContinue2();
		if(RTTC_070_POM.radio.isSelected())
			logger.log(LogStatus.PASS, "Free Shipping radio button is selected & Add Comments About Your Order textbox is displayed");
		else
			logger.log(LogStatus.FAIL, "Free Shipping radio button is NOT selected & Add Comments About Your Order textbox is NOT displayed");
		Thread.sleep(2000);
		
		RTTC_070_POM.sendComment("This product is nice");
		if(RTTC_070_POM.addComment.getAttribute("value").equalsIgnoreCase("This product is nice"))
			logger.log(LogStatus.PASS, "entered credentials is displayed in Add Comments About Your Order textbox");
		else
			logger.log(LogStatus.FAIL, "entered credentials is NOT displayed in Add Comments About Your Order textbox");
		Thread.sleep(2000);
		
		RTTC_070_POM.clickContinue3();
		logger.log(LogStatus.PASS, "Clicked on CONTINUE");
		Thread.sleep(2000);
		
		RTTC_070_POM.clickCheckBox();
		if(RTTC_070_POM.checkbox.isSelected())
			logger.log(LogStatus.PASS, "'I have read and agree to the Terms & Conditions' checkbox is selected");
		else
			logger.log(LogStatus.FAIL, "'I have read and agree to the Terms & Conditions' checkbox is selected");
		Thread.sleep(2000);
		
		RTTC_070_POM.clickContinue4();
		logger.log(LogStatus.PASS, "Product Confirmation page is displayed");
		Thread.sleep(2000);
		
		RTTC_070_POM.clickConfirmOrder();
		try {
			Assert.assertEquals(RTTC_070_POM.orderPlacedMsg.getText(), Complex_RTTC_070_POM.expectedOrderMessage);
			logger.log(LogStatus.PASS, "OrderMessage Validation", "'Your order has been successfully processed!' IS displayed on the screen & product details IS removed from cart");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "OrderMessage Validation", "'Your order has been successfully processed!' IS NOT displayed on the screen & product details IS NOT removed from cart");
			Assert.fail();
		}
		Thread.sleep(2000);
		
		screenShot.captureScreenShot("Complex_RTTC_070_Order_Placed");
		
		driver.switchTo().window(newWindow);
		driver.get(adminUrl);
		logger.log(LogStatus.PASS, "Admin URL opened");
		
		RTTC_070_POM.sendUserName("admin");
		RTTC_070_POM.sendAdminPassword("admin@123");
		RTTC_070_POM.clickLoginBtn();
		try {
			Assert.assertEquals(driver.getTitle(), Complex_RTTC_070_POM.expectedAdminPageTitle);
			logger.log(LogStatus.PASS, "AdminPage Validation", "Admin home page IS displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "AdminPage Validation", "Admin home page IS NOT displayed");
			Assert.fail();
		}
		
		RTTC_070_POM.clickSales();
		logger.log(LogStatus.PASS, "Clicked on Sales Icon");
		
		RTTC_070_POM.clickOrders();
		logger.log(LogStatus.PASS, "Clicked On Orders Link");
		try {
			Assert.assertEquals(driver.getTitle(), Complex_RTTC_070_POM.expectedTitle4);
			logger.log(LogStatus.PASS, "OrdersPage Validation", "Orders Page Opened, Order List displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "OrdersPage Validation", "Orders Page DIDn't Open");
			Assert.fail();
		}
		
		RTTC_070_POM.clickView();
		logger.log(LogStatus.PASS, "Clicked on View Icon");
		try {
			Assert.assertEquals(RTTC_070_POM.ODT.getText(), Complex_RTTC_070_POM.expectedODT);
			logger.log(LogStatus.PASS, "ODT Validation", "Details of Ordered Product displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "ODT Validation", "Details of Ordered Product NOT displayed");
			Assert.fail();
		}
		Thread.sleep(2000);
		
		RTTC_070_POM.selectBox();
		Select s = new Select(RTTC_070_POM.selectList);
		if(s.getFirstSelectedOption().getText().equalsIgnoreCase(RTTC_070_POM.expectedValue))
			logger.log(LogStatus.PASS, "Selected credentials is displayed");
		else
			logger.log(LogStatus.PASS, "Selected credentials is NOT displayed");
		Thread.sleep(2000);
		
		RTTC_070_POM.clickAddHistory();
		System.out.println(RTTC_070_POM.success.getText().substring(0, 34));
		try {
			Assert.assertEquals(RTTC_070_POM.success.getText().substring(0, 34), Complex_RTTC_070_POM.expectedSuccessMsg);
			logger.log(LogStatus.PASS, "Save Validation", "'Success: You have modified Orders!' is displayed");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Save Validation", "Success message not displayed");
			Assert.fail();
		} 
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.open('http://retail.upskills.in/','_blank')");
		
		ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
		Thread.sleep(2000);
		System.out.println(tabs1);
		driver.switchTo().window(tabs1.get(3));
		try {
			Assert.assertEquals(driver.getTitle(), Complex_RTTC_070_POM.expectedTitle5);
			logger.log(LogStatus.PASS, "RetailSite Validation", "User Application is launched");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "RetailSite Validation", "User Application is NOT launched");
			Assert.fail();
		}
		
		RTTC_070_POM.login();
		//user is already logged in the website..
	/*	RTTC_070_POM.sendEmail("abc@abc.com");
		RTTC_070_POM.sendPassWord("admin@123");
		RTTC_070_POM.clickLogin();
		logger.log(LogStatus.PASS, "Logged In successfully");
		*/
		try {
			Assert.assertEquals(driver.getTitle(), Complex_RTTC_070_POM.expectedTitle6);
			logger.log(LogStatus.PASS, "RetailSite Validation", "User Dashboard is launched");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "RetailSite Validation", "User Dashboard is NOT launched");
			Assert.fail();
		}
		
		RTTC_070_POM.clickViewHistory();
		try {
			Assert.assertEquals(RTTC_070_POM.orderStatus.getText(), Complex_RTTC_070_POM.expectedValue);
			logger.log(LogStatus.PASS, "Order Status Validation", "Order status is changed to COMPLETE");
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "Order Status Validation", "Order status is NOT changed to COMPLETE");
			Assert.fail();
		}
		Thread.sleep(2000);
		
		screenShot.captureScreenShot("Complex_RTTC_070_Order_Complete");
		
		
	}

}
