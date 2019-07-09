package co.qa.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Steps {
	WebDriver driver;
	String BaseUrl;
	@Given("^Open the chrome and launch the browser$")
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver = new ChromeDriver();
		BaseUrl = "http://10.0.1.86/tatoc";
		driver.get(BaseUrl);
	}
	
	@When("^Click on Basic Course Link$")
	public void click_on_Basic_Course_Link(){
		WebElement we = driver.findElement(By.cssSelector("a[href=\"/tatoc/basic\"]"));
		we.click();
	}
	

    @Then("^Open Basic Grid Gate page$")
   public void open_Basic_Grid_Gate_page() {
	String et = "Grid Gate - Basic Course - T.A.T.O.C";	 
	   String at = driver.getTitle();
	   Assert.assertEquals("Wrong Page Dummy",et,at);
}
}
