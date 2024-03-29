/*𝐓𝐞𝐬𝐭 𝐒𝐜𝐞𝐧𝐚𝐫𝐢𝐨:

𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐯𝐞𝐫𝐢𝐟𝐲 𝐛𝐮𝐭𝐭𝐨𝐧 𝐢𝐬 𝐯𝐢𝐬𝐢𝐛𝐥𝐞 𝐨𝐧 𝐬𝐜𝐫𝐨𝐥𝐥 𝐚𝐧𝐝 𝐮𝐬𝐞𝐫 𝐧𝐞𝐞𝐝 𝐭𝐨 𝐜𝐥𝐢𝐜𝐤 𝐨𝐧 𝐭𝐡𝐚𝐭 𝐛𝐮𝐭𝐭𝐨𝐧.

𝐒𝐭𝐞𝐩𝐬:
1)Navigate to: https://lnkd.in/dRA3mQgh
2)Click on the "YOU FOUND ME!" button.
4)Verify that the "Mission accomplished" message after clicking on the button.*/

package seleniumcoding50dayschallenge;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Day18_Scrollbar {

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

	// @AfterTest
	void teardown() {
		driver.quit();
	}

	@Test
	void testOne() throws InterruptedException, IOException {

		driver.get("https://qaplayground.dev/apps/covered/#");

		WebElement findMeBtn = driver.findElement(By.id("fugitive"));

		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// scroll into view
		jse.executeScript("document.getElementById('fugitive').scrollIntoView(true)");

		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(findMeBtn));

		// click on the btn
		findMeBtn.click();

		String actualText = driver.findElement(By.id("info")).getText();

		Assert.assertEquals(actualText, "Mission accomplished");
	}

}
