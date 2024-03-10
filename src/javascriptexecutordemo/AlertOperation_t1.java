package javascriptexecutordemo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertOperation_t1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void demo() throws InterruptedException {
		
		driver.get("https://omayo.blogspot.com/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("alert('hello world')");
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
	}
	
	@Test(priority=2)
	public void demoone() throws InterruptedException {
		
		driver.get("https://omayo.blogspot.com/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("prompt('Who are you?')");
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.sendKeys("I am admin");
	}
	

	@Test(priority=3)
	public void demotwo() throws InterruptedException {
		
		driver.get("https://omayo.blogspot.com/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("confirm('we are online')");
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		
		
		System.out.println("The text from confirm/alert >>"+alert.getText());
	}
	
}
