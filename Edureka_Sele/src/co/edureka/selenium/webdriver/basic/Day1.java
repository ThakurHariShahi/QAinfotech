package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {
    ///webdriver is an interface and it has got the functions inside it
	
	WebDriver driver;
	public void invokebrowser() {
	
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		/// impolicitlywait define the time for which our script will wait
		/// for the web application to load 
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		//to fetch url
		driver.get("http://www.edureka.co");
		
	}
	
	public void searchCourse() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

