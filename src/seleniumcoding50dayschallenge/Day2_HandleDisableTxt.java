// Develop an automation script that will input a value in a disabled field (You cannot able to input value in field with sendkeys() directly if field is disabled)

// https://www.linkedin.com/posts/kushalparikh11_50daysofcodechallenge-selenium-activity-7168225014629044224-3FuG/?utm_source=share&utm_medium=member_desktop

package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2_HandleDisableTxt {
	
WebDriver driver;
	
	@BeforeTest
	void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	//@AfterTest
	void teardown() {
		driver.quit();
	}
	
	@Test
	void demo() {
		
		
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('pass').removeAttribute('disabled')");
		driver.findElement(By.id("pass")).sendKeys("hello");
		
		
	}
	


}
