package qainfotech.TatocAdvancedCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriver driver;
        //System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver.exe");
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.firefox.marionette","D:\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
        driver = new FirefoxDriver();
        String BaseUrl = "http://10.0.1.86/tatoc";
        
        driver.get(BaseUrl);
        WebElement we = driver.findElement(By.linkText("Advanced Course"));
        we.click();
        
        
        /*Thread.sleep(5000);
        we = driver.findElement(By.className("menutitle"));
        Select s = new Select(we);
        s.selectByVisibleText("Go Next");*/
        
        
        Thread.sleep(2000);
        we = driver.findElement(By.className("menutitle"));
        Actions a = new Actions(driver);
        a.moveToElement(we).build().perform();
        we = driver.findElement(By.cssSelector("span.menuitem[onclick=\"gonext();\"]"));
        we.click();
        
    }
}
