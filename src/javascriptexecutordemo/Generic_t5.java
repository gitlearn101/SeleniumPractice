
// gettitle
// getURL
// Enter value in textbox
// calendar 
// page refresh
// input into disabledTextBox

package javascriptexecutordemo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Generic_t5 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void demoTitle() throws InterruptedException, IOException {

		driver.get("https://tutorialsninja.com/demo/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		String title = jse.executeScript("return document.title").toString(); // highlight element with red border
		Thread.sleep(1000);
		System.out.println("The title >> " + title);

	}

	@Test(priority = 2)
	public void demoUrl() throws InterruptedException, IOException {

		driver.get("https://tutorialsninja.com/demo/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		String url = jse.executeScript("return document.URL").toString(); // highlight element with red border
		Thread.sleep(1000);
		System.out.println("The URL >> " + url);

	}

	@Test(priority = 3)
	public void demoPostValue() throws InterruptedException, IOException {

		driver.get("https://tutorialsninja.com/demo/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement searchbtn = driver.findElement(By.xpath("//span[@class='input-group-btn']/button"));

		jse.executeScript("document.getElementsByName('search')[0].value='Monitor'");
		jse.executeScript("arguments[0].click()", searchbtn);
		Thread.sleep(1000);

	}

	@Test(priority = 4)
	public void demoCalendar() throws InterruptedException, IOException {

		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement calendar = driver.findElement(By.id("datepicker"));

		String dateSample = "02/02/2022";

		jse.executeScript("arguments[0].value='" + dateSample + "'", calendar);
		Thread.sleep(1000);


	}

	@Test(priority = 5)
	public void demoPageRefresh() throws InterruptedException, IOException {

		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("history.go(0)");
		Thread.sleep(1000);

	}
	
	@Test(priority = 6)
	public void demoInputIntoDisabledTextbox() throws InterruptedException, IOException {

		driver.get("https://omayo.blogspot.com/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement disabledTextbox = driver.findElement(By.id("tb2"));

		jse.executeScript("arguments[0].value='i am in disabled box'",disabledTextbox);
		Thread.sleep(1000);

	}

}
