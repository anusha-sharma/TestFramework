package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Medium_RTTC_044_POM {
	private WebDriver driver;
	public static String expectedUserName = "admin";
	public static String expectedPassWord = "admin@123";
	public static String expectedTitle = "Products";
	public static String expectedAlertMsg = "Are you sure?";
	public static String expectedAlertMessage = "Success: You have modified products!";
	
	
	public Medium_RTTC_044_POM(WebDriver driver) {
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
	
	@FindBy(name = "selected[]")
	public List<WebElement> checkbox;
	
	@FindBy(xpath = "//td[3][contains(text(),'Ear')]//parent::tr//child::td//input")
	public WebElement earRing;
	
	@FindBy(xpath = "//td[3][contains(text(),'Finger')]//parent::tr//child::td//input")
	public WebElement fingerRing;
	
	@FindBy(xpath = "//*[@class='btn btn-danger']")
	private WebElement delete;
	
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
	
	public void check1() {
		checkbox.get(0).click();
	}
	
	public void check2() {
		checkbox.get(1).click();
	}
	
	public void earRingCheck() {
		this.earRing.click();
	}
	
	public void fingerRingCheck() {
		this.fingerRing.click();
	}
	
	public void clickDelete() {
		this.delete.click();		
	}

}
