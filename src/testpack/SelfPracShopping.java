package testpack;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelfPracShopping {

	public static void main(String[] args) throws InterruptedException {

		String[] toBuy = { "Brocolli", "Cucumber", "Potato", "Pumpkin" };
		int buycount = toBuy.length;
		int counter = 0;

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(5000);

		// div[@class='product-action']/button >> xpath for 'add to cart'
		// h4.product-name >> product name

		List myShoppingList = Arrays.asList(toBuy);

		List<WebElement> itemInPortal = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < itemInPortal.size(); i++) {

			String[] itemAvailable = itemInPortal.get(i).getText().split("-");
			String formattedItemAvailable = itemAvailable[0].trim();

			if (myShoppingList.contains(formattedItemAvailable))

			{
				counter++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (counter == buycount) // to make sure that we optimise the browse through all product list of portal.
											// If our requiremen is met then no need to browse through whole portal
				{
					break;
				}

			}

		}

	}

}
