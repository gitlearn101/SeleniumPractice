// https://www.linkedin.com/posts/kushalparikh11_50daysofcodechallenge-selenium-activity-7167888545586651137-RaDO/?utm_source=share&utm_medium=member_desktop

package seleniumcoding50dayschallenge;

import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.openqa.selenium.Credentials;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1_BypassBrowserAuth {
	
	WebDriver driver;
	
	@BeforeTest
	void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	//@AfterTest
	void teardown() {
		driver.quit();
	}
	
	@Test
	void demo() {
		
		// Method 1 : using username+password append
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		// Method 2: Selenium4 BiDi >> Implementation keep changing based on Selenium version.
		/*
		String username = "admin";
		String password = "admin";
		
		Predicate<URI> uriPredicate = uri -> uri.toString().contains("herokuapp.com");
	    Supplier<Credentials> authentication = UsernameAndPassword.of("admin", "admin");

	    ((HasAuthentication) driver).register(uriPredicate, authentication);
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		*/
	}
	

}
