package com.training.sanity.tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_006_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_006_Test {

	private WebDriver driver;
	private String baseUrl;
	private RETC_006_POM RETC_006;
	private LoginPOM loginPOM;
	private static Properties properties;
	// private ScreenShot screenShot;

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
		loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		// screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	//This test method will test successful logout from the realstate application after user has logged in.
	public void validLogOutTest() throws Exception {
		loginPOM.LogInClick();
		loginPOM.sendUserName("sikandar2010eee@gmail.com");
		loginPOM.sendPassword("sik_2010");
		loginPOM.clickLoginBtn();
		Thread.sleep(2000);
		RETC_006.ClickOnLogOut();
		RETC_006.VerfiyLogOut();
		// screenShot.captureScreenShot("First");//we need to give path to our folder.

	}

}
