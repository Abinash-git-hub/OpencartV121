package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//this is the base class parent class of all testcases under TestBase package
//methods are commonly required for multiple testcases like setup teardown random data methods ,
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


public class BaseClass 
{
public WebDriver driver;
public Properties p; //create a property class variable. by using this can load properties file  and get the values
	
	@BeforeClass
	@Parameters({"os","browser"})
	void setUp(String os, String br) throws IOException
	{
		//loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		//load the file by using create the object for properties file 
		p=new Properties();
		p.load(file);   //load the file 
		
		
		//selenium grid concept started..added in base class
		//if env is remote have to decide in which os have to use and
		//which browser have to launch in perticular node
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//for os..
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WINDOWS);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("no matching os..");
				return;
			}
			
			//for browser..
			switch(br.toLowerCase())
			{
			case "chrome" :capabilities.setBrowserName("chrome"); break;
			case "edge" :capabilities.setBrowserName("MicrosoftEdge"); break;
			default : System.out.println("no matching browser.."); return;
			}
			
			//for local environment copy the below conditions
			
			//launch the url in grid
			driver = new RemoteWebDriver(new URL("http://192.168.1.10:4444/wd/hub"),capabilities);
			
			
			
		}
		
		//end
		
		
		
		//before launching the browser have to based on condition, launch particular browser
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		default : System.out.println("Invalid browser name.."); return;
		}
		
		//driver=new ChromeDriver();
		
		
		driver.manage().deleteAllCookies(); //delete all cookies
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://tutorialsninja.com/demo/"); instead of hardcoaded get it by properties file
		driver.get(p.getProperty("appUrl")); //reading the url from properties file
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
	//some methods for creating random data
	public  String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomAlphanumeric()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(4);
		return (generatedstring+"#"+generatednumber);
	}
	
	


}
