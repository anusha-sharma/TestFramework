package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Medium_RTTC_043_POM {
	private WebDriver driver;
	public static String expectedUserName = "admin";
	public static String expectedPassWord = "admin@123";
	public static String expectedTitle = "Products";
	public static String expectedPageTitle = "Edit Product";
	public static String expectedAlertMessage = "Success: You have modified products!";
	
	public Medium_RTTC_043_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	public WebElement userName; 
	
	@FindBy(id="input-password")
	public WebElement password;
	
	@FindBy(css = "button.btn.btn-primary")
	private WebElement loginBtn; 
	
	@FindBy(id = "menu-catalog")
	private WebElement catalog;
	
	@FindBy(xpath = "//*[@id='menu-catalog']//child::ul//li[2]//a")
	private WebElement products;
	
	@FindBy(xpath = "//*[@class='btn btn-primary' and @data-original-title='Edit']")
	private WebElement edit;
	
	@FindBy(xpath = "//*[@class='panel-title']")
	public WebElement pageTitle;
	
	@FindBy(xpath = "//ul[@class='nav nav-tabs']//li[2]")
	private WebElement data;
	
	@FindBy(id = "input-quantity")
	private WebElement quantity;
	
	@FindBy(css = "input#input-keyword.form-control")
	private WebElement seoUrl;
	
	@FindBy(xpath = "//*[@class='btn btn-primary' and @data-original-title='Save']")
	private WebElement save;
	
	@FindBy(xpath = "//*[@class = 'alert alert-success']")
	public WebElement success;
	
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
	
	public void clickCatalog() {
		this.catalog.click();	
	}
	
	public void clickProducts() {
		this.products.click();
	}
	
	public void clickEditIcon() {
		this.edit.click();
	}
	
	public void clickData() {
		this.data.click();
	}
	
	public void clearQuantity() {
		this.quantity.clear();
	}
	
	public void sendQuantity(Integer quantity) {
		String strQuantity = quantity.toString();
		this.quantity.sendKeys(strQuantity);
	}
	
	public void sendSeoUrl(String seoUrl) {
		this.seoUrl.clear(); 
		this.seoUrl.sendKeys(seoUrl);
	}
	
	public void saveProduct() {
		this.save.click();
	}

}
