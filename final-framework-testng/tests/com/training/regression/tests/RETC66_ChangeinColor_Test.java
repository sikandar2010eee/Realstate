package com.training.regression.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_007_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC66_ChangeinColor_Test {

	private WebDriver driver;
	private String baseUrl;
	private RETC_007_POM RETC_007;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RETC_007 = new RETC_007_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void VerifyTextBoxColorChange() throws Exception {
		RETC_007.ClickOnApartmentTab();
		RETC_007.ClickOnDoneQuisTab();
		String before = RETC_007.sendUserName("");
		RETC_007.SendEmail("");
		RETC_007.SendYourSubject("");
		RETC_007.Yourtext("");
		RETC_007.ClickOnSendButton();
		Thread.sleep(3000);
		String after = RETC_007.GetColor();
		Assert.assertEquals(before, after);
		
		
	}
}
