package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.NewCustomerPage;
import TestBase.BaseClass;

public class LoginTest__001 extends BaseClass{

	@Test()
	public void login() throws InterruptedException, IOException
	{
		
		
		logger.info("**URL is opened** ");
		Thread.sleep(1000);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		Thread.sleep(1000);
		logger.info("**Entered data** ");
		lp.clickLogin();
		Thread.sleep(1000);
		
		logger.info("**Logged in** ");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("**Login passed** ");
		}
		else
		{
			logger.info("**Login Failed** ");
			captureScreen(driver, "login");
			Assert.assertTrue(false);
			logger.info("**Login Failed** ");
		}
		
		
	}
	
		
				
}
