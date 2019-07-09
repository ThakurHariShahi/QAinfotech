package com.qa.pom.script;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*import com.qa.pom.classes.BasicCookiePage;
import com.qa.pom.classes.BasicDragPage;
import com.qa.pom.classes.BasicFrameDungeonPage;
import com.qa.pom.classes.BasicGridGatePage;
import com.qa.pom.classes.BasicWindowsPage;
import com.qa.pom.classes.BasicWindowsPopupPage;
import com.qa.pom.classes.TatocPage;*/
import com.qa.pom.objects.PageObjects;

public class TestNgBasicCourse2 {
	WebDriver driver;
	PageObjects PageObjects_object;
	String base_url = "http://10.0.1.86/tatoc";
	
	String mainWindow;
	String childWindow;
	Set<String> s;
	Iterator<String> i ;
	
	String name;
	@BeforeTest
	  @Parameters("browser")
	  public void f(String browser) {
		  if(browser.equalsIgnoreCase("firefox"))
		  {
			  System.setProperty("webdriver.firefox.marionette","D:\\geckodriver.exe");
			  driver = new FirefoxDriver();
			  driver.get(base_url);
		  }
		  else
		  {
			  if(browser.equalsIgnoreCase("chrome"))
			  {
				  System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
				  driver = new ChromeDriver();
				  driver.get(base_url);
			  }
		  }
		  
		  
	  }
	@Test
	  public void performTatocBasicCourse() {
		  PageObjects_object = new PageObjects(driver);
		  driver.manage().timeouts().pageLoadTimeout(55, TimeUnit.SECONDS);
		  //TatocPage_object	 = new TatocPage(driver);  
		  PageObjects_object.TatocPage_object.clickOnBasicCourse();
		  
		  //BasicGridGatePage_object = new BasicGridGatePage(driver);
		  PageObjects_object.BasicGridGatePage_object.clickOnGreenBox();
		  
		  //BasicFrameDungeonPage_object = new BasicFrameDungeonPage(driver);
		  PageObjects_object.BasicFrameDungeonPage_object.clickOnRepaintBox2();
		  
		  //BasicDragPage_object = new BasicDragPage (driver);
		  PageObjects_object.BasicDragPage_object.performDragAndDrop();
		  
		  //BasicWindowsPage_object = new BasicWindowsPage(driver);
		  PageObjects_object.BasicWindowsPage_object.clickOnLaunchPopupWindow();
		  mainWindow = driver.getWindowHandle();
		  s = driver.getWindowHandles();
		  i = s.iterator();
		  
		  while(i.hasNext())
		  {
			  childWindow = i.next();
			  if(!mainWindow.equalsIgnoreCase(childWindow))
			  {
				  driver.switchTo().window(childWindow);
			  }
		  }
		  //BasicWindowsPopupPage_object = new BasicWindowsPopupPage(driver);
		  name = "Thakur Hari Shahi";
		  PageObjects_object.BasicWindowsPopupPage_object.clickOnSubmitButton(name);
		  driver.switchTo().window(mainWindow);
		  PageObjects_object.BasicWindowsPage_object.clickOnProceed();
		  //BasicCookiePage_object = new BasicCookiePage(driver);
		  PageObjects_object.BasicCookiePage_object.generateToken();
		  
	  }
}
