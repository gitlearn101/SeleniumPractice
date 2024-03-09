package testpack;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LiveSortDemo {

	public static void main(String[] args) {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// CLick on column of fruit/veg name
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// Capture all webelements into list
		List<WebElement> webelements = driver.findElements(By.xpath("//tr/td[1]"));
		
		// Capture text of all webelements into new(original) list
		List<String> originalList = webelements.stream().map(s->s.getText()).collect(Collectors.toList());
		
		// Sort on the original list of step-3 -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		// Compare original Vs Sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		// Scan name column with getText->Rice-> get price of Rice
		List<String> priceItem = webelements.stream().filter(s->s.getText().contains("Almond")).map(s->getPrice(s)).collect(Collectors.toList());
		
		
		priceItem.forEach(a->System.out.println(a));
	
	}

	private static String getPrice(WebElement s) {
		
		String priceValue = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();
		
		return priceValue;
	}

	

}
