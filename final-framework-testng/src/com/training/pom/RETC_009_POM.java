package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_009_POM {
	
private WebDriver driver; 
	
	public RETC_009_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="APARTMENTS")
	private WebElement ApartmentTab; 
	
	
	//@FindBy(xpath="//div[@data-title='RETC_051_3']/a")
	//private WebElement  DoneQuis;
	
	@FindBy(xpath="//input[@id='keyword_search']")
	private WebElement Address;
	
	
	@FindBy(xpath="//a[@class='chosen-single chosen-default']/span[contains(text(),'Property type')]")//need to write method to send keys
	private WebElement Propertype;
	
	@FindBy(xpath="//ul[@class='chosen-results']/li[4]")//need to write method to send keys
	private WebElement Plots;
	
	
	@FindBy(xpath="//a[@class='chosen-single chosen-default']/span[contains(text(),'Any Regions')]")//need to write method to sen keys
	private WebElement Region;
	
	
	@FindBy(xpath="//ul[@class='chosen-results']/li[6]")
	private WebElement ChooseRegion;//need to write method to click on send button
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	private WebElement SearchButton;//need to write method to click on send button
	
	
	public void ClickOnApartmentTab() {
		
		this.ApartmentTab.click();
	}
	

	
	public void sendAddress(String address) {
		this.Address.clear(); 
		this.Address.sendKeys(address); 
	}
	
public void ClickOnProperty() {
		
		this.Propertype.click();
	}

public void ClickOnPlots() {
	
	this.Plots.click();
}

public void ClickOnRegion() {
	
	this.Region.click();
}

public void SelectRegion() {
	this.ChooseRegion.click();
}

public void ClickonSerachButton() {
	this.SearchButton.click();
}
	
	
}
