// https://www.linkedin.com/posts/kushalparikh11_50daysofcodechallenge-selenium-activity-7173898153090248708-sy9C/?utm_source=share&utm_medium=member_desktop

package seleniumcoding50dayschallenge;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day12_navigateMultipleUrls {
	
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

		ArrayList<String> urls = new ArrayList<>();
		urls.add("https://www.lambdatest.com/blog/selenium-best-practices-for-web-testing/");
		urls.add("https://www.ministryoftesting.com/articles/websites-to-practice-testing");
		urls.add("https://naveenautomationlabs.com/opencart/");
		urls.add("https://demo.guru99.com/");
		
		Map<String, Integer> map = new HashMap<>();
		
		for(String url:urls) {
			Thread.sleep(500);
			driver.get(url);
			
			System.out.println("Title >> "+driver.getTitle());
			System.out.println("Url >> "+driver.getCurrentUrl());
			System.out.println("Number of links >>"+driver.findElements(By.tagName("a")).size());
			
			map.put(driver.getTitle(), driver.findElements(By.tagName("a")).size());
		}
		
		 
		 	// find largest value from map
		int maxLinkValue = Collections.max(map.values());
		
		for( Map.Entry<String, Integer> entry:map.entrySet()) {
			
			if(maxLinkValue == entry.getValue()) {
				System.out.println(entry.getKey()+ " : "+entry.getValue());
			}
			
		}
		
		//System.out.println("Max link"+maxLinkValue);
		
	}
	

}
