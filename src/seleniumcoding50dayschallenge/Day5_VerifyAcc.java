// https://www.linkedin.com/posts/kushalparikh11_50daysofcodechallenge-selenium-activity-7170427088225648641-QQ6u/?utm_source=share&utm_medium=member_desktop

package seleniumcoding50dayschallenge;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Day5_VerifyAcc {
	
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

	 @AfterTest
	void teardown() {
		driver.quit();
	}

	@Test
	void demo() throws AWTException, InterruptedException {

		driver.get("https://qaplayground.dev/apps/verify-account/");
		
		List<WebElement> numberZone = driver.findElements(By.xpath("//input[@type='number']"));
		
		Robot robot = new Robot();
		
		for(WebElement num : numberZone) {
			Thread.sleep(500);
			num.click();
			
			robot.keyPress(KeyEvent.VK_9);
			robot.keyRelease(KeyEvent.VK_9);
			
		}
		
		Thread.sleep(1000);
		
		
		//Validated the success msg
		WebElement sucessMsg = driver.findElement(By.xpath("//small[text()='Success']"));
		if(sucessMsg.isDisplayed() == true) {
		System.out.println("Validated the success msg");
		} else {
		Assert.fail("Not Able to see the success msg");
		}
		
		
		
	}

	


}
