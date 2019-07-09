package com.qa.pom.script;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.qa.pom.classes.BasicCookiePage;
import com.qa.pom.classes.BasicDragPage;
import com.qa.pom.classes.BasicFrameDungeonPage;
import com.qa.pom.classes.BasicGridGatePage;
import com.qa.pom.classes.BasicWindowsPage;
import com.qa.pom.classes.BasicWindowsPopupPage;
import com.qa.pom.classes.TatocPage;

public class TestNgBasicCourse {
	WebDriver driver;
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
  public void setUp() throws InterruptedException {
	  /*System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	  driver = new ChromeDriver();*/
		System.setProperty("webdriver.firefox.marionette","D:\\geckodriver.exe");
driver = new FirefoxDriver(); 
Thread.sleep(5000);
	  driver.get("http://10.0.1.86/tatoc");//(base_url);
      //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
  }
  @Test
  public void performTatocBasicCourse() {
	  TatocPage_object	 = new TatocPage(driver);  
	  TatocPage_object.clickOnBasicCourse();
	  
	  BasicGridGatePage_object = new BasicGridGatePage(driver);
	  BasicGridGatePage_object.clickOnGreenBox();
	  
	  BasicFrameDungeonPage_object = new BasicFrameDungeonPage(driver);
	  BasicFrameDungeonPage_object.clickOnRepaintBox2();
	  
	  BasicDragPage_object = new BasicDragPage(driver);
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
  @Test(dependsOnMethods="setUp")
  public void tearDown() {
	  //1247
	  //driver.close();
  }
}
