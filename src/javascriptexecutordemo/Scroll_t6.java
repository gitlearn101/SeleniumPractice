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

public class Scroll_t6 {

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
	public void demoScrollToElementView() throws InterruptedException, IOException {

		driver.get("https://omayo.blogspot.com/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('alert2').scrollIntoView(true)");
		Thread.sleep(1000);

	}

	// scroll till bottom of the screen
	@Test(priority = 2)
	public void demoScrollToBottom() throws InterruptedException, IOException {

		driver.get("https://omayo.blogspot.com/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);

	}

}
