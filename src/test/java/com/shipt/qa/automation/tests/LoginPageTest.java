package com.shipt.qa.automation.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shipt.qa.automation.base.TestBase;
import com.shipt.qa.automation.webapp.pages.HomePage;
import com.shipt.qa.automation.webapp.pages.LoginPage;
import com.shipt.qa.automation.webapp.pages.ForgotPasswordPage;
/**
 * @author mtulugu
 *
 */

public class LoginPageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	ForgotPasswordPage forgotPasswordPage;

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception{
	  
		launchBrowser();
		homePage = new HomePage();
		homePage.closePopUpWindow();
		homePage.clickLoginButton();
		loginPage = new LoginPage();
	}

	@Test(priority = 1, groups = {"sanity"}, enabled = true)
	public void verifyLoginPageTitle() {
		assertEquals(loginPage.getLoginPageTitle(),"Shipt Groceries","Login Page Title Not Matched");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();	
	}
	

}
