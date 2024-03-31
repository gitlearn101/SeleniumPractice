// Will complete the code once 3rd party bar code reader API is stable

/*
 𝐒𝐭𝐞𝐩𝐬:
1)Navigate to: https://lnkd.in/d2RbkjbV
2)Enter the text "I am an Automation QA" in the input field.
3)Click on the "Generate QR Code" button.
4)Now you can try to fetch the embedded text from the QR Code generated.
5)Verify that your fetched-embedded text from QR is the same as you have given the input text.
  
  
 */

package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day20_ReadTextFromQR {
	
	public static WebDriver driver;
	public static String inputText = "I am an Automation QA";
	public static WebElement qrCode = driver.findElement(By.xpath("//img[@alt='qr-code']"));

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
	public void EmojiRating() throws InterruptedException {
		
		driver.get("https://qaplayground.dev/apps/qr-code-generator/");
		
		//input text & click btn
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(inputText);
		driver.findElement(By.xpath("//button[contains(text(),'Generate QR Code')]")).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(qrCode));
		
		// Will complete the code once 3rd party bar code reader API is stable
		
	}
		


}
