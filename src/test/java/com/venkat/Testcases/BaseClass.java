package com.venkat.Testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.venkat.Utilities.ReadConfig;


public class BaseClass {
	WebDriver driver;
	Logger logger;
	ReadConfig rc = new ReadConfig();
	public String baseUrl = rc.getBaseUrl();
	public String username = rc.getUsername();
	public String password = rc.getPassword();
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String br)
	{
		logger = Logger.getLogger("BaseClass");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome browser opened");
		}
		else if(br.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");			
			driver = new FirefoxDriver();			
			logger.info("firefox browser opened");
		}
		else if(br.equals("edge"))
		{			
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");			
			driver = new EdgeDriver();			
			logger.info("edge browser opened");
		}
		
		driver.manage().window().maximize();
		logger.info("Browser window maximized.");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		logger.info("Implicit time out is set.");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		logger.info("Page load time out is set.");
		driver.get(baseUrl);
		logger.info("Opened url "+ baseUrl+"  successfully.");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
