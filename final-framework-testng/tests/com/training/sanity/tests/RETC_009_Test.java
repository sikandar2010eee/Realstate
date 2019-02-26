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
import com.training.pom.RETC_009_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_009_Test {

	private WebDriver driver;
	private String baseUrl;
	private RETC_009_POM RETC_009;
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
		RETC_009 = new RETC_009_POM(driver); 
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
	public void validLoginTest() {
		RETC_009.ClickOnApartmentTab();
		RETC_009.sendAddress("Electronic City");
		RETC_009.ClickOnProperty();
		RETC_009.ClickOnPlots();
		RETC_009.ClickOnRegion();
		RETC_009.SelectRegion();
		RETC_009.ClickonSerachButton();
		
		//String ActualMsg="Monthly Payment: 3003.43 Rs.";
				//String exp=driver.findElement(By.xpath("//div[@class='notification success']")).getText();
				//assertEquals(ActualMsg, exp);
	}
}
