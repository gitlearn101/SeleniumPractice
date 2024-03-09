package testpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorDemo3 {

	public static void main(String[] args) {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// sibling-parent traverse
		
		
		// following sibling
		String btnName=driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText(); // finding 'Login' button with the help of 'Practice' Button
		System.out.println(btnName);
		
		
		// going from child to parent and then to another child
		String anotherBtnName = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[3]")).getText();
		System.out.println(anotherBtnName);
		driver.quit();
	}

}
