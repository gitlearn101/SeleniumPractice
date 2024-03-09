package testpack;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// 1. Find the count of links

		System.out.println("The counnt of links::" + driver.findElements(By.tagName("a")).size());

		// 2. count links only for footer section - concept of Scope
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("The links count for footer section::" + footerDriver.findElements(By.tagName("a")).size());

		// 3. count of links in 1st column of footer section
		WebElement columndriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("The count of link in 1st column of footer section::"
				+ columndriver.findElements(By.tagName("a")).size());

		// 4. click on each links of the 1st column and check if the page is loading
		// 5. Grab url text of each opened tabs

		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER); // Open links in new tabs

			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(5000);
		} // open all tabs

		// window handling ops
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println("The tab name is ::" + driver.getTitle());
		}

	}

}
