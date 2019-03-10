package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_007_POM {

	private WebDriver driver;

	public RETC_007_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * This POM file consist of WebElement and methods to send enquiry details to
	 * the realstate database server and assertion will verify the success message
	 * received.
	 * 
	 */

	@FindBy(linkText = "APARTMENTS")
	private WebElement ApartmentTab;

	@FindBy(xpath = "//div[@data-title='RETC_051_3']/a")
	private WebElement DoneQuis;

	@FindBy(xpath = "//input[@name='your-name']")
	private WebElement NameTextBox;

	@FindBy(xpath = "//input[@name='your-email']") // need to write method to send keys
	private WebElement YourEmail;

	@FindBy(xpath = "//input[@name='your-subject']") // need to write method to send keys
	private WebElement YourSubject;

	@FindBy(xpath = "//textarea[@name='your-message']") // need to write method to sen keys
	private WebElement YourMessage;

	@FindBy(xpath = "//input[@value='Send']")
	private WebElement SendButton;// need to write method to click on send button

	@FindBy(xpath = "//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement MessageConfirmation;

	public void ClickOnApartmentTab() {

		this.ApartmentTab.click();
	}

	public void ClickOnDoneQuisTab() {

		this.DoneQuis.click();
	}

	public String sendUserName(String name) {
		this.NameTextBox.clear();
		this.NameTextBox.sendKeys(name);
		String cssValue = this.NameTextBox.getCssValue("background-color");
		String s2 = Color.fromString(cssValue).asHex();
		return s2;

	}

	public void SendEmail(String email) {
		this.YourEmail.clear();
		this.YourEmail.sendKeys(email);

	}

	public void SendYourSubject(String subject) {
		this.YourSubject.sendKeys(subject);

	}

	public void Yourtext(String text) {
		this.YourMessage.sendKeys(text);

	}

	public void ClickOnSendButton() {
		this.SendButton.click();
	}

	public String GetColor() {

		String cssValue = this.NameTextBox.getCssValue("background-color");
		System.out.println(cssValue);
		String s1 = Color.fromString(cssValue).asHex();
		System.out.println(s1);
		return s1;
	}

	public void VerifyAssertion() {

		String exp = "Thank you for your message. It has been sent.";
		String actual = this.MessageConfirmation.getText();
		Assert.assertEquals(exp, actual);
	}

}
