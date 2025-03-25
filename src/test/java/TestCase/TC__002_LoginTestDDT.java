package TestCase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import TestBase.BaseClass;
import Utilities.XLUtilits.ExcelUtility;

public class TC__002_LoginTestDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void LoginDDT(String user, String pwd) throws InterruptedException
	{
		
		logger.info("**URL is opened** ");
		Thread.sleep(1000);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		System.out.println("Using Credentials - Username: " + user + " | Password: " + pwd);
		Thread.sleep(1000);
		logger.info("**Entered data** ");
		lp.clickLogin();
		Thread.sleep(1000);
		
		logger.info("**Logged in** ");
		
		
		Thread.sleep(1000);
		
		
		
		if (isAleartPreset()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(false);
			
		}
		
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			
			driver.switchTo().defaultContent();
		}

	}
	
	
	
	
	
	
	public boolean isAleartPreset()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir") + "/src/test/java/TestData/March23.xlsx";
		int rownum=ExcelUtility.getRowCount(path,"Sheet1");
		int colcount=ExcelUtility.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=ExcelUtility.getCellData(path, "Sheet1", i, j);
				
			}
		}

		return logindata;
			
	}
	
	
	
	
}
