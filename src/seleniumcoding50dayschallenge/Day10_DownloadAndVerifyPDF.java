// https://www.linkedin.com/posts/kushalparikh11_50daysofcodechallenge-selenium-activity-7172946055939014656-DTxt/?utm_source=share&utm_medium=member_desktop#

package seleniumcoding50dayschallenge;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day10_DownloadAndVerifyPDF {

	WebDriver driver;

	@Test
	public void demo() throws IOException, InterruptedException {

		final String downloadDirectory = System.getProperty("user.dir") + "\\Downloads";

		cleanDownloadDirectory(downloadDirectory);

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("download.default_directory", downloadDirectory);

		options.setExperimentalOption("prefs", chromePrefs);

		options.addArguments("--disable-extensions");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-setuid-sandbox");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-default-apps");
		options.addArguments("--mute-audio");
		options.addArguments("--blink-settings=imageEnabled=false");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.automationtesting.in/FileDownload.html");

		WebElement downloadBtn = driver.findElement(By.xpath("//a[@type='button']"));

		// Bring the button into the view
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", downloadBtn);
		Thread.sleep(1000);

		// click the download button
		downloadBtn.click();
		Thread.sleep(2000);

		String file = downloadDirectory + "\\samplefile.pdf";

		getFileSizeAndName(new File(file));
		readContent(new File(file));

	}

	private void cleanDownloadDirectory(String downloadDirectory) throws IOException {

		File dir = new File(downloadDirectory);

		if (dir.exists() && dir.isDirectory()) {
			FileUtils.cleanDirectory(dir);
		}

	}

	private void readContent(File file) throws IOException {
		PDDocument document = Loader.loadPDF(file);
		PDFTextStripper stripper = new PDFTextStripper();

		String pdfText = stripper.getText(document);

		if (pdfText.equals("Get Tickets")) {
			System.out.println("Found");
		} else {
			System.out.println("not found");
		}

	}

	private void getFileSizeAndName(File file) {

		long fileSize = FileUtils.sizeOf(file);

		String fileName = file.getName();

		String filePath = file.getAbsolutePath();

		System.out.println("File name >>" + fileName);
		System.out.println("File size >>" + fileSize);
		System.out.println("File path >>" + filePath);

	}

}
