package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	//add the constructor
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//add elements 
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	//verify the message
	public boolean isMyPageExists()
	{
		try
		{
		return(msgHeading.isDisplayed());	
		}catch(Exception e)
		{
		return false;	
		}
	}

}
