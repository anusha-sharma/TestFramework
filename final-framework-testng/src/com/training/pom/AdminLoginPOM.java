package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdminLoginPOM {
	private WebDriver driver; 
	
	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(css = "button.btn.btn-primary")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		System.out.println(this.userName.getAttribute("value"));
		Assert.assertEquals(this.userName.getAttribute("value"), userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password);
		System.out.println(this.password.getAttribute("value"));
		Assert.assertEquals(this.password.getAttribute("value"), password);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
}
