package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day4_GrowingBtn {
	
	WebDriver driver;

	@BeforeTest
	void setup() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	
	@AfterTest
	void teardown() {
		driver.quit();
	}

	@Test
	void demo() {

		driver.get("https://testpages.eviltester.com/styled/challenges/growing-clickable.html");
		
		// Find the button element by its ID
		WebElement button = driver.findElement(By.id("growbutton"));
		WebElement text = driver.findElement(By.id("growbuttonstatus"));
		
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.attributeContains(button, "class", "grown"));
		
		if (button.isEnabled()) {
		button.click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(d -> text.isDisplayed());
		
		if (text.isDisplayed()) {
		String eventTriggerMsg = driver.findElement(By.xpath("//p[@id='growbuttonstatus']")).getText();
		System.out.println(eventTriggerMsg);
		
		Assert.assertEquals(eventTriggerMsg,"Event Triggered");
		}
		}
		else {
		System.out.println("Not Clicked");
		}
		
		
	}

	

}
