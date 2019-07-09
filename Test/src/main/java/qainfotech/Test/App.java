package qainfotech.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws InterruptedException
    {
    	System.setProperty( "webdriver.chrome.driver","D:\\chromedriver.exe"  );
    	WebDriver driver  = new ChromeDriver();
        driver.get("https://hris.qainfotech.com/login.php");
        //driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"txtUserName\"]")).sendKeys("harishahi");
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[2]/div/input")).click();
        
        driver  = new ChromeDriver();
        driver.get("https://www.gmail.com");
        driver.manage().window().fullscreen();
        
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("harishahi");
        driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
        driver.close();
        
    }
}
