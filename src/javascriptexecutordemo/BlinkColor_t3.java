package javascriptexecutordemo;

import java.time.Duration;

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

public class BlinkColor_t3 {

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

	@Test(priority = 1)
	public void demoFlashOne() throws InterruptedException {

		driver.get("https://tutorialsninja.com/demo/");

		WebElement cartBtn = driver.findElement(By.xpath("//div[@id='cart']/button"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		String defaultColor = cartBtn.getCssValue("background-color");

		for (int i = 0; i < 5; i++) {

			jse.executeScript("document.querySelector('div#cart > button').style.background='" + defaultColor + "'");

			Thread.sleep(1000);

			jse.executeScript("document.querySelector('div#cart > button').style.background='yellow'");

		}

	}

}