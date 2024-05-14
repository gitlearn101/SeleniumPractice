// Relative Locator of Selenium4

package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorDemo {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*", "--start-maximized");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	//@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void demo() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement usernameTxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Username']")));
		usernameTxt.sendKeys("Admin");
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		
		// Relative xpath to find password
		WebElement passwordTxt = driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginBtn));
		passwordTxt.sendKeys("admin123");
		
		loginBtn.click();
		
	}
}
