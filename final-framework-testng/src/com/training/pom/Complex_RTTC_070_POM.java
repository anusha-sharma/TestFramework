package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Complex_RTTC_070_POM {
	
	private WebDriver driver; 
	public static String oldWindow = "https://www.google.com/";
	public static String expectedTitle = "Necklace";
	public static String expectedTitle1 = "Integer Vitae Iaculis Massa";
	public static String expectedMessage = "Shopping Cart updated!";
	public static String expectedTitle2 = "Shopping Cart";
	public static String expectedTitle3 = "Checkout";
	public static String expectedOrderMessage = "Your order has been successfully processed!";
	public static String expectedAdminPageTitle = "Dashboard";
	public static String expectedTitle4 = "Orders";
	public static String expectedODT = "Order Details";
	public static String expectedValue = "Complete";
	public static String expectedSuccessMsg = "Success: You have modified orders!";
	public static String expectedTitle5 = "Retail";
	public static String expectedTitle6 = "My Account";

	
	public Complex_RTTC_070_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Gmail')]")
	private WebElement gmail;
	
	public void clickNewWindow() throws AWTException, InterruptedException {
		Actions act = new Actions(driver);
		act.contextClick(this.gmail).build().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	@FindBy(xpath = "//li[@class='tb_link dropdown tb_menu_system_account_account']")
	private WebElement loginIcon;
	
	@FindBy(id = "input-email")
	private WebElement email;
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@class='btn btn-primary' and @value='Login']")
	private WebElement login;
	
	@FindBy(xpath = "//*[@id='menu_all_categories_Menu_VIfWm2LT_Gd1U2']//a")
	private WebElement shop; 
	
	@FindBy(xpath = "//*[@class='tb_menu_category_Gd1U2 tb_link']//a")
	private WebElement necklace;
	
	@FindBy(xpath = "//h4//a[contains(text(),'Integer')]")
	private WebElement integer; 
	
	@FindBy(id="button-cart")
	private WebElement addToCart;
	
	@FindBy(xpath = "//div[@class='noty_text']//h3")
	public WebElement message;
	
	@FindBy(xpath = "//*[@class='noty_close btn btn-default btn-sm tb_no_text']")
	private WebElement closePopUp;
	
	@FindBy(xpath = "//*[@class='tb_icon ico-linea-ecommerce-bag']")
	public WebElement shoppingCart; 
	
	@FindBy(xpath = "//td[@class='name']//a")
	public WebElement popUpWindow;
	
	@FindBy(xpath = "//a[contains(text(),'View Cart')]")
	public WebElement viewCart;
	
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement checkOut;
	
	@FindBy(id = "button-payment-address")
	private WebElement continue1;
	
	@FindBy(id = "button-shipping-address")
	private WebElement continue2;
	
	@FindBy(name = "shipping_method")
	public WebElement radio;
	
	@FindBy(name = "comment")
	public WebElement addComment;
	
	@FindBy(id = "button-shipping-method")
	private WebElement continue3;
	
	@FindBy(name = "agree")
	public WebElement checkbox;
	
	@FindBy(id = "button-payment-method")
	private WebElement continue4;
	
	@FindBy(id = "button-confirm")
	private WebElement confirmOrder;
	
	@FindBy(xpath = "//div[@class='tb_text_wrap tb_sep']//p")
	public WebElement orderPlacedMsg;
	
	public void login() throws InterruptedException {
		this.loginIcon.click();
		Thread.sleep(2000);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassWord(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickLogin() {
		this.login.click();
	}
	
	public void clickEthnic() throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(this.shop).build().perform();
		Thread.sleep(1000);
		act.moveToElement(this.necklace).click().build().perform();
	}
	
	public void clickInteger() throws InterruptedException {
		//this.integer.click();
		//Thread.sleep(3000);
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(this.integer).click().build().perform();
	}
	
	public void clickAddToCart() throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(this.addToCart).click().build().perform();		
	}
	
	public void clickClosePopUp() {
		this.closePopUp.click();
	}
	
	public void clickCheckOut() {
		this.checkOut.click();
	}
	
	public void clickContinue1() {
		this.continue1.click();
	}
	
	public void clickContinue2() {
		this.continue2.click();
	}
	
	public void sendComment(String comment) {
		this.addComment.sendKeys(comment);
	}
	
	public void clickContinue3() {
		this.continue3.click();
	}
	
	public void clickCheckBox() {
		this.checkbox.click();
	}
	
	public void clickContinue4() {
		this.continue4.click();
	}
	
	public void clickConfirmOrder() {
		this.confirmOrder.click();
	}
	
	//Admin Page
	
	@FindBy(id="input-username")
	public WebElement userName; 
	
	@FindBy(id="input-password")
	public WebElement adminPassword;
	
	@FindBy(css = "button.btn.btn-primary")
	private WebElement loginBtn;
	
	@FindBy(id = "menu-sale")
	private WebElement sales;
	
	@FindBy(xpath = "//*[@id='menu-sale']//ul//li[1]")
	private WebElement orders;
	
	@FindBy(xpath = "//td[contains(text(),'Anusha Sharma')]//following-sibling::td[5]//a")
	private WebElement view;
	
	@FindBy(xpath = "//*[@class='panel-title']")
	public WebElement ODT;
	
	@FindBy(id = "input-order-status")
	public WebElement selectList;
	
	@FindBy(id = "button-history")
	private WebElement addHistory;
	
	@FindBy(xpath = "//*[@class='alert alert-success']")
	public WebElement success;
	
	@FindBy(xpath = "//a[contains(text(),'View your order history')]")
	private WebElement viewHistory;
	
	@FindBy(xpath = "//tbody/tr/td[4]")
	public WebElement orderStatus;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendAdminPassword(String password) {
		this.adminPassword.clear(); 
		this.adminPassword.sendKeys(password);
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
	
	public void clickView() {
		this.view.click();
	}
	
	public void selectBox() {
		Select sel = new Select(this.selectList);
		sel.selectByValue("5");
	}
	
	public void clickAddHistory() {
		this.addHistory.click();
	}
	
	public void clickViewHistory() {
		this.viewHistory.click();
	}

}
