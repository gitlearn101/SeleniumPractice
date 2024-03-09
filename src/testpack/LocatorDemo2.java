package testpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorDemo2 {

	public static void main(String[] args) throws InterruptedException {

		String name = "hello";

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// calling getPassword() method
		String password = getPassword(driver);

		driver.get("https://rahulshettyacademy.com/locatorspractice");

		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();

		Thread.sleep(2000);

		String msg = driver.findElement(By.tagName("p")).getText();
		System.out.println("The message in the home screen is ::" + msg);

		Assert.assertEquals(msg, "You are successfully logged in."); // Assert 1

		// Assert 2
		String LabelMsg = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertEquals(LabelMsg, "Hello " + name + ",");

		driver.findElement(By.xpath("//button[text()='Log Out']")).click();

		driver.quit();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice");

		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

		String textPwd = driver.findElement(By.cssSelector("form p")).getText(); // The text are : Please use temporary
																					// password 'rahulshettyacademy' to
																					// Login.

		String[] passwordArray = textPwd.split("'"); // passwordArray[0] > Please use temporary password '
														// passwordArray[1] > rahulshettyacademy' to Login.

		String finalPassword = passwordArray[1].split("'")[0]; // 0th index > rahulshettyacademy
																// 1th index > ' to Login.

		return finalPassword;

	}

}
