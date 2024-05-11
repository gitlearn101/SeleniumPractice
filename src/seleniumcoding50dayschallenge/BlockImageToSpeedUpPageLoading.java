// One effective way to speed up the process is by blocking image loading & maximize window using chromeOptions

package seleniumcoding50dayschallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlockImageToSpeedUpPageLoading {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--blink-settings=ImageEnabled=false", "--start-maximized");   // block image & maximize window
		
		driver = new ChromeDriver(options);
		
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

	
	@Test
	public void run() {
		
		driver.get("https://www.freepik.com/");
		
	}
	
}
