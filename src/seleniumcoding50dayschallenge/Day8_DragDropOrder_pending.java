// https://www.linkedin.com/posts/kushalparikh11_50daysofcodechallenge-selenium-activity-7171837153272807424-hLhj/?utm_source=share&utm_medium=member_desktop#

package seleniumcoding50dayschallenge;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day8_DragDropOrder_pending {

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

	 //@AfterTest
	void teardown() {
		driver.quit();
	}

	@Test
	public void demo() throws AWTException, InterruptedException {
		
		driver.get("https://qaplayground.dev/apps/sortable-list/");
		
		List<String> expectedOrder = new ArrayList<>(Arrays.asList("Jeff Bezos","Bill Gates","Warren Buffett","Bernard Arnault", "Carlos Slim Helu", "Amancio Ortega", "Larry Ellison", "Mark Zuckerberg", "Michael Bloomberg", "Larry Page"));
		
		for(int i=0;i<expectedOrder.size();i++) {
			
			List<WebElement> actualOrderEle = driver.findElements(By.xpath("//ul[@class='draggable-list']/li//p"));
			
			List<String> actualOrder = new ArrayList<>();
			
			for(WebElement e: actualOrderEle) {
				actualOrder.add(e.getText());
			}
		
			// Actions class operation
			Actions act = new Actions(driver);
			
			if(! expectedOrder.get(i).equals((actualOrder).get(i))){
				
				int index = actualOrder.indexOf(actualOrder.get(i));
				
				String temp = actualOrder.get(i);
				
				actualOrder.set(i, actualOrder.get(index));
				
				actualOrder.set(index, temp);
				
				Thread.sleep(1000);
				
				act.dragAndDrop(actualOrderEle.get(index), actualOrderEle.get(i)).build().perform();
				
				
			}
			
			// click on 'check' btn
			driver.findElement(By.cssSelector("button#check")).click();
	}
	}

	
}
