package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_036_POM {
	private WebDriver driver;

	public RETC_036_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "VILLAS")
	private WebElement villas;
	
	@FindBy(xpath="//div[@id='ajaxsearchlite1']//input[@placeholder='Search here for Properties..']")
	private WebElement SearchButton;
	
	@FindBy(xpath="//div[@id='ajaxsearchlite1']//input[@placeholder='Search here for Properties..']")
	private WebElement Searchinput;
	
	@FindBy(xpath="//a[contains(text(),'quis nostrud exercitation ullamco laboris')]")
	private WebElement Clicksearchinput;

	/*@FindBy(linkText = "Drop Us a Line")
	private WebElement ContactUs;

	@FindBy(xpath = "//input[@placeholder='Your Name']")
	private WebElement YourName;

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	private WebElement YourEmail;

	@FindBy(xpath = "//input[@placeholder='Subject']")
	private WebElement Subject;

	@FindBy(xpath = "//textarea[@placeholder='Message']")
	private WebElement MessageBox;

	@FindBy(xpath = "//input[@value='Send']")
	private WebElement SendButton*/;

	public void ClickOnVillas() {

		this.villas.click();

	}
	
	public void ClickOnSearchButton() {

		this.SearchButton.click();

	}
	
	public void sendSearchInput(String searchinput) {
		Searchinput.clear();
		Searchinput.sendKeys(searchinput);
	}
	
	public void ClickOnSearchInput() {

		this.Clicksearchinput.click();

	}

	/*public void ClickOnDropUsALine() {

		this.ContactUs.click();

	}


	public void sendYourName(String yourname) {
		YourName.clear();
		YourName.sendKeys(yourname);
	}

	public void sendEmail(String youremail) {
		YourEmail.sendKeys(youremail);
	}

	public void sendSubject(String subject) {
		Subject.sendKeys(subject);
	}

	public void sendMessage(String message) {
		MessageBox.sendKeys(message);
	}

	public void ClickOnSend() {
		SendButton.click();
	}
*/
}
