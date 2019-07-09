package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Simple_RTTC_010_POM {
	private WebDriver driver; 
	public static String expectedTitle = "Necklace";
	public static String expectedTitle1 = "Integer Vitae Iaculis Massa";
	public static String expectedMessage = "Shopping Cart updated!";
	public static String expectedTitle2 = "Shopping Cart";
	public static String expectedMsg = "Your shopping cart is empty!";
	
	public Simple_RTTC_010_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
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
	
	public void clickEthnic() throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(this.shop).build().perform();
		Thread.sleep(1000);
		act.moveToElement(this.necklace).click().build().perform();
	}
	
	public void clickInteger() throws InterruptedException {		
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
	
	@FindBy(xpath = "//*[@class='fa fa-times-circle']")
	private WebElement remove;
	
	@FindBy(xpath = "//*[@class='fa fa-refresh']")
	private WebElement update;
	
	@FindBy(xpath = "//*[@class='tb_text_wrap tb_sep']")
	public WebElement msg;
	
	public void clickRemove() {
		this.remove.click();
	}
	
	public void clickUpdate() {
		this.update.click();
	}

}
