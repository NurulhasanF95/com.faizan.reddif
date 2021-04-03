package com.faizan.reddif.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.faizan.reddif.base.Testbase;

public class UtilityDemo extends Testbase
{
	
	public static void max_window()
	{
		driver.manage().window().maximize();
	}
	
	public static void implicit_wait(int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void selectByvalue(WebElement ele, String val)
	{
		Select sel=new Select(ele);
		
		sel.selectByValue(val);
	}
	
	public static void selectByvisibletext(WebElement ele, String val)
	{
		Select sel=new Select(ele);
		
		sel.selectByVisibleText(val);
	}
	
	public static void selectByindex(WebElement ele, int val)
	{
		Select sel=new Select(ele);
		
		sel.selectByIndex(val);
	}
	
	public static void alert_Okbutton()
	{
		Alert alt=driver.switchTo().alert();
		
		alt.accept();
	}
	
	public static void alert_Canclebutton()
	{
		Alert alt=driver.switchTo().alert();
		
		alt.dismiss();
	}
	
	public static void switchToFrameByindex(int frameindex)
	{
		driver.switchTo().frame(frameindex);
	}
	
	public static void switchToFrameByname(String framename)
	{
		driver.switchTo().frame(framename);
	}



}
