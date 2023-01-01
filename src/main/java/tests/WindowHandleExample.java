package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class WindowHandleExample extends BaseTest {
	
	@Test
	public void windowHandleTest() throws InterruptedException {
		app.menu.navigateTo(app.menu.eventsLink);
		app.events.click(app.events.festivalOfOldFilmsLink);
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 800).perform();
		
		System.out.println("Current "+ driver.getWindowHandle());
		
		app.genericEvent.clickMap();
		
		System.out.println("All " + driver.getWindowHandles());
		
		Thread.sleep(3000);
		
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		
    	driver.findElement(By.xpath("//span[contains(text(), 'Accept all')]")).click();
		
		driver.close();
		
		Thread.sleep(3000);
		
		driver.switchTo().window(browserTabs.get(0));
		
		app.genericEvent.clickMap();
	}

}
