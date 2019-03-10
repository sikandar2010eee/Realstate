package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_007_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_007_Test {

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
	//This test method will send the enquiry details to the realstate database server and will verify the success msg.
	public void SendEnquiryDetailsAndVerifySuccessMsg() {
		RETC_007.ClickOnApartmentTab();
		RETC_007.ClickOnDoneQuisTab();
		RETC_007.sendUserName("sikandar");
		RETC_007.SendEmail("sikandar2010eee@gmail.com");
		RETC_007.SendYourSubject("apartments");
		RETC_007.Yourtext("looking for apartments");
		RETC_007.ClickOnSendButton();
		RETC_007.VerifyAssertion();
	}
}
