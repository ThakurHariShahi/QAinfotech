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

import com.qa.pom.classes.BasicCookiePage;
import com.qa.pom.classes.BasicDragPage;
import com.qa.pom.classes.BasicFrameDungeonPage;
import com.qa.pom.classes.BasicGridGatePage;
import com.qa.pom.classes.BasicWindowsPage;
import com.qa.pom.classes.BasicWindowsPopupPage;
import com.qa.pom.classes.TatocPage;
import com.qa.pom.objects.PageObjects;

public class TestNgBasicCourse3 {
	WebDriver driver;
	PageObjects PageObjects_object;
	String base_url = "http://10.0.1.86/tatoc";
	
	String mainWindow;
	String childWindow;
	Set<String> s;
	Iterator<String> i ;
	
	String name;
	
	TatocPage TatocPage_object;
	BasicGridGatePage BasicGridGatePage_object;
	BasicFrameDungeonPage BasicFrameDungeonPage_object;
	BasicDragPage BasicDragPage_object;
	BasicWindowsPage BasicWindowsPage_object;
	BasicWindowsPopupPage BasicWindowsPopupPage_object;
	BasicCookiePage BasicCookiePage_object;
	 
	@Test
	  public void performTatocBasicCourse() {
		//PageObjects_object = new PageObjects(driver);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
		/*WebDriverWait o = new WebDriverWait(driver,5).until(ExpectedCondition);*/

		  TatocPage_object	 = new TatocPage(driver);  
		  TatocPage_object.clickOnBasicCourse();
		  
		  BasicGridGatePage_object = new BasicGridGatePage(driver);
		  BasicGridGatePage_object.clickOnGreenBox();
		  
		  BasicFrameDungeonPage_object = new BasicFrameDungeonPage(driver);
		  BasicFrameDungeonPage_object.clickOnRepaintBox2();
		  
		  BasicDragPage_object = new BasicDragPage (driver);
		  BasicDragPage_object.performDragAndDrop();
		  
		  BasicWindowsPage_object = new BasicWindowsPage(driver);
		  BasicWindowsPage_object.clickOnLaunchPopupWindow();
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
		  BasicWindowsPopupPage_object = new BasicWindowsPopupPage(driver);
		  name = "Thakur Hari Shahi";
		  BasicWindowsPopupPage_object.clickOnSubmitButton(name);
		  driver.switchTo().window(mainWindow);
		  BasicWindowsPage_object.clickOnProceed();
		  BasicCookiePage_object = new BasicCookiePage(driver);
		  BasicCookiePage_object.generateToken();
		  
	  }
  
	
  @BeforeTest
  @Parameters("browser")
  public void f(String browser) {
	  System.out.println(browser);
	  if(browser.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get(base_url);
		  System.out.println("firefox :- "+driver);
		 
	  }
	  
		  if(browser.equalsIgnoreCase("chrome"))
		  {
			  System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			  driver = new ChromeDriver();
			  driver.get(base_url);
			  System.out.println("chrome :- "+driver);
		  }
		 
	  
  }
}
