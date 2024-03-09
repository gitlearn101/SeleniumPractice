package testpack;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		// click on blinking text link
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		// window handling
		Set<String> windows = driver.getWindowHandles();  // [parentID,childID]
		
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		
		String childId = it.next();
		
		
		// pass driver control to child window/tab
		driver.switchTo().window(childId);
		
		// capture and display relevant text
		System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
		
		driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
		
		
		// Extract emailID from the above text
		String emailID = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println("Email :: "+emailID);
		
		
		// pass driver control to parent window
		driver.switchTo().window(parentId);
		Thread.sleep(3000);
		
		// input email id in username text box
		driver.findElement(By.id("username")).sendKeys(emailID);
		
		

	}

}
