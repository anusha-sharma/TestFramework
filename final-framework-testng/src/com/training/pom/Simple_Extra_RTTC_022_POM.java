package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Simple_Extra_RTTC_022_POM {
	private WebDriver driver;
	public static String expecteduserName = "admin";
	public static String expectedPassword = "admin@123";
	public static String expectedAdminPageTitle = "Dashboard";
	public static String expectedTitle = "Sales Report";
	public static String expectedValue = "Week";
		
		public Simple_Extra_RTTC_022_POM(WebDriver driver) {
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
		
		@FindBy(id = "menu-report")
		private WebElement report;
		
		public void clickReport() {
			this.report.click();
		}
		
		@FindBy(xpath = "//*[@id='menu-report']//child::ul//li[1]//a")
		public WebElement sales;
		
		public void clickSales() {
			this.sales.click();
		}
		
		@FindBy(xpath = "//*[@id='menu-report']//child::ul//li[1]//child::ul//li[1]//a")
		public WebElement order;
		
		public void clickOrder() {
			this.order.click();
		}
		
		@FindBy(id = "input-group")
		public WebElement groupBy;
		
		public void clickGroupBy() throws InterruptedException {
			Select sel = new Select(groupBy);
			sel.selectByValue("week");
			Thread.sleep(3000);
		}
		
		@FindBy(id = "button-filter")
		private WebElement filter;
		
		public void clickFilter() {
			this.filter.click();
		}
}
