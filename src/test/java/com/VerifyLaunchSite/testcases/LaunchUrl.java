package com.VerifyLaunchSite.testcases;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LaunchUrl {

WebDriver driver;
static Logger logger;
ReadConfig readconfig = new ReadConfig();
	
	@BeforeClass
	void setup()
	{
		System.setProperty("webdriver.chrome.driver","C://seleniumDrivers//chromedriver84/chromedriver.exe"); 
		driver = new ChromeDriver();
		
		logger = Logger.getLogger("LaunchUrl"); // provide test case  or class name as a parameter
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Inside Setup method");
	}
	
	@Test 
	void openUrl()
	{
		/*String expectedTitle = "CNN - Breaking News, Latest News and Videos";
		String expectedUrl = "http://www.cnn.com";*/
		
		String expectedTitle=readconfig.getPageTitle();
		String expectedUrl=readconfig.getApplicationUrl();
		
		System.out.println("Launch Website " + expectedUrl);
		logger.info("Launch Website " + expectedUrl);
		System.out.println("Website Title" + expectedTitle);
		logger.info("Website Title " + expectedTitle);
		
		driver.get(expectedUrl);
		try{
			Assert.assertEquals(expectedTitle, driver.getTitle());
			System.out.println("Website is up");
			logger.info("Website is up");
		}
		catch(Throwable pageNavigationError){
			System.out.println("This site can't be reached");
			logger.info("This site can't be reached");
			Assert.assertTrue(false);  
		}		
	}
		
	@AfterClass
	void closeBrowser()
	{
		driver.close();
	} 
	
}
 