package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_038_POM {
	private WebDriver driver;

	public RETC_038_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "BLOG")
	private WebElement plots;

	@FindBy(xpath = "//div[@class='sidebar right']//input[@type='search']")
	private WebElement SearchButton;

	@FindBy(xpath = "//div[@class='sidebar right']//input[@type='search']")
	private WebElement Searchinput;

	@FindBy(xpath = "//div[@class='resdrg']/div/div/div/following-sibling::h3/a[contains(text(),' quis nostrud exercitation ullamco laboris')]")
	private WebElement Clicksearchinput;

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

	public void ClickOnPlots() {

		this.plots.click();

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

	/*
	 * public void GetNewHandle() {
	 * 
	 * String mywindowHandle = driver.getWindowHandle(); Set<String> handles =
	 * driver.getWindowHandles(); for(String winhandle:handles) {
	 * 
	 * if(mywindowHandle.equals(winhandle)) {//if this condition is not true...then
	 * line 41 will not be executed and control will go to the start of the for loop
	 * continue;
	 * 
	 * } driver.switchTo().window(winhandle); } }
	 */

	public void ClickOnDropUsALine() {
		String mywindowHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String winhandle : handles) {

			if (mywindowHandle.equals(winhandle)) {// if this condition is not true...then line 41 will not be executed
													// and control will go to the start of the for loop
				continue;

			}
			driver.switchTo().window(winhandle);
			this.ContactUs.click();
		}

		// this.ContactUs.click();

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
