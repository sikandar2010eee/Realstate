package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elearning_Add_user_POM {
	private WebDriver driver;

	public Elearning_Add_user_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(linkText = "Add a user")
	private WebElement user;

	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement login;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement Add;
	
	public void clickonAdduser() {
		this.user.click();
	}

	
	public void sendFirstName(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}

	public void sendLastName(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendLogin(String login) {
		this.login.clear();
		this.login.sendKeys(login);
	}
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickonAdd() {
		this.Add.click();
	}
}
