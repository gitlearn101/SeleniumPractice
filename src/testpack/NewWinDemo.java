package testpack;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWinDemo {

	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// Selenium will open a blank tab
		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> winHandles = driver.getWindowHandles();

		Iterator<String> it = winHandles.iterator();

		String parentWinID = it.next();
		String childWinID = it.next();

		// pass driver control to new tab and provide url
		driver.switchTo().window(childWinID);
		driver.get("https://rahulshettyacademy.com/");

		String courseName = driver.findElements(By.cssSelector("[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();

		// pass driver control to parent window
		driver.switchTo().window(parentWinID);

		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);

	}

}
