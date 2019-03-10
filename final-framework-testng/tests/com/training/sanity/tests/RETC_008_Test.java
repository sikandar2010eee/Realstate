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
import com.training.pom.RETC_008_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_008_Test {

	private WebDriver driver;
	private String baseUrl;
	private RETC_008_POM RETC_008;
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
		RETC_008 = new RETC_008_POM(driver);
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
	public void MortgageCalculator() {
		RETC_007.ClickOnApartmentTab();
		RETC_007.ClickOnDoneQuisTab();
		RETC_008.sendSalesprice("400000");
		RETC_008.SendDownPayment("20000");
		RETC_008.SendLoanTerm("20");
		RETC_008.SendInterestrate("7.25");
		RETC_008.ClickOnCalculateButton();
		RETC_008.VerifyAssertion();
		
	}
}
