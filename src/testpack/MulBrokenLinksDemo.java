package testpack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MulBrokenLinksDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		
		List<WebElement> sampleLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		for(WebElement x :sampleLinks)
		{
			// Step 1 - To get all urls tied up to the links using selenium
			String sampleUrl = x.getAttribute("href");
			System.out.println("URL under observation::"+sampleUrl);
			
			// Step 2 - Java method to call URL and get you status code
			HttpURLConnection conn = (HttpURLConnection) new URL(sampleUrl).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			
			// Step 3 - if status code>400 then the urls is not working
			int respCode = conn.getResponseCode();
			System.out.println("Response Code ::"+respCode);
			
			if(respCode>400)
			{
				System.out.println("The link with text "+x.getText()+" is broken with code "+respCode);
				//Assert.assertTrue(false);    // Assert will break code whenever it faces failed TC so better to go for SOft Assertion
			}
			
		}

	}

}
