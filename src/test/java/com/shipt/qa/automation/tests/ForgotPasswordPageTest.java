package com.shipt.qa.automation.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shipt.qa.automation.base.TestBase;
import com.shipt.qa.automation.webapp.pages.ForgotPasswordPage;
import com.shipt.qa.automation.webapp.pages.HomePage;
import com.shipt.qa.automation.webapp.pages.LoginPage;

/**
 * @author mtulugu
 *
 */
public class ForgotPasswordPageTest extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;
	
	public ForgotPasswordPageTest(){
		super();
	}
		
	@BeforeMethod
	public void setup() throws Exception{
		
		launchBrowser();
		homePage = new HomePage();
		homePage.closePopUpWindow();
		homePage.clickLoginButton();
		loginPage = new LoginPage();
		forgotPasswordPage = loginPage.clickForgotPasswordLink();
	}
	
	@Test(priority = 1, groups = {"sanity"}, enabled = true)
	public void verifyResetPagePasswordTextBoxTest() {

		assertTrue(forgotPasswordPage.isResetPasswordTextBoxDispayed());
		assertTrue(forgotPasswordPage.isResetPasswordTextBoxEnabled());
		assertTrue(forgotPasswordPage.isResetPasswordTextBoxEmpty());
	}
	
	@Test(priority = 2, groups = {"sanity"}, enabled = true)
	public void verifyResetButtonTest() {

		assertTrue(forgotPasswordPage.isResetButtonDisplayed());
		assertTrue(forgotPasswordPage.isResetButtonEnabled());
		assertEquals(forgotPasswordPage.getResetButtonText(), "Reset my password!");
	}
	
	// TODO: For some reason this testcase is failing as in forgotPasswordPage.getWarningMessageWithEmptyEmail() 
	// is returning null instead of 'Please fill out this field.' 
	@Test(priority = 3, groups = {"sanity"}, enabled = false)
	public void verifyResetPasswordButtonClickWithEmptyEmail() throws InterruptedException {
		forgotPasswordPage.clickResetButtonWithEmptyEmail();
		assertEquals(forgotPasswordPage.getWarningMessageWithEmptyEmail(), "Please fill out this field.");
	}
	
	@Test(priority = 4, groups = {"sanity"}, enabled = true)
	public void verifyResetPasswordButtonClickWithInvalidEmail() throws InterruptedException {

		forgotPasswordPage.clickResetButtonWithInvalidEmail("invalid@invalidtest.com");
		assertEquals(forgotPasswordPage.getConfirmationMessageWithInvalidEmail(), "Cannot find user with email: "+"invalid@invalidtest.com");
	}
	
	@Test(priority = 5, groups = {"sanity"}, enabled = true)
	public void verifyResetPasswordButtonClickWithValidEmail() {
		forgotPasswordPage.clickResetButtonWithValidEmail("cproint@gmail.com");
		assertEquals(forgotPasswordPage.getConfirmationMessageWithValidEmail(), "Instructions have been sent to your email");
	}
	
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}