package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage
{
	WebDriver driver; //declare driver
	
	//create one constructor same name as class name
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

//this BasePage is not a page object class but it is required for every object class
//here we constructor part, which is required for every page object class
