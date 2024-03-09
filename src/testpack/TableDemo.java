package testpack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Using javascript to perform scrolling ops
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);

		// scroll internal table
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		
		// Map 'Amount' column of the 'web table fixed header'
		List<WebElement> val =  driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		
		for(int i=0;i<val.size();i++)
		{
			  // convert string to int
			//System.out.println(Integer.parseInt(val.get(i).getText()));
			
			sum += Integer.parseInt(val.get(i).getText());
			
			
			
		}
		System.out.println(sum);
		
		//String uiText= driver.findElement(By.cssSelector("div.totalAmount")).getText();
		
		// convert from string to int
		int uiTotal = Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
		System.out.println("UI is ::"+uiTotal);
		
		Assert.assertEquals(sum, uiTotal);
		
		
	
	}

}
