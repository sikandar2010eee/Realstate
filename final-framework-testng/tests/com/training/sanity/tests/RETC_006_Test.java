package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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

import com.training.pom.RETC_006_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import common.Assert;

public class RETC_006_Test {

	private WebDriver driver;
	private String baseUrl;
	private RETC_006_POM RETC_006;
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
		RETC_006 = new RETC_006_POM(driver); 
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
		RETC_006.LogInClick();
		RETC_006.sendUserName("sikandar2010eee@gmail.com");
		RETC_006.SendPassWord("sik_2010");
		RETC_006.ClickOnSignInIn(); 
		Thread.sleep(5000);
		RETC_006.ClickOnLogOut();
		String expected="";
		String actual= driver.findElement(By.name("log")).getText();
		assertEquals(actual, expected);
		
		
	}	
		/*@Test
		public void verifylogout() {
			RETC_006.LogInClick();
			

		
		}*/
		//Thread.sleep(5000);
		//RETC_006.ClickBookMark();
		//screenShot.captureScreenShot("First");//we need to give path to our folder.
	}

