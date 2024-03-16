package seleniumcoding50dayschallenge;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day9_shadow {

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
	public void demo() throws AWTException, InterruptedException, UnsupportedFlavorException, IOException {

		driver.get("http://uitestingplayground.com/shadowdom");

		// initialize getshadowroot()
		SearchContext shadowDOMContext = driver.findElement(By.tagName("guid-generator")).getShadowRoot();

		// identify gear icon and click to generate code
		shadowDOMContext.findElement(By.cssSelector(".button-generate")).click();

		// identify webelement for textbox
		WebElement element = shadowDOMContext.findElement(By.cssSelector("#editField"));

		// JSE operations to capture textbox content
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String guidValue = jse.executeScript("return arguments[0].value", element).toString();
		Thread.sleep(1000);
		System.out.println("The guid value >>" + guidValue);

		// copy the code by manually clicking on 'copy' logo
		Actions action = new Actions(driver);
		action.keyDown(element, Keys.CONTROL).sendKeys("A").sendKeys("C").keyUp(Keys.CONTROL).build().perform();

		// collect the copied value from Clipboard
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Object clipData = clipboard.getData(DataFlavor.stringFlavor);
		Thread.sleep(1000);

		// Assert whether Clipboard content is same as data captured from textbox
		Assert.assertTrue(((String) clipData).equalsIgnoreCase(guidValue));

	}

}
