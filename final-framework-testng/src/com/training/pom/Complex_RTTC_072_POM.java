package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Complex_RTTC_072_POM {
	public static String expectedTitle = "Products";
	public static String expectedPageTitle = "Add Product";
	public static String expectedStartDate = "2019-07-05";
	public static String expectedEndDate = "2019-07-07";
	public static String expectedAlertMessage = "Warning: Please check the form carefully for errors!";

	
	public Complex_RTTC_072_POM(WebDriver driver) {
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
	
	@FindBy(xpath = "//*[@id='menu-catalog']//child::ul//li[2]//a")
	private WebElement products;
	
	public void clickCatalog() {
		this.catalog.click();	
	}
	
	public void clickProducts() {
		this.products.click();
	}
	
	@FindBy(xpath = "//*[@class='btn btn-primary' and @data-original-title='Add New']")
	private WebElement addNew;
	
	@FindBy(xpath = "//*[@class='panel-title']")
	public WebElement pageTitle;
	
	public void clickAddNew() {
		this.addNew.click();
	}
	
	@FindBy(id = "input-name1")
	public WebElement productName;
	
	public void sendProductName(String productName) {
		this.productName.clear();
		this.productName.sendKeys(productName);
	}
	
	@FindBy(id = "input-meta-title1")
	public WebElement metaTagTitle;
	
	public void sendMetaTagTitle(String metaTagTitle) {
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTagTitle);
	}
	
	@FindBy(xpath = "//ul[@class='nav nav-tabs']//li[2]//a")
	public WebElement dataTab;
	
	public void clickDataTab() {
		this.dataTab.click();
	}
	
	@FindBy(xpath = "//div[@class='form-group required']/label[contains(text(),'Model')]")
	public WebElement modelLabel;
	
	@FindBy(id = "input-model")
	public WebElement modelName;
	
	public void sendModelName(String modelName) {
		this.modelName.clear();
		this.modelName.sendKeys(modelName);
	}
	
	@FindBy(id = "input-price")
	public WebElement price;
	
	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	@FindBy(id = "input-quantity")
	public WebElement quantity;
	
	public void sendQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	
	@FindBy(xpath = "//ul[@class='nav nav-tabs']/li[3]/a")
	public WebElement linkTab;
	
	public void clickLinkTab() {
		this.linkTab.click();
	}
	
	@FindBy(xpath = "//label[@class='col-sm-2 control-label' and @for='input-manufacturer']")
	public WebElement manufacturer;
	
	@FindBy(id = "input-category")
	public WebElement category;
	
	@FindBy(xpath = "//ul/li/a[@href='#']")
	private WebElement selection;
	
	public void sendCategory(String category) {
		this.category.clear();
		this.category.sendKeys(category);
		this.selection.click();
	}
	
	@FindBy(id = "product-category")
	public WebElement selectedCategory;
	
	@FindBy(xpath = "//ul[@class='nav nav-tabs']/li[7]/a")
	public WebElement discountTab;
	
	public void clickDiscountTab() {
		this.discountTab.click();
	}
	
	@FindBy(xpath = "//table[@id='discount']/thead/tr/td")
	public WebElement customerGroup;
	
	@FindBy(xpath = "//button[@data-original-title='Add Discount']")
	private WebElement addDiscount;
	
	public void clickAddDiscount() {
		this.addDiscount.click();
	}
	
	@FindBy(name = "product_discount[0][quantity]")
	public WebElement discountQuantity;
	
	public void sendDiscountQuantity(String quantity) {
		this.discountQuantity.clear();
		this.discountQuantity.sendKeys(quantity);
	}
	
	@FindBy(name = "product_discount[0][price]")
	public WebElement discountPrice;
	
	public void sendDiscountPrice(String discountPrice) {
		this.discountPrice.clear();
		this.discountPrice.sendKeys(discountPrice);
	}
	
	@FindBy(name = "product_discount[0][date_start]")
	public WebElement startDate;
	
	public void sendStartDate(String startDate) {
		this.startDate.clear();
		this.startDate.sendKeys(startDate);
	}
	
	@FindBy(name = "product_discount[0][date_end]")
	public WebElement endDate;
	
	public void sendEndDate(String endDate) {
		this.endDate.clear();
		this.endDate.sendKeys(endDate);
	}
	
	@FindBy(xpath = "//ul[@class='nav nav-tabs']/li[10]/a")
	public WebElement rewardPointsTab;
	
	public void clickRewardPointsTab() {
		this.rewardPointsTab.click();
	}
	
	@FindBy(id = "input-points")
	public WebElement points;
	
	public void sendPoints(String points) {
		this.points.clear();
		this.points.sendKeys(points);
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;
	
	public void clickSave() {
		this.save.click();
	}
	
	@FindBy(xpath = "//*[@class='alert alert-danger']")
	public WebElement warning;

}
