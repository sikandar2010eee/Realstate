package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC067_POM {
	
private WebDriver driver; 
	
	public RETC067_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="APARTMENTS")
	private WebElement ApartmentTab; 
	
	
	@FindBy(xpath="//div[@data-title='RETC_051_3']/a")
	private WebElement  DoneQuis;
	
	@FindBy(xpath="//input[@name='your-name']")
	private WebElement NameTextBox;
	
	
	@FindBy(xpath="//input[@name='your-email']")//need to write method to send keys
	private WebElement YourEmail;
	
	@FindBy(xpath="//input[@name='your-subject']")//need to write method to send keys
	private WebElement YourSubject;
	
	
	@FindBy(xpath="//textarea[@name='your-message']")//need to write method to sen keys
	private WebElement YourMessage;
	
	
	@FindBy(xpath="//input[@value='Send']")
	private WebElement SendButton;//need to write method to click on send button
	
	
	public void ClickOnApartmentTab() {
		
		this.ApartmentTab.click();
	}
	
public void ClickOnDoneQuisTab() {
		
		this.DoneQuis.click();
	}

	
	public String sendUserName(String name) {
		this.NameTextBox.clear(); 
		 this.NameTextBox.sendKeys(name); 
		return this.NameTextBox.getAttribute("value");
		 
		 
	}
	
	public String SendEmail(String email) {
		this.YourEmail.clear();
		this.YourEmail.sendKeys(email);
		return this.YourEmail.getAttribute("value");
	}
	
	public String SendYourSubject(String subject) {
		this.YourSubject.sendKeys(subject);
		return this.YourSubject.getAttribute("value");
	}
	public String Yourtext(String text) {
		this.YourMessage.sendKeys(text);
		return this.YourMessage.getAttribute("value");
	}
	public void ClickOnSendButton() {
		this.SendButton.click();
	}

}
