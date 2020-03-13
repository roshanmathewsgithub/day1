package com.guru.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru.pageObjects.LoginPage;

public class Tc_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void LoginTest() throws IOException 
	{
	
		LoginPage lg = new LoginPage(driver);
		
		driver.get(baseURL);
		logger.info("Url Loading");
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lg.typeUserName(username);
		logger.info("Typing user name");
		lg.typePassword(password);
		logger.info("Typing passoword");
		lg.clickLogin_Btn();
		logger.info("Login Button clicked ");
			
	
		if(driver.getTitle().contains("Guru99 Bank Manager HomePage"))
		{
			//System.out.println("PASSED");
			Assert.assertTrue(true);
			//captureScreen(driver,"login");
			logger.info("Page loaded Sucesssfully");
				}
		else
		{
			captureScreen(driver,"login");
			//System.out.println("FAILED");
			Assert.assertTrue(false);
		}
	}

}


