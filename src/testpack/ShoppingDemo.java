package testpack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppingDemo {

	public static void main(String[] args) {
		
		String itemName = "Cucumber";
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		// 
		
		List<WebElement> productName = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<productName.size();i++)
		{
			//System.out.println(productName.get(i).getText());
			
			if(productName.get(i).getText().contains(itemName))
			{
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				
			}
		}

	}

}
