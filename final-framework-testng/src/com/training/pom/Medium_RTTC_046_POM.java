package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Medium_RTTC_046_POM {
	private WebDriver driver;
	public static String expectedUserName = "admin";
	public static String expectedPassWord = "admin@123";
	public static String expectedTitle = "Orders";
	public static String expectedPageTitle = "Edit Order";
	public static String expectedTab = "2. Products";
	public static String expectedTextAfterRemove = "No results!";
	public static String expectedPaymentTab = "3. Payment Details";
	public static String expectedShippingTab = "4. Shipping Details";
	public static String expectedTotalTab = "5. Totals";
	public static String expectedAlertMessage = "Success: You have modified orders!";
	
	public Medium_RTTC_046_POM(WebDriver driver) {
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
	
	@FindBy(xpath = "//td[3][contains(text(),'Anusha')]//following-sibling::td[5]//a[2]")
	public WebElement editOrder;
	
	@FindBy(xpath = "//*[@class='panel-title']")
	public WebElement pageTitle;
	
	//@FindBy(xpath = "//*[@id='button-customer' and @class='btn btn-primary']")
	@FindBy(css = "button#button-customer.btn.btn-primary")
	private WebElement Continue;
	
	@FindBy(xpath = "//ul[@id='order']//li[2]//a")
	public WebElement productsTab;
	
	@FindBy(xpath = "//*[@class='btn btn-danger']")
	private WebElement remove;
	
	@FindBy(xpath = "//*[@class='text-center']")
	public WebElement afterRemove;
	
	@FindBy(id = "input-product")
	public WebElement chooseProduct;
	
	@FindBy(xpath = "//a[@href='#']")
	private WebElement selPrediction;
	
	@FindBy(id = "input-quantity")
	public WebElement quantity;
	
	@FindBy(id = "button-product-add")
	private WebElement addProduct;
	
	@FindBy(xpath = "//tbody[@id='cart']//tr//td")
	public WebElement product;
	
	@FindBy(id = "button-cart")
	private WebElement continueInProductsTab;
	
	@FindBy(xpath = "//ul[@id='order']//li[3]//a")
	public WebElement paymentTab;
	
	@FindBy(id = "button-payment-address")
	private WebElement continuePayment;
	
	@FindBy(xpath = "//ul[@id='order']//li[4]//a")
	public WebElement shippingTab;
	
	@FindBy(id = "button-shipping-address")
	private WebElement continueShipping;
	
	@FindBy(xpath = "//ul[@id='order']//li[5]//a")
	public WebElement totalsTab;
	
	@FindBy(id = "button-save")
	private WebElement save;
	
	@FindBy(name = "shipping_method")
	private WebElement selectInput;
	
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
	
	public void clickSales() {
		this.sales.click();	
	}
	
	public void clickOrders() {
		this.orders.click();
	}
	
	public void editOrderClick() {
		this.editOrder.click();
	}
	
	public void clickContinue() throws InterruptedException {	
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(this.Continue).click().build().perform();
	}
	
	public void clickRemove() {
		this.remove.click();
	}
	
	public void sendChooseProduct(String chooseProduct) {
		this.chooseProduct.clear();
		this.chooseProduct.sendKeys(chooseProduct);
		this.selPrediction.click();
	}
	
	public void sendQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	
	public void clickAddProduct() throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(this.addProduct).click().build().perform();
		Thread.sleep(3000);
	}
	
	public void clickContinueProduct() throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(this.continueInProductsTab).click().build().perform();
	}
	
	public void clickContinuePayment() throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(this.continuePayment).click().build().perform();
	}
	
	public void clickContinueShipping() throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(this.continueShipping).click().build().perform();
	}
	
	public void clickSave() {
		this.save.click();
	}
	
	public void selectInput() {
		Select sel = new Select(this.selectInput);
		sel.selectByValue("free.free");
	}

}
