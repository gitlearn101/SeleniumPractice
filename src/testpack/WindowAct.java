package testpack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowAct {

	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com"); // has internal wait method to wait till 100% loading done
		
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice"); // no wait here
		
		driver.navigate().back();
		
		driver.navigate().forward();

	}

}
