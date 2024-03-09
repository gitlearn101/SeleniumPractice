// First program

package testpack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelIntro {

	public static void main(String[] args) {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/");
		
		// Display title of the page
		String title = driver.getTitle();
		System.out.println("The title of the page :"+title);
		
		// Display current url
		System.out.println(driver.getCurrentUrl());
		
		// close current window
		driver.quit();   		// avoid driver.close() as it leads connection reset error
		

	}

}
