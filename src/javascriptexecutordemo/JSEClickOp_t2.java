package javascriptexecutordemo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSEClickOp_t2 {
	
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

	// Method =1 : click an element by using JSE DOM statement
	@Test(priority=1)
	public void demoClickOne() throws InterruptedException {
		
		driver.get("https://omayo.blogspot.com/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('alert1').click()");
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
	}
	
	// Method 2 : click an element by using JSE arguments
	@Test(priority=2)
	public void demoClickArg() throws InterruptedException {
		
		driver.get("https://omayo.blogspot.com/");
		
		WebElement btnEle = driver.findElement(By.id("alert1"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",btnEle);
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
	}
	
	
}
