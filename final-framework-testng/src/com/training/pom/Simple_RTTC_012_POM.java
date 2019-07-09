package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Simple_RTTC_012_POM {
	private WebDriver driver;
	public static String expecteduserName = "admin";
	public static String expectedPassword = "admin@123";
	public static String expectedAdminPageTitle = "Dashboard";
	public static String expectedText = "Category List";
	
	public Simple_RTTC_012_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	public WebElement userName; 
	
	@FindBy(id="input-password")
	public WebElement password;
	
	@FindBy(css = "button.btn.btn-primary")
	private WebElement loginBtn; 
	
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
	
	@FindBy(id = "menu-catalog")
	private WebElement catalog;
	
	@FindBy(xpath = "//*[@id='menu-catalog']//child::ul//li[1]//a")
	public WebElement categories;
	
	@FindBy(xpath = "//*[@class='panel-title']")
	public WebElement categoryList;
	
	public void clickCatalog() {
		this.catalog.click();
	}
	
	public void clickCategories() {
		this.categories.click();	
	}


}
