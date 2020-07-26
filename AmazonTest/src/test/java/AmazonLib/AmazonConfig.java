package AmazonLib;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonConfig {
	
	Properties pro;
	
	public AmazonConfig() {
		File src = new File(".\\src\\test\\java\\AmazonLib\\amazonconfig.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("amazonurl");
		return url;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chrome");
	return chromepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefox");
	return firefoxpath;
	}
	
	public String getbrowser()
	{
	String browser=pro.getProperty("browser");
	return browser;
	}
	
	public WebDriver getdriver()
	{
		WebDriver fdriver;
		if (pro.getProperty("browser")=="firefox") {
			fdriver = new FirefoxDriver();
		} else {
			fdriver = new ChromeDriver();
		}
	return fdriver;
	}


}
