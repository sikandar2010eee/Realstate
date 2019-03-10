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

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.RETC67_DataProvider;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RETC067_POM;
import com.training.pom.RETC_007_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_067_DB_Test {

	private WebDriver driver;
	private String baseUrl;
	private RETC067_POM RETC_067;
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
		RETC_067 = new RETC067_POM(driver); 
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
	@Test(dataProvider = "db-inputs", dataProviderClass = RETC67_DataProvider.class)
	public void VerfiyValuesInDB(String username, String email,String subject,String text) {
		RETC_067.ClickOnApartmentTab();
		RETC_067.ClickOnDoneQuisTab();
		String UserName=RETC_067.sendUserName("sikandar");
		String Email=RETC_067.SendEmail("sikandar2010eee@gmail.com");
		String Subject =RETC_067.SendYourSubject("apartments");
		String Text=RETC_067.Yourtext("looking for apartments");
		RETC_067.ClickOnSendButton();
		Assert.assertEquals(UserName, username);
		Assert.assertEquals(Email, email);
		Assert.assertEquals(Subject, subject);
		Assert.assertEquals(Text, text);
		
		/*String exp="Thank you for your message. It has been sent.";
		String actual=driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
		Assert.assertEquals(actual, exp);*/
		
		
	}
}
