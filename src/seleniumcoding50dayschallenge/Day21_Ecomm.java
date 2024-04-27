/*

𝐒𝐭𝐞𝐩𝐬:
1)Navigate to: https://lnkd.in/dF9UMUD4
2)Create a Customer with valid info.
3)Sign in with the customer credentials you created.
4)Take Any product and add it to the cart. 
5)Verify that the product name, product type, product description(if it exists) & size are the same as you selected.
6) Proceed to checkout and Verify its billing details & its price calculated at billing.

*/

package seleniumcoding50dayschallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day21_Ecomm {

	public static WebDriver driver;
	public static String loginEmail = "pamami8135@dacgu.com";
	public static String password = "Name@123";
	
	public static String sizeOptions="XS";
	public static String colorOptions="Gray";
 
	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	//@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	@Test
	public void demo() throws InterruptedException {
		
		driver.get("https://magento.softwaretestingboard.com/");
		
		
		/* Bypass for testing purpose
		// create account
		driver.findElement(By.linkText("Create an Account")).click();
		
		driver.findElement(By.cssSelector("input#firstname")).sendKeys("firstName");
		driver.findElement(By.cssSelector("input#lastname")).sendKeys("lastName");
		driver.findElement(By.cssSelector("input#email_address")).sendKeys(loginEmail);
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
		
		String passwordStrengthMeter = driver.findElement(By.cssSelector("span#password-strength-meter-label")).getText();
		
		System.out.println("passwordStrengthMeter >> "+passwordStrengthMeter);
		
		driver.findElement(By.cssSelector("input#password-confirmation")).sendKeys("Name@123");
		
		driver.findElement(By.cssSelector("button[title = 'Create an Account']")).click();
		
		// Validate success of Account creation
		String accountDetails = driver.findElement(By.xpath("//div[@class='box box-information']//div[@class='box-content']")).getText();
		System.out.println(accountDetails);
		
		// logout
		driver.findElement(By.xpath("//div[@class='panel header']//li[@class='customer-welcome']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='panel header']//li[@class='customer-welcome active']//div//ul//li[3]")).click();
		
		// wait till landing page is loaded
		//new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.)
		*/
		// sign in
		driver.findElement(By.linkText("Sign In")).click();
		
		driver.findElement(By.cssSelector("input#email")).sendKeys(loginEmail);
		driver.findElement(By.xpath("//form/fieldset/div[3]/div/input")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@class='action login primary']")).click();
		
		// click on Men tab
		driver.findElement(By.xpath("//li[contains(@class, 'nav-3') and contains(@class, 'level0')]")).click();
		
		// Hover to first image & Click 'Add to Cart' to the first picure
		WebElement firstImg= driver.findElement(By.xpath("//div[contains(@class, 'block-products-list')]//li[1]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(firstImg).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class, 'block-products-list')]//li[1]//button[@title='Add to Cart']")).click();
		
		driver.findElement(By.cssSelector("#product-addtocart-button")).click();
		
		// select size & color
		
		driver.findElement(By.xpath("//div[contains(@option-label, '"+sizeOptions+"')]")).click();
		
		driver.findElement(By.xpath("//div[contains(@option-label, '"+colorOptions+"')]")).click();
		
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(500);
		// go to cart screen
		WebElement cart= driver.findElement(By.xpath("//a[contains(@class, 'action showcart')]"));
		
		cart.click();
		
		Thread.sleep(500);
		
		String qtyIncart = driver.findElement(By.xpath("//div[contains(@class, 'block-minicart')]//ol[@class='minicart-items']//div[@class='details-qty qty']//input")).getAttribute("data-item-qty");
	
		int qtyInCart = Integer.parseInt(qtyIncart);
		
		Assert.assertEquals(qtyInCart, 10);
		
	}

}
