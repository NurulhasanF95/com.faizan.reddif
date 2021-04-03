package com.faizan.reddif.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.faizan.reddif.util.UtilityDemo;

public class Testbase {
	
	FileInputStream fis;
	public Properties pro;
	public static WebDriver driver;
	
	public Testbase()
	{
		try
		{
			
		fis=new FileInputStream(".\\src\\main\\java\\com\\faizan\\reddif\\config\\Configuration.properties");
		
		pro=new Properties();
		
		pro.load(fis);
		
		
		
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public void browserSetup()
	{
		String browsername=pro.getProperty("browser");
				
				if(browsername.equalsIgnoreCase("Chrome"))
				{
				ChromeOptions off01= new ChromeOptions();
				off01.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", pro.getProperty("chromepath"));
				driver=new ChromeDriver(off01);

				}
				
				else if(browsername.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", pro.getProperty("geckopath"));
					driver=new FirefoxDriver();
					
				}
				
				else
				{
					System.out.println("Given browsername is wrong");
				}
				
				driver.get(pro.getProperty("url"));
				
				UtilityDemo.max_window();
				
				UtilityDemo.implicit_wait(30);
				
				

	}
	
	
}
