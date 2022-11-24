package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;

	@BeforeClass
	public void setup() {
		
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://keybooks.ro");
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	@AfterClass
	
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.quit();
	}

}
