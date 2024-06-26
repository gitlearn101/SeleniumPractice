// Practice web table. Pls refers to index.htm file under package named resourcefortesting for practice

package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountRowCol {
	
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
		
		driver.get("file:///C:/1New2/2_STUDY/howToRunHTML/index.htm");
		
		
	}
	

}
