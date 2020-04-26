	package com.openhrm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.openhrm.qa.base.TestBase;
import com.openhrm.qa.pages.HomePage;
import com.openhrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	Logger logger = LogManager.getLogger(LoginPageTest.class);
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginpage = new LoginPage();
		
	}
   @Test(priority = 1)
	public void loginpageTitleTest() {
	   
		assertEquals(loginpage.validatetitle(), "OrangeHRM", "Title Does Not Match");
		
	}
   
   @Test(priority =2)
   public void loginpagelogoTest() {
	   SoftAssert softassert = new SoftAssert();
	  
	   softassert.assertTrue(loginpage.validateLogo());
	   
	   softassert.assertAll();
   }
   @Test(priority = 3)
   public void loginTest() {
	   
	    homepage =  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	  
   }

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
