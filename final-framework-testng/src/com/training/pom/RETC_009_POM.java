package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_009_POM {

	private WebDriver driver;

	public RETC_009_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * This POM file consist of WebElement and methods to search property details by entering Address details and assertion to verify search results
	 * in realstate application.
	 */

	@FindBy(xpath = "//input[@id='keyword_search']")
	private WebElement Address;

	@FindBy(xpath = "//a[@class='chosen-single chosen-default']/span[contains(text(),'Property type')]") 
	private WebElement Propertype;

	@FindBy(xpath = "//ul[@class='chosen-results']/li[4]") // need to write method to send keys
	private WebElement Plots;

	@FindBy(xpath = "//a[@class='chosen-single chosen-default']/span[contains(text(),'Any Regions')]") 

	private WebElement Region;

	@FindBy(xpath = "//ul[@class='chosen-results']/li[6]")
	private WebElement ChooseRegion;

	@FindBy(xpath = "//button[@class='button fullwidth']")
	private WebElement SearchButton;
	
	@FindBy(xpath="//h1[contains(text(),'Region: Apartments')]")
	private WebElement SearchResults;

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
	
	public void VerifySearchResults() {
		String Expected="Region: Apartments";
		String Actual= this.SearchResults.getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual, Expected);
	}
	
	

}
