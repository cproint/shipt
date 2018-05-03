package com.shipt.qa.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase extends DriverInit {
	
	protected static final Logger logger = Logger.getLogger(TestBase.class.getName());
	
	public static WebDriver driver;
	public static Properties prop;
	static String browser;	

	protected static String webURL;
	protected static String baseURI;
	
	static FirefoxOptions options = new FirefoxOptions();
	
	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream configFile = new FileInputStream (System.getProperty("user.dir") + "/src/main/java/com/shipt/qa/automation/config/config.properties");
			prop.load(configFile);
			String log4jConfPath = System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
	
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
        // Read environment from property file
		browser = prop.getProperty("browser");
		webURL = prop.getProperty("URL");
		baseURI = prop.getProperty("baseURI");
	}
	
	public  void launchBrowser(){
		
		browser = prop.getProperty("browser");
				
		DriverInit instanceDriver = DriverInit.getInstance();
		driver = instanceDriver.openBrowser(browser);
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIMEOUT")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		driver.get(webURL);
		logger.info("url launched");
	}
	


	


}
