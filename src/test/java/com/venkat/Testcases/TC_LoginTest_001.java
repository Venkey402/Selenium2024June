package com.venkat.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.venkat.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	
	@Test
	public void loginTest()
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("User name is set");
		lp.setPassword(password);
		logger.info("Password is set");
		lp.clickLogin();
		logger.info("Clicked on login button");
		
		
		if(driver.getTitle().contains("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("User is able to login successfully.");
		}
		else
		{
			logger.info("User is not able to login successfully.");
			Assert.assertTrue(false);			
		}
		
	}

}
