/* Day-16  𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐡𝐨𝐯𝐞𝐫 𝐨𝐧 𝐭𝐡𝐞 𝐦𝐨𝐯𝐢𝐞 𝐩𝐨𝐬𝐭𝐞𝐫 𝐚𝐧𝐝 𝐨𝐧 𝐡𝐨𝐯𝐞𝐫 𝐢𝐭 𝐬𝐡𝐨𝐮𝐥𝐝 𝐟𝐞𝐭𝐜𝐡 𝐩𝐫𝐢𝐜𝐞 𝐨𝐟 𝐢𝐭.

        𝐒𝐭𝐞𝐩𝐬:
        1)Navigate to: https://lnkd.in/dwDQbUKz
        2)Do the mouse hover on the Movie poster.
        3)Fetch the price and verify it.  */



package seleniumcoding50dayschallenge;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day16_mouseAct {
	
	
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

	@AfterTest
	void teardown() {
		driver.quit();
	}

	
	@Test
	void testOne() throws InterruptedException, IOException {
	
	driver.get("https://qaplayground.dev/apps/mouse-hover/");
	
	WebElement poster = driver.findElement(By.xpath("//img[@class='poster']"));
	
	Actions act = new Actions(driver);
	act.moveToElement(poster).build().perform();
	Thread.sleep(500);
	poster.click();
	Thread.sleep(500);
	
	String price = driver.findElement(By.xpath("//div[@class='title-container']//p[@class='current-price']")).getText();
	
	System.out.println(price);
	
	Assert.assertEquals(price, "$24.96");
	
	}
	}


