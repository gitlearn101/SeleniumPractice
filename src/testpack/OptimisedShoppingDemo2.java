package testpack;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptimisedShoppingDemo2 {

	public static void main(String[] args) throws InterruptedException {

		String[] myShopping = { "Brocolli", "Cucumber", "Potato", "Pumpkin" };
		// int j = 0; // j is variable to track count of myShopping

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		// explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(5000);

		// calling method
		addItems(driver, myShopping);

		// checkout cart
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		// driver.findElement(By.cssSelector("//div[@class='cart-preview
		// active']/div[2]/button")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		// explicit wait till promotext is visible
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		// add promocode
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		// click on apply promo btn
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		// explcit wait till promo text is ready
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		// grab text of promo
		String promoTxt = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		System.out.println("Promo Text :" + promoTxt);

	}

	public static void addItems(WebDriver driver, String[] myShopping) {
		int j = 0;
		List<WebElement> productNameInWebsite = driver.findElements(By.cssSelector("h4.product-name"));

		List myShoppingList = Arrays.asList(myShopping);

		for (int i = 0; i < productNameInWebsite.size(); i++) {

			// Actual product name in website in Brocolli - 1 kg , so we need to split and
			// trim to extract actual veg name

			String[] productAvailableInSite = productNameInWebsite.get(i).getText().split("-");
			String formattedproductAvailableInSite = productAvailableInSite[0].trim();

			if (myShoppingList.contains(formattedproductAvailableInSite)) {
				j++;
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click(); // 'ADD TO CART' text as locator is unreliable
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == myShopping.length) // instead of j==3
				{
					break; // as soon as all shoppingList is accounted for then the break is executed
				}

			}

		}

	}

}
