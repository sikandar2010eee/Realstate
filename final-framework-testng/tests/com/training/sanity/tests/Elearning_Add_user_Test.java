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
import com.training.pom.Elearning_Add_user_POM;
import com.training.pom.Elearning_login_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Elearning_Add_user_Test {

	private WebDriver driver;
	private String baseUrl;
	private Elearning_login_POM loginPOM;
	private Elearning_Add_user_POM Adduser;
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
		loginPOM = new Elearning_login_POM(driver); 
		Adduser = new Elearning_Add_user_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
*/	@Test
	public void validLoginTest() {
		
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		Adduser.clickonAdduser();
		Adduser.sendFirstName("sikandar");
		Adduser.sendLastName("ahmad");
		Adduser.sendEmail("sikandar2010eee@gmail.com");
		Adduser.sendLogin("sikandar1986");
		Adduser.sendPassword("12345");
		Adduser.clickonAdd();
	}
}
