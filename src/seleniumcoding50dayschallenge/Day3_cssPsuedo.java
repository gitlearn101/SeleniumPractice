// css Psuedo element
// https://www.linkedin.com/posts/kushalparikh11_50daysofcodechallenge-selenium-activity-7168568033995702272-37Wy/?utm_source=share&utm_medium=member_desktop

package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day3_cssPsuedo {

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

		driver.get("https://play1.automationcamp.ir/advanced.html");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String starRating = js.executeScript("return window.getComputedStyle(document.querySelector('.star-rating'), '::after').getPropertyValue('content')").toString();

		System.out.println(starRating);
		
		String starRatingToBePushed = starRating.replace("\"", "");
		
		driver.findElement(By.id("txt_rating")).sendKeys(starRatingToBePushed);
		
		driver.findElement(By.id("check_rating")).click();
		
		String actualDisplayMessage = driver.findElement(By.id("validate_rating")).getText();
		
		Assert.assertEquals(actualDisplayMessage, "Well done!");

	}

}
