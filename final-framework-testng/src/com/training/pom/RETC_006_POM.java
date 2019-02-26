package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_006_POM {
	
private WebDriver driver; 
	
	public RETC_006_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='responsive']//a[@class='sign-in']")
	private WebElement login; 
	
	@FindBy(xpath="//input[@id='user_login']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='user_pass']")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Sign In']")
	private WebElement SignIn;
	
	@FindBy(linkText="Log Out")
	private WebElement LogOut;
	
	
	public void LogInClick() {
		
		this.login.click();
	}
	
	public void sendUserName(String username) {
		this.username.clear(); 
		this.username.sendKeys(username); 
	}
	
	public void SendPassWord(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void ClickOnSignInIn() {
		SignIn.click();
	}
	
	
	public void ClickOnLogOut() {
		this.LogOut.click();
	}
		
	
}

