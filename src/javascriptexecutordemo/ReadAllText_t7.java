package javascriptexecutordemo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadAllText_t7 {

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

	// scroll for element to be in view
	@Test(priority = 1)
	public void demoReadAllText() throws InterruptedException, IOException {

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String readAllText = jse.executeScript("return document.documentElement.innerText").toString();

		Thread.sleep(1000);
		System.out.println(readAllText);

	}

}
