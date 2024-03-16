// https://www.linkedin.com/posts/kushalparikh11_50daysofcodechallenge-selenium-activity-7173333722237276160-g3qL/?utm_source=share&utm_medium=member_desktop

package seleniumcoding50dayschallenge;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day11_TagInputBox {

	WebDriver driver;

	@BeforeTest
	void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	 @AfterTest
	void teardown() {
		driver.quit();
	}

	@Test
	public void demo() throws AWTException, InterruptedException {

		Faker faker = new Faker();

		driver.get("https://qaplayground.dev/apps/tags-input-box/");

		List<WebElement> initialTags = driver.findElements(By.xpath("//div[@class='content']//ul//li"));

		// Print the tags already present in the box
		System.out.println("initialTags >>");
		for (WebElement we : initialTags) {
			System.out.println(we.getText());
		}

		// Print the count of insertTags
		System.out.println("Count of initialTags >> " + initialTags.size());

		Thread.sleep(1000);

		// remove all tags
		WebElement removeAllBtn = driver.findElement(By.xpath("//button[contains(text(),'Remove All')]"));
		removeAllBtn.click();

		Robot robot = new Robot();

		// add 10 tags inside the box by using faker()

		WebElement inputBox = driver.findElement(By.xpath("//div[@class='content']/ul/input"));
		inputBox.click();

		ArrayList<Object> nameList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			nameList.add(faker.name().firstName());
			inputBox.sendKeys(nameList.get(i).toString());
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);

		}
		
		// Extract pending Tag count and assert it to 0
		 String pendingTagCountDom = driver.findElement(By.xpath("//div[@class='details']/p/span")).getText(); 
		  int pendingTag = Integer.parseInt(pendingTagCountDom);
		
		Assert.assertEquals(pendingTag, 0);
		Thread.sleep(1000);
		
		// Click removeAll btn
		removeAllBtn.click();
		
		// input alert() in inputBox
		inputBox.sendKeys("<script> alert() </script>");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
		Thread.sleep(1000);
		
		Object newTag = driver.findElement(By.xpath("//div[@class='content']/ul/li")).getAttribute("innerHTML");
		System.out.println("The last tag is >>"+newTag);
	}

}
