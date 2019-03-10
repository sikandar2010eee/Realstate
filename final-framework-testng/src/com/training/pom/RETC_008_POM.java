package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_008_POM {
	
private WebDriver driver; 
	
	public RETC_008_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	/*
	 * This POM file consist of WebElement and methods to calculate Mortgage  in the Mortgage claculator section of the
	 * realstate application and assertion to verify calculated value returned.
	 * received.
	 */
		
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
	
	@FindBy(xpath="//div[@class='notification success']")
	private WebElement SuccessMsg;
	
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
	public void VerifyAssertion() {
		
		////div[contains(text(),'Monthly Payment: ')]/strong
		String Constantmsg="Monthly Payment: ";
		String paymentamount=driver.findElement(By.xpath("//div[contains(text(),'Monthly Payment: ')]/strong")).getText();
		System.out.println(paymentamount);
		String Actual=Constantmsg+paymentamount;
		String Expected=this.SuccessMsg.getText();
		Assert.assertEquals(Actual, Expected);
		
	}
	
	

}
