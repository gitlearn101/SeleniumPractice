/* Day-14 𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐯𝐚𝐥𝐢𝐝𝐚𝐭𝐞𝐬 𝐟𝐨𝐥𝐥𝐨𝐰𝐢𝐧𝐠 𝐭𝐰𝐨 𝐭𝐞𝐬𝐭 𝐜𝐚𝐬𝐞𝐬:

        ✅𝐓𝐞𝐬𝐭 𝐂𝐚𝐬𝐞 1: 𝐕𝐞𝐫𝐢𝐟𝐲 𝐅𝐥𝐢𝐠𝐡𝐭 𝐑𝐞𝐬𝐮𝐥𝐭𝐬 𝐒𝐞𝐚𝐫𝐜𝐡

        𝐒𝐭𝐞𝐩𝐬:
        -Open the JetBlue website - https://www.jetblue.com/.
        -Enter "Mumbai" in the departure city field and select it from the dynamic list.
        -Enter "London-Heathrow, UK (LHR)" in the destination city field and select it from the dynamic list.
        -Enter the departure date as "03/19/2024" in the date picker.
        -Enter the return date as "03/20/2024" in the date picker.
        -Click on the "Search flights" button.
        -Verify that the results for the flights are displayed or not.

        ✅𝐓𝐞𝐬𝐭 𝐂𝐚𝐬𝐞 2: 𝐕𝐞𝐫𝐢𝐟𝐲 𝐅𝐚𝐢𝐥𝐞𝐝 𝐅𝐥𝐢𝐠𝐡𝐭 𝐒𝐞𝐚𝐫𝐜𝐡

        𝐒𝐭𝐞𝐩𝐬:
        -Open the JetBlue website - https://www.jetblue.com/.
        -Enter "Mumbai" in the departure city field and select it from the dynamic list.
        -Enter "London-Heathrow, UK (LHR)" in the destination city field and select it from the dynamic list.
        -Enter the departure date as "01/01/2024" in the date picker.
        -Enter the return date as "01/01/2024" in the date picker.
        -Click on the "Search flights" button.
        -Verify and capture the validation msg.

        𝐍𝐨𝐭𝐞: Use TestNG and execute test cases one by one using priority and the browser should be launched only once. Here date format MM/DD/YYYY is applicable. */




package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day14_Pending_FlightCalendar {
	
	public static WebDriver driver;
	
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
	
	@Test(priority = 1)
	void testOne() throws InterruptedException {
		
		driver.get("https://www.jetblue.com/");
		
		
		// handle consent popup
		try {
		driver.switchTo().frame(1);
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Accept All Cookies']")));
		
		driver.findElement(By.xpath("//a[normalize-space()='Accept All Cookies']")).click();
		driver.switchTo().defaultContent();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//Thread.sleep(5000);
		// input Mumbai in from Airport
		//driver.findElement(By.xpath("//dot-city-selector[@data-qaid='fromAirport']//jb-autocomplete//div[@class='flex items-start active-border ng-star-inserted']")).click();
		//driver.findElement(By.xpath("//dot-city-selector[@data-qaid='fromAirport']")).clear();
		//driver.findElement(By.xpath("//dot-city-selector[@data-qaid='fromAirport']//jb-autocomplete//div[@class='flex items-start active-border ng-star-inserted']")).sendKeys("M");
		
		
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@id,'jb-autocomplete')])[1]")));
        driver.findElement(By.xpath("(//input[contains(@id,'jb-autocomplete')])[1]")).click();
        driver.findElement(By.xpath("(//input[contains(@id,'jb-autocomplete')])[1]")).sendKeys("Mumbai");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Mumbai')]")));
        driver.findElement(By.xpath("//strong[contains(text(),'Mumbai')]")).click();
		
	}

}
