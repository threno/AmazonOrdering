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
		
			System.out.println("2");
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
//			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else 
		{

			System.out.println("3");
//			System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
			System.setProperty("webdriver.firefox.driver",readconfig.getFirefoxPath());
//			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		

//		System.setProperty("webdriver.firefox.driver",readconfig.getFirefoxPath());
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		System.out.println("4");
		driver.get(url);
	}

//	

}
