package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver driver;
	public NewCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='New Customer']")
	WebElement clickNewcustomer;
	
	
	@FindBy(xpath="//input[@name='name']")
	WebElement txtname;
	
	
	@FindBy(xpath="//tbody/tr[5]/td[2]")
	WebElement btngender;
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement txtdob;
	
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement txtaddress;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement txtcity;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement txtstate;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement txtpinno;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement txtphoneno;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement btnsubmit;
	
	public void Newcustomer()
	{
		clickNewcustomer.click();
	}
	public void setuname(String uname)
	{
		txtname.sendKeys(uname);
	}
	
	public void setGender()
	{
		btngender.click();
	}
	
	public void setDateofB(String dob)
	{
		txtdob.sendKeys(dob);
	}
	
	public void setAddress(String add)
	{
		txtaddress.sendKeys(add);
	}
	
	public void setcity(String city)
	{
		txtcity.sendKeys(city);
	}
	
	public void setstate(String state)
	{
		txtstate.sendKeys(state);
	}
	
	public void setpin(String pin)
	{
		txtpinno.sendKeys(pin);
	}
	
	public void setphoneno(String phoneno)
	{
		txtphoneno.sendKeys(phoneno);
	}
	
	public void clickbtn()
	{
		btnsubmit.click();
	}
	
}
