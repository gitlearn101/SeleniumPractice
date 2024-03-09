package testpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		
		
		/** Input credential and try forget password flow **/
		
		//driver.findElement(By.id("inputUsername")).sendKeys("sampleUser");
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("hello");		// alternatively using css selector for username box
		
		driver.findElement(By.name("inputPassword")).sendKeys("Pass@123");
		//driver.findElement(By.cssSelector("input")).sendKeys("Pass@123");
		
		//driver.findElement(By.className("submit")).click();
		driver.findElement(By.cssSelector("button.submit")).click();					// alternatively using css selector for signin button
		
		//read the error message
		System.out.println("Error message::"+driver.findElement(By.cssSelector("p.error")).getText());
		
		// Click on 'forgot password'
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		
		// Input 'Name' for Forgot password section
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Tooop");
		
	//	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Tooop@rsa.com");
		
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("top@gmail.com");		// using concept of index in css selector
		
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9876543210");
		
		//driver.findElement(By.xpath("//form/input[3]")).click();					// using parent-child transversal for Xpath
		
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		String textPwd=driver.findElement(By.cssSelector("form p")).getText();		// using parent-child transversal for CSS
		System.out.println("Reset password said:"+textPwd);
		
		// Click on 'go to login' button in 'forget password' form
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		
		/** Input credential and login**/
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("BUH");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");				// Using regular expression for css selector
		
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();							// Regular expression for xpath
		
		
		
	}

}
