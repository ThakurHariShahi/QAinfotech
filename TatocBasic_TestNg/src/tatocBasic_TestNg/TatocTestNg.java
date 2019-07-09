package tatocBasic_TestNg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TatocTestNg {

	WebDriver driver;
	String b1, b2;
	WebElement x, y;
	String MainWindow,ChildWindow;

	/*
	 * @Test public void open() { String url = "http://10.0.1.86/tatoc";
	 * System.setProperty("webdriver.chrome.driver",
	 * "/home/qainfotech/Downloads/chromedriver"); driver = new ChromeDriver();
	 * driver.get(url); System.out.println("open"); //
	 * driver.manage().window().maximize(); }
	 * 
	 * @Test(dependsOnMethods = "open") public void checkTitle() {
	 * 
	 * String expectedTitle = "Welcome - T.A.T.O.C"; String actualTitle =
	 * driver.getTitle(); System.out.println("checkTitle");
	 * Assert.assertEquals(actualTitle, expectedTitle, "galat hai");
	 * System.out.println("checkTitle"); InterruptedException }@test
	 * 
	 */
	@Test(priority = -001)
	public void Test01Open() throws IOException {
		/*
		 * For Ubunto FileInputStream objfile=new
		 * FileInputStream(System.getProperty("user.dir") + "/properties.properties");
		 */

		// For windows
		Properties p = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\properties.properties");
		p.load(objfile);
		// System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		// driver = new ChromeDriver();
		// System.setProperty("webdriver.firefox.marionette","D:\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(p.getProperty("Url"));
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void Test02click() {
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.cssSelector("div.greenbox[onclick=\"passthru();\"]")).click();

	}

	@Test(priority = 3)
	public void Test03boxcolourmatched() {
		driver.switchTo().frame("main");
		b1 = driver.findElement(By.id("answer")).getAttribute("class");
		do {
			driver.findElement(By.linkText("Repaint Box 2")).click();
			driver.switchTo().frame("child");
			b2 = driver.findElement(By.id("answer")).getAttribute("class");
			// driver.switchTo().frame("main");
			driver.switchTo().parentFrame();
			// System.out.println(b2);

		} while (!(b1.equals(b2)));

		driver.findElement(By.linkText("Proceed")).click();
		driver.switchTo().defaultContent();
	}

	@Test(priority = 4)
	public void Test04dragdrop() {
		x = driver.findElement(By.cssSelector("div[class=\"ui-draggable\"]"));
		// x = driver.findElement(By.cssSelector("div.ui-draggable"));
		// x =
		// driver.findElement(By.cssSelector("div#dragbox[class=\"ui-draggable\"]"));
		y = driver.findElement(By.cssSelector("div#dropbox"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(x, y).build().perform();
		driver.findElement(By.linkText("Proceed")).click();

	}

	@Test(priority = 5)
	public void Test05TabSwitching() {
		driver.findElement(By.linkText("Launch Popup Window")).click();
		MainWindow = driver.getWindowHandle();
		System.out.println("Test05TabSwitching");
		System.out.println(MainWindow);
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				/*
				 * b2 = driver.getTitle(); System.out.println(b2);
				 * System.out.println(ChildWindow);
				 */
			}
		}

	}

	@Test(priority = 6)
	public void Test06SubmitData() throws InterruptedException, DocumentException {
		/*
		 * read xml file (first.xml) For Windows :-
		 */
		File inputFile = new File(
				"C:\\Users\\harishahi\\eclipseoxy\\eclipse-workspace\\TatocBasic_TestNg\\properties.xml");
		// File inputFile = new File(System.getProperty("user.dir")
		// +"\\properties.xml");

		/*
		 * For Ubunto :- File inputFile = new
		 * File("/home/qainfotech/eclipse-workspace/tatoctestng/first.xml");or File
		 * inputFile = new File(System.getProperty("user.dir") +"/first.xml");
		 */

		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		String str = document.selectSingleNode("//menu/name").getText();
		driver.findElement(By.id("name")).sendKeys(str);

		// Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		// Thread.sleep(1000);
		driver.switchTo().window(MainWindow);
		driver.findElement(By.linkText("Proceed")).click();
		// Thread.sleep(1000);

	}

	@Test(priority = 7)
	public void Cookie() throws InterruptedException {
		driver.findElement(By.linkText("Generate Token")).click();
		Thread.sleep(1000);
		String token = driver.findElement(By.xpath("//*[@id=\"token\"]")).getText();
		token = token.substring(7);
		System.out.println(token);

		Cookie name = new Cookie("Token", token);
		driver.manage().addCookie(name);
		Cookie n = driver.manage().getCookieNamed("Token");
		System.out.println("Cookie :-" + n);
		/*
		 * Set<Cookie> cookiesList = driver.manage().getCookies(); Iterator <Cookie> i
		 * =cookiesList.iterator(); System.out.println(i.next());
		 */
		/*
		 * for(Cookie getcookies:cookiesList) { System.out.println(getcookies); }
		 */

	}

	@Test(priority = 8)
	public void close() {
		x = driver.findElement(By.cssSelector("a[onclick=\"gonext();\"]"));

		x.click();
		/* driver.close(); */
	}

}
