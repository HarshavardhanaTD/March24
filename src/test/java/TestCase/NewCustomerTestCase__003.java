package TestCase;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.NewCustomerPage;
import TestBase.BaseClass;


public class NewCustomerTestCase__003 extends BaseClass{
	
	@Test()
	public void NewCustomerCreation() throws InterruptedException
	{
		
		logger.info("**URL is opened** ");
		Thread.sleep(1000);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("username");
		lp.setPassword("password");
		Thread.sleep(1000);
		logger.info("**Entered data** ");
		lp.clickLogin();
		Thread.sleep(1000);
		
		
		
		NewCustomerPage newcus= new NewCustomerPage(driver);
		newcus.Newcustomer();
		newcus.setuname("Harsha");
		newcus.setGender();
		newcus.setDateofB("27-02-1999");
		newcus.setAddress("bangalore");
		newcus.setcity("bangalore");
		Thread.sleep(1000);
		newcus.setstate("karnataka");
		newcus.setpin("1234");
		newcus.setphoneno("9482382414");
		Thread.sleep(1000);
		newcus.clickbtn();
	}
	
	
}
