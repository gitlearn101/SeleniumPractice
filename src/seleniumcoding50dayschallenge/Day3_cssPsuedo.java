// css Psuedo element
// https://www.linkedin.com/posts/kushalparikh11_50daysofcodechallenge-selenium-activity-7168568033995702272-37Wy/?utm_source=share&utm_medium=member_desktop

package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

		

	}

}
