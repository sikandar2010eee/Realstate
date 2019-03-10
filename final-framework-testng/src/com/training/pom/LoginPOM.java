package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver;

	public LoginPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@id='responsive']//a[@class='sign-in']")
	private WebElement login;

	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='user_pass']")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Sign In']")
	private WebElement SignIn;

	public void LogInClick() {

		this.login.click();
	}

	public void sendUserName(String userName) {
		this.username.clear();
		this.username.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.SignIn.click();
	}
}
