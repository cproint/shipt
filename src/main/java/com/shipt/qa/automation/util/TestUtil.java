package com.shipt.qa.automation.util;


import static io.restassured.RestAssured.given;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.shipt.qa.automation.base.TestBase;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * @author mtulugu
 *
 */
public class TestUtil extends TestBase {
	
    public static String endDate;
    public static String startDate;
    public static SimpleDateFormat simpleDateFormat;
    public static Calendar calendar;

    protected static RequestSpecification request;
    protected static JSONObject jsonObject;
    protected static JSONArray jsonArray;
    protected static Response response;


    public static String sqlResult;
    public static Connection dbConnection;
    public static String sqlQuery;
    public static ResultSet rs;
    public static PreparedStatement pstmt;
    public static Statement stmt;

	


	WebElement element;

	// Start - These are Selenium UI based utility methods
	public void switchToFrame(String frameName){
		driver.switchTo().frame(frameName);
	}


	
	
	
	public static boolean isElementPresent(WebDriver webdriver, WebElement webelement) {
		boolean exists = false;

		webdriver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

		try {
			webelement.getTagName();
			exists = true;
		} catch (NoSuchElementException e) {
			logger.info(e.getMessage());
		}

		webdriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

		return exists;
	}
	
	public static boolean isElementPresentByLocator(String locator){
		
		if(driver.findElements(By.cssSelector(locator)).size() > 0){
				return true;
			}else{
				return false;
		}
	}
	
	//This is Explicit wait using locator (Used by non-Page Object Model)
	public void waitForElement(String locator) {
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));

	}
		// This utility method should be used for Energy Supply Page 
		public boolean isDaylightSavingsTime(String startDate) throws Exception{
 
				Date date = new SimpleDateFormat("MM/dd/yy").parse(startDate);
				boolean isDST = TimeZone.getTimeZone("US/Pacific").inDaylightTime(date);
				return isDST;
		}
		
	    
		public void clickBrowserBackButton() {

			driver.navigate().back();

		}
		
		

		public void implicitWaitForElement() {
			try {

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} catch (Exception e) {

			}

		}

		public static void fluentWaitForElement(WebElement element) {
			
			try {

				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						   .withTimeout(10, TimeUnit.SECONDS)
						   .pollingEvery(10, TimeUnit.MILLISECONDS)
							.ignoring(NoSuchElementException.class);
				
						wait.until(ExpectedConditions.visibilityOf(element));
						logger.info("Element found: " + element);
						
						} catch (Exception e) {
							logger.info("Element not found: " + element);
			}

		}

		//This is Explicit wait using WebElement (Used in Page Object Model)
		public static void explicitWaitForElement(WebElement element) {
			element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element));

		}
		
		public void moveMouse() {

			Actions builder = new Actions(driver);
			Action moveMouseOver = builder.moveByOffset(50, 50).build();
			moveMouseOver.perform();
		}
		
	    public static RequestSpecification givenContentType(){
	    	//Since there is no Authentication is required, no header is necessary
	        if (request == null) {
	            request = given().contentType("application/json");
	        }
	        return request;
	    }
	  
	    public static String baseURI() {
	        return baseURI;
	    }

	    @Test(priority = 1, enabled = false, groups = { "web" })
		public void test()  {
	    	

	    	
	    }
	    
	    
	    
}

