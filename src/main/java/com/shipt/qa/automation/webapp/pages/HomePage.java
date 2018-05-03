package com.shipt.qa.automation.webapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shipt.qa.automation.base.TestBase;
import com.shipt.qa.automation.util.TestUtil;

/**
 * @author mtulugu
 *
 */
public class HomePage extends TestBase{

	@FindBy(css = "button.pop-close")
	@CacheLookup  //homePageImage will be stored in cache memory for the subsequent calls rather than using Browser/DOM/css etc. More useful when we use xpath etc. Note that if the element is changed dynamically then it gices StaleElementException
	private WebElement popUpWindowClose;

	@FindBy(css = "section")
	@CacheLookup  
	private WebElement popUpWindow;
	
	@FindBy(css = "a.button-secondary")
	@CacheLookup  
	private WebElement loginButton;
	
	//Grocery Delivery - Shipt
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean isPopUpWindowDisplayed(){
		return popUpWindow.isDisplayed();
	}
	
	public boolean isPopUpWindowCloseButtonDisplayed(){
		return popUpWindowClose.isDisplayed();
	}
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}

	public void closePopUpWindow() throws InterruptedException{
		TestUtil.explicitWaitForElement(popUpWindowClose);
		popUpWindowClose.click();
		Thread.sleep(5000);

	}
	
	public LoginPage clickLoginButton() throws InterruptedException{
		TestUtil.explicitWaitForElement(loginButton);
		loginButton.click();
		Thread.sleep(5000);

		return new LoginPage();
		
	}
	

	
}