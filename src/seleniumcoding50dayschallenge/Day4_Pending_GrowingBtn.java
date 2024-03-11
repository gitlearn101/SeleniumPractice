package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day4_Pending_GrowingBtn {
	
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

	// @AfterTest
	void teardown() {
		driver.quit();
	}

	@Test
	void demo() {

		driver.get("https://testpages.eviltester.com/styled/challenges/growing-clickable.html");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.cssSelector("button.grown"))));
		
		driver.findElement(By.cssSelector("button#growbutton")).click();
		
		
	}

	

}
