package AmazonLib;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;



public class AmazonDriver {
	
	AmazonConfig readconfig = new AmazonConfig();
	public String url = readconfig.getApplicationURL();
	String br = readconfig.getbrowser();
//	static WebDriver ff = readconfig.getdriver();
	public static final WebDriver driver = new FirefoxDriver();
//	public static WebDriver driver = ff;
//	public static WebDriver driver; 


	public void setup(){
		
		

		if(br.equals("chrome"))
		{
		

			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
//			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else 
		{



			System.setProperty("webdriver.firefox.driver",readconfig.getFirefoxPath());
//			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		driver.get(url);
	}

//	

}
