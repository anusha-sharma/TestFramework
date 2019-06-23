package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CatalogPOM {
	private WebDriver driver;
	
	public CatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "menu-catalog")
	private WebElement catalog;
	
	@FindBy(xpath = "//*[@id='menu-catalog']//child::ul//li[1]//a")
	private WebElement categories;
	
	@FindBy(xpath = "//*[@class='panel-title']")
	private WebElement categoryList;
	
	public void clickBtn() {
		this.catalog.click(); 
		this.categories.click();	
		Assert.assertEquals(this.categoryList.getText(), "Category List");
	}

}
