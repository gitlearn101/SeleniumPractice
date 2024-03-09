package testpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDropdown {

	public static void main(String[] args) {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/"); 
		
		WebElement currencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select staticDropdown = new Select(currencyDropdown);
		
		staticDropdown.selectByIndex(3);
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		
		staticDropdown.selectByValue("AED");
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		
		staticDropdown.selectByVisibleText("INR");
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		
		

	}

}
