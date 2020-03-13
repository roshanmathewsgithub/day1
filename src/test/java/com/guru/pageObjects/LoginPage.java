package com.guru.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage( WebDriver driver)
	{
		this.driver=driver;
	}
	
    By userName =By.name("uid");
    By password =By.name("password");
    By clickBtn_Login=By.name("btnLogin");
	
    public void typeUserName(String uname)
    {
    	driver.findElement(userName).sendKeys(uname);
    }
	
	public void typePassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLogin_Btn()
	{
		driver.findElement(clickBtn_Login).click();
	}
	
}
