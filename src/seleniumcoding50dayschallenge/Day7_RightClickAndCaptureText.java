// https://www.linkedin.com/feed/update/urn:li:activity:7171153320760229888/?updateEntityUrn=urn%3Ali%3Afs_updateV2%3A%28urn%3Ali%3Aactivity%3A7171153320760229888%2CFEED_DETAIL%2CEMPTY%2CDEFAULT%2Cfalse%29

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

public class Day7_RightClickAndCaptureText {

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

	// @AfterTest
	void teardown() {
		driver.quit();
	}

	@Test
	public void demo() {

		driver.get("https://qaplayground.dev/apps/context-menu/");

		WebElement textUI = driver.findElement(By.xpath("//*[contains(text(),'Open')]"));
		WebElement shareUI = driver.findElement(By.xpath("//*[contains(text(),'Share')]"));
		WebElement al = driver.findElement(By.xpath("//ul[@class='share-menu']/li"));

		Actions action = new Actions(driver);
		action.contextClick(textUI).build().perform();

		action.moveToElement(shareUI).build().perform();

		al.click();

		String actualMsg = driver.findElement(By.xpath("//p[contains(text(),'Menu item Twitter clicked')]")).getText();

		Assert.assertEquals(actualMsg, "Menu item Twitter clicked");

	}

}
