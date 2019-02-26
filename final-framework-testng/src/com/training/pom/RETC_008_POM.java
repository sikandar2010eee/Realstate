package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_008_POM {
	
private WebDriver driver; 
	
	public RETC_008_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="APARTMENTS")
	private WebElement ApartmentTab; 
	
	
	@FindBy(xpath="//div[@data-title='RETC_051_3']/a")
	private WebElement  DoneQuis;
	
	@FindBy(xpath="//div[@class='calc-input']//input[@id='amount']")
	private WebElement Salesprice;
	
	
	@FindBy(xpath="//div[@class='calc-input']//input[@id='downpayment']")//need to write method to send keys
	private WebElement DownPayment;
	
	@FindBy(xpath="//div[@class='calc-input']//input[@id='years']")//need to write method to send keys
	private WebElement LoanTerm;
	
	
	@FindBy(xpath="//div[@class='calc-input']//input[@id='interest']")//need to write method to sen keys
	private WebElement Interestrate;
	
	
	@FindBy(xpath="//button[@class='button calc-button']")
	private WebElement CalculateButton;//need to write method to click on send button
	
	
	public void ClickOnApartmentTab() {
		
		this.ApartmentTab.click();
	}
	
public void ClickOnDoneQuisTab() {
		
		this.DoneQuis.click();
	}

	
	public void sendSalesprice(String name) {
		this.Salesprice.clear(); 
		this.Salesprice.sendKeys(name); 
	}
	
	public void SendDownPayment(String downpayment) {
		this.DownPayment.clear();
		this.DownPayment.sendKeys(downpayment);
	}
	
	public void SendLoanTerm(String loantrem) {
		this.LoanTerm.sendKeys(loantrem);
	}
	public void SendInterestrate(String rate) {
		this.Interestrate.sendKeys(rate);
	}
	public void ClickOnCalculateButton() {
		this.CalculateButton.click();
	}

}
