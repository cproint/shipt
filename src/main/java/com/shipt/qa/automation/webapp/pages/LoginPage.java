package com.shipt.qa.automation.webapp.pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shipt.qa.automation.base.TestBase;

/**
 * @author mtulugu
 *
 */
public class LoginPage extends TestBase {
	
	@FindBy(css = "input[ng-model='login.username']")
	@CacheLookup
	private WebElement emailTextBox;

	@FindBy(css = "input[ng-model='login.password']")
	@CacheLookup
	private WebElement passwordTextBox;

	@FindBy(id = "start_shopping_login_button")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(css = "button[ng-click='resetPassword()']")
	@CacheLookup
	private WebElement forgotPasswordLink;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	

	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean isLoginEmailTextboxDisplayed(){
		return emailTextBox.isDisplayed();
	}
	
	public boolean isLoginEmailTextboxEnabled(){
		return emailTextBox.isEnabled();
	}
	
	public boolean isPasswordTextboxDisplayed(){
		return passwordTextBox.isDisplayed();
	}
	
	public boolean isPasswordTextboxEnabled(){
		return passwordTextBox.isEnabled();
	}
	
	public boolean verifyLoginEmailTextboxIsEmpty(){
		return emailTextBox.getText().isEmpty();
	}
		
	public boolean verifyLoginPasswordTextboxIsDisplayed(){
		return passwordTextBox.isDisplayed();
	}
	
	public boolean verifyLoginPasswordTextboxIsEnabled(){
		return passwordTextBox.isEnabled();
	}
	
	public boolean verifyLoginPasswordTextboxIsEmpty(){
		return passwordTextBox.getText().isEmpty();
	}
	
	public boolean verifyLoginButtonIsDisplayed(){
		return loginButton.isDisplayed();
	}
	
	public boolean verifyLoginButtonIsEnabled(){
		return loginButton.isEnabled();
	}
	
	public String getLoginButtonText(){
		return loginButton.getText();
	}
	
	public boolean isForgotPasswordLinkDisplayed(){
		return forgotPasswordLink.isDisplayed();
	}
	
	public boolean isForgotPasswordLinkEnabled(){
		return forgotPasswordLink.isEnabled();
	}
	
	public ForgotPasswordPage clickForgotPasswordLink() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", forgotPasswordLink);
		
		//Get all window Tabs and switch focus to new tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		return new ForgotPasswordPage();
	}
	
	

}
