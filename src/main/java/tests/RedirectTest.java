package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import utils.BaseTest;

public class RedirectTest extends BaseTest {
	
	@Test
	public void socialMediaRedirect() throws InterruptedException {
		
		menu.click(menu.facebook);
		
		Thread.sleep(3000);
		
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		
		driver.close();
		
		driver.switchTo().window(browserTabs.get(0));
		
		Thread.sleep(3000);
		
		menu.click(menu.twitter);
		
	    Thread.sleep(3000);
	    
	    driver.getWindowHandle();

		driver.switchTo().window(browserTabs.get(1));
		
		driver.close();
		
		driver.switchTo().window(browserTabs.get(0));
		
		Thread.sleep(3000);
		
		menu.click(menu.instagram);
		
        driver.switchTo().window(browserTabs.get(1));
		
		driver.close();
		
		driver.switchTo().window(browserTabs.get(0));
		
	}

}
