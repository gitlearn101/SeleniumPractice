package testpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameDemo {

	public static void main(String[] args) {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/droppable");
		
		// Get count of frame
		System.out.println("Nos of frames ::"+driver.findElements(By.tagName("iframe")).size());
		
		// move driver control to frame using webelement as arg
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		// alternate option to switch to a frame using index as arg
		driver.switchTo().frame(0); 
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		// drag and drop ops
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();

	}

}
