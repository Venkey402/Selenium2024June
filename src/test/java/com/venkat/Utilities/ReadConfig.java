package com.venkat.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public Properties pro ;
	
	public ReadConfig()
	{
		try {
			File file = new File(System.getProperty("user.dir")+"\\Configuration\\config.Properties");		
			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getBaseUrl()
	{
		return pro.getProperty("baseUrl");
	}
	public String getUsername()
	{
		return pro.getProperty("username");
	}
	public String getPassword()
	{
		return pro.getProperty("password");
	}
	

}
