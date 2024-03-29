/*𝐓𝐞𝐬𝐭 𝐒𝐜𝐞𝐧𝐚𝐫𝐢𝐨:

𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐯𝐞𝐫𝐢𝐟𝐲 - 𝐬𝐞𝐭 𝐞𝐚𝐜𝐡 𝐚𝐯𝐚𝐢𝐥𝐚𝐛𝐥𝐞 𝐫𝐚𝐭𝐞 𝐯𝐚𝐥𝐮𝐞 𝐚𝐧𝐝 𝐚𝐬𝐬𝐞𝐫𝐭 𝐛𝐲 𝐢𝐦𝐚𝐠𝐞, 𝐭𝐞𝐱𝐭, 𝐚𝐧𝐝 𝐧𝐮𝐦𝐛𝐞𝐫

𝐒𝐭𝐞𝐩𝐬:
1)Navigate to: https://lnkd.in/dgNMwyt9
2)Click on the set of each available rate value and assert by image, text, and number.
4)Verify that the Emoji image, the text message e.g-"I don't like it" and the number out of 5 e.g- "2 out of 5". Verify for all the 5 ratings. */


package seleniumcoding50dayschallenge;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day19_Emoji {
	
public static WebDriver driver;
	

	@BeforeTest
	void setup() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	//@AfterTest
	void teardown() {
		driver.quit();
	}

	
	@Test
	void testOne() throws InterruptedException, IOException {
		
		driver.get("https://qaplayground.dev/apps/rating/");
		
		
		
		
		
	}
		

	

}
