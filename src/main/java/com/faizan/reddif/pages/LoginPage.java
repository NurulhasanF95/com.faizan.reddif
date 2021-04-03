package com.faizan.reddif.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.faizan.reddif.base.Testbase;

public class LoginPage extends Testbase 
{
	
	@FindBy(id="logInPanelHeading")
	WebElement loginPanel;
	
	@FindBy(xpath="//input[@name='txtUsername']")
	public WebElement userNametxtbx;
	
	@FindBy(name="txtPassword")
	public WebElement passwordtxtbx;
	
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy(id="forgotPasswordLink")
	WebElement forgotPassword;
	
	
	@FindBy(xpath="//span[text()='( Username : Admin | Password : admin123 )']")
	WebElement usernameandpassword;
	
	@FindBy(id = "welcome" )
	public WebElement welcomebtn;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logoutbtn;
	
	
	
	public LoginPage()
	{
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String verifyTitle()
	{
		String title=driver.getTitle();
		
		return title;
	}
	
	public String verifyUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyLoginpaneltext()
	{
		return loginPanel.getText();
	}
	
	public void verifyloginPage()
	{
		userNametxtbx.sendKeys(pro.getProperty("username"));
		passwordtxtbx.sendKeys(pro.getProperty("password"));
		loginBtn.click();
	}

}
