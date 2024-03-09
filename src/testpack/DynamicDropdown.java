package testpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// int timeClick = 4; // how many times to click to increase adult count

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // open the To dropdown box
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();   //Stable xpath >> //div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // Stable xpath >>> //div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']
		
		
		

	}

}
