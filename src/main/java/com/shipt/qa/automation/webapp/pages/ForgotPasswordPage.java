package com.shipt.qa.automation.webapp.pages;

import org.openqa.selenium.JavascriptExecutor;
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
public class ForgotPasswordPage extends TestBase{
	
	String validationMessage;
	
	@FindBy(id = "email")
	@CacheLookup
	private WebElement resetPasswordTextBox;

	@FindBy(css = "input[name='commit']")
	@CacheLookup
	private WebElement resetPasswordButton;
	
	@FindBy(css = "div.alert")
	@CacheLookup
	private WebElement errorMessageWithInvalidEmail;
	

	
	@FindBy(css = "div[role = 'alert']")
	@CacheLookup
	private WebElement successMessageWithValidEmail;
	
	public ForgotPasswordPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean isResetPasswordTextBoxDispayed() {
		return resetPasswordTextBox.isDisplayed();
	}
	
	public boolean isResetPasswordTextBoxEnabled() {
		return resetPasswordTextBox.isEnabled();
	}
	
	public boolean isResetPasswordTextBoxEmpty() {
		return resetPasswordTextBox.getText().isEmpty();
	}

	public boolean isResetButtonDisplayed() {
		return resetPasswordButton.isDisplayed();
	}
	
	public boolean isResetButtonEnabled() {
		return resetPasswordButton.isEnabled();
	}
	
	public String getResetButtonText() {
		return resetPasswordButton.getAttribute("value");
	}
	
	public void clickResetButtonWithEmptyEmail() {
		resetPasswordTextBox.sendKeys("");
		resetPasswordButton.click();
		
/*		String validationMessage = resetPasswordButton.getAttribute("validationMessage");
		System.out.println("validationMessage " + validationMessage);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", resetPasswordButton);
		String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", resetPasswordButton);
		System.out.println("is_valid: " + is_valid);
		System.out.println("validationMessage " + validationMessage);
*/
	}
	
	public String getWarningMessageWithEmptyEmail() throws InterruptedException {
		
		return validationMessage;
		//return errorMessageWithEmptyEmail.getText();
	}
	
	public void clickResetButtonWithInvalidEmail(String invalidEmail) throws InterruptedException {
		resetPasswordTextBox.sendKeys(invalidEmail);
		resetPasswordButton.click();
	
	}
	
	public String getConfirmationMessageWithInvalidEmail() {
		TestUtil.fluentWaitForElement(errorMessageWithInvalidEmail);
		return errorMessageWithInvalidEmail.getText();
	}
	
	public void clickResetButtonWithValidEmail(String validEmail) {
		resetPasswordTextBox.sendKeys(validEmail);
		resetPasswordButton.click();
	}
	
	
	public String getConfirmationMessageWithValidEmail() {
		TestUtil.fluentWaitForElement(successMessageWithValidEmail);
		return successMessageWithValidEmail.getText();
	}
	
}