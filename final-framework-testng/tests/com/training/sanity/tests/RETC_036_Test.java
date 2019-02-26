package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_010_POM;
import com.training.pom.RETC_036_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_036_Test {

	private WebDriver driver;
	private String baseUrl;
	private RETC_036_POM RETC_036;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RETC_036 = new RETC_036_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	//@AfterMethod
	//public void tearDown() throws Exception {
		//Thread.sleep(1000);
		//driver.quit();
	//}
	@Test
	public void validLoginTest() throws Exception {
		RETC_036.ClickOnVillas();
		RETC_036.ClickOnSearchButton();
		RETC_036.sendSearchInput("quis nostrud exercitation ullamco laboris");
		RETC_036.ClickOnSearchInput();
		RETC_036.ClickOnDropUsALine();
		RETC_036.sendYourName("sikandar");
		RETC_036.sendEmail("sikandar2010eee@gmail.com");
		RETC_036.sendSubject("apartments");
		RETC_036.sendMessage("looking for an apartments");
		RETC_036.ClickOnSend();
	}
}