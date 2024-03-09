package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day6_StopProgressBar {

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
	public void stopbar() {

		driver.get("http://uitestingplayground.com/progressbar");

		WebElement startBtn = driver.findElement(By.cssSelector("#startButton"));
		WebElement stopBtn = driver.findElement(By.cssSelector("#stopButton"));
		WebElement progressBar = driver.findElement(By.id("progressBar"));

		startBtn.click();

		while (true) {
			int percentage = Integer.parseInt(progressBar.getText().replace("%", ""));

			if (percentage >= 75) {
				stopBtn.click();
				break;
			}

		}
	}
}
