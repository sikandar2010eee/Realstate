package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_006_POM {
	
private WebDriver driver; 
	
	public RETC_006_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
/*This POM file consists of consist of WebElement and methods needed to logout from the realstate application after user has 
 * successfully logged in 
 */
	@FindBy(linkText="Log Out")
	private WebElement LogOut;
	
	@FindBy(name="log")
	private WebElement LogOutSuccess;
	
	public void ClickOnLogOut() {
		this.LogOut.click();
		
	}
	//This method will verify whether user has logged out or not from the realstate application
	public void VerfiyLogOut() {
		String expected="";
		String actual= driver.findElement(By.name("log")).getText();
		Assert.assertEquals(actual, expected);
		
	}
		
	
}

