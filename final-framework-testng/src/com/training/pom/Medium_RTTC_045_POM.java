package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Medium_RTTC_045_POM {
	private WebDriver driver;
	public static String expectedUserName = "admin";
	public static String expectedPassWord = "admin@123";
	public static String expectedTitle = "Orders";
	public static String expectedODT = "Order Details";
	
	public Medium_RTTC_045_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	public WebElement userName; 
	
	@FindBy(id="input-password")
	public WebElement password;
	
	@FindBy(css = "button.btn.btn-primary")
	private WebElement loginBtn; 
	
	@FindBy(id = "menu-sale")
	private WebElement sales;
	
	@FindBy(xpath = "//*[@id='menu-sale']//ul//li[1]")
	private WebElement orders;
	
	@FindBy(xpath = "//*[@class='btn btn-info' and @data-original-title='View']")
	private WebElement view;
	
	@FindBy(xpath = "//*[@class='panel-title']")
	public WebElement ODT;
	
	@FindBy(xpath = "//*[@class='fa fa-cog']")
	private WebElement generate;
	
	@FindBy(id = "invoice")
	public WebElement invoice;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click();
	}
	
	public void clickSales() {
		this.sales.click();	
	}
	
	public void clickOrders() {
		this.orders.click();
	}
	
	public void clickViewIcon() {
		this.view.click();
	}
	
	public void clickGenerate() {
		this.generate.click();
	}

}
