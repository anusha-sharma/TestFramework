package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RetailPOM {
	private WebDriver driver; 
	
	public RetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Integer')]")
	private WebElement integer; 
	
	@FindBy(id="button-cart")
	private WebElement addToCart;
	
	@FindBy(xpath = "//*[@class='noty_close btn btn-default btn-sm tb_no_text']")
	private WebElement popUp;
	
	@FindBy(xpath = "//*[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement shoppingCart; 
	
	@FindBy(xpath = "//a[contains(text(),'View Cart')]")
	private WebElement viewCart;
	
	@FindBy(xpath = "//*[@class='fa fa-times-circle']")
	private WebElement remove;
	
	@FindBy(xpath = "//*[@class='fa fa-refresh']")
	private WebElement update;
	
	@FindBy(xpath = "//*[@class='tb_text_wrap tb_sep']")
	private WebElement msg;
	
	public void clickBtn() throws InterruptedException {
		//didn't find ethnic link in the website, so proceeded with next step as discussed with Sunil
		this.integer.click(); 
		this.addToCart.click();
		Thread.sleep(2000);
		this.popUp.click();
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(this.shoppingCart).build().perform();
		Thread.sleep(5000);
		act.moveToElement(this.viewCart).click().build().perform();
		Thread.sleep(2000);
		this.remove.click();
		this.update.click();
		System.out.println(this.msg.getText());
		Assert.assertEquals(this.msg.getText(), "Your shopping cart is empty!");
	}
}
