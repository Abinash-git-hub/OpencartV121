package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	//every page object class should be extends from basepage
	//create one constructor as class name ,expecting driver from testcase
	//instead of doing "pagefactory init elements" ,
	//directly pass the same driver to the parent class constructor
	//inside parent class this constructor will receive the driver and initiate the driver
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//capture the elements by @findby 
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccnt;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	//capture the element for login link
	@FindBy(linkText= "Login")
	WebElement lnkLogin;
	
	
	
	//declare action methods
	
	public void clickMyAccount()
	{
		lnkMyaccnt.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	//add method for login
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
}

