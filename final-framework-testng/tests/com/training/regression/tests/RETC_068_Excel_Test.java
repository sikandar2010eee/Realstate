package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_007_POM;
import com.training.pom.RETC_008_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.Test;



public class RETC_068_Excel_Test {
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
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String salesprice, String downpayment,String loanterm,String InterestRate) {
		RETC_007.ClickOnApartmentTab();
		RETC_007.ClickOnDoneQuisTab();
		RETC_008.sendSalesprice(salesprice);
		RETC_008.SendDownPayment(downpayment);
		RETC_008.SendLoanTerm(loanterm);
		RETC_008.SendInterestrate(InterestRate);
		RETC_008.ClickOnCalculateButton();
		RETC_008.VerifyAssertion();
		//screenShot.captureScreenShot(userName);
	
	
		
	
	}

}