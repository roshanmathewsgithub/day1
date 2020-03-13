package com.guru.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.guru.Utilities.Readconfig;

public class BaseClass {
	
	static Readconfig readconf = new Readconfig();
	public String baseURL=readconf.getApplicationURL();
	public String username=readconf.getUserName();
	public String password=readconf.getPassword();
			static WebDriver driver;
	public static Logger logger;

	
@Parameters("browser")	
@BeforeTest
public void setUP(String br)
{

	logger = Logger.getLogger("Guru");
	 PropertyConfigurator.configure("log4j.properties");
	 
	 if(br.equals("chrome"))
	 {
	System.setProperty("webdriver.chrome.driver",readconf.getChromePath());
	 driver = new ChromeDriver();
	 }
	 else if(br.equals("firefox"))
	 {
		 System.setProperty("webdriver.firefox.marionette",readconf.getFirePath());
		 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	       capabilities.setCapability("marionette", true);
	        driver = new FirefoxDriver();
	 }
	 
	 
}
	

@AfterTest
public void tearDown()
{
	driver.quit();
}

public static void captureScreen(WebDriver driver,String sname) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File("./Screenshots/"+sname+".png"));
	System.out.println("Screenshot Taken");	
}
}
