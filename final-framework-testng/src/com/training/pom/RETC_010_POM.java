package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_010_POM {
	private WebDriver driver;

	public RETC_010_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * This POM file consist of WebElement and methods to Send details in the contact form by clicking on DropUsALine when user does not
	 * find any details in realstate application.
	 */

	@FindBy(linkText = "BLOG")
	private WebElement blog;

	@FindBy(linkText = "Drop Us a Line")
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
	private WebElement SendButton;

	public void ClickOnBlog() {

		this.blog.click();

	}

	public void ClickOnDropUsALine() {

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

}
