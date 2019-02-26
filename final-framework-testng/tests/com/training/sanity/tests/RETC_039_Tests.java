package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_039_POM_AddNewPost;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_039_Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_039_POM_AddNewPost RETC_039;
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
		RETC_039 = new RETC_039_POM_AddNewPost(driver);
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/

	@Test
	public void validLoginTest() throws Exception {
		RETC_039.sendUserName("admin");
		RETC_039.sendPassword("admin@123");
		RETC_039.ClickOnSignIn();
		RETC_039.ClickOnPost();
		RETC_039.ClickOnCategories();
		RETC_039.sendNameText("Black friday01");
		RETC_039.sendslugText("special01");
		RETC_039.sendDescriptionText("Villas for free");
		RETC_039.clickonAddNewCategory();
		RETC_039.clickonposts();
		RETC_039.clickonAddNewPost();
		RETC_039.sendTitle("extravaganzas01");
		RETC_039.sendBodyText("Newhome01");
		RETC_039.clickonCategoryCheckBox();
		Thread.sleep(5000);
		RETC_039.clickonPublish();

	}
}
