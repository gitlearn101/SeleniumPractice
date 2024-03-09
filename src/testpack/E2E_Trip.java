package testpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E_Trip {

	public static void main(String[] args) throws InterruptedException {

		int timeClick = 4; // how many times to click to increase adult count for 'passengers' dropdown

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");

		
		/** Operate on 'passengers' dropdown **/
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);

		for (int i = 1; i < timeClick; i++) {
			driver.findElement(By.id("hrefIncAdt")).click(); // click + icon to increase count of passengers
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		// validation count of Adult passengers
		System.out.println("Nos of Adults ::" + driver.findElement(By.id("divpaxinfo")).getText());

		// to verify if checkbox is selected - before clicking
		// System.out.println("The Sr citizen box is selected::"+driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // This assert is expecting false
																													

		/** click on sr citizen checkbox **/
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click(); // regular exp using css selector
																							

		// to verify if checkbox is selected - after clicking
		// System.out.println("The Sr citizen box is selected::"+driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // This assert is expecting true
																													

		System.out.println("The size of checkbox in the home screen :: " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		
		/** Operate on 'From' **/
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // open the To dropdown box

		driver.findElement(By.xpath("//a[@value='BLR']")).click(); // Stable xpath >> //div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']
		Thread.sleep(1000);

		/** Operate on 'From' **/
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // Stable xpath >>> //div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']

		
		/** Calendar - Depart date **/
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click(); // always select the current date
		
		/** Calendar - Return date **/
		
		
		System.out.println("Date picker of return date is enabled/disabled? ::"+driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());  // The answer should be False but it is displaying True as Selenium is not able to handle this particular disabled webelement in graceful manner.
		
		// The workaround to above problem
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));  // display style attribute before clicking on 'round trip' radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();			// click on radio button of 'round trip'
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));  // display style attribute After clicking on 'round trip' radio button
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Date picker of Return trip is enabled");
		}
		else
		{
			System.out.println("Date picker of Return trip is DISABLED");
		}
		
		// Click on 'round trip' radio button
		driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_0")).click();
		Thread.sleep(1000);
		
		// Click on 'search'
		driver.findElement(By.cssSelector("input#ctl00_mainContent_btn_FindFlights")).click();
		
	}

}
