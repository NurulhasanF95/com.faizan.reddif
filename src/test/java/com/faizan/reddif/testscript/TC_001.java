package com.faizan.reddif.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.faizan.reddif.base.Testbase;
import com.faizan.reddif.pages.LoginPage;
import com.faizan.reddif.util.Read_Excel;

public class TC_001 extends Testbase
{
	LoginPage page;
	
	@BeforeTest
	public void setUp()
	{
		browserSetup();
		page=new LoginPage();
	}
	
	@Test(priority = 1)
	public void validateLoginPageTitle()
	{
		String actualTitle=page.verifyTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Test(priority = 2)
	public void validateLoginPageUrl()
	{
		String actualUrl=page.verifyUrl();
		
		Assert.assertEquals(actualUrl, "https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority = 3)
	public void validateLoginPaneltxt()
	{
		String actualText=page.verifyLoginpaneltext();
		
		Assert.assertEquals(actualText,"LOGIN Panel");
	}
	
	@Test(priority = 4, enabled=true)
	public void validateLogin()
	{
		page.verifyloginPage();
	}
	
	@Test(priority = 5, dataProvider = "s1", enabled=false)
	public void validateLoginDDF(String username, String password) throws InterruptedException
	{
	  page.userNametxtbx.sendKeys(username);
	  page.passwordtxtbx.sendKeys(password);
	  page.loginBtn.click();
	  Thread.sleep(3000);
	  page.welcomebtn.click();
	  page.logoutbtn.click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	@DataProvider(name="s1")
	public Object[][] getData()
	{
		Read_Excel r=new Read_Excel(".\\src\\main\\java\\com\\faizan\\reddif\\exceldata\\Arshad.xlsx");
		
		int rows=r.TotalRow("Sheet1");
		
		int cols=r.Totalcolumn("Sheet1");
		
		Object[][] obj=new Object[rows][cols];
		
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				obj[i][j]=r.getdata("Sheet1", i, j);
			}
		}
		
		return obj;
	}
}
