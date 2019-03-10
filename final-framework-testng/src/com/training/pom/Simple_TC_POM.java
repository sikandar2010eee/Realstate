package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Simple_TC_POM {
private WebDriver driver; 
	
	public Simple_TC_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

//-----------------------------------------------------
//WebElements for Login

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

//Methods for login and logout operation



}