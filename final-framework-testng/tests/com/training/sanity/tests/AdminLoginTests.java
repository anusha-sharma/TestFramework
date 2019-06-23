package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.CatalogPOM;
import com.training.pom.OrdersPOM;
import com.training.pom.TaxPOM;

public class AdminLoginTests {

	private static WebDriver driver;
	private static String baseUrl;
	private static AdminLoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static CatalogPOM cPOM;
	private static OrdersPOM oPOM;
	private static TaxPOM tPOM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminLoginPOM(driver); 
		cPOM = new CatalogPOM(driver);
		oPOM = new OrdersPOM(driver);
		tPOM = new TaxPOM(driver);
		baseUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	//RTTC_011
	@Test
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("RTTC_011");
	}
	
	//RTTC_012
	@Test (dependsOnMethods = {"validLoginTest"})
	public void CatalogTest() {
		cPOM.clickBtn();
		screenShot.captureScreenShot("RTTC_012");
	}
	
	//RTTC_022
	@Test (dependsOnMethods = {"CatalogTest"})
	public void OrdersTest() throws InterruptedException {
		oPOM.clickBtn();
		screenShot.captureScreenShot("RTTC_022");
	}
	
	//RTTC_023
	@Test (dependsOnMethods = {"OrdersTest"})
	public void TaxTest() throws InterruptedException {
		tPOM.clickBtn();
		screenShot.captureScreenShot("RTTC_023");
	}
}
