package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import utils.BaseTest;
import utils.ScreenShots;

public class ScreenShotTest extends BaseTest{
	
	@Test
	public void screenshotTest() {
		try {
		app.menu.navigateTo(app.menu.shopLink);
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shoplink/");
	}catch (Exception e) {
		ScreenShots sc = new ScreenShots();
		sc.screenshot(driver);
	   }
	}
	
}
