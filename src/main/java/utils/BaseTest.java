package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MenuPage;
import pages.ShopPage;
import pages.TheWickedKingBookPage;

public class BaseTest {
	
	public static WebDriver driver;
	public MenuPage menu;
	public BasePage app;
	public ShopPage shop;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		Log.info("Start ChromeBrowser");
		driver = WebDriverManager.chromedriver().create();
	    Log.info("maximize chrome browser");
		
		driver.get("https://keybooks.ro");
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		menu = new MenuPage(driver);
		app = new BasePage();
		shop = new ShopPage(driver);
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.quit();
	}
	
	@AfterMethod
	
	public void recordFailure(ITestResult result) {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			
			TakesScreenshot poza = (TakesScreenshot) driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			try {
				Files.copy(picture, new File("screenshots/"+result.getName()+"-"+ timeStamp+ ".png"));
				System.out.println("Picture saved");
			} catch (IOException e) {
				System.out.println("Picture could not be saved");
				e.printStackTrace();
			}
			
		}
		
	}

}
