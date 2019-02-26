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
import com.training.pom.RETC_038_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_038_Test {

	private WebDriver driver;
	private String baseUrl;
	private RETC_038_POM RETC_038;
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
		RETC_038 = new RETC_038_POM(driver); 
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
		RETC_038.ClickOnPlots();
		RETC_038.ClickOnSearchButton();
		RETC_038.sendSearchInput("quis nostrud exercitation ullamco laboris");
		RETC_038.ClickOnSearchInput();
		Thread.sleep(5000);
		RETC_038.ClickOnDropUsALine();
		RETC_038.sendYourName("sikandar");
		RETC_038.sendEmail("sikandar2010eee@gmail.com");
		RETC_038.sendSubject("apartments");
		RETC_038.sendMessage("looking for an apartments");
		RETC_038.ClickOnSend();
	}
}