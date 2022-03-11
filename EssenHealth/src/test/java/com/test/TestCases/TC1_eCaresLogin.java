package com.test.TestCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.PageObject.eCaresLoginPage;


public class TC1_eCaresLogin extends BaseClass{

	@Test
	
	public void loginTest() throws IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();
		eCaresLoginPage eLogin=new eCaresLoginPage(driver);
		eLogin.setUsername(username);
		logger.info("username entered");
		eLogin.setPassword(password);
		logger.info("password entered");
		eLogin.ClickSingIn();
		logger.info("Clicked on Login button");
		if(driver.getTitle().equals(TC1Assertion))
		{
			Assert.assertTrue(true);
			logger.info("Login successfull");
		}
		else
		{
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login fail");
		}
	}
}
