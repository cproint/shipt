package com.shipt.qa.automation.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shipt.qa.automation.base.TestBase;
import com.shipt.qa.automation.webapp.pages.HomePage;
import com.shipt.qa.automation.webapp.pages.LoginPage;
/**
 * @author mtulugu
 *
 */

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;

	
	public HomePageTest(){
		super();
	}
	
	

	@BeforeClass
	public void setup(){
		
		launchBrowser();
		homePage = new HomePage();

	}
	
	@Test(priority = 1, groups = {"sanity"}, enabled = true)
	public void VerifyHomePageTitle(){
		
		assertEquals(homePage.getHomePageTitle(), "Grocery Delivery - Shipt");
	}
	
	@Test(priority = 2, groups = {"sanity"}, enabled = true)
	public void closePopUpWindow() throws InterruptedException{
		homePage.closePopUpWindow();

	}
	
	@Test(priority = 3, groups = {"sanity"}, enabled = true)
	public void clickLoginButton() throws InterruptedException{
		homePage.clickLoginButton();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();	
	}
	

}
