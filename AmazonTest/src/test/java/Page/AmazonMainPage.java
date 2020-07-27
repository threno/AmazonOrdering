package Page;

//import javax.xml.xpath.XPathExpression;
//import javax.xml.xpath.XPath;
//import javax.xml.xpath.XPathConstants;
//import javax.xml.xpath.XPathFactory;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonLib.*;

public class AmazonMainPage extends AmazonDriver{
	Actions actions = new Actions(driver);
	
//	By txt_search = By.name("field-keywords");
	@FindBy(name="field-keywords")
	@CacheLookup
	WebElement txt_search;
	
	@FindBy(id="nav-hamburger-menu")
	@CacheLookup
	WebElement humburger_icon;
	
	@FindBy(xpath="//div[@id='hmenu-content']/ul/li[3]/a/div")
	@CacheLookup
	WebElement cat_alexa; 
	
	
	//*[@id="p_72/2661621011"]/span/a/section
	
	
	
	@FindBy(id="p_72/2661621011")
	@CacheLookup
	WebElement onestarUp;

	@FindBy(id="p_72/2661620011")
	@CacheLookup
	WebElement twostarUp;
	
	@FindBy(id="p_72/2661619011")
	@CacheLookup
	WebElement threesstarUp;
	
	@FindBy(id="p_72/2661618011")
	@CacheLookup
	WebElement fourstarUp;
	
	
	By bnt_search = By.xpath("//input[@value='Go']");
	
	By alexa =	By.linkText("Echo Show 5");
	
	
	@FindBy(xpath="//*[@id=\"p_89/Acer\"]/span/a/div")
	@CacheLookup
	WebElement chk_acer;
	
	@FindBy(xpath="//*[@id=\"p_89/HP\"]/span/a/div")
	@CacheLookup
	WebElement chk_hp;
	
	@FindBy(xpath="//*[@id=\"p_89/Dell\"]/span/a/div")
	@CacheLookup
	WebElement chk_dell;
	
	@FindBy(xpath="//*[@id=\"p_89/SAMSUNG\"]/span/a/div")
	@CacheLookup
	WebElement chk_samsung;
	
	
	public AmazonMainPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	XPathFactory xpathFactory = XPathFactory.newInstance();
//	XPath xpath = xpathFactory.newXPath();
//
//	XPathExpression xpr = xpath.compile("count(//*[@id=\"hmenu-content\"]/ul[3])");
	public void setSearchBox(String forsearch)
	{
		txt_search.sendKeys(forsearch);
	}
	
	public void click_search()
	{
		driver.findElement(bnt_search).click();
	}
	public void click_humburger_icon()
	{
						
//		WebElement hmicon = humburger_icon;
		actions.moveToElement(humburger_icon);
		actions.click().build().perform();
		
	}
	public void select_category_echo_and_alexa() {
//		WebElement shopcat  = driver.findElement(By.xpath("//div[@id='hmenu-content']/ul/li[3]/a/div"));
		actions.moveToElement(cat_alexa);
		actions.click().build().perform();
	}
	public void teardown() {
		driver.quit();
	}
	
	public void select_by_number_star(String star) {
		switch(star) {
		  case "1":
			  onestarUp.click();
		    break;
		  case "2":
			  twostarUp.click();
		    break;
		  case "3":
			  threesstarUp.click();
		  case "4":
			  fourstarUp.click();
		}
	}
	
	public void select_by_brand(String brand) {
		switch(brand) {
		  case "Acer":
			  chk_acer.click();
		    break;
		  case "Dell":
			  chk_dell.click();
		    break;
		  case "HP":
			  chk_hp.click();
		  case "Samsung":
			  chk_samsung.click();
		}
	}
}
