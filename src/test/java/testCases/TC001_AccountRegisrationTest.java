package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;


public class TC001_AccountRegisrationTest extends BaseClass
{
	/*  separate all these common methods to another base class
	 * this class should extends the parent class base class
	 
	//one single class is for one test case
	//create public methods for accessing throughout the project
	//setup() for launching the browser related
	//teardown() for close or quit 
	//actual test 
	//create one variable webdriver as public
	
	public WebDriver driver;
	
	@BeforeClass
	void setUp() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies(); //delete all cookies
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
	*/
	
	//actual test
	
	@Test
	void verify_account_registration()
	{
		//to implement this test we have to take help of page object classes 
		//1st one is homepage object class from home page need to click on register
		//to access the page object class of homepage have to create object of homepage class
		//through that object we can access the methods
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		//also create object of account registration page
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		//regpage.setFirstName("Ram");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); //randomly generated email
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphanumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setSubscribe();
		regpage.setPolicy();
		regpage.clickBtn();
		
		String confmsg = regpage.getConfirmMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		
	}
	
	//here we have access the page object classes and passed the all data 
	
	/*
	//create one user defined java method for creating random test datas
	//in java randomstringutils is a predefined class 
	//and a method random alphabetics
	
	public  String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	//this will generated new  random strings everytime
	//call the created method instead of passing the hardcoded value and concate with required text
	//and also can do with multiple operations

	//also can generate random numeric data by a method
	public String randomNumber()
	{
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	//also can generate alpha numeric data
	public String randomAlphanumeric()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(4);
		return (generatedstring+"#"+generatednumber);
	}
	
	//if there is password and confirmpassword field and we use random alphanumeric,
	//then there will be error because every time the method will create different data
	//so it can't match
	//for this have to call the method and store the value in a string variable
	//and pass the variable in both the places
	 
	 */
}

//here some methods are commonly required for multiple testcases like setup teardown random data methods ,
//so we can keep these methods in another class under testcases
//as baseclass for all classes, here we maintain the re usable methods, what ever required for the test cases 
//those methods we keep inside this class

//to get the driver and the methods from the testcases,
//simply must have to extends Baseclass
//base class is the parent class of all the testcase classes
//the main objective of separating this is to achieve reusability
//because the methods which are repeating or required in every test cases
//we can kept it inside a separate class and can reuse in every testcases classes 

//execute the testcase class







