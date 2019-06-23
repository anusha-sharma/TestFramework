package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TaxPOM {
private WebDriver driver;
	
	public TaxPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "menu-report")
	private WebElement report;
	
	@FindBy(xpath = "//*[@id='menu-report']//child::ul//li[1]//a")
	private WebElement sales;
	
	@FindBy(xpath = "//*[@id='menu-report']//child::ul//li[1]//child::ul//li[2]//a")
	private WebElement tax;
	
	@FindBy(id = "input-group")
	private WebElement groupBy;
	
	@FindBy(id = "button-filter")
	private WebElement filter;
	
	public void clickBtn() throws InterruptedException {
		this.report.click(); 
		this.sales.click();
		this.tax.click();		
		//Thread.sleep(2000);
		Select sel = new Select(groupBy);
		sel.selectByValue("week");
		Thread.sleep(3000);
		this.filter.click();
	}

}
