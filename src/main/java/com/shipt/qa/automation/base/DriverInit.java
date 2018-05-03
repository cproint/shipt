package com.shipt.qa.automation.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverInit {

	protected static final Logger logger = Logger.getLogger(DriverInit.class.getName());

	private static DriverInit instanceDriver = null;
	private static WebDriver driver;
	
	static FirefoxOptions options = new FirefoxOptions();

	@SuppressWarnings("unused")
	private void DriverInt() {
		String log4jConfPath = System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
	
	public static DriverInit getInstance(){
		
		if (instanceDriver == null)
			instanceDriver = new DriverInit();
		return instanceDriver;
		 
	}
	
	public WebDriver openBrowser(String browser){

		if (browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");	
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			driver = new FirefoxDriver(options); //works with Selenium 3.8.1 but not with 3.11.0

		} else {
			logger.info("Unknown Browser: "+ browser);
		}
		
		
		return driver; 
	}
	

}
