package qainfotech.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty( "webdriver.chrome.driver","D:\\chromedriver.exe"  );
    	WebDriver driver  = new ChromeDriver();
		driver.get("https://www.google.com");
		 driver.manage().window().fullscreen();
        driver.findElement(By.xpath("//a[@class=\"gb_d\"]")).click();
        /*driver.findElement(By.xpath("input.whsOnd[name=\"identifier\"]")).;
        driver.findElement(By.xpath("")).click();
        driver.findElement(By.xpath("li.h-c-header__nav-li:nth-child(2) .h-c-header__nav-li-link")).click();
        driver.findElement(By.xpath("//a[@href="https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/"]")).click();
        driver.findElement(By.xpath("//a[@href=\"https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/\" and @target = \"_blank\"  ]")).click();
*/	}

}
