package com.guru.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {

	Properties pro;
	
	public Readconfig()
	{
	File src=new File("./Configurations\\config.properties"); 	
	try {
		FileInputStream fis=new FileInputStream(src);
		pro= new Properties();
		pro.load(fis);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
		
	
	}

	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
		
	}
	
	public String getUserName()
	{
		String userN=pro.getProperty("username");
		return userN;
	}
	
	public String getPassword()
	{
		String passw=pro.getProperty("password");
		return passw;
	}

public String getChromePath()
{
	String chr=pro.getProperty("chromepath");
	return chr;
}

public String getFirePath()
{
	String fir=pro.getProperty("firefoxpath");
	return fir;
}

public String getIEPath()
{
	String iepa=pro.getProperty("iepath");
	return iepa;
}





}
