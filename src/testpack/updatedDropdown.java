package testpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class updatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		
		int timeClick = 4; // how many times to click to increase adult count

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		for(int i=1;i<timeClick;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();   // click + icon to increase count	
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
		// validation count of Adult
		System.out.println("Nos of Adults ::"+driver.findElement(By.id("divpaxinfo")).getText());
		driver.quit();
	}

}
