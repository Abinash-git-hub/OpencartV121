package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass
{
	//create login test
	@Test
	public void verifyLogin()
	{
		try
		{
		//to access homepage elements have to 
		//create object for homepage class by passing driver instance
		//by using the object call the action methods of the pageobject class
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//for login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("Email")); //pass the values from properties file
		lp.setPassword(p.getProperty("Password"));
		lp.clickLogin();
		
		//for MyAccount page
		MyAccountPage myacc = new MyAccountPage(driver);
		//perform the action and store in boolean type
		boolean targetPage = myacc.isMyPageExists();
		
		//Assert.assertEquals(targetPage, true, "Login Failed");
		
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	
	}
	

}
