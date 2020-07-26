package Steps;



//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;


import AmazonLib.*;
import Page.AmazonMainPage;



public class AddToCartSteps extends AmazonDriver{
	
//	AmazonConfig xreadconfig =new AmazonConfig();
//	public String br = xreadconfig.getbrowser();
	
	@Given("User is in Amazon Page")
	public void user_is_in_Amazon_Main_Page()  {
		setup();
		driver.getTitle();
		System.out.println(driver.getTitle());
//		Assert.assertTrue
	}
	
	@And("^User search the (.*) to search box")
	public void user_search_the_item_to_search_box(String item) {
		AmazonMainPage am = new AmazonMainPage(driver);	
		am.setSearchBox(item);
		am.click_search();
//		driver.findElement(By.xpath("//input[@value='Go']")).click();
	}

	@When("^the (.*) displayed")
	public void the_item_displayed(String item) {
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains(item));
	}

	@And("^user choose\\/select the (.*)")
	public void user_choose_select_the_item(String item) {
		driver.findElement(By.partialLinkText(item)).click();
	}

	@And("user click the Add To Cart button")
	public void user_click_the_Add_To_Cart_button() throws Throwable {
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(9000);
	}

	@Then("user click the Cart Icon")
	public void user_click_the_Cart_Icon() throws Throwable {
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains("Added to Cart"));
		boolean cart_icon = driver.findElements(By.id("attach-desktop-sideSheet")).isEmpty();
				
		if (cart_icon == true) {
			driver.findElement(By.xpath("//*[@id=\"nav-cart\"]/span[3]")).click();
		} else
		{
			driver.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"nav-cart\"]/span[3]")).click();
		}
	}

	@And("^check if the selected (.*) was added")
	public void check_if_the_selected_item_was_added(String item) throws Throwable{
		Assert.assertTrue("Passed", driver.findElement(By.cssSelector("BODY")).getText().contains(item));
		Thread.sleep(3000);
	}
	
	@And("navigate to Shop by category menu")
	public void navigate_to_Shop_by_category_menu() throws Throwable{
		AmazonMainPage am = new AmazonMainPage(driver);
		am.click_humburger_icon();
		Thread.sleep(1000);		
		am.select_category_echo_and_alexa();
		
	
	}
	
	@And("^filter by number of (.*)")
	public void filter_by_number_of_stars(Integer star) throws Throwable{
		AmazonMainPage am = new AmazonMainPage(driver);
		am.select_by_number_star(star);
		Thread.sleep(3000);
	}
	
	@And("^filter product by (.*)")
	public void filter_by_brand(String brand) throws Throwable{
		AmazonMainPage am = new AmazonMainPage(driver);
		am.select_by_brand(brand);
		Thread.sleep(3000);
	}
	
	
	@Given("Close Session")
	public void Close_Session() throws Throwable{
		driver.quit();		
	
	}
	
	
}
