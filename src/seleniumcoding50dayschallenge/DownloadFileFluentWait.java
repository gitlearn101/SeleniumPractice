//Employ FluentWait to monitor the file system, allowing your script to wait until the downloaded file is fully available at the specified path.
 


package seleniumcoding50dayschallenge;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.timeout.TimeoutException;

public class DownloadFileFluentWait {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized"); // maximize browser
		
		driver = new ChromeDriver(options);
	}
	
	//@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	@Test
	public void runDemo() {
		
		driver.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");
		
		String downloadPath = "v:\\yyyy\\xxx\\Downloads"; // Add own path
		
		String fileName = "jenkins.msi";
		
		File file = new File(downloadPath, fileName);
		
		FluentWait<File> wait = new FluentWait<>(file)
								.withTimeout(Duration.ofMinutes(5))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(Exception.class)
								.withMessage("--- File not downloaded ---");
		
		
		
		try {
		Boolean isDownloaded = wait.until(f -> f.exists() && f.canRead());
		
		if(isDownloaded) {
			System.out.println("File is 100% downloaded");
		}
		}catch(TimeoutException e) {
			System.out.println("**** file is not completely downloaded ****");
		}
		
		
	}
	
	

}
