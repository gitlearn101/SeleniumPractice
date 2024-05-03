/*
 𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐟𝐞𝐭𝐜𝐡 𝐚𝐧𝐝 𝐯𝐞𝐫𝐢𝐟𝐲 - 𝐭𝐡𝐞 𝐩𝐫𝐨𝐝𝐮𝐜𝐭 -𝐩𝐫𝐢𝐜𝐞 𝐬𝐨𝐫𝐭𝐢𝐧𝐠 𝐟𝐫𝐨𝐦 𝐥𝐨𝐰 𝐭𝐨 𝐡𝐢𝐠𝐡.

𝐒𝐭𝐞𝐩𝐬:
1)Navigate to: https://lnkd.in/dhzzVRMM
2)Click on "Mega Menu" on the menu bar then click on "Apple" submenu
3)Print the number of Products listed on the page.
4)Fetch the Product name and price of the products on the page.
5)Sort the Product with its price from low to high and print it.
 */

package seleniumcoding50dayschallenge;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day22_ecommPriceList {
	
	private static WebDriver driver;
	public String productList,price = null;
    ArrayList<Map<String, String>> productListSort = new ArrayList<>();
	
	@BeforeTest
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	//@AfterTest
	public void teardown() {
		driver.quit();
	}
	

	@Test
	public void run() {
		
		driver.get("https://ecommerce-playground.lambdatest.io/");
		
		driver.findElement(By.xpath("//a[normalize-space()='Shop by Category']")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='Desktops and Monitors']")).click();
		
		getAllProductNames();
		
		sortProductListByPrice();
		
	}

	private void sortProductListByPrice() {
		
		// inner anonymous
		Collections.sort(productListSort, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                double price1 = Double.parseDouble(o1.get("productPrice").replace(",", "").replace("$", ""));
                double price2 = Double.parseDouble(o2.get("productPrice").replace(",", "").replace("$", ""));
                return Double.compare(price1, price2);
            }
        });
		
		
		// Print sorted product list
        System.out.println("##################################################");
        System.out.println("Sorted Product List:");
        for (Map<String, String> product : productListSort) {
            System.out.println("Product: " + product.get("productName") + ", Price: " + product.get("productPrice"));
        }
		
	}

	private void getAllProductNames() {
		List<WebElement> productNames = driver.findElements(By.xpath("//h4[@class='title']/a[contains(@class,'text-ellipsis')]"));
		
		 System.out.println("List before Unsorted from Low to High");
		for(WebElement productName : productNames) {
			
			String productList = productName.getText();
			
			if (productList != null && !productList.isEmpty()) 
			{
			//System.out.println("product name >> "+ productList);
			 price = driver.findElement(By.xpath("(//h4[@class='title']//a[text()='" + productList + "'])/following::span[@class='price-new']"))
                     .getText();
			//System.out.println(price);
			}
			
			System.out.println("Product name is " + productList + " and price is " + price);
			
			Map<String, String> productDetails = new HashMap<>();
			productDetails.put("productName", productList);
			productDetails.put("productPrice", price);
			
			productListSort.add(productDetails);
			
		}
		
	}
	
	
}
